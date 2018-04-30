/*
 * @(#)TopPanel.java
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
package com.fundation.search.view.MainWindow;

import com.fundation.search.common.SearchLogger;
import com.fundation.search.view.CriteriaPanels.CriteriaPanel;
import com.fundation.search.view.MainSearchWindows;
import com.fundation.search.view.SearchTextField;
import com.fundation.search.view.SearchToolBar;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class TopPanel extends JPanel {
    /**
     * Init logger  in Top Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * This is color to set all labels.
     */
    private static final Color FONT_COLOR = Color.WHITE;

    /**
     * Separator of System
     */
    private static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * searchTextField, Type: SearchTextField, this is input for initialize search.
     */
    private SearchTextField searchTextField;

    /**
     * toolbar, Type: SearchToolBar, this toolbar contains all buttons for set search.
     */
    private SearchToolBar toolbar;

    /**
     * searchButton, Type: JButton, this button is for Controller and send all data.
     */
    private JButton searchButton;

    /**
     * criteriaPanel, Type: CriteriaPanel, this contains all criteria panels.
     */
    private CriteriaPanel criteriaPanel;

    /**
     * constraints, Type: GridBagConstraints, this is initialize GridBag Layout.
     */
    private GridBagConstraints constraints;

    /**
     * searchJLabel, Type: JLabel, this is a plane text with "Search: ".
     */
    private JLabel searchJLabel;

    /**
     * Constructor for TopPanel.
     * This method is for initialize searchButton, setting layout and repaint panel.
     */
    public TopPanel() {
        LOOGER.info("Get top panel Entry");
        this.setOpaque(false);
        this.searchButton = new JButton(new ImageIcon(System.getProperty("user.dir") + SEPARATOR + "resources" + SEPARATOR + "icons" + SEPARATOR + "search.png"));
        this.searchButton.setOpaque(true);
        this.searchButton.setOpaque(false);
        //setup layout
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();
        LOOGER.info("top panel exit");
    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        LOOGER.info("Get init components");
        // Dynamic criteria JPanel.
        this.criteriaPanel = new CriteriaPanel();
        // JLabel "Search".
        this.searchJLabel = new JLabel("Search: ");
        this.searchJLabel.setForeground(FONT_COLOR);
        // JTextField with place holder.
        this.searchTextField = new SearchTextField("Searching...");
        // JToolbar with all buttons
        this.toolbar = new SearchToolBar(criteriaPanel);
        LOOGER.info("components exit");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add Components Entry");

        JPanel searchComponents = new JPanel(new FlowLayout());
        searchComponents.setOpaque(false);
        searchComponents.add(searchJLabel);
        searchComponents.add(searchTextField);
        searchComponents.add(searchButton);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(searchComponents, constraints);
        // Second Row only for add toolbar buttons.
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(toolbar, constraints);
        // Third Row only for add criteria dynamic JPanel.
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        this.add(criteriaPanel, constraints);
        LOOGER.info("add Components exit");
    }

    /**
     * This method is return Path criteria.
     *
     * @return String
     */
    public String getPathOfCriteria() {
        LOOGER.info("get path");
        return toolbar.getPathOfCriteria();
    }

    /**
     * This method is return Key Sensitive criteria.
     *
     * @return Boolean
     */
    public boolean getKeySensitiveOfCriteria() {
        LOOGER.info("get key sensitive");
        return toolbar.getKeySensitiveOfCriteria();
    }

    /**
     * This method is return Read Only criteria.
     *
     * @return Boolean
     */
    public boolean getReadOnlyOfCriteria() {
        LOOGER.info("get read only");
        return toolbar.getReadOnlyOfCriteria();
    }

    /**
     * This method is return File System criteria.
     *
     * @return Boolean
     */
    public boolean getFileSystemOfCriteria() {
        LOOGER.info("get file system");
        return toolbar.getFileSystemOfCriteria();
    }

    /**
     * This method is return Directory criteria.
     *
     * @return Boolean
     */
    public boolean getDirectoryOfCriteria() {
        LOOGER.info("get Directory");
        return toolbar.getDirectoryOfCriteria();
    }

    /**
     * This method is return Size criteria.
     *
     * @return Array String
     */
    public String[] getSizeOfCriteria() {
        LOOGER.info("get size");
        return toolbar.getSizeCriteria();
    }

    /**
     * This method is return Owner criteria.
     *
     * @return String
     */
    public String getOwnerOfCriteria() {
        LOOGER.info("get owner");
        return toolbar.getOwnerCriteria();
    }


    /**
     * This method is return Date Creation criteria.
     *
     * @return Date
     */
    public Date getDateCreationCriteria() {
        LOOGER.info("get date creation init");
        return toolbar.getDateCreationCriteria();
    }

    /**
     * This method is return Date to Creation criteria.
     *
     * @return Date
     */
    public Date getDateToCreationCriteria() {
        LOOGER.info("get date creation end");
        return toolbar.getDateToCreationCriteria();
    }

    /**
     * This method is return Date Modification criteria.
     *
     * @return Date
     */
    public Date getDateModificationCriteria() {
        LOOGER.info("get modified init");
        return toolbar.getDateModificationCriteria();
    }

    /**
     * This method is return Date Modification to criteria.
     *
     * @return Date
     */
    public Date getDateToModificationCriteria() {
        LOOGER.info("get modified end");
        return toolbar.getDateToModificationCriteria();
    }

    /**
     * This method is return Last Access criteria.
     *
     * @return Date
     */
    public Date getDateLastOpenedCriteria() {
        LOOGER.info("get last opened init");
        return toolbar.getDateLastOpenedCriteria();
    }

    /**
     * This method is return Last Access to Creation criteria.
     *
     * @return Date
     */
    public Date getDateToLastOpenedCriteria() {
        LOOGER.info("get last opened end");
        return toolbar.getDateToLastOpenedCriteria();
    }

    /**
     * This method is return File name criteria.
     *
     * @return String
     */
    public String getFileNameOfCriteria() {
        LOOGER.info("get file name");
        return toolbar.getFileNameOfCriteria();
    }

    /**
     * This method is for return Hidden criteria.
     *
     * @return String
     */
    public String getHiddenOfCriteria() {
        LOOGER.info("get hidden");
        return toolbar.getHiddenOfCriteria();
    }

    /**
     * This method is for return Type criteria.
     *
     * @return String
     */
    public String getTypeCriteria() {
        LOOGER.info("get type");
        return toolbar.getTypeCriteria();
    }

    /**
     * This method is for return Search button.
     *
     * @return JButton
     */
    public JButton getSearchButton() {
        LOOGER.info("get search button");
        return searchButton;
    }

    /**
     * This method is for return Search Text.
     *
     * @return String
     */
    public String getSearchText() {
        LOOGER.info("get search text");
        return searchTextField.getText();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isHiddenCriteria, this is hidden criteria.
     */
    public void setIsHiddenCriteria(String isHiddenCriteria) {
        this.toolbar.setIsHiddenCriteria(isHiddenCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param typeCriteria, this is type of size criteria.
     */
    public void setTypeCriteria(String typeCriteria) {
        this.toolbar.setTypeCriteria(typeCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param operatorCriteria, this is operator of size criteria.
     */
    public void setOperatorCriteria(String operatorCriteria) {
        this.toolbar.setOperatorCriteria(operatorCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param sizeCriteria, this is size criteria.
     */
    public void setSizeCriteria(long sizeCriteria) {
        this.toolbar.setSizeCriteria(sizeCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param isReadOnlyCriteria, this is Read Only criteria.
     */
    public void setIsReadOnlyCriteria(boolean isReadOnlyCriteria) {
        this.toolbar.setIsReadOnlyCriteria(isReadOnlyCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param isFileSystemCriteria, true is File System and false is not file system.
     */
    public void setIsFileSystemCriteria(boolean isFileSystemCriteria) {
        this.toolbar.setIsFileSystemCriteria(isFileSystemCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param isDirectoryCriteria, true is directory and false is not directory.
     */
    public void setIsDirectoryCriteria(boolean isDirectoryCriteria) {
        this.toolbar.setIsDirectoryCriteria(isDirectoryCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param fileNameCriteria, this is file name criteria.
     */
    public void setFileNameCriteria(String fileNameCriteria) {
        this.toolbar.setFileNameCriteria(fileNameCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param pathCriteria, this is path criteria.
     */
    public void setPathCriteria(String pathCriteria) {
        this.toolbar.setPathCriteria(pathCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param ownerCriteria, this is owner criteria.
     */
    public void setOwnerCriteria(String ownerCriteria) {
        this.toolbar.setOwnerCriteria(ownerCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param extensionCriteria, this is file extension criteria.
     */
    public void setExtensionCriteria(String extensionCriteria) {
        this.toolbar.setExtensionCriteria(extensionCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param nameCriteria, this is search words.
     */
    public void setNameCriteria(String nameCriteria) {
        this.searchTextField.setText(nameCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param modifiedDateInit, this is modified date init.
     */
    public void setModifiedDateInit(String modifiedDateInit) {
        this.toolbar.setModifiedDateInit(modifiedDateInit);
    }

    /**
     * This method is to update one criteria.
     *
     * @param modifiedDateEnd, this is modified date end.
     */
    public void setModifiedDateEnd(String modifiedDateEnd) {
        this.toolbar.setModifiedDateEnd(modifiedDateEnd);
    }

    /**
     * This method is to update one criteria.
     *
     * @param lastAccessInit, this is last access date end.
     */
    public void setLastAccessInit(String lastAccessInit) {
        this.toolbar.setLastAccessInit(lastAccessInit);
    }

    /**
     * This method is to update one criteria.
     *
     * @param lastAccessEnd, this is last access date end.
     */
    public void setLastAccessEnd(String lastAccessEnd) {
        this.toolbar.setLastAccessEnd(lastAccessEnd);
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateInit, this is creation date init.
     */
    public void setCreationDateInit(String creationDateInit) {
        this.toolbar.setCreationDateInit(creationDateInit);
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateEnd, this is creation date end.
     */
    public void setCreationDateEnd(String creationDateEnd) {
        this.toolbar.setCreationDateEnd(creationDateEnd);
    }

    /**
     * This method is to update one criteria.
     *
     * @param keySensitiveOfCriteria, this is key sensitive criteria.
     */
    public void setKeySensitiveOfCriteria(boolean keySensitiveOfCriteria) {
        this.toolbar.setKeySensitiveOfCriteria(keySensitiveOfCriteria);
    }

    /**
     * This method is to get contains criteria.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean getIsContainsInsideFileCriteria() {
        return toolbar.getIsContainsInsideFileCriteria();
    }

    /**
     * This method is to get contains criteria.
     *
     * @return String, text of contains criteria.
     */
    public String getTextContainsInsideFileCriteria() {
        return toolbar.getTextContainsInsideFileCriteria();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isContainsInsideFileCriteria, this is contains criteria.
     */
    public void setIsContainsInsideFileCriteria(boolean isContainsInsideFileCriteria) {
        this.toolbar.setIsContainsInsideFileCriteria(isContainsInsideFileCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param textContainsInsideFileCriteria, this is contains criteria.
     */
    public void setTextContainsInsideFileCriteria(String textContainsInsideFileCriteria) {
        this.toolbar.setTextContainsInsideFileCriteria(textContainsInsideFileCriteria);
    }

    public void resetAllDataOfDataDBTable() {
        LOOGER.info("reset all data of table data base result");
        this.toolbar.resetAllDataOfDataDBTable();
        LOOGER.info("reset all data of table result exit");
    }

    public void insertRowToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        this.toolbar.insertRowToDataBaseTableResult(row);
    }

    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria");
        return toolbar.getNameOfCriteriaToSaveOnDataBase();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return toolbar.getSaveButtonOnDataBasePanel();
    }

    /**
     * This method return Load JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return toolbar.getLoadButtonOnDataBasePanel();
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return toolbar.getFillButtonOnDataBasePanel();
    }

    /**
     * This method return selection model of Data Base Table result.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public ListSelectionModel getSelectionModel() {
        return toolbar.getSelectionModel();
    }

    /**
     * This method return Data Base Table result.
     * Controller need use this.
     *
     * @return JTable, this is a Data Base JTable.
     */
    public JTable getDataBaseTableResult() {
        return toolbar.getDataBaseTableResult();
    }

    /**
     * This method is for return Delete JButton.
     *
     * @return JButton, this is Delete button of Data Base
     */
    public JButton getDeleteButtonOnDataBasePanel() {
        return this.toolbar.getDeleteButtonOnDataBasePanel();
    }

    /**
     * This method is for return Duration Multimedia critera.
     *
     * @return String, this comparator for multimedia filter.
     */
    public String getDurationMultimediaCriteria() {
        return this.toolbar.getDurationMultimediaCriteria();
    }

    /**
     * This method is for return Duration Multimedia Number.
     *
     * @return String, this is number for filter multimedia files.
     */
    public String getDurationMultimediaNumber() {
        return this.toolbar.getDurationMultimediaNumber();
    }

    /**
     * This method is for return Duration Multimedia Time.
     *
     * @return String, this is type time {seconds,minutes,hours}.
     */
    public String getDurationMultimediaTime() {
        return this.toolbar.getDurationMultimediaTime();
    }

    /**
     * This method is for return Frame Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getFrameRateCriteria() {
        return this.toolbar.getFrameRateCriteria();
    }

    /**
     * This method is for return Video Codec Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getVideoCodecCriteria() {
        return this.toolbar.getVideoCodecCriteria();
    }

    /**
     * This method is for return Resolution Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getResolutionCriteria() {
        return this.toolbar.getResolutionCriteria();
    }


    /**
     * This method is for return Audio Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getMultimediaTypeCriteria() {
        return toolbar.getMultimediaTypeCriteria();
    }

    /**
     * This method is return is search multimedia actived.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean isSearchMultimedia() {
        return toolbar.isSearchMultimedia();
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String
     */
    public String getAudioBitRateInit() {
        return this.toolbar.getAudioBitRateInit();
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String
     */
    public String getAudioBitRateEnd() {
        return this.toolbar.getAudioBitRateEnd();
    }

    /**
     * This method is to update duration criteria.
     *
     * @param multimediaDurationCriteria, this duration criteria "Major to:", "Minor to:" and "Equal to:"
     */
    public void setMultimediaDurationCriteria(String multimediaDurationCriteria) {
        this.toolbar.setMultimediaDurationCriteria(multimediaDurationCriteria);
    }

    /**
     * This method is to update duration number criteria.
     *
     * @param multimediaDurationNumber, this duration number.
     */
    public void setMultimediaDurationNumber(String multimediaDurationNumber) {
        this.toolbar.setMultimediaDurationNumber(multimediaDurationNumber);
    }

    /**
     * This method is to update duration type criteria.
     *
     * @param multimediaDurationType, this duration type.
     */
    public void setMultimediaDurationType(String multimediaDurationType) {
        this.toolbar.setMultimediaDurationType(multimediaDurationType);
    }

    /**
     * This method is to update duration Frame Rate criteria.
     *
     * @param multimediaDurationFrameRate, this is ArrayList with all data.
     */
    public void setMultimediaFrameRate(ArrayList<String> multimediaDurationFrameRate) {
        this.toolbar.setMultimediaFrameRate(multimediaDurationFrameRate);
    }

    /**
     * This method is to update duration VideoCodec criteria.
     *
     * @param multimediaDurationVideoCodec, this is ArrayList with all data.
     */
    public void setMultimediaDurationVideoCodec(ArrayList<String> multimediaDurationVideoCodec) {
        this.toolbar.setMultimediaDurationVideoCodec(multimediaDurationVideoCodec);
    }

    /**
     * This method is to update duration VideoCodec criteria.
     *
     * @param multimediaDurationResolution, this is ArrayList with all data.
     */
    public void setMultimediaResolution(ArrayList<String> multimediaDurationResolution) {
        this.toolbar.setMultimediaResolution(multimediaDurationResolution);
    }

    /**
     * This method is to update duration VideoCodec criteria.
     *
     * @param multimediaType, this is ArrayList with all data.
     */
    public void setMultimediaType(ArrayList<String> multimediaType) {
        this.toolbar.setMultimediaType(multimediaType);
    }

    /**
     * This method is to update init Audio bit rate criteria.
     *
     * @param multimediaAudioBitRateInit, this audio bit rate.
     */
    public void setMultimediaAudioBitRateInit(String multimediaAudioBitRateInit) {
        this.toolbar.setMultimediaAudioBitRateInit(multimediaAudioBitRateInit);
    }

    /**
     * This method is to update end Audio bit rate criteria.
     *
     * @param multimediaAudioBitRateEnd, this audio bit rate.
     */
    public void setMultimediaAudioBitRateEnd(String multimediaAudioBitRateEnd) {
        this.toolbar.setMultimediaAudioBitRateEnd(multimediaAudioBitRateEnd);
    }
}
