package pages;

public class YahooPage extends BasePage<YahooPage>{
    private static final String PAGE_URL = "https://www.yahoo.com";

    @Override
    protected String getPageURL() {
        return PAGE_URL;
    }

    @Override
    protected YahooPage getThis() {
        return this;
    }
}
