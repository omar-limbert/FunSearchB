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
     * toggleButtonCollection Collection of JToggleButtons.
     */
    private Collection<JToggleButton> toggleButtonCollection;
    private String action;
    private CriteriaPanel criteriaPanel;
    private Map<String, JPanel> panelList;
    private static final FileNamePanel FILE_NAME_PANEL = new FileNamePanel();
    private static final PathPanel PATH_PANEL = new PathPanel();

    /**
     * Constructor for SearchToolBar.
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
     * Method add criteria panel.
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
     * This method is return Path criteria.
     *
     * @return String.
     */
    public String getPathOfCriteria() {
        return PATH_PANEL.getPathCriteria();
    }

    /**
     * This method is return File Name criteria.
     *
     * @return String.
     */
    public String getFileNameOfCriteria() {
        return FILE_NAME_PANEL.getFileNameCriteria();
    }

    /**
     * This method is return Hidden files criteria.
     *
     * @return String.
     */
    public boolean isShowHiddenFilesChecked() {

        return FILE_NAME_PANEL.isHiddenFilesChecked();
    }
}
