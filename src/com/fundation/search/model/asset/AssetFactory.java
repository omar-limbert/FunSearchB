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
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class AssetFactory {

    // constructor for FileResult
    public Asset getAsset( String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime lastAccessTime, FileTime creationTime, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String ownerFile, String extensionFile, String textSample) {
        return new FileResult(pathFile, nameFile, sizeFile, isHiddenFile, lastModifiedTime, creationTime, lastAccessTime, ownerFile, isReadOnly, isFileSystem, isDirectory, extensionFile,textSample);
    }

    // constructor for FolderResult0
    public Asset getAsset( String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime lastAccessTime, FileTime creationTime, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String ownerFile, int filesQuantity) {
        return new FolderResult(pathFile, nameFile, sizeFile, isHiddenFile, lastModifiedTime, creationTime, lastAccessTime, ownerFile, isReadOnly, isFileSystem, isDirectory, filesQuantity);
    }

    // constructor for MultimediaResult
    public Asset getAsset( String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime lastAccessTime, FileTime creationTime, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String ownerFile, double duration, String extensionFile) {
        return new MultimediaResult(pathFile, nameFile, sizeFile, isHiddenFile, lastModifiedTime, creationTime, lastAccessTime, ownerFile, isReadOnly, isFileSystem, isDirectory, duration, extensionFile);
    }

}