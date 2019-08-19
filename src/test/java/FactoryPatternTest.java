import DriverManager.DriverManager;
import DriverManager.DriverManagerFactory;
import DriverManager.DriverType;
import Pages.GooglePage;
import Pages.YahooPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FactoryPatternTest extends BaseTest {
    DriverManager driverManager;
    WebDriver driver;

    @BeforeClass
    public void beforeTest(){
        driverManager = DriverManagerFactory.getManager(DriverType.valueOf(browser));
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
                .getPageTitle(),"Google");
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
