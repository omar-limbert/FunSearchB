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

import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * This class is to create the configuration for Path button.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class PathPanel extends JPanel {

    /**
     * directoryChooser, Type: JFileChooser, this is a file chooser for get path of directory.
     */
    private JFileChooser directoryChooser;
    /**
     * pathButton, Type: JButton, this is a button for open JFileChooser.
     */
    private JButton pathButton;
    /**
     * pathTextField, Type: JTextField, this is a JTextField for contains final path result.
     */
    private JTextField pathTextField;


    private JCheckBox readOnlyCheckBox;
    private JLabel readOnlyLabel;
    private JCheckBox fileSystemCheckBox;
    private JLabel fileSystemLabel;
    /**
     * Constructor for PathPanel.
     * This method is for set Layout, call initComponents(), call addComponents() and repaint() panel.
     */
    public PathPanel() {
        this.setLayout(new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();
    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {

        // Initialize and config Folder Chooser.
        directoryChooser = new JFileChooser();
        directoryChooser.setCurrentDirectory(new java.io.File("/"));
        directoryChooser.setDialogTitle("Folder chooser for search files");
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.setAcceptAllFileFilterUsed(false);
        // Button for open Folder Chooser.
        pathButton = new JButton();
        pathButton.setText("Choose Folder");
        // Action Listener for Folder Chooser.
        pathButton.addActionListener(e -> folderChooser(e));
        // JTextField for show result.
        pathTextField = new JTextField();
        pathTextField.setPreferredSize(new Dimension(200, 35));
        pathTextField.setText(directoryChooser.getCurrentDirectory().getPath());

        readOnlyCheckBox = new JCheckBox();
        readOnlyLabel = new JLabel("Read Only");
        fileSystemCheckBox = new JCheckBox();
        fileSystemLabel = new JLabel("File System");

    }

    /**
     * This method is for open file chooser and search path for folder.
     *
     * @param event, this is event from Action Listener.
     */
    private void folderChooser(ActionEvent event) {
        if (directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            pathTextField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("No Selection "); // maybe you will replace this for logger.
        }
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        this.add(pathTextField);
        this.add(pathButton);
        this.add(readOnlyCheckBox);
        this.add(readOnlyLabel);
        this.add(fileSystemCheckBox);
        this.add(fileSystemLabel);

    }

    /**
     * This method is for return path.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathCriteria() {
        return pathTextField.getText();
    }


}
