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
package com.fundation.search.view.MainWindow;

import com.fundation.search.common.SearchLogger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.logging.Logger;

/**
 * This class is for create Center Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class CenterPanel extends JPanel {
    /**
     * Init logger  in Center Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * resultsOfCriteria, Type: JTable, this table is for show results.
     */
    private JTable resultsOfCriteria; //maybe you need convert this to new extend class.
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
    public CenterPanel() {
        LOOGER.info("Get center");
        this.setLayout(new BorderLayout(2, 1));
        this.initComponents();
        this.addComponents();
        LOOGER.info("exit center");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add");
        this.add(resultsOfCriteria, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.add(new JScrollPane(resultsOfCriteria));
        LOOGER.info("add exit");

    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        LOOGER.info("Get init");
        String columnNames[] = {"Name", "Path", "Hidden", "Read only", "File System", "Directory", "Type", "Size", "Owner", "Date Created", "Last Modified", "Last Access"};
        String rowData[][] = {{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
        resultsOfCriteria = new JTable();
        modelOfJTableResult = new DefaultTableModel(rowData, columnNames);
        resultsOfCriteria.setModel(modelOfJTableResult);
        /* Accedemos al header de forma individual */
        header = resultsOfCriteria.getTableHeader();
        LOOGER.info("init exit");

    }

    /**
     * This method is for add row to TableResult.
     *
     * @param rowForInsertToTableResult Is Object[] with 5 positions {File, Type,Size, Modification, Creation, Owner}.
     */
    public void insertRowToJTableResult(Object[] rowForInsertToTableResult) {
        LOOGER.info("insert row to table result init");
        modelOfJTableResult.addRow(rowForInsertToTableResult);
        LOOGER.info("insert row to table result exit");
    }

    /**
     * This method is reset all data of Table Result.
     */
    public void resetAllDataOfTableResult() {
        LOOGER.info("Get reset all data of table result init");
        this.cleanModelOfJTable((DefaultTableModel) resultsOfCriteria.getModel());
        LOOGER.info("reset all data of table result exit");
    }

    /**
     * This method is for clean model from JTableResult.
     *
     * @param modelOfJTableResult, this is model from table result.
     */
    private void cleanModelOfJTable(DefaultTableModel modelOfJTableResult) {
        LOOGER.info("Get init clean model of table");
        int rows = modelOfJTableResult.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                modelOfJTableResult.removeRow(0);
            }
        }
        LOOGER.info("Exit clean model of table");
    }


}
