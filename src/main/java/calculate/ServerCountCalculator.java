package calculate;

import model.HardwareModel;

import java.util.List;

/**
 * This class is responsible from calculating the required server count for given server and VM
 * hardware specifications.
 */
public class ServerCountCalculator {

    private int remainingCPU;
    private int remainingHDD;
    private int remainingRAM;

    /**
     * This method returns the number of required server count for the given server
     * and VM hardware specifications
     * @param serverType
     * @param virtualMachines
     * @return numberOfServers which represents the number of required server
     */
    public int calculate(HardwareModel serverType, List<HardwareModel> virtualMachines) {
        int numberOfServers = 1;

        initiateRemainingHardware(serverType);

        for (HardwareModel virtualMachine : virtualMachines) {
            if(checkIfVMisTooBig(serverType, virtualMachine)) {
                //skip according to requirements
            } else {
                numberOfServers += calculateRemainingHardware(serverType, virtualMachine);
            }
        }

        return numberOfServers;
    }

    /**
     * This method initiates the remainig hardwares to server hardwares
     * @param serverType
     */
    private void initiateRemainingHardware(HardwareModel serverType) {
        this.remainingCPU = serverType.getCPU();
        this.remainingHDD = serverType.getHDD();
        this.remainingRAM = serverType.getRAM();
    }

    /**
     * This method calculates the remaining hardware for an incoming VM
     * @param serverType
     * @param virtualMachine
     * @return 1 if a new server is required, 0 otherwise
     */
    private int calculateRemainingHardware(HardwareModel serverType, HardwareModel virtualMachine) {
        if(virtualMachine.getCPU() > this.remainingCPU ||
        virtualMachine.getRAM() > this.remainingRAM ||
        virtualMachine.getHDD() > this.remainingHDD) {
            initiateRemainingHardware(serverType);
            calculateRemainingHardware(virtualMachine);
            return 1;
        } else {
            calculateRemainingHardware(virtualMachine);
            return 0;
        }
    }

    /**
     * This method calculates the remaining hardware of the each server
     * @param virtualMachine
     */
    private void calculateRemainingHardware(HardwareModel virtualMachine) {
        this.remainingCPU -= virtualMachine.getCPU();
        this.remainingRAM -= virtualMachine.getRAM();
        this.remainingHDD -= virtualMachine.getHDD();
    }

    /**
     * This method checks if the current VM is too big for a server
     * @param serverType
     * @param virtualMachine
     * @return true if VM could not fit to a server, else returns false
     */
    private boolean checkIfVMisTooBig(HardwareModel serverType, HardwareModel virtualMachine) {
        return (serverType.getCPU() < virtualMachine.getCPU() ||
                serverType.getHDD() < virtualMachine.getHDD() ||
                serverType.getRAM() < virtualMachine.getRAM());
    }
}
