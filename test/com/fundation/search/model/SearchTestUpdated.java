/*
 * @(#)SearchTestUpdated.java
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

import com.fundation.search.common.Convertor;
import com.fundation.search.controller.builder.SearchCriteria;
import com.fundation.search.controller.builder.SearchCriteriaBuilder;
import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.FileResult;
import com.fundation.search.model.asset.FolderResult;
import com.fundation.search.model.asset.MultimediaResult;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test the files searched by criterias.
 *
 * @author Ariel Gonzales V. - AT-[06].
 * @version 1.0.
 */
public class SearchTestUpdated {
    /**
     * This is an Object from Search class.
     */
    private Search search;
    /**
     * This is an List of Assets.
     */
    private List<Asset> assetList;

    /**
     * This is an List of AssetMultimedia.
     */
    private List<MultimediaResult> assetMultimediaList;
    /**
     * This is an Object from SearchCriteria class.
     */
    SearchCriteria searchCriteria;
    /**
     * This is separator for manage paths.
     */
    private static final String SEPARATOR = System.getProperty("file.separator");
    /**
     * This is an Object from Convertor class.
     */
    private Convertor convertor;

    /**
     * This method init a list to compare with the results of Seacrh class.
     *
     * @throws IOException to use a generic Path
     */
    @Before
    public void init() throws IOException {
        assetList = new ArrayList<>();
        assetMultimediaList = new ArrayList<>();
        search = new Search();
        convertor = new Convertor();
        FileTime lastAccess = convertor.convertStringToFileTime("01/05/2018");
        FileTime creation = convertor.convertStringToFileTime("01/05/2018");
        FileTime modified = convertor.convertStringToFileTime("30/04/2018");
        assetList.add(new FolderResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "folder", "folder"
                , 0L, false, modified, creation, lastAccess, ""
                , false, false, true, 1));


        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "blacks-factors-influence-estimation-supplement.pdf"
                , "blacks-factors-influence-estimation-supplement.pdf"
                , 11864L, false, modified, creation, lastAccess, ""
                , false, false, true, "pdf", ""));

        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "folder" + SEPARATOR + "test1.txt"
                , "test1.txt"
                , 33L, false, modified, creation, lastAccess, ""
                , false, false, false, "txt", ""));


        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "LAB - BAP Ticketing.docx"
                , "LAB - BAP Ticketing.docx"
                , 37518L, false, modified, creation, lastAccess, ""
                , false, false, false, "docx", ""));


        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "Practice_03.docx"

                , "Practice_03.docx"
                , 104060L, true, modified, creation, lastAccess, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, "docx", ""));


        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "WorkPlans.doc"

                , "WorkPlans.doc"
                , 67072L, false, modified, creation, lastAccess, ""
                , true, false, false, ".jpg", ""));

        assetList.add(new FolderResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs"
                , "docs"
                , 4096L, false, modified, creation, lastAccess, ""
                , false, false, true, 9));

        assetMultimediaList.add(new MultimediaResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "testmultimedia"
                , "Callense"
                , 528894, false, modified, creation, lastAccess, ""
                , false, false, true, "H.264", ".mp4", "H.264/ AVC /MPEG-4 AVC / MPEG-4 part 10", 720, 480
                , "4:3", Fraction.getFraction(29, 3), 0.0, 4.25, 0L, 0L, "", ""
                , "", 2, "", 0.0, 0.0, 132083, 0L
                , 0L));

        assetMultimediaList.add(new MultimediaResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "testmultimedia"
                , "ay esta grasa no se quita"
                , 3169694, false, modified, creation, lastAccess, ""
                , false, false, true, "H.264", ".mp4", "H.264/ AVC /MPEG-4 AVC / MPEG-4 part 10", 720, 480
                , "22:15", Fraction.getFraction(29, 3), 0.0, 18.99, 0L, 0L, "ACC", ""
                , "", 2, "", 0.0, 0.0, 128762, 0L
                , 0L));

    }

    /**
     * This method check the method SearchByPath.
     *
     * @throws IOException
     */
    @Test
    public void testSearchByPath() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .ownerCriteria("").multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getPathFile(), assetList1.get(1).getPathFile());
        assertEquals(assetList.get(3).getPathFile(), assetList1.get(2).getPathFile());
        assertEquals(assetList.get(4).getPathFile(), assetList1.get(3).getPathFile());
        assertEquals(assetList.get(5).getPathFile(), assetList1.get(4).getPathFile());
    }

    /**
     * This method check the method SearchByName.
     * case filenameCriteria "all words".
     *
     * @throws IOException
     */
    @Test
    public void testSearchByNameCase1() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("WorkPlans.doc").fileNameCriteria("all words")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(5).getName(), assetList1.get(0).getName());
    }

    /**
     * This method check the method SearchByName.
     * case filenameCriteria "start with".
     *
     * @throws IOException
     */
    @Test
    public void testSearchByNameCase2() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("b").fileNameCriteria("start with")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getName(), assetList1.get(0).getName());
    }

    /**
     * This method check the method SearchByName.
     * case filenameCriteria "end with".
     *
     * @throws IOException
     */
    @Test
    public void testSearchByNameCase3() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("x").fileNameCriteria("end with")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(3).getName(), assetList1.get(0).getName());
        assertEquals(assetList.get(4).getName(), assetList1.get(1).getName());
    }

    /**
     * This method check the method SearchByName.
     * case filenameCriteria "equal to.
     *
     * @throws IOException
     */
    @Test
    public void testSearchByNameCase4() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("WorkPlans.doc").fileNameCriteria("equal to")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(5).getName(), assetList1.get(0).getName());
    }

    /**
     * This method check the method SearchBySize.
     * case operator = Major to:;size = 37518L; type = bytes.
     *
     * @throws IOException
     */
    @Test
    public void testSearchBySizeCase1() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .sizeCriteria("Major to:", 37518L, "bytes")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(4).getSizeFile(), assetList1.get(0).getSizeFile());
        assertEquals(assetList.get(5).getSizeFile(), assetList1.get(1).getSizeFile());
    }

    /**
     * This method check the method SearchBySize.
     * case operator = Minor to:;size = 67062L; type = bytes.
     *
     * @throws IOException
     */
    @Test
    public void testSearchBySizeCase2() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .sizeCriteria("Minor to:", 67062L, "bytes")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getSizeFile(), assetList1.get(1).getSizeFile());
        assertEquals(assetList.get(3).getSizeFile(), assetList1.get(2).getSizeFile());

    }

    /**
     * This method check the method SearchBySize.
     * case operator = Equal to:;size = 104060L; type = bytes.
     *
     * @throws IOException
     */
    @Test
    public void testSearchBySizeCase3() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .sizeCriteria("Equal to:", 104060L, "bytes")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(4).getSizeFile(), assetList1.get(0).getSizeFile());
    }

    /**
     * This method check the method SearchBySize.
     * case operator = Major to:;size = 4L; type = Kb.
     *
     * @throws IOException
     */
    @Test
    public void testSearchBySizeCase4() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .sizeCriteria("Major to:", 4L, "Kb")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getSizeFile(), assetList1.get(1).getSizeFile());
    }

    /**
     * This method check the method SearchBySize.
     * case operator = Minor to:;size = 101L; type = Mb.
     *
     * @throws IOException
     */
    @Test
    public void testSearchBySizeCase5() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .sizeCriteria("Minor to:", 123456L, "Mb")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getSizeFile(), assetList1.get(1).getSizeFile());
        assertEquals(assetList.get(3).getSizeFile(), assetList1.get(2).getSizeFile());
        assertEquals(assetList.get(5).getSizeFile(), assetList1.get(4).getSizeFile());
    }

    /**
     * This method check the method SearchHiddenFiles.
     * case hiddenCriteria = only hidden.
     *
     * @throws IOException
     */
    @Test
    public void testSearchHiddenFilesCase1() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .hiddenCriteria("without hidden")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getIsHidden(), assetList1.get(1).getIsHidden());
    }

    /**
     * This method check the method SearchHiddenFiles.
     * case hiddenCriteria = without hidden.
     *
     * @throws IOException
     */
    @Test
    public void testSearchHiddenFilesCase2() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .hiddenCriteria("without hidden")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getIsHidden(), assetList1.get(1).getIsHidden());
        assertEquals(assetList.get(2).getIsHidden(), assetList1.get(2).getIsHidden());
        assertEquals(assetList.get(3).getIsHidden(), assetList1.get(3).getIsHidden());
        assertEquals(assetList.get(5).getIsHidden(), assetList1.get(4).getIsHidden());
    }

    /**
     * This method check the method IsReadOnly.
     * case isReadCriteria = true.
     *
     * @throws IOException
     */
    @Test
    public void testIsReadOnlyCase1() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .isReadCriteria(false)
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getIsReadOnlyFile(), assetList1.get(1).getIsReadOnlyFile());
    }

    /**
     * This method check the method IsReadOnly.
     * case isReadCriteria = false.
     *
     * @throws IOException
     */
    @Test
    public void testIsReadOnlyCase2() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .isReadCriteria(false)
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getIsReadOnlyFile(), assetList1.get(1).getIsReadOnlyFile());
        assertEquals(assetList.get(2).getIsReadOnlyFile(), assetList1.get(2).getIsReadOnlyFile());
        assertEquals(assetList.get(3).getIsReadOnlyFile(), assetList1.get(3).getIsReadOnlyFile());
    }

    /**
     * This method check the method IsFileSystem.
     * case isReadCriteria = false.
     *
     * @throws IOException
     */
    @Test
    public void testIsFileSystem() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .isFileSystemCriteria(false)
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(1).getIsFileSystemFile(), assetList1.get(1).getIsFileSystemFile());
        assertEquals(assetList.get(2).getIsFileSystemFile(), assetList1.get(2).getIsFileSystemFile());
        assertEquals(assetList.get(3).getIsFileSystemFile(), assetList1.get(3).getIsFileSystemFile());
        assertEquals(assetList.get(4).getIsFileSystemFile(), assetList1.get(4).getIsFileSystemFile());
    }

    /**
     * This method check the method SearchByDirectory.
     * case isReadCriteria = true.
     *
     * @throws IOException
     */
    @Test
    public void testSearchByDirectoryCase1() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .isDirectoryCriteria(true)
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(5).getIsFileSystemFile(), assetList1.get(0).getIsFileSystemFile());
    }

    /**
     * This method check the method SearchByDirectory.
     * case isReadCriteria = false.
     *
     * @throws IOException
     */
    @Test
    public void testSearchByDirectoryCase2() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .isDirectoryCriteria(false)
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(5).getIsFileSystemFile(), assetList1.get(0).getIsFileSystemFile());
        assertEquals(assetList.get(1).getIsFileSystemFile(), assetList1.get(1).getIsFileSystemFile());
        assertEquals(assetList.get(2).getIsFileSystemFile(), assetList1.get(2).getIsFileSystemFile());
        assertEquals(assetList.get(3).getIsFileSystemFile(), assetList1.get(3).getIsFileSystemFile());
    }

    /**
     * This method check the method SearchByExtension.
     * case isReadCriteria = .docx.
     *
     * @throws IOException
     */
    @Test
    public void testSearchByExtension() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .extensionCriteria(".docx")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(3).getIsFileSystemFile(), assetList1.get(0).getIsFileSystemFile());
        assertEquals(assetList.get(4).getIsFileSystemFile(), assetList1.get(1).getIsFileSystemFile());
    }

    /**
     * This method check the method SearchKeySensitive.
     * case fileName = .Pract; fileNameCriteria= all words; keySensitiveOfCriteria = true.
     *
     * @throws IOException
     */
    @Test
    public void testSearchKeySensitive() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("Pract").fileNameCriteria("all words").keySensitiveOfCriteria(true)
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(4).getName(), assetList1.get(0).getName());
    }


    /**
     * This method check the method SearchIntoFiles DOCX.
     * case  isContainsInsideFileCriteria = true; textContainsInsideFileCriteria = English.
     *
     * @throws IOException
     */
    @Test
    public void testSearchIntoFileDOCX() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .isContainsInsideFileCriteria(true).textContainsInsideFileCriteria("English")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(4).getName(), assetList1.get(0).getName());
    }


    /**
     * This test check the method filterByCriteria.
     *
     * @throws IOException
     */
    @Test
    public void testFilterByCriteriaCase2() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("x").fileNameCriteria("end with")
                .modifiedDateCriteria(convertor.convertStringToFileTime("15/02/2018"), convertor.convertStringToFileTime("18/03/2020"))
                .creationDateCriteria(convertor.convertStringToFileTime("01/03/2018"), convertor.convertStringToFileTime("20/04/2020"))
                .lastAccessDateCriteria(convertor.convertStringToFileTime("01/04/2018"), convertor.convertStringToFileTime("01/05/2020"))
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(3).getName(), assetList1.get(0).getName());
        assertEquals(assetList.get(4).getName(), assetList1.get(1).getName());
    }

    /**
     * This test check the method filterByCriteria.
     *
     * @throws IOException
     */
    @Test
    public void testFilterByCriteriaCase3() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("x").fileNameCriteria("end with")
                .isReadCriteria(false).isDirectoryCriteria(false).isFileSystemCriteria(false)
                .modifiedDateCriteria(convertor.convertStringToFileTime("15/02/2018"), convertor.convertStringToFileTime("18/03/2020"))
                .creationDateCriteria(convertor.convertStringToFileTime("01/03/2018"), convertor.convertStringToFileTime("20/04/2020"))
                .lastAccessDateCriteria(convertor.convertStringToFileTime("01/04/2018"), convertor.convertStringToFileTime("01/05/2020"))
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(3).getName(), assetList1.get(0).getName());
        assertEquals(assetList.get(4).getName(), assetList1.get(1).getName());
    }

    /**
     * This test check the method filterByCriteria.
     *
     * @throws IOException
     */
    @Test
    public void testFilterByCriteriaCase4() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("WorkPlans.doc").fileNameCriteria("all words")
                .isReadCriteria(false).isDirectoryCriteria(false).isFileSystemCriteria(false)
                .modifiedDateCriteria(convertor.convertStringToFileTime("15/02/2018"), convertor.convertStringToFileTime("18/03/2020"))
                .creationDateCriteria(convertor.convertStringToFileTime("01/03/2018"), convertor.convertStringToFileTime("20/04/2020"))
                .lastAccessDateCriteria(convertor.convertStringToFileTime("01/04/2018"), convertor.convertStringToFileTime("01/05/2020"))
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(5).getName(), assetList1.get(0).getName());
    }

    /**
     * This test check the method filterByCriteria.
     *
     * @throws IOException
     */
    @Test
    public void testFilterByCriteriaCase5() throws IOException {
        List<Asset> assetList1;
        SearchCriteriaBuilder searchCriteriaBuilder;
        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("L").fileNameCriteria("start with")
                .isReadCriteria(false).isDirectoryCriteria(false).isFileSystemCriteria(false)
                .modifiedDateCriteria(convertor.convertStringToFileTime("15/02/2018"), convertor.convertStringToFileTime("18/03/2020"))
                .creationDateCriteria(convertor.convertStringToFileTime("01/03/2018"), convertor.convertStringToFileTime("20/04/2020"))
                .lastAccessDateCriteria(convertor.convertStringToFileTime("01/04/2018"), convertor.convertStringToFileTime("01/05/2020"))
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList.get(3).getName(), assetList1.get(0).getName());
    }

    /**
     * This test check the Search Class.
     *
     * @throws IOException
     */
    @Test
    public void testSearhCase1() throws IOException {
        List<Asset> aux = new ArrayList<>();
        List<Asset> assetList1;
        FileTime lastAccess1 = convertor.convertStringToFileTime("01/05/2018");
        FileTime creation1 = convertor.convertStringToFileTime("30/04/2018");
        FileTime modified1 = convertor.convertStringToFileTime("30/04/2018");
        SearchCriteriaBuilder searchCriteriaBuilder;

        aux.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest"
                + SEPARATOR + "test1" + SEPARATOR + "docs" + SEPARATOR + "Practice_03.docx"
                , "Practice_03.docx"
                , 104060L, false, modified1, creation1, lastAccess1, ""
                , false, false, false, "docx", ""));


        searchCriteriaBuilder = new SearchCriteriaBuilder().pathCriteria(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "filesTest" + SEPARATOR + "test1" + SEPARATOR + "docs")
                .fileName("Practice_03.docx").fileNameCriteria("all words")
                .hiddenCriteria("without hidden").isReadCriteria(false).isDirectoryCriteria(false).isFileSystemCriteria(false).keySensitiveOfCriteria(false)
                .extensionCriteria(".docx")
                .ownerCriteria("")
                .multimediaDurationInputCriteria("", 0, "")
                .multimediaAudioBitRateCriteriaInit("").multimediaAudioBitRateCriteriaEnd("");
        searchCriteria = new SearchCriteria(searchCriteriaBuilder);
        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assetList1 = search.getResultList();
        assertEquals(assetList1.get(0).getPathFile(), aux.get(0).getPathFile());
        assertEquals(assetList1.get(0).getName(), aux.get(0).getName());
        assertEquals(assetList1.get(0).getIsHidden(), aux.get(0).getIsHidden());
        assertEquals(assetList1.get(0).getIsFileSystemFile(), aux.get(0).getIsFileSystemFile());
        assertEquals(assetList1.get(0).getIsReadOnlyFile(), aux.get(0).getIsReadOnlyFile());
        assertEquals(assetList1.get(0).getExtensionFile(), aux.get(0).getExtensionFile());
    }
}
