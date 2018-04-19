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

/**
 * This class Asset can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0..
 */
import java.nio.file.attribute.FileTime;

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

    private FileTime lastModifiedTime;

    private FileTime creationTime;

    private FileTime lastAccessTime;

    private boolean isReadOnly;

    private boolean isFileSystem;

    // private boolean isDirectory;

    //private String ownerFile;

    //private String intoFile;

    private String extensionFile;

    public Asset(String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, boolean isReadOnly, boolean isFileSystem, String extensionFile) {
        this.pathFile = pathFile;
        this.nameFile = nameFile;
        this.sizeFile = sizeFile;
        this.isHiddenFile = isHiddenFile;
        this.lastModifiedTime = lastModifiedTime;
        this.creationTime = creationTime;
        this.lastAccessTime = lastAccessTime;
        this.isReadOnly = isReadOnly;
        this.isFileSystem = isFileSystem;
        this.extensionFile = extensionFile;

    }

    public String getExtensionFile() {
        return extensionFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public long getSizeFile() {
        return sizeFile;
    }

    public FileTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public FileTime getLastAccessTime() {
        return lastAccessTime;
    }

    public FileTime getCreationTime() {
        return creationTime;
    }

    public boolean isFileSystem() {
        return isFileSystem;
    }

    public boolean isHiddenFile() {
        return isHiddenFile;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }
}
