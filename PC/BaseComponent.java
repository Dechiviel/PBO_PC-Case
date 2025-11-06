package Misi_1.PC;
import Misi_1.Interfaces.IKomponen;

public abstract class BaseComponent implements IKomponen
{
    private double price;
    private String nama;
    private String brand;

    public BaseComponent(double price, String nama, String brand)
    {
        this.price = price;
        this.nama = nama;
        this.brand = brand;
    }

    public String getNama() { return nama; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }

    public void setNama(String nama) { this.nama = nama; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setPrice(double price) { this.price = price; }
}