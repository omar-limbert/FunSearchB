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
public class Utils {

    public static String toStringOrNull(Object o) {
        return o != null ? o.toString() : null;
    }

    public static int safeLength(String s) {
        return s != null ? s.length() : 0;
    }

    public static String padLeft(String txt, char compchar, int length) {
        String out = null;
        if (txt != null) {
            out = txt;
            while (out.length() < length) {
                out = compchar + out;
            }
        }
        return out;
    }

    public static String padRight(String txt, char compchar, int length) {
        String out = null;
        if (txt != null) {
            out = txt;
            while (out.length() < length) {
                out = out + compchar;
            }
        }
        return out;
    }

    public static String padCenter(String txt, char compchar, int length) {
        String out = null;
        if (txt != null) {
            out = txt;
            boolean flip = true;
            while (out.length() < length) {
                if (flip) {
                    out = out + compchar;
                } else {
                    out = compchar + out;
                }
                flip = !flip;
            }
        }
        return out;
    }

    public static String toUpperCaseFirstChar(String s) {
        if (s != null && s.length() > 0) {
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        } else {
            return s;
        }
    }
}
