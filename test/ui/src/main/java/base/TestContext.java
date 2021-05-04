package base;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final Map<String, Object> scenarioContext;

    public TestContext() {
        scenarioContext = new HashMap<>();
    }

    public void setScenarioContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getScenarioContext(String key) {
        return scenarioContext.get(key);
    }
}
