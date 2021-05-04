package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions
        (
                glue = {"stepDefinitions"},
                features = "src/test/resources/features/",
                plugin = {"pretty", "json:target/json-files/cucumber.json" + "", "timeline:target"},
                tags = {"@roomBooking"}
        )

public class RunnerIT extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}