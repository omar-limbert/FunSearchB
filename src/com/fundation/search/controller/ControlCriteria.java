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
import com.fundation.search.view.MainSearchWindows;

import javax.swing.JOptionPane;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.logging.Logger;

/**
 * This class is made the control between View and Model.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @author Omar Limbert Huanca sanchez - AT-[06]
 * @version 1.0.
 */
public class ControlCriteria {
    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * searchWindows is the view.
     */
    private MainSearchWindows searchWindows;
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
     * @param searchWindows is the main window of the app.
     */
    public ControlCriteria(MainSearchWindows searchWindows) {
        LOOGER.info("Constructor entry");
        this.searchWindows = searchWindows;

        // Open User Interface
        this.searchWindows.initWindows();

        // Action for Search Button
        this.searchWindows.getSearchButton().addActionListener(e -> listenSearchButton());

        // Initialize Validator
        this.validateInputs = new Validator();

        // Initialize Converter
        this.converter = new Convertor();

        LOOGER.info("Constructor exit");
    }

    /**
     * This method check the event button "search" and fill Data from User Interface.
     * then the inputs are insert for validate.
     */
    private void listenSearchButton() {
        LOOGER.info("Action Search Button entry");

        // Reset Table of result from User Interface.
        searchWindows.resetDataOfJTableResult();

        // For Size getting Criteria[0], Size[1] and Type[2] from UI
        String criteriaOfSize = searchWindows.getSizeOfCriteria()[0];
        String sizeOfSize = searchWindows.getSizeOfCriteria()[1];
        String typeOfSize = searchWindows.getSizeOfCriteria()[2];
        Long size = 0L;

        // Converting Size to bytes for Model
        if (typeOfSize.equalsIgnoreCase("bit") && !sizeOfSize.isEmpty()) {
            size = Long.parseLong(sizeOfSize);
        }

        // YOU NEED IMPLEMENT FOR KB, MB and GB HERE

        // Adding to SearchCriteria and Validating some data
        this.searchCriteria = new com.fundation.search.controller.builder.SearchCriteriaBuilder()
                .pathCriteria(this.pathValidation(searchWindows.getPathOfCriteria()))
                .fileName(this.nameValidation(searchWindows.getSearchText()))
                .hiddenCriteria(searchWindows.getHiddenOfCriteria())
                .fileNameCriteria(searchWindows.getFileNameOfCriteria())
                .ownerCriteria(searchWindows.getOwnerOfCriteria())
                .isReadCriteria(Boolean.valueOf(searchWindows.getReadOnlyOfCriteria()))
                .isFileSystemCriteria(Boolean.valueOf(searchWindows.getFileSystemOfCriteria()))
                .creationDateCriteria(this.dateValidation(searchWindows.getCreationDateInit())
                        , this.dateValidation(searchWindows.getCreationDateEnd()))
                .modifiedDateCriteria(this.dateValidation(searchWindows.getModifiedDateInit())
                        , this.dateValidation(searchWindows.getModifiedDateEnd()))
                .lastAccessDateCriteria(this.dateValidation(searchWindows.getLastAccessDateInit())
                        , this.dateValidation(searchWindows.getLastAccessDateEnd()))
                .sizeCriteria(criteriaOfSize, size, typeOfSize)
                .isDirectoryCriteria(searchWindows.getDirectoryOfCriteria())
                .extensionCriteria(searchWindows.getTypeCriteria())
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
        //  JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
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
        JOptionPane.showMessageDialog(null, "Invalid Path", "Error", JOptionPane.ERROR_MESSAGE);
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

        // Adding row to Table of Result
        search.getResultList().forEach(e -> searchWindows.insertDataOfJTableResult(this.getDataFromAsset(e)));
        LOOGER.info("Get Result Exit");
    }
    /**
     * This method is complement of GetResult.
     *
     * @param file This is FileResult of Model.
     */
    private Object[] getDataFromAsset(Asset file) {
        LOOGER.info("getDataFromAsset Entry");
        // Object[] for create row and sent this to table result on User Interface
        Object[] dataFromAsset = new Object[15]; // number of columns
        // Getting data for table result
        dataFromAsset[0] = file.getName();
        dataFromAsset[1] = file.getPathFile();
        dataFromAsset[2] = file.getIsHidden();
        dataFromAsset[3] = file.getIsReadOnlyFile();
        dataFromAsset[4] = file.getIsFileSystemFile();
        dataFromAsset[5] = file.getIsDirectory();
        dataFromAsset[6] = file.getExtensionFile();
        dataFromAsset[7] = file.getSizeFile();
        dataFromAsset[8] = file.getOwnerFile();
        dataFromAsset[9] = converter.convertFileDateToDate(file.getCreationTime());
        dataFromAsset[10] = converter.convertFileDateToDate(file.getLastModifiedTime());
        dataFromAsset[11] = converter.convertFileDateToDate(file.getLastAccessTime());

        LOOGER.info("getDataFromAsset Exit");
        return dataFromAsset;
    }
}
