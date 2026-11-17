
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {

        SerVehicle coche = new SerVehicle("Subaru", 2024);

        //serializacion
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("vehicle.dat"))) {

            output.writeObject(coche);
            output.close();

            System.out.println("Objeto serializado");
        } catch (IOException e) {
            System.out.println("Mensaje IO: " + e.getMessage());
        }

        //deserializacion
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("vehicle.dat"))) {

            SerVehicle cocheRecu = (SerVehicle) input.readObject();
            input.close();

            System.out.println("Marca: " + cocheRecu.getMarca());
            System.out.println("Año: " + cocheRecu.getYear());
        } catch (IOException e) {
            System.out.println("Mensaje IO: " + e.getMessage());
        } catch (ClassNotFoundException cfe) {
            System.out.println("Mensaje ClassNotFound: " + cfe.getMessage());
        }

    }
}
