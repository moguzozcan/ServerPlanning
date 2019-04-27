package specification;

import model.HardwareModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible from getting the Server and VM specs from the user as input
 * and return the server and list of vms to the main method
 */
public class HardwareSpecificationsCollector {

    /**
     * This method gets the server specs from the user and return the server spec to main
     * @return server specs as HardwareModel
     */
    public static HardwareModel obtainServerSpecs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Server Hardware specifications with spaces:");
        System.out.println("For the following Server type = {CPU: 2, RAM: 32, HDD: 100}");
        System.out.println("Enter \"2 32 100\" for CPU RAM and HDD");
        String serverTypeStr = scanner.nextLine();
        HardwareModel server = parseHardwareString(serverTypeStr);

        return server;
    }

    /**
     * This method obtains number of VMs and their corresponding specs from the user as input
     * @return list of HardwareModel which represents the VMs
     */
    public static List<HardwareModel> obtainVMSpecs() {
        Scanner scanner = new Scanner(System.in);

        List<HardwareModel> virtualMachines = new ArrayList<>();

        System.out.println("Please enter how many VM's you want to add");
        int numberOfVMs = scanner.nextInt();
        scanner.nextLine();

        while (numberOfVMs > 0) {
            System.out.println("Please enter VM Hardware specifications with spaces:");
            System.out.println("For the following Virtual Machines = {CPU: 1, RAM: 16, HDD: 10}");
            System.out.println("Enter \"1 16 10\" for CPU RAM and HDD");
            String vmTypeStr = scanner.nextLine();
            HardwareModel vm = parseHardwareString(vmTypeStr);

            virtualMachines.add(vm);
            numberOfVMs--;
        }

        return virtualMachines;
    }

    /**
     * This method parses the user input and creates corresponding hardware accordingly
     * @param vmTypeStr
     * @return HardwareModel created from user as input
     */
    private static HardwareModel parseHardwareString(String vmTypeStr) {
        HardwareModel hardwareModel = new HardwareModel();

        //Here we can check if user enters an integer or not, but assume user is entering correct value
        String[] specifications = vmTypeStr.split(" ");
        hardwareModel.setCPU(Integer.valueOf(specifications[0]));
        hardwareModel.setRAM(Integer.valueOf(specifications[1]));
        hardwareModel.setHDD(Integer.valueOf(specifications[2]));

        return hardwareModel;
    }
}
