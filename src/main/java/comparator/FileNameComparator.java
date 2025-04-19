package comparator;

import java.util.Comparator;

import model.FileInfo;

public class FileNameComparator implements Comparator<FileInfo> {
    @Override
    public int compare(FileInfo first, FileInfo second) {
        if (first.getFileName().equals(second.getFileName())) return 0;
        return first.getFileName().compareTo(second.getFileName());
    }
}
