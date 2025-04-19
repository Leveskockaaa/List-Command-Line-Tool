package model;

public class FileInfo {
    private final String filePermission;
    private final String fileModified;
    private final long fileSize;
    private static long maxLength;
    private final String fileName;

    public FileInfo(String filePermission, String fileModified, long fileSize, String fileName) {
        this.filePermission = filePermission;
        this.fileModified = fileModified;
        this.fileSize = fileSize;
        this.fileName = fileName;
    }

    public String getFileModified() {
        return fileModified;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public static void setMaxLength(long length) {
        maxLength = length;
    }

    @Override
    public String toString() {
        int difference = (int)(maxLength - String.valueOf(fileSize).length());
        return "> " + filePermission + " " + fileModified + " " + " ".repeat(difference) + fileSize + " " + fileName;
    }
}
