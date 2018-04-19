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

import com.fundation.search.common.SearchLogger;
import com.fundation.search.controller.SearchCriteria;
import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.AssetFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is to search files by criteria..
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @author Ariel Gonzales Vargas - AT-[06].
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

    private List<Asset> assetList;

    private  AssetFactory assetFactory;

    private List<Asset> result;
    /**
     * Search Class constructor.
     */
    public Search() {

        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        fileList = new ArrayList<>();
        assetFactory = new AssetFactory();
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
    }

    /**
     * @param path .
     * @return list all the files contained within the path.
     */
    private List<File> searchByPath(String path) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return fileList;
    }

    /**
     * NOTE: You need improve 'e.getName()' for get only file name without extension.
     *
     * @param listFile .
     * @param nameFile .
     * @return list all the files that contains the name of a file.
     */
    private List<Asset> searchByName(File listFile, String nameFile, String fileNameCriteria) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        if (fileNameCriteria.equalsIgnoreCase("all words")) {
            assetList.removeIf(e -> (!listFile.getName().contains(nameFile)));
        }
        if (fileNameCriteria.equalsIgnoreCase("start with")) {
            assetList.removeIf(e -> (!listFile.getName().startsWith(nameFile)));
        }
        if (fileNameCriteria.equalsIgnoreCase("end with")) {
            assetList.removeIf(e -> (!listFile.getName().endsWith(nameFile)));
        }
        if (fileNameCriteria.equalsIgnoreCase("equal to")) {
            assetList.removeIf(e -> (!listFile.getName().equals(nameFile)));
        }
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return assetList;
    }

    /**
     * @param listFile file list.
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     * @return list all the files minor or major or equal to given size.
     */


    private List<File> searchBySize(List<File> listFile, long size, String operator) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        if (hiddenCriteria.equalsIgnoreCase("only hidden")) {
            listFile.removeIf(e -> (!e.isHidden()));
        }
        if (hiddenCriteria.equalsIgnoreCase("without hidden")) {
            listFile.removeIf(e -> (e.isHidden()));
        }
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFile;
    }

    /**
     * This method is for search files by Owner.
     *
     * @param owner this is name of owner for filter file list.
     * @return list all the files minor or major or equal to given size.
     */

   /* private List<File> searchByOwner(String owner) {
        fileList.removeIf(e -> !(this.isOwner(e, owner)));

        return fileList;
    }*/

    /**
     * This method is compare Owner.
     *
     * @param owner this is name of owner for filter file list.
     * @param e     this is a file for compare.
     * @return list all the files minor or major or equal to given size.
     */
  /*  private boolean isOwner(File e, String owner) {
        try {
            return owner.equalsIgnoreCase(Files.readAttributes(e.toPath(), PosixFileAttributes.class).owner().getName());
        } catch (IOException e1) {
            e1.printStackTrace();
            return false;
        }
    }
*/

   /* private List<File> searchByOwner(List<File> listFile, String owner) {

        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {

            PosixFileAttributes f = null;
            try {
                f = Files.readAttributes(file.toPath(), PosixFileAttributes.class);
                if (f.owner().getName().equalsIgnoreCase(owner)) {
                    listFilter.add(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            }
        return listFilter;
        }*/


    private List<File> lastModifiedTime(List<File> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }


    /**
     * @param listFile It is the list of Files.
     * @param dateConditionInt Is the init date for Creation time on a file.
     * @param dateConditionEnd Is the end date for Creation time on a file.
     * @return a list of files that are on range between init date and end date.
     */
    private List<File> creationTime(List<File> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }


    /**
     * @param listFile It is the list of Files.
     * @param dateConditionInt Is the init date for Last Access time on a file.
     * @param dateConditionEnd Is the end date for Last Access time on a file.
     * @return a list of files that are on range between init date and end date.
     */
    private List<File> lastAccessTime(List<File> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }


    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are ReadOnly.
     */
    private List<File> isReadOnly(List<File> listFile) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are on System.
     */
    private List<File> isFileSystem(List<File> listFile) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are a Directories (Folders).
     */
    private List<File> searchByDirectory(List<File> listFile) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
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
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @param extension The name of extension (.png,.docx,etc).
     * @return A list of files that are the criteria of the extension.
     */
    private List<File> searchByExtension(List<File> listFile, String extension) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (file.getName().endsWith(extension)) {
                listFilter.add(file);
            }
        }
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @param text The text that it should be find.
     * @return a list of files that contains the text into itselves.
     */
    private List<File> searchIntoFile (List<File> listFile, String text) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {

            try(FileInputStream fis=new FileInputStream(file)){

                int valor=fis.read();
                while(valor!=-1){
                    System.out.print((char)valor);
                    valor=fis.read();
                }

            }catch(IOException e){

            }
        }
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return listFilter;
    }


    /**
     * This method is for filter by criteria.
     *
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    public void filterByCriteria(SearchCriteria criteria) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        if (criteria.getPath() != null) {
            fileList = searchByPath(criteria.getPath());
            for (File f : fileList){

                if (criteria.getName() != null) {
                    assetList = searchByName(f, criteria.getName(), criteria.getFileNameCriteria());
                }
                if (criteria.getSize() > -1 && criteria.getSize() != 0L) {
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

            /* if (criteria.getOwnerCriteria() != null) {
                fileList = searchByOwner(fileList,criteria.getOwnerCriteria());
            }*/

             /*if(criteria.getIntoFile() != null){
                fileList = searchIntoFile(fileList,criteria.getIntoFile());
            }*/

            }

        }
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
    }

    /**
     * @param criteria This method receives a criteria.
     */
    public void setSearchCriteria(SearchCriteria criteria) {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        this.criteria = criteria;
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
    }

    /**
     * This method initialize the criteria filtering.
     */
    public void initSearch() {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        filterByCriteria(criteria);
        AssetFactory assetFactory = new AssetFactory();
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
    }

    /**
     * Is the list(FileResult) result of a search by criteria.
     *
     * @return File Result list with the files already searched.
     */
    private void fillResultList() {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        result = new ArrayList<>();
        if (!fileList.isEmpty()) {
            for (File file : fileList) {
                try {
                    BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    DosFileAttributes fileAttributes1 = Files.readAttributes(file.toPath(), DosFileAttributes.class);
                    // PosixFileAttributes fileAttributes2 = Files.readAttributes(file.toPath(),PosixFileAttributes.class);
                    result.add(new Asset(file.getPath(),file.getName(), file.length(), file.isHidden(), fileAttributes.creationTime()
                            , fileAttributes.lastAccessTime(), fileAttributes.lastModifiedTime(), fileAttributes1.isReadOnly(), fileAttributes1.isSystem()
                            ,file.getName()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
    }

    public List<Asset> getResultList() {
        SearchLogger.getInstanceOfLogger().getLogger().info("Entry to Method");
        fillResultList();
        SearchLogger.getInstanceOfLogger().getLogger().info("Exit to Method");
        return result;
    }

}