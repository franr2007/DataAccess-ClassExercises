
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        File file = new File("messages.txt");
        Scanner sc = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        String[] contenido = {

        };

        for (String frase : contenido) {
            
        }

        long frases = file.length() / 40;
        System.out.println("");



    }
}
