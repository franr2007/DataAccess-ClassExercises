import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class UnScrambleData {
    public static void main(String[] args) {
        Random rm = new Random(77777);

        if (args.length != 2) {
            System.out.println("Uso: java ScrambleData <origen> <destino>");
            return;
        }

        String origen = args[0];
        String destino = args[1];

        System.out.println("Archivo origen: " + origen);
        System.out.println("Archivo destino: " + destino);

        int[] map = new int[256];

        for (int i = 0; i < 256; i++) {
            map[i] = i;
        }

        for (int i = 0; i < 256; i++) {
            int j = rm.nextInt(256);

            int temp = map[i];
            map[i] = map[j];
            map[j] = temp;
        }

        int[] inverseMap = new int[256];

        for (int i = 0; i < 256; i++) {
            inverseMap[map[i]] = i;
        }

        try {
            FileInputStream fis = new FileInputStream(origen);

            FileOutputStream fos = new FileOutputStream(destino);

            int resultado;

            ScrambledInputStream entrada = new ScrambledInputStream(fis, inverseMap);

            while ((resultado = entrada.read()) != -1) {
                fos.write(resultado);
            }

            fis.close();
            fos.close();
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
