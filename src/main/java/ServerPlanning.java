import calculate.ServerCountCalculator;
import model.HardwareModel;
import specification.HardwareSpecificationsCollector;

import java.util.List;

/**
 * This is the main class responsible from running the application
 */
public class ServerPlanning {

    public static void main(String[] args) {
        HardwareModel serverType = HardwareSpecificationsCollector.obtainServerSpecs();
        List<HardwareModel> virtualMachines = HardwareSpecificationsCollector.obtainVMSpecs();

        ServerCountCalculator serverCountCalculator = new ServerCountCalculator();
        int result = serverCountCalculator.calculate(serverType, virtualMachines);

        System.out.println("Number of servers that is required = " + result);
    }
}
