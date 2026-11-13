
import java.io.Serializable;

public class Employee implements Serializable {

    // atributos
    private String nombre;
    private int edad;

    // constructor
    public Employee(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // getters
    public String getnombre() {
        return nombre;
    }

    public int getedad() {
        return edad;
    }
}