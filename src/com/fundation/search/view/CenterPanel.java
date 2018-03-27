/*
 * @(#)CenterPanel.java
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

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * This class is for create Center Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class CenterPanel extends JPanel {


    /**
     * Constructor for CentralPanel.
     */
    public CenterPanel() {
        this.setLayout(new GridLayout(2, 1));
        this.initComponents();
        this.addComponents();

    }
    /**
     * This method is for initialize all components.
     */
    public void initComponents() {
        //  this.searchJTable = new SearchJTable();


    }
    /**
     * This method is for add all components.
     */
    public void addComponents() {
//        this.add(searchJTable);

    }

}
