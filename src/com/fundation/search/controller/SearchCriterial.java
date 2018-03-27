package com.fundation.search.controller;

public class SearchCriterial {

    private String path;
    private String name;
    private String type;
    private String size;


    public SearchCriterial(String path, String name, String type) {
        this.path = (path != "") ? path : "";
        this.name = (name != "") ? name : "";
        this.type = (type != "") ? type : "";
        //this.size = (size != "") ? size : "";
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }
}
