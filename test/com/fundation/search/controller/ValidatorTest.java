/*
 * @(#)ValidatorTest.java
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

import com.fundation.search.common.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The validatorTest, verify all the formats.
 * for Path a real path, filename, extension, size.
 * an others that we add on the project.
 */
public class ValidatorTest {
    
     /**
     * validator is the object of the class Convertor.
     * for check the tests
     */
    private Validator validator;

    /**
     * Init the object validator.
     */
    @Before
    public void init() {
        validator = new Validator();
    }

    /**
     * This test check the valid format Path
     * Check the validatorPath..
     */
    @Test
    public void testValidPaths() {

        assertTrue(validator.isValidPath("C:\\Program Files"));
        assertTrue(validator.isValidPath("C:\\Program Files\\Java"));
        assertTrue(validator.isValidPath("C:\\Program Files\\JetBrains"));
        assertTrue(validator.isValidPath("C:\\Windows"));
        assertTrue(validator.isValidPath("C:\\Users"));
        assertTrue(validator.isValidPath("C:\\Users\\Public"));
        assertTrue(validator.isValidPath("C:\\Users\\Public\\Documents"));
        assertTrue(validator.isValidPath("C:\\Program Files (x86)\\Internet Explorer"));
        assertTrue(validator.isValidPath("C:\\Program Files (x86)\\Windows Media Player"));
        assertTrue(validator.isValidPath("C:\\Program Files (x86)\\WindowsPowerShell"));

    }

    /**
     * This test check the invalid format Path
     * Check the validatorPath.
     */
    @Test
    public void testInvalidPaths() {
        assertFalse(validator.isValidPath("C:\\Program Files (x86)\\WindowsPowerShe"));
        assertFalse(validator.isValidPath("C:\\Downoad"));
        assertFalse(validator.isValidPath("C\\Program Files (x)\\WinRAR"));
        assertFalse(validator.isValidPath("C:\\ou"));
        assertFalse(validator.isValidPath("D:\\Download"));
        assertFalse(validator.isValidPath("C:\\Program Files (x86)\\Javac"));
        assertFalse(validator.isValidPath("C:\\Program Files (x86)\\Doc"));
        assertFalse(validator.isValidPath("G:\\Users"));

    }


    /**
     * It checks a  valid path
     * In this test you need a valid path.
     * that exist on the PC.
     */
    @Test
    public void testIsValidPath() {
        assertTrue(validator.isValidPath("C:\\Program Files (x86)"));
        assertTrue(validator.isValidPath("C:\\Windows"));
        assertTrue(validator.isValidPath("C:\\Users"));
    }


    /**
     * Check the valid format for validatorFile.
     */
    @Test
    public void testValidFiles() {

        assertTrue(validator.isValidFile("Informe de la microempresa"));
        assertTrue(validator.isValidFile("_datoteke"));
        assertTrue(validator.isValidFile("_saveslot1_checkpoint2"));
        assertTrue(validator.isValidFile("RG-DIR_MI-002-05"));
        assertTrue(validator.isValidFile("The_Witcher_Toruviel"));
        assertTrue(validator.isValidFile("MotoSpeed Gaming MouseV20"));
    }

    /**
     * Check the invalid format for validatorFile.
     */
    @Test
    public void testInvalidFiles() {

        assertFalse(validator.isValidFile("Informe d* la microempresa"));
        assertFalse(validator.isValidFile("_datote?e"));
        assertFalse(validator.isValidFile("_sa::lot1_checkpoint2"));
        assertFalse(validator.isValidFile("RG-D<>_MI-002-05"));
        assertFalse(validator.isValidFile("The_Witcher|_Toruviel"));
        assertFalse(validator.isValidFile("MotoSpeed \"\"Gaming MouseV20"));
        assertFalse(validator.isValidFile("https:\\www.google.com.bo/?gws_rd=cr,ssl&ei=zUXFVaCtHYW8wASKzbOgBw"));
        assertFalse(validator.isValidFile("lelouch@Jose:~$"));
        assertFalse(validator.isValidFile("/watch?v:=t:hsaWzy9PdM"));


    }

    /**
     * Check the valid Format for a validatorType.
     */
    @Test
    public void testValidTypes() {
        assertTrue(validator.isValidFileExtension(".doc"));
        assertTrue(validator.isValidFileExtension(".exe"));
        assertTrue(validator.isValidFileExtension(".pack"));
        assertTrue(validator.isValidFileExtension(".txt"));
        assertTrue(validator.isValidFileExtension(".rar"));
        assertTrue(validator.isValidFileExtension(".zip"));
        assertTrue(validator.isValidFileExtension(".jpg"));
        assertTrue(validator.isValidFileExtension(".png"));
        assertTrue(validator.isValidFileExtension(".pdf"));
        assertTrue(validator.isValidFileExtension(".gif"));
    }

