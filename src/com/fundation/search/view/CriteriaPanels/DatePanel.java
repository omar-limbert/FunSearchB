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

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.logging.Logger;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    /**
     * SimpleDateFormat, Date format for all dates
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * dateCreationInitDateChooser , Type: JDateChooser, this is a JDateChooser for contains date creation.
     */
    private JDateChooser dateCreationInitDateChooser;

    /**
     * dateModificationInitDateChooser , Type: JDateChooser, this is a JDateChooser for contains date modification.
     */
    private JDateChooser dateModificationInitDateChooser;

    /**
     * dateLastAccessInitDateChooser , Type: JDateChooser, this is a JDateChooser for contains last modification.
     */
    private JDateChooser dateLastAccessInitDateChooser;

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
            this.dateOfCriteria.getModel().setSelectedItem("Creation Date");
            this.dateOfCriteria.addItemListener(e -> this.dateOfCriteriaListener(e));

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
        LOOGER.info("dateOfCriteriaListener init");
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
        LOOGER.info("dateOfCriteriaListener end");
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("Get add");
        this.add(dateOfCriteria);
        this.add(dateCreationInitDateChooser);
        this.add(to1);
        this.add(dateCreationEndDateChooser);
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
        LOOGER.info("setModifiedDateInit init");
        try {
            this.dateModificationInitDateChooser.setDate(DATE_FORMAT.parse(modifiedDateInit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("setModifiedDateInit end");
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param modifiedDateEnd, this is modified data end.
     */
    public void setModifiedDateEnd(String modifiedDateEnd) {
        LOOGER.info("setModifiedDateEnd init");
        try {
            this.dateModificationEndDateChooser.setDate(DATE_FORMAT.parse(modifiedDateEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("setModifiedDateEnd end");
    }

    /**
     * This method is to update one criteria.
     * Controller need use this.
     *
     * @param lastAccessInit, this is last access data end.
     */
    public void setLastAccessInit(String lastAccessInit) {
        LOOGER.info("lastAccessInit init");
        try {
            this.dateLastAccessInitDateChooser.setDate(DATE_FORMAT.parse(lastAccessInit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("lastAccessInit end");
    }

    /**
     * This method is to update one criteria.
     *
     * @param lastAccessEnd, this is last access data end.
     */
    public void setLastAccessEnd(String lastAccessEnd) {
        LOOGER.info("lastAccessEnd init");
        try {
            this.dateLastAccessEndDateChooser.setDate(DATE_FORMAT.parse(lastAccessEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("lastAccessEnd end");
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateInit, this is creation date init.
     */
    public void setCreationDateInit(String creationDateInit) {
        LOOGER.info("lastAccessEnd init");
        try {
            this.dateCreationInitDateChooser.setDate(DATE_FORMAT.parse(creationDateInit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("lastAccessEnd end");
    }

    /**
     * This method is to update one criteria.
     *
     * @param creationDateEnd, this is creation date end.
     */
    public void setCreationDateEnd(String creationDateEnd) {
        LOOGER.info("setCreationDateEnd init");
        try {
            this.dateCreationEndDateChooser.setDate(DATE_FORMAT.parse(creationDateEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("setCreationDateEnd end");
    }
}