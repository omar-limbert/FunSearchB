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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
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
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * dateCreationCheck , Type: JCheckBox, this is a JCheckBox for contains check date creation.
     */
    private JCheckBox dateCreationCheck;

    /**
     * dateCreationInitDateChooser , Type: JDateChooser, this is a JDateChooser for contains date creation.
     */
    private JDateChooser dateCreationInitDateChooser;

    /**
     * dateModificationDateCheck , Type: JDateChooser, this is a JDateChooser for contains date creation.
     */
    private JCheckBox dateModificationDateCheck;

    /**
     * dateModificationInitDateChooser , Type: JDateChooser, this is a JDateChooser for contains date modification.
     */
    private JDateChooser dateModificationInitDateChooser;
    /**
     * dateLastOpenedDateCheck , Type: JCheckBox, this is a JCheckBox for contains check date creation.
     */
    private JCheckBox dateLastOpenedDateCheck;

    /**
     * dateLastAccessInitDateChooser , Type: JDateChooser, this is a JDateChooser for contains last modification.
     */
    private JDateChooser dateLastAccessInitDateChooser;

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
     * dateCreationEndDateChooser , Type: JDateChooser, this is a JDateChooser for contains date to creation.
     */
    private JDateChooser dateCreationEndDateChooser;

    /**
     * dateModificationEndDateChooser , Type: JDateChooser, this is a JDateChooser for contains date to modification.
     */
    private JDateChooser dateModificationEndDateChooser;

    /**
     * dateLastAccessEndDateChooser , Type: JDateChooser, this is a JDateChooser for contains last to modification.
     */
    private JDateChooser dateLastAccessEndDateChooser;

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

    private JComboBox<String> dateOfCriteria;


    /**
     * Constructor for DatePanel.
     */
    public DatePanel() {
        LOOGER.info("Get Result Entry");
        this.setLayout(new FlowLayout());
        this.dateOfCriteria = new JComboBox<>();
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
            this.dateOfCriteria.addItem("Creation Date");
            this.dateOfCriteria.addItem("Last Modified Date");
            this.dateOfCriteria.addItem("Last Access Date");

            this.to1 = new JLabel("to :");
            this.to2 = new JLabel("to :");
            this.to3 = new JLabel("to :");

            this.dateOfCriteria.addItemListener(e -> this.dateOfCriteriaListener(e));

            this.dateOfCriteria.getModel().setSelectedItem("Creation Date");

            // Initialize all dates
            this.dateCreationInitDateChooser = new JDateChooser(DATE_FORMAT.parse("01/01/1999"));
            this.dateCreationEndDateChooser = new JDateChooser(new Date());
            this.dateModificationInitDateChooser = new JDateChooser(DATE_FORMAT.parse("01/01/1999"));
            this.dateModificationEndDateChooser = new JDateChooser(new Date());
            this.dateLastAccessInitDateChooser = new JDateChooser(DATE_FORMAT.parse("01/01/1999"));
            this.dateLastAccessEndDateChooser = new JDateChooser(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.to3 = new JLabel("to ");
        this.dateLastAccessEndDateChooser = new JDateChooser(new Date());
        LOOGER.info("init exit");

    }

    private void dateOfCriteriaListener(ItemEvent event) {

        if (event != null) {
            if ("Last Modified Date".equalsIgnoreCase(dateOfCriteria.getModel().getSelectedItem().toString())) {
                this.add(dateModificationInitDateChooser);
                this.add(to1);
                this.add(dateModificationEndDateChooser);
            } else {
                this.remove(dateModificationInitDateChooser);
                this.remove(to1);
                this.remove(dateModificationEndDateChooser);
            }

            if ("Last Access Date".equalsIgnoreCase(dateOfCriteria.getModel().getSelectedItem().toString())) {
                this.add(dateLastAccessInitDateChooser);
                this.add(to2);
                this.add(dateLastAccessEndDateChooser);
            } else {
                this.remove(dateLastAccessInitDateChooser);
                this.remove(to2);
                this.remove(dateLastAccessEndDateChooser);
            }

            if ("Creation Date".equalsIgnoreCase(dateOfCriteria.getModel().getSelectedItem().toString())) {
                this.add(dateCreationInitDateChooser);
                this.add(to3);
                this.add(dateCreationEndDateChooser);
            } else {
                this.remove(dateCreationInitDateChooser);
                this.remove(to3);
                this.remove(dateCreationEndDateChooser);
            }
            this.revalidate();
            this.repaint();


        }
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add");
        this.add(dateOfCriteria);
        this.add(dateModificationInitDateChooser);
        this.add(to1);
        this.add(dateModificationEndDateChooser);
        LOOGER.info("add exit");
    }


    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date Creation".
     */
    public Date getDateCreationCriteria() {
        LOOGER.info("Get date creation Panel");
        return dateCreationInitDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date to Creation".
     */
    public Date getDateToCreationCriteria() {
        LOOGER.info("Get date creation to Panel");
        return dateCreationEndDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date modification".
     */
    public Date getDateModificationCriteria() {
        LOOGER.info("Get modified  Panel");
        return dateModificationInitDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Date to modification".
     */
    public Date getDateToModificationCriteria() {
        LOOGER.info("Get modified to Panel");
        return dateModificationEndDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be "Last Opened".
     */
    public Date getDateLastOpenedCriteria() {
        LOOGER.info("Get last opened Panel");
        return dateLastAccessInitDateChooser.getDate();

    }

    /**
     * This method return Date criteria.
     *
     * @return Date, this is a action command can be " To Last Opened".
     */
    public Date getDateToLastOpenedCriteria() {
        LOOGER.info("Get last opened to Panel");
        return dateLastAccessEndDateChooser.getDate();

    }

    /**
     * This method is to update one criteria.
     *
     * @param modifiedDateInit, this is modified data init.
     */
    public void setModifiedDateInit(String modifiedDateInit) {
        try {
            this.dateModificationInitDateChooser.setDate(DATE_FORMAT.parse(modifiedDateInit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param modifiedDateEnd, this is modified data end.
     */
    public void setModifiedDateEnd(String modifiedDateEnd) {
        try {
            this.dateModificationEndDateChooser.setDate(DATE_FORMAT.parse(modifiedDateEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param lastAccessInit, this is last access data end.
     */
    public void setLastAccessInit(String lastAccessInit) {
        try {
            this.dateLastAccessInitDateChooser.setDate(DATE_FORMAT.parse(lastAccessInit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is to update one criteria.
     *
     * @param lastAccessEnd, this is last access data end.
     */
    public void setLastAccessEnd(String lastAccessEnd) {
        try {
            this.dateLastAccessEndDateChooser.setDate(DATE_FORMAT.parse(lastAccessEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateInit, this is creation date init.
     */
    public void setCreationDateInit(String creationDateInit) {
        try {
            this.dateCreationInitDateChooser.setDate(DATE_FORMAT.parse(creationDateInit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateEnd, this is creation date end.
     */
    public void setCreationDateEnd(String creationDateEnd) {
        try {
            this.dateCreationEndDateChooser.setDate(DATE_FORMAT.parse(creationDateEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}