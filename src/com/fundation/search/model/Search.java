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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is to search files by criteria.
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


    /**
     * @param listFile
     * @return
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
     * @param listFile
     * @return
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
     * @param listFile
     * @return
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

             /*if (criteria.getOwnerCriteria() != null) {
                fileList = searchByOwner(fileList,criteria.getOwnerCriteria());
            }*/

             /*if(criteria.getIntoFile() != null){
                fileList = searchIntoFile(fileList,criteria.getIntoFile());
            }*/
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
     * Is the list(FileResult) result of a search by criteria.
     *
     * @return File Result list with the files already searched.
     */
    public List<FileResult> getResultList() {
        List<FileResult> result = new ArrayList<>();
        if (!fileList.isEmpty()) {
            for (File file : fileList) {
                try {
                    BasicFileAttributes fileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    DosFileAttributes fileAttributes1 = Files.readAttributes(file.toPath(), DosFileAttributes.class);
                    // PosixFileAttributes fileAttributes2 = Files.readAttributes(file.toPath(),PosixFileAttributes.class);
                    result.add(new FileResult()
                            .pathFile(file.getPath())
                            .nameFile(file.getName())
                            .sizeFile(file.length())
                            .isHiddenFile(file.isHidden())
                            .isDirectory(fileAttributes.isDirectory())
                            .extensionFile(file.getName())
                            .creationTime(fileAttributes.creationTime())
                            .lastAccessTime(fileAttributes.lastAccessTime())
                            .lastModifiedTime(fileAttributes.lastModifiedTime())
                            .isReadOnlyFile(fileAttributes1.isReadOnly())
                            .isFileSystemFile(fileAttributes1.isSystem()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }
}