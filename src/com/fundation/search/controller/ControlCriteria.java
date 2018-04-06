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

import com.fundation.search.common.Validator;
import com.fundation.search.model.FileResult;
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
    /**
     * searchWindows is the view.
     */
    private MainSearchWindows searchWindows;

    /**
     * Init the constructor.
     * To init the ControlCriteria we need to use the MainSearchWindows class.
     *
     * @param searchWindows is the main window of the app.
     */
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
        validInputs(searchWindows.getPathOfCriteria(), searchWindows.getSearchText(), searchWindows.getHiddenOfCriteria());
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
    private void validInputs(String namePath, String nameFile, String hCriteria) {
        // Init a Validator object.
        Validator validateInputs = new Validator();
        // The path name.
        String validNamePath = null;
        //The file name.
        String validNameFile = null;
        //The file extension.
        String extension = null;
        //The file's size.
        long validFormatSize = -1;
        //the instruccion for the operator.
        char operatorForSize = '=';
        //The instruccion of search a Hidden files.
        String hiddenCriteria = hCriteria;

        if (validateInputs.validatorPath(namePath) && validateInputs.isValidPath(namePath)) {
            validNamePath = namePath;
            if (validateInputs.validatorFile(nameFile)) {
                validNameFile = nameFile;
            }
        }
        //Init a SearchCriteria object with the validated information.
        SearchCriteria searchCriteria = new SearchCriteria(validNamePath, validNameFile, extension, validFormatSize, operatorForSize, hiddenCriteria);
        getResults(searchCriteria);
    }

    /**
     * This method valid add the valid inputs from GUI to SearchCriteria.
     * on a table.
     *
     * @param sc An object that contain all the Inputs from GUI.
     */
    private void getResults(SearchCriteria sc) {
        //Init an Search object.
        Search search = new Search();
        search.setSearchCriteria(sc);
        search.initSearch();
        List<FileResult> result = search.getResultList();
        for (FileResult file : result) {
            searchWindows.insertDataOfJTableResult(new Object[]{file.getName(), file.getPathFile(),file.getIsHidden()});

        }
    }
}
