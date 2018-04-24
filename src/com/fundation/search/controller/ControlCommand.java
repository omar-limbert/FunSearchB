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

import java.util.Date;
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
     * validateInputs is the validator for valid inputs.
     */
    private Validator validateInputs;
    /**
     * converter is the converter for valid inputs.
     */
    private Convertor converter;
    /**
     * SearchCriteria is Search Criteria with Builder Pattern.
     */
    private SearchCriteria searchCriteria;

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
        this.commandCriteria = new CommandCriteria(searchCommand.getMapToSearch());

        // Initialize Validator
        this.validateInputs = new Validator();

        // Initialize Converter
        this.converter = new Convertor();

        this.listenCommands();

        LOOGER.info("Constructor exit");
    }

    /***
     * This method check the event button "search" and fill Data from User Interface.
     * then the inputs are insert for validate.
     */
    private void listenCommands() {
        LOOGER.info("Action Search Button entry");

        Date[] dateCreation = converter.convertDate(dateValidation(commandCriteria.getDateCreation()));
        Date[] dateModified = converter.convertDate(dateValidation(commandCriteria.getDateModified()));
        Date[] dateLastAccess = converter.convertDate(dateValidation(commandCriteria.getDateLastAccess()));
        String[] getSize = splitGetSize(commandCriteria.getSize());
        // Adding to SearchCriteria and Validating some data
        this.searchCriteria = new com.fundation.search.controller.builder.SearchCriteriaBuilder()
                .pathCriteria(this.pathValidation(commandCriteria.getPath()))
                .fileName(this.nameValidation(commandCriteria.getFileName()))
                .hiddenCriteria(isHiddenValidation(commandCriteria.getIsHidden()))
                .fileNameCriteria(fileNameCriteriaValidation(commandCriteria.getCriteriaName()))
                .ownerCriteria(commandCriteria.getOwner())
                .isReadCriteria(isTrueFalseValidation(commandCriteria.getReadOnly()))
                .creationDateCriteria(converter.convertDateToFileDate(dateCreation[0]), converter.convertDateToFileDate(dateCreation[1]))
                .modifiedDateCriteria(converter.convertDateToFileDate(dateModified[0]), converter.convertDateToFileDate(dateModified[1]))
                .lastAccessDateCriteria(converter.convertDateToFileDate(dateLastAccess[0]), converter.convertDateToFileDate(dateLastAccess[1]))
                .sizeCriteria(getSize[0], converter.convertSizeStringToLong(getSize[1], getSize[2]), getSize[2])
                .isDirectoryCriteria(isTrueFalseValidation(commandCriteria.getIsDirectory()))
                .extensionCriteria(extensionFileValidation(commandCriteria.getExtension()))
                .build();

        // Shown results
        this.getResults(searchCriteria);

        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method  split the command size
     * Minor to:/Major to:/Equals to obtain:
     * tam size
     * bytes/kb/mb/gb
     *
     * @param sizeCommand dates.
     * @return String []dates.
     */
    public String[] splitGetSize(String sizeCommand) {
        LOOGER.info("SizeCommand entry");
        String[] parts = sizeCommand.split(":");
        String[] valueCommand = new String[3];
        if (parts.length == 2 && validateInputs.isOptionSize(parts[0].concat(":"))) {
            valueCommand[0] = parts[0].concat(":");
            valueCommand[1] = parts[1].replaceAll("[^.0-9]+", "");
            valueCommand[2] = parts[1].replaceAll("[^a-zA-Z]+", "");
        }
        LOOGER.info("SizeCommand exit");
        return valueCommand;
    }

    /**
     * This method split and validate the date command in:
     * dd/MM/yyyy
     * to
     * dd/MM/yyyy
     *
     * @param date command date.
     * @return String []dates.
     */
    private String[] dateValidation(String date) {
        LOOGER.info("dateValidation entry");
        String[] listDate = date.split(" ");
        if (listDate.length == 3) {
            if (validateInputs.isValidDate(listDate[0]) &&
                    validateInputs.isValidDate(listDate[2])) {
                return listDate;
            }
        }
        LOOGER.info("dateValidation exit");
        return new String[3];
    }

    /**
     * This method validate Path.
     *
     * @param pathOfCriteria Path of file.
     * @return String return Path validated.
     */
    private String pathValidation(String pathOfCriteria) {
        LOOGER.info("pathValidation Entry");
        return validateInputs.isValidPath(pathOfCriteria) ? pathOfCriteria : null;
    }

    /**
     * This method validate File Name.
     *
     * @param searchText Name of File.
     * @return String return name validated.
     */
    private String nameValidation(String searchText) {
        LOOGER.info("nameValidation Entry");
        return validateInputs.isValidFile(searchText) ? searchText : "";
    }

    /**
     * This method validate if is a hidden criteria.
     *
     * @param hiddenCriteria (only hidden/without hidden) .
     * @return String return hiddenCriteria validated.
     */
    private String isHiddenValidation(String hiddenCriteria) {
        LOOGER.info("pathValidation Entry");
        return validateInputs.isOptionHidden(hiddenCriteria) ? hiddenCriteria : "";
    }

    /**
     * This method validate a criteria file name.
     *
     * @param criteriaName criteria file name(start with,end with,all words).
     * @return String criteria file name validated.
     */
    private String fileNameCriteriaValidation(String criteriaName) {
        LOOGER.info("fileNameCriteriaValidation" + criteriaName);
        return validateInputs.isOptionCriteriaFileName(criteriaName) ? criteriaName : "";
    }

    /**
     * This method validate if a criteria is true or false.
     *
     * @param criteria true or false.
     * @return boolean criteria validated.
     */
    private boolean isTrueFalseValidation(String criteria) {
        LOOGER.info("isTrueFalseValidation " + criteria);
        return validateInputs.isTrueFalse(criteria) ? Boolean.parseBoolean(criteria) : false;
    }

    /**
     * This method validate the structure extension file.
     *
     * @param extension is the extension file.
     * @return String extension validated.
     */
    private String extensionFileValidation(String extension) {
        LOOGER.info("isTrueFalseValidation " + extension);
        return validateInputs.isValidFileExtension(extension) ? extension : "";
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

        // Init CommandView
        CommandView commandView = new CommandView();
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
