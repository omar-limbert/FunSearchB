package com.fundation.search.model;

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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is to search files by criterias.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class FileClass {
    private String path;
    private List<File> fileList;

    /**
     * @param path Constructor for FileClass.
     */
    public FileClass(String path) {
        this.path = path;
        fileList = new ArrayList<>();
    }

    /**
     * @param
     * @return list all the content given a path.
     */

    public List<File> searchByPath() {
        File[] files = new File(path).listFiles();
        try {
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory()) {
                    path = file.getPath();
                    searchByPath();
                }
            }
        } catch (NullPointerException e) {
        }
        return fileList;
    }

    /**
     * @param nameFile is the namefile.
     * @return list all the files that contains the name of a file.
     */
    public List<File> searchByName(String nameFile) {
        List<File> files = new ArrayList<>();
        for (File file : searchByPath()) {
            if (file.getName().contains(nameFile)) {
                files.add(file);
            }
        }
        return files;
    }
}
