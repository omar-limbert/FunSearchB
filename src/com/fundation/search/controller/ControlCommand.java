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
import com.fundation.search.model.FileResult;
import com.fundation.search.model.Search;
import com.fundation.search.view.command.CommandCriteria;
import com.fundation.search.view.command.CommandView;
import com.fundation.search.view.command.SearchCommand;

import java.nio.file.attribute.FileTime;
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

        // For Size getting Criteria[0], Size[1] and Type[2] from UI
        String criteriaOfSize = "major to:";
        String sizeOfSize = commandCriteria.getSize();
        String typeOfSize = "bit";
        Long size = 0L;

        // Converting Size to bytes for Model
        if (typeOfSize.equalsIgnoreCase("bit") && !sizeOfSize.isEmpty()) {
            size = Long.parseLong(sizeOfSize);
        }

        // YOU NEED IMPLEMENT FOR KB, MB and GB HERE

        // Adding to SearchCriteria and Validating some data
       this.searchCriteria = new com.fundation.search.controller.builder.SearchCriteriaBuilder()
                .pathCriteria(this.pathValidation(commandCriteria.getPath()))
                .fileName(this.nameValidation(commandCriteria.getFileName()))
                .hiddenCriteria(commandCriteria.getIsHidden())
                .fileNameCriteria(commandCriteria.getCriteriaName())
                .ownerCriteria(commandCriteria.getOwner())
                .isReadCriteria(Boolean.valueOf(commandCriteria.getReadOnly()))
                .creationDateCriteria(this.dateValidation(new Date("01/01/1999"))
                        , this.dateValidation(new Date()))
                .modifiedDateCriteria(this.dateValidation(new Date("01/01/1999"))
                        , this.dateValidation(new Date()))
                .lastAccessDateCriteria(this.dateValidation(new Date("01/01/1999"))
                        , this.dateValidation(new Date()))
                .sizeCriteria(criteriaOfSize, size, typeOfSize)
                .isDirectoryCriteria(false)
                .extensionCriteria("")
                .build();

        // Shown results
        this.getResults(searchCriteria);

        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method validate Date.
     *
     * @param creationDateInit Date of Creation of File.
     * @return FileTime, return validated date on FileTime format.
     */
    private FileTime dateValidation(Date creationDateInit) {
        LOOGER.info("dateValidation Entry");
        if (validateInputs.isValidDate(creationDateInit.toString())) {
            return converter.convertDateToFileDate(creationDateInit);
        }
        LOOGER.info("dateValidation Exit");
        return converter.convertDateToFileDate(creationDateInit);
    }

    /**
     * This method validate File Name.
     *
     * @param searchText Name of File.
     * @return String return name validated.
     */
    private String nameValidation(String searchText) {
        LOOGER.info("nameValidation Entry");
        if (validateInputs.isValidFile(searchText)) {
            return searchText;
        }
        LOOGER.info("nameValidation Exit");
        return "";
    }

    /**
     * This method validate Path.
     *
     * @param pathOfCriteria Path of file.
     * @return String return Path validated.
     */
    private String pathValidation(String pathOfCriteria) {
        LOOGER.info("pathValidation Entry");
        if (validateInputs.isValidPath(pathOfCriteria)) {
            return pathOfCriteria;
        }
        LOOGER.info("pathValidation Exit");
        return null;
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
        // Adding row to Table of Result
        commandView.printColumn();
        search.getResultList().forEach(e -> commandView.printRows(this.getDataFromAsset(e)));
        LOOGER.info("Get Result Exit");
    }

    /**
     * This method is complement of GetResult.
     *
     * @param file This is FileResult of Model.
     */
    private String[] getDataFromAsset(FileResult file) {
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
        dataFromAsset[9]=String.valueOf(file.getIsDirectory());

        LOOGER.info("getDataFromAsset Exit");
        return dataFromAsset;
    }
}
