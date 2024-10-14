package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * The AccessoriesPage class represents the accessories section of the online store.
 *
 * It provides methods to interact with the available products, including selecting
 * a random product for further actions.
 */
public class AccessoriesPage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='products columns-4']/li")
    private List<WebElement> products;

    /**
     * Constructs an AccessoriesPage object with the specified WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public AccessoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects a random product from the accessories list and navigates to its product page.
     *
     * @return a ProductPage object representing the selected product's page.
     */
    public ProductPage selectRandomProduct() {
        int randomIndex = (int) (Math.random() * products.size());
        products.get(randomIndex).click();
        return new ProductPage(driver);
    }
}
