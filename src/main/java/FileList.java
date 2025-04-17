import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FileList {
    private final List<LineFormat> listOfFiles = new ArrayList<>();
    private final List<File> files;
    List<String> arguments;
    private int maxLength = 0;

    public FileList(File[] files, String[] arguments) {
        this.files = new ArrayList<>(Arrays.asList(files));
        this.arguments = new ArrayList<>(Arrays.asList(arguments));
    }

    public void filterFiles() {
        Iterator<File> fileIterator = files.iterator();
        while (fileIterator.hasNext()) {
            File file = fileIterator.next();
    
            boolean remove = false;
            if (!arguments.contains("-hidden") && file.isHidden()) {
                remove = true;
            }    
            if (arguments.contains("-dirs") && !file.isDirectory()) {
                remove = true;
            }
            if (remove) {
                fileIterator.remove();
            }
        }
    }
    

    public void calculateMaxLength() {
        for (File file : files) {
            if (file.isHidden()) continue;
            if (String.valueOf(file.length()).length() > maxLength) {
                maxLength = String.valueOf(file.length()).length();
            }
        }
    }

    public void selectFiles() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (File file : files) {
            String permission = (file.isDirectory() ? "d" : "-") + (file.canRead() ? "r" : "-") + (file.canWrite() ? "w" : "-") + (file.canExecute() ? "x" : "-");
            String modified = sdf.format(new Date(file.lastModified()));
            long length = file.length();
            String name = file.getName();

            listOfFiles.add(new LineFormat(permission, modified, length, maxLength, name));
        }
    }

    public void sortFiles() {
        if (arguments.contains("-size")) {
            listOfFiles.sort(new FileSizeComparator());
            return;
        }
        if (arguments.contains("-date")) {
            listOfFiles.sort(new FileDateComparator());
            return;
        }
        listOfFiles.sort(new FileNameComparator());
    }

    public void printFiles() {
        for (LineFormat line : listOfFiles) {
            System.out.println(line);
        }
    }
}
