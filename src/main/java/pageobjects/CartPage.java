package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The CartPage class represents the shopping cart page in the online store.
 *
 * It provides methods to interact with the cart, including proceeding to the
 * checkout process.
 */
public class CartPage {

    private WebDriver driver;

    @FindBy(className = "wc-proceed-to-checkout")
    private WebElement checkoutBtn;

    /**
     * Constructs a CartPage object with the specified WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Proceeds to the checkout page by clicking the checkout button.
     *
     * @return a CheckoutPage object representing the checkout page.
     */
    public CheckoutPage checkout() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}
