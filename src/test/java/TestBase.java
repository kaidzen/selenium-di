import manager.ChromeDriverManager;
import manager.DriverManager;
import manager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;

public class TestBase {
    private String browser;
    private DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(@Optional("CHROME") String browser) {
       this.browser = browser;
    }

    @BeforeClass
    public void beforeTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        driverManager = DriverManagerFactory.getManager(ChromeDriverManager.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
}

