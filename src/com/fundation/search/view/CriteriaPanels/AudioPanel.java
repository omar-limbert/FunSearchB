/*
 * @(#)AudioPanel.java
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


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * This class is to create the Audio panel criteria
 *
 * @author Omar Limbert Huanca Sanchez- AT-[06].
 * @version 1.0.
 */
public class AudioPanel extends JPanel {
    /**
     * Logger, Init logger  in Hidden Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * Constrains, to set layout on Criteria Panel
     */

    private GridBagConstraints constraints;

    /**
     * JLabel, to Bit Rate
     */
    private JLabel bitRate;

    /**
     * JComboCheckBox, to Bit Rate with many options
     */
    private JComboCheckBox bitRateJComboBox;

    /**
     * Vector, all data for Bit Rate
     */
    private Vector<JCheckBox> bitRateData;

    /**
     * JLabel, to Audio Codec
     */
    private JLabel audioCodec;

    /**
     * JComboCheckBox, to Bit Rate with many options
     */
    private JComboCheckBox audioCodecJComboBox;

    /**
     * Vector, all data for Audio Codec
     */
    private Vector<JCheckBox> audioCodecData;


    /**
     * Constructor to Audio Panel.
     *
     */
    public AudioPanel() {
        LOOGER.info("Get Result Entry");

        // Setting layout to GridBagLayout.
        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();

        // Vector with data from JComboBox's
        audioCodecData = new Vector();
        bitRateData = new Vector();

        // Calling to initComponents() method
        this.initComponents();

        // Calling to addComponents() method
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
        bitRateJComboBox.setPreferredSize(new Dimension(200, 34));
        bitRateJComboBox.addActionListener(e->this.updateBitRateData());

        // Sample Data
        audioCodecData.add(new JCheckBox("All", true));
        audioCodecData.add(new JCheckBox("MP3", false));
        audioCodecData.add(new JCheckBox("WAV", false));
        audioCodecData.add(new JCheckBox("WMA", false));
        audioCodecData.add(new JCheckBox("AAC", false));

        // Initialize Frame Rate criteria
        audioCodec = new JLabel("Audio Bit Rate:");
        audioCodecJComboBox = new JComboCheckBox(audioCodecData);
        audioCodecJComboBox.setPreferredSize(new Dimension(200, 34));
        audioCodecJComboBox.addActionListener(e->this.updateAudioCodecData());

        LOOGER.info("init exit");
    }

    /**
     * This method is to update data with event
     */
    private void updateAudioCodecData() {
        audioCodecJComboBox.itemSelected();
    }

    /**
     * This method is to update data with event
     */
    private void updateBitRateData() {
        bitRateJComboBox.itemSelected();
    }

    /**
     * This method is to add all components.
     *
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
     * This method is for return Audio Format Array.
     *
     * @return String[], this is String array with selected values.
     */
    public ArrayList<String> getAudioFormatCriteria() {
        ArrayList<String> result = new ArrayList<>();
        audioCodecData.forEach(e -> {
            if (e.isSelected()) {
                result.add(e.getText());
            }
        });
        return result;
    }
}
