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


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;


/**
 * This class is to create the configuration for Owner button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class OwnerPanel extends JPanel{
    private  JTextField ownerTextField;
    private JLabel ownerLabelField;

    /**
    * Constructor for OwnerPanel.
    * */

    public  OwnerPanel(){
        this.setLayout(new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();

    }
    /**
     * This method is for initialize all components.
     */
    private void initComponents() {
        //Initialize
        this.ownerLabelField = new JLabel("Owner: ");
        this.ownerTextField = new JTextField();
        ownerTextField.setPreferredSize(new Dimension(100, 35));
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
