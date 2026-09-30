
import java.io.File;

public class App {

    public static void main(String[] args) {

        File directory1 = new File("folder1");

        if (directory1.mkdir()) {
            System.out.println("folder1 was created.");
        } else {
            System.out.println("folder1 could not be created.");
        }

        File directory2 = new File("folder2/../folder3/../folder4");

        if (directory2.mkdirs()) {
            System.out.println("folder2/subfolder/data was created.");
        } else {
            System.out.println("Directories could not be created.");
        }
    }
}
