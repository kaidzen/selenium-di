import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    String browser;

    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(@Optional("CHROME") String browser) {
       this.browser = browser;
    }
}

