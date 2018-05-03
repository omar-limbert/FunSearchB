/*
 * @(#)DataBaseCenterPanel.java
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * This class is for create Botton Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBaseCenterPanel extends JPanel {

    /**
     * Init logger  in Center Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * dataBaseCriteriaTable, Type: JTable, this table is for show results.
     */
    private JTable dataBaseCriteriaTable;

    /**
     * modelOfJTableResult, Type: DefaultTableModel, this is a file chooser for get path of directory.
     */
    private DefaultTableModel modelOfJTableResult;

    /**
     * modelOfTableHeader, Type:JTableHeader, is the Header of the table.
     */
    private JTableHeader header;

    /**
     * Constructor for Data Base Central Panel.
     *
     */
    public DataBaseCenterPanel() {
        LOOGER.info("Constructor Bottom Panel Entry");
        this.setLayout(new BorderLayout());
        this.initComponents();
        this.addComponents();
        LOOGER.info("Constructor Bottom Panel Entry");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("addComponents entry");
        this.setOpaque(false);
        this.add(dataBaseCriteriaTable, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.add(new JScrollPane(dataBaseCriteriaTable));
        this.setPreferredSize(new Dimension(200,200));
        this.dataBaseCriteriaTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        LOOGER.info("addComponents exit");

    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        LOOGER.info("initComponents entry");
        String columnNames[] = {"ID", "Criteria"};
        String rowData[][] = {{}, {}};
        dataBaseCriteriaTable = new JTable();
        modelOfJTableResult = new DefaultTableModel(rowData, columnNames);

        // Single selection on table
        dataBaseCriteriaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dataBaseCriteriaTable.setModel(modelOfJTableResult);

        // Delimit columns
        dataBaseCriteriaTable.getColumnModel().getColumn(0).setPreferredWidth(47);
        dataBaseCriteriaTable.getColumnModel().getColumn(1).setPreferredWidth(320);

        // Fixing size of table
        dataBaseCriteriaTable.setSize(372,172);
        dataBaseCriteriaTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        header = dataBaseCriteriaTable.getTableHeader();
        LOOGER.info("initComponents exit");



    }

    /**
     * This method is reset all data of Table Result.
     */
    public void resetAllDataOfDBTable() {
        LOOGER.info("Get reset all data of table result init");
        this.cleanModelOfDBTable((DefaultTableModel) dataBaseCriteriaTable.getModel());
        LOOGER.info("reset all data of table result exit");
    }

    /**
     * This method is for clean model from JTableResult.
     *
     * @param modelOfDBTable, this is model from table result.
     */
    private void cleanModelOfDBTable(DefaultTableModel modelOfDBTable) {
        LOOGER.info("Get init clean model of table");
        int rows = modelOfDBTable.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                modelOfDBTable.removeRow(0);
            }
        }
        LOOGER.info("Exit clean model of table");
    }

    /**
     * This method is for insert one row to JTable result.
     *
     * @param row, this is array to insert into JTable.
     */
    public void insertRowToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        this.modelOfJTableResult.addRow(row);
    }

    public ListSelectionModel getSelectionModel() {
        return dataBaseCriteriaTable.getSelectionModel();
    }

    /**
     * This method return Data Base Table result.
     *
     * @return JTable, this is a Data Base JTable.
     */
    public JTable getDataBaseTableResult() {
        return dataBaseCriteriaTable;
    }
}
