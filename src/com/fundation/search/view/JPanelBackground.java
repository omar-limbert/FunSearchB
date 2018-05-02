/*
 * @(#)JPanelBackground.java
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
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * This class JPanelBackground.
 *
 * @author Omar Limbert Huanca Sanchez - AT-[06].
 * @version 1.0.
 */
public class JPanelBackground extends javax.swing.JPanel {

    /**
     * Image of view.
     */
    ImageIcon imagen;

    /**
     * This method return JPanelBackground.
     *
     * @param nombre, this is String of JPanelBackground.
     */
    public JPanelBackground(String nombre) {
        initComponents();
        imagen= new ImageIcon(nombre);
        setSize(imagen.getIconWidth(),imagen.getIconHeight());

    }

    /**
     * This method return paintComponent.
     *
     * @param g, this is Graphics of paintComponent.
     */
       @Override
       protected void paintComponent(Graphics g){
       Dimension d=getSize();
       g.drawImage(imagen.getImage(), 0, 0, d.width,  d.height, null);
       this.setOpaque(false);
       super.paintComponent(g);

       }

    /**
     * This method is for init Components.
     */
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
