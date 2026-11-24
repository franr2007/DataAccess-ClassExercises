
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class BankAccount implements Externalizable {

    //atributos
    private String accountHolder;
    private int accountNumber;
    private double balance;

    //constructores
    public BankAccount() {

    }

    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //getters y setters
    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(double balance) {
        this.balance = balance;
    }

    //metodos
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(accountHolder);
        out.writeInt(accountNumber);
        out.writeDouble(balance);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        accountHolder = (String) in.readObject();
        accountNumber = in.readInt();
        balance = in.readDouble();
    }

    @Override
    public String toString() {
        return "Account Holder: " + accountHolder
                + "\nAccount Number: " + accountNumber
                + "\nBalance: " + balance;
    }
}
