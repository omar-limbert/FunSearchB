package com.fundation.search;

import com.fundation.search.controller.ControlCommand;
import com.fundation.search.controller.ControlCriteria;
import com.fundation.search.view.MainSearchWindows;

import java.io.File;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) {
        MainSearchWindows searchWindow = new MainSearchWindows();
        ControlCriteria controlCriteria;

        ControlCommand controlCommand;

        if (args.length > 0) {
            controlCommand = new ControlCommand(args);
        } else {
            controlCriteria = new ControlCriteria(searchWindow);
        }
    }
    
}
