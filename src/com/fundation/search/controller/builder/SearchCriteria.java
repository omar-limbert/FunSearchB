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

import com.fundation.search.common.SearchLogger;

import java.nio.file.attribute.FileTime;
import java.util.logging.Logger;

/**
 * This class is make SearchCriteria with Builder Pattern.
 *
 * @author Omar Limbert Huanca sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchCriteria {

    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * path is the direction Path.
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
     * operator is the instruction (upper, lower and equal).
     */
    private String operator;
    /**
     * type is the format of size, for example Mb, Fb, and the rest.
     */
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
     * isReadOnly, true if is readable file and false if isn't readable file.
     */
    private boolean isReadOnly;
    /**
     * isDirectory, true if is Directoy and false if isn't Directory.
     */
    private boolean isDirectory;
    /**
     * isFileSystem, true if is File System and false if isn't File System.
     */
    private boolean isFileSystem;
    /**
     * extension, is file extension.
     */
    private String extension;
    /**
     * nameOnDataBase, is name on data base.
     */
    private String nameOnDataBase;


    /**
     * This class is to create SearchCriteria with Builder Pattern.
     *
     * @author Omar Limbert Huanca Sanchez - AT-[06].
     * @version 1.0.
     */
    public SearchCriteria(SearchCriteriaBuilder builder) {
        LOOGER.info("Constructor entry");

        // Initialize Builder
        this.path = builder.getPathCriteria();
        this.name = builder.getFileName();
        this.hiddenCriteria = builder.getHiddenCriteria();
        this.size = builder.getSizeCriteria();
        this.operator = builder.getOperator();
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
        this.isFileSystem = builder.getIsFileSystemCriteria();
        this.extension = builder.getExtensionCriteria();
        this.nameOnDataBase = builder.getNameOnDataBase();
        LOOGER.info("Constructor Exit");
    }

    /**
     * This method is for get Path.
     *
     * @return String return Path.
     */
    public String getPath() {
        LOOGER.info("getPath Entry");
        LOOGER.info("getPath Exit");
        return path;
    }

    /**
     * This method is for get File Name.
     *
     * @return String return File Name.
     */
    public String getName() {
        LOOGER.info("getName Entry");
        LOOGER.info("getName Exit");
        return name;
    }

    /**
     * This method is for get Hidden Criteria.
     *
     * @return String return Hidden Criteria.
     */
    public String getHiddenCriteria() {
        LOOGER.info("getHiddenCriteria Entry");
        LOOGER.info("getHiddenCriteria Exit");
        return hiddenCriteria;
    }

    /**
     * This method is for get Size.
     *
     * @return String return Size.
     */
    public long getSize() {
        LOOGER.info("getSize Entry");
        LOOGER.info("getSize Exit");
        return size;
    }

    /**
     * This method is for get Operator of Size.
     *
     * @return String return Operator of Size.
     */
    public String getOperator() {
        LOOGER.info("getOperator Entry");
        LOOGER.info("getOperator Exit");
        return operator == null ? "upper" : operator;
    }

    /**
     * This method is for get type of Size.
     *
     * @return String return type og Size.
     */
    public String getType() {
        LOOGER.info("getType Entry");
        LOOGER.info("getType Exit");
        return type;
    }

    /**
     * This method is for get File name Criteria.
     *
     * @return String return File name Criteria.
     */
    public String getFileNameCriteria() {
        LOOGER.info("getFileNameCriteria Entry");
        LOOGER.info("getFileNameCriteria Exit");
        return fileNameCriteria;

    }

    /**
     * This method is for get Owner.
     *
     * @return String return Owner.
     */
    public String getOwnerCriteria() {
        LOOGER.info("getOwnerCriteria Entry");
        LOOGER.info("getOwnerCriteria Exit");
        return ownerCriteria;
    }

    /**
     * This method is for get Init Date of Modified.
     *
     * @return String return Init Date of Modified.
     */
    public FileTime getModifiedDateInit() {
        LOOGER.info("getModifiedDateInit Entry");
        LOOGER.info("getModifiedDateInit Exit");
        return modifiedDateInit;
    }

    /**
     * This method is for get End Date of Modified.
     *
     * @return String return End Date of Modified.
     */
    public FileTime getModifiedDateEnd() {
        LOOGER.info("getModifiedDateEnd Entry");
        LOOGER.info("getModifiedDateEnd Exit");
        return modifiedDateEnd;
    }

    /**
     * This method is for get Init Date of Creation.
     *
     * @return String return Init Date of Creation.
     */
    public FileTime getCreationDateInit() {
        LOOGER.info("getCreationDateInit Entry");
        LOOGER.info("getCreationDateInit Exit");
        return creationDateInit;
    }

    /**
     * This method is for get End Date of Creation.
     *
     * @return String return End Date of Creation.
     */
    public FileTime getCreationDateEnd() {
        LOOGER.info("getCreationDateEnd Entry");
        LOOGER.info("getCreationDateEnd Exit");
        return creationDateEnd;
    }

    /**
     * This method is for get Init Date of Last Access.
     *
     * @return String return Init Date of Last Access.
     */
    public FileTime getLastAccessDateInit() {
        LOOGER.info("getLastAccessDateInit Entry");
        LOOGER.info("getLastAccessDateInit Exit");
        return lastAccessDateInit;
    }

    /**
     * This method is for get End Date of Last Access.
     *
     * @return String return End Date of Last Access.
     */
    public FileTime getLastAccessDateEnd() {
        LOOGER.info("getLastAccessDateEnd Entry");
        LOOGER.info("getLastAccessDateEnd Exit");
        return lastAccessDateEnd;
    }

    /**
     * This method is for get if can readable.
     *
     * @return boolean return true if file can read and false if cant read.
     */
    public boolean getIsReadOnly() {
        LOOGER.info("getIsReadOnly Entry");
        LOOGER.info("getIsReadOnly Exit");
        return isReadOnly;
    }

    /**
     * This method is for get if fis directory.
     *
     * @return boolean return true if is directory and false if is not directory.
     */
    public boolean getIsDirectory() {
        LOOGER.info("getIsDirectory Entry");
        LOOGER.info("getIsDirectory Exit");
        return isDirectory;
    }

    /**
     * This method is for get if is file system.
     *
     * @return boolean return true if is file System and false if is not file System.
     */
    public boolean getIsFileSystem() {
        LOOGER.info("getIsFileSystem Entry");
        LOOGER.info("getIsFileSystem Exit");
        return isFileSystem;
    }

    /**
     * This method is for get nameOnDataBase.
     *
     * @return String return extension of file.
     */
    public String getNameOnDataBase() {
        return nameOnDataBase;
    }

    /**
     * This method is for get extension.
     *
     * @return String return extension of file.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * This method is for update name on data base.
     *
     * @return String return extension of file.
     */
    public void updateNameOnDataBase(String nameOnDataBase) {
        this.nameOnDataBase = nameOnDataBase;
    }
}
