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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBasePanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private DataBasePanel dataBasePanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        dataBasePanel = new DataBasePanel();
    }

    @Test
    public void testGetNameOfCriteriaToSaveOnDataBaseTrue() {
        assertEquals("", dataBasePanel.getNameOfCriteriaToSaveOnDataBase());
    }

    @Test
    public void testGetNameOfCriteriaToSaveOnDataBaseFalse() {
        assertNotEquals("test", dataBasePanel.getNameOfCriteriaToSaveOnDataBase());
    }

    @Test
    public void testGetSaveButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBasePanel.getSaveButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetSaveButtonOnDataBasePanelIsNotVisible() {
        dataBasePanel.getSaveButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBasePanel.getSaveButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetLoadButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBasePanel.getLoadButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetLoadButtonOnDataBasePanelIsNotVisible() {
        dataBasePanel.getLoadButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBasePanel.getLoadButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetFillButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBasePanel.getFillButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetFillButtonOnDataBasePanelIsNotVisible() {
        dataBasePanel.getFillButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBasePanel.getFillButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetSelectionModelTrue() {
        assertTrue(dataBasePanel.getSelectionModel().isSelectionEmpty());
    }

    @Test
    public void testGetSelectionModelNotNull() {
        assertTrue(dataBasePanel.getSelectionModel() != null);
    }

    @Test
    public void testGetDataBaseTableResultNotNull() {
        assertTrue(dataBasePanel.getDataBaseTableResult() != null);
    }

    @Test
    public void testGetDeleteButtonOnDataBasePanelIsVisible() {
        assertTrue(dataBasePanel.getDeleteButtonOnDataBasePanel().isVisible());
    }

    @Test
    public void testGetDeleteButtonOnDataBasePanelIsNotVisible() {
        dataBasePanel.getDeleteButtonOnDataBasePanel().setVisible(false);
        assertFalse(dataBasePanel.getDeleteButtonOnDataBasePanel().isVisible());
    }
}