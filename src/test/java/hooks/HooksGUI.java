package hooks;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.ExtentReportUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class HooksGUI {

    private WebDriver driver;


    @Before
    public void setUp(Scenario scenario) {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(60));
        System.out.println("---- Test Started ----");

        ExtentReportUtils.createTestReport(scenario.getName(), "test description");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportUtils.logStepWithScreenshot(driver, "Step failed: " + scenario.getName());

        } else {
            ExtentReportUtils.logStepWithScreenshot(driver, "Step passed: " + scenario.getName());

        }
    }

    @After
    public void tearDown(Scenario scenario) {

        if (Driver.getDriver() != null) {
            Driver.closeDriver();
        }

    }

    private void takeScreenshot(Scenario scenario) {
        try {
            File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String path = System.getProperty("user.dir") + "/test-screenshots/" + timestamp + "-failed.png";

            FileUtils.copyFile(screenshot, new File(path));
            scenario.attach(FileUtils.readFileToByteArray(screenshot), "image/png", "screenshot");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void ReportCreation() {

        ExtentReportUtils.flush();

    }

}
