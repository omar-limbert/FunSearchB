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

    private JRadioButton allWordsRadioButton;
    private JRadioButton startWithRadioButton;
    private JRadioButton endWithRadioButton;
    private JRadioButton equalsToRadioButton;

    private ButtonGroup radioButtonGroup;

    private JCheckBox hiddenFileJCheckButton;

    /**
     * Constructor to FileNamePanel.
     */
    public FileNamePanel() {

        this.setLayout(new FlowLayout());
        this.initComponents();
        this.addComponents();
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
     * This method is to get File Name criteria.
     *
     * @return String
     */
    public String getFileNameCriteria() {

        return radioButtonGroup.getSelection().getActionCommand();

    }

    /**
     * This method is to get state of hiddenFileJCheckBox.
     *
     * @return boolean
     */
    public boolean isHiddenFilesChecked() {
        return hiddenFileJCheckButton.isSelected();
    }

}
