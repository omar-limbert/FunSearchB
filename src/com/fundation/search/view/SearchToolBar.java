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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
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

    /**
     * Constructor for SearchToolBar.
     */
    public SearchToolBar(CriteriaPanel criteriaPanel) {

        this.toggleButtonCollection = new Vector<>();
        this.action ="";
        this.criteriaPanel = criteriaPanel;


        // adding buttons
        this.addButtonToToggleCollection("All Tags");
        this.addButtonToToggleCollection("File Name");
        this.addButtonToToggleCollection("Path");
        this.addButtonToToggleCollection("Type");
        this.addButtonToToggleCollection("Size");
        this.addButtonToToggleCollection("Owner");
        this.addButtonToToggleCollection("Date");

        this.addActionListeners();


    }
    /**
     * Method addActionListeners.
     *
     */
    protected void addActionListeners() {
        for(JToggleButton button:toggleButtonCollection){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JToggleButton sourceButton = (JToggleButton) e.getSource();

                    String newAction = sourceButton.isSelected() ? e.getActionCommand():"";
                    firePropertyChange("action",action,newAction);

                    action = e.getActionCommand();
                    //System.out.println(action + " selected");

                    if(sourceButton.isSelected()){
                        System.out.println(action + " selected");
                        if(action.equalsIgnoreCase("File Name")){

                            criteriaPanel.addComponent(new FileNamePanel());
                        }
                        if(action.equalsIgnoreCase("Path")){

                            criteriaPanel.addComponent(new PathPanel());
                        }

                    }
                    else{

                        System.out.println(action + " not selected");
                    }

                    for(JToggleButton toggleButton: toggleButtonCollection){
                        if(!toggleButton.equals(sourceButton)){
                            toggleButton.setSelected(false);
                        }
                    }


                }
            });

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
        toggleButtonCollection.add(buttonToAddCollection);
    }
}
