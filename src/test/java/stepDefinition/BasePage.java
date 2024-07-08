package stepDefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import utility.BrowserDriver;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import io.cucumber.java.PendingException;
import org.junit.Assert;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class BasePage {
    private static WebDriver driver=BrowserDriver.getDriver();
    @Given("user navigates to the Login page")
    public void user_navigates_to_the_login_page()  {
        driver.get("https://www.saucedemo.com/");
//        this.driver.close();

    }
    @When("user is logged in")
    public void user_is_logged_in(){
     WebElement userNameInput = driver.findElement(By.id("user-name"));
     WebElement passwordInput = driver.findElement(By.id("password"));
     WebElement loginBtn = driver.findElement(By.id("login-button"));
     userNameInput.sendKeys("standard_user");
     passwordInput.sendKeys("secret_sauce");
     loginBtn.click();
    }
    @Then("user should be logged in")
    public void user_should_be_logged_in(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals("https://www.saucedemo.com/",currentUrl);
    }

    @Then("browser is closed")
    public void browser_is_closed(){
        BrowserDriver.quite();
      ;
    }

//    @Given("User click on Sauce Labs Backpack")
//    public void user_click_on_Sauce_Labs_Backpack(){
//        WebElement itemSauceLabsBackpack = driver.findElement(By.cssSelector("inventory_item_name:nth-child(1)"));
//        itemSauceLabsBackpack.click();
//    }
    @When ("User navigates to the Product page")
    public void userNavigatesToTheProductPage(){
        WebElement productLink = driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]"));
    productLink.click();
    }
    @Then("User click on Add to cart")
    public void userClickOnAddToCart(){
        WebElement btnAddToCart = driver.findElement(By.id("add-to-cart"));
        btnAddToCart.click();
    }
    @And("User basket should display with added item")
    public void userBasketShouldDisplayWithAddedItem(){
        WebElement btnBasket = driver.findElement(By.className("shopping_cart_badge"));
        String checkBasketValue = btnBasket.getText();
System.out.println(checkBasketValue);
       Assert.assertEquals(checkBasketValue, "1");

    }


    @When ("User goes to the Product page")
    public void userGoesToTheProductPage(){
        WebElement nextProductLink = driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Bike Light')]"));
        nextProductLink.click();
       // throw new PendingException();
    }
    @Then("User repeat to click on Add to cart")
    public void userRepeatToClickOnAddToCart(){
        WebElement secondBtnAddToCart = driver.findElement(By.name("add-to-cart"));
        secondBtnAddToCart.click();
    }

    @Then ("User removes from card")
    public void userRemoveFromCart(){
        WebElement btnRemoveFromCart=driver.findElement(By.id("remove"));
        btnRemoveFromCart.click();
    }
    public static boolean isElementNotPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return false; // Element is found, so it exists
        } catch (NoSuchElementException e) {
            return true; // Element is not found, so it does not exist
        }
    }
    @And("User basket should display 0 item")

    public void userBasketShouldDisplay0Item(){
//        WebElement btnBasket1 = driver.findElement(By.className("shopping_cart_link"));
//        String checkBasketValue1 = btnBasket1.getText();
//        System.out.println(checkBasketValue1);
//        Assert.assertEquals(checkBasketValue1, "1");
        Assert.assertEquals(isElementNotPresent(driver,By.className("shopping_cart_badge")) , false);

    }

    @When("User clicks on filter")
    public void userClicksOnFilter(){
        WebElement btnFilter = driver.findElement(By.className("product_sort_container"));
        btnFilter.click();

    }

    @Then("User chooses new filter")
    public void userChoosesNewFilter(){
        WebElement btnNewFilter = driver.findElement(By.className("product_sort_container"));
        btnNewFilter.click();
        WebElement newOptionOfFilter = driver.findElement(By.cssSelector("option[value='lohi']"));
        newOptionOfFilter.click();
    }

    @And("User have new sort page with work of filter")
    public void UserHaveNewSortPageWithWorkOfFilter(){
        WebElement firstProductPrice = driver.findElement(By.className("inventory_item_price"));
        String rezult = firstProductPrice.getText();
       //System.out.println(rezult);
        Assert.assertEquals("$7.99",rezult);

    }
}
