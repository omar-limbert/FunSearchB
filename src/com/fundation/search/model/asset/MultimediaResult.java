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
 * @version 1.0.
 */
import java.nio.file.attribute.FileTime;

public class MultimediaResult extends Asset {

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

    private boolean isDirectory;

    private String ownerFile;

    private String intoFile;

    private String extensionFile;

    public MultimediaResult (String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, boolean isReadOnly, boolean isFileSystem, String extensionFile){
        super(pathFile,nameFile,sizeFile,isHiddenFile,lastModifiedTime,creationTime,lastAccessTime,isReadOnly,isFileSystem,extensionFile);
    }
}
