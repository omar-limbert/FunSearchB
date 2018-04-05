package com.fundation.search;

import com.fundation.search.controller.ControlCriteria;
import com.fundation.search.view.MainSearchWindows;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) {

        MainSearchWindows searchWindow = new MainSearchWindows();
        ControlCriteria controlCriteria = new ControlCriteria(searchWindow);

    }
}
