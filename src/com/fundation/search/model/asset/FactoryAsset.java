package com.fundation.search.model.asset;

import java.nio.file.attribute.FileTime;
//
public class FactoryAsset {

    public Asset buildAsset(String assetType, String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, boolean isReadOnly, boolean isFileSystem, String extensionFile) {
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("file")) {
            return new FileResult(pathFile,nameFile,sizeFile,isHiddenFile,lastModifiedTime,creationTime,lastAccessTime,isReadOnly,isFileSystem,extensionFile);
        }
        if (assetType.equalsIgnoreCase("multimedia")) {
            return new FileResult(pathFile,nameFile,sizeFile,isHiddenFile,lastModifiedTime,creationTime,lastAccessTime,isReadOnly,isFileSystem,extensionFile);
        }

        return null;
    }

}
