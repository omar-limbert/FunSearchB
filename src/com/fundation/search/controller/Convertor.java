package com.fundation.search.controller;

/*
 * @(#)Convertor.java
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
 * This class made the conversion from size to bytes.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class Convertor {

    /**
     * This class convert.
     * Gb to Mb.
     * Mb to Kb.
     * Kb to B.
     *
     * @author Ariel Gonzales Vargas - AT-[06]..
     * @version 1.0.
     */
    public Convertor() {
    }

    /**
     * This method convert Gb to Mb
     *
     * @param tam a deciaml number (Gb).
     * @return the number on Mb
     */
    public double convertGbToMb(double tam) {
        return tam * 1024.0;
    }

    /**
     * This method convert Mb to Kb
     *
     * @param tam a deciaml number (Mb).
     * @return the number on Kb
     */
    public double convertMbToKb(double tam) {
        return tam * 1024.0;
    }

    /**
     * This method convert Kb to B
     *
     * @param tam a deciaml number (Kb).
     * @return the number on B
     */
    public double convertKbToB(double tam) {
        return tam * 1024.0;
    }
}
