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

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class validate all the fields that are recivied by the GUI.
 * For this method  was implement using Expressions Regulars.
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
     * @param path a String Path
     * @return true if it is a valid format for a path.
     * return false if is an invalid format for a path.
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
     * @return true if the path exist on the PC.
     * false if the that does not exist on the PC.
     */
    public boolean isValidPath(String path) {
        File pathD = new File(path);
        return pathD.isDirectory();
    }

    /**
     * It method checks if the input is a valid File format.
     *
     * @param file format file name.
     * @return true if it is a valid format for a file name.
     * false if it is an invalid format for a file name.
     */
    public boolean validatorFile(String file) {
        pattern = Pattern.compile("(\\w+(\\s|[^:*?\"<>|]\\w+)*)+");
        matcher = pattern.matcher(file);
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid Type (extension of the file) format.
     *
     * @param type a format file extension name.
     * @return true if it is a valid format for a extension.
     * false if it is an invalid format for a extension.
     */
    public boolean validatorType(String type) {
        pattern = Pattern.compile("^\\.[a-z]{3,4}");
        matcher = pattern.matcher(type);
        return matcher.matches();
    }

    /**
     * It method checks if the input is a valid size format.
     *
     * @param size format file size.
     * @return true if it is a valid format for a size format.
     * false if it is an invalid format for a size format.
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
