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

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * This class is to create the configuration for File Name button.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class FileNamePanel extends JPanel {

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
     * hiddenFileJCheckButton, Type: TopPanel, this is for search with/without hidden files.
     */
    private JCheckBox hiddenFileJCheckButton;

    /**
     * Constructor to FileNamePanel.
     * This method is for set layout to FlowLayout, call to iniComponents(), call to addComponents(),
     * and repaint.
     */
    public FileNamePanel() {
        // Setting layout to FlowLayout.
        this.setLayout(new FlowLayout());
        // Calling to initComponents() method.
        this.initComponents();
        // Callind to addComponents() method.
        this.addComponents();
        // repaint.
        this.repaint();
    }

    /**
     * This method is to initialize all components.
     */
    private void initComponents() {
        // Initialize Hidden Check Button.
        this.hiddenFileJCheckButton = new JCheckBox();
        this.hiddenFileJCheckButton.setText("Hidden Files");
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
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
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
        this.add(hiddenFileJCheckButton);
        // Default radioButton selected.
        this.allWordsRadioButton.setSelected(true);
    }

    /**
     * This method return Hidden File criteria.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameCriteria() {
        return radioButtonGroup.getSelection().getActionCommand();
    }

    /**
     * This method is to get state of hiddenFileJCheckBox.
     *
     * @return boolean, true for search with hidden files and false for search without hidden files.
     */
    public boolean isHiddenFilesChecked() {
        return hiddenFileJCheckButton.isSelected();
    }

}
