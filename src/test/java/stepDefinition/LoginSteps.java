package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.LoginPage;
import org.junit.Assert;


public class LoginSteps {
    private String page;

    private WebDriver driver;

    private LoginPage loginPage;

    public LoginSteps(){
        this.driver = Hooks.driver;
    }


    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        //для LoginPage будет добавлен driver
//        this.page = "Login Page";
    }

//    @When("the user enters valid credentials")
//    public void the_user_enters_valid_credentials() {
//        // Assume credentials are entered
//    }

    @When("User enters username {string}") //рег выражение в {}
    public void user_enters_username(String username){
        loginPage.enterUserName(username);
    }

    @When("User enters password {string}") //рег выражение в {}
    public void user_enters_password(String password){
        loginPage.enterPassword(password);

    }

    @When("User clicks on login button") //рег выражение в {}
    public void user_clicks_on_login_button(){
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard") //рег выражение в {}
    public void user_should_be_redirected_to_the_dashboard(){
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",currentUrl);

    }

//    @Then("the user should be redirected to the dashboard")
//    public void the_user_should_be_redirected_to_the_dashboard() {
//        // Simulate page change
//        this.page = "Dashboard";
//
//    }
}