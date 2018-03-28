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

import org.fundacionjala.coding.omar.view.CriteriaPanels.CriteriaPanel;
import org.fundacionjala.coding.omar.view.SearchTextField;
import org.fundacionjala.coding.omar.view.SearchToolBar;

import javax.swing.*;
import java.awt.*;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class TopPanel extends JPanel {

    private SearchTextField searchTextField;
    private JToolBar toolbar;
    private JButton searchButton;
    private CriteriaPanel criteriaPanel;
    GridBagConstraints constraints;




    /**
     * Constructor for TopPanel.
     * @param placeHolderText
     * This is text for place holder.
     */
    public TopPanel(String placeHolderText) {


        this.searchButton = new JButton();
        this.searchButton.setText("Search");


        //setup layout
        this.constraints = new GridBagConstraints();



        this.setLayout (new GridBagLayout());
        this.initComponents(placeHolderText);
        this.addComponents();
        this.repaint();

      //  System.out.println("Ariel =>"+searchTextField.getText());
    }
    /**
     * This method is for initialize all components.
     * @param placeHolderText
     * This is text for place holder.
     */
    public void initComponents(String placeHolderText) {
        this.searchTextField = new SearchTextField(placeHolderText);

        this.criteriaPanel = new CriteriaPanel();

        this.toolbar = new SearchToolBar(criteriaPanel);

    }
    /**
     * This method is for add all components.
     */
    public void addComponents() {

        // First Row, "Search", SearchTextField, JButton.
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add (new JLabel("Search: "), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add (searchTextField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add (searchButton, constraints);


        // Second Row only toolbar.
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        this.add (toolbar, constraints);

        // Third Row CardLayout of criterias.

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        this.add (criteriaPanel, constraints);




    }

    public String getPathOfCriteria() {

        return null;
    }

    public String getFileNameOfCriteria() {
        return null;
    }
}
