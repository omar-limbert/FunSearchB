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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class HiddenPanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private HiddenPanel hiddenPanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        hiddenPanel = new HiddenPanel();
    }

    @Test
    public void testGetHiddenCriteriaTrue() {
        assertEquals("all files", hiddenPanel.getHiddenCriteria());
    }

    @Test
    public void testGetHiddenCriteriaFalse() {
        assertNotEquals("all ", hiddenPanel.getHiddenCriteria());
    }

    @Test
    public void setIsHiddenCriteriaTrue() {
        hiddenPanel.setIsHiddenCriteria("without hidden");
        assertEquals("without hidden", hiddenPanel.getHiddenCriteria());
    }

    @Test
    public void setIsHiddenCriteriaFalse() {
        hiddenPanel.setIsHiddenCriteria("without");
        assertNotEquals("without hidden", hiddenPanel.getHiddenCriteria());
    }
}