package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")

@SelectClasspathResource("features")

 // base folder for all features
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty," +
                "html:target/cucumber-reports.html," +
                "json:target/json-reports/cucumber.json," +
                "junit:target/xml-reports/cucumber.xml," +
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
// Optional: Tag filter (change this value to run specific feature groups)
@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@api_ajeesha" // Run all features
)

public class Runner {
}
