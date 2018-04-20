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
import com.fundation.search.view.CriteriaPanels.DataBasePanel;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class BottomPanel extends JPanel {
    /**
     * Init logger  in Top Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * dataBasePanel, Type: DataBasePanel.
     */
    private DataBasePanel dataBasePanel;

    /**
     * Constructor for TopPanel.
     * This method is for initialize searchButton, setting layout and repaint panel.
     */
    public BottomPanel() {
        LOOGER.info("Get top panel Entry");
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
        this.dataBasePanel = new DataBasePanel();

        LOOGER.info("components exit");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add Components Entry");
        // Adding Search JLabel to first row.
        this.add(dataBasePanel);
        LOOGER.info("add Components exit");
    }

    public void resetAllDataOfDataDBTable() {
        LOOGER.info("reset all data of table data base result");
        this.dataBasePanel.resetAllDataOfDataDBTable();
        LOOGER.info("reset all data of table result exit");
    }

    public void insertRowToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        this.dataBasePanel.insertRowToDataBaseTableResult(row);
    }

    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria");
        return dataBasePanel.getNameOfCriteriaToSaveOnDataBase();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return dataBasePanel.getSaveButtonOnDataBasePanel();
    }

    /**
     * This method return Load JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return dataBasePanel.getLoadButtonOnDataBasePanel();
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return dataBasePanel.getFillButtonOnDataBasePanel();
    }

    /**
     * This method return selection model of Data Base Table result.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public ListSelectionModel getSelectionModel() {
        return dataBasePanel.getSelectionModel();
    }

    /**
     * This method return Data Base Table result.
     * Controller need use this.
     *
     * @return JTable, this is a Data Base JTable.
     */
    public JTable getDataBaseTableResult() {
        return dataBasePanel.getDataBaseTableResult();
    }

    /**
     * This method is for return Delete JButton.
     *
     * @return JButton, this is Delete button of Data Base
     */
    public JButton getDeleteButtonOnDataBasePanel() {
        return this.dataBasePanel.getDeleteButtonOnDataBasePanel();
    }
}
