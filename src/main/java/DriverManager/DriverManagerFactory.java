package DriverManager;

import java.util.HashMap;
import java.util.Map;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        Map<DriverType, DriverManager> driverManager = new HashMap<>();
        driverManager.put(DriverType.CHROME, new ChromeDriverManager());
        driverManager.put(DriverType.FIREFOX, new FirefoxDriverManager());
        driverManager.put(DriverType.SAFARI, new SafariDriverManager());

        return driverManager.get(type);

    }

}
