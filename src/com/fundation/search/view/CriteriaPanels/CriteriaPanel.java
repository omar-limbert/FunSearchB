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

import com.fundation.search.common.SearchLogger;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
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
     * Constructor for TopPanel.
     * This constructor call initComponents() after this
     * revalidate and repaint all panel.
     */
    public CriteriaPanel() {
        LOOGER.info("Get Result Entry");
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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        LOOGER.info("init component criteria exit");
    }

    /**
     * This method is for add all components.
     *
     * @param panelList This is Map with all criteria panels.
     */
    public void addComponent(Map<String, JPanel> panelList) {
        this.removeAll();
        LOOGER.info("Get init");
        //Adding Panel for each button
        panelList.forEach((k, v) -> this.add(v));
        // Revalidate and repaint.
        this.revalidate();
        this.repaint();
        LOOGER.info("add exit component Criteria");
    }
}
