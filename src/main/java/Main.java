import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        File[] files = currentDirectory.listFiles();

        if (files == null) {
            System.out.println("No files found");
            return;
        }

        int maxLength = 0;
        for (File file : files) {
            if (file.isHidden()) continue;
            if (String.valueOf(file.length()).length() > maxLength) {
                maxLength = String.valueOf(file.length()).length();
            }
        }

        List<LineFormat> lines = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (File file : files) {
            if (file.isHidden()) continue;

            String permission = (file.isDirectory() ? "d" : "-") + (file.canRead() ? "r" : "-") + (file.canWrite() ? "w" : "-") + (file.canExecute() ? "x" : "-");
            String modified = sdf.format(new Date(file.lastModified()));
            long length = file.length();
            String name = file.getName();

            lines.add(new LineFormat(permission, modified, length, maxLength, name));
        }

        lines.sort(new FileNameComparator());

        for (LineFormat lineFormat : lines) {
            System.out.println(lineFormat);
        }
    }
}