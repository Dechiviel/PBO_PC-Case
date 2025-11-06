package Misi_1.PC;

import Misi_1.Interfaces.IKomponen;
import java.util.ArrayList;
import java.util.List;

public class PC {

    private IKomponen motherboard;
    private IKomponen cpu;
    private IKomponen ram;
    private List<IKomponen> penyimpanan;
    private List<IKomponen> peripheral;

    public PC(IKomponen motherboard, IKomponen cpu, IKomponen ram) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
        this.peripheral = new ArrayList<>();
    }

    public void activatePenyimpanan() {
        this.penyimpanan = new ArrayList<>();
    }

    public void addPenyimpanan(IKomponen storage) {
        this.penyimpanan.add(storage);
    }

    public void addPeripheral(IKomponen device) {
        this.peripheral.add(device);
    }

    public double calculateTotalPrice() {
        double total = 0;

        total += motherboard.getPrice();
        total += cpu.getPrice();
        total += ram.getPrice();

        for (IKomponen s : penyimpanan) {
            total += s.getPrice();
        }

        for (IKomponen p : peripheral) {
            total += p.getPrice();
        }

        return total;
    }

    public double getTotalPrice() {
        return calculateTotalPrice();
    }

    public void showConfiguration() {
        System.out.println("=== PC Configuration ===");
        motherboard.showDetail();
        cpu.showDetail();
        ram.showDetail();
        for (IKomponen c : penyimpanan) {
            c.showDetail();
        }
        for (IKomponen c : peripheral) {
            c.showDetail();
        }
        System.out.println("Total Price: Rp " + calculateTotalPrice());
    }

    public void generateReport() {
        System.out.println("--- PC Build Report ---");
        // Tiga baris berikut semuanya mengakses data dari objek 'pc'
        System.out.println("CPU: " + this.cpu.getNama());
        System.out.println("Motherboard: " + this.motherboard.getNama());
        System.out.println("RAM Sticks: " + this.ram.getNama());
        System.out.println("-----------------------");
    }

}
