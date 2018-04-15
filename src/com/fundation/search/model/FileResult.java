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
 * @author Ariel Gonzales Vargas - AT-[06].
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

    private FileTime lastModifiedTime;

    private FileTime creationTime;

    private FileTime lastAccessTime;

    private boolean isReadOnly;

    private boolean isFileSystem;

    private boolean isDirectory;

    private String ownerFile;

    private String intoFile;

    private String extensionFile;

    /**
     * FileResult constructor.
     *
     * @param pathFile     path .
     * @param nameFile     name file.
     * @param sizeFile     lenght file.
     * @param isHiddenFile state hidden file.
     */

    public FileResult() {
    }

    public FileResult extensionFile(String extensionFile) {
        this.extensionFile = extensionFile;
        return this;
    }

    public FileResult owner(String owner) {
        this.ownerFile = owner;
        return this;
    }

    public FileResult intoFile(String intoFile) {
        this.intoFile = intoFile;
        return this;
    }

    public FileResult pathFile(String pathFile) {
        this.pathFile = pathFile;
        return this;
    }

    public FileResult nameFile(String nameFile) {
        this.nameFile = nameFile;
        return this;
    }

    public FileResult sizeFile(long sizeFile) {
        this.sizeFile = sizeFile;
        return this;
    }

    public FileResult isHiddenFile(boolean isHiddenFile) {
        this.isHiddenFile = isHiddenFile;
        return this;
    }


    public FileResult lastModifiedTime(FileTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
        return this;
    }

    public FileResult creationTime(FileTime creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public FileResult lastAccessTime(FileTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
        return this;
    }

    public FileResult isReadOnlyFile(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
        return this;
    }

    public FileResult isFileSystemFile(boolean isFileSystem) {
        this.isFileSystem = isFileSystem;
        return this;
    }

    public FileResult isDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
        return this;
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

    public FileTime getCreationTime() {
        return creationTime;
    }

    public FileTime getLastAccessTime() {
        return lastAccessTime;
    }

    public FileTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public boolean getIsReadOnlyFile() {
        return isReadOnly;
    }

    public boolean getIsFileSystemFile() {
        return isFileSystem;
    }

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public String getIntoFile() {
        return intoFile;
    }

    public String getOwnerFile() {
        return ownerFile;
    }

    public String getExtensionFile() {
        return extensionFile;
    }
}