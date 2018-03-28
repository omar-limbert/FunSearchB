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

import com.fundation.search.view.SearchTextField;

import javax.swing.*;
import java.awt.*;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class PathPanel extends JPanel {


    private JFileChooser directoryChooser;
    private JButton pathButton;
    private SearchTextField pathTextField;

    /**
     * Constructor for TopPanel.
     * This is text for place holder.
     */
    public PathPanel() {



        this.setLayout (new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();

        //  System.out.println("Ariel =>"+searchTextField.getText());
    }
    /**
     * This method is for initialize all components.
     * This is text for place holder.
     */
    public void initComponents() {

        directoryChooser = new JFileChooser();
        directoryChooser.setCurrentDirectory(new java.io.File("/"));
        directoryChooser.setDialogTitle("choosertitle");
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.setAcceptAllFileFilterUsed(false);

        pathButton = new JButton();
        pathButton.setText("Choose Folder");

        pathTextField = new SearchTextField(directoryChooser.getCurrentDirectory().getPath());
        pathTextField.setEditable(false);



        if (directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + directoryChooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + directoryChooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
    }
    /**
     * This method is for add all components.
     */
    public void addComponents() {
        this.add(pathTextField);
        this.add(pathButton);


    }
    /**
     * This method is for add all components.
     */
    public String getPathCriteria(){

        return pathTextField.getText();
    }

}
