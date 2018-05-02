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
import com.fundation.search.view.SearchTextField;


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for Size button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class SizePanel extends JPanel {
    /**
     * Init logger  in Size Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * This is color to set all labels.
     */
    private static final Color FONT_COLOR = Color.WHITE;

    /**
     * sizeTextField, Type: SearchTextField, this is a JTextField for contains final size result.
     */
    private SearchTextField sizeTextField;

    /**
     * sizeComboBox, Type: JComboBox, this is a JComboBox for contains final size.
     */
    private JComboBox sizeComboBox;

    /**
     * majorMinorComboBox, Type: JComboBox, this is a JComboBox for contains major.
     */
    private JComboBox majorMinorComboBox;

    /**
     * sizeLabel, Type: JLabel, this is Label for size
     */
    private JLabel sizeLabel;

    /**
     * Constructor for SizePanel.
     */
    public SizePanel() {
        LOOGER.info("Get Result Entry");
        this.setOpaque(false);
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
        this.sizeTextField = new SearchTextField("Size");
        this.sizeLabel = new JLabel("Size :");
        this.sizeLabel.setForeground(FONT_COLOR);
        this.sizeTextField.setPreferredSize(new Dimension(100, 32));
        this.sizeComboBox = new JComboBox();
        this.sizeComboBox.addItem("Bytes");
        this.sizeComboBox.addItem("Kb");
        this.sizeComboBox.addItem("Mb");
        this.sizeComboBox.addItem("Gb");
        this.majorMinorComboBox = new JComboBox();
        this.majorMinorComboBox.addItem("Equal to:");
        this.majorMinorComboBox.addItem("Major to:");
        this.majorMinorComboBox.addItem("Minor to:");
        LOOGER.info("init exit");

    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("Get init");
        this.add(sizeLabel);
        this.add(majorMinorComboBox);
        this.add(sizeTextField);
        this.add(sizeComboBox);
        LOOGER.info("Get init");

    }

    /**
     * This method is for return type.
     *
     * @return String, this contains type.
     */
    public String[] getSizeCriteria() {
        LOOGER.info("Get Size Panel");
        return new String[]{majorMinorComboBox.getModel().getSelectedItem().toString()
                , sizeTextField.getText(), sizeComboBox.getModel().getSelectedItem().toString()};

    }

    /**
     * This method is to update one criteria.
     *
     * @param typeCriteria, this is type of size criteria.
     */
    public void setTypeCriteria(String typeCriteria) {
        sizeComboBox.getModel().setSelectedItem(typeCriteria);
    }

    /**
     * This method is to update one criteria.
     *
     * @param operatorCriteria, this is operator of size criteria.
     */
    public void setOperatorCriteria(String operatorCriteria) {
        if("upper".equalsIgnoreCase(operatorCriteria)){
            majorMinorComboBox.getModel().setSelectedItem("Major to:");
        }
        if("lower".equalsIgnoreCase(operatorCriteria)){
            majorMinorComboBox.getModel().setSelectedItem("Minor to:");
        }
        if("equal".equalsIgnoreCase(operatorCriteria)){
            majorMinorComboBox.getModel().setSelectedItem("Equal to:");
        }
    }

    /**
     * This method is to update one criteria.
     *
     * @param sizeCriteria, this is size criteria.
     */
    public void setSizeCriteria(long sizeCriteria) {
        this.sizeTextField.setText(String.valueOf(sizeCriteria));
    }
}
