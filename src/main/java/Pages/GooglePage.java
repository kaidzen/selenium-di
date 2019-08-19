package Pages;


public class GooglePage extends BasePage<GooglePage>{
    private final String PAGE_URL = "https://www.google.com";

    @Override
    protected String getPageURL() {
        return PAGE_URL;
    }

}
