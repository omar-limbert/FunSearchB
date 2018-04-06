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

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

/**
 * This class is to create the configuration for Hidden button.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class HiddenPanel extends JPanel {

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

        // Initialize RadioButtons.
        this.radioButtonGroup = new ButtonGroup();
        this.allFilesRadioButton = new JRadioButton("all files");
        this.onlyHiddenRadioButton = new JRadioButton("only hidden");
        this.withoutHiddenRadioButton = new JRadioButton("without hidden");
        // Setting Action Command.
        this.allFilesRadioButton.setActionCommand("all files");
        this.onlyHiddenRadioButton.setActionCommand("only hidden");
        this.withoutHiddenRadioButton.setActionCommand("without hidden");
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
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
    }

    /**
     * This method return Hidden File criteria.
     *
     * @return String, this is a action command can be "all files", "only hidden","without hidden".
     */
    public String getHiddenCriteria() {
        return radioButtonGroup.getSelection().getActionCommand();
    }

}
