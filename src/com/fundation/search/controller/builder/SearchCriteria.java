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
package com.fundation.search.controller.builder;

import java.nio.file.attribute.FileTime;

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
        private String hiddenCriteria;
        /**
         * size is the file size.
         */
        private long size;
        /**
         * operator is the instruccion (> ; < ; =).
         */
        private String operator;
        private String type;
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
         * isRead, true if is readable file and false if isn't readable file
         */
        private boolean isReadOnly;
        private boolean isDirectory;
        private boolean isFileSystem;
        private String extension;




    /**
     * This class save the SearchCriterial..
     * Before to send the Search Class.
     *
     * @author Ariel Gonzales Vargas - AT-[06].
     * @version 1.0.
     */
    public SearchCriteria( SearchCriteriaBuilder builder) {
        this.path = builder.getPathCriteria();
        this.name = builder.getFileName();
        this.hiddenCriteria = builder.getHiddenCriteria();
        this.size = builder.getSizeCriteria();
        this.operator = builder.getgetOperator();
        this.type = builder.getType();
        this.fileNameCriteria = builder.getFileNameCriteria();
        this.ownerCriteria = builder.getOwnerCriteria();
        this.modifiedDateInit = builder.getModifiedDateInit();
        this.modifiedDateEnd = builder.getModifiedDateEnd();
        this.creationDateInit = builder.getCreationDateInit();
        this.creationDateEnd = builder.getCreationDateEnd();
        this.lastAccessDateInit = builder.getLastAccessDateInit();
        this.lastAccessDateEnd = builder.getLastAccessDateEnd();
        this.isReadOnly = builder.getIsReadCriteria();
        this.isDirectory = builder.getIsDirectoryCriteria();
        this.isFileSystem = builder.getIsFileSystemCriteris();
        this.extension = builder.getExtensionCriteria();

    }
    public String getPath() {
        return path;
    }
    public String getName() {
        return name;
    }

    public String getHiddenCriteria() {
        return hiddenCriteria;
    }

    public long getSize() {
        return size;
    }

    public String getOperator() {
        return operator;
    }

    public String getType() {
        return type;
    }

    public String getFileNameCriteria() {
        return fileNameCriteria;
    }

    public String getOwnerCriteria() {
        return ownerCriteria;
    }

    public FileTime getModifiedDateInit() {
        return modifiedDateInit;
    }

    public FileTime getModifiedDateEnd() {
        return modifiedDateEnd;
    }

    public FileTime getCreationDateInit() {
        return creationDateInit;
    }

    public FileTime getCreationDateEnd() {
        return creationDateEnd;
    }

    public FileTime getLastAccessDateInit() {
        return lastAccessDateInit;
    }

    public FileTime getLastAccessDateEnd() {
        return lastAccessDateEnd;
    }

    public boolean getIsReadOnly() {
        return isReadOnly;
    }

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public boolean getIsFileSystem() {
        return isFileSystem;
    }

    public String getExtension() {
        return extension;
    }
}
