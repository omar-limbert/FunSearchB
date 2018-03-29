package com.fundation.search.model;
/*
 * @(#)SearchTest.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and propietary information of
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
 * This class is to test the files searched by criterias.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class SearchTest {
    private Search file;
    private static List<File> filesList;

    /**
     * initialize SearchTest Class.
     */
    @Before
    public void initialize() {
        file = new Search();
        filesList = new ArrayList<>();
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test1"));
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.2.txt"));
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test3"));
        filesList.add(new File("src\\com\\fundation\\search\\filesTest\\test3\\test3.1.txt"));
    }

    /**
     * testToVerifyThePathContent.
     */
    @Test
    public void testToVerifyThePathContent() {

        assertEquals(filesList, file.searchByPath("src\\com\\fundation\\search\\filesTest"));
    }

    /**
     * testToSearchFileByNameGivenAFileList.
     */
    @Test
    public void testToSearchFilesByName() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        assertEquals(case1, file.searchByName(filesList, "test2"));
    }

    /**
     * testToSearchHiddenFilesFalseGivenAFileList.
     */
    @Test
    public void testToSearchHiddenFilesFalse() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.2.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test3\\test3.1.txt"));
        assertEquals(case1, file.searchHiddenFiles(filesList, false));
    }

    /**
     * testToSearchHiddenFilesTrueGivenAFileList.
     */
    @Test
    public void testToSearchHiddenFilesTrue() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.2.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test3"));
        assertEquals(filesList, file.searchHiddenFiles(filesList, true));
    }

    /**
     * testToSearchBySizeEqualGivenAFileList.
     */
    @Test
    public void testToSearchFilesBySizeEqual() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));

        assertEquals(case1, file.searchBySize(filesList, 6, '='));
    }

    /**
     * testToSearchBySizeMajorGivenAFileList.
     */
    @Test
    public void testToSearchFilesBySizeMajor() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.2.txt"));

        assertEquals(case1, file.searchBySize(filesList, 5, '>'));
    }

    /**
     * testToSearchBySizeMinorGivenAFileList.
     */
    @Test
    public void testToSearchFilesBySizeMinor() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test3"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test3\\test3.1.txt"));

        assertEquals(case1, file.searchBySize(filesList, 3, '<'));
    }
}
