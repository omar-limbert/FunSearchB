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
import com.fundation.search.view.CriteriaPanels.DatePanel;
import com.fundation.search.view.CriteriaPanels.FileNamePanel;
import com.fundation.search.view.CriteriaPanels.HiddenPanel;
import com.fundation.search.view.CriteriaPanels.OwnerPanel;
import com.fundation.search.view.CriteriaPanels.PathPanel;
import com.fundation.search.view.CriteriaPanels.SizePanel;

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
import  java.util.Date;



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
    /**
     * HIDDEN_PANEL, Type: HiddenPanel, this Hidden criteria Panel.
     */
    private static final HiddenPanel HIDDEN_PANEL = new HiddenPanel();
    /**
     * SIZE_PANEL, Type: SizePanel, this Size criteria Panel.
     */
    private static final SizePanel SIZE_PANEL = new SizePanel();
    /**
     * OWNER_PANEL, Type: OwnerPanel, this Owner criteria Panel.
     */
    private static final OwnerPanel OWNER_PANEL = new OwnerPanel();
    /**
     * DATE_PANEL, Type: DatePanel, this Date criteria Panel.
     */
    private  static final  DatePanel DATE_PANEL = new DatePanel();

    /**
     * Constructor for SearchToolBar.
     * This method is for initialize toggleButtonCollection, action, criteriaPanel and panelList.
     */
    public SearchToolBar(CriteriaPanel criteriaPanel) {
        System.out.println("SearchToolBAr ");
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
        System.out.println("addComponents");
        // adding buttons
        this.addButtonToToggleCollection("All Tags");
        this.addButtonToToggleCollection("File Name");
        this.addButtonToToggleCollection("Path");
        this.addButtonToToggleCollection("Hidden");
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
        System.out.println("ActionButton");
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
        // Removing "Hidden Panel Criteria"
        if (action.equalsIgnoreCase("Hidden")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Size")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Owner")) {
            panelList.remove(action);
        }
        if (action.equalsIgnoreCase("Date")) {
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
            panelList.put("Hidden", HIDDEN_PANEL);
            panelList.put("Size", SIZE_PANEL);
            panelList.put("Owner", OWNER_PANEL);
            panelList.put("Date", DATE_PANEL);
        }
        // Adding "File Name Panel Criteria"
        if (action.equalsIgnoreCase("File Name")) {
            panelList.put(action, FILE_NAME_PANEL);
        }
        // Adding "Path Panel Criteria"
        if (action.equalsIgnoreCase("Path")) {
            panelList.put(action, PATH_PANEL);
        }
        // Adding "Hidden Panel Criteria"
        if (action.equalsIgnoreCase("Hidden")) {
            panelList.put(action, HIDDEN_PANEL);
        }
        // Adding "Size Panel Criteria"
        if (action.equalsIgnoreCase("Size")) {
            panelList.put(action, SIZE_PANEL);
        }
        // Adding "Owner Panel Criteria"
        if (action.equalsIgnoreCase("Owner")) {
            panelList.put(action, OWNER_PANEL);
        }
        // Adding "Date Panel Criteria"
        if (action.equalsIgnoreCase("Date")) {
            panelList.put(action, DATE_PANEL);
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
     * This method is for return Size.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getSizeCriteria() {
        return  SIZE_PANEL.getSizeCriteria();
    }
    /**
     * This method is for return owner.
     *
     * @return String, this contains a complete path for search files.
     */
    public String getOwnerCriteria() {
        return  OWNER_PANEL.getOwnerCriteria();
    }
    /**
     * This method is for return Date.
     *
     * @return date, this contains a complete path for search files.
     */
    public Date getDateCreationCriteria() {
        return  DATE_PANEL.getDateCreationCriteria();
    }
    public Date getDateToCreationCriteria() {
        return  DATE_PANEL.getDatetoCreationCriteria();
    }
    public Date getDateModificationCriteria() {
        return  DATE_PANEL.getDateModificationCriteria();
    }
    public Date getDateToModificationCriteria() {
        return  DATE_PANEL.getDateToModificationCriteria();
    }
    public Date getDateLastOpenedCriteria() {
        return  DATE_PANEL.getDateLastOpenedCriteria();
    }
    public Date getDateToLastOpenedCriteria() {
        return  DATE_PANEL.getDateToLastOpenedCriteria();
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
     * This method is to get state of hiddenFile.
     * Controller nee ise this.
     *
     * @return String, ""all files",""only hidden files",""without hidden files".
     */
    public String getHiddenOfCriteria() { return HIDDEN_PANEL.getHiddenCriteria(); }
}
