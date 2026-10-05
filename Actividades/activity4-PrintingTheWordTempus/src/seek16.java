import java.io.RandomAccessFile;

public class seek16 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("lipsum16.txt", "r");

        file.seek(98);

        byte[] word = new byte[12];
        file.readFully(word);

        System.out.println(new String(word));

        file.close();
    }
}
