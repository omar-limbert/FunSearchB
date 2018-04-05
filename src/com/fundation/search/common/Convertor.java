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

package com.fundation.search.common;

/**
 * This class made the conversion from size to bytes.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class Convertor {

    /**
     * This class convert.
     * Gb (Gigabytes) to Mb(Megabytes).
     * Mb (Megabytes) to Kb (Kilobytes).
     * Kb (Kilobytes) to B (Bytes).
     */
    public Convertor() {
    }

    /**
     * This method convert Gb to Mb
     *
     * @param tam a decimal number (Gb).
     * @return the a number(a conversion from Gb to Mb) on Mb
     */
    public double convertGbToMb(double tam) {
        return tam * 1024.0;
    }

    /**
     * This method convert Mb to Kb
     *
     * @param tam a decimal number (Mb).
     * @return the a number(a conversion from Mb to Kb) on Kb
     */
    public double convertMbToKb(double tam) {
        return tam * 1024.0;
    }

    /**
     * This method convert Kb to B
     *
     * @param tam a decimal number (Kb).
     * @return the a number (a conversion from Kb to B) on B
     */
    public double convertKbToB(double tam) {
        return tam * 1024.0;
    }
}
