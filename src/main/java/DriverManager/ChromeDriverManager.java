package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class ChromeDriverManager extends DriverManager {
    private ChromeDriverService chromeWDService;

    @Override
    protected void startService() {

        WebDriverManager.getInstance(CHROME).setup(); // use bin provided by WDManager
        if (null == chromeWDService) {
            try {
                chromeWDService = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                chromeWDService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != chromeWDService && chromeWDService.isRunning())
            chromeWDService.stop();
    }

    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        driver = new ChromeDriver(chromeWDService, options);
    }
}
