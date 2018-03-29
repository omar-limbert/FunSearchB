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

import com.fundation.search.view.CriteriaPanels.CriteriaPanel;
import com.fundation.search.view.SearchTextField;
import com.fundation.search.view.SearchToolBar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class TopPanel extends JPanel {

    private SearchTextField searchTextField;
    private SearchToolBar toolbar;
    private JButton searchButton;
    private CriteriaPanel criteriaPanel;
    private GridBagConstraints constraints;
    private JLabel searchJLabel;


    /**
     * Constructor for TopPanel.
     *
     * @param placeHolderText This is text for place holder.
     */
    public TopPanel(String placeHolderText) {


        this.searchButton = new JButton();
        this.searchButton.setText("Search");


        //setup layout
        this.constraints = new GridBagConstraints();


        this.setLayout(new GridBagLayout());
        this.initComponents(placeHolderText);
        this.addComponents();
        this.repaint();

    }

    /**
     * This method is for initialize all components.
     *
     * @param placeHolderText This is text for place holder.
     */
    private void initComponents(String placeHolderText) {

        // Dynamic criteria JPanel.
        this.criteriaPanel = new CriteriaPanel();
        // JLabel "Search".
        this.searchJLabel = new JLabel("Search: ");
        // JTextField with place holder.
        this.searchTextField = new SearchTextField(placeHolderText);
        // JToolbar with all buttons
        this.toolbar = new SearchToolBar(criteriaPanel);

    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {

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
     * @return boolean
     */
    public boolean isShowHiddenFilesChecked() {
        return toolbar.isShowHiddenFilesChecked();
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
