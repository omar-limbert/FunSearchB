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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

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
     * SYSTEM_SEPARATOR, String: This system separator to make portable on Windows, Linux, OSX.
     */
    private final static String SYSTEM_SEPARATOR = System.getProperty("file.separator");

    /**
     * Private Constructor for Singleton Pattern.
     */
    private SearchLogger() {
        // Logger
        logger = Logger.getLogger(SearchLogger.class.getName());
        try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream(System.getProperty("user.dir")
                            + SYSTEM_SEPARATOR
                            + "config"
                            + SYSTEM_SEPARATOR + "logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Set logger of on Console
        logger.setUseParentHandlers(false);
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

