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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * This class made the conversion from size to bytes.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @author Escarleth Ledezma Q - AT-[06].
 * @version 1.0.
 */
public class Convertor {
    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

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
     * @param size long size on bytes of a file.
     * @param unit If is Bytes, Kb, Mb, Gb.
     * @return the size of the file with its unit.
     */
    public String convertSizeUnit(long size, String unit) {
        StringBuilder buildResult = new StringBuilder(" ");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (unit.equalsIgnoreCase("Bytes")) {
            return buildResult.append(String.valueOf(decimalFormat.format(size))).append(unit).toString();
        }
        if (unit.equalsIgnoreCase("Kb")) {
            return buildResult.append(String.valueOf(decimalFormat.format(size / 1024.0))).append(unit).toString();
        }
        if (unit.equalsIgnoreCase("Mb")) {
            return buildResult.append(String.valueOf(decimalFormat.format((size / 1024.0) / 1024))).append(unit).toString();
        }
        if (unit.equalsIgnoreCase("Gb")) {
            return buildResult.append(String.valueOf(decimalFormat.format(((size / 1024) / 1024.0) / 1024.0))).append(unit).toString();
        }
        return String.valueOf(size);
    }

    /**
     * @param time     on seconds of a multimedia file.
     * @param unitTime the unit second, minute, hour.
     * @return The duration converted.
     */
    public String convertTimeUnit(double time, String unitTime) {
        StringBuilder buildResult = new StringBuilder(" ");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (unitTime.equalsIgnoreCase("second")) {
            return buildResult.append(String.valueOf(decimalFormat.format(time))).append(unitTime).toString();
        }
        if (unitTime.equalsIgnoreCase("minute")) {
            return buildResult.append(String.valueOf(decimalFormat.format(time / 60.0))).append(unitTime).toString();
        }
        if (unitTime.equalsIgnoreCase("hour")) {
            return buildResult.append(String.valueOf(decimalFormat.format(time / 3600.0))).append(unitTime).toString();
        }
        return String.valueOf(time);
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
     * This method convert String to FileTime.
     *
     * @param date This is a String.
     * @return Date this is String converted to FileTime.
     */
    public FileTime convertStringToFileTime(String date) {
        LOOGER.info("convertStringToDate Entry");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        FileTime result = null;
        try {
            if (!("").equals(date)) {
                result = FileTime.fromMillis(format.parse(date).getTime());
                return result;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOOGER.info("convertStringToDate Exit");
        return result;
    }

    /**
     * This method convert a String to FileTime[].
     *
     * @param dates This is a String.
     * @return FileTime[] this is String converted to FileTime[].
     */
    public FileTime[] convertStringToListFileTime(String dates) {
        LOOGER.info("convertStringToListFileTime Entry");
        FileTime listFiles[] = new FileTime[2];
        try {
            if (!("").equals(dates)) {
                String list[] = dates.split(" ");
                listFiles[0] = convertStringToFileTime(list[0]);
                listFiles[1] = convertStringToFileTime(list[2]);
                return listFiles;
            }
        } catch (NullPointerException e) {
        }
        LOOGER.info("convertStringToListFileTime exit");
        return listFiles;
    }

    /**
     * This method converts bytes/kb/mb/gb to bytes.
     *
     * @param size       length file.
     * @param typeOfSize bytes/kb/mb/gb.
     * @return long converted to bytes.
     */
    public long convertToBytes(double size, String typeOfSize) {
        LOOGER.info("convertToBytes Entry");
        if (typeOfSize.equalsIgnoreCase("Gb")) {
            return Math.round(size * 1024 * 1024 * 1024);
        }
        if (typeOfSize.equalsIgnoreCase("Mb")) {
            return Math.round(size * 1024 * 1024);
        }
        if (typeOfSize.equalsIgnoreCase("Kb")) {
            return Math.round(size * 1024);
        }
        if (typeOfSize.equalsIgnoreCase("Bytes")) {
            return Math.round(size);
        }
        LOOGER.info("convertToBytes Entry");
        return Math.round(0.0);
    }

    /**
     * This method converts String to long
     * to convert to bytes.
     *
     * @param sizeOfSize length file.
     * @param typeOfSize bytes/kb/mb/gb.
     * @return long converted to bytes.
     */
    public long convertSizeStringToLong(String sizeOfSize, String typeOfSize) {
        LOOGER.info("convertSizeStringToLong Entry");
        long size = 0L;
        try {
            if (sizeOfSize != null) {
                size = convertToBytes(Double.parseDouble(sizeOfSize), typeOfSize);
            }
        } catch (NumberFormatException e) {
        }
        LOOGER.info("convertSizeStringToLong exit");
        return size;
    }

    /**
     * This method  split the command size
     * Minor to:/Major to:/Equals to obtain:
     * tam size
     * bytes/kb/mb/gb
     *
     * @param sizeCommand dates.
     * @return String []dates.
     */
    public String[] splitGetSize(String sizeCommand) {
        LOOGER.info("SizeCommand entry");
        String[] valueCommand = new String[3];
        if (!("").equals(sizeCommand)) {
            String[] parts = sizeCommand.split(":");
            valueCommand[0] = parts[0].concat(":");
            valueCommand[1] = parts[1].replaceAll("[^.0-9]+", "");
            valueCommand[2] = parts[1].replaceAll("[^a-zA-Z]+", "");
        }
        LOOGER.info("SizeCommand exit");
        return valueCommand;
    }

    /**
     * This method convert  hours and minutes to seconds.
     *
     * @param duration Input string
     * @param time     Unit Time hour or minute.
     * @return a double number on unit seconds.
     */
    public double convertTimeDurationToDouble(String duration, String time) {
        LOOGER.info("convertTimeDurationToDouble entry");
        if (time.equalsIgnoreCase("second")) {
            return Double.parseDouble(duration);
        }
        if (time.equalsIgnoreCase("minute")) {
            return Double.parseDouble(duration) * 60.0;
        }
        if (time.equalsIgnoreCase("hour")) {
            return Double.parseDouble(duration) * 3600.0;
        }
        LOOGER.info("convertTimeDurationToDouble exit");
        return 0.0;
    }
}


