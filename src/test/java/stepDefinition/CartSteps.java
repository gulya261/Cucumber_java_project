package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductPage;


public class CartSteps {

    private WebDriver driver;
    private CartPage cartPage;

    public CartSteps() {
        this.driver = Hooks.driver;
        this.cartPage = new CartPage(driver);

    }

    @Then("User is on Cart Page")
    public void user_is_on_cart_page() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", currentUrl);
    }

    @When("User goes to Checkout Page")
    public void user_goes_to_checkout_page() {
        cartPage.click_on_checkout_btn();

        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", currentUrl);
    }

}
