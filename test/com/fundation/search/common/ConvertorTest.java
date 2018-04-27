package com.fundation.search.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals(3600.0, convertor.convertTimeDurationToDouble("1", "hour"));
        assertEquals(60.0, convertor.convertTimeDurationToDouble("1", "minute"));
        assertEquals(123456.0, convertor.convertTimeDurationToDouble("123456", "second"));
        assertEquals(180.0, convertor.convertTimeDurationToDouble("3", "minute"));
        assertEquals(36000.0, convertor.convertTimeDurationToDouble("10", "hour"));
    }
}