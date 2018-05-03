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
public class SizePanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private SizePanel sizePanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        sizePanel = new SizePanel();
    }

    @Test
    public void getSizeCriteriaTrue() {
        assertEquals(new String[]{"Equal to:"
                , "", "Bytes"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void getSizeCriteriaFalse() {
        assertNotEquals(new String[]{"Equal to:"
                , "1", "Bytes"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void setTypeCriteriaTrue() {
        sizePanel.setTypeCriteria("Mb");
        assertEquals(new String[]{"Equal to:"
                , "", "Mb"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void setTypeCriteriaFalse() {
        sizePanel.setTypeCriteria("Mb");
        assertNotEquals(new String[]{"Equal to:"
                , "", "Gb"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void setOperatorCriteriaTrue() {
        sizePanel.setOperatorCriteria("upper");
        assertEquals(new String[]{"Major to:"
                , "", "Bytes"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void setOperatorCriteriaFalse() {
        sizePanel.setOperatorCriteria("lower");
        assertNotEquals(new String[]{"Major to:"
                , "", "Mb"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void setSizeCriteriaTrue() {
        sizePanel.setSizeCriteria(100);
        assertEquals(new String[]{"Equal to:"
                , "100", "Bytes"}, sizePanel.getSizeCriteria());
    }

    @Test
    public void setSizeCriteriaFalse() {
        sizePanel.setSizeCriteria(100);
        assertNotEquals(new String[]{"Equal to:"
                , "1030", "Bytes"}, sizePanel.getSizeCriteria());
    }
}