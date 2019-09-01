package Pages;

import org.openqa.selenium.WebDriver;


abstract class BasePage<T extends BasePage> {
    private WebDriver webDriver;

    protected abstract String getPageURL();
    protected abstract T getPage();

    public T setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return getPage();
    }

    public T openPage() {
        webDriver.get(getPageURL());
        return getPage();
    }

    public final String getPageTitle() {
        return webDriver.getTitle();
    }
}
