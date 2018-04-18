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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for Path button.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class PathPanel extends JPanel {
    /**
     * Init logger  in Path Panel
     * */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

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

    /**
     * readOnlyCheckBox, Type: JCheckBox, this is a JCheckBox for read only.
     * */
    private JCheckBox readOnlyCheckBox;

    /**
     * readOnlyLabel, Type: JLabel, this is a JLabel for read only.
     * */
    private JLabel readOnlyLabel;

    /**
     * fileSystemCheckBox, Type: JCheckBox, this is a JCheckBox for file System.
     * */
    private JCheckBox fileSystemCheckBox;

    /**
     * fileSystemLabel, Type: JLabel, this is a JLabel for file System.
     * */
    private JLabel fileSystemLabel;

    /**
     * directoryCheckBox, Type: JCheckBox, this is a JCheckBox for directory only.
     * */
    private JCheckBox directoryCheckBox;

    /**
     * directoryLabel, Type: JLabel, this is a JLabel for directory only.
     * */
    private JLabel directoryLabel;

    /**
     * keySensitiveCheck, Type: JCheckBox, this is a JCheckBox for directory only.
     * */
    private JCheckBox keySensitiveCheck;

    /**
     * keySensitiveLabel, Type: JLabel, this is a JLabel for directory only.
     * */
    private  JLabel keySensitiveLabel;

    /**
     * Constructor for PathPanel.
     * This method is for set Layout, call initComponents(), call addComponents() and repaint() panel.
     */
    public PathPanel() {
        LOOGER.info("Get Result Entry");
        this.setLayout(new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        LOOGER.info("Get init");
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
        //Check box
        keySensitiveLabel = new JLabel("Key Sensitive");
        keySensitiveCheck = new JCheckBox();
        readOnlyCheckBox = new JCheckBox();
        readOnlyLabel = new JLabel("Read Only");
        fileSystemCheckBox = new JCheckBox();
        fileSystemLabel = new JLabel("File System");
        directoryCheckBox = new JCheckBox();
        directoryLabel = new JLabel("Directory");
        LOOGER.info("init exit");

    }

    /**
     * This method is for open file chooser and search path for folder.
     *
     * @param event, this is event from Action Listener.
     */
    private void folderChooser(ActionEvent event) {
        LOOGER.info("Get folder chooser init");
        if (directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            pathTextField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("No Selection "); // maybe you will replace this for logger.
        }
        LOOGER.info("folder chooser exit");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("add component");
        this.add(pathTextField);
        this.add(pathButton);
        //Check box
        this.add(keySensitiveCheck);
        this.add(keySensitiveLabel);
        this.add(readOnlyCheckBox);
        this.add(readOnlyLabel);
        this.add(fileSystemCheckBox);
        this.add(fileSystemLabel);
        this.add(directoryCheckBox);
        this.add(directoryLabel);
        LOOGER.info("exit add");
    }

    /**
     * This method is for return path.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathCriteria() {
        return pathTextField.getText();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains Read only selection files.
     */
    public boolean getReadOnlyOfCriteria() {
        return readOnlyCheckBox.isSelected();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains File System only selection files.
     */
    public boolean getFileSystemOfCriteria(){
        return  fileSystemCheckBox.isSelected();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains File System only selection files.
     */
    public boolean getDirectoryOfCriteria(){
        return  directoryCheckBox.isSelected();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains Key Sensitive only selection files.
     */
    public boolean getKeySensitiveOfCriteria(){
        return  keySensitiveCheck.isSelected();
    }
}
