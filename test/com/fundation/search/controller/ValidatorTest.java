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
        assertTrue(validator.isValidPath("C:\\Users\\Ariel Gonzales\\Desktop\\Fundacion Jala\\Ingles"));
        assertTrue(validator.isValidPath("D:\\DESCARGAS\\jre1.8.0_162\\bin\\dtplugin"));
        assertTrue(validator.isValidPath("C:\\MSI\\GamingAPP\\Hotkey\\Script"));
        assertTrue(validator.isValidPath("C:\\Users\\Ariel Gonzales\\Downloads\\The witcher\\The_Witcher_wallpapers\\1600 x 1200"));
        assertTrue(validator.isValidPath("C:\\Users\\Ariel Gonzales\\Downloads\\CINEBENCHR15.038\\CINEBENCH R15.038_RC184115\\modules\\mograph\\res\\strings_us\\description"));
    }

    /**
     * This test check the invalid format Path
     * Check the validatorPath.
     */
    @Test
    public void testInvalidPaths() {
        assertFalse(validator.isValidPath("C:\\Users\\Ariel Gonzales\\Downloads\\\\Motospeed V20"));
        assertFalse(validator.isValidPath("C:\\Users\\Ariel Gonzales\\Downloads\\The witcher\\The_Witcher_wallpapers\\1600 x ****"));
        assertFalse(validator.isValidPath("D:\\D:\\DESCARGAS\\\\jre1.8.0_162\\\\bin\\\\dtplugin\""));

    }


    /**
     * It checks a  valid path
     * In this test you need a valid path.
     * that exist on the PC.
     */
    @Test
    public void testIsValidPath() {
        assertTrue(validator.isValidPath("C:\\Program Files (x86)"));
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
    }

    /**
     * Check the valid Format for a validatorType.
     */
    @Test
    public void testValidTypes() {
        assertTrue(validator.isValidFileExtension(".doc"));
        assertTrue(validator.isValidFileExtension(".exe"));
        assertTrue(validator.isValidFileExtension(".pack"));
        assertTrue(validator.isValidFileExtension(".dll"));
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

    }

}
