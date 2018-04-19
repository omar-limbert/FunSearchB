/*
 * @(#)CenterPanel.java
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
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.logging.Logger;

/**
 * This class is for create Botton Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBaseCenterPanel extends JPanel {
    /**
     * Init logger  in Center Panel
     * */
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
     * Constructor for CentralPanel.
     * This method is for set Layout to GirdLayout, call initComponents() and call addComponents().
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
        this.add(dataBaseCriteriaTable, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.add(new JScrollPane(dataBaseCriteriaTable));
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
        dataBaseCriteriaTable.setModel(modelOfJTableResult);
        header = dataBaseCriteriaTable.getTableHeader();
        LOOGER.info("initComponents exit");

    }

    /**
     * This method is for add row to TableResult.
     *
     * @param rowForInsertToDBTable
     */
    public void insertRowToDBTable(Object[] rowForInsertToDBTable) {
        LOOGER.info("insert row to table result init");
        modelOfJTableResult.addRow(rowForInsertToDBTable);
        LOOGER.info("insert row to table result exit");
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


    public void insertRowToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        this.modelOfJTableResult.addRow(row);
    }
}