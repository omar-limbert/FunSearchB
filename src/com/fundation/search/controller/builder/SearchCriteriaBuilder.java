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
 * @author Omar Limbert Huanca sanchez - AT-[06]
 * @version 1.0.
 */
public class SearchCriteriaBuilder {

    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();
    /**
     * path is the Path.
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
     * operator is the instruccion (upper, lower and equal.
     */
    private String operator;
    /**
     * type is the format of size, for example Mb, Fb, and the rest
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
     * nameOnDataBase, name on data base.
     */
    private String nameOnDataBase;
    /**
     * keySensitiveOfCriteria, Key sensitive criteria.
     */
    private boolean keySensitiveOfCriteria;
    /**
     * isContainsInsideFileCriteria, is name on data base.
     */
    private boolean isContainsInsideFileCriteria;
    /**
     * textContainsInsideFileCriteria, is name on data base.
     */
    private String textContainsInsideFileCriteria;



    /**
     * This method is constructor of SearchCriteriaBuilder
     */
    public SearchCriteriaBuilder() {
        LOOGER.info("Constructor Entry");
        LOOGER.info("Constructor Exit");

    }

    /**
     * This method is for initialize Builder Pattern
     *
     * @return SearchCriteria, return the class for Builder
     */
    public SearchCriteria build() {
        LOOGER.info("build Entry");
        LOOGER.info("build Exit");
        return new SearchCriteria(this);
    }

    /**
     * This method is for initialize pathCriteria.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder pathCriteria(String path) {
        LOOGER.info("pathCriteria Entry");
        LOOGER.info("pathCriteria Exit");
        this.path = path;
        return this;
    }

    /**
     * This method is for initialize fileName.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder fileName(String name) {
        LOOGER.info("fileName Entry");
        LOOGER.info("fileName Exit");
        this.name = name;
        return this;
    }

    /**
     * This method is for initialize hiddenCriteria.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder hiddenCriteria(String hiddenCriteria) {
        LOOGER.info("hiddenCriteria Entry");
        LOOGER.info("hiddenCriteria Exit");
        this.hiddenCriteria = hiddenCriteria;
        return this;
    }

    /**
     * This method is for initialize sizeCriteria.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder sizeCriteria(String operators, long size, String type) {
        LOOGER.info("sizeCriteria Entry");

        if (operators != null) {
            // Converting operator to valid format for Model
            if (operators.equalsIgnoreCase("Minor to:")) {
                this.operator = "lower";
            }
            if (operators.equalsIgnoreCase("Major to:")) { // Little change on UI to "Major"
                this.operator = "upper";
            }
            if (operators.equalsIgnoreCase("Equals to:")) {
                this.operator = "equal";
            }
            this.type = type;
            this.size = size;
            return this;
        }

        this.operator = "upper";
        this.type = type;
        this.size = 0;
        LOOGER.info("sizeCriteria Exit");
        return this;
    }

    /**
     * This method is for initialize fileNameCriteria.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder keySensitiveOfCriteria(boolean keySensitiveOfCriteria) {
        LOOGER.info("keySensitiveOfCriteria Entry");
        LOOGER.info("keySensitiveOfCriteria Exit");
        this.keySensitiveOfCriteria = keySensitiveOfCriteria;
        return this;
    }
    /**
     * This method is for initialize fileNameCriteria.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder fileNameCriteria(String fileNameCriteria) {
        LOOGER.info("fileNameCriteria Entry");
        LOOGER.info("fileNameCriteria Exit");
        this.fileNameCriteria = fileNameCriteria;
        return this;
    }

    /**
     * This method is for initialize ownerCriteria.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder ownerCriteria(String ownerCriteria) {
        LOOGER.info("ownerCriteria Entry");
        LOOGER.info("ownerCriteria Exit");
        this.ownerCriteria = ownerCriteria;
        return this;
    }

    /**
     * This method is for initialize modifiedDateInit and modifiedDateEnd.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder modifiedDateCriteria(FileTime modifiedDateInit, FileTime modifiedDateEnd) {
        LOOGER.info("modifiedDateCriteria Entry");
        this.modifiedDateInit = modifiedDateInit;
        this.modifiedDateEnd = modifiedDateEnd;
        LOOGER.info("modifiedDateCriteria Exit");
        return this;
    }

    /**
     * This method is for initialize creationDateInit and creationDateEnd.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder creationDateCriteria(FileTime creationDateInit, FileTime creationDateEnd) {
        LOOGER.info("creationDateCriteria Entry");
        this.creationDateInit = creationDateInit;
        this.creationDateEnd = creationDateEnd;
        LOOGER.info("creationDateCriteria Exit");
        return this;
    }

    /**
     * This method is for initialize lastAccessDateInit and lastAccessDateEnd.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder lastAccessDateCriteria(FileTime lastAccessDateInit, FileTime lastAccessDateEnd) {
        LOOGER.info("lastAccessDateCriteria Entry");
        this.lastAccessDateInit = lastAccessDateInit;
        this.lastAccessDateEnd = lastAccessDateEnd;
        LOOGER.info("lastAccessDateCriteria Exit");
        return this;
    }

    /**
     * This method is for initialize isReadOnly.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder isReadCriteria(boolean isReadOnly) {
        LOOGER.info("isReadCriteria Entry");
        LOOGER.info("isReadCriteria Exit");
        this.isReadOnly = isReadOnly;
        return this;
    }

    /**
     * This method is for initialize isDirectory
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder isContainsInsideFileCriteria(boolean isContainsInsideFileCriteria) {
        LOOGER.info("isContainsInsideFileCriteria Entry");
        LOOGER.info("isContainsInsideFileCriteria Exit");
        this.isContainsInsideFileCriteria = isContainsInsideFileCriteria;
        return this;
    }

    /**
     * This method is for initialize isDirectory
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder textContainsInsideFileCriteria(String textContainsInsideFileCriteria) {
        LOOGER.info("textContainsInsideFileCriteria Entry");
        LOOGER.info("textContainsInsideFileCriteria Exit");
        this.textContainsInsideFileCriteria = textContainsInsideFileCriteria;
        return this;
    }
    /**
     * This method is for initialize isDirectory
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder isDirectoryCriteria(boolean isDirectory) {
        LOOGER.info("isDirectoryCriteria Entry");
        LOOGER.info("isDirectoryCriteria Exit");
        this.isDirectory = isDirectory;
        return this;
    }
    /**
     * This method is for initialize isFileSystem.
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder isFileSystemCriteria(boolean isFileSystem) {
        LOOGER.info("isFileSystemCriteria Entry");
        LOOGER.info("isFileSystemCriteria Exit");
        this.isFileSystem = isFileSystem;
        return this;
    }

    /**
     * This method is for initialize extension .
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder extensionCriteria(String extension) {
        LOOGER.info("extensionCriteria Entry");
        LOOGER.info("extensionCriteria Exit");
        this.extension = extension;
        return this;
    }

    /**
     * This method is for initialize name on data base .
     *
     * @return SearchCriteriaBuilder return Builder Class.
     */
    public SearchCriteriaBuilder nameOnDataBase(String nameOnDataBase) {
        LOOGER.info("extensionCriteria Entry");
        LOOGER.info("extensionCriteria Exit");
        this.nameOnDataBase = nameOnDataBase;
        return this;
    }
    /**
     * This method is for get Path.
     *
     * @return String return Path.
     */
    public String getPathCriteria() {
        LOOGER.info("getPathCriteria Entry");
        LOOGER.info("getPathCriteria Exit");
        return path;
    }

