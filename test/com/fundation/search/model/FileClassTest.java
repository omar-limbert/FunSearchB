package com.fundation.search.model;
/*
 * @(#)FileClassTest.java
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

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test the files search by criterias.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class FileClassTest {
    private FileClass file;

    /**
     * initialize File Class.
     */
    @Before
    public void initialize() {
        file = new FileClass("F:\\PRUEBA_CARPETAS");
    }

    /**
     * testToVerifyThePathContent.
     */
    @Test
    public void testToVerifyThePathContent() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("F:\\PRUEBA_CARPETAS\\1"));
        case1.add(new File("F:\\PRUEBA_CARPETAS\\1\\1.1"));
        case1.add(new File("F:\\PRUEBA_CARPETAS\\1\\1.1\\nuevo.txt"));
        case1.add(new File("F:\\PRUEBA_CARPETAS\\documen.txt"));
        case1.add(new File("F:\\PRUEBA_CARPETAS\\documento1.txt"));
        assertEquals(case1, file.searchByPath());
    }

    /**
     * testToSearchFileByName.
     */
    @Test
    public void testToSearchFileByName() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("F:\\PRUEBA_CARPETAS\\documen.txt"));
        case1.add(new File("F:\\PRUEBA_CARPETAS\\documento1.txt"));
        assertEquals(case1, file.searchByName("documen"));
    }

    /**
     * testToSearchFileByName2.
     */
    @Test
    public void testToSearchByName2() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("F:\\PRUEBA_CARPETAS\\documento1.txt"));
        assertEquals(case1, file.searchByName("documento"));
    }
}
