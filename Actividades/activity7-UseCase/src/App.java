
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        PipedOutputStream emisor = new PipedOutputStream();
        PipedInputStream receptor = new PipedInputStream(emisor);

        Thread emisorThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int numero = (int) (Math.random() * 256);
                    emisor.write(numero);
                }

                emisor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); 

        Thread receptorThread = new Thread(() -> {
            try {
                int dato;

                while ((dato = receptor.read())!= -1) { 
                    System.out.println("Byte recibido: "+dato);
                }

                receptor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); 

        receptorThread.start();
        emisorThread.start();
    }
}
