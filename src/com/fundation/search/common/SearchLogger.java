/*
 * @(#)SearchToolBar.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class is for create Logger with Singleton Pattern.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchLogger {

    /**
     * searchLogger, Type: SearchLogger, this variable is for Singleton Pattern.
     */
    private static SearchLogger searchLogger;
    /**
     * logger, Type: Logger, this is Logger of java.
     */
    private Logger logger;
    /**
     * fileHandler, FileHandler: Handler for Singleton Pattern.
     */
    private FileHandler fileHandler;
    /**
     * currently_date, String: This is currently Date in String format.
     */
    private String currently_date;
    /**
     * SYSTEM_SEPARATOR, String: This system separator to make portable on Windows, Linux, OSX.
     */
    private final static String SYSTEM_SEPARATOR = System.getProperty("file.separator");

    /**
     * Private Constructor for Singleton Pattern.
     */
    private SearchLogger() {
        // Logger
        logger = Logger.getLogger(SearchLogger.class.getName());

        // Currently date in "YYYY-MMM-dd" format.
        currently_date = new SimpleDateFormat("YYYY-MMM-dd").format(new Date());

        // This block configure the logger with handler and formatter
        try {
            fileHandler = new FileHandler(System.getProperty("user.dir")
                    + SYSTEM_SEPARATOR //System separator
                    + "logs" // folder to save .log
                    + SYSTEM_SEPARATOR //System separator
                    + currently_date // currently date on String format
                    + ".log", true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Adding handler to logger.
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }

    /**
     * Method for get Logger with Singleton Pattern.
     *
     * @return SearchLogger This is a Logger instance.
     */
    public static SearchLogger getInstanceOfLogger() {

        return searchLogger == null ? searchLogger = new SearchLogger() : searchLogger;
    }

    /**
     * Method for return Logger.
     *
     * @return Logger This is logger for use in other Classes.
     */
    public Logger getLogger() {
        return logger;

    }
}
