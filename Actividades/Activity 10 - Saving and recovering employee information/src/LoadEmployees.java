import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadEmployees {
    public static void main(String[] args) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("employees.dat"))) {

            ArrayList<Employee> empleados = (ArrayList<Employee>) input.readObject();

            int edadTotal = 0;

            System.out.println("Empleados:");

            for (Employee empleado : empleados) {
                System.out.println("Name: " + empleado.getnombre() + ", Age: " + empleado.getedad());

                edadTotal += empleado.getedad();
            }

            double media = (double) edadTotal / empleados.size();

            System.out.println("Media de edades: "+media);

        } catch (IOException e) {
            System.out.println("Error al leer empleados: "+e.getMessage());
        }
        catch (ClassNotFoundException ex){
            System.out.println("Error clase no encontrada: "+ex.getMessage());
        }
    }
}
