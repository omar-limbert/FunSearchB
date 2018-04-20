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

import com.fundation.search.common.SearchLogger;
import com.fundation.search.view.MainWindow.BottomPanel;
import com.fundation.search.view.MainWindow.CenterPanel;
import com.fundation.search.view.MainWindow.TopPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.logging.Logger;

/**
 * This class main windows.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MainSearchWindows extends JFrame {
    /**
     * Init logger  in Main Search Panel
     * */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * topPanel, Type: TopPanel, this is top panel of main windows.
     */
    private TopPanel topPanel;

    /**
     * centerPanel, Type: CenterPanel, this is center panel of main windows.
     */
    private CenterPanel centerPanel;

    /**
     * bottomPanel, Type: CenterPanel, this is center panel of main windows.
     */
    private BottomPanel bottomPanel;

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
        LOOGER.info("Get init");
        // Setting tittle of application.
        this.setTitle("Search Application");
        LOOGER.info("Get init top and center panel");
        // Initialize Top and Center Panel, you need add new Bottom panel for new functionalities.
        this.topPanel = new TopPanel("Searching...");
        this.centerPanel = new CenterPanel();
        this.bottomPanel = new BottomPanel();
        // this.bottom = new BottomPanel(); <= you need implement this for next features.
        // Setting Border Layout and repaint.
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
        // Setting main windows <= maybe you could be this dynamic.
        LOOGER.info("finish add top and center panel");
        final int width = 1300;
        final int height = 900;
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        LOOGER.info("init exit");
    }

    /**
     * This method return word on SearchJTextField.
     * Controller need use this.
     *
     * @return String, this is a text on SearchJTextField.
     */
    public String getSearchText() {
        LOOGER.info("Get SearchText");
        return topPanel.getSearchText();
    }

    /**
     * This method return Search JButton.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Top pane.
     */
    public JButton getSearchButton() {
        LOOGER.info("Get search button");
        return topPanel.getSearchButton();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathOfCriteria() {
        LOOGER.info("Get Path");
        return topPanel.getPathOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete Key Sensitive for search files.
     */
    public  boolean getKeySensitiveOfCriteria() {
        LOOGER.info("Get key Sensitive");
        return  topPanel.getKeySensitiveOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete Read only for search files.
     */

    public boolean getReadOnlyOfCriteria() {
        LOOGER.info("Get Read only");
        return  topPanel.getReadOnlyOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete File System for search files.
     */
    public  boolean getFileSystemOfCriteria() {
        LOOGER.info("Get File System");
        return  topPanel.getFileSystemOfCriteria();
    }

    /**
     * This method is for return path.
     * Controller nee ise this.
     *
     * @return Boolean, this contains a complete Directory for search files.
     */
    public  boolean getDirectoryOfCriteria() {
        LOOGER.info("Get directory");
        return  topPanel.getDirectoryOfCriteria();
    }

    /**
     * This method is for return size.
     * Controller nee ise this.
     *
     * @return array String, this contains a complete path for search files.
     */
    public String[] getSizeOfCriteria() {
        LOOGER.info("Get size");
        return topPanel.getSizeOfCriteria();
    }

    /**
     * This method is for return type.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getTypeCriteria() {
        LOOGER.info("Get type");
        return topPanel.getTypeCriteria();
    }

    /**
     * This method is for return owner.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getOwnerOfCriteria() {
        LOOGER.info("Get Owner");
        return topPanel.getOwnerOfCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getCreationDateInit() {
        LOOGER.info("Get Date creation init");
        return topPanel.getDateCreationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getCreationDateEnd() {
        LOOGER.info("Get date creation end");
        return topPanel.getDateToCreationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getModifiedDateInit() {
        LOOGER.info("Get modified init");
        return topPanel.getDateModificationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getModifiedDateEnd() {
        LOOGER.info("Get modified end");
        return topPanel.getDateToModificationCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getLastAccessDateInit() {
        LOOGER.info("Get last access init");
        return topPanel.getDateLastOpenedCriteria();
    }

    /**
     * This method is for return date.
     * Controller nee ise this.
     *
     * @return String, this contains a complete path for search files.
     */
    public Date getLastAccessDateEnd() {
        LOOGER.info("Get last access end");
        return topPanel.getDateToLastOpenedCriteria();
    }

    /**
     * This method return Hidden File criteria.
     * Controller nee ise this.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameOfCriteria() {
        LOOGER.info("Get file name");
        return topPanel.getFileNameOfCriteria();
    }

    /**
     * This method is to get state of hiddenFile.
     * Controller nee ise this.
     *
     * @return String, ""all files",""only hidden files",""without hidden files".
     */
    public String getHiddenOfCriteria() {
        LOOGER.info("Get hidden ");
        return topPanel.getHiddenOfCriteria();
    }

    /**
     * This method is for insert one row to JTableResult.
     * Controller need use this.
     *
     * @param row, this row contains all values for insert to table result.
     */
    public void insertDataOfJTableResult(Object[] row) {
        LOOGER.info("Insert data to table result");
        centerPanel.insertRowToJTableResult(row);
    }

    /**
     * This method is for reset all values of JTableResult.
     * Controller can use this.
     */
    public void resetDataOfJTableResult() {
        LOOGER.info("get reset table");
        centerPanel.resetAllDataOfTableResult();
    }

    /**
     * This method is for reset all values of Data Base Table Result.
     * Controller can use this.
     */
    public void resetDataOfDataBaseTableResult() {
        LOOGER.info("get reset table");
        bottomPanel.resetAllDataOfDataDBTable();
    }

    /**
     * This method is for insert one row to Data Base Table Result.
     * Controller need use this.
     *
     * @param row, this row contains all values for insert to table result.
     */
    public void insertDataToDataBaseTableResult(Object[] row) {
        LOOGER.info("Insert data to Data Base table result");
        bottomPanel.insertRowToDataBaseTableResult(row);
    }
    /**
     * This method return name of criteria to save on data base.
     * Controller need use this.
     *
     * @return String, this is a text.
     */
    public String getNameOfCriteriaToSaveOnDataBase() {
        LOOGER.info("Get name of criteria");
        return bottomPanel.getNameOfCriteriaToSaveOnDataBase();
    }

    /**
     * This method return Save JButton on Data Base Panel.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadSaveButtonOnDataBasePanel() {
        LOOGER.info("Get Save button of Data Base Panel");
        return bottomPanel.getLoadSaveButtonOnDataBasePanel();
    }

    /**
     * This method return Load JButton on Data Base Panel.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadButtonOnDataBasePanel() {
        LOOGER.info("Get Load button of Data Base Panel");
        return bottomPanel.getLoadButtonOnDataBasePanel();
    }

    /**
     * This method return Fill JButton on Data Base Panel.
     * Controller need use this.
     *
     * @return JButton, this is a JButton on Data Base pane.
     */
    public JButton getLoadFillButtonOnDataBasePanel() {
        LOOGER.info("Get Fill button of Data Base Panel");
        return bottomPanel.getLoadFillButtonOnDataBasePanel();
    }
}
