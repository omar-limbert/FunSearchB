package com.fundation.search.controller;


/*
 * @(#)FileClass.java
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


import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is to validate the input format.
 *
 * @author Ariel Gonzales Vargas  - AT-[06].
 * @version 1.0.
 */

public class Validator {
    public Validator() {
    }

    /**
     * It method checks if the input is a valid Path format.
     *
     * @param path Path
     * @return boolean
     */
    public boolean validatorPath(String path) {
        Pattern patternFormat = Pattern.compile("(^[A-Z]:)?((\\\\)\\w+((\\s|\\.)\\w+)*)+");
        Matcher matcher = patternFormat.matcher(path);
        return matcher.matches();

    }

    /**
     * It method checks if the input is a valid File format.
     *
     * @param file string
     * @return boolean
     */
    public boolean validatorFile(String file) {
        Pattern patternFormat = Pattern.compile("(\\w+(\\s|[^:*?\"<>|]\\w+)*)+");
        Matcher matcher = patternFormat.matcher(file);
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid Type format.
     *
     * @param extension
     * @return
     */
    public boolean validatorType(String extension) {
        Pattern patternFormat = Pattern.compile("^\\.[a-z]{3,4}");
        Matcher matcher = patternFormat.matcher(extension);
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid size format.
     *
     * @param size number double.
     * @return boolean
     */
    public boolean isValidSizeFormat(String size) {
        Pattern patternFormat = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        Matcher matcher = patternFormat.matcher(size);
        return matcher.matches();

    }

    public boolean isValidDate(String date) {
        Pattern patternFormat = Pattern.compile("\\d{1,2}\\/\\d{2}\\/\\d{2,4}");
        Matcher matcher = patternFormat.matcher(date);
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

}
