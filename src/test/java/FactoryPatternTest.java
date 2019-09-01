import pages.GooglePage;
import pages.YahooPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactoryPatternTest extends TestBase {


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
