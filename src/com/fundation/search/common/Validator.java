

/*
 * @(#)Validator.java
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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class validate all the fields that are recivied by the GUI.
 * For this method  was implement using Expressions Regulars.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @author Omar Limbert Huanca Sanchez - AT-[06]
 * @version 1.0.
 */
public class Validator {
    private Pattern pattern;
    private Matcher matcher;
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Init the Validator.
     */
    public Validator() {
    }

    /**
     * It method checks if the input is a valid Path format.
     *
     * @param path Path
     * @return boolean
     */
    public boolean validatorPath(String path) {
        LOOGER.info("ValidatorPath : " + path);
        Pattern patternFormat = Pattern.compile("(^[A-Z]:)?((\\\\)\\w+((\\s|\\.)\\w+)*)+");
        Matcher matcher = patternFormat.matcher(path);
        LOOGER.info("Exit Validator");
        return matcher.matches() && Files.exists(Paths.get(path));
    }

    /**
     * It method checks if the input is a valid Path format.
     *
     * @param path a String Path
     * @return true if it is a valid format for a path.
     */
    public boolean isValidPath(String path) {

        LOOGER.info("Validate Path: " + path);
        LOOGER.info("Exit Validator");
        if (!path.isEmpty()) {
            return Files.exists(Paths.get(path));
        }
        return false;
    }

    /**
     * It method checks if the input is a valid File format.
     *
     * @param file format file name.
     * @return true if it is a valid format for a file name.
     * false if it is an invalid format for a file name.
     */
    public boolean isValidFile(String file) {

        LOOGER.info("Validate File: " + file);
        pattern = Pattern.compile("(\\w+(\\s|[^:*?\"<>|]\\w+)*)+");
        matcher = pattern.matcher(file.trim());
        LOOGER.info("Exit Validator");
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid Type (extension of the file) format.
     *
     * @param type a format file extension name.
     * @return true if it is a valid format for a extension.
     * false if it is an invalid format for a extension.
     */
    public boolean isValidFileExtension(String type) {
        LOOGER.info("Validate Type: " + type);
        pattern = Pattern.compile("^\\.[a-z]{3,4}");
        matcher = pattern.matcher(type.trim());
        LOOGER.info("Exit Validator");
        return matcher.matches();
    }


    /**
     * @param owner a format owner name.
     * @return true if it is a valid format for a owner name.
     * false if it is an invalid format for a owner name.
     */
    public boolean isOwnerName(String owner) {
        LOOGER.info("Validate Type: " + owner);
        Pattern pattern = Pattern.compile("\\w+(\\s|[\\\\\\-]\\w+)*(\\\\)?\\w+\\s\\w+");
        matcher = pattern.matcher(owner.trim());
        LOOGER.info("Exit Validator");
        return matcher.matches();
    }

    /**
     * @param size a format of a number
     * @return true if it is a valid format for a size.
     * false if it is an invalid format for a size.
     */
    public boolean isValidformatSize(String size) {
        LOOGER.info("Validate Type: " + size);
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        matcher = pattern.matcher(size.trim());
        LOOGER.info("Exit Validator");
        return matcher.matches();
    }


    /**
     * It method checks if the input is a valid size format.
     *
     * @param size format file size.
     * @return true if it is a valid format for a size format.
     * false if it is an invalid format for a size format.
     */
    public boolean isValidSize(String size) {
        LOOGER.info("Validate Size: " + size);
        try {
            Double.parseDouble(size);
        } catch (NumberFormatException nfe) {
            LOOGER.warning("Invalid Size: " + size);
            return false;
        }
        LOOGER.info("Exit Validator");
        return true;
    }

    /**
     * It method checks if the dateCommand is a valid date command format.
     *
     * @param dateCommand format date command.
     * @return true if it is a valid format for a date command format.
     * false if it is an invalid format for a date command format.
     */
    public boolean isValidDateCommand(String dateCommand) {
        LOOGER.info("Validate Type: " + dateCommand);
        pattern = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}\\s+(to|TO)\\s+\\d{1,2}/\\d{1,2}/\\d{4}");
        matcher = pattern.matcher(dateCommand);
        LOOGER.info("Exit Validator");
        return matcher.matches();
    }

