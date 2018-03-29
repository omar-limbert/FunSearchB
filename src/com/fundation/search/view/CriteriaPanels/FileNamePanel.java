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
 * This class is for create the configuration for File Name button.
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

    private JCheckBox showHiddenFiles;

    /**
     * Constructor for FileNamePanel.
     */
    public FileNamePanel() {

        this.setLayout(new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();

    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {

        this.showHiddenFiles = new JCheckBox();

        this.showHiddenFiles.setText("Hidden Files");
        this.radioButtonGroup = new ButtonGroup();
        this.allWordsRadioButton = new JRadioButton("all words");
        this.startWithRadioButton = new JRadioButton("start with");
        this.endWithRadioButton = new JRadioButton("end with");
        this.equalsToRadioButton = new JRadioButton("equal to");

        this.allWordsRadioButton.setActionCommand("all words");
        this.startWithRadioButton.setActionCommand("start with");
        this.endWithRadioButton.setActionCommand("end with");
        this.equalsToRadioButton.setActionCommand("equal to");

        this.radioButtonGroup.add(allWordsRadioButton);
        this.radioButtonGroup.add(startWithRadioButton);
        this.radioButtonGroup.add(endWithRadioButton);
        this.radioButtonGroup.add(equalsToRadioButton);

        this.allWordsRadioButton.setSelected(true);
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {

        this.add(allWordsRadioButton);
        this.add(startWithRadioButton);
        this.add(endWithRadioButton);
        this.add(equalsToRadioButton);
        this.add(showHiddenFiles);

    }

    /**
     * This method is for add all components.
     *
     * @return only one radioButton selected.
     */
    public String getFileNameCriteria() {

        return radioButtonGroup.getSelection().getActionCommand();

    }

    /**
     * This method is for add all components.
     *
     * @return state of hidden button.
     */
    public boolean isShowHiddenFilesChecked() {
        return showHiddenFiles.isSelected();
    }

}
