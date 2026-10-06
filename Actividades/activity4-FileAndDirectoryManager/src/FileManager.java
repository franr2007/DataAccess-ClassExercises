
import java.io.File;
import java.io.FilenameFilter;

public class FileManager {

    public static void main(String[] args) throws Exception {
        File directory = new File("workspace");
        File notes = new File(directory, "notes.txt");
        File data = new File(directory, "data.txt");
        File image = new File(directory, "image.jpg");
        if (!directory.exists()) {
            if (directory.mkdir()){
                System.out.println("Directory workspace created");
            } else System.out.println("Directory couldn't be created or already exits");
            if (notes.createNewFile()) {
                System.out.println("notes.txt created");
            }else System.out.println("notes.txt couldn't be created or already exits");

            if (data.createNewFile()) {
                System.out.println("data.txt created");
            }else System.out.println("data.txt couldn't be created or already exits");

            if (image.createNewFile()) {
                System.out.println("image.jpg created");
            }else System.out.println("image.jpg couldn't be created or already exits");
        }
        else{
            System.out.println("The directory couldn't be created or already exits");
        }

        System.out.println("\nLisiting all files: ");

        String[] files = directory.list();

        for (String file : files) {
            System.out.println(file);
        }

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        files = directory.list(filter);

        System.out.println("\nFiles with an '.txt' ext: ");

        for (String file : files) {
            System.out.println(file);
        }

        File students = new File(directory, "students.txt");
        if (data.renameTo(students)) {
            System.out.println("\ndata.txt went renamed to students.txt");
        }

        files = directory.list(filter);

        for (String file : files) {
            System.out.println(file);
        }

        if (notes.delete()) {
            System.out.println("\nnotes.txt deleted correctly");
        }
        else System.out.println("\nnotes.txt couldn't be deleted");
        if (image.delete()) {
            System.out.println("\nimage.jpg deleted correctly");
        }
        else System.out.println("\nimage.jpg couldn't be deleted");
    }
}
