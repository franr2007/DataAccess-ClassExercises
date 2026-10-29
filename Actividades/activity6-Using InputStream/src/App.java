
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("report.txt"))) {

            // muestra los bytes disponibles
            System.out.println("Bytes available: " + bis.available());

            // lee y imprime los primeros 10 bytes
            System.out.println("First 10 bytes:");

            for (int i = 0; i < 10; i++) {
                int b = bis.read();

                // Si llegamos al final del archivo, dejamos de leer.
                if (b == -1) {
                    break;
                }

                System.out.print((char) b);
            }

            System.out.println();

            // buscar start
            int b;
            String palabra = "START";
            int contador = 0;
            boolean encontrado = false;

            //bucle para encontrar start
            //mientras se lea algo y no se haya encontrado seguira el bucle
            while ((b = bis.read()) != -1 && !encontrado) {

                //si la letra leida es justo igual que la letra seleccionada de la palabra
                if (b == palabra.charAt(contador)) {
                    contador++; //se suma 1 al contador

                    //si la longitud de la palabra y el contador es igual
                    if (contador == palabra.length()) {
                        //es que la palabra se ha encontrado
                        encontrado = true;
                    }

                } else {
                    //si la letra ya no coincide el contador se reinicia
                    contador = 0;
                }
            }

            if (encontrado) {
                System.out.println("The word 'START' has been found.");

                // se guarda la posicion despues de start
                bis.mark(40);

                // espacio para los siguiente 40 bytes
                byte[] primeraLectura = new byte[40];
                int primeraCuenta = 0;
                boolean acabado = false;

                while (primeraCuenta < primeraLectura.length && !acabado) {
                    b = bis.read();

                    // si se llega al final del archivo se termina la lectura
                    if (b == -1) {
                        acabado = true;
                    }

                    primeraLectura[primeraCuenta] = (byte) b;
                    primeraCuenta++;
                }

                // primera lectura
                System.out.println("\nFirst reading:");

                for (int i = 0; i < primeraCuenta; i++) {
                    System.out.print((char) primeraLectura[i]);
                }

                System.out.println();

                // vuelve a la posicion marcada
                bis.reset();

                // lee de nuevo los mismos 40 bytes
                byte[] segundaLectura = new byte[40];
                int segundaCuenta = bis.read(segundaLectura);

                // segunda lectura
                System.out.println("Second reading:");

                if (segundaCuenta > 0) {
                    for (int i = 0; i < segundaCuenta; i++) {
                        System.out.print((char) segundaLectura[i]);
                    }
                }

                System.out.println();

                // comprueba que las lecturas tengan la misma longitud
                boolean igual = primeraCuenta == segundaCuenta;

                // si tienen la misma longitud comparamos cada byte
                if (igual) {
                    for (int i = 0; i < primeraCuenta; i++) {
                        if (primeraLectura[i] != segundaLectura[i]) {
                            igual = false;
                            break;
                        }
                    }
                }

                if (igual) {
                    System.out.println("The two readings are the igual.");
                } else {
                    System.out.println("The two readings are different.");
                }

                // conteo de cuantas a hay en la segunda lectura
                int contadorA = 0;

                for (int i = 0; i < segundaCuenta; i++) {
                    if (segundaLectura[i] == 'a') {
                        contadorA++;
                    }
                }

                System.out.println("Number of 'a' characters: " + contadorA);

            } else {
                System.out.println("The word 'START' was not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
