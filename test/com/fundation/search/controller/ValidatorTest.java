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
        assertTrue(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Desktop\\Fundacion Jala\\Ingles"));
        assertTrue(validator.validatorPath("D:\\DESCARGAS\\jre1.8.0_162\\bin\\dtplugin"));
        assertTrue(validator.validatorPath("C:\\MSI\\GamingAPP\\Hotkey\\Script"));
        assertTrue(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\The witcher\\The_Witcher_wallpapers\\1600 x 1200"));
        assertTrue(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\CINEBENCHR15.038\\CINEBENCH R15.038_RC184115\\modules\\mograph\\res\\strings_us\\description"));
    }

    /**
     * This test check the invalid format Path
     * Check the validatorPath.
     */
    @Test
    public void testInvalidPaths() {
        assertFalse(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\\\Motospeed V20"));
        assertFalse(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\The witcher\\The_Witcher_wallpapers\\1600 x ****"));
        assertFalse(validator.validatorPath("D:\\D:\\DESCARGAS\\\\jre1.8.0_162\\\\bin\\\\dtplugin\""));

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

        assertTrue(validator.validatorFile("Informe de la microempresa"));
        assertTrue(validator.validatorFile("_datoteke"));
        assertTrue(validator.validatorFile("_saveslot1_checkpoint2"));
        assertTrue(validator.validatorFile("RG-DIR_MI-002-05"));
        assertTrue(validator.validatorFile("The_Witcher_Toruviel"));
        assertTrue(validator.validatorFile("MotoSpeed Gaming MouseV20"));
    }

    /**
     * Check the invalid format for validatorFile.
     */
    @Test
    public void testInvalidFiles() {

        assertFalse(validator.validatorFile("Informe d* la microempresa"));
        assertFalse(validator.validatorFile("_datote?e"));
        assertFalse(validator.validatorFile("_sa::lot1_checkpoint2"));
        assertFalse(validator.validatorFile("RG-D<>_MI-002-05"));
        assertFalse(validator.validatorFile("The_Witcher|_Toruviel"));
        assertFalse(validator.validatorFile("MotoSpeed \"\"Gaming MouseV20"));
    }

    /**
     * Check the valid Format for a validatorType.
     */
    @Test
    public void testValidTypes() {
        assertTrue(validator.validatorType(".doc"));
        assertTrue(validator.validatorType(".exe"));
        assertTrue(validator.validatorType(".pack"));
        assertTrue(validator.validatorType(".dll"));
    }

    /**
     * Check the invalid Format for a validatorType.
     */
    @Test
    public void testInvalidTypes() {
        assertFalse(validator.validatorType("doc."));
        assertFalse(validator.validatorType("exe"));
        assertFalse(validator.validatorType(".treepack"));
        assertFalse(validator.validatorType("..dll"));
        assertFalse(validator.validatorType(".gg"));
    }

    /**
     * This test check the valid format size.
     * It must to be a float number.
     */
    @Test
    public void testValidatorSize() {
        assertTrue(validator.validatorSize("6565465465654654"));
        assertTrue(validator.validatorSize("3.071970"));
        assertTrue(validator.validatorSize("25.2"));
        assertTrue(validator.validatorSize("158.3"));
        assertTrue(validator.validatorSize("25874"));

    }

    /**
     * This test check the invalid format size.
     * It must to be a float number.
     */
    @Test
    public void testInvalidSize() {
        assertFalse(validator.validatorSize("656holas65465654654"));
        assertFalse(validator.validatorSize("3*071970"));
        assertFalse(validator.validatorSize("25..2"));
        assertFalse(validator.validatorSize("158.3.0"));
        assertFalse(validator.validatorSize("25.87.4"));
        assertFalse(validator.validatorSize("25.87 4"));

    }

}
