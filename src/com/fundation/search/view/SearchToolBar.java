/*
 * @(#)SearchToolBar.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.view;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;
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

    /**
     * Constructor for SearchToolBar.
     */
    public SearchToolBar() {

        toggleButtonCollection = new Vector<>();

        // adding buttons
        this.addButtonToToggleCollection("All Tags");
        this.addButtonToToggleCollection("File Name");
        this.addButtonToToggleCollection("Path");
        this.addButtonToToggleCollection("Type");
        this.addButtonToToggleCollection("Size");
        this.addButtonToToggleCollection("Owner");
        this.addButtonToToggleCollection("Date");


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
