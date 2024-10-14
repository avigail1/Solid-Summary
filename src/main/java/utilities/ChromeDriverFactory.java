package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * The ChromeDriverFactory class implements the OpenCloseBrowser interface
 * to manage the lifecycle of a Chrome browser instance.
 *
 * This class is responsible for initializing the ChromeDriver using
 * WebDriverManager and providing methods to open and close the browser.
 */
public class ChromeDriverFactory implements OpenCloseBrowser {

    static WebDriver driver;

    /**
     * Constructs a ChromeDriverFactory with the specified WebDriver instance.
     *
     * @param driver the WebDriver instance to be managed by this factory.
     */
    public ChromeDriverFactory(WebDriver driver) {
        ChromeDriverFactory.driver = driver;
    }

    /**
     * Opens a new Chrome browser instance and returns the WebDriver for it.
     *
     * @return a WebDriver instance for the opened Chrome browser.
     */
    @Override
    public WebDriver openBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();  // Return a new instance of ChromeDriver
    }

    /**
     * Closes the specified Chrome browser instance.
     *
     * @param driver the WebDriver instance to be closed.
     */
    @Override
    public void closeBrowser(WebDriver driver) {
        driver.quit();  // Quit the driver and close all associated windows
    }
}
