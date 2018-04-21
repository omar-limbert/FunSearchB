/*
 * @(#)Convertor.java
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

package com.fundation.search.common;

import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * This class made the conversion from size to bytes.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class Convertor {
    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * This class convert.
     * Gb (Gigabytes) to Mb(Megabytes).
     * Mb (Megabytes) to Kb (Kilobytes).
     * Kb (Kilobytes) to B (Bytes).
     */
    public Convertor() {
    }

    /**
     * This method convert Gb to Mb
     *
     * @param tam a decimal number (Gb).
     * @return the a number(a conversion from Gb to Mb) on Mb
     */
    public double convertGbToMb(double tam) {
        LOOGER.info("convertGbToMb Entry");
        LOOGER.info("convertGbToMb Exit");
        return tam * 1024.0;
    }

    /**
     * This method convert Mb to Kb
     *
     * @param tam a decimal number (Mb).
     * @return the a number(a conversion from Mb to Kb) on Kb
     */
    public double convertMbToKb(double tam) {
        LOOGER.info("convertMbToKb Entry");
        LOOGER.info("convertMbToKb Exit");
        return tam * 1024.0;
    }

    /**
     * This method convert Kb to B
     *
     * @param tam a decimal number (Kb).
     * @return the a number (a conversion from Kb to B) on B
     */
    public double convertKbToB(double tam) {
        LOOGER.info("convertKbToB Entry");
        LOOGER.info("convertKbToB Exit");
        return tam * 1024.0;
    }

    /**
     * This method convert a Date to FileTime.
     *
     * @param date This is a Date.
     * @return FileTime This is FileTime converted.
     */
    public FileTime convertDateToFileDate(Date date) {
        LOOGER.info("convertDateToFileDate Entry");
        FileTime result = null;
        if (date != null) {
            result = FileTime.fromMillis(date.getTime());
            return result;
        }
        LOOGER.info("convertDateToFileDate Exit");
        return result;
    }

    /**
     * This method convert FileTime to Date.
     *
     * @param fileTime This is a Date.
     * @return Date this is date converted.
     */
    public String convertFileDateToDate(FileTime fileTime) {
        LOOGER.info("convertFileDateToDate Entry");
        // Format to Date
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        LOOGER.info("convertFileDateToDate Exit");
        return fileTime != null ? df.format(fileTime.toMillis()) : null;//"01/01/1999";
    }
    /**
     * This method convert String to Date.
     *
     * @param date This is a String.
     * @return Date this is date converted.
     */
    public Date convertStringToDate(String date) {
        LOOGER.info("convertStringToDate Entry");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            if (date != null) {
                fechaDate = formato.parse(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("convertStringToDate Exit");
        return fechaDate;
    }
}
