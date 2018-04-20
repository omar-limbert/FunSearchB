package com.fundation.search.model.asset;

import java.nio.file.attribute.FileTime;

public class FolderResult extends Asset{
    private int cantFiles;

    public FolderResult (String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, boolean readFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, String ownerFile, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String intoFile){
        super( pathFile,  nameFile,  sizeFile,  isHiddenFile,  readFile,  lastModifiedTime,  creationTime,  lastAccessTime,  ownerFile,  isReadOnly,  isFileSystem,  isDirectory,  intoFile);
        this.cantFiles= cantFiles;
    }
    public int getCantFiles() {
        return cantFiles;
    }
}
