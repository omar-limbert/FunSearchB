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
import java.awt.*;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class FileNamePanel extends JPanel {

    private JRadioButton allWordsRadioButton ;
    private JRadioButton startWithRadioButton ;
    private JRadioButton endWithRadioButton ;
    private JRadioButton equalsToRadioButton ;

    /**
     * Constructor for TopPanel.
     * This is text for place holder.
     */
    public FileNamePanel() {



        this.setLayout (new FlowLayout());
        this.initComponents();
        this.addComponents();
        this.repaint();

        //  System.out.println("Ariel =>"+searchTextField.getText());
    }
    /**
     * This method is for initialize all components.
     * This is text for place holder.
     */
    public void initComponents() {

        allWordsRadioButton = new JRadioButton("all words");
        startWithRadioButton = new JRadioButton("start with");
        endWithRadioButton = new JRadioButton("end with");
        equalsToRadioButton = new JRadioButton("equal to");


    }
    /**
     * This method is for add all components.
     */
    public void addComponents() {

        this.add(allWordsRadioButton);
        this.add(startWithRadioButton);
        this.add(endWithRadioButton);
        this.add(equalsToRadioButton);

    }

}
