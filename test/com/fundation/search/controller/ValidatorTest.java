package com.fundation.search.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    private Validator validator;

    @Before
    public void init() {
        validator = new Validator();
    }

    /**
     * Check the validatorPath.
     */
    @Test
    public void testValidPaths() {
        assertTrue(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Desktop\\Fundacion Jala\\Ingles"));
        assertTrue(validator.validatorPath("D:\\DESCARGAS\\jre1.8.0_162\\bin\\dtplugin"));
        assertTrue(validator.validatorPath("C:\\MSI\\GamingAPP\\Hotkey\\Script"));
        assertTrue(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\The witcher\\The_Witcher_wallpapers\\1600 x 1200"));
        assertTrue(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\CINEBENCHR15.038\\CINEBENCH R15.038_RC184115\\modules\\mograph\\res\\strings_us\\description"));
        //assertTrue(validator.validatorPath("C:\\Users\\Administrator\\Downloads\\Fun_Search_A-develop (1).zip\\Fun_Search_A-develop\\config\\checkstyle"));
        assertFalse(validator.validatorPath(""));
    }

    @Test
    public void testInvalidPaths() {
        assertFalse(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\\\Motospeed V20"));
        assertFalse(validator.validatorPath("C:\\Users\\Ariel Gonzales\\Downloads\\The witcher\\The_Witcher_wallpapers\\1600 x ****"));
        assertFalse(validator.validatorPath("D:\\D:\\DESCARGAS\\\\jre1.8.0_162\\\\bin\\\\dtplugin\""));
        //assertFalse(validator.validatorPath());
    }


    @Test
    public  void testIsValidPath(){
        assertTrue(validator.isValidPath("C:\\Users\\Administrator\\Downloads"));
//        assertTrue(validator.isValidPath("C:\\Users\\Ariel Gonzales\\Desktop\\Fundacion Jala\\Ingles"));
    }



    /**
     * Check the validatorFile.
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
     * Check the validatorType.
     */
    @Test
    public void testValidTypes() {
        assertTrue(validator.validatorType(".doc"));
        assertTrue(validator.validatorType(".exe"));
        assertTrue(validator.validatorType(".pack"));
        assertTrue(validator.validatorType(".dll"));
    }

    @Test
    public void testInvalidTypes() {
        assertFalse(validator.validatorType("doc."));
        assertFalse(validator.validatorType("exe"));
        assertFalse(validator.validatorType(".treepack"));
        assertFalse(validator.validatorType("..dll"));
        assertFalse(validator.validatorType(".gg"));
    }

    @Test
    public void testValidatorSize(){
        assertTrue(validator.validatorSize("6565465465654654"));
        assertTrue(validator.validatorSize("3.071970"));
        assertTrue(validator.validatorSize("25.2"));
        assertTrue(validator.validatorSize("158.3"));
        assertTrue(validator.validatorSize("25874"));

    }

    @Test
    public void testInvalidSize(){
        assertFalse(validator.validatorSize("656holas65465654654"));
        assertFalse(validator.validatorSize("3*071970"));
        assertFalse(validator.validatorSize("25..2"));
        assertFalse(validator.validatorSize("158.3.0"));
        assertFalse(validator.validatorSize("25.87.4"));
        assertFalse(validator.validatorSize("25.87 4"));


    }


}