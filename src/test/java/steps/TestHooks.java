package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.ExtentManager;

public class TestHooks {
    ExtentReports extent;
    ExtentTest test;

    @Before
    public void setup() {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Facebook Login Test");
        test.info("Starting test execution...");
    }

    @After
    public void tearDown() {
        test.info("Test execution finished.");
        extent.flush(); // ✅ generates the HTML report
    }
}
