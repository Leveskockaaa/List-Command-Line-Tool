import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        File[] files = currentDirectory.listFiles();

        if (files == null) {
            System.out.println("No files found");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (File file : files) {
            if (file.isHidden()) continue;
            String name = file.getName();
            String lastModified = sdf.format(new Date(file.lastModified()));
            String permissions = (file.canRead() ? "r" : "-") + (file.canWrite() ? "w" : "-") + (file.canExecute() ? "x" : "-");
            System.out.println("> " + permissions + " " + lastModified + " " + name);
        }
    }
}