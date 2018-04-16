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

/**
 * this class is to show the view in command after results.
 *
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class CommandView {

    /**
     * Print header results.
     */
    public void printColumn() {
        System.out.println("-----------------------------------RESULTS-----------------------------------");

        String[] tableTitles = {"Name", "Path", "Hidden", "Owner", "ReadOnly", "CreationDate", "ModifiedDate", "LastAccessDate"};
        for (String titles : tableTitles) {
            System.out.print(String.format("%s%s", titles, "\t"));
        }
        System.out.println();
    }

    /**
     * Print file with attributes ("Name", "Path", "Hidden", "Owner", "ReadOnly", "CreationDate", "ModifiedDate", "LastAccessDate")
     *
     * @param row files with attributes.
     */
    public void printRows(String[] row) {
        System.out.print(String.format("%s%s%s%s%s%s", row[0], "\t", row[1], "\t", row[2], "\t", row[3], "\t"));
        System.out.print(String.format("%s%s%s%s%s%s", row[4], "\t", row[5], "\t", row[6], "\t", row[7], "\t"));
        System.out.println();
    }
}
