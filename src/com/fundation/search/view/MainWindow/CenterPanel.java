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

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This class is for create Center Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class CenterPanel extends JPanel {

    /**
     * resultsOfCriteria, Type: JTable, this table is for show results.
     */
    private JTable resultsOfCriteria; //maybe you need convert this to new extend class.
    /**
     * modelOfJTableResult, Type: DefaultTableModel, this is a file chooser for get path of directory.
     */
    private DefaultTableModel modelOfJTableResult;

    /**
     * Constructor for CentralPanel.
     * This method is for set Layout to GirdLayout, call initComponents() and call addComponents().
     */
    public CenterPanel() {
        this.setLayout(new GridLayout(2, 1));
        this.initComponents();
        this.addComponents();
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        this.add(resultsOfCriteria);
        //Adding columns. (you will fix this when extend class table is will create)
        modelOfJTableResult.addColumn("File");
        modelOfJTableResult.addColumn("Type");
        modelOfJTableResult.addColumn("Size");
        modelOfJTableResult.addColumn("Modification");
        modelOfJTableResult.addColumn("Creation");
        modelOfJTableResult.addColumn("Owner");
        //Sample data please remove this when you will complete dynamic jtable class.
        this.insertRowToJTableResult(new Object[]{"File1", "Parth1", "Type1",
                "Size1", "Modification1", "Creation1", "Owner1"});
        this.insertRowToJTableResult(new Object[]{"File2", "Parth2", "Type2",
                "Size2", "Modification2", "Creation2", "Owner2"});
        this.insertRowToJTableResult(new Object[]{"File3", "Parth3", "Type3",
                "Size3", "Modification3", "Creation3", "Owner3"});
        this.insertRowToJTableResult(new Object[]{"File4", "Parth4", "Type4",
                "Size4", "Modification4", "Creation4", "Owner4"});
    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        resultsOfCriteria = new JTable();
        modelOfJTableResult = new DefaultTableModel();
        resultsOfCriteria.setModel(modelOfJTableResult);
    }

    /**
     * This method is for add row to TableResult.
     *
     * @param rowForInsertToTableResult Is Object[] with 5 positions {File, Type,Size, Modification, Creation, Owner}.
     */
    public void insertRowToJTableResult(Object[] rowForInsertToTableResult) {
        modelOfJTableResult.addRow(rowForInsertToTableResult);
    }

    /**
     * This method is reset all data of Table Result.
     */
    public void resetAllDataOfTableResult() {
        this.cleanModelOfJTable((DefaultTableModel) resultsOfCriteria.getModel());
    }

    /**
     * This method is for clean model from JTableResult.
     *
     * @param modelOfJTableResult, this is model from table result.
     */
    private void cleanModelOfJTable(DefaultTableModel modelOfJTableResult) {
        int filas = modelOfJTableResult.getRowCount();
        if (filas > 0) {
            for (int i = 0; i < filas; i++) {
                modelOfJTableResult.removeRow(0);
            }
        }
    }


}
