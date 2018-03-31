package com.fundation.search.controller;
/*
 * @(#)FileClass.java
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

/**
 * This class save the SearchCriterial.
 * Before to send the Search Class.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */

public class SearchCriteria {

    private String path;
    private String name;
    private String type;
    private boolean isHidden;
    private long size;
    private char operator;


    /**
     * This method init the Search Criterial.
     *
     * @param path     a direction Path.
     * @param name     a file name.
     * @param type     a file extension.
     * @param size     a file size.
     * @param operator the instruction of the operator.
     * @param isHidden the hidden.
     */
    public SearchCriteria(String path, String name, String type, long size, char operator, boolean isHidden) {
        this.path = (path != "") ? path : "";
        this.name = (name != "") ? name : "";
        this.type = (type != "") ? type : "";
        this.size = size;
        this.operator = operator;
        this.isHidden = isHidden;
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
    public boolean getIsHidden() {
        return isHidden;
    }

}