    /**
     * This method check to date input is valid
     *
     * @param date format date.
     * @return
     */
    public boolean isValidDate(String date) {
        LOOGER.info("Validate Date: " + date);
        boolean result = false;

        // Verify if date is null or empty
        if (date == null || date.trim().length() == 0) {
            result = false;
            LOOGER.warning("Date input can't be null.");
        }
        // Date Formats supported
        DateTimeFormatter formatter = null;
        try {
            formatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("[dd/MM/yyyy]")
                    .appendPattern("[dd/MM/yy]")
                    .appendPattern("[dd/M/yyyy]")
                    .appendPattern("[dd/M/yy]")
                    .appendPattern("[d/MM/yyyy]")
                    .appendPattern("[d/MM/yy]")
                    .appendPattern("[d/M/yyyy]")
                    .appendPattern("[d/M/yy]")
                    .appendPattern("[dd/MMM/yy]")
                    .toFormatter();
            LocalDate.parse(date.trim(), formatter);
            result = true;

        } catch (Exception e) {
            LOOGER.warning("Date is invalid. "
                    + "It could be out of bounds. Please correct the format. "
                    + "Accepted formats are dd/MM/yyyy, dd/MM/yy, dd/M/yyyy, dd/M/yy "
                    + "d/MM/yyyy, d/MM/yy, d/M/yyyy, d/M/yy, dd/MMM/yy. ");
        }
        LOOGER.info("Exit Validator");
        return result;
    }

    /**
     * It method checks if the dateCommand is a valid command Size format.
     *
     * @param commandSize format date command.
     * @return true if it is a valid format for a command Size format.
     * false if it is an invalid format for a command Size format.
     */
    public boolean validateCommandSize(String commandSize) {
        LOOGER.info("validateCommandSize: " + commandSize);
        Pattern pattern = Pattern.compile("\\b(Major to:|Minor to:|Equal to:)\\s*[0-9]+\\s*(?:mb|kb|gb|bytes)", Pattern.CASE_INSENSITIVE);
        Matcher matcherCommand = pattern.matcher(commandSize);
        LOOGER.info("Exit validateCommandSize");
        return matcherCommand.find();
    }

    /**
     * this method compares the options allowed in command line
     * for the search by hidden files.
     *
     * @param optionHidden command hidden.
     * @return optionHidden validated
     */
    public boolean isOptionHidden(String optionHidden) {
        LOOGER.info("isOptionHidden: " + optionHidden);
        return optionHidden.equalsIgnoreCase("only hidden") ||
                optionHidden.equalsIgnoreCase("without hidden");
    }

    /**
     * this method compares the options allowed in command line
     * for the search by criteria file name.
     *
     * @param criteriaFileName command criteriaFileName.
     * @return criteriaFileName validated
     */
    public boolean isOptionCriteriaFileName(String criteriaFileName) {
        LOOGER.info("isOptionCriteriaFileName: " + criteriaFileName);
        return criteriaFileName.equalsIgnoreCase("start with") ||
                criteriaFileName.equalsIgnoreCase("end with") ||
                criteriaFileName.equalsIgnoreCase("equal to");
    }

    /**
     * this method compares the options allowed in command line
     * for the search by isReadOnly/isDirectory.
     *
     * @param criteria true/false.
     * @return criteria validated
     */
    public boolean isTrueFalse(String criteria) {
        LOOGER.info("isTrueFalse validator: " + criteria);
        return criteria.equalsIgnoreCase("true") ||
                criteria.equalsIgnoreCase("false");
    }

}
