package stepDefinitions.hooks;

import base.SharedDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;


public class Hooks {

    @AfterStep
    public void afterStep(Scenario scenario) {
        TakesScreenshot camera = (TakesScreenshot) SharedDriver.getDriver();
        byte[] screenshot = camera.getScreenshotAs(BYTES);
        scenario.attach(screenshot, "image/png", "Test Evidence");
    }

    @After
    public void afterTest() {
        SharedDriver.getDriver().manage().deleteAllCookies();
    }
}