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
package com.fundation.search.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This method check the convertor class.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */

public class ConvertorTest {
    /**
     * convertor is the object of the class Convertor.
     * for check the tests
     */
    private Convertor convertor;

    /**
     * Init the object convertor.
     */
    @Before
    public void init() {
        convertor = new Convertor();
    }

    /**
     * this method check the conversion from Gb to Bytes.
     */
    @Test
    public void testToConvertGbToBytes() {
        assertEquals(16965120819L, convertor.convertToBytes(15.8, "Gb"));
        assertEquals(1073741824L, convertor.convertToBytes(1, "gb"));
    }

    /**
     * this method check the conversion from Mb to Bytes.
     */
    @Test
    public void testToConvertMbToBytes() {
        assertEquals(1048576, convertor.convertToBytes(1, "Mb"));
        assertEquals(27021804, convertor.convertToBytes(25.77, "mb"));
    }

    /**
     * this method check the conversion from kb to Bytes.
     */
    @Test
    public void testToConvertKbToBytes() {
        assertEquals(1024, convertor.convertToBytes(1, "kb"));
        assertEquals(333312, convertor.convertToBytes(325.5, "KB"));
    }

    /**
     * this method check if returns the same value converted to long.
     */
    @Test
    public void testToVerifyBytes() {
        assertEquals(15650867788L, convertor.convertToBytes(15650867787.6, "bytes"));
        assertEquals(0, convertor.convertToBytes(0, "Bytes"));
        assertEquals(222222223, convertor.convertToBytes(222222222.555, "bytes"));
    }

    /**
     * this method check if converts the String to long with correct values.
     */
    @Test
    public void testToSizeStringToLong() {
        assertEquals(15650867788L, convertor.convertSizeStringToLong("15650867787.6", "bytes"));
    }

    /**
     * this method check if converts the String to long with correct values.
     */
    @Test
    public void testToSizeStringToLongNull() {
        assertEquals(0L, convertor.convertSizeStringToLong(null, "mb"));
    }

    /**
     * this method check if converts the String to long with one incorrect value.
     */
    @Test
    public void testToSizeStringToLongInvalid() {
        assertEquals(0L, convertor.convertSizeStringToLong("hola", "mb"));
    }

    /**
     * this method check if converts the String to long with two incorrect values(invalid/null).
     */
    @Test
    public void testToSizeStringToLongInvalidNull() {
        assertEquals(0L, convertor.convertSizeStringToLong("hola", null));
    }

    /**
     * this method check if converts the String to long with two incorrect values(null/null).
     */
    @Test
    public void testToSizeStringToLongInvalidNullNull() {
        assertEquals(0L, convertor.convertSizeStringToLong(null, null));
    }

    /**
     * this method check if converts the String to double and seconds unit.
     */
    @Test
    public void testConvertTimeDurationToDouble() {
        assertEquals(3600.0, convertor.convertTimeDurationToDouble("1", "hour"), 0.0);
        assertEquals(123456.0, convertor.convertTimeDurationToDouble("123456", "second"), 0.0);
        assertEquals(180.0, convertor.convertTimeDurationToDouble("3", "minute"), 0.0);
        assertEquals(36000.0, convertor.convertTimeDurationToDouble("10", "hour"), 0.0);
    }

    /**
     * this method check the convert from bytes to Kb, Mb and Gb.
     */
    @Test
    public void testConvertSizeUnit() {

        assertEquals("29878250bytes", convertor.convertSizeUnit(29878250, "bytes"));
        assertEquals("251704bytes", convertor.convertSizeUnit(251704, "bytes"));
        assertEquals("53990487bytes", convertor.convertSizeUnit(53990487, "bytes"));
        assertEquals("102,83Kb", convertor.convertSizeUnit(105295, "Kb"));
        assertEquals("291,26Kb", convertor.convertSizeUnit(298250, "Kb"));
        assertEquals("484,39Kb", convertor.convertSizeUnit(496017, "Kb"));
        assertEquals("518,79Mb", convertor.convertSizeUnit(543991704, "Mb"));
        assertEquals("1,69Mb", convertor.convertSizeUnit(1770119, "Mb"));
        assertEquals("11,99Mb", convertor.convertSizeUnit(12567188, "Mb"));
        assertEquals("5,67Gb", convertor.convertSizeUnit(6085481932L, "Gb"));
        assertEquals("16,31Gb", convertor.convertSizeUnit(17513972809L, "Gb"));
        assertEquals("3,15Gb", convertor.convertSizeUnit(3384936952L, "Gb"));
    }

    /**
     * this method check the convert from second to Minutes and Hours.
     */
    @Test
    public void testConvertTimeUnit() {
        assertEquals("12547second", convertor.convertTimeUnit(12547, "second"));
        assertEquals("98743second", convertor.convertTimeUnit(98743, "second"));
        assertEquals("152942second", convertor.convertTimeUnit(152942, "second"));
        assertEquals("9421289second", convertor.convertTimeUnit(9421289, "second"));
        assertEquals("3minute", convertor.convertTimeUnit(180, "minute"));
        assertEquals("60minute", convertor.convertTimeUnit(3600, "minute"));
        assertEquals("330minute", convertor.convertTimeUnit(19800, "minute"));
        assertEquals("12535,8minute", convertor.convertTimeUnit(752148, "minute"));
        assertEquals("5,99hour", convertor.convertTimeUnit(21548, "hour"));
        assertEquals("4088,95hour", convertor.convertTimeUnit(14720212, "hour"));
        assertEquals("1hour", convertor.convertTimeUnit(3600, "hour"));
        assertEquals("23,67hour", convertor.convertTimeUnit(85210, "hour"));
    }
}
