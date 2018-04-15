/*
 * @(#)OwnerPanel.java
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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.util.logging.Logger;


/**
 * This class is to create the configuration for Owner button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class OwnerPanel extends JPanel{

    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    private  JTextField ownerTextField;
    private JLabel ownerLabelField;

    /**
    * Constructor for OwnerPanel.
    * */

    public  OwnerPanel(){
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
        //Initialize
        this.ownerLabelField = new JLabel("Owner: ");
        this.ownerTextField = new JTextField();
        ownerTextField.setPreferredSize(new Dimension(100, 25));
        LOOGER.info("init exit");
    }
    /**
     * This method is to add all components.
     */
    private void addComponents() {
        this.add(ownerLabelField);
        this.add(ownerTextField);
    }

    public String getOwnerCriteria(){
        return ownerTextField.getText();
    }


}
