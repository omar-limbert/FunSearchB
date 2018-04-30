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
import com.fundation.search.controller.builder.SearchCriteria;
import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.AssetFactory;
import com.fundation.search.model.asset.FileResult;
import com.fundation.search.model.asset.MultimediaResult;
import com.fundation.search.model.database.SearchQuery;
import com.google.gson.Gson;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.lang3.math.Fraction;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 * This class is to search files by criteria.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class Search {
    /**
     * LOOGER is the logger.
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * This is separator for manage paths.
     */
    private static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * This is currently Operating System.
     */
    private static final String OS = System.getProperty("os.name").toLowerCase();

    /**
     * criteria  is a SearchCriteria object that receive criteria to find files.
     */
    private SearchCriteria criteria;

    /**
     * fileList is a Asset.
     */
    private List<Asset> assetList;

    /**
     * assetFactory is a FileResult, FolderResult or MultimediaResult.
     */
    private AssetFactory assetFactory;

    /**
     * stream is variable for manage ffprobe and obtain data.
     */
    private FFmpegStream stream;

    /**
     * ffprobePath is variable for manage ffprobe and obtain data.
     */
    private String ffprobePath;

    /**
     * probeResult is variable for manage ffprobe and obtain data.
     */
    private FFmpegProbeResult probeResult;

    /**
     * ffprobe is variable for manage ffprobe and obtain data.
     */
    private FFprobe ffprobe;

    /**
     * Search Class constructor.
     */
    public Search() {
        assetList = new ArrayList<>();
        assetFactory = new AssetFactory();
    }

    /**
     * @param path .
     * @return list all the files contained within the path.
     */
    private void searchByPath(String path) {
        LOOGER.info("Entry to searchByPath Method");
        try {
            assetList = Files.walk(Paths.get(path))
                    .map(p -> {
                        Asset asset = null;
                        File file = new File(p.toString());
                        BasicFileAttributes fileBasicAttributes = null;
                        boolean isReadOnly = false;
                        boolean isFileSystem = false;
                        FileOwnerAttributeView fileOwnerAttributeView = null;
                        String extension = null;
                        int i = file.getName().lastIndexOf('.');
                        if (i > 0) {
                            extension = file.getName().substring(i + 1);
                        }
                        try {
                            fileBasicAttributes = Files.readAttributes(p, BasicFileAttributes.class);
                            fileOwnerAttributeView = Files.getFileAttributeView(file.toPath(), FileOwnerAttributeView.class);
                            isFileSystem = OS.contains("windows") ? Files.readAttributes(file.toPath(), DosFileAttributes.class).isSystem() : false;
                            isReadOnly = OS.contains("windows") ? Files.readAttributes(file.toPath(), DosFileAttributes.class).isReadOnly() : false;

                            if (!file.isDirectory()) {

                                // FileResult Creation
                                asset = new AssetFactory().getAsset(file.getPath()
                                        , file.getName()
                                        , fileBasicAttributes.size()
                                        , file.isHidden()
                                        , fileBasicAttributes.lastModifiedTime()
                                        , fileBasicAttributes.lastAccessTime()
                                        , fileBasicAttributes.creationTime()
                                        , isReadOnly
                                        , isFileSystem
                                        , fileBasicAttributes.isDirectory()
                                        , fileOwnerAttributeView.getOwner().getName()
                                        , extension
                                        , "");
                            } else {

                                // FolderResult Creation
                                asset = assetFactory.getAsset(file.getPath()
                                        , file.getName()
                                        , fileBasicAttributes.size()
                                        , file.isHidden()
                                        , fileBasicAttributes.lastModifiedTime()
                                        , fileBasicAttributes.lastAccessTime()
                                        , fileBasicAttributes.creationTime()
                                        , isReadOnly
                                        , isFileSystem
                                        , fileBasicAttributes.isDirectory()
                                        , fileOwnerAttributeView.getOwner().getName()
                                        , file.list().length);
                            }
                        } catch (java.io.IOException | java.lang.NullPointerException exception) {

                        }
                        return asset;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOOGER.info("Exit of searchByPath Method");
    }

    /**
     * This method is to search by name criteria.
     *
     * @param nameFile name of file.
     */
    private void searchByName(String nameFile, String fileNameCriteria) {
        LOOGER.info("Entry to searchByName Method");
        if (fileNameCriteria.equalsIgnoreCase("all words") || fileNameCriteria.isEmpty()) {
            assetList.removeIf(e -> (!e.getName().toLowerCase().contains(nameFile.toLowerCase())));
        }
        if (fileNameCriteria.equalsIgnoreCase("start with")) {
            assetList.removeIf(e -> (!e.getName().toLowerCase().startsWith(nameFile.toLowerCase())));
        }
        if (fileNameCriteria.equalsIgnoreCase("end with")) {
            assetList.removeIf(e -> (!e.getName().toLowerCase().endsWith(nameFile.toLowerCase())));
        }
        if (fileNameCriteria.equalsIgnoreCase("equal to")) {
            assetList.removeIf(e -> (!e.getName().toLowerCase().equals(nameFile.toLowerCase())));
        }
        LOOGER.info("Exit of searchByName Method");
    }

    /**
     * This Method is for filter Multimedia file by duration.
     *
     * @param time     is the multimedia file duration.
     * @param operator is "upper" or "lower" or "equal".
     */
    private void searchMultimediaByDuration(Double time, String operator) {
        LOOGER.info("Entry to searchMultimediaByDuration Method");
        if (operator.equalsIgnoreCase("upper")) {
            assetList.removeIf(file -> !(((MultimediaResult) file).getDuration() > time));
        }
        if (operator.equalsIgnoreCase("lower")) {
            assetList.removeIf(file -> !(((MultimediaResult) file).getDuration() < time));
        }
        if (operator.equalsIgnoreCase("equal")) {
            assetList.removeIf(file -> !(((MultimediaResult) file).getDuration() == time));
        }
        LOOGER.info("Exit of searchMultimediaByDuration Method");
    }

    /**
     * This method is for filter by size.
     *
     * @param size     is the file size.
     * @param operator is "upper" or "lower" or "equal".
     */
    private void searchBySize(long size, String operator) {
        LOOGER.info("Entry to searchBySize Method");
        if (operator.equalsIgnoreCase("upper")) {
            assetList.removeIf(e -> !(e.getSizeFile() > size));
        }
        if (operator.equalsIgnoreCase("lower")) {
            assetList.removeIf(e -> !(e.getSizeFile() < size));
        }
        if (operator.equalsIgnoreCase("equal")) {
            assetList.removeIf(e -> !(e.getSizeFile() == size));
        }

        LOOGER.info("Exit of searchBySize Method");
    }

    /**
     * This method is for search Hidden Files.
     *
     * @param hiddenCriteria this param has 3 values, all files, only hiddens, without hiddens.
     */

    private void searchHiddenFiles(String hiddenCriteria) {
        LOOGER.info("Entry to searchHiddenFiles Method");
        if (hiddenCriteria.equalsIgnoreCase("only hidden")) {
            assetList.removeIf(e -> (!e.getIsHidden()));
        }
        if (hiddenCriteria.equalsIgnoreCase("without hidden")) {
            assetList.removeIf(e -> (e.getIsHidden()));
        }
        LOOGER.info("Exit of searchHiddenFiles Method");
    }

    /**
     * This method is for filter by last modified date.
     *
     * @param dateConditionInt Is the init date for lastModifiedTime time on a file.
     * @param dateConditionEnd Is the end date for lastModifiedTime time on a file.
     */
    private void lastModifiedTime(FileTime dateConditionInt, FileTime dateConditionEnd) {
        LOOGER.info("Entry to lastModifiedTime Method");
        assetList.removeIf(e -> !(e.getLastModifiedTime().toMillis() >= dateConditionInt.toMillis() && e.getLastModifiedTime().toMillis() <= dateConditionEnd.toMillis()));
        LOOGER.info("Exit of lastModifiedTime Method");
    }

    /**
     * This method is for filter by creation date.
     *
     * @param dateConditionInt Is the init date for creationTime time on a file.
     * @param dateConditionEnd Is the end date for creationTime time on a file.
     */
    private void creationTime(FileTime dateConditionInt, FileTime dateConditionEnd) {
        LOOGER.info("Entry to creationTime Method");
        assetList.removeIf(e -> !(e.getLastModifiedTime().toMillis() >= dateConditionInt.toMillis() && e.getLastModifiedTime().toMillis() <= dateConditionEnd.toMillis()));
        LOOGER.info("Exit of creationTime Method");
    }

    /**
     * This method is for filter by Las Access Date.
     *
     * @param dateConditionInt Is the init date for lastAccessTime time on a file.
     * @param dateConditionEnd Is the end date for lastAccessTime time on a file.
     */
    private void lastAccessTime(FileTime dateConditionInt, FileTime dateConditionEnd) {
        LOOGER.info("Entry to lastAccessTime Method");
        assetList.removeIf(e -> !(e.getLastModifiedTime().toMillis() >= dateConditionInt.toMillis() && e.getLastModifiedTime().toMillis() <= dateConditionEnd.toMillis()));

        LOOGER.info("Exit of lastAccessTime Method");

    }

    /**
     * This method is for filter by is read only or not.
     */
    private void isReadOnly() {
        LOOGER.info("Entry to isReadOnly Method");
        assetList.removeIf(e -> !(e.getIsReadOnlyFile()));
        LOOGER.info("Exit of isReadOnly Method");
    }

    /**
     * This method is to filter by is File System.
     */
    private void isFileSystem() {
        LOOGER.info("Entry to isFileSystem Method");
        assetList.removeIf(e -> !(e.getIsFileSystemFile()));
        LOOGER.info("Exit of isFileSystem Method");
    }

    /**
     * This method is to filter by is directory.
     */
    private void searchByDirectory() {
        LOOGER.info("Entry to searchByDirectory Method");
        assetList.removeIf(e -> !(e.getIsDirectory()));
        LOOGER.info("Exit of searchByDirectory Method");
    }

    /**
     * This method is to filter by extension.
     *
     * @param extension The name of extension (.png,.docx,etc).
     */
    private void searchByExtension(String extension) {
        LOOGER.info("Entry to searchByExtension Method");
        assetList.removeIf(e -> !(e.getName().endsWith(extension)));
        LOOGER.info("Exit of searchByExtension Method");
    }

    /**
     * This method is to filter by sensitive case.
     *
     * @return A list of files that are the criteria of the extension.
     */
    private void searchKeySensitive(String name) {
        LOOGER.info("Entry to searchKeySensitive Method");
        assetList.removeIf(e -> !(e.getName().contains(name)));
        LOOGER.info("Exit of searchKeySensitive Method");
    }

    /**
     * This method is for search text inside of file.
     *
     * @param text The text for search into files.
     */
    private void searchIntoFile(String text) {
        LOOGER.info("Entry to searchIntoFile Method");

        assetList.removeIf(fileToRead -> {
            Scanner scanner;
            if (fileToRead instanceof FileResult) {
                if (fileToRead.getName().endsWith(".txt")) {
                    try {
                        scanner = new Scanner(new FileReader(new File(fileToRead.getPathFile())));
                        while (scanner.hasNextLine()) {
                            if (scanner.nextLine().toLowerCase().contains(text.toLowerCase())) {
                                return false;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (fileToRead.getName().endsWith(".docx") || fileToRead.getName().endsWith(".doc") ) {

                    try {
                        FileInputStream fis = new FileInputStream(fileToRead.getPathFile());
                        XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                        if (extractor.getText().toLowerCase().contains(text.toLowerCase())) {
                            return false;
                        }
                    } catch (Exception ex) {
                        return true;
                    }
                }
            }
            return true;

        });
        LOOGER.info("Exit of searchIntoFile Method");
    }

    /**
     * This method is for search files by Owner.
     *
     * @param owner this is name of owner for filter file list.
     */
    private void searchByOwner(String owner) {
        LOOGER.info("Entry to searchByOwner Method");
        assetList.removeIf(e -> !(e.getOwnerFile().equalsIgnoreCase(owner)));
        LOOGER.info("Exit of searchByOwner Method");
    }

    /**
     * This method is for filter by criteria.
     *
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    private void filterByCriteria(SearchCriteria criteria) {
        LOOGER.info("Entry to filterByCriteria Method");
        if (criteria.getPath() != null) {
            this.searchByPath(criteria.getPath());
            if (criteria.getName() != null) {
                this.searchByName(criteria.getName(), criteria.getFileNameCriteria());
            }
            if (criteria.getHiddenCriteria().equalsIgnoreCase("all files")) {
                this.searchHiddenFiles("all files");
            }
            if (criteria.getHiddenCriteria().equalsIgnoreCase("only hidden")) {
                this.searchHiddenFiles("only hidden");
            }
            if (criteria.getHiddenCriteria().equalsIgnoreCase("without hidden")) {
                this.searchHiddenFiles("without hidden");
            }
            if (criteria.getIsDirectory()) {
                this.searchByDirectory();
            }
            if (criteria.getIsFileSystem()) {
                this.isFileSystem();
            }
            if (criteria.getIsReadOnly()) {
                this.isReadOnly();
            }
            if (criteria.getExtension() != null && !criteria.getExtension().isEmpty() ) {
                this.searchByExtension(criteria.getExtension());
            }
            if (criteria.getSize() > -1) {
                this.searchBySize(criteria.getSize(), criteria.getOperator());
            }
            if (!criteria.getOwnerCriteria().isEmpty()) {
                this.searchByOwner(criteria.getOwnerCriteria());
            }
            if (criteria.getKeySensitiveOfCriteria()) {
                this.searchKeySensitive(criteria.getName());
            }
            if (criteria.getCreationDateInit() != null && criteria.getCreationDateEnd() != null) {
                this.creationTime(criteria.getCreationDateInit(), criteria.getCreationDateEnd());
            }
            if (criteria.getLastAccessDateInit() != null && criteria.getLastAccessDateEnd() != null) {
                this.lastAccessTime(criteria.getLastAccessDateInit(), criteria.getLastAccessDateEnd());
            }
            if (criteria.getModifiedDateInit() != null && criteria.getModifiedDateEnd() != null) {
                this.lastModifiedTime(criteria.getModifiedDateInit(), criteria.getModifiedDateEnd());
            }
            if (criteria.getIsContainsInsideFileCriteria()) {
                this.searchIntoFile(criteria.getTextContainsInsideFileCriteria());
            }
            // Multimedia Files
            if (criteria.isSearchMultimedia()) {
                this.addMultimediaAttributes();
            }
            if (criteria.getMultimediaDuration() > -1 && criteria.isSearchMultimedia()) {
                this.searchMultimediaByDuration(criteria.getMultimediaDuration(), criteria.getMultimediaDurationOperator());
            }
            if (!criteria.getMultimediaVideoCodec().isEmpty() && criteria.isSearchMultimedia()) {
                this.searchMultimediaByVideoCodec(criteria.getMultimediaVideoCodec());
            }
            if (!criteria.getMultimediaResolution().isEmpty() && criteria.isSearchMultimedia()) {
                this.searchMultimediaByResolution(criteria.getMultimediaResolution());
            }
            if (!criteria.getMultimediaType().isEmpty() && criteria.isSearchMultimedia()) {
                this.searchMultimediaByType(criteria.getMultimediaType());
            }
            if (!criteria.getFrameRateCriteria().isEmpty() && criteria.isSearchMultimedia()) {
                this.searchMultimediaByFrameRate(criteria.getFrameRateCriteria());
            }
            if (!criteria.getMultimediaAudioBitRateInit().isEmpty() && !criteria.getMultimediaAudioBitRateEnd().isEmpty() && criteria.isSearchMultimedia()) {
                this.searchMultimediaByAudioBitRate(criteria.getMultimediaAudioBitRateInit(), criteria.getMultimediaAudioBitRateEnd());
            }
        }
        LOOGER.info("Exit of filterByCriteria Method");
    }

    /**
     * This method is for add multimedia attributes to Asset List.
     *
     */
    private void addMultimediaAttributes() {
        // Obtains data for multimedia
        List<Asset> assetResult = new ArrayList<>();

        // Initialize library for multimedia
        assetList.forEach(lookingForMultimedia -> {
            try {
                if (OS.contains("windows")) {
                    ffprobePath = new File(".").getCanonicalPath() + SEPARATOR + "resources" + SEPARATOR + "ffprobe.exe";

                } else {
                    ffprobePath = new File(".").getCanonicalPath() + SEPARATOR + "resources" + SEPARATOR + "ffprobe";
                }
                ffprobe = new FFprobe(ffprobePath);
                probeResult = ffprobe.probe(lookingForMultimedia.getPathFile());
                // Getting video information
                stream = probeResult.getStreams().get(0);
                String codecName = stream.codec_name;
                String codecLongName = stream.codec_long_name;
                int width = stream.width;
                int height = stream.height;
                String displayAspect = stream.display_aspect_ratio;
                Fraction rFrameRate = stream.r_frame_rate;
                double startTime = stream.start_time;
                double duration = stream.duration;
                long bitRate = stream.bit_rate;
                long nbFrames = stream.nb_frames;

                // Getting audio information
                stream = probeResult.getStreams().get(1);
                String audioCodecName = stream.codec_name;
                String audioCodecNameLong = stream.codec_long_name;
                String audioCodecTag = stream.codec_tag;
                int audioChannels = stream.channels;
                String audioChannelsLayout = stream.channel_layout;
                double audioStarTime = stream.start_time;
                double audioDuration = stream.duration;
                long audioBitRate = stream.bit_rate;
                long audioMaxBitRate = stream.max_bit_rate;
                long audioNbFrame = stream.nb_frames;

                assetResult.add(assetFactory.getAsset(lookingForMultimedia.getPathFile()
                        , lookingForMultimedia.getName()
                        , lookingForMultimedia.getSizeFile()
                        , lookingForMultimedia.getIsHidden()
                        , lookingForMultimedia.getLastModifiedTime()
                        , lookingForMultimedia.getLastAccessTime()
                        , lookingForMultimedia.getCreationTime()
                        , lookingForMultimedia.getIsReadOnlyFile()
                        , lookingForMultimedia.getIsFileSystemFile()
                        , lookingForMultimedia.getIsDirectory()
                        , lookingForMultimedia.getOwnerFile()
                        , codecName
                        , lookingForMultimedia.getExtensionFile()
                        , codecLongName
                        , width
                        , height
                        , displayAspect
                        , rFrameRate
                        , startTime
                        , duration
                        , bitRate
                        , nbFrames
                        , audioCodecName
                        , audioCodecNameLong
                        , audioCodecTag
                        , audioChannels
                        , audioChannelsLayout
                        , audioStarTime
                        , audioDuration
                        , audioBitRate
                        , audioMaxBitRate
                        , audioNbFrame));

            } catch (java.io.IOException | java.lang.NullPointerException exception) {

            } catch (java.lang.IndexOutOfBoundsException ex) {

            }
        });
        assetList = assetResult;
    }

    /**
     * This method is to search Multimedia by Audio Rate.
     *
     * @param bitRateInit Audio Rate Init.
     * @param bitRateEnd Audio Rate End.
     */
    private void searchMultimediaByAudioBitRate(String bitRateInit, String bitRateEnd) {
        LOOGER.info("Entry to searchMultimediaByType Method");
        assetList.removeIf(file -> {
            MultimediaResult multimediaResult = (MultimediaResult) file;
            return !(multimediaResult.getAudioBitRate() >= Long.valueOf(bitRateInit) && multimediaResult.getAudioBitRate() <= Long.valueOf(bitRateEnd));
        });
        LOOGER.info("Exit of searchMultimediaByType Method");
    }

    /**
     * This method is to search Multimedia by Frame Rate.
     *
     * @param frameRate Frame Rate Criteria.
     */
    private void searchMultimediaByFrameRate(ArrayList<String> frameRate) {
        LOOGER.info("Entry to searchMultimediaByType Method");
        assetList.removeIf(file -> {
            MultimediaResult multimediaResult = (MultimediaResult) file;
            final boolean[] result = new boolean[1];
            result[0] = true;
            frameRate.forEach(criteria -> {
                Double value = (Math.ceil(multimediaResult.getrFrameRate().doubleValue()));
                String valueForCompare = value.intValue() + " fps";
                if ((criteria.equalsIgnoreCase(valueForCompare)) || criteria.equalsIgnoreCase("All")) {
                    result[0] = false;
                }
            });
            return result[0];

        });
        LOOGER.info("Exit of searchMultimediaByType Method");
    }

    /**
     * This method is to search Multimedia by multimedia type.
     *
     * @param multimediaType Multimedia type Criteria.
     */
    private void searchMultimediaByType(ArrayList<String> multimediaType) {
        LOOGER.info("Entry to searchMultimediaByType Method");
        assetList.removeIf(file -> {
            MultimediaResult multimediaResult = (MultimediaResult) file;
            final boolean[] result = new boolean[1];
            result[0] = true;
            multimediaType.forEach(criteria -> {
                if (criteria.equalsIgnoreCase(multimediaResult.getExtensionFile()) || criteria.equalsIgnoreCase("All")) {
                    result[0] = false;
                }
            });
            return result[0];

        });
        LOOGER.info("Exit of searchMultimediaByType Method");
    }

    /**
     * This method is to search Multimedia by video codec.
     *
     * @param multimediaVideoCodec Multimedia video codec Criteria.
     */
    private void searchMultimediaByVideoCodec(ArrayList<String> multimediaVideoCodec) {
        LOOGER.info("Entry to searchMultimediaByVideoCodec Method");
        assetList.removeIf(file -> {
            MultimediaResult multimediaResult = (MultimediaResult) file;
            final boolean[] result = new boolean[1];
            result[0] = true;
            multimediaVideoCodec.forEach(criteria -> {
                if (criteria.equalsIgnoreCase(multimediaResult.getCodecName()) || criteria.equalsIgnoreCase("All")) {
                    result[0] = false;
                }
            });
            return result[0];

        });
        LOOGER.info("Exit of searchMultimediaByVideoCodec Method");
    }

    /**
     * This method is to search Multimedia by video resolution.
     *
     * @param multimediaREsolution Multimedia Resolution Criteria.
     */
    private void searchMultimediaByResolution(ArrayList<String> multimediaREsolution) {
        LOOGER.info("Entry to searchMultimediaByResolution Method");
        assetList.removeIf(file -> {
            MultimediaResult multimediaResult = (MultimediaResult) file;
            final boolean[] result = new boolean[1];
            result[0] = true;
            multimediaREsolution.forEach(criteria -> {
                if (criteria.equalsIgnoreCase(multimediaResult.getDisplayAspect() + " " + multimediaResult.getWidth() + "x" + multimediaResult.getHeight()) || criteria.equalsIgnoreCase("All")) {
                    result[0] = false;
                }
            });
            return result[0];
        });
        LOOGER.info("Exit of searchMultimediaByResolution Method");
    }

    /**
     * @param criteria This method receives a criteria.
     */
    public void setSearchCriteria(SearchCriteria criteria) {
        LOOGER.info("Entry to setSearchCriteria Method");
        LOOGER.info("Exit of setSearchCriteria Method");
        this.criteria = criteria;
    }

    /**
     * This method initialize the criteria filtering..
     */
    public void initSearch() {
        LOOGER.info("Entry to initSearch Method");
        LOOGER.info("Exit of initSearch Method");
        assetList = new ArrayList<Asset>();
        filterByCriteria(criteria);
    }

    /**
     * @return List of files.
     */
    public List<Asset> getResultList() {
        LOOGER.info("Entry to getResultList Method");
        LOOGER.info("Exit of getResultList Method");
        return assetList;

    }

    /**
     * This method is for filter by criteria.
     *
     * @param searchCriteria receives SearchCriteria object.
     *                       Is a method that filter a List according that insert to DB.
     */
    public void saveCriteriaToDataBase(SearchCriteria searchCriteria) {
        LOOGER.info("Entry to saveCriteriaToDataBase Method");
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
        LOOGER.info("Exit of saveCriteriaToDataBase Method");
    }

    /**
     * Return data from DB to Search Criteria.
     *
     * @return Criteria list of files.
     */
    public Map<Integer, SearchCriteria> getAllDataFromDataBase() {
        LOOGER.info("Entry to getAllDataFromDataBase Method");
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
        LOOGER.info("Exit of getAllDataFromDataBase Method");
        return criteriaList;
    }

    /**
     * Delete data from DB.
     */
    public void deleteCriteriaFromDataBase(int index) {
        LOOGER.info("Entry to deleteCriteriaFromDataBase Method");
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
        LOOGER.info("Exit of deleteCriteriaFromDataBase Method");
    }
}
