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

import javax.swing.*;
import java.awt.*;
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
     * */
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
        return toolbar.getPathOfCriteria();
    }

    /**
     * This method is return Read Only criteria.
     *
     * @return Boolean
     */

    public boolean getReadOnlyOfCriteria() {
        return  toolbar.getReadOnlyOfCriteria();
    }

    /**
     * This method is return File System criteria.
     *
     * @return Boolean
     */
    public  boolean getFileSystemOfCriteria() {
        return  toolbar.getFileSystemOfCriteria();
    }

    /**
     * This method is return Directory criteria.
     *
     * @return Boolean
     */
    public  boolean getDirectoryOfCriteria() {
        return  toolbar.getDirectoryOfCriteria();
    }

    /**
     * This method is return Size criteria.
     *
     * @return Array String
     */
    public String[] getSizeOfCriteria() {
        return toolbar.getSizeCriteria();
    }

    /**
     * This method is return Owner criteria.
     *
     * @return String
     */
    public String getOwnerOfCriteria() {
        return  toolbar.getOwnerCriteria();
    }


    /**
     * This method is return Date Creation criteria.
     *
     * @return Date
     */
    public Date getDateCreationCriteria() {
        return toolbar.getDateCreationCriteria();
    }

    /**
     * This method is return Date to Creation criteria.
     *
     * @return Date
     */
    public Date getDateToCreationCriteria() {
        return toolbar.getDateToCreationCriteria();
    }

    /**
     * This method is return Date Modification criteria.
     *
     * @return Date
     */
    public Date getDateModificationCriteria() {
        return toolbar.getDateModificationCriteria();
    }

    /**
     * This method is return Date Modification to criteria.
     *
     * @return Date
     */
    public Date getDateToModificationCriteria() {
        return toolbar.getDateToModificationCriteria();
    }

    /**
     * This method is return Last Access criteria.
     *
     * @return Date
     */
    public Date getDateLastOpenedCriteria() {
        return toolbar.getDateLastOpenedCriteria();
    }

    /**
     * This method is return Last Access to Creation criteria.
     *
     * @return Date
     */
    public Date getDateToLastOpenedCriteria() {
        return toolbar.getDateToLastOpenedCriteria();
    }

    /**
     * This method is return File name criteria.
     *
     * @return String
     */
    public String getFileNameOfCriteria() {
        return toolbar.getFileNameOfCriteria();
    }

    /**
     * This method is for return Hidden criteria.
     *
     * @return String
     */
    public String getHiddenOfCriteria() {
        return toolbar.getHiddenOfCriteria();
    }

    /**
     * This method is for return Type criteria.
     *
     * @return String
     */
    public String getTypeCriteria() {
        return toolbar.getTypeCriteria();
    }

    /**
     * This method is for return Search button.
     *
     * @return JButton
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * This method is for return Search Text.
     *
     * @return String
     */
    public String getSearchText() {
        return searchTextField.getText();
    }


}
