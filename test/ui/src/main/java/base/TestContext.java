package base;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    public Page page;
    public DriverFactory driverFactory;
    private final Map<String, Object> scenarioContext;

    public TestContext(DriverFactory driverFactory, Page page) {
        scenarioContext = new HashMap<>();
        this.driverFactory = driverFactory;
        this.page = page;
    }

    public void setScenarioContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getScenarioContext(String key) {
        return scenarioContext.get(key);
    }
}
