/*
 * @(#)PathPanel.java
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
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * This is color to set all labels.
     */
    private static final Color FONT_COLOR = Color.WHITE;

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
     */
    private JCheckBox readOnlyCheckBox;

    /**
     * readOnlyLabel, Type: JLabel, this is a JLabel for read only.
     */
    private JLabel readOnlyLabel;

    /**
     * fileSystemCheckBox, Type: JCheckBox, this is a JCheckBox for file System.
     */
    private JCheckBox fileSystemCheckBox;

    /**
     * fileSystemLabel, Type: JLabel, this is a JLabel for file System.
     */
    private JLabel fileSystemLabel;

    /**
     * directoryCheckBox, Type: JCheckBox, this is a JCheckBox for directory only.
     */
    private JCheckBox directoryCheckBox;

    /**
     * directoryLabel, Type: JLabel, this is a JLabel for directory only.
     */
    private JLabel directoryLabel;

    /**
     * keySensitiveCheck, Type: JCheckBox, this is a JCheckBox for directory only.
     */
    private JCheckBox keySensitiveCheck;

    /**
     * keySensitiveLabel, Type: JLabel, this is a JLabel for directory only.
     */
    private JLabel keySensitiveLabel;

    /**
     * inputLabel, Type: JLabel, this is JLabel for file chooser.
     */
    private JLabel inputLabel;

    /**
     * Constructor for PathPanel.
     * This method is for set Layout, call initComponents(), call addComponents() and repaint() panel.
     */
    public PathPanel() {
        LOOGER.info("Get Result Entry");
        this.setOpaque(false);
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
        inputLabel = new JLabel("Path: ");
        inputLabel.setForeground(FONT_COLOR);
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
        pathTextField.setEnabled(true);
        //Check box
        keySensitiveLabel = new JLabel("Key Sensitive");
        keySensitiveLabel.setForeground(FONT_COLOR);
        keySensitiveCheck = new JCheckBox();
        readOnlyCheckBox = new JCheckBox();
        readOnlyLabel = new JLabel("Read Only");
        readOnlyLabel.setForeground(FONT_COLOR);
        fileSystemCheckBox = new JCheckBox();
        fileSystemLabel = new JLabel("File System");
        fileSystemLabel.setForeground(FONT_COLOR);
        directoryCheckBox = new JCheckBox();
        directoryLabel = new JLabel("Directory");
        directoryLabel.setForeground(FONT_COLOR);
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
        this.add(inputLabel);
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
        LOOGER.info("Get path Panel");
        return pathTextField.getText();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains Read only selection files.
     */
    public boolean getReadOnlyOfCriteria() {
        LOOGER.info("Get read only Panel");
        return readOnlyCheckBox.isSelected();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains File System only selection files.
     */
    public boolean getFileSystemOfCriteria() {
        LOOGER.info("Get File system Panel");
        return fileSystemCheckBox.isSelected();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains File System only selection files.
     */
    public boolean getDirectoryOfCriteria() {
        LOOGER.info("Get directory Panel");
        return directoryCheckBox.isSelected();
    }

    /**
     * This method is for return path.
     *
     * @return boolean, this contains Key Sensitive only selection files.
     */
    public boolean getKeySensitiveOfCriteria() {
        LOOGER.info("Get key sensitive Panel");
        return keySensitiveCheck.isSelected();
    }

    /**
     * This method is to update one criteria.
     *
     * @param isReadOnlyCriteria, this is Read Only criteria.
     */
    public void setIsReadOnlyCriteria(boolean isReadOnlyCriteria) {
        this.readOnlyCheckBox.setSelected(isReadOnlyCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isFileSystemCriteria, true is File System and false is not file system.
     */
    public void setIsFileSystemCriteria(boolean isFileSystemCriteria) {
        this.fileSystemCheckBox.setSelected(isFileSystemCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param isDirectoryCriteria, true is directory and false is not directory.
     */
    public void setIsDirectoryCriteria(boolean isDirectoryCriteria) {
        this.directoryCheckBox.setSelected(isDirectoryCriteria);
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param pathCriteria, this is path criteria.
     */
    public void setPathCriteria(String pathCriteria) {
        this.pathTextField.setText(pathCriteria);
    }

    public void setKeySensitiveOfCriteria(boolean keySensitiveOfCriteria) {
        this.keySensitiveCheck.setSelected(keySensitiveOfCriteria);
    }
}
