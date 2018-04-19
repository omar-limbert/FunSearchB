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
        System.out.println("----------------------------------------------------RESULTS----------------------------------------------------");

        String[] tableTitles = {"Name    ", "            Path               ", " Hidden", "SizeKb", "      Owner      ", "CreationDate", "ModifiedDate", "LastAccessDate", "ReadOnly", "IsDirectory"};
        for (String titles : tableTitles) {
            System.out.print(String.format("%s%s", titles, "\t"));
        }
        System.out.println();
        LOOGER.info("Print Colum exit");
    }

    /**
     * Print file with attributes ("Name", "Path", "Hidden", "Owner", "ReadOnly", "CreationDate", "ModifiedDate", "LastAccessDate")
     * @param row files with attributes.
     */
    public void printRows(String[] row) {
        LOOGER.info("Constructor Command Criteria entry");
        System.out.print(String.format("%s%s%s%s%s%s%s%s", row[0], "\t", row[1], "\t", row[2], "\t", row[3], "\t"));
        System.out.print(String.format("%s%s%s%s%s%s%s", row[4], "\t", row[5], "\t", row[6], "\t", row[7]));
        System.out.print(String.format("%s%s%s%s", "\t", row[8], "\t", row[9]));
        System.out.println();
        LOOGER.info("Constructor Command Criteria exit");
    }

}
