/*
 * @(#)FileNamePanel.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.model.asset;

import java.nio.file.attribute.FileTime;

/**
 * This class Asset can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MultimediaResult extends Asset{

    /** Declaration of variables For Video.*/

    /**
     * Extension File is the extensionFile.
     */
    private String extensionFile;

    /**
     * Codec Name is the codecName.
     */
    private String codecName;

    /**
     * Codec Long Name is the codecLongName.
     */
    private  String codecLongName;

    /**
     * Width is the width.
     */
    private int width;

    /**
     * Height is the height.
     */
    private int height;

    /**
     * Display Aspect is the displayAspect.
     */
    private String displayAspect;

    /**
     * Frame Rate is the rFrameRate.
     */
    private  String rFrameRate;

    /**
     * Start Time is the starTime.
     */
    private double starTime;

    /**
     * Duration is the duration.
     */
    private double duration;

    /**
     * BitRate is the bitRate.
     */
    private long bitRate;

    /**
     * Nb Frames is the nbFrames.
     */
    private long nbFrames;


    /**Declaration of variables Only for Audio.*/

    /**
     * Audio Codec Name is the audioCodecName.
     */
    private String audioCodecName;

    /**
     * Audio Codec Long Name is the audioCodecLongName.
     */
    private String audioCodecLongName;

    /**
     * Audio Codec Tag is the audioCodecTag.
     */
    private String audioCodecTag;

    /**
     * Audio Channels is the audioChannels.
     */
    private int audioChannels;

    /**
     * Audio Channel Layout is the audioChannelLayout.
     */
    private String audioChannelLayout;

    /**
     * Audio Start Time is the audioStarTime.
     */
    private  double audioStarTime;

    /**
     * Audio Duration is the audioDuration.
     */
    private double audioDuration;

    /**
     * Audio BitRate is the audioBitRate.
     */
    private long audioBitRate;

    /**
     * Audio Max BitRate is the audioMaxBitRate.
     */
    private long audioMaxBitRate;

    /**
     * Audio Nb Frame is the audioNbFrame.
     */
    private long audioNbFrame;


    /**
     * Constructor for MultimediaResult of Video.
     */
    public MultimediaResult (String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, String ownerFile, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String codecName, String extensionFile, String codecLongName, int width, int height, String displayAspect, String rFrameRate, double startTime, double duration, long bitRate, long nbFrames, String audioCodecName, String audioCodecNameLong, String audioCodecTag, int audioChannels, String audioChannelsLayout, double audioStarTime, double audioDuration, long audioBitRate, long audioMaxBitRate, long audioNbFrame){
        super( pathFile,  nameFile,  sizeFile,  isHiddenFile,  lastModifiedTime,  creationTime,  lastAccessTime,  ownerFile,  isReadOnly,  isFileSystem,  isDirectory);
        //Video
        this.extensionFile = extensionFile;
        this.codecName = codecName;
        this.codecLongName = codecLongName;
        this.width = width;
        this.height = height;
        this.displayAspect = displayAspect;
        this.rFrameRate = rFrameRate;
        this.starTime = startTime;
        this.duration = duration;
        this.bitRate = bitRate;
        this.nbFrames = nbFrames;
        //Only Audio
        this.audioCodecName = audioCodecName;
        this.audioCodecLongName = audioCodecNameLong;
        this.audioCodecTag = audioCodecTag;
        this.audioChannels = audioChannels;
        this.audioChannelLayout = audioChannelsLayout;
        this.audioStarTime = audioStarTime;
        this.audioDuration = audioDuration;
        this.audioBitRate = audioBitRate;
        this.audioMaxBitRate = audioMaxBitRate;
        this.audioNbFrame = audioNbFrame;

    }
    /**
     * This method return a Extension File.
     */
     public String getExtensionFile() {
        return extensionFile;
    }

    /**
     * This method return a duration.
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     * This method return a Codec Name.
     */
    public String getCodecName() {
        return codecName;
    }

    /**
     * This method return a Codec Long Name.
     */
    public String getCodecLongName() {
        return codecLongName;
    }

    /**
     * This method return a width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * This method return a height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * This method return a Display Aspect.
     */
    public String getDisplayAspect() {
        return displayAspect;
    }

    /**
     * This method return a Frame Rate.
     */
    public String getrFrameRate() {
        return rFrameRate;
    }

    /**
     * This method return a Start Time.
     */
    public double getStarTime() {
        return starTime;
    }

    /**
     * This method return a bitRate.
     */
    public long getBitRate() {
        return bitRate;
    }

    /**
     * This method return a Nb Frames.
     */
    public long getNbFrames() {
        return nbFrames;
    }

    /**
     * This method return a Audio Codec Name.
     */
    public String getAudioCodecName() {
        return audioCodecName;
    }

    /**
     * This method return a Audio Codec Long Name.
     */
    public String getAudioCodecLongName() {
        return audioCodecLongName;
    }

    /**
     * This method return a Audio Codec Tag.
     */
    public String getAudiofCodecTag() {
        return audioCodecTag;
    }

    /**
     * This method return a Audio Channels.
     */
    public int getAudioChannels() {
        return audioChannels;
    }

    /**
     * This method return a Audio Channel Layout.
     */
    public String getAudioChannelLayout() {
        return audioChannelLayout;
    }

    /**
     * This method return a Audio Start Time.
     */
    public double getAudioStarTime() {
        return audioStarTime;
    }

    /**
     * This method return a Audio Duration.
     */
    public double getAudioDuration() {
        return audioDuration;
    }

    /**
     * This method return a Audio BitRate.
     */
    public long getAudioBitRate() {
        return audioBitRate;
    }

    /**
     * This method return a Audio Max BitRate.
     */
    public long getAudioMaxBitRate() {
        return audioMaxBitRate;
    }

    /**
     * This method return a Audio Nb Frame.
     */
    public long getAudioNbFrame() {
        return audioNbFrame;
    }

}
