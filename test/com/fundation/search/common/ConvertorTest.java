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

import java.text.SimpleDateFormat;

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
        assertEquals(15800000000L, convertor.convertToBytes(15.8, "Gb"));
        assertEquals(1070000000L, convertor.convertToBytes(1.07, "gb"));
        assertEquals(170000000L, convertor.convertToBytes(0.17, "gb"));
        assertEquals(305800000000L, convertor.convertToBytes(305.8, "Gb"));
        assertEquals(1505800000000L, convertor.convertToBytes(1505.8, "Gb"));
    }

    /**
     * this method check the conversion from Mb to Bytes.
     */
    @Test
    public void testToConvertMbToBytes() {
        assertEquals(1040000, convertor.convertToBytes(1.04, "Mb"));
        assertEquals(25770000, convertor.convertToBytes(25.77, "mb"));
        assertEquals(104000, convertor.convertToBytes(0.104, "Mb"));
        assertEquals(257700000, convertor.convertToBytes(257.7, "mb"));
        assertEquals(14000, convertor.convertToBytes(0.014, "Mb"));

    }

    /**
     * this method check the conversion from kb to Bytes.
     */
    @Test
    public void testToConvertKbToBytes() {
        assertEquals(1000, convertor.convertToBytes(1, "kb"));
        assertEquals(33550, convertor.convertToBytes(33.55, "KB"));
        assertEquals(500, convertor.convertToBytes(0.5, "kb"));
        assertEquals(303550, convertor.convertToBytes(303.55, "KB"));
        assertEquals(6303500, convertor.convertToBytes(6303.5, "KB"));
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
        assertEquals(56, convertor.convertSizeStringToLong("56", "bytes"));
        assertEquals(8569, convertor.convertSizeStringToLong("8569", "bytes"));

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
        assertEquals(0L, convertor.convertSizeStringToLong("@-*", "mb"));
        assertEquals(0L, convertor.convertSizeStringToLong(" ", "mb"));
        assertEquals(0L, convertor.convertSizeStringToLong("é", "mb"));


    }

    /**
     * this method check if converts the String to long with two incorrect values(invalid/null).
     */
    @Test
    public void testToSizeStringToLongInvalidNull() {
        assertEquals(0L, convertor.convertSizeStringToLong("hola", null));
        assertEquals(0L, convertor.convertSizeStringToLong("null", null));
        assertEquals(0L, convertor.convertSizeStringToLong("draft", null));
        assertEquals(0L, convertor.convertSizeStringToLong("bob", null));

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
        assertEquals("12547 second", convertor.convertTimeUnit(12547, "second"));
        assertEquals("98743 second", convertor.convertTimeUnit(98743, "second"));
        assertEquals("152942 second", convertor.convertTimeUnit(152942, "second"));
        assertEquals("9421289 second", convertor.convertTimeUnit(9421289, "second"));
        assertEquals("3 minute", convertor.convertTimeUnit(180, "minute"));
        assertEquals("60 minute", convertor.convertTimeUnit(3600, "minute"));
        assertEquals("330 minute", convertor.convertTimeUnit(19800, "minute"));
        assertEquals("12535,8 minute", convertor.convertTimeUnit(752148, "minute"));
        assertEquals("5,99 hour", convertor.convertTimeUnit(21548, "hour"));
        assertEquals("4088,95 hour", convertor.convertTimeUnit(14720212, "hour"));
        assertEquals("1 hour", convertor.convertTimeUnit(3600, "hour"));
        assertEquals("23,67 hour", convertor.convertTimeUnit(85210, "hour"));
    }

    

    @Test
    public void testConvertToBytes() {
        assertEquals(452362, convertor.convertToBytes(452.362,"Kb"));
        assertEquals(482362, convertor.convertToBytes(482.362,"Kb"));
        assertEquals(55236000, convertor.convertToBytes(55.236,"Mb"));
        assertEquals(2362000000L, convertor.convertToBytes(2.362,"Gb"));
    }

    @Test
    public void testConvertSizeStringToLong() {
        assertEquals(452362, convertor.convertSizeStringToLong("452.362","Kb"));
        assertEquals(452362, convertor.convertSizeStringToLong("452.362","Kb"));
        assertEquals(5230000000L, convertor.convertSizeStringToLong("5.23","Gb"));
        assertEquals(2, convertor.convertSizeStringToLong("2","bytes"));
        assertEquals(2362000, convertor.convertSizeStringToLong("2.362","Mb"));
    }


}
