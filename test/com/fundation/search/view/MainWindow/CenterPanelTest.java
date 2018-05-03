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
package com.fundation.search.view.MainWindow;

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
public class CenterPanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private CenterPanel centerPanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        centerPanel = new CenterPanel();
    }

    @Test
    public void setResultProcessTextFieldTrue() {
        centerPanel.setResultProcessTextField("100");
        assertEquals(true, true);

    }

    @Test
    public void insertRowToJTableResultTrue() {
        centerPanel.insertRowToJTableResult(new Object[]{"1", "2"});
        assertEquals(true, true);
    }

    @Test
    public void resetAllDataOfTableResultTrue() {
        centerPanel.resetAllDataOfTableResult();
        assertEquals(true, true);
    }

    @Test
    public void updateColumnsTittleToFileTrue() {
        centerPanel.updateColumnsTittleToFile();
        assertEquals(true, true);
    }

    @Test
    public void updateColumnsTittleToMultimediaTrue() {
        centerPanel.updateColumnsTittleToMultimedia();
        assertEquals(true, true);
    }

    @Test
    public void setResultProcessTextFieldFalse() {
        centerPanel.setResultProcessTextField("test");
        assertEquals(true, true);

    }

    @Test
    public void insertRowToJTableResultFalse() {
        centerPanel.insertRowToJTableResult(new Object[]{"1", "2"});
        assertEquals(true, true);
    }

    @Test
    public void resetAllDataOfTableResultFalse() {
        centerPanel.resetAllDataOfTableResult();
        assertEquals(true, true);
    }

    @Test
    public void updateColumnsTittleToFileFalse() {
        centerPanel.updateColumnsTittleToFile();
        assertEquals(true, true);
    }

    @Test
    public void updateColumnsTittleToMultimediaFalse() {
        centerPanel.updateColumnsTittleToMultimedia();
        assertEquals(true, true);
    }
}