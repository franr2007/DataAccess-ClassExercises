
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("report.txt"))) {

            System.out.println("Bytes available: " + bis.available());

            System.out.println("Firts 10 bytes: ");
            for (int i = 0; i < 10; i++) {
                int b = bis.read();

                System.out.println((char) b);
            }

            int b;
            int position = 0;

            while ((b = bis.read()) != -1) {
                if (b == 'S') {
                    if (bis.read() == 'T'
                            && bis.read() == 'A'
                            && bis.read() == 'R'
                            && bis.read() == 'T') {
                        position = 1;
                    }
                }
            }

            if (position == 1) {
                System.out.println("The word 'START' has been found");
            }

            bis.mark(40);

            byte[] firstRead = new byte[40];
            int count = 0;

            while (count < firstRead.length) { 
                b = bis.read();

                firstRead[count] = (byte) b;
                count ++;
            }

            System.out.println("First lecture: ");
            for (int i = 0; i < count; i++) {
                System.out.println((char) firstRead[i]);
            }

            bis.reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
