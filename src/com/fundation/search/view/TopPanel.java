/*
 * @(#)TopPanel.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * Address
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.fundation.search.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * This class is for create Top Panel.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class TopPanel extends JPanel {

    private SearchTextField searchTextField;
    private JToolBar toolbar;

    /**
     * Constructor for TopPanel.
     * @param placeHolderText
     * This is text for place holder.
     */
    public TopPanel(String placeHolderText) {

        final int three = 3;
        final int one = 1;
        this.setLayout(new GridLayout(three, one));
        this.initComponents(placeHolderText);
        this.addComponents();
        this.repaint();
    }
    /**
     * This method is for initialize all components.
     * @param placeHolderText
     * This is text for place holder.
     */
    public void initComponents(String placeHolderText) {
        this.searchTextField = new SearchTextField(placeHolderText);
        this.toolbar = new SearchToolBar();


    }
    /**
     * This method is for add all components.
     */
    public void addComponents() {
        this.add(searchTextField);
        this.add(toolbar);
    }

}
