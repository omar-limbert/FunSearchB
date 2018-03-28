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

import javax.swing.*;
import java.awt.*;

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
     *
     * @param tittle This is a Tittle of Main Windows.
     */
    private MainSearchWindows(String tittle) {

        super(tittle);

        this.topPanel = new TopPanel("Searching...");
        this.centerPanel = new CenterPanel();

        // this.searchButton.setVisible(true);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);

        this.getContentPane().add(centerPanel, BorderLayout.CENTER);

        this.repaint();

    }

    /**
     * Constructor for CentralPanel.
     *
     * @return path of criteria.
     */
    public String getPathOfCriteria() {

        return topPanel.getPathOfCriteria();
    }

    /**
     * Constructor for CentralPanel.
     *
     * @return File name criteria.
     */
    public String getFileNameOfCriteria() {

        return topPanel.getFileNameOfCriteria();
    }

    /**
     * Constructor for CentralPanel.
     *
     * @param args
     */
    public static void main(String[] args) {

        final int width = 600;
        final int height = 400;

        JFrame windows = new MainSearchWindows("Search Application");
        windows.setSize(width, height);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setVisible(true);
    }


}
