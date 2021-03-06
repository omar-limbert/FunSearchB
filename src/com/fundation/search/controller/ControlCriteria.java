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
import com.fundation.search.model.asset.FileResult;
import com.fundation.search.controller.builder.SearchCriteriaBuilder;
import com.fundation.search.model.asset.FolderResult;
import com.fundation.search.model.asset.MultimediaResult;
import com.fundation.search.view.MainSearchWindows;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.HashMap;
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
     * SearchCriteria is Search Criteria with Builder Pattern.
     */

    private SearchCriteria searchCriteria;

    /**
     * search is Search of Model.
     */
    private Search search;

    /**
     * search is Search of Model.
     */
    private int indexSelectedOnDataTableResult;

    /**
     * search is Search of Model.
     */
    private Map<Integer, SearchCriteria> searchCriteriaMapOfDataBase;

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
        this.searchWindows.getSearchButton().addActionListener(e -> this.listenSearchButton());

        // Action for Save Button
        this.searchWindows.getSaveButtonOnDataBasePanel().addActionListener(e -> this.listenSaveButton());

        // Action for Fill Button
        this.searchWindows.getFillButtonOnDataBasePanel().addActionListener(e -> this.listenFillButton());

        // Action for Delete Button
        this.searchWindows.getDeleteButtonOnDataBasePanel().addActionListener(e -> this.listenDeleteButton());

        // Action for Load Button
        this.searchWindows.getLoadButtonOnDataBasePanel().addActionListener(e -> this.listenLoadButton());

        // Action for Data Base Table
        this.searchWindows.getSelectionModelOfDataBaseTableResult().addListSelectionListener(this::updateSelectedCriteriaOnDataBaseTable);

        // Initialize Validator
        this.validateInputs = new Validator();

        // Initialize Converter
        this.converter = new Convertor();

        // Initialize SearchCriteria
        this.searchCriteria = null;

        // Initialize Model
        this.search = new Search();

        // Initialize searchCriteriaMap
        this.searchCriteriaMapOfDataBase = new HashMap<>();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method Listener is to update index of Data Base Table Result selected.
     *
     * @param e, this is event of JTable.
     */
    private void updateSelectedCriteriaOnDataBaseTable(ListSelectionEvent e) {

        // Getting Row Selected and updating index
        if (!searchWindows.getSelectionModelOfDataBaseTableResult().isSelectionEmpty()) {

            // Getting index
            String index = searchWindows
                    .getDataBaseTableResult()
                    .getValueAt(searchWindows.getDataBaseTableResult().getSelectedRow(), 0)
                    .toString();

            // Updating index
            indexSelectedOnDataTableResult = Integer.parseInt(index);

        }
    }

    /**
     * This method check the event button "save" and fill Data from User Interface.
     * then the inputs are insert for validate.
     */
    private void listenSaveButton() {
        LOOGER.info("Action Search Button entry");
        if (searchCriteria != null) {

            // Updating Name of Criteria
            searchCriteria.updateNameOnDataBase(searchWindows.getNameOfCriteriaToSaveOnDataBase());

            // Confirmation
            int confirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure to add: " + searchCriteria.getNameOnDataBase(), "Add -> DB", JOptionPane.YES_NO_OPTION);
            if (confirmDialog == JOptionPane.YES_OPTION) {
                search.saveCriteriaToDataBase(searchCriteria);
                this.listenLoadButton();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Search Criteria not found", "Error", JOptionPane.ERROR_MESSAGE);
        }

        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method check the event button "save" and fill Data from User Interface.
     * then the inputs are insert for validate.
     */
    private void listenFillButton() {
        LOOGER.info("Action Search Button entry");
        SearchCriteria searchCriteriaDB;
        if (!searchWindows.getSelectionModelOfDataBaseTableResult().isSelectionEmpty()) {

            // Recover search criteria and update User Interface
            searchCriteriaDB = searchCriteriaMapOfDataBase.get(indexSelectedOnDataTableResult);

            // Confirm show results
            int confirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure to Recover: " + searchCriteriaDB.getNameOnDataBase(), "Recover <- DB", JOptionPane.YES_NO_OPTION);
            if (confirmDialog == JOptionPane.YES_OPTION) {
                searchWindows.resetDataOfJTableResult();
                this.getResults(searchCriteriaDB);
                long size;
                String sizeOperator;
                String sizeCriteria;

                if (searchCriteriaDB.getSize() == -1) {
                    size = 0;
                    sizeOperator = "upper";
                    sizeCriteria = "Bytes";
                } else {
                    size = searchCriteriaDB.getSize();
                    sizeOperator = searchCriteriaDB.getOperator();
                    sizeCriteria = searchCriteriaDB.getType();
                }

                // Updating User Interface
                searchWindows.setCreationDateEnd(converter.convertFileDateToDate(searchCriteriaDB.getCreationDateEnd()));
                searchWindows.setCreationDateInit(converter.convertFileDateToDate(searchCriteriaDB.getCreationDateInit()));
                searchWindows.setLastAccessEnd(converter.convertFileDateToDate(searchCriteriaDB.getLastAccessDateEnd()));
                searchWindows.setLastAccessInit(converter.convertFileDateToDate(searchCriteriaDB.getLastAccessDateInit()));
                searchWindows.setModifiedDateEnd(converter.convertFileDateToDate(searchCriteriaDB.getModifiedDateEnd()));
                searchWindows.setModifiedDateInit(converter.convertFileDateToDate(searchCriteriaDB.getModifiedDateInit()));
                searchWindows.setNameCriteria(searchCriteriaDB.getName());
                searchWindows.setSizeCriteria(size);
                searchWindows.setOperatorCriteria(sizeOperator);
                searchWindows.setTypeCriteria(sizeCriteria);
                searchWindows.setExtensionCriteria(searchCriteriaDB.getExtension());
                searchWindows.setOwnerCriteria(searchCriteriaDB.getOwnerCriteria());
                searchWindows.setPathCriteria(searchCriteriaDB.getPath());
                searchWindows.setFileNameCriteria(searchCriteriaDB.getFileNameCriteria());
                searchWindows.setIsDirectoryCriteria(searchCriteriaDB.getIsDirectory());
                searchWindows.setIsFileSystemCriteria(searchCriteriaDB.getIsFileSystem());
                searchWindows.setIsReadOnlyCriteria(searchCriteriaDB.getIsReadOnly());
                searchWindows.setIsHiddenCriteria(searchCriteriaDB.getHiddenCriteria());
                searchWindows.setKeySensitiveOfCriteria(searchCriteriaDB.getKeySensitiveOfCriteria());
                searchWindows.setIsContainsInsideFileCriteria(searchCriteriaDB.getIsContainsInsideFileCriteria());
                searchWindows.setTextContainsInsideFileCriteria(searchCriteriaDB.getTextContainsInsideFileCriteria());
                searchWindows.setMultimediaDurationCriteria(searchCriteriaDB.getMultimediaDurationOperatorDB());
                searchWindows.setMultimediaDurationNumber(searchCriteriaDB.getMultimediaDuration().toString());
                searchWindows.setMultimediaDurationType(searchCriteriaDB.getMultimediaDurationType());
                searchWindows.setMultimediaFrameRate(searchCriteriaDB.getFrameRateCriteria());
                searchWindows.setMultimediaDurationVideoCodec(searchCriteriaDB.getMultimediaVideoCodec());
                searchWindows.setMultimediaResolution(searchCriteriaDB.getMultimediaResolution());
                searchWindows.setMultimediaAudioBitRateInit(searchCriteriaDB.getMultimediaAudioBitRateInit());
                searchWindows.setMultimediaAudioBitRateEnd(searchCriteriaDB.getMultimediaAudioBitRateEnd());
                searchWindows.setMultimediaType(searchCriteriaDB.getMultimediaType());
            }
        }
        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method check the event button "Delete" and fill Data from User Interface.
     * then the inputs are insert for validate.
     */
    private void listenDeleteButton() {
        LOOGER.info("Action Search Button entry");
        SearchCriteria searchCriteriaDB;
        if (!searchWindows.getSelectionModelOfDataBaseTableResult().isSelectionEmpty()) {

            // Recover search criteria and update User Interface
            searchCriteriaDB = searchCriteriaMapOfDataBase.get(indexSelectedOnDataTableResult);

            // Confirm show results
            int confirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure to Delete: " + searchCriteriaDB.getNameOnDataBase(), "Recover <- DB", JOptionPane.YES_NO_OPTION);
            if (confirmDialog == JOptionPane.YES_OPTION) {
                search.deleteCriteriaFromDataBase(indexSelectedOnDataTableResult);
                this.listenLoadButton();
            }
        }
        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method check the event button "save" and fill Data from User Interface.
     * then the inputs are insert for validate.
     */
    private void listenLoadButton() {
        LOOGER.info("Action Search Button entry");
        searchWindows.resetDataOfDataBaseTableResult();

        // Getting Search Criteria Map
        searchCriteriaMapOfDataBase = search.getAllDataFromDataBase();

        // Insert row to Data Base Table Result
        searchCriteriaMapOfDataBase
                .forEach((k, v) -> searchWindows.insertDataToDataBaseTableResult(this.getDataFromCriteriaMap(k, v)));
        LOOGER.info("Action Search Button exit");
    }

    /**
     * This method is complement of getDataFromCriteriaMap.
     *
     * @param (idOfCriteria, searchCriteria) .
     */
    private Object[] getDataFromCriteriaMap(Integer idOfCriteria, SearchCriteria searchCriteria) {
        //LOOGER.info("getDataFromAsset Entry");

        // Object[] for create row and sent this to table result on User Interface
        Object[] dataFromAsset = new Object[3]; // number of columns

        // Getting data for table result
        dataFromAsset[0] = idOfCriteria;
        dataFromAsset[1] = searchCriteria.getNameOnDataBase();

        //LOOGER.info("getDataFromAsset Exit");
        return dataFromAsset;
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
        long size = -1L;

        // Converting Size to bytes for Model
        if (!sizeOfSize.isEmpty()) {
            size = converter.convertSizeStringToLong(sizeOfSize, typeOfSize);
        }
        double durationMultimedia = -1.0;
        if (!searchWindows.getDurationMultimediaNumber().equals("")) {
            if (!validateInputs.isValidFormatSize(searchWindows.getDurationMultimediaNumber()) && !searchWindows.getDurationMultimediaNumber().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Format of Duration Multimedia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                durationMultimedia = converter.convertTimeDurationToDouble(searchWindows.getDurationMultimediaNumber(), searchWindows.getDurationMultimediaTime());
            }
        }

        // Adding to SearchCriteria and Validating some data
        if (validateInputsGUI()) {
            this.searchCriteria = new SearchCriteriaBuilder()
                    .pathCriteria(searchWindows.getPathOfCriteria())
                    .fileName(searchWindows.getSearchText())
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
                    .nameOnDataBase("")
                    .keySensitiveOfCriteria(Boolean.valueOf(searchWindows.getKeySensitiveOfCriteria()))
                    .isContainsInsideFileCriteria(Boolean.valueOf(searchWindows.getIsContainsInsideFileCriteria()))
                    .textContainsInsideFileCriteria(searchWindows.getTextContainsInsideFileCriteria())
                    .multimediaDurationInputCriteria(searchWindows.getDurationMultimediaCriteria(), durationMultimedia, searchWindows.getDurationMultimediaTime())
                    .multimediaVideoCodecCriteria(searchWindows.getVideoCodecCriteria())
                    .searchMultimediaFrameCriteria(searchWindows.getFrameRateCriteria())
                    .multimediaResolutionCriteria(searchWindows.getResolutionCriteria())
                    .multimediaAudioBitRateCriteriaInit(searchWindows.getAudioBitRateInit())
                    .multimediaAudioBitRateCriteriaEnd(searchWindows.getAudioBitRateEnd())
                    .multimediaTypeCriteria(searchWindows.getMultimediaTypeCriteria())
                    .searchMultimediaCriteria(searchWindows.isSearchMultimedia())
                    .build();
            // Shown results
            this.getResults(searchCriteria);
        }
        LOOGER.info("Action Search Button exit");
    }

    /**
     * @return Return true if all the inputs have the rith format.
     */
    private boolean validateInputsGUI() {
        if (!validateInputs.isValidPath(searchWindows.getPathOfCriteria()) && !validateInputs.isValidPath(searchWindows.getPathOfCriteria())) {
            JOptionPane.showMessageDialog(null, "Invalid Format Path", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validateInputs.isValidFile(searchWindows.getSearchText()) && !searchWindows.getSearchText().equals("")) {
            JOptionPane.showMessageDialog(null, "Invalid Format File", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!validateInputs.isValidFormatSize(searchWindows.getSizeOfCriteria()[1]) && !searchWindows.getSizeOfCriteria()[1].equals("")) {
            JOptionPane.showMessageDialog(null, "Invalid Format of Size", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!validateInputs.isValidFileExtension(searchWindows.getTypeCriteria()) && !searchWindows.getTypeCriteria().equals("")) {
            JOptionPane.showMessageDialog(null, "Invalid Format of Extension File", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!validateInputs.isValidFormatBitRate(searchWindows.getAudioBitRateInit()) && !searchWindows.getAudioBitRateInit().equals("")) {
            JOptionPane.showMessageDialog(null, "Invalid Format of AudiBitRate", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validateInputs.isValidFormatBitRate(searchWindows.getAudioBitRateEnd()) && !searchWindows.getAudioBitRateEnd().equals("")) {
            JOptionPane.showMessageDialog(null, "Invalid Format of AudiBitRate", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
     * This method valid add the valid inputs from GUI to SearchCriteria.
     * on a table.
     *
     * @param searchCriteria An object that contain all the Inputs from GUI.
     */
    private void getResults(SearchCriteria searchCriteria) {
        LOOGER.info("Get Result Entry");

        // Files counter
        final int[] filesCounter = {0};

        // Folder counter
        final int[] folderCounter = {0};
        // Sending SearchCriteria to MODEL
        search.setSearchCriteria(searchCriteria);
        // Init Model
        search.initSearch();
        // Adding row to Table of Result
        search.getResultList().forEach(e -> {
            if (!(e instanceof FolderResult)) {
                filesCounter[0]++;
            } else {
                folderCounter[0]++;
            }
            searchWindows.insertDataOfJTableResult(this.getDataFromAsset(e));
        });

        searchWindows.setResultProcessTextField(filesCounter[0] + " File(s), " + folderCounter[0] + " Directory(ies)");
        LOOGER.info("Get Result Exit");
    }

    /**
     * This method is complement of GetResult.
     *
     * @param file This is FileResult of Model.
     */

    private Object[] getDataFromAsset(Asset file) {
        //LOOGER.info("getDataFromAsset Entry");

        // Object[] for create row and sent this to table result on User Interface
        Object[] dataFromAsset = new Object[15]; // number of columns
        // Getting data for table result

        if (file instanceof MultimediaResult && searchWindows.isSearchMultimedia()) {
            this.searchWindows.setColumnsTittleToMultimedia();
            this.multimediaToTableResult(dataFromAsset, file);

        } else {
            this.searchWindows.setColumnsTittleToFile();
            this.fileResultToTableResult(dataFromAsset, file);
        }


        //LOOGER.info("getDataFromAsset Exit");
        return dataFromAsset;
    }

    /**
     * This method is complement of fileResultToTableResult.
     *
     * @param (dataFromAsset, file) .
     */
    private void fileResultToTableResult(Object[] dataFromAsset, Asset file) {
        dataFromAsset[0] = file.getName();
        dataFromAsset[1] = file.getPathFile();
        dataFromAsset[2] = file.getIsHidden();
        dataFromAsset[3] = file.getIsReadOnlyFile();
        dataFromAsset[4] = file.getIsFileSystemFile();
        dataFromAsset[5] = file.getIsDirectory();
        if (file instanceof FileResult || file instanceof MultimediaResult) {
            dataFromAsset[6] = file.getExtensionFile();
        } else {
            dataFromAsset[6] = file.getFilesQuantity() + " File(s)";
        }
        dataFromAsset[7] = converter.convertSizeUnit(file.getSizeFile(), searchWindows.getSizeOfCriteria()[2]);
        dataFromAsset[8] = file.getOwnerFile();
        dataFromAsset[9] = converter.convertFileDateToDate(file.getCreationTime());
        dataFromAsset[10] = converter.convertFileDateToDate(file.getLastModifiedTime());
        dataFromAsset[11] = converter.convertFileDateToDate(file.getLastAccessTime());
    }

    /**
     * This method is complement of multimediaToTableResult.
     *
     * @param (dataFromAsset, file) .
     */
    private void multimediaToTableResult(Object[] dataFromAsset, Asset file) {
        // Setting Data
        MultimediaResult multimediaResult = (MultimediaResult) file;
        dataFromAsset[0] = multimediaResult.getName();
        dataFromAsset[1] = multimediaResult.getCodecLongName();
        Double value = (Math.ceil(multimediaResult.getrFrameRate().doubleValue()));
        String valueForCompare = value.intValue() + " fps";
        dataFromAsset[2] = valueForCompare;
        dataFromAsset[3] = multimediaResult.getDisplayAspect();
        dataFromAsset[4] = multimediaResult.getWidth() + "x" + multimediaResult.getHeight();
        dataFromAsset[5] = multimediaResult.getExtensionFile();
        dataFromAsset[6] = converter.convertTimeUnit(multimediaResult.getDuration(), searchWindows.getDurationMultimediaTime());
        dataFromAsset[7] = multimediaResult.getAudioCodecLongName();
        dataFromAsset[8] = multimediaResult.getAudioBitRate();
        dataFromAsset[9] = multimediaResult.getAudioChannels();
        dataFromAsset[10] = multimediaResult.getPathFile();
        dataFromAsset[11] = converter.convertSizeUnit(multimediaResult.getSizeFile(), searchWindows.getSizeOfCriteria()[2]);
    }
}
