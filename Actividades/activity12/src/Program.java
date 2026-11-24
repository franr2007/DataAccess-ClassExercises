
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Program {

    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount("Fran Rodriguez", 21234, 10000.76);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bankaccount.dat"))) {
            out.writeObject(account);

            System.out.println("Account serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("bankaccount.dat"))) {
            BankAccount restoredAccount = (BankAccount) in.readObject();

            System.out.println("\nRestored account:");
            System.out.println(restoredAccount);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
        Question:
        Explain why the no-argument constructor is called during deserialization and
        why the Externalizable interface requires it.

        Answer:
        Durante la deserialización, Java primero crea una nueva instancia de la clase
        BankAccount llamando a su constructor público sin argumentos. Después, ejecuta
        el método readExternal() para recuperar los atributos del archivo.

        La interfaz Externalizable requiere este constructor porque Java necesita
        crear el objeto antes de restaurar sus datos. Esto permite al programador
        tener un control completo sobre cómo se escriben y se leen los atributos
        del objeto.
     */
}
