/*
 * @(#)SearchToolBar.java
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
import com.fundation.search.view.CriteriaPanels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.logging.Logger;

/**
 * This class is for create buttons inside to JToolBar.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchToolBar extends JToolBar {
    /**
     * Init logger  in SearchToolBar
     */

    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Separator of System
     */
    private static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * toggleButtonCollection, Type: Collection<JToggleButton>, this is a collection of buttons.
     */
    private Collection<JToggleButton> toggleButtonCollection;

    /**
     * action, Type: String, this is action of one button.
     */
    private String action;

    /**
     * criteriaPanel, Type: CriteriaPanel, this criteria panel.
     */
    private CriteriaPanel criteriaPanel;

    /**
     * panelList, Type: Map<String, JPanel>, this is a Map of panels.
     */
    private Map<String, JPanel> panelList;

    /**
     * FILE_NAME_PANEL, Type: FileNamePanel, this is a File Name criteria Panel
     */
    private static final FileNamePanel FILE_NAME_PANEL = new FileNamePanel();

    /**
     * PATH_PANEL, Type: PathPanel, this Path criteria Panel.
     */
    private static final PathPanel PATH_PANEL = new PathPanel();

    /**
     * HIDDEN_PANEL, Type: HiddenPanel, this Hidden criteria Panel.
     */
    private static final HiddenPanel HIDDEN_PANEL = new HiddenPanel();

    /**
     * SIZE_PANEL, Type: SizePanel, this Size criteria Panel.
     */
    private static final SizePanel SIZE_PANEL = new SizePanel();

    /**
     * OWNER_PANEL, Type: OwnerPanel, this Owner criteria Panel.
     */
    private static final OwnerPanel OWNER_PANEL = new OwnerPanel();

    /**
     * DATE_PANEL, Type: DatePanel, this Date criteria Panel.
     */
    private static final DatePanel DATE_PANEL = new DatePanel();

    /**
     * TYPE_PANEL, Type: DatePanel, this Type criteria Panel.
     */
    private static final TypePanel TYPE_PANEL = new TypePanel();

    /**
     * DB_PANEL, Type: DatePanel, this Type criteria Panel.
     */
    private static final DataBasePanel DB_PANEL = new DataBasePanel();

    /**
     * MULTIMEDIA, Type: MultimediaPanel, this is Multimedia Panel.
     */
    private static final MultimediaPanel MULTIMEDIA = new MultimediaPanel();

    /**
     * isSearchMultimedia, Type: boolean, true when multimedia panel is actived, false when multimedia panel is not actived.
     */
    private boolean isSearchMultimedia;

    /**
     * Constructor for SearchToolBar.
     * This method is for initialize toggleButtonCollection, action, criteriaPanel and panelList.
     */
    public SearchToolBar(CriteriaPanel criteriaPanel) {
        LOOGER.info("Get Result Entry");
        // This is a collection of buttons.
        this.toggleButtonCollection = new Vector<>();
        this.isSearchMultimedia = false;
        // Action for define button.
        this.action = "";
        // Dynamic JPanel for add all button panels.
        this.criteriaPanel = criteriaPanel;
        // Hashtable of all Criteria Panels
        this.panelList = new Hashtable<>();
        // Adding components
        this.addComponents();
        LOOGER.info("Constructor exit");
    }

    /**
     * Method for add al components.
     */
    private void addComponents() {
        LOOGER.info("Get add Components");
        // adding buttons
        this.addButtonToToggleCollection("All Tags");
        this.addButtonToToggleCollection("File Name");
        this.addButtonToToggleCollection("Path");
        this.addButtonToToggleCollection("Hidden");
        this.addButtonToToggleCollection("Type");
        this.addButtonToToggleCollection("Size");
        this.addButtonToToggleCollection("Owner");
        this.addButtonToToggleCollection("Date");
        this.addButtonToToggleCollection("Multimedia");
        this.addButtonToToggleCollection("Data Base");
        // you need implements others buttons here.

        // Adding action listeners for all buttons
        this.addActionListeners();
        LOOGER.info("add Components exit");
    }

    /**
     * Method addActionListeners.
     */
    private void addActionListeners() {
        LOOGER.info("Get addActionListeners");
        // lambda is amazing..!! XD
        toggleButtonCollection
                .forEach(e -> e.addActionListener(this::actionListenerForAllButtons));
        LOOGER.info("addActionListeners exit");

    }

    /**
     * Method addActionListeners.
     *
     * @param actionEvent This is action event.
     */
    private void actionListenerForAllButtons(ActionEvent actionEvent) {
        LOOGER.info("Get addActionListeners of buttons init");
        JToggleButton sourceButton = (JToggleButton) actionEvent.getSource();
        // Action when a button is selected.
        String newAction = sourceButton.isSelected() ? actionEvent.getActionCommand() : "";
        firePropertyChange("action", action, newAction);
        action = actionEvent.getActionCommand();
        if (sourceButton.isSelected()) {
            this.addingCriteriaPanelToActionListenerButton();
        } else {
            this.removingCriteriaPanelToActionListenerButton();
            criteriaPanel.setBorderCriteriaPanel(null);
        }

        // updating button states
        for(JToggleButton toggleButton: toggleButtonCollection){
            if(!toggleButton.equals(sourceButton)){
                toggleButton.setSelected(false);

            }
        }

        criteriaPanel.addComponent(panelList);
        LOOGER.info("addActionListeners of buttons exit");
    }

    /**
     * Method for remove criteria panel.
     */
    private void removingCriteriaPanelToActionListenerButton() {
        LOOGER.info("remove criteria Action listener of buttons init");
        System.out.println(action);
        // Removing "All Tags Panel Criteria"
        if (action.equalsIgnoreCase("All Tags")) {
            panelList = new Hashtable<>();
        }
        // Removing "File Name Panel Criteria"
        if (action.equalsIgnoreCase("File Name")) {
            panelList.remove(action);
        }
        // Removing "Path Panel Criteria"
        if (action.equalsIgnoreCase("Path")) {
            panelList.remove(action);
        }
        // Removing "Hidden Panel Criteria"
        if (action.equalsIgnoreCase("Hidden")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Type")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Size")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Owner")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Date")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Data Base")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Multimedia")) {
            isSearchMultimedia= false;
            panelList.remove(action);
        }
        LOOGER.info("remove criteria listener of buttons exit");
    }

    /**
     * Method for add criteria panel to panelList.
     */
    private void addingCriteriaPanelToActionListenerButton() {
        LOOGER.info("add criteria panel  action of button");
        panelList = new HashMap<>();
        // Adding "All Tags Panel Criteria"
        if (action.equalsIgnoreCase("All Tags")) {
            panelList.put("File Name", FILE_NAME_PANEL);
            panelList.put("Path", PATH_PANEL);
            panelList.put("Hidden", HIDDEN_PANEL);
            panelList.put("Size", SIZE_PANEL);
            panelList.put("Owner", OWNER_PANEL);
            panelList.put("Date", DATE_PANEL);
            panelList.put("Type", TYPE_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }

        // Adding "File Name Panel Criteria"
        if (action.equalsIgnoreCase("File Name")) {
            panelList.put(action, FILE_NAME_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        // Adding "Path Panel Criteria"
        if (action.equalsIgnoreCase("Path")) {
            panelList.put(action, PATH_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        // Adding "Hidden Panel Criteria"
        if (action.equalsIgnoreCase("Hidden")) {
            panelList.put(action, HIDDEN_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        // Adding "Size Panel Criteria"
        if (action.equalsIgnoreCase("Size")) {
            panelList.put(action, SIZE_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        // Adding "Owner Panel Criteria"
        if (action.equalsIgnoreCase("Owner")) {
            panelList.put(action, OWNER_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        // Adding "Date Panel Criteria"
        if (action.equalsIgnoreCase("Date")) {
            panelList.put(action, DATE_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        if (action.equalsIgnoreCase("Type")) {
            panelList.put(action, TYPE_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }

        if (action.equalsIgnoreCase("Multimedia")) {
            isSearchMultimedia = true;
            panelList.put(action, MULTIMEDIA);
            criteriaPanel.setBorderCriteriaPanel(action);
        }

        if (action.equalsIgnoreCase("Data Base")) {
            panelList.put(action, DB_PANEL);
            criteriaPanel.setBorderCriteriaPanel(action);
            isSearchMultimedia= false;
        }
        LOOGER.info("exit criteria panel  action of button");
    }

    /**
     * Method addButtonToToggleCollection.
     * This method is for JToggleButtons to Collection.
     *
     * @param nameOfJToggleButton Name of JToggleButton to add collection.
     */
    private void addButtonToToggleCollection(String nameOfJToggleButton) {
        LOOGER.info("add button to toggle collection");
        JToggleButton buttonToAddCollection = new JToggleButton(nameOfJToggleButton);
        this.updateIcon(buttonToAddCollection,nameOfJToggleButton);
        this.add(buttonToAddCollection);
        this.toggleButtonCollection.add(buttonToAddCollection);
        LOOGER.info("exit button to toggle collection");
    }

    private void updateIcon(JToggleButton buttonToAddCollection, String nameOfJToggleButton) {
        if("All Tags".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"alltags.png"));
        }
        if("Path".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"path.png"));
        }
        if("Hidden".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"hidden.png"));
        }
        if("Size".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"size.png"));
        }
        if("Owner".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"owner.png"));
        }
        if("Date".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"date.png"));
        }
        if("Type".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"type.png"));
        }
        if("Data Base".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"database.png"));
        }
        if("File Name".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"name.png"));
        }
        if("Multimedia".equalsIgnoreCase(nameOfJToggleButton)){
            buttonToAddCollection.setIcon(new ImageIcon(System.getProperty("user.dir")+SEPARATOR+"resources"+SEPARATOR+"icons"+SEPARATOR+"video.png"));
        }

    }

    /**
     * This method is for return path.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathOfCriteria() {
        LOOGER.info("get path");
        return PATH_PANEL.getPathCriteria();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains a read only files.
     */
    public boolean getReadOnlyOfCriteria() {
        LOOGER.info("get read only");
        return PATH_PANEL.getReadOnlyOfCriteria();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains a File System files.
     */
    public boolean getFileSystemOfCriteria() {
        LOOGER.info("get file system");
        return PATH_PANEL.getFileSystemOfCriteria();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains a Directory files.
     */
    public boolean getDirectoryOfCriteria() {
        LOOGER.info("get directory");
        return PATH_PANEL.getDirectoryOfCriteria();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains a Key Sensitive files.
     */
    public boolean getKeySensitiveOfCriteria() {
        LOOGER.info("get key sensitive");
        return PATH_PANEL.getKeySensitiveOfCriteria();
    }

    /**
     * This method is for return Size.
     *
     * @return Array String, this contains a complete path for search files.
     */
    public String[] getSizeCriteria() {
        LOOGER.info("get size");
        return SIZE_PANEL.getSizeCriteria();
    }

    /**
     * This method is for return owner.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getOwnerCriteria() {
        LOOGER.info("get owner");
        return OWNER_PANEL.getOwnerCriteria();
    }

    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateCreationCriteria() {
        LOOGER.info("get date creation");
        return DATE_PANEL.getDateCreationCriteria();
    }

    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateToCreationCriteria() {
        LOOGER.info("get date creation to");
        return DATE_PANEL.getDateToCreationCriteria();
    }

    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateModificationCriteria() {
        LOOGER.info("get modified init");
        return DATE_PANEL.getDateModificationCriteria();
    }

    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateToModificationCriteria() {
        LOOGER.info("get modified end");
        return DATE_PANEL.getDateToModificationCriteria();
    }

    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateLastOpenedCriteria() {
        LOOGER.info("get last access init");
        return DATE_PANEL.getDateLastOpenedCriteria();
    }

    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateToLastOpenedCriteria() {
        LOOGER.info("get last access end");
        return DATE_PANEL.getDateToLastOpenedCriteria();
    }

    /**
     * This method return Hidden File criteria.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameOfCriteria() {
        LOOGER.info("get file name");
        return FILE_NAME_PANEL.getFileNameCriteria();
    }

    /**
     * This method is to get state of hiddenFile.
     * Controller nee ise this.
     *
     * @return String, ""all files",""only hidden files",""without hidden files".
     */
    public String getHiddenOfCriteria() {
        LOOGER.info("get hidden");
        return HIDDEN_PANEL.getHiddenCriteria();
    }

    /**
     * This method return Type criteria.
     *
     * @return String, this contains a complete path for type files.
     */
    public String getTypeCriteria() {
        LOOGER.info("get type");
        return TYPE_PANEL.getTypeCriteria();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isHiddenCriteria, this is hidden criteria.
     */
    public void setIsHiddenCriteria(String isHiddenCriteria) {
        this.HIDDEN_PANEL.setIsHiddenCriteria(isHiddenCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param typeCriteria, this is type of size criteria.
     */
    public void setTypeCriteria(String typeCriteria) {
        this.SIZE_PANEL.setTypeCriteria(typeCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param operatorCriteria, this is operator of size criteria.
     */
    public void setOperatorCriteria(String operatorCriteria) {
        this.SIZE_PANEL.setOperatorCriteria(operatorCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param sizeCriteria, this is size criteria.
     */
    public void setSizeCriteria(long sizeCriteria) {
        this.SIZE_PANEL.setSizeCriteria(sizeCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param isReadOnlyCriteria, this is Read Only criteria.
     */
    public void setIsReadOnlyCriteria(boolean isReadOnlyCriteria) {
        this.PATH_PANEL.setIsReadOnlyCriteria(isReadOnlyCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param isFileSystemCriteria, true is File System and false is not file system.
     */
    public void setIsFileSystemCriteria(boolean isFileSystemCriteria) {
        this.PATH_PANEL.setIsFileSystemCriteria(isFileSystemCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param isDirectoryCriteria, true is directory and false is not directory.
     */
    public void setIsDirectoryCriteria(boolean isDirectoryCriteria) {
        this.PATH_PANEL.setIsDirectoryCriteria(isDirectoryCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param fileNameCriteria, this is file name criteria.
     */
    public void setFileNameCriteria(String fileNameCriteria) {
        this.FILE_NAME_PANEL.setFileNameCriteria(fileNameCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param pathCriteria, this is path criteria.
     */
    public void setPathCriteria(String pathCriteria) {
        this.PATH_PANEL.setPathCriteria(pathCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param ownerCriteria, this is owner criteria.
     */
    public void setOwnerCriteria(String ownerCriteria) {
        this.OWNER_PANEL.setOwnerCriteria(ownerCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param extensionCriteria, this is file extension criteria.
     */
    public void setExtensionCriteria(String extensionCriteria) {
        this.TYPE_PANEL.setExtensionCriteria(extensionCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param modifiedDateInit, this is modified date init.
     */
    public void setModifiedDateInit(String modifiedDateInit) {
        this.DATE_PANEL.setModifiedDateInit(modifiedDateInit);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param modifiedDateEnd, this is modified date end.
     */
    public void setModifiedDateEnd(String modifiedDateEnd) {
        this.DATE_PANEL.setModifiedDateEnd(modifiedDateEnd);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param lastAccessInit, this is last access date end.
     */
    public void setLastAccessInit(String lastAccessInit) {
        this.DATE_PANEL.setLastAccessInit(lastAccessInit);
    }

    /**
     * This method is to update one criteria.
     *
     * @param lastAccessEnd, this is last access date end.
     */
    public void setLastAccessEnd(String lastAccessEnd) {
        this.DATE_PANEL.setLastAccessEnd(lastAccessEnd);
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateInit, this is creation date init.
     */
    public void setCreationDateInit(String creationDateInit) {
        this.DATE_PANEL.setCreationDateInit(creationDateInit);
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateEnd, this is creation date end.
     */
    public void setCreationDateEnd(String creationDateEnd) {
        this.DATE_PANEL.setCreationDateEnd(creationDateEnd);
    }

    /**
     * This method is to update one criteria.
     *
     * @param keySensitiveOfCriteria, this is key sensitive criteria.
     */
    public void setKeySensitiveOfCriteria(boolean keySensitiveOfCriteria) {
        this.PATH_PANEL.setKeySensitiveOfCriteria(keySensitiveOfCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean getIsContainsInsideFileCriteria() {
        return FILE_NAME_PANEL.getIsContainsInsideFileCriteria();
    }

    /**
     * This method is to get contains criteria.
     *
     * @return String, text of contains criteria.
     */
    public String getTextContainsInsideFileCriteria() {
        return FILE_NAME_PANEL.getTextContainsInsideFileCriteria();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isContainsInsideFileCriteria, this is contains criteria.
     */
    public void setIsContainsInsideFileCriteria(boolean isContainsInsideFileCriteria) {
        this.FILE_NAME_PANEL.setIsContainsInsideFileCriteria(isContainsInsideFileCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param textContainsInsideFileCriteria, this is contains criteria.
     */
    public void setTextContainsInsideFileCriteria(String textContainsInsideFileCriteria) {
        this.FILE_NAME_PANEL.setTextContainsInsideFileCriteria(textContainsInsideFileCriteria);
    }

    public void resetAllDataOfDataDBTable() {
        LOOGER.info("reset all data of table data base result");
        this.DB_PANEL.resetAllDataOfDataDBTable();
        LOOGER.info("reset all data of table result exit");
    }

    public void insertRowToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        this.DB_PANEL.insertRowToDataBaseTableResult(row);
    }

    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria");
        return DB_PANEL.getNameOfCriteriaToSaveOnDataBase();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return DB_PANEL.getSaveButtonOnDataBasePanel();
    }

    /**
     * This method return Load JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return DB_PANEL.getLoadButtonOnDataBasePanel();
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return DB_PANEL.getFillButtonOnDataBasePanel();
    }

    /**
     * This method return selection model of Data Base Table result.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public ListSelectionModel getSelectionModel() {
        return DB_PANEL.getSelectionModel();
    }

    /**
     * This method return Data Base Table result.
     * Controller need use this.
     *
     * @return JTable, this is a Data Base JTable.
     */
    public JTable getDataBaseTableResult() {
        return DB_PANEL.getDataBaseTableResult();
    }

    /**
     * This method is for return Delete JButton.
     *
     * @return JButton, this is Delete button of Data Base
     */
    public JButton getDeleteButtonOnDataBasePanel() {
        return this.DB_PANEL.getDeleteButtonOnDataBasePanel();
    }

    /**
     * This method is for return Duration Multimedia critera.
     *
     * @return String, this comparator for multimedia filter.
     */
    public String getDurationMultimediaCriteria() {
        return this.MULTIMEDIA.getDurationMultimediaCriteria();
    }

    /**
     * This method is for return Duration Multimedia Number.
     *
     * @return String, this is number for filter multimedia files.
     */
    public String getDurationMultimediaNumber() {
        return this.MULTIMEDIA.getDurationMultimediaNumber();
    }

    /**
     * This method is for return Duration Multimedia Time.
     *
     * @return String, this is type time {seconds,minutes,hours}.
     */
    public String getDurationMultimediaTime() {
        return this.MULTIMEDIA.getDurationMultimediaTime();
    }

    /**
     * This method is for return Frame Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getFrameRateCriteria() {
        return this.MULTIMEDIA.getFrameRateCriteria();
    }

    /**
     * This method is for return Video Codec Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getVideoCodecCriteria() {
        return this.MULTIMEDIA.getVideoCodecCriteria();
    }

    /**
     * This method is for return Resolution Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getResolutionCriteria() {
        return this.MULTIMEDIA.getResolutionCriteria();
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getMultimediaTypeCriteria() {
        return MULTIMEDIA.getMultimediaTypeCriteria();
    }

    /**
     * This method is return is search multimedia actived.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean isSearchMultimedia() {
        return isSearchMultimedia;
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String
     */
    public String getAudioBitRateInit() {
        return this.MULTIMEDIA.getAudioBitRateInit();
    }
    /**
     * This method is for return Audio Rate Array.
     *
     * @return String
     */
    public String getAudioBitRateEnd() {
        return this.MULTIMEDIA.getAudioBitRateEnd();
    }
}
