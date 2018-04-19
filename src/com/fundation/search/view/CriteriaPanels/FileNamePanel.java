/*
 * @(#)FileNamePanel.java
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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for File Name button.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class FileNamePanel extends JPanel {
    /**
     * Init logger  in File Name Panel
     * */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * allWordsRadioButton, Type: JRadioButton, when file name contains all words.
     */
    private JRadioButton allWordsRadioButton;
    /**
     * startWithRadioButton, Type: JRadioButton, when file name start with word.
     */
    private JRadioButton startWithRadioButton;
    /**
     * endWithRadioButton, Type: JRadioButton, when file name end with word.
     */
    private JRadioButton endWithRadioButton;
    /**
     * equalsToRadioButton, Type: JRadioButton, when file name is equal to word.
     */
    private JRadioButton equalsToRadioButton;
    /**
     * radioButtonGroup, Type: ButtonGroup, this radio button groups will contains all radioButtons.
     */
    private ButtonGroup radioButtonGroup;



    /**
     * Constructor to FileNamePanel.
     * This method is for set layout to FlowLayout, call to iniComponents(), call to addComponents(),
     * and repaint.
     */
    public FileNamePanel() {
        LOOGER.info("Get Result Entry");
        // Setting layout to FlowLayout.
        this.setLayout(new FlowLayout());
        // Calling to initComponents() method.
        this.initComponents();
        // Callind to addComponents() method.
        this.addComponents();
        // repaint.
        this.repaint();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method is to initialize all components.
     */
    private void initComponents() {
        LOOGER.info("Get init");
        // Initialize RadioButtons.
        this.radioButtonGroup = new ButtonGroup();
        this.allWordsRadioButton = new JRadioButton("all words");
        this.startWithRadioButton = new JRadioButton("start with");
        this.endWithRadioButton = new JRadioButton("end with");
        this.equalsToRadioButton = new JRadioButton("equal to");
        // Setting Action Command.
        this.allWordsRadioButton.setActionCommand("all words");
        this.startWithRadioButton.setActionCommand("start with");
        this.endWithRadioButton.setActionCommand("end with");
        this.equalsToRadioButton.setActionCommand("equal to");

        LOOGER.info("init exit");
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add");
        // Adding radioButtons to one Group Radio Button.
        this.radioButtonGroup.add(allWordsRadioButton);
        this.radioButtonGroup.add(startWithRadioButton);
        this.radioButtonGroup.add(endWithRadioButton);
        this.radioButtonGroup.add(equalsToRadioButton);
        // Adding radioButtons to Panel
        this.add(allWordsRadioButton);
        this.add(startWithRadioButton);
        this.add(endWithRadioButton);
        this.add(equalsToRadioButton);
        // Default radioButton selected.
        this.allWordsRadioButton.setSelected(true);

        LOOGER.info("add exit");
    }

    /**
     * This method return Hidden File criteria.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameCriteria() {
        LOOGER.info("Get file name panel");
        return radioButtonGroup.getSelection().getActionCommand();
    }

}
