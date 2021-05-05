package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;

    public DriverFactory() {
        if (SharedDriver.getDriver() == null) {
            driver = createDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitWaitTimeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(ConfigFileReader.getInstance().getPageLoadTimeout(), TimeUnit.SECONDS);
            SharedDriver.addDriver(driver);
        }
    }

    private WebDriver createDriver() {
        switch (ConfigFileReader.getInstance().getBrowser()) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(Boolean.parseBoolean(ConfigFileReader.getInstance().getHeadlessFlag().toString()));
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(Boolean.parseBoolean(ConfigFileReader.getInstance().getHeadlessFlag().toString()));
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        return driver;
    }
}
