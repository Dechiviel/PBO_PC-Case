package Misi_1;

import Misi_1.Interfaces.IKomponen;
import Misi_1.KomponenInti.*;
import Misi_1.KomponenPenyimpanan.*;
import Misi_1.PC.*;
import Misi_1.Peripheral.*;

public class Main {

    public static void main(String[] args) {
        IKomponen motherboard = new Motherboard(2500000, "ASUS Prime B550M-A", "ASUS");
        IKomponen cpu = new CPU(3500000, "Ryzen 5 5600", "AMD");
        IKomponen ram = new RAM(1200000, "Vengeance LPX 16GB", "Corsair");

        PC pc = new PC(motherboard, cpu, ram);

        pc.activatePenyimpanan();
        pc.addPenyimpanan(new SSD(1000000, "Samsung EVO 970", "Samsung"));
        pc.addPenyimpanan(new HDD(750000, "Barracuda 1TB", "Seagate"));

        pc.addPeripheral(new Mouse(300000, "G102 Lightsync", "Logitech"));
        pc.addPeripheral(new Keyboard(450000, "K380 Bluetooth", "Logitech"));

        pc.showConfiguration();

	PCReportGenerator.generateReport(pc);
    }
}
