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
import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.FileResult;
import com.fundation.search.model.asset.MultimediaResult;
import com.fundation.search.view.SearchTextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner.ListEditor;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Dimension;
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
     * resultProcessJLable, Type: JLabel, this is label to process.
     */
    private JLabel resultProcessJLabel;

    /**
     * resultProcessTextField, Type: SearchTextField, this is textField to process.
     */
    private SearchTextField resultProcessTextField;

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
        JPanel resultProcess = new JPanel();
        resultProcess.add(resultProcessJLabel);
        resultProcess.add(resultProcessTextField);
        this.add(resultProcess, BorderLayout.NORTH);
        this.add(resultsOfCriteria, BorderLayout.CENTER);
        this.add(header, BorderLayout.CENTER);
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
        this.resultProcessJLabel = new JLabel("Files Matched :");
        this.resultProcessTextField = new SearchTextField("Results Found");
        this.resultProcessTextField.setPreferredSize(new Dimension(250, 32));
        this.resultProcessTextField.setEditable(false);
        this.resultProcessTextField.setEnabled(false);
        this.resultProcessTextField.setPlaceHolderColor(Color.RED);
        this.resultsOfCriteria = new JTable();
        this.modelOfJTableResult = new DefaultTableModel(rowData, columnNames);
        this.resultsOfCriteria.setModel(modelOfJTableResult);
        this.resultsOfCriteria.setAutoCreateRowSorter(true);
        this.header = resultsOfCriteria.getTableHeader();
        this.repaint();
        LOOGER.info("init exit");

    }

    /**
     * This method is to set result process.
     *
     * @param resultProcessTextField this is text to result process.
     */
    public void setResultProcessTextField(String resultProcessTextField) {
        this.resultProcessTextField.setText(resultProcessTextField);
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

    /**
     * This method is to change columns tittle for file.
     *
     */
    public void updateColumnsTittleToFile(){

        // Setting Columns
        header.getColumnModel().getColumn(0).setHeaderValue("Name");
        header.getColumnModel().getColumn(1).setHeaderValue("Path");
        header.getColumnModel().getColumn(2).setHeaderValue("Hidden");
        header.getColumnModel().getColumn(3).setHeaderValue("Read Only");
        header.getColumnModel().getColumn(4).setHeaderValue("File System");
        header.getColumnModel().getColumn(5).setHeaderValue("Directory");
        header.getColumnModel().getColumn(6).setHeaderValue("Type/Files");
        header.getColumnModel().getColumn(7).setHeaderValue("Size");
        header.getColumnModel().getColumn(8).setHeaderValue("Owner");
        header.getColumnModel().getColumn(9).setHeaderValue("Date Created");
        header.getColumnModel().getColumn(10).setHeaderValue("Last Modified");
        header.getColumnModel().getColumn(11).setHeaderValue("Last Access");
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is to change columns tittle for Multimedia.
     *
     */
    public void updateColumnsTittleToMultimedia(){

        // Setting Columns
        header.getColumnModel().getColumn(0).setHeaderValue("Multimedia Name");
        header.getColumnModel().getColumn(1).setHeaderValue("Video Codec");
        header.getColumnModel().getColumn(2).setHeaderValue("Frame Rate");
        header.getColumnModel().getColumn(3).setHeaderValue("Aspect Ratio");
        header.getColumnModel().getColumn(4).setHeaderValue("Resolution");
        header.getColumnModel().getColumn(5).setHeaderValue("Extension");
        header.getColumnModel().getColumn(6).setHeaderValue("Duration [S]");
        header.getColumnModel().getColumn(7).setHeaderValue("Audio Codec");
        header.getColumnModel().getColumn(8).setHeaderValue("Audio Bit Rate");
        header.getColumnModel().getColumn(9).setHeaderValue("Channels");
        header.getColumnModel().getColumn(10).setHeaderValue("Path");
        header.getColumnModel().getColumn(11).setHeaderValue("Size");
        this.revalidate();
        this.repaint();


    }
}
