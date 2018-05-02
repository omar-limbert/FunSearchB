/*
 * @(#)CommandViewTest.java
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

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test CommandViewTest.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class CommandViewTest {
    /**
     * command is the object of the class CommandView.
     * for check the tests
     */
    private CommandView command;
    /**
     * This is separator for manage paths.
     */

    private static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * Init the object command.
     */
    @Before
    public void init() {
        command = new CommandView();
    }

    /**
     * this method check the cut a large name.
     */
    @Test
    public void testCutName() {
        assertEquals("It is clear to us that to build the f...", command.cutName("It is clear to us that to build the future we must invest today.txt"));
        assertEquals("It is clear.txt", command.cutName("It is clear.txt"));
    }

    /**
     * this method check cut a long owner.
     */
    @Test
    public void testCutOwner() {
        assertEquals("fundacion jala - jalasoft 2...", command.cutOwner("fundacion jala - jalasoft 2018"));
        assertEquals("fundacion jala", command.cutOwner("fundacion jala"));
    }

    /**
     * this method check cut long path.
     */
    @Test
    public void testCutPath() throws IOException {
        String path = new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation";
        String path2 = new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "search1111";
        String pathResult = new File(".").getCanonicalPath() + SEPARATOR + "test"
                + SEPARATOR + "com" + SEPARATOR + "fundation" + SEPARATOR + "sear...";
        assertEquals(path, command.cutPath(path));
        assertEquals(pathResult, command.cutPath(path2));
    }
}
