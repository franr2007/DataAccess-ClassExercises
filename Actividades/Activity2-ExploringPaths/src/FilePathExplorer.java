
import java.io.File;

public class FilePathExplorer {

    public static void main(String[] args) throws Exception {

        File file = new File("data");
        System.out.println("\nName: " + file.getName());
        if (file.getParent() != null) {
            System.out.println("Directory: " + file.getParent() + "\n");
        } else {
            System.out.println("It dosn't have a parent");
        }

        System.out.println("Original rute: " + file.getPath());
        System.out.println("Absolute rute: " + file.getAbsolutePath());
        System.out.println("Absolute rute (File): " + file.getAbsoluteFile());
        System.out.println("Canon rute: " + file.getCanonicalPath());
        if (file.isAbsolute()) {
            System.out.println("Is an absolute rute");
        } else {
            System.out.println("Is a relative rute");
        }
        System.out.println("Exists?: " + (file.exists() ? "yes" : "no"));
        if (file.isFile()) {
            System.out.println("Is a file");
            System.out.println("Size: " + file.length() + " bytes");
        } else if (file.isDirectory()) {
            System.out.println("Is a directory");
        } else {
            System.out.println("The route could not be recognized");
        }

        System.out.println("Last modified: " + file.lastModified() + " ms");

        File file2= new File("data\\students.txt");

        System.out.println("\n\n'File2'");
        System.out.println("Original rute: "+file2.getPath());
        System.out.println("Absolute path: "+file2.getAbsolutePath());
        System.out.println("Canon path: "+file2.getCanonicalPath());
    }
}
