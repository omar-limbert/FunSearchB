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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a class that validate the command
 * format and return a map with criteria to search files.
 *
 * @author J Christian Galarza Crespo
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class SearchCommand {
    private List<String> criteriaList;
    private Map<String, String> map;

    /**
     * Init the constructor.
     *
     * @param args is a command line list.
     */
    public SearchCommand(String[] args) {
        criteriaList = new ArrayList<>();
        map = new HashMap<>();
        this.addCriterias();
        this.assignCriteria(args);
    }

    /**
     * Add criterias in the Criteria list.
     */

    public void addCriterias() {
        criteriaList.add("-v");//version
        criteriaList.add("-p");//path
        criteriaList.add("-f");//file
        criteriaList.add("-cf");//criteriaFileName
        criteriaList.add("-h");//hidden
        criteriaList.add("-o");//owner
        criteriaList.add("-s");//size
        criteriaList.add("-dc");//dateCreation
        criteriaList.add("-dm");//modifiedDate
        criteriaList.add("-dl");//dateLastAccess
        criteriaList.add("-ro");//readOnly
    }

    /**
     * Validate if the command line has criterias(criteria-value)
     *
     * @param args command line list
     */
    public boolean validateCommandFormat(String[] args) {

        for (int i = 0; i < args.length; i += 2) {
            if (!criteriaList.contains(args[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate if the command line doesn´t have duplicated criterias and fill the map
     * with citeria and values
     *
     * @param args command line list
     */
    public boolean criteriaValidatorDuplicated(String[] args) {
        try {
            for (int i = 0; i < args.length; i += 2) {
                if (map.containsKey(args[i])) {
                    map = new HashMap<>();
                    return false;
                } else {
                    map.put(args[i], args[i + 1]);
                }
            }
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
    public void assignCriteria(String[] args) {
        if (!validateCommandFormat(args) || !criteriaValidatorDuplicated(args)) {
            System.out.println("Invalid command");
        }
    }

    /**
     * return the filled map if the command is valid
     */
    public Map<String, String> getMapToSearch() {
        return map;
    }
}