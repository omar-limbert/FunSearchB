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


/**
 * This class main windows.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MainSearchWindows extends JFrame {

    private TopPanel topPanel;
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
        final int width = 600;
        final int height = 400;
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     * This method return word on SearchJTextField.
     * Controller need use this.
     *
     * @return String.
     */
    public String getSearchText() {

        return topPanel.getSearchText();
    }

    /**
     * This method return Search JButton.
     * Controller need use this.
     *
     * @return JButton.
     */
    public JButton getSearchButton() {

        return topPanel.getSearchButton();
    }

    /**
     * This method return Path criteria.
     * Controller need use this.
     *
     * @return String.
     */
    public String getPathOfCriteria() {

        return topPanel.getPathOfCriteria();
    }

    /**
     * This method return File Name criteria.
     * Controller need use this.
     *
     * @return String.
     */
    public String getFileNameOfCriteria() {

        return topPanel.getFileNameOfCriteria();
    }

    /**
     * This method return Hidden File criteria.
     * Controller need use this.
     *
     * @return String.
     */
    public boolean isHiddenFilesButtonChecked() {

        return topPanel.isShowHiddenFilesChecked();
    }

    /**
     * This method is for insert one row to JTableResult.
     * Controller need use this.
     *
     * @param row
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
