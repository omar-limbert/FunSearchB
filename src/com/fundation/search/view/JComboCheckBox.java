/*
 * @(#)JComboCheckBox.java
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

import com.fundation.search.common.SearchLogger;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * This class is for create JComboBox with JCheckBox.
 *
 * @author Internet.
 * @author Omar Limbert Huanca Sanchez.
 * @version 1.0.
 */
public class JComboCheckBox extends JComboBox {
    /**
     * Init logger  in Main Search Panel
     */
    private static final Logger LOOGER = SearchLogger.getInstanceOfLogger().getLogger();

    /**
     * selected, currently checkbox selected
     */
    private JCheckBox selected;

    /**
     * This method return Search JButton.
     *
     * @param items, this is vector of JCheckBox's.
     */
    public JComboCheckBox(Vector items) {
        super(items);
        init();
    }

    /**
     * This method is for init action.
     *
     */
    private void init() {
        LOOGER.info("init");
        setRenderer(new ComboBoxRenderer());
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                getItemSelected();
            }
        });
        LOOGER.info("end");
    }

    /**
     * this method is for change state of JCheckBox.
     *
     */
    public void itemSelected() {
        LOOGER.info("itemSelected init");
        if (getSelectedItem() instanceof JCheckBox) {
            selected = (JCheckBox) getSelectedItem();
            selected.setSelected(!selected.isSelected());

        }
        LOOGER.info("itemSelected end");
    }

    /**
     * This method return selected JCheckBox.
     *
     * @return Vector, this is vector of JCheckBox's.
     */
    public JCheckBox getItemSelected() {
        LOOGER.info("itemSelected init");
        LOOGER.info("itemSelected end");
        return selected;
    }

    /**
     * This class is for create JComboBox with JCheckBox.
     *
     * @author Internet.
     * @author Omar Limbert Huanca Sanchez.
     * @version 1.0.
     */
    class ComboBoxRenderer implements ListCellRenderer {

        /**
         * label, This from combobox
         */
        private JLabel label;

        /**
         * This method is from ComboBoxRenderer.
         *
         */
        public ComboBoxRenderer() {
            setOpaque(true);
        }

        /**
         * This method is for return Component.
         *
         * @return Component
         */
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Component) {
                Component c = (Component) value;
                if (isSelected) {
                    c.setBackground(list.getSelectionBackground());
                    c.setForeground(list.getSelectionForeground());
                } else {
                    c.setBackground(list.getBackground());
                    c.setForeground(list.getForeground());
                }

                return c;
            } else {
                if (label == null) {
                    label = new JLabel(value.toString());
                } else {
                    label.setText(value.toString());
                }

                return label;
            }
        }
    }
}
