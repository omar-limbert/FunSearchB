/*
 * @(#)Multimedia.java
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

import com.fundation.search.common.SearchLogger;
import com.fundation.search.view.JComboCheckBox;
import com.fundation.search.view.SearchTextField;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Vector;

/**
 * This class is to create Multimedia Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class MultimediaPanel extends JPanel {
    /**
     * Init logger  in Multimedia Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Constrains to set layout on Criteria Panel
     */
    private GridBagConstraints constraints;

    /**
     * JLabel for duration criteria
     */
    private JLabel duration;

    /**
     * JComboBox<String> for duration criteria
     */
    private JComboBox<String> durationCriteria;

    /**
     * SearchTextField for duration criteria to input data
     */
    private SearchTextField durationTextField;

    /**
     * JComboBox<String> for duration criteria
     */
    private JComboBox<String> durationType;

    /**
     * JLabel for frameRate criteria
     */
    private JLabel frameRate;

    /**
     * JComboCheckBox for frameRate criteria
     */
    private JComboCheckBox frameRateJComboBox;

    /**
     * Vector<JCheckBox> data of CheckBox's to frame rate criteria
     */
    private Vector<JCheckBox> frameRateData;

    /**
     * JLabel for frameRate videoCodec
     */
    private JLabel videoCodec;

    /**
     * JComboCheckBox for videoCodec criteria
     */
    private JComboCheckBox videoCodecJComboBox;

    /**
     * Vector<JCheckBox> data of CheckBox's to video codec criteria
     */
    private Vector<JCheckBox> videoCodecData;

    /**
     * JLabel for frameRate resolution
     */
    private JLabel resolution;

    /**
     * JComboCheckBox for resolution criteria
     */
    private JComboCheckBox resolutionJComboBox;

    /**
     * Vector<JCheckBox> data of CheckBox's to resolution criteria
     */
    private Vector<JCheckBox> resolutionData;

    /**
     * JComboCheckBox, to Bit Rate with many options
     */
    private JComboCheckBox bitRateJComboBox;

    /**
     * Vector, all data for Bit Rate
     */
    private Vector<JCheckBox> bitRateData;

    /**
     * JLabel for frameRate resolution
     */
    private JLabel bitRate;

    /**
     * JComboCheckBox, all data for multimedia type data
     */
    private JComboCheckBox multimediaType;

    /**
     * JLabel for frameRate multimedia type data
     */
    private JLabel multimediaTypeLabel;

    /**
     * Vector, all data for multimedia type data
     */
    private Vector<JCheckBox> multimediaTypeData;

    /**
     * Constructor to Multimedia Panel.
     */
    public MultimediaPanel() {
        LOOGER.info("Get Result Entry");

        // Setting layout to GridBagLayout.
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.frameRateData = new Vector<>();
        this.videoCodecData = new Vector<>();
        this.resolutionData = new Vector<>();
        this.bitRateData = new Vector();
        this.multimediaTypeData = new Vector<>();

        // Calling to initComponents() method.
        this.initComponents();

        // Calling to addComponents() method.
        this.addComponents();

        // repaint
        this.repaint();
        LOOGER.info("Constructor exit");
    }

    /**
     * This method is to initialize all components.
     */
    private void initComponents() {
        LOOGER.info("Get init");

        // Initialize duration criteria
        duration = new JLabel("Duration :");
        durationCriteria = new JComboBox<>();
        durationCriteria.addItem("Major to:");
        durationCriteria.addItem("Minor to:");
        durationCriteria.addItem("Equal to:");
        durationTextField = new SearchTextField("duration input");
        durationType = new JComboBox<>();
        durationType.addItem("Second");
        durationType.addItem("Minute");
        durationType.addItem("Hour");

        // Sample Data
        frameRateData.add(new JCheckBox("All", true));
        frameRateData.add(new JCheckBox("30 fps", false));
        frameRateData.add(new JCheckBox("48 fps", false));
        frameRateData.add(new JCheckBox("50 fps", false));
        frameRateData.add(new JCheckBox("60 fps", false));

        // Initialize Frame Rate criteria
        frameRate = new JLabel("Frame Rate :");
        frameRateJComboBox = new JComboCheckBox(frameRateData);
        frameRateJComboBox.setPreferredSize(new Dimension(200, 34));
        frameRateJComboBox.addActionListener(e -> this.updateFrameRateData());

        // Sample Data
        videoCodecData.add(new JCheckBox("All", true));
        videoCodecData.add(new JCheckBox("H.264", false));
        videoCodecData.add(new JCheckBox("H.263", false));
        videoCodecData.add(new JCheckBox("MPEG-4", false));
        videoCodecData.add(new JCheckBox("MPEG-2", false));

        // Initialize Video Codec
        videoCodec = new JLabel("Video Codec :");
        videoCodecJComboBox = new JComboCheckBox(videoCodecData);
        videoCodecJComboBox.setPreferredSize(new Dimension(200, 34));
        videoCodecJComboBox.addActionListener(e -> this.updateVideoCodecData());

        // Sample Data
        resolutionData.add(new JCheckBox("All", true));
        resolutionData.add(new JCheckBox("4:3 320x240", false));
        resolutionData.add(new JCheckBox("15:9 1280x768", false));
        resolutionData.add(new JCheckBox("25:16 3200x2048", false));

        // Initialize resolution
        resolution = new JLabel("Resolution :");
        resolutionJComboBox = new JComboCheckBox(resolutionData);
        resolutionJComboBox.setPreferredSize(new Dimension(200, 34));
        resolutionJComboBox.addActionListener(e -> this.updateResolutionData());
        LOOGER.info("init exit");

        // Sample Data
        bitRateData.add(new JCheckBox("All", true));
        bitRateData.add(new JCheckBox("16 fps", false));
        bitRateData.add(new JCheckBox("24 fps", false));
        bitRateData.add(new JCheckBox("64 fps", false));
        bitRateData.add(new JCheckBox("96 fps", false));

        // Initialize Audio Bit Rate criteria
        bitRate = new JLabel("Audio Bit Rate:");
        bitRateJComboBox = new JComboCheckBox(bitRateData);
        bitRateJComboBox.setPreferredSize(new Dimension(200, 34));
        bitRateJComboBox.addActionListener(e->this.updateBitRateData());

        // Sample Data
        multimediaTypeData.add(new JCheckBox("All", true));
        multimediaTypeData.add(new JCheckBox("MP4", false));
        multimediaTypeData.add(new JCheckBox("AVI", false));
        multimediaTypeData.add(new JCheckBox("WEB", false));

        // Initialize Multimedia Type criteria
        multimediaTypeLabel = new JLabel("Multimedia Type:");
        multimediaType = new JComboCheckBox(multimediaTypeData);
        multimediaType.setPreferredSize(new Dimension(200, 34));
        multimediaType.addActionListener(e->this.updateMultimediaTypeData());
    }

    /**
     * This method is to update data with event
     */
    private void updateResolutionData() {
        resolutionJComboBox.itemSelected();
    }

    /**
     * This method is to update data with event
     */
    private void updateVideoCodecData() {
        videoCodecJComboBox.itemSelected();
    }

    /**
     * This method is to update data with event
     */
    private void updateFrameRateData() {
        frameRateJComboBox.itemSelected();
    }

    /**
     * This method is to update data with event
     */
    private void updateBitRateData() {
        bitRateJComboBox.itemSelected();
    }

    /**
     * This method is to update data with event
     */
    private void updateMultimediaTypeData() {
        multimediaType.itemSelected();
    }

    /**
     * This method is to add all components.
     */
    private void addComponents() {
        LOOGER.info("init add");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(duration, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(durationCriteria, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(durationTextField, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(durationType, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(frameRate, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(frameRateJComboBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(videoCodec, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(videoCodecJComboBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(resolution, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(resolutionJComboBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(bitRate, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(bitRateJComboBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(multimediaTypeLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(multimediaType, constraints);

        LOOGER.info("add exit");
    }

    /**
     * This method is for return Duration Multimedia critera.
     *
     * @return String, this comparator for multimedia filter.
     */
    public String getDurationMultimediaCriteria() {
        return this.durationCriteria.getModel().getSelectedItem().toString();
    }

    /**
     * This method is for return Duration Multimedia Number.
     *
     * @return String, this is number for filter multimedia files.
     */
    public String getDurationMultimediaNumber() {
        return this.durationTextField.getText();
    }

    /**
     * This method is for return Duration Multimedia Time.
     *
     * @return String, this is type time {seconds,minutes,hours}.
     */
    public String getDurationMultimediaTime() {
        return this.durationType.getModel().getSelectedItem().toString();
    }

    /**
     * This method is for return Frame Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getFrameRateCriteria() {
        ArrayList<String> result = new ArrayList<>();
        frameRateData.forEach(e -> {
            if (e.isSelected()) {
                result.add(e.getText());
            }
        });
        return result;
    }

    /**
     * This method is for return Video Codec Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getVideoCodecCriteria() {
        ArrayList<String> result = new ArrayList<>();
        videoCodecData.forEach(e -> {
            if (e.isSelected()) {
                result.add(e.getText());
            }
        });
        return result;
    }

    /**
     * This method is for return Resolution Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getResolutionCriteria() {
        ArrayList<String> result = new ArrayList<>();
        resolutionData.forEach(e -> {
            if (e.isSelected()) {
                result.add(e.getText());
            }
        });
        return result;
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getAudioRateCriteria() {
        ArrayList<String> result = new ArrayList<>();
        bitRateData.forEach(e -> {
            if (e.isSelected()) {
                result.add(e.getText());
            }
        });
        return result;
    }

    /**
     * This method is for return Audio Rate Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getMultimediaTypeCriteria() {
        ArrayList<String> result = new ArrayList<>();
        multimediaTypeData.forEach(e -> {
            if (e.isSelected()) {
                result.add(e.getText());
            }
        });
        return result;
    }


}
