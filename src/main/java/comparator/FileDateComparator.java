package comparator;

import java.util.Comparator;

import model.FileInfo;

public class FileDateComparator implements Comparator<FileInfo> {
    @Override
    public int compare(FileInfo first, FileInfo second) {
        if (first.getFileModified().equals(second.getFileModified())) return 0;
        return second.getFileModified().compareTo(first.getFileModified());
    }
}