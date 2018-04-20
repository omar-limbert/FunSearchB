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
package com.fundation.search.common.table;

/**
 * This class is make SearchCriteria with Builder Pattern.
 *
 * @author Omar Limbert Huanca sanchez - AT-[06]
 * @version 1.0.
 */
public class DefaultConsoleCellRenderer implements ConsoleCellRenderer<Object> {

    public static final String EMPTY = "";
    public final static DefaultConsoleCellRenderer instance = new DefaultConsoleCellRenderer();


    private final String ifNull;

    public DefaultConsoleCellRenderer() {
        this(EMPTY);
    }

    public DefaultConsoleCellRenderer(String ifNull) {
        this.ifNull = ifNull;
    }

    @Override
    public String render(Object value, int row, int column) {
        return value != null ? value.toString() : ifNull;
    }
}
