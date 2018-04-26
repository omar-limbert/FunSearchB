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

import javax.xml.crypto.dom.DOMCryptoContext;
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


    public double convertTimeDurationToDouble (String duration, String time){
        double inputTime = 0.0;
        if(!duration.equalsIgnoreCase("")){
            if(time.equalsIgnoreCase("hour")){
                inputTime = Double.parseDouble(duration)*3600.0;
            }
            if(time.equalsIgnoreCase("minute")){
                inputTime = Double.parseDouble(duration)*60.0;
            }
            if(time.equalsIgnoreCase("second")){
                inputTime = Double.parseDouble(duration);
            }
        }
        return inputTime;
    }
}
