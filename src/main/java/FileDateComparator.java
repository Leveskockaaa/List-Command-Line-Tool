import java.util.Comparator;

public class FileDateComparator implements Comparator<LineFormat> {
    @Override
    public int compare(LineFormat line1, LineFormat line2) {
        if (line1.getFileModified().equals(line2.getFileModified())) return 0;
        return line1.getFileModified().compareTo(line2.getFileModified());
    }
}