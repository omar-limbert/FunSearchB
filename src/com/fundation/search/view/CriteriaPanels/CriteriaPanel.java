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
package com.fundation.search.view.CriteriaPanels;

import javax.swing.*;
import java.util.Map;

/**
 * This class is for create Criteria Panel with all sub-panels.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class CriteriaPanel extends JPanel {


    /**
     * Constructor for TopPanel.
     * This is text for place holder.
     */
    public CriteriaPanel() {


        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxlayout);
        this.initComponents();
        this.revalidate();
        this.repaint();


    }

    /**
     * This method is for initialize all components.
     */
    private void initComponents() {


    }

    /**
     * This method is for add all components.
     *
     * @param panelList This is Map with all criteria panels.
     */
    public void addComponent(Map<String, JPanel> panelList) {
        this.removeAll();

        for (Map.Entry<String, JPanel> entry : panelList.entrySet()) {
            this.add(entry.getValue());

        }
        this.revalidate();
        this.repaint();


    }

}
