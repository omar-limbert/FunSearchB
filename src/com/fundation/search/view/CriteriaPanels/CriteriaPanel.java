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

import javax.swing.*;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class CriteriaPanel extends JPanel {


    /**
     * Constructor for TopPanel.
     * This is text for place holder.
     */
    public CriteriaPanel() {


        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout (boxlayout);
        this.initComponents();
      //  this.addComponents();
        this.repaint();

        //  System.out.println("Ariel =>"+searchTextField.getText());
    }
    /**
     * This method is for initialize all components.
     * This is text for place holder.
     */
    public void initComponents() {

     //   this.add(new FileNamePanel());

    }
    /**
     * This method is for add all components.
     */
    public void addComponent(JPanel component) {

        this.add(component);
        this.repaint();

    }

}
