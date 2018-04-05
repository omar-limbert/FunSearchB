/*
 * @(#)Search.java
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
package com.fundation.search.model;

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
    /**
     * criteria  is a SearchCriteria object that receive criterias to find files
     */
    private SearchCriteria criteria;
    /**
     * fileList is a file list that save files according to criterias
     */
    private List<File> fileList;

    /**
     * Search Class constructor.
     */
    public Search() {
        fileList = new ArrayList<>();
    }

    /**
     * @param path .
     * @return list all the files contained within the path.
     */
    private List<File> searchByPath(String path) {
        try {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                }
            }
        } catch (NullPointerException e) {
        }
        return fileList;
    }

    /**
     * Modified by Omar, I improve performance for result search.
     * @param listFile .
     * @param nameFile .
     * @return list all the files that contains the name of a file.
     */
    private List<File> searchByName(List<File> listFile, String nameFile) {
        listFile.removeIf(e -> (!e.getName().contains(nameFile)));
        return listFile;
    }

    /**
     * @param listFile file list.
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     * @return list all the files minor or major or equal to given size.
     */
    private List<File> searchBySize(List<File> listFile, double size, char operator) {

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

    /**
     * Modified by Omar, I improve performance for result search.
     * @param listFile list file.
     * @param hiddenCriteria this param has 3 values, all files, only hiddens, without hiddens.
     * @return list all the files minor or major or equal to given size.
     */

    private List<File> searchHiddenFiles(List<File> listFile, String hiddenCriteria) {

        if(hiddenCriteria.equalsIgnoreCase("only hidden")){
            listFile.removeIf(e -> (!e.isHidden()));
        }
        if(hiddenCriteria.equalsIgnoreCase("without hidden")){
            listFile.removeIf(e -> (e.isHidden()));
        }


        return listFile;
    }

    /**
     * Modified by Omar, I added IF's for hidden files.
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    private void filterByCriteria(SearchCriteria criteria) {
        if (criteria.getPath() != null) {
            fileList = searchByPath(criteria.getPath());
            if (criteria.getName() != null) {
                fileList = searchByName(fileList, criteria.getName());
            }
            if (criteria.getSize() > -1) {
                fileList = searchBySize(fileList, criteria.getSize(), criteria.getOperator());
            }
            if (criteria.getHiddenCriteria().equalsIgnoreCase("all files")) {
                fileList = searchHiddenFiles(fileList, "all files");
            }
            if (criteria.getHiddenCriteria().equalsIgnoreCase("only hidden")) {
                fileList = searchHiddenFiles(fileList, "only hidden");
            }
            if (criteria.getHiddenCriteria().equalsIgnoreCase("without hidden")) {
                fileList = searchHiddenFiles(fileList, "without hidden");
            }
        }
    }

    /**
     * @param criteria This method receives a criteria.
     */
    public void setSearchCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    /**
     * This method initialize the criteria filtering.
     */
    public void initSearch() {
        filterByCriteria(criteria);
    }

    /**
     * Is the list(FileResult) result of a search by criterias.
     *@return File Result list with the files already searched
     */
    public List<FileResult> getResultList() {
        List<FileResult> result = new ArrayList<>();
        if (!fileList.isEmpty()) {
            for (File file : fileList) {
                result.add(new FileResult(file.getPath(), file.getName(), file.length(), file.isHidden()));
            }
        }
        return result;
    }
}
