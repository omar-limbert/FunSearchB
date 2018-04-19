/*
 * @(#)FileNamePanel.java
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
package com.fundation.search.model.asset;

import java.nio.file.attribute.FileTime;

/**
 * This class Asset can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06]..
 * @version 1.0.
 */
public class Asset {

    /**
     * pathFile is the file path
     */
    private String pathFile;
    /**
     * nameFile is the file name
     */
    private String nameFile;
    /**
     * sizeFile is the file tam
     */
    private long sizeFile;
    /**
     * isHiddenFile is the file state hidden/no hidden
     */
    private boolean isHiddenFile;
    /**
     * lastModifiedTime the last access.
     */
    private FileTime lastModifiedTime;
    /**
     * creationTime the last creatin.
     */
    private FileTime creationTime;
    /**
     * lastAccessTime the last access.
     */
    private FileTime lastAccessTime;
    /**
     * isReadOnly if the file state isReadOnly/no isReadOnly.
     */
    private boolean isReadOnly;
    /**
     * isFileSystem if the file state isFileSystem/no isFileSystem.
     */
    private boolean isFileSystem;
    /**
     * isDirectory if the file state isDirectory/no isDirectory.
     */
    private boolean isDirectory;
    /**
     * ownerFile the name of the owner.
     */
    private String ownerFile;
    /**
     * The text for made a search.
     */
    private String intoFile;
    /**
     * The Type of extension.
     */


    /**
     * FileResult constructor.
     *
     * @param pathFile     path .
     * @param nameFile     name file.
     * @param sizeFile     lenght file.
     * @param isHiddenFile state hidden file.
     */
//FileTime lastModifiedTimeInit, FileTime lastModifiedTimeEnd, FileTime creationTimeInit , FileTime creationTimeEnd, FileTime lastAccessTimeInit, FileTime lastAccessTimeEnd
    public Asset(String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, boolean readFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, String ownerFile, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String intoFile) {
        this.pathFile = pathFile;
        this.nameFile = nameFile;
        this.sizeFile = sizeFile;
        this.isHiddenFile = isHiddenFile;
        this.lastModifiedTime = lastModifiedTime;
        this.creationTime = creationTime;
        this.lastAccessTime = lastAccessTime;
        this.ownerFile = ownerFile;
        this.isReadOnly = isReadOnly;
        this.isFileSystem = isFileSystem;
        this.isDirectory = isDirectory;
        this.intoFile = intoFile;

    }

    /**
     * This method return a path.
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * This method return the file name.
     */
    public String getName() {
        return nameFile;
    }

    /**
     * This method return the size file.
     */
    public long getSizeFile() {
        return sizeFile;
    }

    /**
     * This method return true if the a file is hidden .
     */
    public boolean getIsHidden() {
        return isHiddenFile;
    }

    /**
     * This method return creationTime on a File.
     */
    public FileTime getCreationTime() {
        return creationTime;
    }

    /**
     * This method return lastAccessTime on a File.
     */
    public FileTime getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * This method return lastModifiedTime on a File.
     */
    public FileTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * This method return true if the a file isReadOnly.
     */
    public boolean getIsReadOnlyFile() {
        return isReadOnly;
    }

    /**
     * This method return true if the a file isFileSystem.
     */
    public boolean getIsFileSystemFile() {
        return isFileSystem;
    }

    /**
     * This method return true if the a file isDirectory.
     */
    public boolean getIsDirectory() {
        return isDirectory;
    }

    /**
     * This method return the text into the file.
     */
    public String getIntoFile() {
        return intoFile;
    }

    /**
     * This method return the name of the owner.
     */
    public String getOwnerFile() {
        return ownerFile;
    }

    /**
     * This method return the extension on a file.
     */
    public String getExtensionFile() {
        return this.getExtensionFile();
    }

    public int getCantFiles(){
        return  this.getCantFiles();
    }
}
