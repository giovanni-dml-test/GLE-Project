package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//generates reports in the console as well
                "html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,//makes the console reports more readable
        features = "./src/test/resources/features/API", //path of the features folder
        glue = {"stepDefinitions", "hooks"}, //path of the step definitions folder and (hooks folder if needed)
        dryRun = false, //generate the missing step definitions only. Do not run the existing step definitions
        tags = "@api_gio" //only run scenarios with @api tag

)


public class APITestRunner {



}

