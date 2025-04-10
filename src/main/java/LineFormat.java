public class LineFormat {
    private final String filePermission;
    private final String fileModified;
    private final long fileSize;
    private final long maxLength;
    private final String fileName;

    public LineFormat(String filePermission, String fileModified, long fileSize, long maxLength, String fileName) {
        this.filePermission = filePermission;
        this.fileModified = fileModified;
        this.fileSize = fileSize;
        this.maxLength = maxLength;
        this.fileName = fileName;
    }

    public String toString() {
        int difference = (int)(maxLength - String.valueOf(fileSize).length());
        return "> " + filePermission + " " + fileModified + " " + " ".repeat(difference) + fileSize + " " + fileName;
    }
}
