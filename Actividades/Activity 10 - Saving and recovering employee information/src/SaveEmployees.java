import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveEmployees {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alex", 22));
        employees.add(new Employee("Fran", 30));
        employees.add(new Employee("Ivan", 25));

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {

            output.writeObject(employees);

            System.out.println("Empleados guardados correctamente");

        } catch (IOException e) {
            System.out.println("Error al guardar los empleados: "+e.getMessage());
        }

    }
}
