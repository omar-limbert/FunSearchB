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
    public void printHeader() {
        LOOGER.info("Print Column entry");
        System.out.print("----------------------------------------------------------------------------------");
        System.out.print("RESULTS----------------------------------------------------------------------------------");
        System.out.println();
        System.out.print(String.format("%s %-40s %s %-80s %s %-5s %s %-12s %s", " ", "NAME", "|", "PATH", "|", "HIDDEN", "|", "SIZE (Bytes)", "|"));
        System.out.print(String.format("%-30s %s %-12s %s %-12s %s %-15s", "OWNER", "|", "CREATION DATE", "|", "MODIFIED DATE", "|", "LAST ACCESS DATE"));
        System.out.print(String.format("%s %-8s %s %-6s", "|", "READ ONLY", "|", "IS DIRECTORY"));
        System.out.println();
        LOOGER.info("Print Column exit");
    }

    /**
     * Print file with attributes ("Name", "Path", "Hidden", "Size", "Owner", "CreationDate",
     * "ModifiedDate", "LastAccessDate","Read Only","IsDirectory")
     *
     * @param row files with attributes.
     */
    public void printRows(String[] row) {
        LOOGER.info("Constructor Command Criteria entry");
        System.out.print(String.format("%s %-40s %s %-80s %s %-5s %s %-12s %s", " ", cutName(row[0]), "|", cutPath(row[1]), "|", row[2], "|", row[3], "|"));
        System.out.print(String.format("%-30s %s %-12s %s %-12s %s %-15s", cutOwner(row[4]), "|", row[5], "|", row[6], "|", row[7]));
        System.out.print(String.format("%s %-8s %s %-6s", "|", row[8], "|", row[9]));
        System.out.println();
        LOOGER.info("Constructor Command Criteria exit");
    }
    public String cutName(String name){
        if(name.length()>=40) {
            return name.substring(0,37).concat("...");
        }
        return name;
    }
    public String cutPath(String path){
        if(path.length()>=80){
            return path.substring(0,77).concat("...");
        }
        return path;
    }
    public String cutOwner(String owner){
        if(owner.length()>=30){
            return owner.substring(0,27).concat("...");
        }
        return owner;
    }

    public void printErrorMessage(String error) {
        System.out.println(error);
    }
}
