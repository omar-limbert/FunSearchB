package com.fundation.search.controller;


/*
 * @(#)FileClassTest.java
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
 * This class convert any size to bytes.
 *
 * @author Ariel Gonzales Vargas  - AT-[06].
 * @version 1.0.
 */

public class Convertor {

    public Convertor() {
    }

    public long convertGbToMb(double tam) {
        return Math.round(tam * 1024.0);
    }

    public long convertMbToKb(double tam) {
        return Math.round(tam * 1024.0);
    }

    public long convertKbToB(double tam) {
        return Math.round(tam * 1024.0);
    }
}