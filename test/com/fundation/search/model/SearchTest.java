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
package com.fundation.search.model;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    /**
     * file is an Search object.
     */
    private Search file;
    /**
     * filesList is the content of path.
     */
    private static List<File> filesList;
    /**
     * access the content of the  SearchByPath method.
     */
    private Method methodSearchByPath;
    /**
     * access the content of the  SearchByName method.
     */
    private Method methodSearchByName;
    /**
     * access the content of the  SearchBySize method.
     */
    private Method methodSearchBySize;
    /**
     * access the content of the SearchByHidden method.
     */
    private Method methodSearchByHidden;

    /**
     * initialize SearchTest Class and access to private methods.
     */
    @Before
    public void initialize() {
        file = new Search();
        filesList = new ArrayList<>();
        try {
            methodSearchByPath = file.getClass().getDeclaredMethod("searchByPath", new Class[]{String.class});
            methodSearchByName = file.getClass().getDeclaredMethod("searchByName", List.class, String.class);
            methodSearchBySize = file.getClass().getDeclaredMethod("searchBySize", new Class[]{List.class, double.class, char.class});
            methodSearchByHidden = file.getClass().getDeclaredMethod("searchHiddenFiles", new Class[]{List.class, boolean.class});
            methodSearchByPath.setAccessible(true);
            methodSearchByName.setAccessible(true);
            methodSearchBySize.setAccessible(true);
            methodSearchByHidden.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1"));
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.1.txt"));
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.2.txt"));
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2"));
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2\\test2.1.txt"));
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test3"));
        filesList.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test3\\test3.1.txt"));
    }

    /**
     * testToVerifyThePathContent.
     */
    @Test
    public void testToVerifyThePathContent() {
        try {
            List<File> result = (List) methodSearchByPath.invoke(file, new Object[]{"test\\com\\fundation\\search\\model\\filesTest"});
            assertEquals(filesList, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * testToSearchFileByNameGivenAFileList.
     */
    @Test
    public void testToSearchFilesByName() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2\\test2.1.txt"));
        try {
            List<File> result = (List) methodSearchByName.invoke(file, new Object[]{filesList, "test2"});
            assertEquals(case1, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * testToSearchHiddenFilesFalseGivenAFileList.
     */
    @Test
    public void testToSearchHiddenFilesFalse() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.1.txt"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.2.txt"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2\\test2.1.txt"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test3\\test3.1.txt"));
        try {
            List<File> result = (List) methodSearchByHidden.invoke(file, new Object[]{filesList, false});
            assertEquals(case1, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * testToSearchHiddenFilesTrueGivenAFileList.
     */
    @Test
    public void testToSearchHiddenFilesTrue() {
        try {
            List<File> result = (List) methodSearchByHidden.invoke(file, new Object[]{filesList, true});
            assertEquals(filesList, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * testToSearchBySizeEqualGivenAFileList.
     */
    @Test
    public void testToSearchFilesBySizeEqual() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.1.txt"));
        try {
            List<File> result = (List) methodSearchBySize.invoke(file, new Object[]{filesList, 6, '='});
            assertEquals(case1, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * testToSearchBySizeMajorGivenAFileList.
     */
    @Test
    public void testToSearchFilesBySizeMajor() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.1.txt"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.2.txt"));
        try {
            List<File> result = (List) methodSearchBySize.invoke(file, new Object[]{filesList, 5, '>'});
            assertEquals(case1, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * testToSearchBySizeMinorGivenAFileList.
     */
    @Test
    public void testToSearchFilesBySizeMinor() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test1"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test2\\test2.1.txt"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test3"));
        case1.add(new File("test\\com\\fundation\\search\\model\\filesTest\\test3\\test3.1.txt"));
        try {
            List<File> result = (List) methodSearchBySize.invoke(file, new Object[]{filesList, 3, '<'});
            assertEquals(case1, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
