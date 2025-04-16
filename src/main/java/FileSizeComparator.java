import java.util.Comparator;

public class FileSizeComparator implements Comparator<LineFormat> {
    @Override
    public int compare(LineFormat line1, LineFormat line2) {
        if (line1.getFileSize() == line2.getFileSize()) return 0;
        return line1.getFileSize() < line2.getFileSize() ? 1 : -1;
    }
}
