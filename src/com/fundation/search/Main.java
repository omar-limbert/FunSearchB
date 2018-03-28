package com.fundation.search;

import com.fundation.search.view.MainSearchWindows;

import javax.swing.*;

/**
 * Main class .
 */
public class Main {

    /**
     * Constructor for CentralPanel.
     *
     * @param args
     */
    public static void main(String[] args) {

        final int width = 600;
        final int height = 400;

        MainSearchWindows windows = new MainSearchWindows();
        windows.initWindows("Search Application");
        windows.setSize(width, height);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setVisible(true);
    }
}
