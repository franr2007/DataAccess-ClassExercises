
import java.io.RandomAccessFile;
import java.util.Scanner;

public class WriteText {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile("written.txt", "rw");

        System.out.println("Write something");
        String text = sc.nextLine();
        byte[] bytes = text.getBytes();

        raf.write(bytes);

        raf.close();
        sc.close();
    }
}
