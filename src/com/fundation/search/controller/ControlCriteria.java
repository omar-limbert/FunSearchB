/*
 * @(#)ControlCriteria.java
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


package com.fundation.search.controller;

import com.fundation.search.model.FileClass;
import com.fundation.search.model.Search;
import com.fundation.search.view.MainSearchWindows;

import java.util.List;

/**
 * This class is made the control between View and Model.
 *
 * @author Ariel Gonzales Vargas - AT-[06].
 * @version 1.0.
 */
public class ControlCriteria {
    private MainSearchWindows searchWindows;

    public ControlCriteria(MainSearchWindows searchWindows) {
        this.searchWindows = searchWindows;
        searchWindows.initWindows();
        searchWindows.getSearchButton().addActionListener(e -> listenSearchButton());
    }

    /**
     * This method check the event of the button "search".
     * then the inputs are insert for validate.
     */
    private void listenSearchButton() {
        searchWindows.resetDataOfJTableResult();
        validInputs(searchWindows.getPathOfCriteria(), searchWindows.getSearchText());
    }

    /**
     * This method valid the inputs from GUI.
     * Before to make an add the inputs to searchCriterial.
     * <p>
     * For the first sprint we only just use the search by path.
     * and search by file name.
     * So the others attributes are empty by the default.
     *
     * @param namePath validate the inputs of the name path on GUI.
     * @param nameFile validate the input of the FieldName on GUI..
     */
    private void validInputs(String namePath, String nameFile) {

        Validator validateInputs = new Validator();
        String validNamePath = null;
        String validNameFile = null;
        String extension = null;
        long validFormatSize = -1;
        char operatorForSize = '.';
        boolean isHidden = false;

        if (validateInputs.validatorPath(namePath) && validateInputs.isValidPath(namePath)) {
            validNamePath = namePath;
            if (validateInputs.validatorFile(nameFile)) {
                validNameFile = nameFile;
            }
        }
        SearchCriteria searchCriteria = new SearchCriteria(validNamePath, validNameFile, extension, validFormatSize, operatorForSize, isHidden);
        getResults(searchCriteria);

    }

    /**
     * This method valid add the valid inputs from GUI to SearchCriteria.
     * on a table.
     *
     * @param sc An object that contain all the Inputs from GUI.
     */
    private void getResults(SearchCriteria sc) {
        Search search = new Search();
        search.setSearchCriteria(sc);
        search.initSearch();
        List<FileClass> fileClasses = search.getResultList();
        for (FileClass fileClass : fileClasses) {
            searchWindows.insertDataOfJTableResult(new Object[]{fileClass.getName(), fileClass.getPathFile()});
        }
    }
}
