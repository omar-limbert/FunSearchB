/*
 * @(#)SearchTextField.java
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
package com.fundation.search.view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * This class is for create JTexField with place holder.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class SearchTextField extends JTextField {


    private String placeHolderText;
    private Color placeHolderColor;
    private boolean band;
    private boolean disable;

    /**
     * Constructor for SearchTextField.
     *
     * @param placeHolderText This is text for place holder.
     */
    public SearchTextField(String placeHolderText) {

        super();

        this.initComponents(placeHolderText);

        //Mapping changes on textField.
        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                band = getText().length() <= 0;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                band = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }

        });
    }

    /**
     * This method is for initialize all variables.
     *
     * @param placeHolderText This is a text for place holder.
     */
    private void initComponents(String placeHolderText) {

        final int three = 3;
        final int zero = 0;
        final int six = 6;
        final int width = 300;
        final int height = 32;


        Dimension dimension = new Dimension(width, height);
        this.placeHolderText = placeHolderText;
        this.placeHolderColor = new Color(zero, zero, zero);
        this.band = true;


        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setMargin(new Insets(three, six, three, six));
        this.setPlaceHolderText(placeHolderText);
    }

    /**
     * This method is for initialize all variables.
     *
     * @param placeHolderText This is a text for place holder.
     */
    public void setPlaceHolderText(String placeHolderText) {
        this.placeHolderText = placeHolderText;
    }

    /**
     * This method is for initialize all variables.
     *
     * @param placeHolderColor This is a text for place holder.
     */
    public void setPlaceHolderColor(Color placeHolderColor) {
        this.placeHolderColor = placeHolderColor;
    }

    @Override
    public void paintComponent(Graphics g) {

        final int number90 = 90;
        final int number2 = 2;
        super.paintComponent(g);
        // Color for place holder.
        g.setColor(
                new Color(placeHolderColor.getRed(),
                        placeHolderColor.getGreen(),
                        placeHolderColor.getBlue(), number90));
        // Drawing text.
        g.drawString((band) ? placeHolderText : "", getMargin().left,
                (getSize().height) / number2 + getFont().getSize() / number2);
    }

}
