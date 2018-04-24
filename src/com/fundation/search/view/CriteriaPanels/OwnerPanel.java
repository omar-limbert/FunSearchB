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
import com.fundation.search.view.SearchTextField;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for Owner button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class OwnerPanel extends JPanel {
    /**
     * Init logger  in Owner Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * ownerTextField, Type: JTextField, this is a JTextField for contains final owner result.
     */
    private SearchTextField ownerTextField;

    /**
     * ownerLabelField, Type: JLabel, this is a JLabel for contains label.
     */
    private JLabel ownerLabelField;

    /**
     * Constructor for OwnerPanel.
     */
    public OwnerPanel() {
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
        this.ownerTextField = new SearchTextField("e.g. Administrator");
        this.ownerTextField.setPreferredSize(new Dimension(250, 32));
        LOOGER.info("init exit");
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("add init");
        this.add(ownerLabelField);
        this.add(ownerTextField);
        LOOGER.info("exit add");
    }

    /**
     * This method is for return owner.
     *
     * @return String, this contains Owner.
     */
    public String getOwnerCriteria() {
        LOOGER.info("Get Owner Panel");
        return ownerTextField.getText();
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param ownerCriteria, this is owner criteria.
     */
    public void setOwnerCriteria(String ownerCriteria) {
        this.ownerTextField.setText(ownerCriteria);
    }
}
