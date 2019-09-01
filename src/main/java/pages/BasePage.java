package pages;

import org.openqa.selenium.WebDriver;


abstract class BasePage<T extends BasePage> {
    private WebDriver webDriver;

    protected abstract String getPageURL();
    protected abstract T getThis();

    public T setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return getThis();
    }

    public T openPage() {
        webDriver.get(getPageURL());
        return getThis();
    }

    public final String getPageTitle() {
        return webDriver.getTitle();
    }
}
