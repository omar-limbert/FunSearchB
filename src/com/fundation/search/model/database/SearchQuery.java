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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * This class si for all query's to database.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchQuery {

    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * connection, Type: Connection, this is connection to replace to connection on Singleton.
     */
    private Connection connection;

    /**
     * Constructor for SearchQuery.
     */
    public SearchQuery() throws SQLException, ClassNotFoundException {
        LOOGER.info("Constructor Entry");
        connection = SearchConnection.getInstance().getConnection();
        LOOGER.info("Constructor Exit");
    }

    /**
     * This method is for add Criteria to database with query.
     *
     * @return SearchConnection, this is SearchConnection class for Singleton Pattern.
     */
    public String addCriteria(String criteriaJSon) {
        LOOGER.info("addCriteria Entry");
        try {
            String insertQuery = "insert into criteria values(?,?);";

            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(insertQuery);


            preparedStatement.setString(2, criteriaJSon);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error Connection";
        }
        LOOGER.info("addCriteria Exit");
        return "Success Connection";
    }

    /**
     * This method is for return all Criteria's from database with query.
     *
     * @return ResultSet, this contains all rows of criteria on database.
     */
    public ResultSet getAllCriteria() {
        LOOGER.info("getAllCriteria Entry");
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id,criteriajson from criteria");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOOGER.info("getAllCriteria Exit");
        return resultSet;
    }

    /**
     * This method is for return all Criteria's from database with query.
     *
     * @return ResultSet, this contains all rows of criteria on database.
     */
    public String deleteCriteria(int index) {
        LOOGER.info("Delete Criteria Entry");
        try {
            String insertQuery = "delete from criteria where id = '"+index+"';";

            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error Connection";
        }
        LOOGER.info("Delete Criteria Exit");
        return "Success Delete";
    }
}
