/*
 * @(#)HiddenPanel.java
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

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * This class is to create the configuration for Hidden button.
 *
 * @author Escarleth Ledezma Quiroga - AT-[06].
 * @version 1.0.
 */
public class MultimediaPanel extends JPanel {
    /**
     * Init logger  in Hidden Panel
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
     * JLabel for duration criteria
     */
    private JComboBox<String> durationType;

    private JLabel frameRate;
    private JComboCheckBox frameRateJComboBox;
    private Vector frameRateData;

    private JLabel videoCodec;
    private JComboCheckBox videoCodecJComboBox;
    private Vector videoCodecData;

    private JLabel resolution;
    private JComboCheckBox resolutionJComboBox;
    private Vector resolutionData;


    /**
     * Constructor to HiddenPanel.
     * This method is for set layout to FlowLayout, call to iniComponents(), call to addComponents(),
     * and repaint.
     */
    public MultimediaPanel() {
        LOOGER.info("Get Result Entry");
        // Setting layout to FlowLayout.
        this.frameRateData = new Vector();
        this.videoCodecData = new Vector();
        this.resolutionData = new Vector();
        this.constraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        // Calling to initComponents() method.
        this.initComponents();
        // Calling to addComponents() method.
        this.addComponents();
        // repaint.
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
        frameRateJComboBox.setPreferredSize(new Dimension(200,34));

        // Sample Data
        videoCodecData.add(new JCheckBox("All", true));
        videoCodecData.add(new JCheckBox("MP4", false));
        videoCodecData.add(new JCheckBox("AVI", false));
        videoCodecData.add(new JCheckBox("WEB", false));


        // Initialize Video Codec
        videoCodec = new JLabel("Video Codec :");
        videoCodecJComboBox = new JComboCheckBox(videoCodecData);
        videoCodecJComboBox.setPreferredSize(new Dimension(200,34));

        // Sample Data
        resolutionData.add(new JCheckBox("All", true));
        resolutionData.add(new JCheckBox("4:3", false));
        resolutionData.add(new JCheckBox("16:9", false));
        resolutionData.add(new JCheckBox("21:9", false));

        // Initialize resolution
        resolution = new JLabel("Resolution :");
        resolutionJComboBox = new JComboCheckBox(resolutionData);
        resolutionJComboBox.setPreferredSize(new Dimension(200,34));
        LOOGER.info("init exit");
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

        LOOGER.info("add exit");
    }


}
