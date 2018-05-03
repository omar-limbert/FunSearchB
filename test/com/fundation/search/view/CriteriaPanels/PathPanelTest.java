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
public class PathPanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private PathPanel pathPanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        pathPanel = new PathPanel();
    }

    @Test
    public void getPathCriteriaTrue() {
        assertEquals("/", pathPanel.getPathCriteria());
    }

    @Test
    public void getPathCriteriaFalse() {
        assertNotEquals("/test", pathPanel.getPathCriteria());
    }

    @Test
    public void getReadOnlyOfCriteriaFalse() {
        assertFalse(pathPanel.getReadOnlyOfCriteria());
    }

    @Test
    public void getReadOnlyOfCriteriaTrue() {
        assertTrue(!pathPanel.getReadOnlyOfCriteria());
    }

    @Test
    public void getFileSystemOfCriteriaFalse() {
        assertFalse(pathPanel.getFileSystemOfCriteria());
    }

    @Test
    public void getFileSystemOfCriteriaTrue() {
        assertTrue(!pathPanel.getFileSystemOfCriteria());
    }

    @Test
    public void getDirectoryOfCriteriaFalse() {
        assertFalse(pathPanel.getDirectoryOfCriteria());
    }

    @Test
    public void getDirectoryOfCriteriaTrue() {
        assertTrue(!pathPanel.getDirectoryOfCriteria());
    }

    @Test
    public void getKeySensitiveOfCriteriaFalse() {
        assertFalse(pathPanel.getKeySensitiveOfCriteria());
    }

    @Test
    public void getKeySensitiveOfCriteriaTrue() {
        assertTrue(!pathPanel.getKeySensitiveOfCriteria());
    }

    @Test
    public void setIsReadOnlyCriteriaTrue() {
        pathPanel.setIsReadOnlyCriteria(true);
        assertTrue(pathPanel.getReadOnlyOfCriteria());
    }

    @Test
    public void setIsReadOnlyCriteriaFalse() {
        pathPanel.setIsReadOnlyCriteria(false);
        assertFalse(pathPanel.getReadOnlyOfCriteria());
    }

    @Test
    public void setIsFileSystemCriteriaTrue() {
        pathPanel.setIsFileSystemCriteria(true);
        assertTrue(pathPanel.getFileSystemOfCriteria());
    }

    @Test
    public void setIsFileSystemCriteriaFalse() {
        pathPanel.setIsFileSystemCriteria(false);
        assertFalse(pathPanel.getFileSystemOfCriteria());
    }

    @Test
    public void setIsDirectoryCriteriaTrue() {
        pathPanel.setIsDirectoryCriteria(true);
        assertTrue(pathPanel.getDirectoryOfCriteria());
    }

    @Test
    public void setIsDirectoryCriteriaFalse() {
        pathPanel.setIsDirectoryCriteria(false);
        assertFalse(pathPanel.getDirectoryOfCriteria());
    }

    @Test
    public void setPathCriteriaTrue() {
        pathPanel.setPathCriteria("/test");
        assertEquals("/test", pathPanel.getPathCriteria());
    }

    @Test
    public void setPathCriteriaFalse() {
        pathPanel.setPathCriteria("/test");
        assertNotEquals("/", pathPanel.getPathCriteria());
    }

    @Test
    public void setKeySensitiveOfCriteriaTrue() {
        pathPanel.setKeySensitiveOfCriteria(true);
        assertTrue(pathPanel.getKeySensitiveOfCriteria());
    }

    @Test
    public void setKeySensitiveOfCriteriaFalse() {
        pathPanel.setKeySensitiveOfCriteria(false);
        assertFalse(pathPanel.getKeySensitiveOfCriteria());
    }
}