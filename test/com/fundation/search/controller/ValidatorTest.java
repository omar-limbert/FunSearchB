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

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * The validatorTest, verify all the formats.
 * for Path a real path, filename, extension, size.
 * an others that we add on the project.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @author Jose Christian Galarza - AT-[06].
 * @version 1.0.
 */
public class ValidatorTest {

    /**
     * validator is the object of the class Convertor.
     * for check the tests
     */
    private Validator validator;

    /**
     * This is separator for manage paths.
     */
    private static final String SEPARATOR=System.getProperty("file.separator");

    /**
     * Init the object validator.
     */
    @Before
    public void init() {
        validator=new Validator();
    }

    /**
     * This test check the valid format Path
     * Check the validatorPath..
     */
    @Test
    public void testValidPaths() throws IOException {
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "config"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "resources"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "command"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "CriteriaPanels"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "MainWindow"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "asset"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "database"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "controller"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "controller" + SEPARATOR + "builder"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "resources" + SEPARATOR + "Icons"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "common"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "controller"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test1" + SEPARATOR + "docs"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test2"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test3"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test1"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "command"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com"));

    }

    /**
     * This test check the invalid format Path
     * Check the validatorPath.
     */
    @Test
    public void testInvalidPaths() {
        assertFalse(validator.isValidPath("F:" + SEPARATOR + "confg"));
        assertFalse(validator.isValidPath("Z:" + SEPARATOR + "1" + SEPARATOR + "Ariel"));
        assertFalse(validator.isValidPath("" + SEPARATOR + "Usser"));
        assertFalse(validator.isValidPath("Y:" + SEPARATOR + "test" + SEPARATOR + "Ussers" + SEPARATOR + "Downloads" + SEPARATOR + "Motospeed"));
        assertFalse(validator.isValidPath("W" + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest" + SEPARATOR + "test2"));
        assertFalse(validator.isValidPath("G:" + SEPARATOR + "DESCARGAS"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest" + SEPARATOR + "test1"));
        assertFalse(validator.isValidPath("d" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Users" + SEPARATOR + "Ariel Gonzales" + SEPARATOR + "Downloads" + SEPARATOR + "Motospeed V20"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Users" + SEPARATOR + "Ariel Gonzales" + SEPARATOR + "Downloads" + SEPARATOR + "The witcher" + SEPARATOR + "The_Witcher_wallpapers" + SEPARATOR + "1600"));
        assertFalse(validator.isValidPath("D:" + SEPARATOR + "DESCARGAS" + SEPARATOR + "jre1.8.0_162" + SEPARATOR + "bin" + SEPARATOR + "dtplugin"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "FunSearch" + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest" + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest" + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest" + SEPARATOR + "test1" + SEPARATOR + "docs"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Users" + SEPARATOR + "Ariel Gonzales" + SEPARATOR + "Downloads" + SEPARATOR + "Motospeed V20"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Users" + SEPARATOR + "Downloads" + SEPARATOR + "V20"));
        assertFalse(validator.isValidPath("Y:" + SEPARATOR + "test" + SEPARATOR + "Ussers" + SEPARATOR + "Downloads" + SEPARATOR + "Motospeed"));
        assertFalse(validator.isValidPath("W" + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "FilesTest" + SEPARATOR + "test2"));
        assertFalse(validator.isValidPath("G:" + SEPARATOR + "DESCARGAS"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Program Files (x86)" + SEPARATOR + "WindowsPowerShe"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Downoad"));
        assertFalse(validator.isValidPath("C" + SEPARATOR + "Program Files (x)" + SEPARATOR + "WinRAR"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "ou"));
        assertFalse(validator.isValidPath("D:" + SEPARATOR + "Download"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Program Files (x86)" + SEPARATOR + "Javac"));
        assertFalse(validator.isValidPath("C:" + SEPARATOR + "Program Files (x86)" + SEPARATOR + "Doc"));
        assertFalse(validator.isValidPath("G:" + SEPARATOR + "Users"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Program Files"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Program Files" + SEPARATOR + "Java"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Program Files" + SEPARATOR + "JetBrains"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Windows"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Users"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Users" + SEPARATOR + "Public"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Users" + SEPARATOR + "Public" + SEPARATOR + "Documents"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Program Files (x86)" + SEPARATOR + "Internet Explorer"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Program Files (x86)" + SEPARATOR + "Windows Media Player"));
        assertTrue(validator.isValidPath("C:" + SEPARATOR + "Program Files (x86)" + SEPARATOR + "WindowsPowerShell"));


    }


    /**
     * It checks a  valid path
     * In this test you need a valid path.
     * that exist on the PC.
     */
    @Test
    public void testIsValidPath() throws IOException {

        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "command"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "CriteriaPanels"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test2"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test3"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "MainWindow"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "common"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "controller"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "asset"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "model" + SEPARATOR + "database"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "controller"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "controller" + SEPARATOR + "builder"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "resources" + SEPARATOR + "Icons"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "config"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "resources"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test1" + SEPARATOR + "docs"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "src" + SEPARATOR + "com"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest" + SEPARATOR + "test1"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "FilesTest"));
        assertTrue(validator.isValidPath(new File(".").getCanonicalPath() + SEPARATOR + "test" + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "view" + SEPARATOR + "command"));


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
        assertTrue(validator.isValidFile("java"));
        assertTrue(validator.isValidFile("FunSearch"));
        assertTrue(validator.isValidFile("_package"));
        assertTrue(validator.isValidFile("test"));
        assertTrue(validator.isValidFile("src"));

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
        assertTrue(validator.isValidFileExtension(".dll"));
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
        assertFalse(validator.isValidFileExtension("a.s.f"));
        assertFalse(validator.isValidFileExtension("fil"));
        assertFalse(validator.isValidFileExtension("...taf"));
        assertFalse(validator.isValidFileExtension("tar."));
        assertFalse(validator.isValidFileExtension("gz."));
        assertFalse(validator.isValidFileExtension("te.x.t"));
        assertFalse(validator.isValidFileExtension("dmg"));
        assertFalse(validator.isValidFileExtension("wav"));
        assertFalse(validator.isValidFileExtension("flv."));

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

    /**
     * This test check the valid format Date.
     * It must to be a date.
     */
    @Test
    public void testValidatorDate() {
        assertTrue(validator.isValidDate("21/03/1995"));
        assertTrue(validator.isValidDate("12/2/1994"));
        assertTrue(validator.isValidDate("25/12/95"));
        assertTrue(validator.isValidDate("1/1/2000"));
        assertTrue(validator.isValidDate("16/Mar/99"));
        assertTrue(validator.isValidDate("18/8/10"));


    }

    /**
     * This test check the invalid format Date.
     * It must to be a date.
     */
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

    /**
     * This test check the valid True our False selector..
     * It must to be a boolean.
     */
    @Test
    public void testValidatorIsTrueFalse() {
        assertTrue(validator.isTrueFalse("true"));
        assertTrue(validator.isTrueFalse("false"));
        assertTrue(validator.isTrueFalse("True"));
        assertTrue(validator.isTrueFalse("False"));

    }

    /**
     * This test check the invalid True our False selector.
     * It must to be a boolean.
     */
    @Test
    public void testInvalidatorIsTrueFalse() {
        assertFalse(validator.isTrueFalse("troe"));
        assertFalse(validator.isTrueFalse("fail"));
        assertFalse(validator.isTrueFalse(""));
        assertFalse(validator.isTrueFalse(".45"));
        assertFalse(validator.isTrueFalse("hello"));
        assertFalse(validator.isTrueFalse("\\"));
        assertFalse(validator.isTrueFalse("@"));
        assertFalse(validator.isTrueFalse("*-"));
        assertFalse(validator.isTrueFalse(" "));
        assertFalse(validator.isTrueFalse("♀☺"));

    }

    @Test
    public void testValidateCommandSize(){
        assertTrue(validator.validateCommandSize((Pattern.compile("Major to: 9 mb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Major to: 100 bytes")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Major to: 93 kb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Major to: 2 gb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Minor to: 90 mb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Minor to: 106 kb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Minor to: 9623 bytes")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Minor to: 6 gb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Equal to: 5 mb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Equal to: 573 kb")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Equal to: 95632 bytes")).toString()));
        assertTrue(validator.validateCommandSize((Pattern.compile("Equal to: 1 gb")).toString()));
    }


}
