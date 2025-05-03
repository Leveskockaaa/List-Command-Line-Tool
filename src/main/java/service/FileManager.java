package service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import comparator.FileDateComparator;
import comparator.FileNameComparator;
import comparator.FileSizeComparator;
import model.FileInfo;
import model.FileType;

public class FileManager {
    private final List<FileInfo> listOfFiles = new ArrayList<>();
    private final List<File> files;
    List<String> arguments;

    public FileManager(File[] files, String[] arguments) {
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
        long maxLength = 0;
        for (File file : files) {
            if (String.valueOf(file.length()).length() > maxLength) {
                maxLength = String.valueOf(file.length()).length();
            }
        }
        FileInfo.setMaxLength(maxLength);
    }

    public void selectFiles() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (File file : files) {
            String permission = (file.isDirectory() ? "d" : "-") + (file.canRead() ? "r" : "-") + (file.canWrite() ? "w" : "-") + (file.canExecute() ? "x" : "-");
            String modified = sdf.format(new Date(file.lastModified()));
            long length = file.length();
            String name = file.getName();
            FileType type = FileType.getFileType(file);

            listOfFiles.add(new FileInfo(type, permission, modified, length, name));
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
        for (FileInfo line : listOfFiles) {
            System.out.println(line);
        }
    }
}