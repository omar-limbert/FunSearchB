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
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class OwnerPanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private OwnerPanel ownerPanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        ownerPanel = new OwnerPanel();
    }

    @Test
    public void getOwnerCriteriaTrue() {
        assertEquals("", ownerPanel.getOwnerCriteria());
    }

    @Test
    public void getOwnerCriteriaFalse() {
        assertNotEquals("test", ownerPanel.getOwnerCriteria());
    }

    @Test
    public void setOwnerCriteriaTrue() {
        ownerPanel.setOwnerCriteria("test");
        assertEquals("test", ownerPanel.getOwnerCriteria());
    }

    @Test
    public void setOwnerCriteriaFalse() {
        ownerPanel.setOwnerCriteria("test");
        assertNotEquals("test1", ownerPanel.getOwnerCriteria());
    }
}