package Pages;

import org.openqa.selenium.WebDriver;


abstract class BasePage<T extends BasePage> {
    private WebDriver webDriver;

    protected abstract String getPageURL();

    public T setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return (T) this;
    }

    public T openPage() {
        webDriver.get(getPageURL());
        return (T) this;
    }

    public final String getPageTitle() {
        return webDriver.getTitle();
    }
}
