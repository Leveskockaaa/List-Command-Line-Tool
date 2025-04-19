package comparator;

import java.util.Comparator;

import model.FileInfo;

public class FileSizeComparator implements Comparator<FileInfo> {
    @Override
    public int compare(FileInfo first, FileInfo second) {
        if (first.getFileSize() == second.getFileSize()) return 0;
        return first.getFileSize() < second.getFileSize() ? 1 : -1;
    }
}
