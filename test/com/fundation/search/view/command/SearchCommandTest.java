/*
 * @(#)SearchCommandTest.java
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
package com.fundation.search.view.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * This class is to test validate command format .
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class SearchCommandTest {
    /**
     * search is a SearchCommand object.
     */
    private SearchCommand search;
    /**
     * search2 is a SearchCommand object.
     */
    private SearchCommand search2;
    /**
     * search3 is a SearchCommand object.
     */
    private SearchCommand search3;
    /**
     * search4 is a SearchCommand object.
     */
    private SearchCommand search4;
    /**
     * COMMAND_LIST1 to initialize search.
     */
    private static final String[] COMMAND_LIST = {"-s", "F:\\1", "-f", "escar", "-cf", "", "-dc", "05/06/2018"};
    /**
     * COMMAND_LIST2 to initialize search1.
     */
    private static final String[] COMMAND_LIST2 = {"-c", "F:\\1", "-c", "-f"};
    /**
     * COMMAND_LIST3 to initialize search2.
     */
    private static final String[] COMMAND_LIST3 = {"aaaa", "F:\\1"};
    /**
     * COMMAND_LIST4 to initialize search3.
     */
    private static final String[] COMMAND_LIST4 = {"-f", "F:\\1", "-p", "f", "-f", "floa", "-p",};

    /**
     * initialize File Class.
     */
    @Before
    public void initialize() {

        search = new SearchCommand(COMMAND_LIST);
        search2 = new SearchCommand(COMMAND_LIST2);
        search3 = new SearchCommand(COMMAND_LIST3);
        search4 = new SearchCommand(COMMAND_LIST4);


    }

    /**
     * testToValidateCommandFormatTrue.
     */
    @Test
    public void testToValidateCommandFormatTrue() {
        assertTrue(search.validateCommandCriteria());
    }


    /**
     * testCriteriaValidatorDuplicatedTrue.
     */
    @Test
    public void testAddCriteriaWithoutDuplicatedTrue() {
        assertTrue(search.addCriteriaWithoutDuplicated());
    }

    /**
     * testToValidateCommandFormatFalse.
     */
    @Test
    public void testToValidateCommandFormatFalse2() {
        assertFalse(search2.validateCommandCriteria());
    }

    /**
     * testCriteriaValidatorDuplicatedFalse.
     */
    @Test
    public void testAddCriteriaWithoutDuplicatedFalse2() {
        assertFalse(search2.addCriteriaWithoutDuplicated());
    }

    /**
     * testToValidateCommandFormatFalse.
     */
    @Test
    public void testToValidateCommandFormatFalse3() {
        assertFalse(search3.validateCommandCriteria());
    }

    /**
     * testCriteriaValidatorDuplicatedTrue.
     */
    @Test
    public void testAddCriteriaWithoutDuplicatedTrue3() {
        assertTrue(search3.addCriteriaWithoutDuplicated());
    }

    /**
     * testToValidateCommandFormatTrue.
     */
    @Test
    public void testToValidateCommandFormatTrue4() {
        assertTrue(search4.validateCommandCriteria());
    }

    /**
     * testCriteriaValidatorDuplicatedFalse.
     */
    @Test
    public void testAddCriteriaWithoutDuplicatedFalse4() {
        assertFalse(search4.addCriteriaWithoutDuplicated());
    }
}