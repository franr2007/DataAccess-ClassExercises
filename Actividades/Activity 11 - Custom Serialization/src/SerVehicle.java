
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerVehicle extends Vehicle implements Serializable {

    public SerVehicle(String marca, int year) {
        super(marca, year);
    }

    // Guardar manualmente los atributos de Vehicle
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

        oos.writeUTF(getMarca());
        oos.writeInt(getYear());
    }

    // Recuperar manualmente los atributos de Vehicle
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        String marca = ois.readUTF();
        int year = ois.readInt();

        setMarca(marca);
        setYear(year);
    }
}
