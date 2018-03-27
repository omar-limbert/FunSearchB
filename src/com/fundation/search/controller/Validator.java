package com.fundation.search.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public Validator() {
    }

    public boolean validatorPath(String path) {
        Pattern pat = Pattern.compile("(^[A-Z]:)?((\\\\)\\w+((\\s|\\.)\\w+)*)+");
        Matcher mat = pat.matcher(path);
        return mat.matches();
    }

    public boolean validatorFile(String file) {
        Pattern pat = Pattern.compile("(\\w+(\\s|[^:*?\"<>|]\\w+)*)+");
        Matcher mat = pat.matcher(file);
        return mat.matches();
    }

    public boolean validatorType(String type){
        Pattern pat = Pattern.compile("^\\.[a-z]{3,4}");
        Matcher mat = pat.matcher(type);
        return mat.matches();
    }

    public boolean validatorDate(String date) {
        Pattern pat = Pattern.compile("\\d{1,2}\\/\\d{2}\\/\\d{2,4}");
        Matcher mat = pat.matcher(date);
        return mat.matches();
    }

}
