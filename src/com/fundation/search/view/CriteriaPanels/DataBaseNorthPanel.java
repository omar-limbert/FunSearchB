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
package com.fundation.search.view.CriteriaPanels;

import com.fundation.search.common.SearchLogger;
import com.fundation.search.view.SearchTextField;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.logging.Logger;

/**
 * This class is for create DataBaseNorth Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBaseNorthPanel extends JPanel {
    /**
     * Init logger  in Top Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * nameDBTextfield, Type: SearchTextField, this is input for initialize search.
     */
    private SearchTextField nameDBTextfield;

    /**
     * saveToDBButton, Type: JButton, this button is for Controller and send all data.
     */
    private JButton saveToDBButton;

    /**
     * constraints, Type: GridBagConstraints, this is initialize GridBag Layout.
     */
    private GridBagConstraints constraints;

    /**
     * nameLabel, Type: JLabel, this is a plane text with "Search: ".
     */
    private JLabel nameLabel;

    /**
     * Constructor for DataBaseNorthPanel.
     * This method is for initialize saveToDBButton, setting layout and repaint panel.
     */
    public DataBaseNorthPanel() {
        LOOGER.info("Get top panel Entry");
        this.saveToDBButton = new JButton();
        this.saveToDBButton.setText("Search");
        //setup layout
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.initComponents("Insert Name Of Criteria to Save on DB");
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
        // JLabel "Search".
        this.nameLabel = new JLabel("Name: ");
        // JTextField with place holder.
        this.nameDBTextfield = new SearchTextField(placeHolderText);
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
        this.add(nameLabel, constraints);
        // Adding Search SearchJTextField to first row.
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(nameDBTextfield, constraints);
        // Adding Search JButton to first row.
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(saveToDBButton, constraints);
        LOOGER.info("add Components exit");
    }

    /**
     * This method is for return Save button.
     *
     * @return JButton
     */
    public JButton getSaveToDBButton() {
        LOOGER.info("get search button");
        return saveToDBButton;
    }

    /**
     * This method is return name of criteria to save.
     *
     * @return String
     */
    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria to save on data base");
        return nameDBTextfield.getText();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return saveToDBButton;
    }
}
