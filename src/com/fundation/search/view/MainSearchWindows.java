/*
 * @(#)MainSearchWindows.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.view;

import com.fundation.search.common.SearchLogger;
import com.fundation.search.view.MainWindow.BottomPanel;
import com.fundation.search.view.MainWindow.CenterPanel;
import com.fundation.search.view.MainWindow.TopPanel;

import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.JTableHeader;
import java.util.Date;

/**
 * This class main windows.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MainSearchWindows extends JFrame {
    /**
     * Init logger  in Main Search Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * topPanel, Type: TopPanel, this is top panel of main windows.
     */
    private TopPanel topPanel;

    /**
     * centerPanel, Type: CenterPanel, this is center panel of main windows.
     */
    private CenterPanel centerPanel;

    /**
     * bottomPanel, Type: CenterPanel, this is center panel of main windows.
     */
    private BottomPanel bottomPanel;

    /**
     * Constructor for MainSearchWindows.
     */
    public MainSearchWindows() {
        super();
    }

    /**
     * This method is for initialize all components on main windows.
     */
    public void initWindows() {
        LOOGER.info("Get init");

        // Setting tittle of application.
        this.setTitle("Search Application");

        // Initialize Top and Center Panel, you need add new Bottom panel for new functionalities.
        this.topPanel = new TopPanel();
        this.centerPanel = new CenterPanel();
        this.bottomPanel = new BottomPanel();

        // Setting Border Layout and repaint.
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();

        // Setting main windows <= maybe you could be this dynamic.

        final int width = 1300;
        final int height = 900;
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        LOOGER.info("init exit");
    }

    /**
     * This method return word on SearchJTextField.
     * Controller need use this.
     *
     * @return String, this is a text on SearchJTextField.
     */
    public String getSearchText() {
        LOOGER.info("Get SearchText");
        return topPanel.getSearchText();
    }

    /**
     * This method return Search JButton.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Top pane.
     */
    public JButton getSearchButton() {
        LOOGER.info("Get search button");
        return topPanel.getSearchButton();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathOfCriteria() {
        LOOGER.info("Get Path");
        return topPanel.getPathOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete Key Sensitive for search files.
     */
    public boolean getKeySensitiveOfCriteria() {
        LOOGER.info("Get key Sensitive");
        return topPanel.getKeySensitiveOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete Read only for search files.
     */

    public boolean getReadOnlyOfCriteria() {
        LOOGER.info("Get Read only");
        return topPanel.getReadOnlyOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete File System for search files.
     */
    public boolean getFileSystemOfCriteria() {
        LOOGER.info("Get File System");
        return topPanel.getFileSystemOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete Directory for search files.
     */
    public boolean getDirectoryOfCriteria() {
        LOOGER.info("Get directory");
        return topPanel.getDirectoryOfCriteria();
    }

    /**
     * This method is for return size.
     * Controller nee ise this.
     *
     * @return array String, this contains a complete path for search files.
     */
    public String[] getSizeOfCriteria() {
        LOOGER.info("Get size");
        return topPanel.getSizeOfCriteria();
    }

    /**
     * This method is for return type.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getTypeCriteria() {
        LOOGER.info("Get type");
        return topPanel.getTypeCriteria();
    }

    /**
     * This method is for return owner.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getOwnerOfCriteria() {
        LOOGER.info("Get Owner");
        return topPanel.getOwnerOfCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getCreationDateInit() {
        LOOGER.info("Get Date creation init");
        return topPanel.getDateCreationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getCreationDateEnd() {
        LOOGER.info("Get date creation end");
        return topPanel.getDateToCreationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getModifiedDateInit() {
        LOOGER.info("Get modified init");
        return topPanel.getDateModificationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getModifiedDateEnd() {
        LOOGER.info("Get modified end");
        return topPanel.getDateToModificationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getLastAccessDateInit() {
        LOOGER.info("Get last access init");
        return topPanel.getDateLastOpenedCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getLastAccessDateEnd() {
        LOOGER.info("Get last access end");
        return topPanel.getDateToLastOpenedCriteria();
    }

    /**
     * This method return Hidden File criteria.
     * Controller nee ise this.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameOfCriteria() {
        LOOGER.info("Get file name");
        return topPanel.getFileNameOfCriteria();
    }

    /**
     * This method is to get state of hiddenFile.
     * Controller nee ise this.
     *
     * @return String, ""all files",""only hidden files",""without hidden files".
     */
    public String getHiddenOfCriteria() {
        LOOGER.info("Get hidden ");
        return topPanel.getHiddenOfCriteria();
    }

    /**
     * This method is for insert one row to JTableResult.
     * Controller need use this.
     *
     * @param row, this row contains all values for insert to table result.
     */
    public void insertDataOfJTableResult(Object[] row) {
        LOOGER.info("Insert data to table result");
        centerPanel.insertRowToJTableResult(row);
    }

    /**
     * This method is for reset all values of JTableResult.
     * Controller can use this.
     */
    public void resetDataOfJTableResult() {
        LOOGER.info("get reset table");
        centerPanel.resetAllDataOfTableResult();
    }

    /**
     * This method is for reset all values of Data Base Table Result.
     * Controller can use this.
     */
    public void resetDataOfDataBaseTableResult() {
        LOOGER.info("get reset table");
        topPanel.resetAllDataOfDataDBTable();
    }

    /**
     * This method is for insert one row to Data Base Table Result.
     * Controller need use this.
     *
     * @param row, this row contains all values for insert to table result.
     */
    public void insertDataToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        topPanel.insertRowToDataBaseTableResult(row);
    }

    /**
     * This method return name of criteria to save on data base.
     * Controller need use this.
     *
     * @return String, this is a text.
     */
    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria");
        return topPanel.getNameOfCriteriaToSaveOnDataBase();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return topPanel.getSaveButtonOnDataBasePanel();
    }

    /**
     * This method return Load JButton on Data Base Panel.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return topPanel.getLoadButtonOnDataBasePanel();
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return topPanel.getFillButtonOnDataBasePanel();
    }

    /**
     * This method return selection model of Data Base Table Result.
     * Controller need use this.
     *
     * @return ListSelectionModel, ListSelectionmodel from Data Base Table Result.
     */
    public ListSelectionModel getSelectionModelOfDataBaseTableResult() {
        return topPanel.getSelectionModel();
    }

    /**
     * This method return Data Base Table result.
     * Controller need use this.
     *
     * @return JTable, this is a Data Base JTable.
     */
    public JTable getDataBaseTableResult() {
        return topPanel.getDataBaseTableResult();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isHiddenCriteria, this is hidden criteria.
     */
    public void setIsHiddenCriteria(String isHiddenCriteria) {
        this.topPanel.setIsHiddenCriteria(isHiddenCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param typeCriteria, this is type of size criteria.
     */
    public void setTypeCriteria(String typeCriteria) {
        this.topPanel.setTypeCriteria(typeCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param operatorCriteria, this is operator of size criteria.
     */
    public void setOperatorCriteria(String operatorCriteria) {
        this.topPanel.setOperatorCriteria(operatorCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param sizeCriteria, this is size criteria.
     */
    public void setSizeCriteria(long sizeCriteria) {
        this.topPanel.setSizeCriteria(sizeCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isReadOnlyCriteria, this is Read Only criteria.
     */
    public void setIsReadOnlyCriteria(boolean isReadOnlyCriteria) {
        this.topPanel.setIsReadOnlyCriteria(isReadOnlyCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isFileSystemCriteria, true is File System and false is not file system.
     */
    public void setIsFileSystemCriteria(boolean isFileSystemCriteria) {
        this.topPanel.setIsFileSystemCriteria(isFileSystemCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isDirectoryCriteria, true is directory and false is not directory.
     */
    public void setIsDirectoryCriteria(boolean isDirectoryCriteria) {
        this.topPanel.setIsDirectoryCriteria(isDirectoryCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param fileNameCriteria, this is file name criteria.
     */
    public void setFileNameCriteria(String fileNameCriteria) {
        this.topPanel.setFileNameCriteria(fileNameCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param pathCriteria, this is path criteria.
     */
    public void setPathCriteria(String pathCriteria) {
        this.topPanel.setPathCriteria(pathCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param ownerCriteria, this is owner criteria.
     */
    public void setOwnerCriteria(String ownerCriteria) {
        this.topPanel.setOwnerCriteria(ownerCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param extensionCriteria, this is file extension criteria.
     */
    public void setExtensionCriteria(String extensionCriteria) {
        this.topPanel.setExtensionCriteria(extensionCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param nameCriteria, this is search words.
     */
    public void setNameCriteria(String nameCriteria) {
        this.topPanel.setNameCriteria(nameCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param modifiedDateInit, this is modified date init.
     */
    public void setModifiedDateInit(String modifiedDateInit) {
        this.topPanel.setModifiedDateInit(modifiedDateInit);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param modifiedDateEnd, this is modified date end.
     */
    public void setModifiedDateEnd(String modifiedDateEnd) {
        this.topPanel.setModifiedDateEnd(modifiedDateEnd);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param lastAccessInit, this is last access date end.
     */
    public void setLastAccessInit(String lastAccessInit) {
        this.topPanel.setLastAccessInit(lastAccessInit);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param lastAccessEnd, this is last access date end.
     */
    public void setLastAccessEnd(String lastAccessEnd) {
        this.topPanel.setLastAccessEnd(lastAccessEnd);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param creationDateInit, this is creation date init.
     */
    public void setCreationDateInit(String creationDateInit) {
        this.topPanel.setCreationDateInit(creationDateInit);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param creationDateEnd, this is creation date end.
     */
    public void setCreationDateEnd(String creationDateEnd) {
        this.topPanel.setCreationDateEnd(creationDateEnd);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param keySensitiveOfCriteria, this is key sensitive criteria.
     */
    public void setKeySensitiveOfCriteria(boolean keySensitiveOfCriteria) {
        this.topPanel.setKeySensitiveOfCriteria(keySensitiveOfCriteria);
    }

    /**
     * This method is to get contains criteria.
     * Controller need use this.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean getIsContainsInsideFileCriteria() {
        return topPanel.getIsContainsInsideFileCriteria();
    }

    /**
     * This method is to get contains criteria.
     * Controller need use this.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public String getTextContainsInsideFileCriteria() {
        return topPanel.getTextContainsInsideFileCriteria();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isContainsInsideFileCriteria, this is contains criteria.
     */
    public void setIsContainsInsideFileCriteria(boolean isContainsInsideFileCriteria) {
        this.topPanel.setIsContainsInsideFileCriteria(isContainsInsideFileCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param textContainsInsideFileCriteria, this is contains criteria.
     */
    public void setTextContainsInsideFileCriteria(String textContainsInsideFileCriteria) {
        this.topPanel.setTextContainsInsideFileCriteria(textContainsInsideFileCriteria);
    }

    /**
     * This method is for return Delete JButton.
     * Controller need use this.
     *
     * @return JButton, this is Delete button of Data Base
     */
    public JButton getDeleteButtonOnDataBasePanel() {
        return this.topPanel.getDeleteButtonOnDataBasePanel();
    }

    /**
     * This method is for return Duration Multimedia critera.
     * Controller need use this.
     *
     * @return String, this comparator for multimedia filter.
     */
    public String getDurationMultimediaCriteria() {
        return this.topPanel.getDurationMultimediaCriteria();
    }

    /**
     * This method is for return Duration Multimedia Number.
     * Controller need use this.
     *
     * @return String, this is number for filter multimedia files.
     */
    public String getDurationMultimediaNumber() {
        return this.topPanel.getDurationMultimediaNumber();
    }

    /**
     * This method is for return Duration Multimedia Time.
     * Controller need use this.
     *
     * @return String, this is type time {seconds,minutes,hours}.
     */
    public String getDurationMultimediaTime() {
        return this.topPanel.getDurationMultimediaTime();
    }

    /**
     * This method is for return Frame Rate Array.
     * Controller need use this.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getFrameRateCriteria() {
        return this.topPanel.getFrameRateCriteria();
    }

    /**
     * This method is for return Video Codec Array.
     * Controller need use this.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getVideoCodecCriteria() {
        return this.topPanel.getVideoCodecCriteria();
    }

    /**
     * This method is for return Resolution Array.
     * Controller need use this.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getResolutionCriteria() {
        return this.topPanel.getResolutionCriteria();
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String
     */
    public String getAudioBitRateInit() {
        return this.topPanel.getAudioBitRateInit();
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String
     */
    public String getAudioBitRateEnd() {
        return this.topPanel.getAudioBitRateEnd();
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getMultimediaTypeCriteria() {
        return topPanel.getMultimediaTypeCriteria();
    }

    /**
     * This method is return is search multimedia actived.
     * Controller need use this.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean isSearchMultimedia() {
        return topPanel.isSearchMultimedia();
    }

    /**
     * This method is to change columns tittle for file.
     * Controller need use this.
     */
    public void setColumnsTittleToFile(){
        this.centerPanel.updateColumnsTittleToFile();
    }

    /**
     * This method is to change columns tittle for Multimedia.
     * Controller need use this.
     */
    public void setColumnsTittleToMultimedia(){
        this.centerPanel.updateColumnsTittleToMultimedia();
    }

    /**
     * This method is to update duration criteria.
     * Controller need use this.
     *
     * @param multimediaDurationCriteria, this duration criteria "Major to:", "Minor to:" and "Equal to:"
     */
    public void setMultimediaDurationCriteria(String multimediaDurationCriteria) {
        this.topPanel.setMultimediaDurationCriteria(multimediaDurationCriteria);
    }

    /**
     * This method is to update duration number criteria.
     * Controller need use this.
     *
     * @param multimediaDurationNumber, this duration number.
     */
    public void setMultimediaDurationNumber(String multimediaDurationNumber) {
        this.topPanel.setMultimediaDurationNumber(multimediaDurationNumber);
    }

    /**
     * This method is to update duration type criteria.
     * Controller need use this.
     *
     * @param multimediaDurationType, this duration type.
     */
    public void setMultimediaDurationType(String multimediaDurationType) {
        this.topPanel.setMultimediaDurationType(multimediaDurationType);
    }

    /**
     * This method is to update duration Frame Rate criteria.
     * Controller need use this.
     *
     * @param multimediaDurationFrameRate, this is ArrayList with all data.
     */
    public void setMultimediaFrameRate(ArrayList<String>  multimediaDurationFrameRate) {
        this.topPanel.setMultimediaFrameRate(multimediaDurationFrameRate);
    }

    /**
     * This method is to update duration VideoCodec criteria.
     * Controller need use this.
     *
     * @param multimediaDurationVideoCodec, this is ArrayList with all data.
     */
    public void setMultimediaDurationVideoCodec(ArrayList<String>  multimediaDurationVideoCodec) {
        this.topPanel.setMultimediaDurationVideoCodec(multimediaDurationVideoCodec);
    }

    /**
     * This method is to update duration VideoCodec criteria.
     * Controller need use this.
     *
     * @param multimediaDurationResolution, this is ArrayList with all data.
     */
    public void setMultimediaResolution(ArrayList<String>  multimediaDurationResolution) {
        this.topPanel.setMultimediaResolution(multimediaDurationResolution);
    }

    /**
     * This method is to update duration VideoCodec criteria.
     * Controller need use this.
     *
     * @param multimediaType, this is ArrayList with all data.
     */
    public void setMultimediaType(ArrayList<String>  multimediaType) {
        this.topPanel.setMultimediaType(multimediaType);
    }

    /**
     * This method is to update init Audio bit rate criteria.
     * Controller need use this.
     *
     * @param multimediaAudioBitRateInit, this audio bit rate.
     */
    public void setMultimediaAudioBitRateInit(String multimediaAudioBitRateInit) {
        this.topPanel.setMultimediaAudioBitRateInit(multimediaAudioBitRateInit);
    }

    /**
     * This method is to update end Audio bit rate criteria.
     * Controller need use this.
     *
     * @param multimediaAudioBitRateEnd, this audio bit rate.
     */
    public void setMultimediaAudioBitRateEnd(String multimediaAudioBitRateEnd) {
        this.topPanel.setMultimediaAudioBitRateEnd(multimediaAudioBitRateEnd);
    }

    /**
     * This method is to set result process.
     * Controller need use this.
     *
     * @param resultProcessTextField this is text to result process.
     */
    public void setResultProcessTextField(String resultProcessTextField) {
        this.centerPanel.setResultProcessTextField(resultProcessTextField);
    }

}
