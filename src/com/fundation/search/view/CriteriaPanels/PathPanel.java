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


    private JFileChooser directoryChooser;
    private JButton pathButton;
    private JTextField pathTextField;

    /**
     * Constructor for PathPanel.
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


    }

    /**
     * This method is for open file chooser and search path for folder.
     *
     * @param event
     */
    private void folderChooser(ActionEvent event) {

        if (directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            pathTextField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("No Selection ");
        }
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {

        this.add(pathTextField);
        this.add(pathButton);
    }

    /**
     * This method is for return path.
     *
     * @return String
     */
    public String getPathCriteria() {

        return pathTextField.getText();

    }

}
