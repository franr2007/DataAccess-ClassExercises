
import java.io.File;

public class App {

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.println("The path doesn't exists");
        } else {
            System.out.println("Original path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Canonical path: " + file.getCanonicalPath());
            System.out.println("Name: " + file.getName());
            System.out.println("Parent: " + file.getParent());
            if (file.isFile()) {
                System.out.println("File size: "+file.length());
                System.out.println("File is hidden?: "+ (file.isHidden() ? "yes" : "no"));
                System.out.println("File date & time last modifed: "+file.lastModified());
            }
        }

    }
}
