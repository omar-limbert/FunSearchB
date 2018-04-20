/*
 * @(#)HiddenPanel.java
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

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for Hidden button.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class HiddenPanel extends JPanel {
    /**
     * Init logger  in Hidden Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * allFilesRadioButton, Type: JRadioButton, when show hidden file and no hidden file.
     */
    private JRadioButton allFilesRadioButton;
    /**
     * onlyHiddenRadioButton, Type: JRadioButton, when show only hidden files.
     */
    private JRadioButton onlyHiddenRadioButton;
    /**
     * withoutHiddenRadioButton, Type: JRadioButton, when show files without hidden files.
     */
    private JRadioButton withoutHiddenRadioButton;
    /**
     * radioButtonGroup, Type: ButtonGroup, this radio button groups will contains all radioButtons.
     */
    private ButtonGroup radioButtonGroup;

    /**
     * Constructor to HiddenPanel.
     * This method is for set layout to FlowLayout, call to iniComponents(), call to addComponents(),
     * and repaint.
     */
    public HiddenPanel() {
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
        this.allFilesRadioButton = new JRadioButton("all files");
        this.onlyHiddenRadioButton = new JRadioButton("only hidden");
        this.withoutHiddenRadioButton = new JRadioButton("without hidden");
        // Setting Action Command.
        this.allFilesRadioButton.setActionCommand("all files");
        this.onlyHiddenRadioButton.setActionCommand("only hidden");
        this.withoutHiddenRadioButton.setActionCommand("without hidden");
        LOOGER.info("init exit");
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("init add");
        // Adding radioButtons to one Group Radio Button.
        this.radioButtonGroup.add(allFilesRadioButton);
        this.radioButtonGroup.add(onlyHiddenRadioButton);
        this.radioButtonGroup.add(withoutHiddenRadioButton);
        // Adding radioButtons to Panel
        this.add(allFilesRadioButton);
        this.add(onlyHiddenRadioButton);
        this.add(withoutHiddenRadioButton);
        // Default radioButton selected.
        this.withoutHiddenRadioButton.setSelected(true);
        LOOGER.info("add exit");
    }

    /**
     * This method return Hidden File criteria.
     *
     * @return String, this is a action command can be "all files", "only hidden","without hidden".
     */
    public String getHiddenCriteria() {
        LOOGER.info("Hidden panel");
        return radioButtonGroup.getSelection().getActionCommand();
    }

    public void setIsHiddenCriteria(String isHiddenCriteria) {

        if ("all files".equalsIgnoreCase(isHiddenCriteria)) {
            this.allFilesRadioButton.setSelected(true);
        }
        if ("only hidden".equalsIgnoreCase(isHiddenCriteria)) {
            this.onlyHiddenRadioButton.setSelected(true);
        }
        if ("without hidden".equalsIgnoreCase(isHiddenCriteria)) {
            this.withoutHiddenRadioButton.setSelected(true);
        }

    }
}
