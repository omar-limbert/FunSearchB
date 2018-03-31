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


package com.fundation.search.controller;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class validate all the fields that are recivied by the GUI.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class Validator {
    private Pattern pattern;
    private Matcher matcher;

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
        pattern = Pattern.compile("(^[A-Z]:(\\\\)*)?((\\\\)\\w+((\\s|\\.)\\w+)*)+");
        matcher = pattern.matcher(path);
        return matcher.matches();
    }

    /**
     * It method checks if the path exist.
     *
     * @param path Direction path.
     * @return boolean.
     */
    public boolean isValidPath(String path) {
        File pathD = new File(path);
        return pathD.isDirectory();
    }

    /**
     * It method checks if the input is a valid File format.
     *
     * @param file string
     * @return boolean
     */
    public boolean validatorFile(String file) {
        pattern = Pattern.compile("(\\w+(\\s|[^:*?\"<>|]\\w+)*)+");
        matcher = pattern.matcher(file);
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid Type format..
     *
     * @param type
     * @return
     */
    public boolean validatorType(String type) {
        pattern = Pattern.compile("^\\.[a-z]{3,4}");
        matcher = pattern.matcher(type);
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid size format.
     *
     * @param size number double.
     * @return boolean
     */
    public boolean validatorSize(String size) {
        pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        matcher = pattern.matcher(size);
        return matcher.matches();

    }

    /**
     * This method check the format in a date.
     *
     * @param date format date.
     * @return
     */
    public boolean validatorDate(String date) {
        pattern = Pattern.compile("\\d{1,2}\\/\\d{2}\\/\\d{2,4}");
        matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
