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
public class FolderResult extends Asset{
    private int filesQuantity;

    public FolderResult (String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, String ownerFile, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, int filesQuantity){
        super( pathFile,  nameFile,  sizeFile,  isHiddenFile,  lastModifiedTime,  creationTime,  lastAccessTime,  ownerFile,  isReadOnly,  isFileSystem,  isDirectory );

        this.filesQuantity= filesQuantity;
    }
    public int getFilesQuantity() {
        return filesQuantity;
    }
}
