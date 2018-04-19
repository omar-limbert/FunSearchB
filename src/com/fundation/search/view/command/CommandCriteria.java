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

import com.fundation.search.common.SearchLogger;

import java.util.Map;
import java.util.logging.Logger;

/**
 * This class allows to get files attributes of commad line
 *
 * @author Escarleth Ledezma Q.
 * @version 1.0
 */
public class CommandCriteria {
    /**
     * pathFile is the file path
     */
    public String path;//p
    /**
     * nameFile is the file name
     */
    public String fileName;//f
    /**
     * criteria file name(all words, start with, end with)
     */
    public String criteriaFileName;//cf
    /**
     * isHiddenFile is the file state hidden/no hidden
     */
    public String isHidden;//h
    /**
     * owner is the file owner.
     */
    public String owner;//o

    /**
     * size is the file size.
     */
    public String size;//s
    /**
     * dateCreation is the file dateCreation.
     */
    public String dateCreation;//dc
    /**
     * dateModified is the file dateModified.
     */
    public String dateModified;//dm
    /**
     * dateLastAccess is the file dateLastAccess.
     */
    public String dateLastAccess;//dl
    /**
     * readOnly is true or false read only the file.
     */
    public String readOnly;//ro
    /**
     * Logger create a instance of logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Init the constructor.
     *
     * @param map with criterias and values.
     */
    public CommandCriteria(Map<String, String> map) {
        LOOGER.info("Constructor Command Criteria entry");
        path = map.containsKey("-p") ? map.get("-p") : "";
        fileName = map.containsKey("-f") ? map.get("-f") : "";
        isHidden = map.containsKey("-h") ? map.get("-h") : "";
        owner = map.containsKey("-o") ? map.get("-o") : "";
        size = map.containsKey("-s") ? map.get("-s") : "";
        criteriaFileName = map.containsKey("-cf") ? map.get("-cf") : "";
        dateCreation = map.containsKey("-dc") ? map.get("-dc") : "";
        dateModified = map.containsKey("-dm") ? map.get("-dm") : "";
        dateLastAccess = map.containsKey("-dl") ? map.get("-dl") : "";
        readOnly = map.containsKey("-ro") ? map.get("-ro") : "";
        LOOGER.info("Constructor Command Criteria exit");
    }

    /**
     * This method return a path.
     */
    public String getPath() {
        LOOGER.info("GetPath CommandCriteria" + path);
        return path;
    }

    /**
     * This method return a file name.
     */
    public String getFileName() {
        LOOGER.info("GetFileName CommandCriteria" + fileName);
        return fileName;
    }

    /**
     * This method return hidden/no hidden.
     */
    public String getIsHidden() {
        LOOGER.info("GetIsHidden CommandCriteria" + isHidden);
        return isHidden;
    }

    /**
     * This method return owner.
     */
    public String getOwner() {
        LOOGER.info("GetOwner CommandCriteria" + owner);
        return owner;
    }

    /**
     * This method return file read Only.
     */
    public String getReadOnly() {
        LOOGER.info("GetReadOnly CommandCriteria" + readOnly);
        return readOnly;
    }

    /**
     * This method return criteria file name(all words, start with, end with).
     */
    public String getCriteriaName() {
        LOOGER.info("GetCriteriaName CommandCriteria" + isHidden);
        return criteriaFileName;
    }

    /**
     * This method return file creation date.
     */
    public String getDateCreation() {
        LOOGER.info("GetDateCreation CommandCriteria" + dateCreation);
        return dateCreation;
    }

    /**
     * This method return file modified date.
     */
    public String getDateModified() {
        LOOGER.info("GetDateModified CommandCriteria" + dateModified);
        return dateModified;
    }

    /**
     * This method return file last access date.
     */
    public String getDateLastAccess() {
        LOOGER.info("GetDateLastAccess CommandCriteria" + dateLastAccess);
        return dateLastAccess;
    }

    /**
     * This method return file size.
     */
    public String getSize() {
        LOOGER.info("GetSize CommandCriteria" + size);
        return size;
    }

}