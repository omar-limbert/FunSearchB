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

        // Converting Size to bytes for Model
        Long size = 0L;
        /** if (tam!=null) {
         size = Long.parseLong(tam);
         }**/

        // YOU NEED IMPLEMENT FOR KB, MB and GB HERE
        Date[] dateCreation = convertDate(dateValidation(commandCriteria.getDateCreation()));
        Date[] dateModified = convertDate(dateValidation(commandCriteria.getDateModified()));
        Date[] dateLastAccess = convertDate(dateValidation(commandCriteria.getDateLastAccess()));
        // Adding to SearchCriteria and Validating some data
        this.searchCriteria = new com.fundation.search.controller.builder.SearchCriteriaBuilder()
                .pathCriteria(this.pathValidation(commandCriteria.getPath()))
                .fileName(this.nameValidation(commandCriteria.getFileName()))
                .hiddenCriteria(commandCriteria.getIsHidden())
                .fileNameCriteria(commandCriteria.getCriteriaName())
                .ownerCriteria(commandCriteria.getOwner())
                .isReadCriteria(Boolean.valueOf(commandCriteria.getReadOnly()))
                .creationDateCriteria(contentDate(dateCreation[0]), contentDate(dateCreation[1]))
                .modifiedDateCriteria(contentDate(dateModified[0]), contentDate(dateModified[1]))
                .lastAccessDateCriteria(contentDate(dateLastAccess[0]), contentDate(dateLastAccess[1]))
                .sizeCriteria("", size, "")
                .isDirectoryCriteria(Boolean.valueOf(commandCriteria.getIsDirectory()))
                .extensionCriteria(commandCriteria.getExtension())
                .build();

        // Shown results
        this.getResults(searchCriteria);

        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method convertDate to FileDate.
     *
     * @param date Date of File.
     * @return FileTime, return validated date on FileTime format.
     */
    private FileTime contentDate(Date date) {
        LOOGER.info("ConvertDate to FileDate");
        return converter.convertDateToFileDate(date);
    }

    /**
     * This method convertString to String[].
     *
     * @param date dates.
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
     * This method convertDate to FileDate.
     *
     * @param dates String dates.
     */
    private Date[] convertDate(String[] dates) {
        LOOGER.info("dates ConvertDate entry");
        Date[] dateList = new Date[2];
        dateList[0] = converter.convertStringToDate(dates[0]);
        dateList[1] = converter.convertStringToDate(dates[2]);
        LOOGER.info("dates ConvertDate exit");
        return dateList;
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
