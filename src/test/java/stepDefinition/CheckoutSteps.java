package stepDefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutSteps {
    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutSteps() {
        this.driver = Hooks.driver;
        this.checkoutPage = new CheckoutPage(driver);
    }
    @When("User fills checkout form with {string} first name {string} last name {string} zip code")
    public void user_fills_checkout_form(String firstName, String lastName, String zip) {
        checkoutPage.fillCheckoutForm(firstName, lastName, zip);
    }
    @Then("User is on Checkout Overview Page")
    public void user_is_on_checkout_overview_page() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", currentUrl);
    }
}
