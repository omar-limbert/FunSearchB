/*
 * @(#)SearchToolBar.java
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
package com.fundation.search.view;

import com.fundation.search.view.CriteriaPanels.CriteriaPanel;
import com.fundation.search.view.CriteriaPanels.FileNamePanel;
import com.fundation.search.view.CriteriaPanels.PathPanel;

import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

/**
 * This class is for create buttons inside to JToolBar.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchToolBar extends JToolBar {


    /**
     * toggleButtonCollection, Type: Collection<JToggleButton>, this is a collection of buttons.
     */
    private Collection<JToggleButton> toggleButtonCollection;
    /**
     * action, Type: String, this is action of one button.
     */
    private String action;
    /**
     * criteriaPanel, Type: CriteriaPanel, this criteria panel.
     */
    private CriteriaPanel criteriaPanel;
    /**
     * panelList, Type: Map<String, JPanel>, this is a Map of panels.
     */
    private Map<String, JPanel> panelList;
    /**
     * FILE_NAME_PANEL, Type: FileNamePanel, this is a File Name criteria Panel
     */
    private static final FileNamePanel FILE_NAME_PANEL = new FileNamePanel();
    /**
     * PATH_PANEL, Type: PathPanel, this Path criteria Panel.
     */
    private static final PathPanel PATH_PANEL = new PathPanel();
    // Here you will add other panels.

    /**
     * Constructor for SearchToolBar.
     * This method is for initialize toggleButtonCollection, action, criteriaPanel and panelList.
     */
    public SearchToolBar(CriteriaPanel criteriaPanel) {
        // This is a collection of buttons.
        this.toggleButtonCollection = new Vector<>();
        // Action for define button.
        this.action = "";
        // Dynamic JPanel for add all button panels.
        this.criteriaPanel = criteriaPanel;
        // Hashtable of all Criteria Panels
        this.panelList = new Hashtable<>();
        // Adding components
        this.addComponents();
    }

    /**
     * Method for add al components.
     */
    private void addComponents() {
        // adding buttons
        this.addButtonToToggleCollection("All Tags");
        this.addButtonToToggleCollection("File Name");
        this.addButtonToToggleCollection("Path");
        this.addButtonToToggleCollection("Type");
        this.addButtonToToggleCollection("Size");
        this.addButtonToToggleCollection("Owner");
        this.addButtonToToggleCollection("Date");
        // you need implements others buttons here.
        // Adding action listeners for all buttons
        this.addActionListeners();
    }

    /**
     * Method addActionListeners.
     */
    private void addActionListeners() {
        // lambda is amazing..!! XD
        toggleButtonCollection
                .forEach(e -> e.addActionListener(this::actionListenerForAllButtons));

    }

    /**
     * Method addActionListeners.
     *
     * @param actionEvent This is action event.
     */
    private void actionListenerForAllButtons(ActionEvent actionEvent) {
        JToggleButton sourceButton = (JToggleButton) actionEvent.getSource();
        // Action when a button is selected.
        String newAction = sourceButton.isSelected() ? actionEvent.getActionCommand() : "";
        firePropertyChange("action", action, newAction);
        action = actionEvent.getActionCommand();
        if (sourceButton.isSelected()) {
            this.addingCriteriaPanelToActionListenerButton();
        } else {
            this.removingCriteriaPanelToActionListenerButton();
        }
        criteriaPanel.addComponent(panelList);
    }

    /**
     * Method for remove criteria panel.
     */
    private void removingCriteriaPanelToActionListenerButton() {
        // Removing "All Tags Panel Criteria"
        if (action.equalsIgnoreCase("All Tags")) {
            panelList = new Hashtable<>();
        }
        // Removing "File Name Panel Criteria"
        if (action.equalsIgnoreCase("File Name")) {
            panelList.remove(action);
        }
        // Removing "Path Panel Criteria"
        if (action.equalsIgnoreCase("Path")) {
            panelList.remove(action);
        }
    }

    /**
     * Method for add criteria panel to panelList.
     */
    private void addingCriteriaPanelToActionListenerButton() {
        // Adding "All Tags Panel Criteria"
        if (action.equalsIgnoreCase("All Tags")) {
            panelList.put("File Name", FILE_NAME_PANEL);
            panelList.put("Path", PATH_PANEL);
        }
        // Adding "File Name Panel Criteria"
        if (action.equalsIgnoreCase("File Name")) {
            panelList.put(action, FILE_NAME_PANEL);
        }
        // Adding "Path Panel Criteria"
        if (action.equalsIgnoreCase("Path")) {
            panelList.put(action, PATH_PANEL);
        }
    }

    /**
     * Method addButtonToToggleCollection.
     * This method is for JToggleButtons to Collection.
     *
     * @param nameOfJToggleButton Name of JToggleButton to add collection.
     */
    private void addButtonToToggleCollection(String nameOfJToggleButton) {
        JToggleButton buttonToAddCollection = new JToggleButton(nameOfJToggleButton);
        this.add(buttonToAddCollection);
        this.toggleButtonCollection.add(buttonToAddCollection);
    }

    /**
     * This method is for return path.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getPathOfCriteria() {
        return PATH_PANEL.getPathCriteria();
    }

    /**
     * This method return Hidden File criteria.
     *
     * @return String, this is a action command can be "all words", "start with", "end with" and "equal to".
     */
    public String getFileNameOfCriteria() {
        return FILE_NAME_PANEL.getFileNameCriteria();
    }

    /**
     * This method is to get state of hiddenFileJCheckBox.
     *
     * @return boolean, true for search with hidden files and false for search without hidden files.
     */
    public boolean isShowHiddenFilesChecked() {

        return FILE_NAME_PANEL.isHiddenFilesChecked();
    }
}
