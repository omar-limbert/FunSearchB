/*
 * @(#)CommandCriteriaTest.java
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test validate getters of CommandCriteria .
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class CommandCriteriaTest {
    /**
     * commandCriteria is a CommandCriteria object.
     */
    private CommandCriteria commandCriteria;
    /**
     * criteriasMap is a filled map.
     */
    Map<String, String> criteriasMap;

    /**
     * initialize map and object.
     */
    @Before
    public void initialize() {
        criteriasMap = new HashMap<>();
        criteriasMap.put("-p", "test\\com\\fundation\\search\\model\\filesTest\\test1");
        criteriasMap.put("-f", "hola ");
        criteriasMap.put("-h", "only hidden ");
        criteriasMap.put("-o", "Escarleth Ledezma");
        criteriasMap.put("-cf", "start with");
        criteriasMap.put("-dc", "25/09/2018 ");
        criteriasMap.put("-dm", "15/09/2018");
        criteriasMap.put("-ro", "false");
        criteriasMap.put("-d", " true ");
        criteriasMap.put("-ex", ".txt");
        commandCriteria = new CommandCriteria(criteriasMap);
    }

    /**
     * testToValidateGetPath.
     */
    @Test
    public void testToValidateGetPath() {
        assertEquals("test\\com\\fundation\\search\\model\\filesTest\\test1", commandCriteria.getPath());
    }

    /**
     * testToValidateGetFile.
     */
    @Test
    public void testToValidateGetFile() {
        assertEquals("hola", commandCriteria.getFileName());
    }

    /**
     * testToValidateGetHidden.
     */
    @Test
    public void testToValidateGetHidden() {
        assertEquals("only hidden", commandCriteria.getIsHidden());
    }

    /**
     * testToValidateGetOwner.
     */
    @Test
    public void testToValidateGetOwner() {
        assertEquals("Escarleth Ledezma", commandCriteria.getOwner());
    }

    /**
     * testToValidateGetCriteriaFileName.
     */
    @Test
    public void testToValidateGetCriteriaFileName() {
        assertEquals("start with", commandCriteria.getCriteriaName());
    }

    /**
     * testToValidateGetSize.
     */
    @Test
    public void testToValidateGetSize() {
        assertEquals("", commandCriteria.getSize());
    }

    /**
     * testToValidateGetDateCreation.
     */
    @Test
    public void testToValidateGetDateCreation() {
        assertEquals("25/09/2018", commandCriteria.getDateCreation());
    }

    /**
     * testToValidateGetDateLastAccess.
     */
    @Test
    public void testToValidateGetDateLastAccess() {
        assertEquals("", commandCriteria.getDateLastAccess());
    }

    /**
     * testToValidateGetDateModified.
     */
    @Test
    public void testToValidateGetDateModified() {
        assertEquals("15/09/2018", commandCriteria.getDateModified());
    }

    /**
     * testToValidateGetReadOnly.
     */
    @Test
    public void testToValidateGetReadOnly() {
        assertEquals("false", commandCriteria.getReadOnly());
    }

    /**
     * testToValidateGetIsDirectory.
     */
    @Test
    public void testToValidateGetIsDirectory() {
        assertEquals("true", commandCriteria.getIsDirectory());
    }

    /**
     * testToValidateGetExtension.
     */
    @Test
    public void testToValidateGetExtension() {
        assertEquals(".txt", commandCriteria.getExtension());
    }

}
