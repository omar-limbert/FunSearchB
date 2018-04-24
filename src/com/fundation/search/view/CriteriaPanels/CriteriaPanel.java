/*
 * @(#)CriteriaPanel.java
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
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import java.util.logging.Logger;


/**
 * This class is to create Criteria Panel with all sub-panels.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class CriteriaPanel extends JPanel {
    /**
     * Init logger  in Criteria Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Constrains to set layout on Criteria Panel.
     */
    private GridBagConstraints constraints;

    /**
     * Constructor for TopPanel.
     * This constructor call initComponents() after this
     * revalidate and repaint all panel.
     */
    public CriteriaPanel() {
        LOOGER.info("Get Result Entry");
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.initComponents();
        this.revalidate();
        this.repaint();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method is for initialize all components.
     * This is for set Layout to BoxLayout on vertical position.
     */
    private void initComponents() {
        LOOGER.info("Get init");
        this.setLayout(new GridBagLayout());
        LOOGER.info("init component criteria exit");
    }

    /**
     * This method is for add all components.
     *
     * @param panelList This is Map with all criteria panels.
     */
    public void addComponent(Map<String, JPanel> panelList) {
        LOOGER.info("Get init");
        this.removeAll();

        //Adding Panel for each button
        panelList.forEach((k, v) -> this.addCriteriaPanel(k, v));

        // Revalidate and repaint.
        this.revalidate();
        this.repaint();
        LOOGER.info("add exit component Criteria");
    }

    /**
     * This method is for change border of Criteria panel.
     *
     * @param tittle This is tittle for Panel.
     */
    public void setBorderCriteriaPanel(String tittle) {
        LOOGER.info("setBorderCriteriaPanel init");
        if (tittle != null) {
            this.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(tittle),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        } else {
            this.setBorder(null);
        }
        LOOGER.info("setBorderCriteriaPanel exit");
    }

    /**
     * This method is for add one panel to Criteria Panel.
     *
     * @param namePanel Name of panel.
     * @param criteriaPanel Panel for add to Criteria Panel.
     */
    private void addCriteriaPanel(String namePanel, JPanel criteriaPanel) {
        LOOGER.info("addCriteriaPanel init");
        if ("Path".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 3;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("File Name".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 3;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Hidden".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Type".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Owner".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 2;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Size".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("date".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Data Base".equalsIgnoreCase(namePanel)) {
            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Multimedia".equalsIgnoreCase(namePanel)) {
            constraints.gridx =1;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        if ("Audio".equalsIgnoreCase(namePanel)) {
            constraints.gridx =1;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            this.add(criteriaPanel, constraints);
        }
        LOOGER.info("addCriteriaPanel end");
    }

}
