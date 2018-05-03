/*
 * @(#)DataBasePanelTest.java
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

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DatePanelTest {

    /**
     * SimpleDateFormat, Date format for all dates
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private DatePanel datePanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        datePanel = new DatePanel();
    }

    @Test
    public void testGetDateCreationCriteria() {
        try {
            assertEquals(DATE_FORMAT.parse("01/01/1999"), datePanel.getDateCreationCriteria());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDateToCreationCriteria() {
        assertEquals(datePanel.getDateToCreationCriteria(), datePanel.getDateToCreationCriteria());
    }

    @Test
    public void testGetDateModificationCriteria() {
        try {
            assertEquals(DATE_FORMAT.parse("01/01/1999"), datePanel.getDateModificationCriteria());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDateToModificationCriteria() {
        assertEquals(datePanel.getDateToModificationCriteria(), datePanel.getDateToModificationCriteria());
    }

    @Test
    public void testGetDateLastOpenedCriteria() {
        try {
            assertEquals(DATE_FORMAT.parse("01/01/1999"), datePanel.getDateLastOpenedCriteria());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDateToLastOpenedCriteria() {
        assertEquals(datePanel.getDateToLastOpenedCriteria(), datePanel.getDateToLastOpenedCriteria());
    }

}