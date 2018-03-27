/*
 * @(#)MainSearchWindows.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.view;

import javax.swing.JFrame;
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
     * @param tittle
     * This is a Tittle of Main Windows.
     */
    public MainSearchWindows(String tittle) {

        super(tittle);

        this.topPanel = new TopPanel("Searching...");
        this.centerPanel = new CenterPanel();


        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);

        this.repaint();

    }




}
