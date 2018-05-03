/*
 * @(#)DataBasePanelTest.java
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
package com.fundation.search.view.CriteriaPanels;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class is to test DataBaseNorthPanel.java.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MultimediaPanelTest {

    /**
     * dataBasePanelTest, this is north data base panel.
     */
    private MultimediaPanel multimediaPanel;

    /**
     * initialize dataBasePanelTest().
     */
    @Before
    public void initialize() {
        multimediaPanel = new MultimediaPanel();
    }

    @Test
    public void testGetDurationMultimediaCriteriaTrue() {
        assertEquals("Major to:", multimediaPanel.getDurationMultimediaCriteria());
    }

    @Test
    public void testGetDurationMultimediaCriteriaFalse() {
        assertNotEquals("Major:", multimediaPanel.getDurationMultimediaCriteria());
    }

    @Test
    public void testGetDurationMultimediaNumberTrue() {
        assertEquals("", multimediaPanel.getDurationMultimediaNumber());
    }

    @Test
    public void testGetDurationMultimediaNumberFalse() {
        assertNotEquals("test", multimediaPanel.getDurationMultimediaNumber());
    }

    @Test
    public void testGetDurationMultimediaTimeTrue() {
        assertEquals("Second", multimediaPanel.getDurationMultimediaTime());
    }

    @Test
    public void testGetDurationMultimediaTimeFalse() {
        assertNotEquals("Seconds", multimediaPanel.getDurationMultimediaTime());
    }

    @Test
    public void testGetFrameRateCriteriaTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("12 fps");
        list.add("23 fps");
        list.add("24 fps");
        list.add("25 fps");
        list.add("30 fps");
        list.add("64 fps");
        list.add("96 fps");
        assertEquals(list, multimediaPanel.getFrameRateCriteria());
    }

    @Test
    public void testGetFrameRateCriteriaFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("12 fps");
        list.add("23 fps");
        list.add("24 fps");
        list.add("25 fps");
        list.add("30 fps");
        list.add("64 fps");
        list.add("96 fps");
        assertNotEquals(list, multimediaPanel.getFrameRateCriteria());
    }

    @Test
    public void getVideoCodecCriteriaTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("H264");
        list.add("H263");
        list.add("MPEG4");
        list.add("WMV1");
        list.add("DVD_NAV_PACKET");
        assertEquals(list, multimediaPanel.getVideoCodecCriteria());
    }

    @Test
    public void getVideoCodecCriteriaFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("H264");
        list.add("H263");
        list.add("MPEG4");
        list.add("WMV1");
        list.add("DVD_NAV_PACKET");
        assertNotEquals(list, multimediaPanel.getVideoCodecCriteria());
    }

    @Test
    public void getResolutionCriteriaTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("0:1 480x360");
        list.add("3:2 540x360");
        list.add("3:2 720x480");
        list.add("4:3 320x240");
        list.add("4:3 384x288");
        list.add("4:3 480x360");
        list.add("4:3 640x480");
        list.add("4:3 720x480");
        list.add("4:3 1920x1440");
        list.add("15:9 1280x768");
        list.add("16:9 640x480");
        list.add("16:9 720x480");
        list.add("16:9 1280x720");
        list.add("22:15 720x480");
        list.add("25:16 3200x2048");
        list.add("41:30 720x480");
        list.add("49:36 720x480");
        list.add("127:72 720x480");
        list.add("160:119 720x480");
        list.add("320:179 720x480");

        assertEquals(list, multimediaPanel.getResolutionCriteria());
    }

    @Test
    public void getResolutionCriteriaFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0:1 480x360");
        assertNotEquals(list, multimediaPanel.getResolutionCriteria());
    }

    @Test
    public void getMultimediaTypeCriteriaTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("MP4");
        list.add("MOV");
        list.add("WMV");
        list.add("AVI");
        assertEquals(list, multimediaPanel.getMultimediaTypeCriteria());
    }

    @Test
    public void getMultimediaTypeCriteriaFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        assertNotEquals(list, multimediaPanel.getMultimediaTypeCriteria());
    }

    @Test
    public void getAudioBitRateInitTrue() {
        assertEquals("", multimediaPanel.getAudioBitRateInit());
    }

    @Test
    public void getAudioBitRateInitFalse() {
        assertNotEquals("test", multimediaPanel.getAudioBitRateInit());
    }

    @Test
    public void getAudioBitRateEndTrue() {
        assertEquals("", multimediaPanel.getAudioBitRateEnd());
    }

    @Test
    public void getAudioBitRateEndFalse() {
        assertNotEquals("test", multimediaPanel.getAudioBitRateEnd());
    }

    @Test
    public void setMultimediaDurationCriteriaTrue() {
        multimediaPanel.setMultimediaDurationCriteria("Minor to:");
        assertEquals("Minor to:", multimediaPanel.getDurationMultimediaCriteria());
    }

    @Test
    public void setMultimediaDurationCriteriaFalse() {
        multimediaPanel.setMultimediaDurationCriteria("Minor to:");
        assertNotEquals("Major to:", multimediaPanel.getDurationMultimediaCriteria());
    }

    @Test
    public void setMultimediaDurationNumberTrue() {
        multimediaPanel.setMultimediaDurationNumber("10");
        assertEquals("10", multimediaPanel.getDurationMultimediaNumber());
    }

    @Test
    public void setMultimediaDurationNumberFalse() {
        multimediaPanel.setMultimediaDurationNumber("10");
        assertNotEquals("100", multimediaPanel.getDurationMultimediaNumber());
    }

    @Test
    public void setMultimediaDurationTypeTrue() {
        multimediaPanel.setMultimediaDurationType("Hour");
        assertEquals("Hour", multimediaPanel.getDurationMultimediaTime());
    }

    @Test
    public void setMultimediaDurationTypeFalse() {
        multimediaPanel.setMultimediaDurationType("Hour");
        assertNotEquals("Minute", multimediaPanel.getDurationMultimediaTime());
    }

    @Test
    public void setMultimediaFrameRateTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("12 fps");
        list.add("23 fps");
        list.add("24 fps");
        list.add("25 fps");
        list.add("30 fps");
        list.add("64 fps");
        list.add("96 fps");
        multimediaPanel.setMultimediaFrameRate(list);
        assertEquals(list, multimediaPanel.getFrameRateCriteria());
    }

    @Test
    public void setMultimediaFrameRateFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        multimediaPanel.setMultimediaFrameRate(list);
        list.add("All2");
        assertNotEquals(list, multimediaPanel.getFrameRateCriteria());
    }

    @Test
    public void setMultimediaDurationVideoCodec() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("H264");
        list.add("H263");
        multimediaPanel.setMultimediaDurationVideoCodec(list);
        assertEquals(list, multimediaPanel.getVideoCodecCriteria());
    }

    @Test
    public void setMultimediaResolutionTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("H264");
        list.add("H263");
        multimediaPanel.setMultimediaDurationVideoCodec(list);
        assertEquals(list, multimediaPanel.getVideoCodecCriteria());
    }

    @Test
    public void setMultimediaResolutionFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("H264");
        multimediaPanel.setMultimediaDurationVideoCodec(list);
        list.add("H263");
        assertNotEquals(list, multimediaPanel.getVideoCodecCriteria());
    }

    @Test
    public void setMultimediaTypeTrue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("MP4");
        list.add("MOV");
        list.add("WMV");
        list.add("AVI");
        multimediaPanel.setMultimediaType(list);
        assertEquals(list, multimediaPanel.getMultimediaTypeCriteria());
    }

    @Test
    public void setMultimediaTypeFalse() {
        ArrayList<String> list = new ArrayList<>();
        list.add("All");
        list.add("MP4");
        list.add("MOV");
        multimediaPanel.setMultimediaType(list);
        list.add("WMV");
        list.add("AVI");
        assertNotEquals(list, multimediaPanel.getMultimediaTypeCriteria());
    }

    @Test
    public void setMultimediaAudioBitRateInitTrue() {
        multimediaPanel.setMultimediaAudioBitRateInit("1000");
        assertEquals("1000", multimediaPanel.getAudioBitRateInit());
    }

    @Test
    public void setMultimediaAudioBitRateInitFalse() {
        multimediaPanel.setMultimediaAudioBitRateInit("1000");
        assertNotEquals("100", multimediaPanel.getAudioBitRateInit());
    }

    @Test
    public void setMultimediaAudioBitRateEndTrue() {
        multimediaPanel.setMultimediaAudioBitRateEnd("1000");
        assertEquals("1000", multimediaPanel.getAudioBitRateEnd());
    }

    @Test
    public void setMultimediaAudioBitRateEndFalse() {
        multimediaPanel.setMultimediaAudioBitRateEnd("1000");
        assertNotEquals("100", multimediaPanel.getAudioBitRateEnd());
    }
}