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

import com.fundation.search.common.SearchLogger;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


/**
 * This class is to create the configuration for Date button.
 *
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */

public class DatePanel extends JPanel {
    /**
     * Init logger  in Date Panel
     * */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * dateCreationCheck , Type: JCheckBox, this is a JCheckBox for contains check date creation.
     */
    private  JCheckBox dateCreationCheck;

    /**
     * dateCreationDateChooser , Type: JDateChooser, this is a JDateChooser for contains date creation.
     */
    private JDateChooser dateCreationDateChooser;

    private  JCheckBox dateModificationDateCheck;

    /**
     * dateModificationDateChooser , Type: JDateChooser, this is a JDateChooser for contains date modification.
     */
    private JDateChooser dateModificationDateChooser;

    private  JCheckBox dateLastOpenedDateCheck;

    /**
     * dateLastOpenedDateChooser , Type: JDateChooser, this is a JDateChooser for contains last modification.
     */
    private JDateChooser dateLastOpenedDateChooser;

    /**
     * dateCreationLabel , Type: JLabel, this is a JLabel for contains creation label.
     */
    private JLabel dateCreationLabel;

    /**
     * dateModificationLabel , Type: JLabel, this is a JLabel for contains modification label.
     */
    private JLabel dateModificationLabel;

    /**
     * dateLastOpenedLabel , Type: JLabel, this is a JLabel for contains last modification label.
     */
    private JLabel dateLastOpenedLabel;

    /**
     * dateToCreationDateChooser , Type: JDateChooser, this is a JDateChooser for contains date to creation.
     */
    private JDateChooser dateToCreationDateChooser;

    /**
     * dateToModificationDateChooser , Type: JDateChooser, this is a JDateChooser for contains date to modification.
     */
    private JDateChooser dateToModificationDateChooser;

    /**
     * dateToLastOpenedDateChooser , Type: JDateChooser, this is a JDateChooser for contains last to modification.
     */
    private JDateChooser dateToLastOpenedDateChooser;

    /**
     * to1 , Type: JLabel, this is a JLabel for contains to1 label.
     */
    private JLabel to1;

    /**
     * to2 , Type: JLabel, this is a JLabel for contains to2 label.
     */
    private JLabel to2;

    /**
     * to3 , Type: JLabel, this is a JLabel for contains to3 label.
     */
    private JLabel to3;


    /**
     * Constructor for DatePanel.
     */
    public DatePanel() {
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
        try {
            this.dateCreationLabel =new JLabel("Creation Date");
            this.dateCreationDateChooser=new JDateChooser(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999"));
            this.to1 =new JLabel("to ");
            this.dateToCreationDateChooser=new JDateChooser(new Date());

            this.dateModificationLabel =new JLabel("Modification Date");
            this.dateModificationDateChooser=new JDateChooser(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999"));

            this.to2 =new JLabel("to ");
            this.dateToModificationDateChooser=new JDateChooser(new Date());


            this.dateLastOpenedLabel =new JLabel("Last Opened Date");

            this.dateLastOpenedDateChooser=new JDateChooser(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.to3 =new JLabel("to ");
        this.dateToLastOpenedDateChooser=new JDateChooser(new Date());
        LOOGER.info("init exit");

    }
    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add");
        //add date Creation and date to creation
        this.add(dateCreationLabel);
        this.add(dateCreationDateChooser);
        this.add(to1);
        this.add(dateToCreationDateChooser);
        //add date modification and date to modification
        this.add(dateModificationLabel);
        this.add(dateModificationDateChooser);
        this.add(to2);
        this.add(dateToModificationDateChooser);
        //add last modification and last to modification
        this.add(dateLastOpenedLabel);
        this.add(dateLastOpenedDateChooser);
        this.add(to3);
        this.add(dateToLastOpenedDateChooser);
        LOOGER.info("add exit");
    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date Creation".
     */
    public Date getDateCreationCriteria() {
        return dateCreationDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date to Creation".
     */
    public Date getDateToCreationCriteria() {
        return dateToCreationDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date modification".
     */
    public Date getDateModificationCriteria() {
        return dateModificationDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date to modification".
     */
    public Date getDateToModificationCriteria() {
        return dateToModificationDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Last Opened".
     */
    public Date getDateLastOpenedCriteria() {
        return dateLastOpenedDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be " To Last Opened".
     */
    public Date getDateToLastOpenedCriteria() {
        return dateToLastOpenedDateChooser.getDate();

    }

}