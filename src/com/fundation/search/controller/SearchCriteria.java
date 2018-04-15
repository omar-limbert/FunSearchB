/*
 * @(#)SearchCriteria.java
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


import java.nio.file.attribute.FileTime;
import java.util.Map;

/**
 * This class save the SearchCriterial..
 * Before to send the Search Class.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class SearchCriteria {

    /**
     * path is the direcction Path.
     */
    private String path;
    /**
     * name is the file name.
     */
    private String name;
    /**
     * isHidden is a string instrucction.
     */
    private String HiddenCriteria;
    /**
     * size is the file size.
     */
    private long size;
    /**
     * operator is the instruccion (> ; < ; =).
     */
    private String operator;
    /**
     * name is the file name criteria.
     */
    private String fileNameCriteria;
    /**
     * ownerCriteria, is the owner name criteria.
     */
    private String ownerCriteria;
    /**
     * modifiedDateInit, FileTime init of last modified.
     */
    private FileTime modifiedDateInit;
    /**
     * modifiedDateEnd, FileTime end of last modified.
     */
    private FileTime modifiedDateEnd;
    /**
     * creationDateInit, FileTime init of creation.
     */
    private FileTime creationDateInit;
    /**
     * creationDateEnd, FileTime end of creation.
     */
    private FileTime creationDateEnd;
    /**
     * lastAccessDateInit, FileTime init of last access.
     */
    private FileTime lastAccessDateInit;
    /**
     * lastAccessDateEnd, FileTime end of last access.
     */
    private FileTime lastAccessDateEnd;
    /**
     * isReadOnly, true if is readable file and false if isn't readable file.
     */

    private boolean isReadOnly;
    /**
     * isFileSystem, a condition in order to search by Files of the system.
     */
    private boolean isFileSystem;
    /**
     * isDirectory, a condition in order to search Directories.
     */

    private boolean isDirectory;
    /**
     * intoFile, the text for search into a file.
     */

    private String intoFile;
    /**
     * extension, the extension text.
     */

    private String extension;

    /**
     * This method init the Search Criteria.
     *
     * @param data, This Map contains all data of User Interface validated.
     */
    public SearchCriteria(Map<String, Object> data) {
        // FileData helper to extract data of Map
        FileTime[] dateOfData;

        // Extracting data of Map
        this.path = (path != "") ? data.get("Path Criteria").toString() : null;
        this.name = (name != "") ? data.get("Search Text").toString() : null;
        this.HiddenCriteria = data.get("Hidden Criteria").toString();
        this.fileNameCriteria = data.get("Name Criteria").toString();
        this.ownerCriteria = data.get("Owner Criteria").toString();
        this.isReadOnly = (boolean) data.get("Read Only Criteria");
        this.size = 1000L; //data.get("Size Criteria").toString(); // Problem converting to LONG
        this.operator = "upper";
        dateOfData = (FileTime[]) data.get("Creation Date Criteria");
        this.creationDateInit = dateOfData[0];
        this.creationDateEnd = dateOfData[1];
        dateOfData = (FileTime[]) data.get("Modified Date Criteria");
        this.modifiedDateInit = dateOfData[0];
        this.modifiedDateEnd = dateOfData[1];
        dateOfData = (FileTime[]) data.get("Last Access Date Criteria");
        this.lastAccessDateInit = dateOfData[0];
        this.lastAccessDateEnd = dateOfData[1];

    }

    /**
     * @return String the file name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return String the directory path.
     */
    public String getPath() {
        return path;
    }

    /**
     * @return long the file size.
     */
    public long getSize() {
        return size;
    }

    /**
     * @return char the instruction of the operator.
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @return String the file hidden.
     */
    public String getHiddenCriteria() {
        return HiddenCriteria;
    }

    /**
     * @return String the name criteria.
     */
    public String getFileNameCriteria() {
        return fileNameCriteria;
    }

    /**
     * @return String owner of criteria.
     */
    public String getOwnerCriteria() {
        return ownerCriteria;
    }

    /**
     * @return FileTime init of creation.
     */
    public FileTime getCreationDateInit() {
        return creationDateInit;
    }

    /**
     * @return FileTime end of creation.
     */
    public FileTime getCreationDateEnd() {
        return creationDateEnd;
    }

    /**
     * @return FileTime init of last modified.
     */
    public FileTime getModifiedDateInit() {
        return modifiedDateInit;
    }

    /**
     * @return FileTime end of last modified.
     */
    public FileTime getModifiedDateEnd() {
        return modifiedDateEnd;
    }

    /**
     * @return FileTime init of last access.
     */
    public FileTime getLastAccessDateInit() {
        return lastAccessDateInit;
    }

    /**
     * @return FileTime end of last access.
     */
    public FileTime getLastAccessDateEnd() {
        return lastAccessDateEnd;
    }

    /**
     * @return boolean, true if is readable file and false if isn't readable file.
     */
    public boolean getIsReadOnly() {
        return isReadOnly;
    }

    /**
     * @return boolean, true if is file of the system  and false if isn't file of the system.
     */
    public boolean getIsFileSystem() {
        return isFileSystem;
    }

    /**
     * @return boolean, true if is a directory  and false if isn't a directory.
     */
    public boolean getIsDirectory() {
        return isDirectory;
    }

    /**
     * @return the name of files that contain a word.
     */
    public String getIntoFile() {
        return intoFile;
    }

    /**
     * @return the file name that contain the extension.
     */
    public String getExtension() {
        return extension;
    }
}
