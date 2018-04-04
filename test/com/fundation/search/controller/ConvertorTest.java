/*
 * @(#)ConvertorTest.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */


package com.fundation.search.controller;

import com.fundation.search.common.Convertor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This method check the class convertor.
 */
public class ConvertorTest {

    private Convertor convertor;

    /**
     * Init the object convertor.
     */
    @Before
    public void init() {
        convertor = new Convertor();
    }

    /**
     * this method check the conversion from Gb to Mb.
     */
    @Test
    public void testGbtoMb() {
        assertEquals(1024.0, convertor.convertGbToMb(1.0), 0);
        assertEquals(25927.68, convertor.convertGbToMb(25.32), 0);
    }

    /**
     * this method check the conversion from Mb to Kb.
     */
    @Test
    public void testMbtoKb() {
        assertEquals(1024.0, convertor.convertMbToKb(1.0), 0);
        assertEquals(25927.68, convertor.convertMbToKb(25.32), 0);
    }

    /**
     * this method check the conversion from Kb to B.
     */
    @Test
    public void testGbtoB() {
        assertEquals(27187142983.68, convertor.convertKbToB(convertor.convertMbToKb(convertor.convertGbToMb(25.32))), 0);
        assertEquals(24159191040.0, convertor.convertKbToB(convertor.convertMbToKb(convertor.convertGbToMb(22.5))), 0);
    }
}
