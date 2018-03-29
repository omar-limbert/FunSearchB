package com.fundation.search.model;

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
public class SearchTest {
    private Search file;
    private static List<File> filesList;

    /**
     * initialize File Class.
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
     * testToSearchFileByName2.
     */
    @Test
    public void testToSearchByName() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        assertEquals(case1, file.searchByName(filesList, "test2"));
    }

    /**
     * testToSearchFileByName.
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
     * testToSearchFileByName2.
     */
    @Test
    public void testToSearchBySizeEqual() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));

        assertEquals(case1, file.searchBySize(filesList, 6, '='));
    }

    @Test
    public void testToSearchBySizeMajor() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1\\test1.2.txt"));

        assertEquals(case1, file.searchBySize(filesList, 5, '>'));
    }

    @Test
    public void testToSearchBySizeMinor() {
        final List<File> case1 = new ArrayList<>();
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test1"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test2\\test2.1.txt"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test3"));
        case1.add(new File("src\\com\\fundation\\search\\filesTest\\test3\\test3.1.txt"));

        assertEquals(case1, file.searchBySize(filesList, 3, '<'));
    }

}
