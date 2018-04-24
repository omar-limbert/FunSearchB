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
public class AudioPanel extends JPanel {
    /**
     * Init logger  in Hidden Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Constrains to set layout on Criteria Panel
     */
    private GridBagConstraints constraints;
    private JLabel bitRate;
    private JComboCheckBox bitRateJComboBox;
    private Vector bitRateData;
    private JLabel audioCodec;
    private JComboCheckBox audioCodecJComboBox;
    private Vector audioCodecData;


    /**
     * Constructor to HiddenPanel.
     * This method is for set layout to FlowLayout, call to iniComponents(), call to addComponents(),
     * and repaint.
     */
    public AudioPanel() {
        LOOGER.info("Get Result Entry");
        // Setting layout to FlowLayout.
        this.constraints = new GridBagConstraints();
        audioCodecData = new Vector();
        bitRateData = new Vector();
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

        // Initialize bitRate criteria
        bitRate = new JLabel("Bit Rate :");

        // Sample Data
        bitRateData.add(new JCheckBox("All", true));
        bitRateData.add(new JCheckBox("16 fps", false));
        bitRateData.add(new JCheckBox("24 fps", false));
        bitRateData.add(new JCheckBox("64 fps", false));
        bitRateData.add(new JCheckBox("96 fps", false));

        // Initialize Audio Bit Rate criteria
        bitRate = new JLabel("Audio Bit Rate:");
        bitRateJComboBox = new JComboCheckBox(bitRateData);
        bitRateJComboBox.setPreferredSize(new Dimension(200,34));

        // Sample Data
        audioCodecData.add(new JCheckBox("All", true));
        audioCodecData.add(new JCheckBox("MP3", false));
        audioCodecData.add(new JCheckBox("WAV", false));
        audioCodecData.add(new JCheckBox("WMA", false));
        audioCodecData.add(new JCheckBox("AAC", false));

        // Initialize Frame Rate criteria
        audioCodec = new JLabel("Audio Bit Rate:");
        audioCodecJComboBox = new JComboCheckBox(audioCodecData);
        audioCodecJComboBox.setPreferredSize(new Dimension(200,34));

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
        this.add(bitRate, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(bitRateJComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(audioCodec, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(audioCodecJComboBox, constraints);
        LOOGER.info("add exit");
    }


}
