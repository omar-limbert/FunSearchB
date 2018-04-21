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

import com.fundation.search.controller.builder.SearchCriteria;
import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.AssetFactory;
import com.fundation.search.model.asset.FileResult;
import com.fundation.search.model.database.SearchQuery;
import com.google.gson.Gson;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * This class is to search files by criteria.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class Search {
    /**
     * criteria  is a SearchCriteria object that receive criteria to find files.
     */
    private SearchCriteria criteria;
    /**
     * fileList is a file list that save files according to criteria.
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
     * NOTE: You need improve 'e.getName()' for get only file name without extension.
     *
     * @param listFile .
     * @param nameFile .
     * @return list all the files that contains the name of a file.
     */
    private List<File> searchByName(List<File> listFile, String nameFile, String fileNameCriteria) {

        if (fileNameCriteria.equalsIgnoreCase("all words")) {
            listFile.removeIf(e -> (!e.getName().contains(nameFile)));
        }
        if (fileNameCriteria.equalsIgnoreCase("start with")) {
            listFile.removeIf(e -> (!e.getName().startsWith(nameFile)));
        }
        if (fileNameCriteria.equalsIgnoreCase("end with")) {
            listFile.removeIf(e -> (!e.getName().endsWith(nameFile)));
        }
        if (fileNameCriteria.equalsIgnoreCase("equal to")) {
            listFile.removeIf(e -> (!e.getName().equals(nameFile)));
        }
        return listFile;
    }

    /**
     * @param listFile file list.
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     * @return list all the files minor or major or equal to given size.
     */
    private List<File> searchBySize(List<File> listFile, long size, String operator) {

        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);

                if (operator.equalsIgnoreCase("upper")) {
                    if (fileAttributes.size() > size) {
                        listFilter.add(file);
                    }
                }

                if (operator.equalsIgnoreCase("lower")) {
                    if (fileAttributes.size() < size) {
                        listFilter.add(file);
                    }
                }

                if (operator.equalsIgnoreCase("equal")) {
                    if (fileAttributes.size() == size) {
                        listFilter.add(file);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return listFilter;
    }

    /**
     * This method is for search Hidden Files.
     *
     * @param listFile       list file.
     * @param hiddenCriteria this param has 3 values, all files, only hiddens, without hiddens.
     * @return list all the files minor or major or equal to given size.
     */

    private List<File> searchHiddenFiles(List<File> listFile, String hiddenCriteria) {

        if (hiddenCriteria.equalsIgnoreCase("only hidden")) {
            listFile.removeIf(e -> (!e.isHidden()));
        }
        if (hiddenCriteria.equalsIgnoreCase("without hidden")) {
            listFile.removeIf(e -> (e.isHidden()));
        }

        return listFile;
    }

    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for lastModifiedTime time on a file.
     * @param dateConditionEnd Is the end date for lastModifiedTime time on a file.
     * @return a list of files that are on range between init date and end date.
     */
    private List<File> lastModifiedTime(List<File> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                if ((fileAttributes.lastModifiedTime().toMillis() >= dateConditionInt.toMillis() && fileAttributes.lastModifiedTime().toMillis() <= dateConditionEnd.toMillis())) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listFilter;
    }

    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for creationTime time on a file.
     * @param dateConditionEnd Is the end date for creationTime time on a file.
     * @return a list of files that are on range creationTime init date and end date.
     */
    private List<File> creationTime(List<File> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {

        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                if ((fileAttributes.creationTime().toMillis() >= dateConditionInt.toMillis() && fileAttributes.creationTime().toMillis() <= dateConditionEnd.toMillis())) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listFilter;
    }


    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for lastAccessTime time on a file.
     * @param dateConditionEnd Is the end date for lastAccessTime time on a file.
     * @return a list of files that are on range lastAccessTime init date and end date.
     */
    private List<File> lastAccessTime(List<File> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                if ((fileAttributes.creationTime().toMillis() >= dateConditionInt.toMillis() && fileAttributes.creationTime().toMillis() <= dateConditionEnd.toMillis())) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are ReadOnly.
     */
    private List<File> isReadOnly(List<File> listFile) {

        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                if (Files.readAttributes(file.toPath(), DosFileAttributes.class).isReadOnly()) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are on System.
     */
    private List<File> isFileSystem(List<File> listFile) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                if (Files.readAttributes(file.toPath(), DosFileAttributes.class).isSystem()) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are a Directories (Folders).
     */
    private List<File> searchByDirectory(List<File> listFile) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                if (Files.readAttributes(file.toPath(), BasicFileAttributes.class).isDirectory()) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listFilter;
    }

    /**
     * @param listFile  It is the list of Files.
     * @param extension The name of extension (.png,.docx,etc).
     * @return A list of files that are the criteria of the extension.
     */
    private List<File> searchByExtension(List<File> listFile, String extension) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (file.getName().endsWith(extension)) {
                listFilter.add(file);
            }
        }
        return listFilter;
    }
    /*private List<File> searchIntoFile (List<File> listFile, String text) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                BufferedReader bf = new BufferedReader(new FileReader(file.getPath()));
                while ( bf.readLine() != null){
                    if (bf.readLine().equalsIgnoreCase(text)){
                        listFilter.add(file);
                    }
                }
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listFilter;
    }*/


    /**
     * This method is for search files by Owner.
     *
     * @param owner this is name of owner for filter file list.
     * @return list all the files minor or major or equal to given size.
     */
    private List<File> searchByOwner(List<File> listFile, String owner) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            try {
                if (Files.getFileAttributeView(file.toPath(),FileOwnerAttributeView.class).getOwner().getName().equalsIgnoreCase(owner)) {
                    listFilter.add(file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listFilter;
    }
    /**
     * This method is for filter by criteria.
     *
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    private void filterByCriteria(SearchCriteria criteria) {

        if (criteria.getPath() != null) {
            fileList = searchByPath(criteria.getPath());
            if (criteria.getName() != null) {
                fileList = searchByName(fileList, criteria.getName(), criteria.getFileNameCriteria());
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

            if (criteria.getModifiedDateInit() != null && criteria.getModifiedDateEnd() != null) {
                fileList = lastModifiedTime(fileList, criteria.getModifiedDateInit(), criteria.getModifiedDateEnd());
            }

            if (criteria.getCreationDateInit() != null && criteria.getCreationDateEnd() != null) {
                fileList = creationTime(fileList, criteria.getCreationDateInit(), criteria.getCreationDateEnd());
            }

            if (criteria.getLastAccessDateInit() != null && criteria.getLastAccessDateEnd() != null) {
                fileList = lastAccessTime(fileList, criteria.getLastAccessDateInit(), criteria.getLastAccessDateEnd());
            }
            if (criteria.getIsReadOnly()) {

                fileList = isReadOnly(fileList);
            }

            if (criteria.getIsDirectory()) {
                fileList = searchByDirectory(fileList);
            }

            if (criteria.getIsFileSystem()) {
                fileList = isFileSystem(fileList);
            }

            if (criteria.getExtension() != null) {
                fileList = searchByExtension(fileList, criteria.getExtension());
            }

            if (criteria.getCreationDateInit() != null && criteria.getCreationDateEnd() != null) {
                fileList = lastModifiedTime(fileList, criteria.getCreationDateInit(), criteria.getCreationDateEnd());
            }

            if (criteria.getModifiedDateInit() != null && criteria.getModifiedDateEnd() != null) {
                fileList = creationTime(fileList, criteria.getModifiedDateInit(), criteria.getModifiedDateEnd());
            }

            if (criteria.getLastAccessDateInit() != null && criteria.getLastAccessDateEnd() != null) {
                fileList = lastAccessTime(fileList, criteria.getLastAccessDateInit(), criteria.getLastAccessDateEnd());
            }
            if (criteria.getSize() > -1 && criteria.getSize() != 0L) {
                fileList = searchBySize(fileList, criteria.getSize(), criteria.getOperator());
            }

            if (!criteria.getOwnerCriteria().isEmpty()) {
                fileList = searchByOwner(fileList,criteria.getOwnerCriteria());
            }
            if(criteria.getKeySensitiveOfCriteria()){
                fileList = searchKeySensitive(fileList, criteria.getName());

            }
            if(criteria.getIsContainsInsideFileCriteria() ){
                fileList =  searchIntoFile(fileList,criteria.getTextContainsInsideFileCriteria());
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
     * This method initialize the criteria filtering..
     */
    public void initSearch() {
        filterByCriteria(criteria);
    }

    /**
     * @return List of files.
     */
    public List<Asset> getResultList() {
        List<Asset> result = new ArrayList<>();

        if (!fileList.isEmpty()) {
            fileList.forEach(e -> result
                    .add(createFileResult(e)));

        }
        return result;

    }

    /**
     * @param e A list of files.
     *
     * @return a list of files it depend of the criteria..
     */
    private Asset createFileResult(File e) {
        FileResult result = null;
        AssetFactory assetFactory = new AssetFactory();
        Asset asset = null;
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(e.toPath(), BasicFileAttributes.class);
            DosFileAttributes fileAttributes1 = Files.readAttributes(e.toPath(), DosFileAttributes.class);
            FileOwnerAttributeView fileAttributes2 = Files.getFileAttributeView(e.toPath(), FileOwnerAttributeView.class);

            asset = assetFactory.buildAsset("file",e.getPath(), e.getName(), e.length(), e.isHidden(), e.canRead(), fileAttributes.lastModifiedTime(), fileAttributes.creationTime(), fileAttributes.lastAccessTime(), fileAttributes2.getOwner().getName(), fileAttributes1.isReadOnly(), fileAttributes1.isSystem(), fileAttributes.isDirectory(), "", e.getName(),25,25.2);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return asset;
    }

    private List<File> searchKeySensitive (List<File> listFile, String name) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (file.getName().equals(name)) {
                listFilter.add(file);
            }
        }
        return listFilter;
    }
    private List<File> searchIntoFile(List<File> listFile, String text) {
        List<File> listFilter = new ArrayList<>();
        Scanner sc = null;
        for (File file : listFile) {
            if (file.getName().endsWith(".txt")) {
                try {
                    sc = new Scanner(new FileReader(file));

                    while (sc.hasNextLine()) {
                        if (sc.nextLine().contains(text)) {
                            listFilter.add(file);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
            if (file.getName().endsWith(".docx")) {

                try {

                    FileInputStream fis = new FileInputStream(file.getPath());
                    XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                    XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                    if(extractor.getText().contains(text)){
                        listFilter.add(file);
                    }

                } catch (Exception ex) {
                    return null;

                }

            }

        }

        return listFilter;
    }



    /**
     * This method is for filter by criteria.
     *
     * @param searchCriteria receives SearchCriteria object.
     *                 Is a method that filter a List according that insert to DB.
     */
    public void saveCriteriaToDataBase(SearchCriteria searchCriteria){
        try {
            //Insert to DB
            SearchQuery queryToInsertOnDataBase = new SearchQuery();
            Gson gSonCriteria = new Gson();
            String jSonCriteriaToSave = gSonCriteria.toJson(searchCriteria);

            queryToInsertOnDataBase.addCriteria(jSonCriteriaToSave);
            //Exceptions
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Return data from DB to Search Criteria.
     * @return Criteria list of files..
     */
    public Map<Integer,SearchCriteria> getAllDataFromDataBase(){

        ResultSet resultSet = null;
        SearchCriteria searchCriteria;
        int index;
        Map<Integer,SearchCriteria> criteriaList = new HashMap<>();
        Gson gSonCriteria = new Gson();
        try {
            //Return from DB
            SearchQuery queryToInsertOnDataBase = new SearchQuery();
            resultSet= queryToInsertOnDataBase.getAllCriteria();
            while(resultSet.next()){

                index = resultSet.getInt("ID");
                searchCriteria = gSonCriteria.fromJson(resultSet.getString("CRITERIAJSON"),SearchCriteria.class);
                criteriaList.put(index,searchCriteria);

            }
            //Exceptions
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return criteriaList;

    }

    /**
     * Delete data from DB.
     */
    public void deleteCriteriaFromDataBase(int index){
        try {
            //Delete from DB
            SearchQuery searchQuery = new SearchQuery();
            searchQuery.deleteCriteria(index);
            //Exception
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
