package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.ExtentReportUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private static final WebDriver driver = Driver.getDriver();

    @Before
    public void setUp(Scenario scenario) {

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(10));
        System.out.println("---- Test Started ----");

        ExtentReportUtils.createTestReport(scenario.getName(), "test description");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        } else {
            ExtentReportUtils.passAndCaptureScreenshot("Step passed: " + scenario.getName());
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }

        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String path = System.getProperty("user.dir") + "/test-screenshots/" + timestamp + "-failed.png";

            FileUtils.copyFile(screenshot, new File(path));
            scenario.attach(FileUtils.readFileToByteArray(screenshot), "image/png", "screenshot");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @After
    public void afterTearDown(Scenario scenario) throws IOException {
        System.out.println("After Hooks...Runs after each Scenario.");
//        if a test scenario fails, then capture the screenshot, AND ATTACH IT TO OUR CUCUMBER HTML REPORT
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_scenario");
            try {
                Driver.closeDriver();
            } catch (Exception e) {
                scenario.log("Exception occurred while closing driver: " + e.getMessage());
            }
        }
    }
}
