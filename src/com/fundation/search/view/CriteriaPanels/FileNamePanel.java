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
import com.fundation.search.view.SearchTextField;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.util.logging.Logger;
import java.awt.event.ItemEvent;
import java.awt.Dimension;
import java.awt.Color;

/**
 * This class is to create the configuration for File Name button.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class FileNamePanel extends JPanel {

    /**
     * Init logger  in File Name Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * This is color to set all labels.
     */
    private static final Color FONT_COLOR = Color.WHITE;

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
     * containsTextInside, Type: JCheckBox, this criteria is for check inside to file.
     */
    private JCheckBox containsTextInside;

    /**
     * containsJTextField, Type: JTextField, this JTextField for contains criteria.
     */
    private SearchTextField containsJTextField;

    /**
     * containsJTextField, Type: JTextField, this JTextField for contains criteria.
     */
    private JLabel fileNameLabel;


    /**
     * Constructor to FileNamePanel.
     * This method is for set layout to FlowLayout, call to iniComponents(), call to addComponents(),
     * and repaint.
     */
    public FileNamePanel() {
        LOOGER.info("Get Result Entry");
        this.setOpaque(false);
        // Setting layout to FlowLayout
        this.setLayout(new FlowLayout());

        // Calling to initComponents() method

        this.initComponents();
        // Callind to addComponents() method

        this.addComponents();
        // repaint all panel
        this.repaint();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method is to initialize all components.
     */
    private void initComponents() {
        LOOGER.info("initComponents init");
        this.containsJTextField = new SearchTextField("<- Search inside a File");
        this.containsJTextField.setPreferredSize(new Dimension(200, 32));
        this.fileNameLabel = new JLabel("File Name :");
        this.fileNameLabel.setForeground(FONT_COLOR);
        this.containsTextInside = new JCheckBox("Search Inside :");
        this.containsTextInside.setOpaque(false);
        this.containsTextInside.setForeground(FONT_COLOR);
        // Initialize RadioButtons.
        this.radioButtonGroup = new ButtonGroup();
        this.allWordsRadioButton = new JRadioButton("all words");
        this.allWordsRadioButton.setOpaque(false);
        this.allWordsRadioButton.setForeground(FONT_COLOR);
        this.startWithRadioButton = new JRadioButton("start with");
        this.startWithRadioButton.setOpaque(false);
        this.startWithRadioButton.setForeground(FONT_COLOR);
        this.endWithRadioButton = new JRadioButton("end with");
        this.endWithRadioButton.setOpaque(false);
        this.endWithRadioButton.setForeground(FONT_COLOR);
        this.equalsToRadioButton = new JRadioButton("equal to");
        this.equalsToRadioButton.setOpaque(false);
        this.equalsToRadioButton.setForeground(FONT_COLOR);

        // Setting Action Command.
        this.allWordsRadioButton.setActionCommand("all words");
        this.startWithRadioButton.setActionCommand("start with");
        this.endWithRadioButton.setActionCommand("end with");
        this.equalsToRadioButton.setActionCommand("equal to");
        LOOGER.info("initComponents exit");
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
        this.add(fileNameLabel);
        this.add(allWordsRadioButton);
        this.add(startWithRadioButton);
        this.add(endWithRadioButton);
        this.add(equalsToRadioButton);
        this.add(containsTextInside);
        this.add(containsJTextField);

        // Default radioButton selected.
        this.allWordsRadioButton.setSelected(true);
        this.containsTextInside.setSelected(false);
        this.containsJTextField.setEditable(false);
        this.containsTextInside.addItemListener(e -> containsTextInsideAction(e));
        LOOGER.info("add exit");
    }

    private void containsTextInsideAction(ItemEvent e) {
        LOOGER.info("containsTextInsideAction init");
        if (e.getStateChange() == 1) {
            this.containsJTextField.setEditable(true);
            this.containsJTextField.setPlaceHolderColor(Color.RED);
            this.containsJTextField.setPlaceHolderText("Type a word");
        }
        if (e.getStateChange() == 2) {
            this.containsJTextField.setEditable(false);
            this.containsJTextField.setPlaceHolderColor(Color.GRAY);
            this.containsJTextField.setPlaceHolderText("<- Search inside a File");
        }
        LOOGER.info("containsTextInsideAction end");
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

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param fileNameCriteria, this is file name criteria.
     */
    public void setFileNameCriteria(String fileNameCriteria) {
        LOOGER.info("setFileNameCriteria init");
        if ("all words".equalsIgnoreCase(fileNameCriteria)) {
            this.allWordsRadioButton.setSelected(true);
        }
        if ("start with".equalsIgnoreCase(fileNameCriteria)) {
            this.startWithRadioButton.setSelected(true);
        }
        if ("end with".equalsIgnoreCase(fileNameCriteria)) {
            this.endWithRadioButton.setSelected(true);
        }
        if ("equal to".equalsIgnoreCase(fileNameCriteria)) {
            this.equalsToRadioButton.setSelected(true);
        }
        LOOGER.info("setFileNameCriteria end");
    }

    /**
     * This method is to update one criteria.
     *
     * @return boolean, true when is selected, false when is unselected.
     */
    public boolean getIsContainsInsideFileCriteria() {
        LOOGER.info("getIsContainsInsideFileCriteria init");
        return containsTextInside.isSelected();
    }

    /**
     * This method is to get contains criteria.
     *
     * @return String, text of contains criteria.
     */
    public String getTextContainsInsideFileCriteria() {
        LOOGER.info("getTextContainsInsideFileCriteria init");
        return containsJTextField.getText();
    }

    /**
     * This method is to update one criteria.
     *
     * @param isContainsInsideFileCriteria, this is contains criteria.
     */
    public void setIsContainsInsideFileCriteria(boolean isContainsInsideFileCriteria) {
        LOOGER.info("setIsContainsInsideFileCriteria init");
        this.containsTextInside.setSelected(isContainsInsideFileCriteria);
        LOOGER.info("setIsContainsInsideFileCriteria end");
    }

    /**
     * This method is to update one criteria.
     *
     * @param textContainsInsideFileCriteria, this is contains criteria.
     */
    public void setTextContainsInsideFileCriteria(String textContainsInsideFileCriteria) {
        LOOGER.info("setTextContainsInsideFileCriteria init");
        this.containsJTextField.setText(textContainsInsideFileCriteria);
        LOOGER.info("setTextContainsInsideFileCriteria end");
    }
}
