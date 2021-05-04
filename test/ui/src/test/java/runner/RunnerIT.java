package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
        (
                glue = {"stepDefinitions"},
                features = "src/test/resources/features/",
                tags = {"@addBooking"}
        )

public class RunnerIT extends AbstractTestNGCucumberTests {
}