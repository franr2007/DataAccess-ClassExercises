import java.io.FileInputStream;
import java.io.IOException;

public class readFile {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("example.txt")) {

            int _byte;

            while ((_byte = fis.read()) != -1) {
                System.out.print((char) _byte);
            }

        } catch (IOException ioe) {
            System.out.println("Error reading the file: " + ioe.getMessage());
        }
    }
}