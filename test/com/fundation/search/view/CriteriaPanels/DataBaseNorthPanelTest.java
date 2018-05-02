/*
 * @(#)DataBaseNorthPanelTest.java
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
import static org.junit.Assert.assertNotEquals;


/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class DataBaseNorthPanelTest {

    /**
     * dataBaseNorthPanel, this is north data base panel.
     */
    private DataBaseNorthPanel dataBaseNorthPanel;

    /**
     * initialize DataBaseNorthPanel().
     */
    @Before
    public void initialize() {
        dataBaseNorthPanel = new DataBaseNorthPanel();
    }

    /**
     * testGetNameOfCriteriaToSaveOnDataBaseTrue.
     */
    @Test
    public void testGetNameOfCriteriaToSaveOnDataBaseTrue() {
        assertEquals("", dataBaseNorthPanel.getNameOfCriteriaToSaveOnDataBase());
    }

    /**
     * testGetNameOfCriteriaToSaveOnDataBaseFalse.
     */
    @Test
    public void testGetNameOfCriteriaToSaveOnDataBaseFalse() {
        assertNotEquals("test", dataBaseNorthPanel.getNameOfCriteriaToSaveOnDataBase());
    }

    /**
     * testGetSaveButtonOnDataBasePanel.
     */
    @Test
    public void testGetSaveButtonOnDataBasePanel() {
        assertTrue(dataBaseNorthPanel.getSaveButtonOnDataBasePanel().isVisible());
    }
}