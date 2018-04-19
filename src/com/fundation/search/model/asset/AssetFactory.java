package com.fundation.search.model.asset;

import java.nio.file.attribute.FileTime;

public class AssetFactory {


    public Asset buildAsset(String assetType, String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, boolean readFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, String ownerFile, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String intoFile, String extensionFile) {
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("file")) {
            return new FileResult ( pathFile,  nameFile,  sizeFile,  isHiddenFile,  readFile,  lastModifiedTime,  creationTime,  lastAccessTime,  ownerFile,  isReadOnly,  isFileSystem,  isDirectory,  intoFile,  extensionFile);
        }
        /*if (assetType.equalsIgnoreCase("multimedia")) {
            return new ResultMultimediaFile(path, fileName, hidden, duration, typeFile);
        }
        if (assetType.equalsIgnoreCase("directory")) {
            return new ResultDirectory(path, fileName, hidden, readOnly, typeFile);
        }*/
        return null;
    }
}