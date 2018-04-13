/*
 * @(#)FileResult.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and propietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.model;

import java.nio.file.attribute.FileTime;

/**
 * This class is to return file attributes.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class FileResult {
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

    private FileTime date;
    /**
     * FileResult constructor.
     *
     * @param pathFile     path .
     * @param nameFile     name file.
     * @param sizeFile     lenght file.
     * @param isHiddenFile state hidden file..
     */

    public FileResult(String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime date) {
        this.pathFile = pathFile;
        this.nameFile = nameFile;
        this.sizeFile = sizeFile;
        this.isHiddenFile = isHiddenFile;
        this.date = date;
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

    public FileTime getDate() {
        return date;
    }
}
