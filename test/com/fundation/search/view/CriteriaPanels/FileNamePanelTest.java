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
public class FileNamePanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private FileNamePanel fileNamePanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        fileNamePanel = new FileNamePanel();
    }

    @Test
    public void testGetFileNameCriteriaTrue() {
        assertEquals("all words", fileNamePanel.getFileNameCriteria());
    }

    @Test
    public void testGetFileNameCriteriaFalse() {
        assertNotEquals("all", fileNamePanel.getFileNameCriteria());
    }

    @Test
    public void testSetFileNameCriteria() {
        fileNamePanel.setFileNameCriteria("start with");
        assertEquals("start with", fileNamePanel.getFileNameCriteria());
    }

    @Test
    public void testGetIsContainsInsideFileCriteriaIsSelected() {
        fileNamePanel.setIsContainsInsideFileCriteria(true);
        assertTrue(fileNamePanel.getIsContainsInsideFileCriteria());
    }

    @Test
    public void testGetIsContainsInsideFileCriteriaIsNotSelected() {
        fileNamePanel.setIsContainsInsideFileCriteria(false);
        assertFalse(fileNamePanel.getIsContainsInsideFileCriteria());
    }

    @Test
    public void testGetTextContainsInsideFileCriteria() {
        assertEquals("", fileNamePanel.getTextContainsInsideFileCriteria());
    }

    @Test
    public void setIsContainsInsideFileCriteria() {
        fileNamePanel.setIsContainsInsideFileCriteria(true);
        assertTrue(fileNamePanel.getIsContainsInsideFileCriteria());
    }

    @Test
    public void setTextContainsInsideFileCriteria() {
        fileNamePanel.setTextContainsInsideFileCriteria("test");
        assertEquals("test", fileNamePanel.getTextContainsInsideFileCriteria());
    }
}