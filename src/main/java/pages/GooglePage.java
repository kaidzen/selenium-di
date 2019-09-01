package pages;


public class GooglePage extends BasePage<GooglePage>{
    private static final String PAGE_URL = "https://www.google.com";

    @Override
    protected String getPageURL() {
        return PAGE_URL;
    }

    @Override
    protected GooglePage getThis() {
        return this;
    }

    public GooglePage printMessage(){
        System.out.println("Message from Google Page");
        return this;
    }

}
