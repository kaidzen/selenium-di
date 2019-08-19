package Pages;

public class YahooPage extends BasePage<YahooPage>{
    private final String PAGE_URL = "https://www.yahoo.com";

    @Override
    protected String getPageURL() {
        return PAGE_URL;
    }
}
