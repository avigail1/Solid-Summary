package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Person;

/**
 * The CheckoutPage class represents the checkout page in the online store.
 *
 * It provides methods to fill in the checkout form with user information
 * and to retrieve error messages related to the form submission.
 */
public class CheckoutPage {

    private WebDriver driver;

    @FindBy(name = "checkout")
    private WebElement form;

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement postcode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(xpath = "//ul[@role='alert']")
    private WebElement errorElem;

    /**
     * Constructs a CheckoutPage object with the specified WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Fills the checkout form with the provided person's information.
     *
     * @param person the Person object containing the user's details.
     */
    public void fillForm(Person person) {
        firstName.sendKeys(person.getFirstName());
        lastName.sendKeys(person.getLastName());
        address.sendKeys(person.getAddress());
        postcode.sendKeys(person.getPostcode());
        city.sendKeys(person.getCity());
        phone.sendKeys(person.getPhone());
        email.sendKeys(person.getEmail());

        email.submit();  // Submit the form
    }

    /**
     * Returns the error element displayed on the checkout page.
     *
     * @return the WebElement representing the error message.
     */
    public WebElement returnErrorElem() {
        return errorElem;
    }
}
