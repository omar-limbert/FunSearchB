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
 * This class is a class that validate the command
 * format and return a map with criteria to search files.
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
     * map contains the criteria and value .
     */
    private Map<String, String> map;
    /**
     * Logger create a instance of logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Init the constructor.
     *
     * @param args is a command line list.
     */
    public SearchCommand(String[] args) {
        LOOGER.info("Init Constructor SearchCommand");
        criteriaList = new ArrayList<>();
        map = new HashMap<>();
        this.addCriterias();
        this.validateCommand(args);
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
        LOOGER.info("AddCriterias exit");
    }

    /**
     * Validate if the command line has criterias(criteria-value) and create helper.
     *
     * @param args command line list
     */
    public boolean validateCommandFormat(String[] args) {
         LOOGER.info("ValidateCommandFormat entry");
        for (int i = 0; i < args.length; i += 2) {
            if (!criteriaList.contains(args[i])) {
                 LOOGER.info("ValidateCommandFormat with invalid criteria");
                if (args[i].equals("-helper")) {
                    CommandHelper helper = new CommandHelper();
                    helper.printHelper();
                }
                return false;
            }
        }
        LOOGER.info("ValidateCommandFormat exit");
        return true;
    }

    /**
     * Validate if the command line doesn´t have duplicated criterias and fill the map
     * with citeria and values
     *
     * @param args command line list
     */
    public boolean criteriaValidatorDuplicated(String[] args) {
        LOOGER.info("criteriaValidatorDuplicated entry");
        try {
            for (int i = 0; i < args.length; i += 2) {
                if (map.containsKey(args[i])) {
                    LOOGER.info("criteriaValidatorDuplicated criteriaDuplicated");
                    return false;
                } else {
                    map.put(args[i], args[i + 1]);
                }
            }
            LOOGER.info("criteriaValidatorDuplicated exit");
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Impress a message if the command is valid.
     *
     * @param args command line list
     */
    public void validateCommand(String[] args) {
        LOOGER.info("ValidateCommand entry");
        if (!validateCommandFormat(args) || !criteriaValidatorDuplicated(args)) {
            map = new HashMap<>();
            System.out.println("Please,Write -helper for help");
        }
        LOOGER.info("ValidateCommand exit");
    }

    /**
     * return the filled map if the command is valid
     */
    public Map<String, String> getMapToSearch() {
        LOOGER.info("GetMapToSearch entry");
        return map;
    }

}