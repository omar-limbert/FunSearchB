/*
 * @(#)SizePanel.java
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
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.util.logging.Logger;


/**
 * This class is to create the configuration for Size button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class SizePanel extends JPanel {
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    private JTextField sizeTextField;
    private JComboBox sizeComboBox;
    private JComboBox majorMinorComboBox;

    /**
     * Constructor for SizePanel.
     */

    public SizePanel() {
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
        // Iniatilize
        this.sizeTextField=new JTextField();
        sizeTextField.setPreferredSize(new Dimension(80, 25));
        this.sizeComboBox=new JComboBox();
        sizeComboBox.addItem("bit");
        sizeComboBox.addItem("Kb");
        sizeComboBox.addItem("Mb");
        sizeComboBox.addItem("Gb");

        this.majorMinorComboBox=new JComboBox();
        majorMinorComboBox.addItem("Equals:");
        majorMinorComboBox.addItem("major to:");
        majorMinorComboBox.addItem("Minor to:");
        LOOGER.info("init exit");

    }
    /**
     * This method is to add all components.
     */
    private void addComponents() {

        this.add(sizeTextField);
        this.add(sizeComboBox);
        this.add(majorMinorComboBox);

    }

    public String getSizeCriteria() {
        return sizeTextField.getText();

    }


}
