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
 */package com.fundation.search.view.command;

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
     * COMMAND_LIST to initialize searchCommand.
     */
    private static final String[] COMMAND_LIST = {"-p", "F:\\1"};

    /**
     * initialize File Class.
     */
    @Before
    public void initialize() {
        search = new SearchCommand(COMMAND_LIST);
    }

    /**
     * testToValidateCommandFormatTrue.
     */
    @Test
    public void testToValidateCommandFormatTrue() {
        String[] list = {"-p", "F:\\1"};
        assertTrue(search.validateCommandFormat(list));
    }

    /**
     * testToValidateCommandFormatFalse.
     */
    @Test
    public void testToValidateCommandFormatFalse() {
        String[] list = {"-x", "F:\\1"};
        assertFalse(search.validateCommandFormat(list));
    }

    /**
     * testCriteriaValidatorDuplicatedTrue.
     */
    @Test
    public void testCriteriaValidatorDuplicatedTrue() {
        String[] list = {"-p", "F:\\1", "-f", "file"};
        assertTrue(search.criteriaValidatorDuplicated(list));
    }

    /**
     * testCriteriaValidatorDuplicatedFalse.
     */
    @Test
    public void testCriteriaValidatorDuplicatedFalse() {
        String[] list = {"-p", "F:\\1", "-p", "file"};
        assertFalse(search.criteriaValidatorDuplicated(list));
    }
}