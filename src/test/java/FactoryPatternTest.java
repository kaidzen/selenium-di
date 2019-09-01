import Pages.GooglePage;
import Pages.YahooPage;
import DriverManager.ChromeDriverManager;
import DriverManager.DriverManager;
import DriverManager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class FactoryPatternTest extends BaseTest {
    DriverManager driverManager;
    WebDriver driver;

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

    @Test
    public void launchGooglePageTest() {
        GooglePage page = new GooglePage();
        Assert.assertEquals(
                page.setWebDriver(driver)
                        .openPage()
                        .printMessage()
                        .getPageTitle(), "Google");
    }


    @Test
    public void launchYahooPageTest() {
        YahooPage page = new YahooPage();
        Assert.assertEquals(
                page.setWebDriver(driver)
                        .openPage()
                        .getPageTitle(), "Yahoo is now a part of Oath");
    }
}
