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

import com.fundation.search.controller.SearchCriteria;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is to search files by criterias.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class Search {
    private SearchCriteria criteria;
    private List<File> fileList;


    /**
     * Search Class.
     */
    public Search() {
        fileList = new ArrayList<>();
    }

    public List<FileClass> getResultList() {
        List<FileClass> result = new ArrayList<>();
        for (File file : fileList) {
            result.add(new FileClass(file.getPath(), file.getName(), file.length(), file.isHidden()));
        }
        return result;
    }

    public List<File> searchByPath(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            fileList.add(file);
            if (file.isDirectory()) {
                searchByPath(file.getPath());
            }
        }
        return fileList;
    }


    /**
     * @param nameFile is the namefile.
     * @return list all the files that contains the name of a file.
     */
    public List<File> searchByName(List<File> listFile, String nameFile) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (!file.getName().contains(nameFile)) {
                listFilter.add(file);
            }
        }
        listFile.removeAll(listFilter);
        return listFile;
    }

    /**
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     * @return list all the files that contains the name of a file.
     */
    public List<File> searchBySize(List<File> listFile, double size, char operator) {

        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (operator == '=') {
                if (file.length() != size) {
                    listFilter.add(file);
                }
            }
            if (operator == '>') {
                if (file.length() < size) {
                    listFilter.add(file);
                }
            }
            if (operator == '<') {
                if (file.length() > size) {

                    listFilter.add(file);
                }
            }
        }
        listFile.removeAll(listFilter);
        return listFile;
    }
    /*
     * @param
     * @return list all the content given a path.
     */

    public List<File> searchHiddenFiles(List<File> listFile, boolean isHidden) {
        List<File> listFilter = new ArrayList<>();
        if (!isHidden) {
            for (File file : listFile) {
                if (file.isHidden()) {
                    listFilter.add(file);
                }
            }
        }
        listFile.removeAll(listFilter);
        return listFile;
    }
    /** public void setSearchCriteria(SearchCriteria criteria) {
     this.criteria = criteria;
     }

     public void init() {
     fileList = new ArrayList<>();
     filter(criteria);
     }

     private void filter(SearchCriteria criteria) {
     if (criteria.getPath() != null) {
     fileList = searchByPath(criteria.getPath());
     if (criteria.getName() != null) {
     fileList = searchByName(fileList, criteria.getName());
     }
     if (criteria.getSize() > 0) {
     fileList = searchBySize(fileList, criteria.getSize(), criteria.getOperator());
     }
     if (criteria.getIsHidden()) {
     fileList = searchHiddenFiles(fileList, criteria.getIsHidden());
     }
     }
     }
     **/

}
