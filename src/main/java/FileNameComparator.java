import java.util.Comparator;

public class FileNameComparator implements Comparator<LineFormat> {
    @Override
    public int compare(LineFormat line1, LineFormat line2) {
        if (line1.getFileName().equals(line2.getFileName())) return 0;
        return line1.getFileName().compareTo(line2.getFileName());
    }
}
