/*
 * @(#)ControlCriteria.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.controller;

import com.fundation.search.common.Convertor;
import com.fundation.search.common.SearchLogger;
import com.fundation.search.common.Validator;
import com.fundation.search.controller.builder.SearchCriteria;
import com.fundation.search.model.Search;
import com.fundation.search.model.asset.Asset;
import com.fundation.search.view.command.CommandCriteria;
import com.fundation.search.view.command.CommandView;
import com.fundation.search.view.command.SearchCommand;
import com.fundation.search.controller.builder.SearchCriteriaBuilder;

import java.nio.file.attribute.FileTime;
import java.util.logging.Logger;

/**
 * This class is made the control between CommandLine and Model.
 *
 * @author Omar Limbert Huanca sanchez - AT-[06]
 * @version 1.0.
 */
public class ControlCommand {
    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * searchCommand from Command Line.
     */
    private SearchCommand searchCommand;
    /**
     * commandCriteria from Command Line.
     */
    private CommandCriteria commandCriteria;
    /**
     * validator is the validator for valid inputs.
     */
    private Validator validator;
    /**
     * converter is the converter for valid inputs.
     */
    private Convertor converter;
    /**
     * SearchCriteria is Search Criteria with Builder Pattern.
     */
    private SearchCriteria searchCriteria;
    /**
     * Command View allows to show error messages in command line.
     */
    private CommandView commandView;

    /**
     * Init the constructor.
     * To init the ControlCriteria we need to use the MainSearchWindows class.
     *
     * @param inputCommands is the main window of the app.
     */
    public ControlCommand(String[] inputCommands) {
        LOOGER.info("Constructor entry");

        // Initialize SearchCommand with inputCommands
        this.searchCommand = new SearchCommand(inputCommands);

        // Initialize CommandCriteria
        if (!searchCommand.getMapToSearch().isEmpty()) {
            this.commandCriteria = new CommandCriteria(searchCommand.getMapToSearch());
            this.converter = new Convertor();
            this.commandView = new CommandView();
            this.validator = new Validator();
            if (validateAllInputs()) {
                this.listenCommands();
            }
        }
        LOOGER.info("Constructor exit");
    }

    /***
     * This method  fill Data from Command Line in Search Criteria object.
     */
    private void listenCommands() {
        LOOGER.info("Action Search Button entry");

        FileTime[] dateCreation = converter.convertStringToListFileTime(commandCriteria.getDateCreation());
        FileTime[] dateModified = converter.convertStringToListFileTime(commandCriteria.getDateModified());
        FileTime[] dateLastAccess = converter.convertStringToListFileTime(commandCriteria.getDateLastAccess());
        String[] getSize = converter.splitGetSize(commandCriteria.getSize());
        // Adding to SearchCriteria
        this.searchCriteria = new SearchCriteriaBuilder()
                .pathCriteria(commandCriteria.getPath())
                .fileName(commandCriteria.getFileName())
                .hiddenCriteria(commandCriteria.getIsHidden())
                .fileNameCriteria(commandCriteria.getCriteriaName())
                .ownerCriteria(commandCriteria.getOwner())
                .isReadCriteria(Boolean.parseBoolean(commandCriteria.getReadOnly()))
                .creationDateCriteria(dateCreation[0], dateCreation[1])
                .modifiedDateCriteria(dateModified[0], dateModified[1])
                .lastAccessDateCriteria(dateLastAccess[0], dateLastAccess[1])
                .sizeCriteria(getSize[0], converter.convertSizeStringToLong(getSize[1], getSize[2]), getSize[2])
                .isDirectoryCriteria(Boolean.parseBoolean(commandCriteria.getIsDirectory()))
                .extensionCriteria(commandCriteria.getExtension())
                .build();

        // Shown results
        this.getResults(searchCriteria);

        LOOGER.info("Action Search Button exit");
    }

