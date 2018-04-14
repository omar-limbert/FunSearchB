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
import com.fundation.search.model.FileResult;
import com.fundation.search.model.Search;
import com.fundation.search.view.MainSearchWindows;

import javax.swing.JOptionPane;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * userInterfaceInPutData is Map for save all data from User Interface.
     */
    private Map<String, Object> userInterfaceInPutData;

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

        // Initialize Convertor
        this.converter = new Convertor();

        // Initialize List with data from User Interface
        this.userInterfaceInPutData = new HashMap<>();

        LOOGER.info("Constructor exit");
    }

    /***
     * This method check the event of the button "search" and fill Data from User Interface.
     * Data on Map:
     * Key: Search Text Data: String
     * Key: Hidden Criteria Data: String
     * Key: Name Criteria Data: String
     * Key: Owner Criteria Data: String
     * Key: Read Only Criteria Data: Boolean
     * Key: Creation Date Criteria Data: Date[0] creationDateInit Date, Date[1] creationDateEnd Date.
     * Key: Modified Date Criteria Data: Date[0] modifiedDateInit Date, Date[1] modifiedDateEnd Date.
     * Key: Last Access Date Criteria: Date[0] LastAccessDateInit Date, Date[1] LastAccessDateEnd Date.
     *
     * then the inputs are insert for validate.
     */
    private void listenSearchButton() {
        LOOGER.info("Action Search Button entry");

        // Reset Table of result from User Interface.
        searchWindows.resetDataOfJTableResult();

        // Reading Data from User Interface
        userInterfaceInPutData.put("Search Text", searchWindows.getSearchText());
        userInterfaceInPutData.put("Path Criteria", searchWindows.getPathOfCriteria());
        userInterfaceInPutData.put("Hidden Criteria", searchWindows.getHiddenOfCriteria());
        userInterfaceInPutData.put("Name Criteria", searchWindows.getFileNameOfCriteria());
        userInterfaceInPutData.put("Owner Criteria", searchWindows.getOwnerOfCriteria());
        userInterfaceInPutData.put("Read Only Criteria", searchWindows.getReadOnlyOfCriteria());
        userInterfaceInPutData.put("Creation Date Criteria", new FileTime[]{converter.convertDateToFileDate(searchWindows.getCreationDateInit())
                , converter.convertDateToFileDate(searchWindows.getCreationDateEnd())});
        userInterfaceInPutData.put("Modified Date Criteria", new FileTime[]{converter.convertDateToFileDate(searchWindows.getModifiedDateInit())
                , converter.convertDateToFileDate(searchWindows.getModifiedDateEnd())});
        userInterfaceInPutData.put("Last Access Date Criteria", new FileTime[]{converter.convertDateToFileDate(searchWindows.getLastAccessDateInit())
                , converter.convertDateToFileDate(searchWindows.getLastAccessDateEnd())});
        userInterfaceInPutData.put("Size Criteria", searchWindows.getSearchText()); //Incomplete
        // NEXT: Please add here other implementations and don't delete this note

        // Sending valid inputs from User Interface to method validInputs().
        if (this.validInputs()) {
            // Initialize Search Criteria
            this.initSearchCriteria();
        }
        LOOGER.info("Action Search Button exit");
    }

    /**
     * This Method is for initialize search criteria.
     */
    private void initSearchCriteria() {
        LOOGER.info("Init Search Criteria Entry");

        // Sending Map to SearchCriteria
        SearchCriteria searchCriteria = new SearchCriteria(userInterfaceInPutData);

        // Sending results
        this.getResults(searchCriteria);
        LOOGER.info("Init Search Criteria Exit");
    }

    /**
     * This method valid the inputs from GUI.
     *
     * @return boolean, This return true if all is valid, false if any data is not valid.
     */
    private boolean validInputs() {
        LOOGER.info("Valid Inputs Entry");
        FileTime[] dateFromObject;

        // Validate Path
        if (!validateInputs.isValidPath(userInterfaceInPutData.get("Path Criteria").toString())) {
            JOptionPane.showMessageDialog(null, "Invalid Path", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate File Name
        if (!validateInputs.isValidFile(userInterfaceInPutData.get("Search Text").toString())) {
            JOptionPane.showMessageDialog(null, "Invalid File Name", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
/*
        // Validate Size
        if (!validateInputs.isValidSize(userInterfaceInPutData.get("Size Criteria").toString())) {
            JOptionPane.showMessageDialog(null, "Invalid Size", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }*/

        // Validate Creation date
        dateFromObject = (FileTime[]) userInterfaceInPutData.get("Creation Date Criteria");
        if (!validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[0]))) {
            JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[1]))) {
            JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Modified date
        dateFromObject = (FileTime[]) userInterfaceInPutData.get("Modified Date Criteria");
        if (!validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[0]))) {
            JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[1]))) {
            JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Last Access date
        dateFromObject = (FileTime[]) userInterfaceInPutData.get("Last Access Date Criteria");
        if (!validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[0]))) {
            JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        System.out.println(converter.convertFileDateToDate(dateFromObject[1])+" "+converter.convertFileDateToDate(dateFromObject[1])+" "+validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[1]))+" ");
        if (!validateInputs.isValidDate(converter.convertFileDateToDate(dateFromObject[1]))) {
            JOptionPane.showMessageDialog(null, "Invalid Date", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        LOOGER.info("Valid Inputs Exit");
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

        // Getting FileResult List with all result data
        List<FileResult> result = search.getResultList();

        // Object[] for create row and sent this to table result on User Interface
        Object[] data = new Object[10]; // number of columns

        for (FileResult file : result) {
            data[0] = file.getName();
            data[1] = file.getPathFile();
            data[2] = file.getIsHidden();
            data[3] = file.getSizeFile();
            data[4] = file.getOwnerCriteria();
            data[5] = converter.convertFileDateToDate(file.getCreationTime());
            data[6] = converter.convertFileDateToDate(file.getLastModifiedTime());
            data[7] = converter.convertFileDateToDate(file.getLastAccessTime());

            // Sending data to Table of Result on User Interface
            searchWindows.insertDataOfJTableResult(data);
        }
        LOOGER.info("Get Result Exit");
    }
}
