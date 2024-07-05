

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class LoginSteps {
    private String page;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        this.page = "Login Page";
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        // Assume credentials are entered
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        // Simulate page change
        this.page = "Dashboard";

    }
}