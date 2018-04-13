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

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Dimension;


/**
 * This class is to create the configuration for Size button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class SizePanel extends JPanel {

    private JTextField sizeTextField;
    private JComboBox sizeComboBox;
    private JComboBox majorMinorComboBox;

    /**
     * Constructor for SizePanel.
     */

    public SizePanel() {

        this.setLayout(new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();

    }

    /**
     * This method is for initialize all components.
     */

    private void initComponents() {

        // Iniatilize
        this.sizeTextField=new JTextField();
        sizeTextField.setPreferredSize(new Dimension(100, 35));
        this.sizeComboBox=new JComboBox();
        sizeComboBox.addItem("bit");
        sizeComboBox.addItem("Kb");
        sizeComboBox.addItem("Mb");
        sizeComboBox.addItem("Gb");

        this.majorMinorComboBox=new JComboBox();
        majorMinorComboBox.addItem("Equals:");
        majorMinorComboBox.addItem("major to:");
        majorMinorComboBox.addItem("Minor to:");

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
