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
import com.fundation.search.view.SearchTextField;
import com.fundation.search.view.SearchToolBar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Date;
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
     *
     * @param placeHolderText This is text for place holder.
     */
    public TopPanel(String placeHolderText) {
        LOOGER.info("Get top panel Entry");
        this.searchButton = new JButton();
        this.searchButton.setText("Search");
        //setup layout
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.initComponents(placeHolderText);
        this.addComponents();
        this.repaint();
        LOOGER.info("top panel exit");
    }

    /**
     * This method is for initialize all components.
     *
     * @param placeHolderText This is text for place holder.
     */
    private void initComponents(String placeHolderText) {
        LOOGER.info("Get init components");
        // Dynamic criteria JPanel.
        this.criteriaPanel = new CriteriaPanel();
        // JLabel "Search".
        this.searchJLabel = new JLabel("Search: ");
        // JTextField with place holder.
        this.searchTextField = new SearchTextField(placeHolderText);
        // JToolbar with all buttons
        this.toolbar = new SearchToolBar(criteriaPanel);
        LOOGER.info("components exit");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add Components Entry");
        // Adding Search JLabel to first row.
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(searchJLabel, constraints);
        // Adding Search SearchJTextField to first row.
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(searchTextField, constraints);
        // Adding Search JButton to first row.
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(searchButton, constraints);
        // Second Row only for add toolbar buttons.
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        this.add(toolbar, constraints);
        // Third Row only for add criteria dynamic JPanel.
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
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
}
