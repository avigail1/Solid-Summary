package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The ProductPage class represents a product detail page in the online store.
 *
 * It provides methods to interact with product-related actions, such as adding
 * the product to the shopping cart.
 */
public class ProductPage {

    private WebDriver driver;

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    /**
     * Constructs a ProductPage object with the specified WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Adds the product to the shopping cart by clicking the add-to-cart button.
     */
    public void addToCart() {
        addToCartButton.click();
    }
}
