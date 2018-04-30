/*
 * @(#)TopPanel.java
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
package com.fundation.search.view.MainWindow;

import com.fundation.search.common.SearchLogger;
import com.fundation.search.view.CriteriaPanels.DataBasePanel;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.util.logging.Logger;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class BottomPanel extends JPanel {
    /**
     * Init logger  in Top Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();


    /**
     * Constructor for TopPanel.
     * This method is for initialize searchButton, setting layout and repaint panel.
     */
    public BottomPanel() {
        LOOGER.info("Get top panel Entry");
        this.setOpaque(false);
        this.initComponents();
        this.addComponents();
        this.repaint();
        LOOGER.info("top panel exit");
    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        LOOGER.info("Get init components");

        LOOGER.info("components exit");
    }

    /**
     * This method is for add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add Components Entry");

        LOOGER.info("add Components exit");
    }

}
