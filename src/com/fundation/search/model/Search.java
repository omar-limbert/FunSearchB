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
import com.fundation.search.model.asset.FolderResult;
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
import java.nio.file.Paths;
import java.nio.file.attribute.*;
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
     * fileList is a Asset.
     */
    private List<Asset> assetList;
    private AssetFactory assetFactory;

    /**
     * Search Class constructor.
     */
    public Search() {
        assetList = new ArrayList<Asset>();
        assetFactory = new AssetFactory();
    }

    /**
     * @param path .
     * @return list all the files contained within the path.
     */
    private List<Asset> searchByPath(String path) {
        try {

            BasicFileAttributes fileBasicAttributes;
            File[] files = new File(path).listFiles();

            // Attributes for user inside foreach
            Asset asset;
            String ownerFile;
            boolean isFileSystem;
            boolean isReadOnly;
            for (File file : files) {
                fileBasicAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                ownerFile = Files.getFileAttributeView(file.toPath(), FileOwnerAttributeView.class).getOwner().getName();
                isFileSystem = Files.readAttributes(file.toPath(), DosFileAttributes.class).isSystem();
                isReadOnly = Files.readAttributes(file.toPath(), DosFileAttributes.class).isReadOnly();
                asset = assetFactory.getAsset(file.getPath()
                        , file.getName()
                        , fileBasicAttributes.size()
                        , file.isHidden()
                        , fileBasicAttributes.lastModifiedTime()
                        , fileBasicAttributes.creationTime()
                        , fileBasicAttributes.lastAccessTime()
                        , isReadOnly
                        , isFileSystem
                        , fileBasicAttributes.isDirectory()
                        , ownerFile
                        , ""
                        , "");

                assetList.add(asset);

                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                    if (asset instanceof FolderResult) {
                        asset = assetFactory.getAsset(file.getPath()
                                , file.getName()
                                , fileBasicAttributes.size()
                                , file.isHidden()
                                , fileBasicAttributes.lastModifiedTime()
                                , fileBasicAttributes.creationTime()
                                , fileBasicAttributes.lastAccessTime()
                                , isReadOnly
                                , isFileSystem
                                , fileBasicAttributes.isDirectory()
                                , ownerFile
                                , 15);

                        assetList.add(asset);
                    }
                }
            }

            // assetList.forEach(e -> System.out.println(e.getName()));
        } catch (NullPointerException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assetList;
    }

    /**
     * NOTE: You need improve 'e.getName()' for get only file name without extension.
     *
     * @param listFile .
     * @param nameFile .
     * @return list all the files that contains the name of a file.
     */
    private List<Asset> searchByName(List<Asset> listFile, String nameFile, String fileNameCriteria) {
        if (fileNameCriteria.equalsIgnoreCase("all words") || fileNameCriteria.isEmpty()) {
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
    private List<Asset> searchBySize(List<Asset> listFile, long size, String operator) {


        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {

            if (operator.equalsIgnoreCase("upper")) {
                if (file.getSizeFile() > size) {
                    listFilter.add(file);
                }
            }

            if (operator.equalsIgnoreCase("lower")) {
                if (file.getSizeFile() < size) {
                    listFilter.add(file);
                }
            }

            if (operator.equalsIgnoreCase("equal")) {
                if (file.getSizeFile() == size) {
                    listFilter.add(file);
                }
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

    private List<Asset> searchHiddenFiles(List<Asset> listFile, String hiddenCriteria) {

        if (hiddenCriteria.equalsIgnoreCase("only hidden")) {
            listFile.removeIf(e -> (!e.getIsHidden()));
        }
        if (hiddenCriteria.equalsIgnoreCase("without hidden")) {
            listFile.removeIf(e -> (e.getIsHidden()));
        }

        return listFile;
    }

    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for lastModifiedTime time on a file.
     * @param dateConditionEnd Is the end date for lastModifiedTime time on a file.
     * @return a list of files that are on range between init date and end date.
     */
    private List<Asset> lastModifiedTime(List<Asset> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        List<Asset> listFilter = new ArrayList<>();
        //listFile.forEach(e -> System.out.println(e.getName()));
        for (Asset file : listFile) {
            if ((file.getLastModifiedTime().toMillis() >= dateConditionInt.toMillis() && file.getLastModifiedTime().toMillis() <= dateConditionEnd.toMillis())) {
                listFilter.add(file);
            }
        }
        //listFilter.forEach(e -> System.out.println(e.getName()));
        return listFilter;
    }

    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for creationTime time on a file.
     * @param dateConditionEnd Is the end date for creationTime time on a file.
     * @return a list of files that are on range creationTime init date and end date.
     */
    private List<Asset> creationTime(List<Asset> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        List<Asset> listFilter = new ArrayList<>();
        //listFile.forEach(e -> System.out.println(e.getName()));
        for (Asset file : listFile) {
            if ((file.getCreationTime().toMillis() >= dateConditionInt.toMillis() && file.getCreationTime().toMillis() <= dateConditionEnd.toMillis())) {
                listFilter.add(file);
            }
        }
        // listFilter.forEach(e -> System.out.println(e.getName()));
        return listFilter;
    }


    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for lastAccessTime time on a file.
     * @param dateConditionEnd Is the end date for lastAccessTime time on a file.
     * @return a list of files that are on range lastAccessTime init date and end date.
     */
    private List<Asset> lastAccessTime(List<Asset> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        List<Asset> listFilter = new ArrayList<>();
        //listFile.forEach(e -> System.out.println(e.getName()));
        for (Asset file : listFile) {
            if ((file.getLastAccessTime().toMillis() >= dateConditionInt.toMillis() && file.getLastAccessTime().toMillis() <= dateConditionEnd.toMillis())) {
                listFilter.add(file);
            }
        }
        // listFilter.forEach(e -> System.out.println(e.getName()));
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are ReadOnly.
     */
    private List<Asset> isReadOnly(List<Asset> listFile) {

        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getIsReadOnlyFile()) {
                listFilter.add(file);
            }
        }

        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are on System.
     */
    private List<Asset> isFileSystem(List<Asset> listFile) {
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getIsFileSystemFile()) {
                listFilter.add(file);
            }
        }

        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are a Directories (Folders).
     */
    private List<Asset> searchByDirectory(List<Asset> listFile) {
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getIsDirectory()) {
                listFilter.add(file);
            }
        }
        return listFilter;
    }

    /**
     * @param listFile  It is the list of Files.
     * @param extension The name of extension (.png,.docx,etc).
     * @return A list of files that are the criteria of the extension.
     */
    private List<Asset> searchByExtension(List<Asset> listFile, String extension) {
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getName().endsWith(extension)) {
                listFilter.add(file);
            }
        }
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are the criteria of the extension.
     */
    private List<Asset> searchKeySensitive(List<Asset> listFile, String name) {
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getName().equals(name)) {
                listFilter.add(file);
            }
        }
        return listFilter;
    }

    private List<Asset> searchIntoFile(List<Asset> listFile, String text) throws IOException {
        File fileToSearch = null;
        List<Asset> listFilter = new ArrayList<>();
        Scanner sc = null;
        for (Asset file : listFile) {
            if (file instanceof FileResult) {
                fileToSearch = new File(file.getPathFile());
                // this.searchInto(listFilter,fileToSearch, text);
                if (fileToSearch.getName().endsWith(".txt")) {
                    try {

                        sc = new Scanner(new FileReader(fileToSearch));

                        while (sc.hasNextLine()) {
                            if (sc.nextLine().contains(text)) {
                                listFilter.add(file);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
            if (fileToSearch.getName().endsWith(".docx")) {

                try {

                    FileInputStream fis = new FileInputStream(fileToSearch.getPath());
                    XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                    XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                    if (extractor.getText().contains(text)) {
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
     * This method is for search files by Owner.
     *
     * @param owner this is name of owner for filter file list.
     * @return list all the files minor or major or equal to given size.
     */
    private List<Asset> searchByOwner(List<Asset> listFile, String owner) {
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getOwnerFile().equalsIgnoreCase(owner)) {
                listFilter.add(file);
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
        assetList = new ArrayList<Asset>();

        if (criteria.getPath() != null) {
            assetList = searchByPath(criteria.getPath());

            if (criteria.getName() != null) {
                assetList = searchByName(assetList, criteria.getName(), criteria.getFileNameCriteria());
            }

            if (criteria.getHiddenCriteria().equalsIgnoreCase("all files")) {
                assetList = searchHiddenFiles(assetList, "all files");
            }

            if (criteria.getHiddenCriteria().equalsIgnoreCase("only hidden")) {
                assetList = searchHiddenFiles(assetList, "only hidden");
            }

            if (criteria.getHiddenCriteria().equalsIgnoreCase("without hidden")) {
                assetList = searchHiddenFiles(assetList, "without hidden");
            }

            if (criteria.getIsDirectory()) {
                assetList = searchByDirectory(assetList);
            }

            if (criteria.getIsFileSystem()) {
                assetList = isFileSystem(assetList);
            }

            if (criteria.getExtension() != null) {
                assetList = searchByExtension(assetList, criteria.getExtension());
            }

            if (criteria.getSize() > -1 && criteria.getSize() != 0L) {
                assetList = searchBySize(assetList, criteria.getSize(), criteria.getOperator());
            }

            if (!criteria.getOwnerCriteria().isEmpty()) {
                assetList = searchByOwner(assetList, criteria.getOwnerCriteria());
            }
            if (criteria.getKeySensitiveOfCriteria()) {
                assetList = searchKeySensitive(assetList, criteria.getName());

            }

           /*if (criteria.getCreationDateInit() != null && criteria.getCreationDateEnd() != null) {
                assetList = creationTime(assetList, criteria.getModifiedDateInit(), criteria.getModifiedDateEnd());
            }*/

            if (criteria.getLastAccessDateInit() != null && criteria.getLastAccessDateEnd() != null) {
                assetList = lastAccessTime(assetList, criteria.getLastAccessDateInit(), criteria.getLastAccessDateEnd());
            }

            if (criteria.getModifiedDateInit() != null && criteria.getModifiedDateEnd() != null) {
                assetList = lastModifiedTime(assetList, criteria.getCreationDateInit(), criteria.getCreationDateEnd());
            }
            // assetList.forEach(e -> System.out.println(e.getName()));


            if (criteria.getIsContainsInsideFileCriteria()) {
                try {
                    assetList = searchIntoFile(assetList, criteria.getTextContainsInsideFileCriteria());
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        return assetList;

    }

    /**
     * This method is for filter by criteria.
     *
     * @param searchCriteria receives SearchCriteria object.
     *                       Is a method that filter a List according that insert to DB.
     */
    public void saveCriteriaToDataBase(SearchCriteria searchCriteria) {
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
     *
     * @return Criteria list of files.
     */
    public Map<Integer, SearchCriteria> getAllDataFromDataBase() {

        ResultSet resultSet = null;
        SearchCriteria searchCriteria;
        int index;
        Map<Integer, SearchCriteria> criteriaList = new HashMap<>();
        Gson gSonCriteria = new Gson();
        try {
            //Return from DB..
            SearchQuery queryToInsertOnDataBase = new SearchQuery();
            resultSet = queryToInsertOnDataBase.getAllCriteria();
            while (resultSet.next()) {

                index = resultSet.getInt("ID");
                searchCriteria = gSonCriteria.fromJson(resultSet.getString("CRITERIAJSON"), SearchCriteria.class);
                criteriaList.put(index, searchCriteria);

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
    public void deleteCriteriaFromDataBase(int index) {
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
