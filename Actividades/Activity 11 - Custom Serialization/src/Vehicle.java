
public class Vehicle {

    private String marca;
    private int year;

    public Vehicle(String marca, int year) {
        this.marca = marca;
        this.year = year;
    }

    //constructor vacio para deserializar
    public Vehicle() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
