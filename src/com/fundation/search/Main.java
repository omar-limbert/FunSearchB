package com.fundation.search;

import com.fundation.search.controller.ControlCriteria;
import com.fundation.search.controller.SearchCriteria;
import com.fundation.search.model.Search;
import com.fundation.search.view.MainSearchWindows;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) {

        MainSearchWindows searchWindow = new MainSearchWindows();
        ControlCriteria controlCriteria = new ControlCriteria(searchWindow);



    }
}
