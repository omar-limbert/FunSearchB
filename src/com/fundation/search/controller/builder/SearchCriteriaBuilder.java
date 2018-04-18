package com.fundation.search.controller.builder;

import java.nio.file.attribute.FileTime;

public class SearchCriteriaBuilder {

    /**
     * path is the direcction Path.
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
     * operator is the instruccion (> ; < ; =).
     */
    private String operator;
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
     * isRead, true if is readable file and false if isn't readable file
     */
    private boolean isReadOnly;
    private boolean isDirectory;
    private boolean isFileSystem;
    private String extension;


    public SearchCriteriaBuilder(){

    }
    public SearchCriteria build() {
        return new SearchCriteria(this);
    }
    public SearchCriteriaBuilder pathCriteria(String path){
       // this.path = (path != "") ? path : null;
        this.path = path;
        return this;
    }
    public SearchCriteriaBuilder fileName(String name){
        //this.name = (name != "") ? fileName : null;
        this.name = name;
        return this;
    }
    public SearchCriteriaBuilder hiddenCriteria(String hiddenCriteria){
        this.hiddenCriteria = hiddenCriteria;
        return this;
    }
    public SearchCriteriaBuilder sizeCriteria(String operator, Long size, String type){
        System.out.println(operator+" "+size+" "+type);
        if(operator != null || size != null) {

            // Converting operator to valid format for Model
            if (operator.equalsIgnoreCase("Minor to:")) {
                this.operator = "lower";
            }
            if (operator.equalsIgnoreCase("major to:")) { // Little change on UI to "Major"
                this.operator = "upper";
            }
            if (operator.equalsIgnoreCase("Equals")) {
                this.operator = "equal";
            }
            this.type = type;
            this.size = size;
        }
        else{
            this.operator = "upper";
            this.type = type;
            this.size = 0;
        }

        return this;
    }
    public SearchCriteriaBuilder fileNameCriteria(String fileNameCriteria){
        this.fileNameCriteria = fileNameCriteria;
        return this;
    }
    public SearchCriteriaBuilder ownerCriteria(String ownerCriteria){
        this.ownerCriteria = ownerCriteria;
        return this;
    }
    public SearchCriteriaBuilder modifiedDateCriteria(FileTime modifiedDateInit, FileTime modifiedDateEnd){
        this.modifiedDateInit = modifiedDateInit;
        this.modifiedDateEnd = modifiedDateEnd;
        return this;
    }
    public SearchCriteriaBuilder creationDateCriteria(FileTime creationDateInit, FileTime creationDateEnd){
        this.creationDateInit = creationDateInit;
        this.creationDateEnd = creationDateEnd;
        return this;
    }
    public SearchCriteriaBuilder lastAccessDateCriteria(FileTime lastAccessDateInit, FileTime lastAccessDateEnd){
        this.lastAccessDateInit = lastAccessDateInit;
        this.lastAccessDateEnd = lastAccessDateEnd;
        return this;
    }
    public SearchCriteriaBuilder isReadCriteria(boolean isReadOnly){
        this.isReadOnly = isReadOnly;
        return this;
    }
    public SearchCriteriaBuilder isDirectoryCriteria(boolean isDirectory){
        this.isDirectory = isDirectory;
        return this;
    }
    public SearchCriteriaBuilder isFileSystemCriteris(boolean isFileSystem){
        this.isFileSystem = isFileSystem;
        return this;
    }
    public SearchCriteriaBuilder extensionCriteria(String extension){
        this.extension = extension;
        return this;
    }



    public String getPathCriteria() {
        return path;
    }

    public String getFileName() {
        return name;
    }

    public String getHiddenCriteria() {
        return hiddenCriteria;
    }

    public long getSizeCriteria() {
        return size;
    }

    public String getgetOperator() {
        return operator;
    }

    public String getType() {
        return type;
    }

    public String getFileNameCriteria() {
        return fileNameCriteria;
    }

    public String getOwnerCriteria() {
        return ownerCriteria;
    }

    public FileTime getModifiedDateInit() {
        return modifiedDateInit;
    }

    public FileTime getModifiedDateEnd() {
        return modifiedDateEnd;
    }

    public FileTime getCreationDateInit() {
        return creationDateInit;
    }

    public FileTime getCreationDateEnd() {
        return creationDateEnd;
    }

    public FileTime getLastAccessDateInit() {
        return lastAccessDateInit;
    }

    public FileTime getLastAccessDateEnd() {
        return lastAccessDateEnd;
    }

    public boolean getIsReadCriteria() {
        return isReadOnly;
    }

    public boolean getIsDirectoryCriteria() {
        return isDirectory;
    }

    public boolean getIsFileSystemCriteris() {
        return isFileSystem;
    }

    public String getExtensionCriteria() {
        return extension;
    }
}
