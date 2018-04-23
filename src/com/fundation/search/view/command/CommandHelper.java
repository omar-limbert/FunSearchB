/*
 * @(#)CommandHelper.java
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
 * this class shows the program Search helpers.
 *
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class CommandHelper {
    /**
     * Logger create a instance of logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Print the helpers.
     */
    public void printHelper() {
        LOOGER.info("Print Helpers entry");
        // System.out.println(String.format("%10s %5s %-15s", "-v", " ", "Print product version"));
        System.out.println(String.format("%50s", "[value] and [options] write between \"\""));
        System.out.println(String.format("%10s", "[criteria][value]"));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-p", " ", "[\"path\"] obligatory in all cases", "List path content"));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-f", " ", "[\"file name\"]", "List files with \"file name\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-o", " ", "[\"owner name\"]", "List files with \"owner name\""));
        System.out.println(String.format("%10s", "[criteria][options]"));

        System.out.println(String.format("%10s %5s %-40s %-20s", "-cf", " ", "[\"start with\"] obligatory -f \"file name\"", "List files with \"Star with\" -f \"file name\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", " ", " ", "[\"end with\"] obligatory -f \"file name\"", "List files with \"End with\" -f \"file name\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", " ", " ", "[\"equal to\"] obligatory -f \"file name\"", "List files with \"Equal to\" -f \"file name\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-h", " ", "[\"only hidden\"]", "List only hidden files"));
        System.out.println(String.format("%10s %5s %-40s %-20s", " ", " ", "[\"without hidden\"]", "List without hidden files"));

        System.out.println(String.format("%10s %5s %-40s %-20s", "-s", " ", "[\"major to: [size file] [bytes/kb/mb/gb]\"]", "List files with major to size file"));
        System.out.println(String.format("%10s %5s %-40s %-20s", " ", " ", "[\"minor to: [size file][bytes/kb/mb/gb]\"]", "List files with minor to size file"));
        System.out.println(String.format("%10s %5s %-40s %-20s", " ", " ", "[\"equals to: [size file][bytes/kb/mb/gb]\"]", "List files with equals to size file"));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-d", " ", "[true/false]", "List directories/no directories"));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-dc", " ", "dd/mm/yyy to dd/mm/yyyy", "List files with \"Creation Date\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-dm", " ", "dd/mm/yyy to dd/mm/yyyy", "List files with \"Modified Date\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-dl", " ", "dd/mm/yyy to dd/mm/yyyy", "List files with \"Last Access Date\""));
        System.out.println(String.format("%10s %5s %-40s %-20s", "-ro", " ", "[true/false]", "List files read only/without read only"));
        LOOGER.info("Print Helpers exit");
    }
}
