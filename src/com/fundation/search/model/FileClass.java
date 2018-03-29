package com.fundation.search.model;

public class FileClass {
    String pathFile;
    String nameFile;
    long sizeFile;
    boolean isHiddenFile;

    public FileClass(String pathFile, String nameFile, long sizeFile, boolean isHiddenFile) {
        this.pathFile = pathFile;
        this.nameFile = nameFile;
        this.sizeFile = sizeFile;
        this.isHiddenFile = isHiddenFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public String getName() {
        return nameFile;
    }

    public long getSizeFile() {
        return sizeFile;
    }

    public boolean getIsHidden() {
        return isHiddenFile;
    }
}
