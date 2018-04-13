/*
 * @(#)MainSearchWindows.java
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
package com.fundation.search.view;

import com.fundation.search.view.MainWindow.CenterPanel;
import com.fundation.search.view.MainWindow.TopPanel;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.Date;

/**
 * This class main windows.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MainSearchWindows extends JFrame {

    /**
     * topPanel, Type: TopPanel, this is top panel of main windows.
     */
    private TopPanel topPanel;
    /**
     * topPanel, Type: CenterPanel, this is center panel of main windows.
     */
    private CenterPanel centerPanel;


    /**
     * Constructor for MainSearchWindows.
     */
    public MainSearchWindows() {
        super();
    }

    /**
     * This method is for initialize all components on main windows.
     */
    public void initWindows() {
        // Setting tittle of application.
        this.setTitle("Search Application");
        // Initialize Top and Center Panel, you need add new Bottom panel for new functionalities.
        this.topPanel = new TopPanel("Searching...");
        this.centerPanel = new CenterPanel();
        // this.bottom = new BottomPanel(); <= you need implement this for next features.
        // Setting Border Layout and repaint.
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
        // Setting main windows <= maybe you could be this dynamic.
        final int width = 900;
        final int height = 600;
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * This method return word on SearchJTextField.
     * Controller need use this.
     *
     * @return String, this is a text on SearchJTextField.
     */
    public String getSearchText() {
        return topPanel.getSearchText();
    }

    /**
     * This method return Search JButton.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Top pane.
     */
    public JButton getSearchButton() {
        return topPanel.getSearchButton();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathOfCriteria() {
        return topPanel.getPathOfCriteria();
    }

    /**
     * This method is for return size.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getSizeOfCriteria() {
        return topPanel.getSizeOfCriteria();
    }
    /**
     * This method is for return owner.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getOwnerOfCriteria() {
        return topPanel.getOwnerOfCriteria();
    }
    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getDateOfCriteria() {
        return topPanel.getDateCreationCriteria();
    }
    public Date getDatetoCreationCriteria() {
        return topPanel.getDateToCreationCriteria();
    }
    public Date getDateModificationCriteria() {
        return topPanel.getDateModificationCriteria();
    }
    public Date getDateToModificationCriteria() {
        return topPanel.getDateToModificationCriteria();
    }
    public Date getDateLastOpenedCriteria() {
        return topPanel.getDateLastOpenedCriteria();
    }
    public Date getDateToLastOpenedCriteria() {
        return topPanel.getDateToLastOpenedCriteria();
    }

    /**
     * This method return Hidden File criteria.
     * Controller nee ise this.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameOfCriteria() {
        return topPanel.getFileNameOfCriteria();
    }

    /**
     * This method is to get state of hiddenFile.
     * Controller nee ise this.
     *
     * @return String, ""all files",""only hidden files",""without hidden files".
     */
    public String getHiddenOfCriteria() {
        return topPanel.getHiddenOfCriteria();
    }

    /**
     * This method is for insert one row to JTableResult.
     * Controller need use this.
     *
     * @param row, this row contains all values for insert to table result.
     */
    public void insertDataOfJTableResult(Object[] row) {
        centerPanel.insertRowToJTableResult(row);
    }

    /**
     * This method is for reset all values of JTableResult.
     * Controller can use this.
     */
    public void resetDataOfJTableResult() {
        centerPanel.resetAllDataOfTableResult();
    }
}
