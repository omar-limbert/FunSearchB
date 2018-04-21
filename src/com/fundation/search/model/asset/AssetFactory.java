package com.fundation.search.model.asset;

import java.nio.file.attribute.FileTime;

public class AssetFactory {


    public Asset buildAsset(String assetType, String pathFile, String nameFile, long sizeFile, boolean isHiddenFile, boolean readFile, FileTime lastModifiedTime, FileTime creationTime, FileTime lastAccessTime, String ownerFile, boolean isReadOnly, boolean isFileSystem, boolean isDirectory, String intoFile, String extensionFile, int cantFile, double duration){
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("file")) {
            return new FileResult(pathFile, nameFile, sizeFile, isHiddenFile, readFile, lastModifiedTime, creationTime, lastAccessTime, ownerFile, isReadOnly, isFileSystem, isDirectory, intoFile, extensionFile);
        }
        if (assetType.equalsIgnoreCase("folder")) {
            return new FolderResult(pathFile, nameFile, sizeFile, isHiddenFile, readFile, lastModifiedTime, creationTime, lastAccessTime, ownerFile, isReadOnly, isFileSystem, isDirectory, intoFile, cantFile);
        }
        if (assetType.equalsIgnoreCase("multimedia")) {
            return new MultimediaResult(pathFile, nameFile, sizeFile, isHiddenFile, readFile, lastModifiedTime, creationTime, lastAccessTime, ownerFile, isReadOnly, duration);
        }
        return null;
    }
}