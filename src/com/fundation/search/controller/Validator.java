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
 * This class validate all the fields that are recivied by the GUI.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class Validator {

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
        Pattern pat = Pattern.compile("(^[A-Z]:(\\\\)*)?((\\\\)\\w+((\\s|\\.)\\w+)*)+");
        Matcher mat = pat.matcher(path);
        return mat.matches();

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
        Pattern pat = Pattern.compile("(\\w+(\\s|[^:*?\"<>|]\\w+)*)+");
        Matcher mat = pat.matcher(file);
        return mat.matches();
    }

    /**
     * It method checks if the input is a valid Type format.
     *
     * @param type
     * @return
     */
    public boolean validatorType(String type) {
        Pattern pat = Pattern.compile("^\\.[a-z]{3,4}");
        Matcher mat = pat.matcher(type);
        return mat.matches();
    }

    /**
     * It method checks if the input is a valid size format.
     *
     * @param size number double.
     * @return boolean
     */
    public boolean validatorSize(String size) {
        Pattern pat = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        Matcher mat = pat.matcher(size);
        return mat.matches();

    }

    /**
     * This method check the format in a date.
     *
     * @param date format date.
     * @return
     */
    public boolean validatorDate(String date) {
        Pattern pat = Pattern.compile("\\d{1,2}\\/\\d{2}\\/\\d{2,4}");
        Matcher mat = pat.matcher(date);
        return mat.matches();
    }

}