    /**
     * This method is for get File Name.
     *
     * @return String return File Name.
     */
    public String getFileName() {
        LOOGER.info("getFileName Entry");
        LOOGER.info("getFileName Exit");
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
    public long getSizeCriteria() {
        LOOGER.info("getSizeCriteria Entry");
        LOOGER.info("getSizeCriteria Exit");
        return size;
    }

    /**
     * This method is for get Operator of Size.
     *
     * @return String return Operator of Size.
     */
    public String getOperator() {
        LOOGER.info("getgOperator Entry");
        LOOGER.info("getgOperator Exit");
        return operator;
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
    public boolean getIsReadCriteria() {
        LOOGER.info("getIsReadCriteria Entry");
        LOOGER.info("getIsReadCriteria Exit");
        return isReadOnly;
    }

    /**
     * This method is for get if fis directory.
     *
     * @return boolean return true if is directory and false if is not directory.
     */
    public boolean getIsDirectoryCriteria() {
        LOOGER.info("getIsDirectoryCriteria Entry");
        LOOGER.info("getIsDirectoryCriteria Exit");
        return isDirectory;
    }

    /**
     * This method is for get if is file system.
     *
     * @return boolean return true if is file System and false if is not file System.
     */
    public boolean getIsFileSystemCriteria() {
        LOOGER.info("getIsFileSystemCriteris Entry");
        LOOGER.info("getIsFileSystemCriteris Exit");
        return isFileSystem;
    }

    /**
     * This method is for get extension.
     *
     * @return String return extension of file.
     */
    public String getExtensionCriteria() {
        LOOGER.info("getExtensionCriteria Entry");
        LOOGER.info("getExtensionCriteria Exit");
        return extension;
    }

    /**
     * This method is for get Name on data base.
     *
     * @return String return extension of file.
     */
    public String getNameOnDataBase() {
        LOOGER.info("getNameOnDataBase Entry");
        LOOGER.info("getNameOnDataBase Exit");
        return nameOnDataBase;
    }

    /**
     * This method is for get Name on data base.
     *
     * @return String return extension of file.
     */
    public boolean getKeySensitiveOfCriteria() {
        LOOGER.info("getKeySensitiveOfCriteria Entry");
        LOOGER.info("getKeySensitiveOfCriteria Exit");
        return keySensitiveOfCriteria;
    }

    /**
     * This method is to get contains inside file criteria.
     *
     * @return boolean return if this active.
     */
    public boolean getIsContainsInsideFileCriteria() {
        LOOGER.info("getIsContainsInsideFileCriteria Entry");
        LOOGER.info("getIsContainsInsideFileCriteria Exit");
        return isContainsInsideFileCriteria;
    }

    /**
     * This method is to get contains inside file criteria.
     *
     * @return String return text for inside criteria.
     */
    public String getTextContainsInsideFileCriteria() {
        LOOGER.info("getTextContainsInsideFileCriteria Entry");
        LOOGER.info("getTextContainsInsideFileCriteria Exit");
        return textContainsInsideFileCriteria;
    }

}

