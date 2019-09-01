package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class FirefoxDriverManager extends DriverManager {
    private GeckoDriverService ffWDService;

    @Override
    protected void startService() {

        WebDriverManager.getInstance(FIREFOX).setup(); // use bin provided by WDManager
        if (null == ffWDService) {
            try {
                ffWDService = new GeckoDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                ffWDService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != ffWDService && ffWDService.isRunning())
            ffWDService.stop();
    }

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        driver = new FirefoxDriver(ffWDService, options);
    }
}