    /***
     * This method validate all inputs of Command Criteria
     * and print the error message.
     */
    public boolean validateAllInputs() {
        LOOGER.info("validateAllInputs entry");
        if (!validator.isValidPath(commandCriteria.getPath())) {
            commandView.printErrorMessage("Invalid Path: ".concat(commandCriteria.getPath()));
            return false;
        }
        if (commandCriteria.getFileName().equals("") && validator.isOptionCriteriaFileName(commandCriteria.getCriteriaName())) {
            commandView.printErrorMessage("-f is empty,please put -f \"file name\"");
            return false;
        }
        if (!commandCriteria.getCriteriaName().equals("") && !validator.isOptionCriteriaFileName(commandCriteria.getCriteriaName())) {
            commandView.printErrorMessage("Invalid Criteria File Name Option: ".concat(commandCriteria.getCriteriaName()));
            return false;
        }
        if (!commandCriteria.getIsHidden().equals("") && !validator.isOptionHidden(commandCriteria.getIsHidden())) {
            commandView.printErrorMessage("Invalid Hidden Option: ".concat(commandCriteria.getIsHidden()));
            return false;
        }
        if (!commandCriteria.getReadOnly().equals("") && !validator.isTrueFalse(commandCriteria.getReadOnly())) {
            commandView.printErrorMessage("Invalid Read Only Option: ".concat(commandCriteria.getReadOnly()));
            return false;
        }
        if (!commandCriteria.getIsDirectory().equals("") && !validator.isTrueFalse(commandCriteria.getIsDirectory())) {
            commandView.printErrorMessage("Invalid Is Directory Option: ".concat(commandCriteria.getIsDirectory()));
            return false;
        }
        if (!commandCriteria.getExtension().equals("") && !validator.isValidFileExtension(commandCriteria.getExtension())) {
            commandView.printErrorMessage("Invalid File Extension: ".concat(commandCriteria.getExtension()));
            return false;
        }
        if (!commandCriteria.getSize().equals("") && !validator.validateCommandSize(commandCriteria.getSize())) {
            commandView.printErrorMessage("Invalid File Size Option: ".concat(commandCriteria.getSize()));
            return false;
        }
        if (!commandCriteria.getDateCreation().equals("") && !validator.isValidDateCommand(commandCriteria.getDateCreation())) {
            commandView.printErrorMessage("Invalid Creation Date Option: ".concat(commandCriteria.getDateCreation()));
            return false;
        }
        if (!commandCriteria.getDateModified().equals("") && !validator.isValidDateCommand(commandCriteria.getDateModified())) {
            commandView.printErrorMessage("Invalid Modified Date Option: ".concat(commandCriteria.getDateModified()));
            return false;
        }
        if (!commandCriteria.getDateLastAccess().equals("") && !validator.isValidDateCommand(commandCriteria.getDateLastAccess())) {
            commandView.printErrorMessage("Invalid Last Access Option: ".concat(commandCriteria.getDateLastAccess()));
            return false;
        }
        LOOGER.info("validateAllInputs exit");
        return true;
    }

    /**
     * This method valid add the valid inputs from GUI to SearchCriteria.
     * on a table.
     *
     * @param searchCriteria An object that contain all the Inputs from GUI.
     */
    private void getResults(SearchCriteria searchCriteria) {
        LOOGER.info("Get Result Entry");

        //Init an Search object.
        Search search = new Search();

        // Sending SearchCriteria to MODEL
        search.setSearchCriteria(searchCriteria);

        // Init Model
        search.initSearch();
        if (!search.getResultList().isEmpty()) {
            commandView.printHeader();
        }
        // Adding row to Table of Result
        search.getResultList().forEach(e -> commandView.printRows(this.getDataFromAsset(e)));
        LOOGER.info("Get Result Exit");
    }

    /**
     * This method is complement of GetResult.
     *
     * @param file This is FileResult of Model.
     */
    private String[] getDataFromAsset(Asset file) {
        LOOGER.info("getDataFromAsset Entry");
        // Object[] for create row and sent this to table result on User Interface
        String[] dataFromAsset = new String[15]; // number of columns

        dataFromAsset[0] = file.getName();
        dataFromAsset[1] = file.getPathFile();
        dataFromAsset[2] = String.valueOf(file.getIsHidden());
        dataFromAsset[3] = String.valueOf(file.getSizeFile());
        dataFromAsset[4] = file.getOwnerFile();
        dataFromAsset[5] = converter.convertFileDateToDate(file.getCreationTime());
        dataFromAsset[6] = converter.convertFileDateToDate(file.getLastModifiedTime());
        dataFromAsset[7] = converter.convertFileDateToDate(file.getLastAccessTime());
        dataFromAsset[8] = String.valueOf(file.getIsReadOnlyFile());
        dataFromAsset[9] = String.valueOf(file.getIsDirectory());

        LOOGER.info("getDataFromAsset Exit");
        return dataFromAsset;
    }
}
