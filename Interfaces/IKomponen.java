package Misi_1.Interfaces;

public interface IKomponen
{	
	public double getPrice();

	public void setPrice(double price);

	public String getNama();

	public void setNama(String nama);

	public String getBrand();

	public void setBrand(String brand);

	default void showDetail() {
        	System.out.println("- " + getNama() + " (" + getBrand() + ") : Rp " + getPrice());
	}
}