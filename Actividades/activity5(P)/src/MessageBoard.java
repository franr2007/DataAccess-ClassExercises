import java.io.RandomAccessFile;
import java.util.Scanner;

public class MessageBoard {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile("messages.txt", "rw");
        String frase;
        int fraseBuscar;
        long posicion;
        byte[] bytes;
        String mensaje;

        // bucle para las 5 lineas
        int numFrase = 1;
        for (int i = 0; i < 5; i++) {
            System.out.println("\nSentence: " + numFrase);
            frase = sc.nextLine();

            if (frase.length() > 40) {
                frase = frase.substring(0, 40);
            }

            while (frase.length() < 40) {
                frase += " ";
            }
            raf.write(frase.getBytes());
            numFrase++;
        }

        // Frases en total
        long totalFrases = raf.length() / 40;
        System.out.println("\nTotal messages: " + totalFrases + "\n");

        // buscar una frase mediante su numero
        System.out.println("Put the number of the sentence you wanna seek: ");
        fraseBuscar = sc.nextInt();
        posicion = (fraseBuscar - 1) * 40;

        raf.seek(posicion);

        bytes = new byte[40];
        raf.readFully(bytes);

        mensaje = new String(bytes);
        System.out.println("Sentece: " + mensaje.trim() + "\n");

        // ReWrite una frase mediante su numero
        System.out.println("Put the number of the sentence you wanna ReWrite: ");
        fraseBuscar = sc.nextInt();
        sc.nextLine();
        posicion = (fraseBuscar - 1) * 40;

        raf.seek(posicion);

        System.out.println("\nWrite the new sentence: ");
        frase = sc.nextLine();

        if (frase.length() > 40) {
            frase = frase.substring(0, 40);
        }

        while (frase.length() < 40) {
            frase += " ";
        }

        raf.write(frase.getBytes());

        // Leer la frase ReWrited

        raf.seek(posicion);

        bytes = new byte[40];
        raf.readFully(bytes);

        mensaje = new String(bytes);
        System.out.println("\nReWrited Sentece: " + mensaje.trim() + "\n");

        System.out.println("File length: " + raf.length() + " bytes");

        raf.close();
        sc.close();
    }
}