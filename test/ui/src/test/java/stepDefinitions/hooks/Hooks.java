package stepDefinitions.hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks{

    @Before
    public void beforeTest() {
        DriverFactory.setDriver();
    }

    @After
    public void afterTest() {
        DriverFactory.getDriver().manage().deleteAllCookies();
    }
}