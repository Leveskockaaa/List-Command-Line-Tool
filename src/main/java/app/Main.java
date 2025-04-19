package app;

import java.io.File;
import java.util.List;

import service.FileManager;

public class Main {
    static List<String> validShowArguments = List.of( "-hidden", "-dirs" );
    static List<String> validSortArguments = List.of( "-size", "-date" );

    public static void main(String[] args) {
        File currentDirectory = new File(".");
        File[] files = currentDirectory.listFiles();

        if (files == null) {
            System.err.println("> No files found");
            return;
        }

        int sortArguments = 0;
        for (String argument : args) {
            if (!validShowArguments.contains(argument) && !validSortArguments.contains(argument)) {
                System.err.println("> Invalid arguments");
                return;
            }
            if (validSortArguments.contains(argument)) {
                sortArguments++;
            }
        }
        if (sortArguments > 1) {
            System.err.println("> Only one sort argument is allowed");
            return;
        }
        
        FileManager listOfFiles = new FileManager(files, args);
        listOfFiles.filterFiles();
        listOfFiles.calculateMaxLength();
        listOfFiles.selectFiles();
        listOfFiles.sortFiles();
        listOfFiles.printFiles();
    }
}