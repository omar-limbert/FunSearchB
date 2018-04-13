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

package com.fundation.search.controller;

import java.nio.file.attribute.FileTime;

/**
 * This class save the SearchCriterial..
 * Before to send the Search Class.
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */

public class SearchCriteria {

    /**
     * path is the direcction Path.
     */
    private String path;
    /**
     * name is the file name.
     */
    private String name;
    /**
     * type is the file extension.
     */
    private String type;
    /**
     * isHidden is a string instrucction.
     */
    private String HiddenCriteria;
    /**
     * size is the file size.
     */
    private long size;
    /**
     * operator is the instruccion (> ; < ; =).
     */
    private char operator;
    /**
     * modificated by Christian,I added String fileNameCriteria.
     * name is the file name criteria.
     */
    private  String fileNameCriteria;


    private FileTime dateConditionInt;
    private FileTime dateConditionEnd;

    /**
     * modificated by Christian,I added String HiddenCriteria, String fileNameCriteria.
     * This method init the Search Criterial.
     *  @param path     a direction Path.
     * @param name     a file name.
     * @param type     a file extension.
     * @param size     a file size.
     * @param operator the instruction of the operator.
     * @param HiddenCriteria the hidden.
     * @param fileNameCriteria the Name criteria.
     */
    public SearchCriteria(String path, String name, String type, long size, char operator, String HiddenCriteria, String fileNameCriteria,FileTime dateConditionInt, FileTime dateConditionEnd) {
        this.path = (path != "") ? path : null;
        this.name = (name != "") ? name : null;
        this.type = (type != "") ? type : null;
        this.size = size;
        this.operator = operator;
        this.HiddenCriteria = HiddenCriteria;
        this.fileNameCriteria = fileNameCriteria;
        this.dateConditionEnd = dateConditionEnd;
        this.dateConditionInt = dateConditionInt;

    }

    /**
     * @return the name of the file name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the name of the directory path.
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the name of the file size.
     */
    public long getSize() {
        return size;
    }

    /**
     * @return the instruction of the operator.
     */
    public char getOperator() {
        return operator;
    }

    /**
     * @return the name of the file extension.
     */
    public String getType() {
        return type;
    }

    /**
     * @return the name the file hidden.
     */
    public String getHiddenCriteria() {
        return HiddenCriteria ;
    }

    /**
     *modificated by Christian,I added getFileNameCriteria.
     * @return the name the name criteria.
     */
    public  String getFileNameCriteria(){
        return fileNameCriteria;
    }

    public FileTime getDateConditionEnd() {
        return dateConditionEnd;
    }

    public FileTime getDateConditionInt() {
        return dateConditionInt;
    }
}
