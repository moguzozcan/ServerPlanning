import calculate.ServerCountCalculator;
import model.HardwareModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class includes the unit teat for ServerCountCalculator class,
 * which includes all the logic of the application.
 * Note: I could write unit test for HardwareSpecificationController class
 * also, but for simplicity, assume user is entering correct values all the
 * time and let's skip the unit test for now.
 */
public class ServerCountCalculatorTest {

    private static ServerCountCalculator serverCountCalculator;

    @BeforeClass
    public static void init() {
        serverCountCalculator = new ServerCountCalculator();
    }

    @Test
    public void testCalculateSuccess() {
        //Arrange
        HardwareModel server = new HardwareModel(1, 16, 100);
        HardwareModel vm1 = new HardwareModel(1, 16, 100);
        HardwareModel vm2 = new HardwareModel(1, 16, 100);
        List<HardwareModel> vms = new ArrayList<>();
        vms.add(vm1);
        vms.add(vm2);

        //Act
        int numberOfServers = serverCountCalculator.calculate(server, vms);

        //Assert
        Assert.assertEquals(2, numberOfServers);
    }

    @Test
    public void testCalculateVMIsTooBig() {
        //Arrange
        HardwareModel server = new HardwareModel(1, 16, 100);
        HardwareModel vm = new HardwareModel(2, 16, 100);
        List<HardwareModel> vms = new ArrayList<>();
        vms.add(vm);

        //Act
        int numberOfServers = serverCountCalculator.calculate(server, vms);

        //Assert
        Assert.assertEquals(1, numberOfServers);
    }
}
