package utilities;

import org.openqa.selenium.WebDriver;

/**
 * The OpenCloseBrowser interface defines methods for managing a web browser's
 * lifecycle during automated testing.
 *
 * Implementations of this interface should provide specific functionality for
 * opening and closing a web browser using Selenium WebDriver.
 */
public interface OpenCloseBrowser {

    /**
     * Opens a new browser instance and returns the WebDriver for it.
     *
     * @return a WebDriver instance for the opened browser.
     */
    WebDriver openBrowser();

    /**
     * Closes the specified browser instance.
     *
     * @param driver the WebDriver instance to be closed.
     */
    void closeBrowser(WebDriver driver);
}
