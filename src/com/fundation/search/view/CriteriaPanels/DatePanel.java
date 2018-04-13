/*
 * @(#)DatePanel.java
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
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.util.Date;

import com.toedter.calendar.JDateChooser;


/**
 * This class is to create the configuration for Date button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class DatePanel extends JPanel {
    //change JTextField to JCalendar
    private JDateChooser dateCreationDateChooser;
    private JDateChooser dateModificationDateChooser;
    private JDateChooser dateLastOpenedDateChooser;
    private JLabel dateCreationLabel;
    private JLabel dateModificationLabel;
    private JLabel dateLastOpenedLabel;
    private JDateChooser dateToCreationDateChooser;
    private JDateChooser dateToModificationDateChooser;
    private JDateChooser dateToLastOpenedDateChooser;
    private JLabel to1;
    private JLabel to2;
    private JLabel to3;


    /**
     * Constructor for DatePanel.
     */
    public DatePanel() {

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
        this.dateCreationLabel =new JLabel("Creation Date");
        this.dateCreationDateChooser=new JDateChooser(new Date());
        this.to1 =new JLabel("to ");
        this.dateToCreationDateChooser=new JDateChooser(new Date());

        this.dateModificationLabel =new JLabel("Modification Date");
        this.dateModificationDateChooser=new JDateChooser(new Date());

        this.to2 =new JLabel("to ");
        this.dateToModificationDateChooser=new JDateChooser(new Date());


        this.dateLastOpenedLabel =new JLabel("Last Opened Date");
        this.dateLastOpenedDateChooser=new JDateChooser(new Date());

        this.to3 =new JLabel("to ");
        this.dateToLastOpenedDateChooser=new JDateChooser(new Date());


    }
    /**
     * This method is to add all components.
     */
    private void addComponents() {

        this.add(dateCreationLabel);
        this.add(dateCreationDateChooser);
        this.add(to1);
        this.add(dateToCreationDateChooser);

        this.add(dateModificationLabel);
        this.add(dateModificationDateChooser);
        this.add(to2);
        this.add(dateToModificationDateChooser);

        this.add(dateLastOpenedLabel);
        this.add(dateLastOpenedDateChooser);
        this.add(to3);
        this.add(dateToLastOpenedDateChooser);

    }
    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date Creation to Date Creation".
     */
    public Date getDateCreationCriteria() {
        return dateCreationDateChooser.getDate();

    }
    public Date getDateToCreationCriteria() {
        return dateCreationDateChooser.getDate();

    }
    public Date getDateModificationCriteria() {
        return dateCreationDateChooser.getDate();

    }
    public Date getDateToModificationCriteria() {
        return dateCreationDateChooser.getDate();

    }
    public Date getDateLastOpenedCriteria() {
        return dateCreationDateChooser.getDate();

    }
    public Date getDateToLastOpenedCriteria() {
        return dateCreationDateChooser.getDate();

    }


}