    /**
     * Check the invalid Format for a validatorType.
     */
    @Test
    public void testInvalidTypes() {
        assertFalse(validator.isValidFileExtension("doc."));
        assertFalse(validator.isValidFileExtension("exe"));
        assertFalse(validator.isValidFileExtension(".treepack"));
        assertFalse(validator.isValidFileExtension("..dll"));
        assertFalse(validator.isValidFileExtension(".gg"));
        assertFalse(validator.isValidFileExtension("."));
        assertFalse(validator.isValidFileExtension(".png."));
        assertFalse(validator.isValidFileExtension(".jpg.."));
        assertFalse(validator.isValidFileExtension("?gif"));
        assertFalse(validator.isValidFileExtension("!ini"));
        assertFalse(validator.isValidFileExtension("..txt?"));
        assertFalse(validator.isValidFileExtension("?!avi.."));
        assertFalse(validator.isValidFileExtension("doc...?"));
        assertFalse(validator.isValidFileExtension(""));
    }

    /**
     * This test check the valid format size.
     * It must to be a float number.
     */
    @Test
    public void testValidatorSize() {
        assertTrue(validator.isValidSize("6565465465654654"));
        assertTrue(validator.isValidSize("3.071970"));
        assertTrue(validator.isValidSize("25.2"));
        assertTrue(validator.isValidSize("158.3"));
        assertTrue(validator.isValidSize("25874"));

    }

    /**
     * This test check the invalid format size.
     * It must to be a float number.
     */
    @Test
    public void testInvalidSize() {
        assertFalse(validator.isValidSize("656holas65465654654"));
        assertFalse(validator.isValidSize("3*071970"));
        assertFalse(validator.isValidSize("25..2"));
        assertFalse(validator.isValidSize("158.3.0"));
        assertFalse(validator.isValidSize("25.87.4"));
        assertFalse(validator.isValidSize("25.87 4"));
        assertFalse(validator.isValidSize(""));
        assertFalse(validator.isValidSize("hello"));
        assertFalse(validator.isValidSize("@"));
        assertFalse(validator.isValidSize("-*"));
        assertFalse(validator.isValidSize("?45"));
        assertFalse(validator.isValidSize("☻"));
        assertFalse(validator.isValidSize(",."));
        assertFalse(validator.isValidSize("45!6"));
        assertFalse(validator.isValidSize("´<>"));
        assertFalse(validator.isValidSize("\\"));

    }
    @Test
    public void testValidatorDate() {
        assertTrue(validator.isValidDate("21/03/1995"));
        assertTrue(validator.isValidDate("12/2/1994"));
        assertTrue(validator.isValidDate("25/12/95"));
        assertTrue(validator.isValidDate("1/1/2000"));
        assertTrue(validator.isValidDate("16/Mar/99"));
        assertTrue(validator.isValidDate("18/8/10"));


    }


    @Test
    public void testInvalidatorDate() {
        assertFalse(validator.isValidDate(""));
        assertFalse(validator.isValidDate("☻"));
        assertFalse(validator.isValidDate("656holas65465654654"));
        assertFalse(validator.isValidDate(".jpg.."));
        assertFalse(validator.isValidDate("https:\\www.google.com.bo/?gws_rd=cr,ssl&ei=zUXFVaCtHY"));
        assertFalse(validator.isValidDate("656holas65465654654"));
        assertFalse(validator.isValidDate("1/1/2"));
        assertFalse(validator.isValidDate("16/Mar/22562"));
        assertFalse(validator.isValidDate("32/Mar/1962"));
        assertFalse(validator.isValidDate("13/13/13"));
        assertFalse(validator.isValidDate("16/Abr/2012"));
        assertFalse(validator.isValidDate("15/Jan/012"));
        assertFalse(validator.isValidDate("1/ /20"));
        assertFalse(validator.isValidDate(" /1/2018"));
        assertFalse(validator.isValidDate("31/1/ "));
        assertFalse(validator.isValidDate(" / /2018"));
        assertFalse(validator.isValidDate(" /1/ "));
        assertFalse(validator.isValidDate(" / / "));
        assertFalse(validator.isValidDate("31/ / "));
        assertFalse(validator.isValidDate("Twenty/1/2026"));
        assertFalse(validator.isValidDate("21/3/ten"));
        assertFalse(validator.isValidDate("2/10/199"));
        assertFalse(validator.isValidDate("15th/1/1994"));
        assertFalse(validator.isValidDate("1/12/7"));
    }

    @Test
    public void testValidatorIsTrueFalse() {
        assertTrue(validator.isTrueFalse("true"));
        assertTrue(validator.isTrueFalse("false"));
        assertTrue(validator.isTrueFalse("True"));
        assertTrue(validator.isTrueFalse("False"));

    }

    @Test
    public void testInvalidatorIsTrueFalse() {
        assertFalse(validator.isTrueFalse("troe"));
        assertFalse(validator.isTrueFalse("fail"));
        assertFalse(validator.isTrueFalse(""));
        assertFalse(validator.isTrueFalse(".45"));
        assertFalse(validator.isTrueFalse("hello"));
        assertFalse(validator.isTrueFalse("\\"));

    }


}
