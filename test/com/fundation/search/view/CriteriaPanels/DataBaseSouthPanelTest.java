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

import static org.junit.Assert.*;

/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBaseSouthPanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private DataBaseSouthPanel dataBaseSouthPanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        dataBaseSouthPanel = new DataBaseSouthPanel();
    }

    @Test
    public void testGetLoadButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBaseSouthPanel.getLoadButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetFillButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBaseSouthPanel.getFillButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetDeleteButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBaseSouthPanel.getDeleteButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetLoadButtonOnDataBasePanelIsNotVisible() {
        dataBaseSouthPanel.getLoadButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBaseSouthPanel.getLoadButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetFillButtonOnDataBasePanelIsNotVisible() {
        dataBaseSouthPanel.getFillButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBaseSouthPanel.getFillButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetDeleteButtonOnDataBasePanelNotIsVisible() {
        dataBaseSouthPanel.getDeleteButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBaseSouthPanel.getDeleteButtonOnDataBasePanel().isVisible());
    }
}