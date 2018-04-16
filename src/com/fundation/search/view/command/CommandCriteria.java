/*
 * @(#)CommandCriteria.java
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
package com.fundation.search.view.command;

import java.util.Map;

/**
 * This class allows get files attributes of commad line
 *
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class CommandCriteria {
    public String path;//p
    public String fileName;//f
    public String criteriaFileName;//cf
    public String isHidden;//h
    public String owner;//o
    public String date;//dc
    public String size;//s
    public String dateCreation;//dc
    public String dateModified;//dm
    public String dateLastAccess;//dl
    public String readOnly;//ro

    /**
     * Init the constructor.
     *
     * @param map with criterias and values.
     */
    public CommandCriteria(Map<String, String> map) {
        path = map.containsKey("-p") ? map.get("-p") : "";
        fileName = map.containsKey("-f") ? map.get("-f") : "";
        isHidden = map.containsKey("-h") ? map.get("-h") : "";
        owner = map.containsKey("-o") ? map.get("-o") : "";
        date = map.containsKey("-dc") ? map.get("-dc") : "";
        size = map.containsKey("-s") ? map.get("-s") : "";
        criteriaFileName = map.containsKey("-cf") ? map.get("-cf") : "";
        dateCreation = map.containsKey("-dc") ? map.get("-dc") : "";
        dateModified = map.containsKey("-dm") ? map.get("-dm") : "";
        dateLastAccess = map.containsKey("-dl") ? map.get("-dl") : "";
        readOnly = map.containsKey("-ro") ? map.get("-ro") : "";
    }

    /**
     * This method return a path.
     */
    public String getPath() {
        return path;
    }

    /**
     * This method return a file name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method return hidden/no hidden.
     */
    public String getIsHidden() {
        return isHidden;
    }

    /**
     * This method return owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * This method return file read Only.
     */
    public String getReadOnly() {
        return readOnly;
    }

    /**
     * This method return criteria file name(all words, start with, end with).
     */
    public String getCriteriaName() {
        return criteriaFileName;
    }

    /**
     * This method return file creation date.
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * This method return file modified date.
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * This method return file last access date.
     */
    public String getDateLastAccess() {
        return dateLastAccess;
    }

    /**
     * This method return file size.
     */
    public String getSize() {
        return size;
    }
}
