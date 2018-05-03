/*
 * @(#)MainSearchWindows.java
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
package com.fundation.search.model.database;

import com.fundation.search.common.SearchLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * This class is for create Connection with Singleton Pattern.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchConnection {

    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * searchConnection, Type: SearchConnection, connection on Singleton Pattern.
     */
    private static SearchConnection searchConnection;
    /**
     * searchConnection, Type: SearchConnection, connection to  database of application.
     */
    private static Connection connection;

    /**
     * Constructor for SearchConnection.
     */
    private SearchConnection() throws ClassNotFoundException, SQLException {
        LOOGER.info("Constructor SearchConnection Entry");

        // Initialize Connection
        this.initConnection();
        LOOGER.info("Constructor SearchConnection Exit");
    }

    /**
     * This method is for Initialize connection to SQLite.
     */
    private void initConnection() throws ClassNotFoundException, SQLException {
        LOOGER.info("initConnection Entry");
        Class.forName("org.sqlite.JDBC");

        // Setup connection
        connection = DriverManager.getConnection("jdbc:sqlite:search.db");

        // Get Statement
        Statement statement = connection.createStatement();
        String sqlQuery = "CREATE TABLE IF NOT EXISTS CRITERIA (ID INTEGER, CRITERIAJSON VARCHAR(200), PRIMARY KEY(ID))";

        // Execute Query and create database if not exist
        statement.execute(sqlQuery);
        LOOGER.info("initConnection Exit");
    }

    /**
     * This method is for return instance or create new if this not exist with Singleton Pattern.
     *
     * @return SearchConnection, this is SearchConnection class for Singleton Pattern.
     */
    public static SearchConnection getInstance() throws ClassNotFoundException, SQLException {
        LOOGER.info("getInstance Entry");
        if (searchConnection == null) {
            searchConnection = new SearchConnection();
        }
        LOOGER.info("getInstance Exit");
        return searchConnection;
    }

    /**
     * This method is for return Connection to database.
     *
     * @return Connection, this is connection to database.
     */
    public Connection getConnection() {
        LOOGER.info("getConnection Entry");
        LOOGER.info("getConnection Exit");
        return connection;
    }
}
