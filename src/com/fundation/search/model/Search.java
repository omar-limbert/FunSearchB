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
import com.fundation.search.model.asset.FolderResult;
import com.fundation.search.model.asset.MultimediaResult;
import com.fundation.search.model.database.SearchQuery;
import com.google.gson.Gson;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
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
        LOOGER.info("Entry to searchByPath Method");
        try {

            BasicFileAttributes fileBasicAttributes;
            File[] files = new File(path).listFiles();
            boolean os = System.getProperty("os.name").contains("mac");
            boolean isFileSystem;
            // Attributes for user inside foreach
            Asset asset = null;

            // Obtains data for multimedia
            FFmpegProbeResult probeResult = null;
            String ffprobePath = null;
            FFprobe ffprobe = null;

            for (File file : files) {
                fileBasicAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(file.toPath(), FileOwnerAttributeView.class);
                isFileSystem = os ? Files.readAttributes(file.toPath(), DosFileAttributes.class).isReadOnly() : false;

                // Extension file

                String extension = "";

                int i = file.getName().lastIndexOf('.');
                if (i > 0) {
                    extension = file.getName().substring(i + 1);
                }

                if (!file.isDirectory()) {
                    try {
                        // Data for multimedia
                        if(os){
                            ffprobePath = new File(".").getCanonicalPath() + "/resources/ffprobe.exe";
                        }
                        else{
                            ffprobePath = new File(".").getCanonicalPath() + "/resources/ffprobe";
                        }

                        ffprobe = new FFprobe(ffprobePath);
                        probeResult = ffprobe.probe(file.getAbsolutePath());

                        // Getting video information
                        FFmpegStream stream = probeResult.getStreams().get(0);
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

                        asset = assetFactory.getAsset(file.getPath()
                                , file.getName()
                                , fileBasicAttributes.size()
                                , file.isHidden()
                                , fileBasicAttributes.lastModifiedTime()
                                , fileBasicAttributes.creationTime()
                                , fileBasicAttributes.lastAccessTime()
                                , file.canRead()
                                , isFileSystem
                                , fileBasicAttributes.isDirectory()
                                , fileOwnerAttributeView.getOwner().getName()
                                , codecName
                                , extension
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
                                , audioNbFrame);
                        assetList.add(asset);

                    } catch (java.io.IOException | java.lang.NullPointerException exception) {
                        // Data for File
                        asset = assetFactory.getAsset(file.getPath()
                                , file.getName()
                                , fileBasicAttributes.size()
                                , file.isHidden()
                                , fileBasicAttributes.lastModifiedTime()
                                , fileBasicAttributes.creationTime()
                                , fileBasicAttributes.lastAccessTime()
                                , file.canRead()
                                , isFileSystem
                                , fileBasicAttributes.isDirectory()
                                , fileOwnerAttributeView.getOwner().getName()
                                , extension
                                , "");
                        assetList.add(asset);
                    } catch (java.lang.IndexOutOfBoundsException ex) {
                    }
                } else {
                    asset = assetFactory.getAsset(file.getPath()
                            , file.getName()
                            , fileBasicAttributes.size()
                            , file.isHidden()
                            , fileBasicAttributes.lastModifiedTime()
                            , fileBasicAttributes.creationTime()
                            , fileBasicAttributes.lastAccessTime()
                            , file.canRead()
                            , isFileSystem
                            , fileBasicAttributes.isDirectory()
                            , fileOwnerAttributeView.getOwner().getName()
                            , 15);
                    assetList.add(asset);
                    searchByPath(file.getPath());
                }
            }

        } catch (NullPointerException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOOGER.info("Exit of searchByPath Method");
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
        LOOGER.info("Entry to searchByName Method");
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
        LOOGER.info("Exit of searchByName Method");

        return listFile;
    }

    /**
     * This Method is for filter Multimedia file by duration.
     * Note: Need unittest.
     *
     * @param listFile asset list.
     * @param time     is the multimedia file duration.
     * @param operator is "upper" or "lower" or "equal".
     * @return list all the asset minor or major or equal to given time.
     */
    private List<Asset> searchMultimediaByDuration(List<Asset> listFile, Double time, String operator) {
        LOOGER.info("Entry to searchMultimediaByDuration Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file instanceof MultimediaResult) {
                MultimediaResult multimediaResult = (MultimediaResult) file;
                if (operator.equalsIgnoreCase("upper")) {
                    if (multimediaResult.getDuration() > time) {
                        listFilter.add(file);
                    }
                }

                if (operator.equalsIgnoreCase("lower")) {
                    if (multimediaResult.getDuration() < time) {
                        listFilter.add(file);
                    }
                }

                if (operator.equalsIgnoreCase("equal")) {
                    if (multimediaResult.getDuration() == time) {
                        listFilter.add(file);
                    }
                }
            }
        }
        LOOGER.info("Exit of searchMultimediaByDuration Method");
        return listFilter;
    }

    /**
     * @param listFile file list.
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     * @return list all the files minor or major or equal to given size.
     */
    private List<Asset> searchBySize(List<Asset> listFile, long size, String operator) {
        LOOGER.info("Entry to searchBySize Method");
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
        LOOGER.info("Exit of searchBySize Method");
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
        LOOGER.info("Entry to searchHiddenFiles Method");
        if (hiddenCriteria.equalsIgnoreCase("only hidden")) {
            listFile.removeIf(e -> (!e.getIsHidden()));
        }
        if (hiddenCriteria.equalsIgnoreCase("without hidden")) {
            listFile.removeIf(e -> (e.getIsHidden()));
        }
        LOOGER.info("Exit of searchHiddenFiles Method");
        return listFile;
    }

    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for lastModifiedTime time on a file.
     * @param dateConditionEnd Is the end date for lastModifiedTime time on a file.
     * @return a list of files that are on range between init date and end date.
     */
    private List<Asset> lastModifiedTime(List<Asset> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        LOOGER.info("Entry to lastModifiedTime Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if ((file.getLastModifiedTime().toMillis() >= dateConditionInt.toMillis() && file.getLastModifiedTime().toMillis() <= dateConditionEnd.toMillis())) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of lastModifiedTime Method");
        return listFilter;
    }

    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for creationTime time on a file.
     * @param dateConditionEnd Is the end date for creationTime time on a file.
     * @return a list of files that are on range creationTime init date and end date.
     */
    private List<Asset> creationTime(List<Asset> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        LOOGER.info("Entry to creationTime Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if ((file.getCreationTime().toMillis() >= dateConditionInt.toMillis() && file.getCreationTime().toMillis() <= dateConditionEnd.toMillis())) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of creationTime Method");
        return listFilter;
    }


    /**
     * @param listFile         It is the list of Files.
     * @param dateConditionInt Is the init date for lastAccessTime time on a file.
     * @param dateConditionEnd Is the end date for lastAccessTime time on a file.
     * @return a list of files that are on range lastAccessTime init date and end date.
     */
    private List<Asset> lastAccessTime(List<Asset> listFile, FileTime dateConditionInt, FileTime dateConditionEnd) {
        LOOGER.info("Entry to lastAccessTime Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if ((file.getLastAccessTime().toMillis() >= dateConditionInt.toMillis() && file.getLastAccessTime().toMillis() <= dateConditionEnd.toMillis())) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of lastAccessTime Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are ReadOnly.
     */
    private List<Asset> isReadOnly(List<Asset> listFile) {
        LOOGER.info("Entry to isReadOnly Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getIsReadOnlyFile()) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of isReadOnly Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are on System.
     */
    private List<Asset> isFileSystem(List<Asset> listFile) {
        LOOGER.info("Entry to isFileSystem Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getIsFileSystemFile()) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of isFileSystem Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are a Directories (Folders).
     */
    private List<Asset> searchByDirectory(List<Asset> listFile) {
        LOOGER.info("Entry to searchByDirectory Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getIsDirectory()) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of searchByDirectory Method");
        return listFilter;
    }

    /**
     * @param listFile  It is the list of Files.
     * @param extension The name of extension (.png,.docx,etc).
     * @return A list of files that are the criteria of the extension.
     */
    private List<Asset> searchByExtension(List<Asset> listFile, String extension) {
        LOOGER.info("Entry to searchByExtension Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getName().endsWith(extension)) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of searchByExtension Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @return A list of files that are the criteria of the extension.
     */
    private List<Asset> searchKeySensitive(List<Asset> listFile, String name) {
        LOOGER.info("Entry to searchKeySensitive Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getName().equals(name)) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of searchKeySensitive Method");
        return listFilter;
    }

    /**
     * @param listFile It is the list of Files.
     * @param text     The text for search into files.
     * @return A list of files that are the criteria of the intoFiles.
     * @throws IOException
     */
    private List<Asset> searchIntoFile(List<Asset> listFile, String text) throws IOException {
        LOOGER.info("Entry to searchIntoFile Method");
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
        LOOGER.info("Exit of searchIntoFile Method");
        return listFilter;
    }

    /**
     * This method is for search files by Owner.
     *
     * @param owner this is name of owner for filter file list.
     * @return list all the files minor or major or equal to given size.
     */
    private List<Asset> searchByOwner(List<Asset> listFile, String owner) {
        LOOGER.info("Entry to searchByOwner Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : listFile) {
            if (file.getOwnerFile().equalsIgnoreCase(owner)) {
                listFilter.add(file);
            }
        }
        LOOGER.info("Exit of searchByOwner Method");
        return listFilter;
    }

    /**
     * This method is for filter by criteria.
     *
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    private void filterByCriteria(SearchCriteria criteria) {
        LOOGER.info("Entry to filterByCriteria Method");
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

            if (criteria.getIsReadOnly()) {
                assetList = isReadOnly(assetList);
            }

            if (criteria.getExtension() != null) {
                assetList = searchByExtension(assetList, criteria.getExtension());
            }

            if (criteria.getSize() > -1) {
                assetList = searchBySize(assetList, criteria.getSize(), criteria.getOperator());
            }

            if (!criteria.getOwnerCriteria().isEmpty()) {
                assetList = searchByOwner(assetList, criteria.getOwnerCriteria());
            }
            if (criteria.getKeySensitiveOfCriteria()) {
                assetList = searchKeySensitive(assetList, criteria.getName());
            }

            /*if (criteria.getCreationDateInit() != null && criteria.getCreationDateEnd() != null) {
                System.out.println(criteria.getCreationDateInit() + "    " + criteria.getCreationDateEnd());
                assetList = creationTime(assetList, criteria.getModifiedDateInit(), criteria.getModifiedDateEnd());
            }*/

            if (criteria.getLastAccessDateInit() != null && criteria.getLastAccessDateEnd() != null) {
                assetList = lastAccessTime(assetList, criteria.getLastAccessDateInit(), criteria.getLastAccessDateEnd());
            }

            if (criteria.getModifiedDateInit() != null && criteria.getModifiedDateEnd() != null) {
                assetList = lastModifiedTime(assetList, criteria.getModifiedDateInit(), criteria.getModifiedDateEnd());
            }

            if (criteria.getIsContainsInsideFileCriteria()) {
                try {
                    assetList = searchIntoFile(assetList, criteria.getTextContainsInsideFileCriteria());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Multimedia

            if (criteria.getMultimediaDuration() > -1 && criteria.isSearchMultimedia()) {
                assetList = searchMultimediaByDuration(assetList, criteria.getMultimediaDuration(), criteria.getMultimediaDurationOperator());
            }
            if (!criteria.getMultimediaVideoCodec().isEmpty() && criteria.isSearchMultimedia()) {
                assetList = searchMultimediaByVideoCodec(assetList, criteria.getMultimediaVideoCodec());
            }
            if (!criteria.getMultimediaResolution().isEmpty() && criteria.isSearchMultimedia()) {
                assetList = searchMultimediaByResolution(assetList, criteria.getMultimediaResolution());
            }
            if (!criteria.getMultimediaType().isEmpty() && criteria.isSearchMultimedia()) {
                assetList = searchMultimediaByType(assetList, criteria.getMultimediaType());
            }
            if (!criteria.getFrameRateCriteria().isEmpty() && criteria.isSearchMultimedia()) {
                assetList = searchMultimediaByFrameRate(assetList, criteria.getFrameRateCriteria());
            }
            if (!criteria.getMultimediaAudioBitRateInit().isEmpty() && !criteria.getMultimediaAudioBitRateEnd().isEmpty() && criteria.isSearchMultimedia()) {
                assetList = searchMultimediaByAudioBitRate(assetList, criteria.getMultimediaAudioBitRateInit(), criteria.getMultimediaAudioBitRateEnd());
            }
        }
        LOOGER.info("Exit of filterByCriteria Method");
    }

    private List<Asset> searchMultimediaByAudioBitRate(List<Asset> assetList, String bitRateInit, String bitRateEnd) {
        LOOGER.info("Entry to searchMultimediaByType Method");

        List<Asset> listFilter = new ArrayList<>();

        for (Asset file : assetList) {
            if (file instanceof MultimediaResult) {
                MultimediaResult multimediaResult = (MultimediaResult) file;

                if (multimediaResult.getAudioBitRate() >= Long.valueOf(bitRateInit) && multimediaResult.getAudioBitRate() <= Long.valueOf(bitRateEnd)) {
                    listFilter.add(multimediaResult);
                }
            }
        }
        LOOGER.info("Exit of searchMultimediaByType Method");
        return listFilter;
    }

    private List<Asset> searchMultimediaByFrameRate(List<Asset> assetList, ArrayList<String> frameRate) {
        LOOGER.info("Entry to searchMultimediaByType Method");

        List<Asset> listFilter = new ArrayList<>();

        for (Asset file : assetList) {
            if (file instanceof MultimediaResult) {
                MultimediaResult multimediaResult = (MultimediaResult) file;
                frameRate.forEach(e -> {
                    Double value = (Math.ceil(multimediaResult.getrFrameRate().doubleValue()));
                    String valueForCompare = value.intValue() + " fps";

                    if (e.equalsIgnoreCase(valueForCompare)) {
                        listFilter.add(multimediaResult);
                    }
                });
            }
        }
        LOOGER.info("Exit of searchMultimediaByType Method");
        return listFilter;
    }

    private List<Asset> searchMultimediaByType(List<Asset> assetList, ArrayList<String> multimediaType) {
        LOOGER.info("Entry to searchMultimediaByType Method");

        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : assetList) {
            if (file instanceof MultimediaResult) {
                MultimediaResult multimediaResult = (MultimediaResult) file;
                multimediaType.forEach(e -> {
                    if (e.equalsIgnoreCase(multimediaResult.getExtensionFile())) {
                        listFilter.add(multimediaResult);
                    }

                });
            }
        }
        LOOGER.info("Exit of searchMultimediaByType Method");
        return listFilter;
    }

    private List<Asset> searchMultimediaByVideoCodec(List<Asset> assetList, ArrayList<String> multimediaVideoCodec) {
        LOOGER.info("Entry to searchMultimediaByVideoCodec Method");

        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : assetList) {
            if (file instanceof MultimediaResult) {
                MultimediaResult multimediaResult = (MultimediaResult) file;
                multimediaVideoCodec.forEach(e -> {
                    if (e.equalsIgnoreCase(multimediaResult.getCodecName())) {
                        listFilter.add(multimediaResult);
                    }

                });
            }
        }
        LOOGER.info("Exit of searchMultimediaByVideoCodec Method");
        return listFilter;
    }

    private List<Asset> searchMultimediaByResolution(List<Asset> assetList, ArrayList<String> multimediaREsolution) {
        LOOGER.info("Entry to searchMultimediaByResolution Method");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : assetList) {
            if (file instanceof MultimediaResult) {
                MultimediaResult multimediaResult = (MultimediaResult) file;
                multimediaREsolution.forEach(e -> {
                    if (e.equalsIgnoreCase(multimediaResult.getDisplayAspect() + " " + multimediaResult.getWidth() + "x" + multimediaResult.getHeight())) {
                        listFilter.add(multimediaResult);
                    }

                });
            }
        }
        LOOGER.info("Exit of searchMultimediaByResolution Method");
        return listFilter;
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
