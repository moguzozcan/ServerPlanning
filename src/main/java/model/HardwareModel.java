package model;

/**
 * This class is used to represent the Server and VM model.
 *
 * Examples:
 * Server type = {CPU: 2, RAM: 32, HDD: 100}
 * Virtual Machines = [{CPU: 1, RAM: 16, HDD: 10}, {CPU: 1, RAM: 16, HDD: 10}, {CPU: 2, RAM: 32, HDD: 100}]
 */
public class HardwareModel {

    private int CPU;
    private int RAM;
    private int HDD;

    public HardwareModel() {
    }

    public HardwareModel(int CPU, int RAM, int HDD) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.HDD = HDD;
    }

    public int getCPU() {
        return CPU;
    }

    public void setCPU(int CPU) {
        this.CPU = CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getHDD() {
        return HDD;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }
}
