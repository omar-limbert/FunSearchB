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
     * Constructor for SearchToolBar.
     * This method is for initialize toggleButtonCollection, action, criteriaPanel and panelList.
     */
    public SearchToolBar(CriteriaPanel criteriaPanel) {
        LOOGER.info("Get Result Entry");
        // This is a collection of buttons.
        this.toggleButtonCollection = new Vector<>();
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
        }
        criteriaPanel.addComponent(panelList);
        LOOGER.info("addActionListeners of buttons exit");
    }

    /**
     * Method for remove criteria panel.
     */
    private void removingCriteriaPanelToActionListenerButton() {
        LOOGER.info("remove criteria Action listener of buttons init");
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
        LOOGER.info("remove criteria listener of buttons exit");
    }

    /**
     * Method for add criteria panel to panelList.
     */
    private void addingCriteriaPanelToActionListenerButton() {
        LOOGER.info("add criteria panel  action of button");
        // Adding "All Tags Panel Criteria"
        if (action.equalsIgnoreCase("All Tags")) {
            panelList.put("File Name", FILE_NAME_PANEL);
            panelList.put("Path", PATH_PANEL);
            panelList.put("Hidden", HIDDEN_PANEL);
            panelList.put("Size", SIZE_PANEL);
            panelList.put("Owner", OWNER_PANEL);
            panelList.put("Date", DATE_PANEL);
            panelList.put("Type", TYPE_PANEL);
        }
        // Adding "File Name Panel Criteria"
        if (action.equalsIgnoreCase("File Name")) {
            panelList.put(action, FILE_NAME_PANEL);
        }
        // Adding "Path Panel Criteria"
        if (action.equalsIgnoreCase("Path")) {
            panelList.put(action, PATH_PANEL);
        }
        // Adding "Hidden Panel Criteria"
        if (action.equalsIgnoreCase("Hidden")) {
            panelList.put(action, HIDDEN_PANEL);
        }
        // Adding "Size Panel Criteria"
        if (action.equalsIgnoreCase("Size")) {
            panelList.put(action, SIZE_PANEL);
        }
        // Adding "Owner Panel Criteria"
        if (action.equalsIgnoreCase("Owner")) {
            panelList.put(action, OWNER_PANEL);
        }
        // Adding "Date Panel Criteria"
        if (action.equalsIgnoreCase("Date")) {
            panelList.put(action, DATE_PANEL);
        }

        if (action.equalsIgnoreCase("Type")) {
            panelList.put(action, TYPE_PANEL);
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
        this.add(buttonToAddCollection);
        this.toggleButtonCollection.add(buttonToAddCollection);
        LOOGER.info("exit button to toggle collection");
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
}
