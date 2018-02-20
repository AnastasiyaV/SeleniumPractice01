package myproject.driver;

import java.util.HashMap;
import java.util.Map;

public class DriverConfig {
    public static final int WAIT_SEC = 10;// ? to delete in future?

    public static final Map<String, String> config = createMap();

    private static Map <String, String> createMap() {
        Map<String, String> config = new HashMap<String, String>();
        config.put("name", "webdriver.chrome.myproject.driver");
        config.put("path", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        return config;
    }
}

