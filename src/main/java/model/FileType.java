package model;

import java.io.File;

public enum FileType {
    HIDDEN("\u001B[33m"),       //Yellow
    DIRECTORY("\u001B[34m"),    // Blue
    FILE("\u001B[32m");         // Green

    private final String colorCode;

    FileType(String colorCode) {
        this.colorCode = colorCode;
    }

    public static FileType getFileType(File file) {
        if (file.isHidden()) return HIDDEN;
        if (file.isDirectory()) return DIRECTORY;
        return FILE;
    }

    public String getColorCode() {
        return colorCode;
    }
}