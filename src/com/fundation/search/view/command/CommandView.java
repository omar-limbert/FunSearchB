/*
 * @(#)CommandView.java
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

import java.util.logging.Logger;

/**
 * this class is to show the view in command after results.
 *
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class CommandView {
    /**
     * Logger create a instance of logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Print header results.
     */
    public void printColumn() {
        LOOGER.info("Print Colum entry");
        System.out.print("----------------------------------------------------------------------------------");
        System.out.print("RESULTS----------------------------------------------------------------------------------");
        System.out.println();
        System.out.print(String.format("%s %-70s %2s %-80s %2s %-6s %2s %-15s %2s", " ", "NAME", "|", "PATH", "|", "HIDDEN", "|", "SIZE", "|"));
        System.out.print(String.format("%-30s %2s %-13s %2s %-13s %2s %-16s", "OWNER", "|", "CREATION DATE", "|", "MODIFIED DATE", "|", "LAST ACCESS DATE"));
        System.out.print(String.format("%2s %-9s %2s %-6s", "|", "READ ONLY", "|", "IS DIRECTORY"));
        System.out.println();
        LOOGER.info("Print Colum exit");
    }

    /**
     * Print file with attributes ("Name", "Path", "Hidden", "Size", "Owner", "CreationDate",
     * "ModifiedDate", "LastAccessDate","Read Only","IsDirectory")
     *
     * @param row files with attributes.
     */
    public void printRows(String[] row) {
        LOOGER.info("Constructor Command Criteria entry");
        System.out.print(String.format("%s %-70s %2s %-80s %2s %-6s %2s %-15s %2s", " ", row[0], "|", row[1], "|", row[2], "|", row[3], "|"));
        System.out.print(String.format("%-30s %2s %-13s %2s %-13s %2s %-16s", row[4], "|", row[5], "|", row[6], "|", row[7]));
        System.out.print(String.format("%2s %-9s %2s %-6s", "|", row[8], "|", row[9]));
        System.out.println();
        LOOGER.info("Constructor Command Criteria exit");
    }

}
