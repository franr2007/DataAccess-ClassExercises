
import java.io.RandomAccessFile;
import java.util.Scanner;

public class WriteText {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile("messages.txt", "rw");
        String frase;

        for (int i = 0;i<5;i++) { 
            System.out.println("Sentence: "+i);
            frase = sc.nextLine();


            while(frase.length()< 40){
                frase += " ";
            }
            raf.write(frase.getBytes());
        }
        long totalFrases = raf.length() / 40 ;
        System.out.println("Total messages: "+ totalFrases);

        System.out.println("Put the number of the sentence you wanna seek: ");
        int fraseBuscar = sc.nextInt();
        long posicion = (fraseBuscar -1) *40;

        raf.seek(posicion);

        byte[] bytes = new byte[40];
        raf.readFully(bytes);

        String mensaje = new String(bytes);
        System.out.println("Sentece: "+mensaje.trim()+"\n");
        System.out.println("Write a new sentence: ");
        frase = sc.nextLine();

        while(frase.length()< 40){
                frase += " ";
            }
        raf.write(frase.getBytes());

        raf.close();
        sc.close();
    }
}
