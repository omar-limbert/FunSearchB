/*
 * @(#)FileNamePanel.java
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


import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.logging.Logger;


/**
 * This class is to create DataBase Panel with all sub-panels.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBasePanel extends JPanel {
    /**
     * Init logger  on DataBase Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    private DataBaseNorthPanel dataBaseNorthPanel;
    private DataBaseCenterPanel dataBaseCenterPanel;
    private DataBaseSouthPanel dataBaseSouthPanel;

    /**
     * Constructor for DataBasePanel.
     * This constructor call initComponents() after this
     * revalidate and repaint all panel.
     */
    public DataBasePanel() {
        LOOGER.info("Constructor Entry");
        this.initComponents();
        this.addComponents();
        this.revalidate();
        this.repaint();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method is for initialize all components.
     * This is for set Layout to BoxLayout on vertical position.
     */
    private void initComponents() {
        LOOGER.info("Get init");
        this.setLayout(new BorderLayout());
        dataBaseNorthPanel = new DataBaseNorthPanel();
        dataBaseCenterPanel = new DataBaseCenterPanel();
        dataBaseSouthPanel = new DataBaseSouthPanel();
        LOOGER.info("init component criteria exit");
    }

    /**
     * This method is for add all components.
     */
    public void addComponents() {
        this.removeAll();
        LOOGER.info("Get init");
        this.add(dataBaseNorthPanel, BorderLayout.NORTH);
        this.add(dataBaseCenterPanel, BorderLayout.CENTER);
        this.add(dataBaseSouthPanel, BorderLayout.SOUTH);
        // Revalidate and repaint.
        this.revalidate();
        this.repaint();
        LOOGER.info("add exit component Criteria");
    }

    public void resetAllDataOfDataDBTable() {
        LOOGER.info("reset all data of table data base result");
        this.dataBaseCenterPanel.resetAllDataOfDBTable();
        LOOGER.info("reset all data of table data base result exit");
    }

    public void insertRowToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        this.dataBaseCenterPanel.insertRowToDataBaseTableResult(row);
    }

    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria to save on data base");
        return dataBaseNorthPanel.getNameOfCriteriaToSaveOnDataBase();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return dataBaseNorthPanel.getSaveButtonOnDataBasePanel();
    }

    /**
     * This method return Load JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return dataBaseSouthPanel.getLoadButtonOnDataBasePanel();
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return dataBaseSouthPanel.getFillButtonOnDataBasePanel();
    }

    /**
     * This method return selection model of Data Base Table result.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public ListSelectionModel getSelectionModel() {
        return dataBaseCenterPanel.getSelectionModel();
    }

    /**
     * This method return Data Base Table result.
     * Controller need use this.
     *
     * @return JTable, this is a Data Base JTable.
     */
    public JTable getDataBaseTableResult() {
        return dataBaseCenterPanel.getDataBaseTableResult();
    }

    /**
     * This method is for return Delete JButton.
     *
     * @return JButton, this is Delete button of Data Base
     */
    public JButton getDeleteButtonOnDataBasePanel() {
        return this.dataBaseSouthPanel.getDeleteButtonOnDataBasePanel();
    }
}
