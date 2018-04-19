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
import com.fundation.search.view.SearchToolBar;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Date;
import java.util.logging.Logger;

/**
 * This class is for create DataBaseNorth Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBaseSouthPanel extends JPanel {
    /**
     * Init logger  in Top Panel
     * */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * saveToDBButton, Type: JButton, this button is for Controller and send all data.
     */
    private JButton loadButton;

    /**
     * saveToDBButton, Type: JButton, this button is for Controller and send all data.
     */
    private JButton fillButton;

    /**
     * constraints, Type: GridBagConstraints, this is initialize GridBag Layout.
     */
    private GridBagConstraints constraints;

    /**
     * Constructor for DataBaseNorthPanel.
     * This method is for initialize saveToDBButton, setting layout and repaint panel.
     *
     */
    public DataBaseSouthPanel() {
        LOOGER.info("Get top panel Entry");

        this.initComponents();
        this.addComponents();
        this.repaint();
        LOOGER.info("top panel exit");
    }

    /**
     * This method is for initialize all components.
     *
     */
    private void initComponents() {
        LOOGER.info("Get init components");
        this.loadButton = new JButton("Load");
        this.fillButton = new JButton("Fill");
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        LOOGER.info("components exit");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add Components Entry");
        // Adding loadButton to first row.
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(loadButton, constraints);
        // Adding fillButton to first row.
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(fillButton, constraints);
        LOOGER.info("add Components exit");
    }

    /**
     * This method return Load JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return loadButton;
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return fillButton;
    }
}
