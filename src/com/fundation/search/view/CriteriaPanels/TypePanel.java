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

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for type button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class TypePanel extends JPanel{
    /**
     * Init logger  in Type Panel
     * */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * typeTextField, Type: JTextField, this is a JTextField for contains final type result.
     */
    private  JTextField typeTextField;

    /**
     * TypeLabelField, Type: JLabel, this is a JLabel for contains type label.
     */
    private JLabel TypeLabelField;

    /**
     * Constructor for TypePanel.
     * */
    public  TypePanel(){
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
        this.TypeLabelField = new JLabel("Type: ");
        this.typeTextField = new JTextField();
        typeTextField.setPreferredSize(new Dimension(40, 25));
        LOOGER.info("init exit");
    }
    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("Get addd");
        this.add(TypeLabelField);
        this.add(typeTextField);
        LOOGER.info("add exit");
    }
    /**
     * This method is for return type.
     *
     * @return String, this contains a type file.
     */
    public String getTypeCriteria(){
        return typeTextField.getText();
    }

}
