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
import java.util.ArrayList;
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
     * nameOnDataBase, is name on data base.
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

    //Search by Multimedia

    /**
     * multimediaDuration, is name on data base.
     */
    private Double multimediaDuration;

    /**
     * multimediaDurationOperator, is name on data base.
     */
    private String multimediaDurationOperator;

    /**
     * multimediaDurationType, is name on data base.
     */
    private String multimediaDurationType;

    /**
     * multimediaVideoCodec, is name on data base.
     */
    private ArrayList<String> multimediaVideoCodec;

    /**
     * multimediaResolution, is name on data base.
     */
    private ArrayList<String> multimediaResolution;

    /**
     * multimediaType, is name on data base.
     */
    private ArrayList<String> multimediaType;

    /**
     * searchMultimedia, is name on data base.
     */
    private boolean searchMultimedia;

    /**
     * multimediaFrameRate, is name on data base.
     */
    private ArrayList<String> multimediaFrameRate;

    /**
     * multimediaAudioBitRateInit, is name on data base.
     */
    private String multimediaAudioBitRateInit;

    /**
     * multimediaAudioBitRateEnd, is name on data base.
     */
    private String multimediaAudioBitRateEnd;


    /**
     * This class is to create SearchCriteria with Builder Pattern.
     *
     * @author Omar Limbert Huanca Sanchez - AT-[06].
     * @version 1.0.
     */
    public SearchCriteria(SearchCriteriaBuilder builder) {
        LOOGER.info("Constructor entry");

        // Initialize Builder by Search Files
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
        this.keySensitiveOfCriteria = builder.getKeySensitiveOfCriteria();
        this.isContainsInsideFileCriteria = builder.getIsContainsInsideFileCriteria();
        this.textContainsInsideFileCriteria = builder.getTextContainsInsideFileCriteria();

        // Initialize Builder by Search Multimedia
        this.multimediaDuration = builder.getMultimediaDuration();
        this.multimediaVideoCodec = builder.getMultimediaVideoCodec();
        this.multimediaResolution = builder.getMultimediaResolution();
        this.multimediaAudioBitRateInit = builder.getMultimediaAudioBitRateInit();
        this.multimediaAudioBitRateEnd = builder.getMultimediaAudioBitRateEnd();
        this.multimediaType = builder.getMultimediaType();
        this.multimediaDurationOperator = builder.getMultimediaDurationOperator();
        this.multimediaDurationType = builder.getMultimediaDurationType();
        this.searchMultimedia = builder.isSearchMultimedia();
        this.multimediaFrameRate = builder.getFrameRateCriteria();
        LOOGER.info("Constructor Exit");
    }

    /**
     * This method is for get getMultimediaDurationOperatorDB.
     *
     * @return String return getMultimediaDurationOperatorDB.
     */
    public String getMultimediaDurationOperatorDB() {
        LOOGER.info("getMultimediaDurationOperatorDB Entry");

        if(multimediaDurationOperator.equalsIgnoreCase("upper")){
            return "Major to:";
        }
        if(multimediaDurationOperator.equalsIgnoreCase("lower")){
            return "Minor to:";
        }
        if(multimediaDurationOperator.equalsIgnoreCase("equal")){
            return "Equal to:";
        }
        LOOGER.info("getMultimediaDurationOperatorDB Exit");
        return "Major to:";
    }

    /**
     * This method is for get getMultimediaAudioBitRateInit.
     *
     * @return String return multimediaAudioBitRateInit.
     */
    public String getMultimediaAudioBitRateInit() {
        LOOGER.info("getMultimediaAudioBitRateInit Entry");
        LOOGER.info("getMultimediaAudioBitRateInit Exit");
        return multimediaAudioBitRateInit;
    }

    /**
     * This method is for get getMultimediaAudioBitRateEnd.
     *
     * @return String return multimediaAudioBitRateEnd.
     */
    public String getMultimediaAudioBitRateEnd() {
        LOOGER.info("getMultimediaAudioBitRateEnd Entry");
        LOOGER.info("getMultimediaAudioBitRateEnd Exit");
        return multimediaAudioBitRateEnd;
    }

    /**
     * This method is for get getFrameRateCriteria.
     *
     * @return String return multimediaFrameRate.
     */
    public ArrayList<String> getFrameRateCriteria() {
        LOOGER.info("getFrameRateCriteria Entry");
        LOOGER.info("getFrameRateCriteria Exit");
        return multimediaFrameRate;
    }

    /**
     * This method is for get isSearchMultimedia.
     *
     * @return String return searchMultimedia.
     */
    public boolean isSearchMultimedia() {
        LOOGER.info("isSearchMultimedia Entry");
        LOOGER.info("isSearchMultimedia Exit");
        return searchMultimedia;
    }

    /**
     * This method is for get getMultimediaDurationType.
     *
     * @return String return multimediaDurationType.
     */
    public String getMultimediaDurationType() {
        LOOGER.info("getMultimediaDurationType Entry");
        LOOGER.info("getMultimediaDurationType Exit");
        return multimediaDurationType;
    }

    /**
     * This method is for get getMultimediaDurationOperator.
     *
     * @return String return multimediaDurationOperator.
     */
    public String getMultimediaDurationOperator() {
        LOOGER.info("getMultimediaDurationOperator Entry");
        LOOGER.info("getMultimediaDurationOperator Exit");
        return multimediaDurationOperator;
    }

    /**
     * This method is for get getMultimediaVideoCodec.
     *
     * @return String return multimediaVideoCodec.
     */
    public ArrayList<String> getMultimediaVideoCodec() {
        LOOGER.info("getMultimediaVideoCodec Entry");
        LOOGER.info("getMultimediaVideoCodec Exit");
        return multimediaVideoCodec;
    }

    /**
     * This method is for get getMultimediaResolution.
     *
     * @return String return multimediaResolution.
     */
    public ArrayList<String> getMultimediaResolution() {
        LOOGER.info("getMultimediaResolution Entry");
        LOOGER.info("getMultimediaResolution Exit");
        return multimediaResolution;
    }

    /**
     * This method is for get getMultimediaType.
     *
     * @return String return multimediaType.
     */
    public ArrayList<String> getMultimediaType() {
        LOOGER.info("getMultimediaType Entry");
        LOOGER.info("getMultimediaType Exit");
        return multimediaType;
    }

    /**
     * This method is for get getMultimediaDuration.
     *
     * @return String return multimediaDuration.
     */
    public Double getMultimediaDuration() {
        LOOGER.info("getMultimediaDuration Entry");
        LOOGER.info("getMultimediaDuration Exit");
        return multimediaDuration;
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
     * This method is for get if is file system.
     *
     * @return boolean return true if is file System and false if is not file System.
     */
    public boolean getKeySensitiveOfCriteria() {
        LOOGER.info("getIsFileSystem Entry");
        LOOGER.info("getIsFileSystem Exit");
        return keySensitiveOfCriteria;
    }

    /**
     * This method is to get nameOnDataBase.
     *
     * @return String return extension of file.
     */
    public String getNameOnDataBase() {
        LOOGER.info("getNameOnDataBase Entry");
        LOOGER.info("getNameOnDataBase Exit");
        return nameOnDataBase;
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

    /**
     * This method is for get extension.
     *
     * @return String return extension of file.
     */
    public String getExtension() {
        LOOGER.info("getExtension Entry");
        LOOGER.info("getExtension Exit");
        return extension;
    }

    /**
     * This method is for update name on data base.
     *
     * @return String return extension of file.
     */
    public void updateNameOnDataBase(String nameOnDataBase) {
        LOOGER.info("updateNameOnDataBase Entry");
        LOOGER.info("updateNameOnDataBase Exit");
        this.nameOnDataBase = nameOnDataBase;
    }
}
