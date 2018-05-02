/*
 * @(#)ControlCommandTest.java
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
package com.fundation.search.controller;

import com.fundation.search.common.Convertor;
import com.fundation.search.common.Validator;
import com.fundation.search.controller.builder.SearchCriteria;
import com.fundation.search.controller.builder.SearchCriteriaBuilder;
import com.fundation.search.model.Search;
import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.FileResult;

import com.fundation.search.view.command.CommandCriteria;
import com.fundation.search.view.command.CommandView;
import com.fundation.search.view.command.SearchCommand;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControlCommandTest {

    private ControlCommand controlCommand;
    /**
     * searchCommand from Command Line.
     */
    private SearchCommand searchCommand;
    /**
     * commandCriteria from Command Line.
     */
    private CommandCriteria commandCriteria;
    /**
     * validator is the validator for valid inputs.
     */
    private Validator validator;
    /**
     * converter is the converter for valid inputs.
     */
    private Convertor converter;
    /**
     * SearchCriteria is Search Criteria with Builder Pattern.
     */
    private SearchCriteria searchCriteria;
    /**
     * Command View allows to show error messages in command line.
     */
    private CommandView commandView;
    /**
     * This is separator for manage paths.
     */

    private static final String SEPARATOR = System.getProperty("file.separator");
    /**
     * This is an List of Assets.
     */
    private List<Asset> assetList;
    /**
     * This is Search object.
     */
    Search search;

    /**
     * Init objects.
     */
    @Before
    public void initialize() throws IOException {
        assetList = new ArrayList<>();
        converter = new Convertor();
        commandView = new CommandView();
        validator = new Validator();
        search = new Search();
        FileTime date = converter.convertStringToFileTime("02/05/2018");

        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "testCommand"
                , "documen.txt"
                , 19, false, date, date, date, ""
                , false, false, false, "txt", ""));
        assetList.add(new FileResult(new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "testCommand"
                , "documento1.txt"
                , 0, false, date, date, date, ""
                , false, false, false, "txt", ""));

    }

    /**
     * testToValidateCommandFormatTrue.
     */
    @Test
    public void testToValidateCommandFormatTrue() throws IOException {
        String path = new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search" + SEPARATOR + "testFolder" + SEPARATOR + "testCommand";
        String[] COMMAND_LIST = {"-p", path, "-f", "do", "-cf", "start with", "-d", "false"};
        controlCommand = new ControlCommand(COMMAND_LIST);
        searchCommand = new SearchCommand(COMMAND_LIST);
        commandCriteria = new CommandCriteria(searchCommand.getMapToSearch());
        String[] getSize = converter.splitGetSize(commandCriteria.getSize());
        ArrayList<String> empty = new ArrayList<>();
        // Adding to SearchCriteria
        this.searchCriteria = new SearchCriteriaBuilder()
                .pathCriteria(commandCriteria.getPath())
                .fileName(commandCriteria.getFileName())
                .hiddenCriteria(commandCriteria.getIsHidden())
                .fileNameCriteria(commandCriteria.getCriteriaName())
                .ownerCriteria(commandCriteria.getOwner())
                .isReadCriteria(Boolean.parseBoolean(commandCriteria.getReadOnly()))
                .creationDateCriteria(null, null)
                .modifiedDateCriteria(null, null)
                .lastAccessDateCriteria(null, null)
                .sizeCriteria(getSize[0], converter.convertSizeStringToLong(getSize[1], getSize[2]), getSize[2])
                .isDirectoryCriteria(Boolean.parseBoolean(commandCriteria.getIsDirectory()))
                .extensionCriteria(commandCriteria.getExtension())
                .nameOnDataBase("")
                .keySensitiveOfCriteria(false)
                .isContainsInsideFileCriteria(false)
                .textContainsInsideFileCriteria("")
                .multimediaDurationInputCriteria("", -1, "")
                .multimediaVideoCodecCriteria(empty)
                .searchMultimediaFrameCriteria(empty)
                .multimediaResolutionCriteria(empty)
                .multimediaAudioBitRateCriteriaInit("")
                .multimediaAudioBitRateCriteriaEnd("")
                .multimediaTypeCriteria(empty)
                .searchMultimediaCriteria(false)
                .build();

        search.setSearchCriteria(searchCriteria);
        search.initSearch();
        assertTrue(controlCommand.validateAllInputs());

    }

}
