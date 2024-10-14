package utilities;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * The TestLifecycleExtension class implements JUnit 5 callbacks to manage the lifecycle
 * of tests involving Selenium WebDriver.
 *
 * This class is responsible for initializing the WebDriver before all tests and
 * closing it after all tests have been executed. It also facilitates the injection of
 * the WebDriver instance into test methods.
 */
public class TestLifecycleExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {

    private static WebDriver driver;
    ChromeDriverFactory chromeDriverFactory = new ChromeDriverFactory(driver);

    /**
     * Callback executed before all tests in the test class.
     *
     * This method initializes the WebDriver, maximizes the browser window,
     * and sets an implicit wait time for elements to be found.
     *
     * @param context the context of the test class.
     * @throws Exception if an error occurs during WebDriver initialization.
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver = chromeDriverFactory.openBrowser();  // Initialize the WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Callback executed after all tests in the test class.
     *
     * This method closes the WebDriver instance, cleaning up resources used during the tests.
     *
     * @param context the context of the test class.
     * @throws Exception if an error occurs during WebDriver closure.
     */
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        chromeDriverFactory.closeBrowser(driver);
    }

    /**
     * Determines if the current parameter can be resolved by this extension.
     *
     * @param parameterContext the context of the parameter being resolved.
     * @param extensionContext the context of the test execution.
     * @return true if the parameter is of type WebDriver, false otherwise.
     * @throws ParameterResolutionException if an error occurs during parameter resolution.
     */
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(WebDriver.class);  // Inject WebDriver into test methods
    }

    /**
     * Resolves the parameter to be injected into the test method.
     *
     * @param parameterContext the context of the parameter being resolved.
     * @param extensionContext the context of the test execution.
     * @return the WebDriver instance to be injected.
     * @throws ParameterResolutionException if an error occurs during parameter resolution.
     */
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return driver;  // Provide the WebDriver instance
    }
}
