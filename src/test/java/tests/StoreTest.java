package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import utilities.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * The StoreTest class contains test cases for purchasing products from an online store
 * and filling out checkout forms using Selenium WebDriver. It demonstrates the use of JUnit 5,
 * parameterized tests, and page objects.
 *
 * This class includes:
 * - A test for completing a purchase flow by selecting two random products.
 * - A parameterized test that reads XML data to fill out a checkout form.
 */
@ExtendWith({TestLifecycleExtension.class, TestWatcherExtension.class})
public class StoreTest {

    // WebDriver instance used for browser automation.
    WebDriver driver;

    /**
     * Constructor for the StoreTest class.
     *
     * @param driver the WebDriver instance used to drive the browser actions.
     */
    public StoreTest(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Test to validate the complete purchase flow.
     *
     * This test navigates to the store, selects two random products from the Accessories section,
     * adds them to the cart, and verifies that the cart contains two items.
     */
    @Test
    public void testPurchaseFlow() {
        // Initialize the homepage and navigate to store
        StoreHomePage homePage = new StoreHomePage(driver);
        homePage.goToStore();

        // Navigate to Accessories and select two products
        AccessoriesPage accessoriesPage = homePage.goToAccessories();
        ProductPage product1 = accessoriesPage.selectRandomProduct();
        product1.addToCart();

        ProductPage product2 = accessoriesPage.selectRandomProduct();
        product2.addToCart();

        Assertions.assertTrue(homePage.getCountCart() == 2);
    }

    /**
     * Provides a stream of Person objects from an XML file for parameterized tests.
     *
     * This method reads the people.xml file located at "./src/assets/people.xml" and converts
     * its data into a stream of Person objects to be used in parameterized tests.
     *
     * @return a stream of Person objects from the XML file.
     */
    static Stream<Person> personProvider() {
        XmlReader xmlReader = new XmlReader();
        List<Person> people = xmlReader.readXmlPerson("./src/assets/people.xml");
        return people.stream();
    }

    /**
     * Parameterized test to fill out a checkout form with data from an XML file.
     *
     * For each Person object provided by personProvider, this test navigates through the store,
     * selects a random product, and proceeds to the checkout form where the form is filled out using
     * the person's details.
     *
     * @param person the Person object containing form data.
     * @throws InterruptedException if the test is interrupted during execution.
     */
    @ParameterizedTest
    @MethodSource("personProvider")
    public void testFillForm(Person person){
        StoreHomePage homePage = new StoreHomePage(driver);
        homePage.goToStore();

        AccessoriesPage accessoriesPage = homePage.goToAccessories();
        ProductPage product1 = accessoriesPage.selectRandomProduct();
        product1.addToCart();

        // Proceed to checkout
        CartPage cartPage = homePage.goToCart();
        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.fillForm(person);
        Assertions.assertTrue(driver.findElement(By.xpath("//ul[@role='alert']")).isDisplayed());
    }
}
