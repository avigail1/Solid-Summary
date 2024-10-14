package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The StoreHomePage class represents the homepage of the online store.
 *
 * It provides methods to navigate to various sections of the store, such as
 * the Accessories department and the shopping cart. It also allows access
 * to information related to the shopping cart.
 */
public class StoreHomePage {

    private WebDriver driver;
    private static final String URL = "https://atid.store";

    @FindBy(xpath = "//a[contains(text(),'Accessories')]")
    private WebElement accessories;

    @FindBy(className = "ast-site-header-cart-li")
    private WebElement headerCart;

    @FindBy(xpath = "//a[contains(text(),'View cart')]")
    private WebElement viewCartBtn;

    @FindBy(xpath = "//span[@class='count']")
    private WebElement countCart;

    /**
     * Constructs a StoreHomePage object with the specified WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public StoreHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the online store homepage.
     */
    public void goToStore() {
        driver.get(URL);
    }

    /**
     * Navigates to the Accessories department.
     *
     * @return an instance of the AccessoriesPage.
     */
    public AccessoriesPage goToAccessories() {
        accessories.click();
        return new AccessoriesPage(driver);
    }

    /**
     * Navigates to the shopping cart page.
     *
     * @return an instance of the CartPage.
     */
    public CartPage goToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(headerCart).perform();
        viewCartBtn.click();
        return new CartPage(driver);
    }

    /**
     * Retrieves the count of items in the shopping cart.
     *
     * @return the number of items in the cart as an integer.
     */
    public int getCountCart() {
        String countText = countCart.getText();
        return Integer.parseInt(countText);
    }
}
