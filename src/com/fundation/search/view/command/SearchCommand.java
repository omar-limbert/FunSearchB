/*
 * @(#)SearCommand.java
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
package com.fundation.search.view.command;

import com.fundation.search.common.SearchLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class validate the command line format
 * and return a criterias with criterias to search files.
 *
 * @author J Christian Galarza Crespo
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class SearchCommand {
    /**
     * criteriaList contains a criterias list.
     */
    private List<String> criteriaList;
    /**
     * criterias contains the criterias and value .
     */
    private Map<String, String> criterias;
    /**
     * Logger create a instance of logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * Receives String [] of command line.
     */
    private String[] commandLine;
    /**
     * Prints helper.
     */
    private CommandHelper helper;

    /**
     * Init the constructor.
     *
     * @param args is a command line list.
     */
    public SearchCommand(String[] args) {
        LOOGER.info("Init Constructor SearchCommand");
        commandLine = args;
        criteriaList = new ArrayList<>();
        helper = new CommandHelper();
        this.addCriterias();
        this.validateCommand();
        LOOGER.info("Exit Constructor SearchCommand");
    }

    /**
     * Add criterias in the Criteria list.
     */
    public void addCriterias() {
        LOOGER.info("AddCriterias entry");
        criteriaList.add("-v");//version
        criteriaList.add("-p");//path
        criteriaList.add("-f");//file
        criteriaList.add("-cf");//criteriaFileName
        criteriaList.add("-h");//hidden
        criteriaList.add("-o");//owner
        criteriaList.add("-s");//size
        criteriaList.add("-d");//directory
        criteriaList.add("-dc");//dateCreation
        criteriaList.add("-dm");//modifiedDate
        criteriaList.add("-dl");//dateLastAccess
        criteriaList.add("-ro");//readOnly
        criteriaList.add("-ex");//extension
        LOOGER.info("AddCriterias exit");
    }

    /**
     * Validate if the command line has valid criterias in the correct position
     * and if contains -helper, create CommandHelper object.
     */
    public boolean validateCommandCriteria() {
        LOOGER.info("ValidateCommandFormat entry");
        for (int i = 0; i < commandLine.length; i += 2) {
            if (!criteriaList.contains(commandLine[i])) {
                if (commandLine[i].equals("-help")) {
                    helper.printHelper();
                }
                return false;
            }
        }
        LOOGER.info("ValidateCommandFormat exit");
        return true;
    }

    /**
     * Validate if the command line doesn´t have duplicated criterias and fill the criterias
     * with citeria and values
     */
    public boolean addCriteriaWithoutDuplicated() {
        criterias = new HashMap<>();
        LOOGER.info("addCriteriaWithoutDuplicated entry");
        try {
            for (int i = 0; i < commandLine.length; i += 2) {
                if (criterias.containsKey(commandLine[i]) || commandLine[i + 1].equals(null)) {
                    return false;
                } else {
                    criterias.put(commandLine[i], commandLine[i + 1]);
                }
            }
            LOOGER.info("addCriteriaWithoutDuplicated exit");
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Impress "Please,Write -help for help" message if the command is invalid.
     */
    public void validateCommand() {
        LOOGER.info("ValidateCommand entry");
        if (!validateCommandCriteria() || !addCriteriaWithoutDuplicated()) {
            criterias = new HashMap<>();
            helper.printHelperMessage();
        }
        LOOGER.info("ValidateCommand exit");
    }

    /**
     * return criterias map.
     */
    public Map<String, String> getMapToSearch() {
        LOOGER.info("GetMapToSearch entry");
        return criterias;
    }

}