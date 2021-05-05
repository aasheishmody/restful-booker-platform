package utilities;

import enums.Browser;
import enums.HeadlessFlag;

import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static final ConfigFileReader configFileReader;
    private final Properties properties;

    static {
        configFileReader = new ConfigFileReader();
    }

    private ConfigFileReader() {

        properties = new Properties();
        try {
            properties.load(ConfigFileReader.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigFileReader getInstance() {
        return configFileReader;
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public Browser getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equalsIgnoreCase("chrome")) return Browser.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return Browser.FIREFOX;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout"));
    }

    public int getImplicitWaitTimeout() {
        return Integer.parseInt(properties.getProperty("implicitWaitTimeout"));
    }

    public HeadlessFlag getHeadlessFlag() {
        String headlessFlag = properties.getProperty("headlessFlag");
        if (headlessFlag == null || headlessFlag.equalsIgnoreCase("true")) return HeadlessFlag.TRUE;
        else if (headlessFlag.equalsIgnoreCase("false")) return HeadlessFlag.FALSE;
        else
            throw new RuntimeException("Headless Flag Key value in Configuration.properties is not matched : " + headlessFlag);
    }
}
