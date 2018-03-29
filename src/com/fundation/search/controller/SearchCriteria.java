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


    public SearchCriteria(String path, String name, String type, long size, char operator, boolean isHidden) {
        this.path = (path != "") ? path : "";
        this.name = (name != "") ? name : "";
        this.type = (type != "") ? type : "";
        this.size = size;
        this.operator = operator;
        this.isHidden = isHidden;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public char getOperator() {
        return operator;
    }

    public String getType() {
        return type;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

}
