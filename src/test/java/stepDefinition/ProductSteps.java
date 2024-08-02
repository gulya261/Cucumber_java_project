package stepDefinition;
import pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;




public class ProductSteps {
    private WebDriver driver;
    private ProductPage productPage;
    public ProductSteps(){
        this.driver = Hooks.driver;
        this.productPage = new ProductPage(driver);

    }




    @Given("User is on the Product page")
    public void user_is_on_the_product_page() {
        driver.get("https://www.saucedemo.com/");
//        this.productPage = new ProductPage(driver);

    }
    @When("User add {string} item to cart")
    public void user_add_item_to_cart(String itemName){

     productPage.addToCartItem(itemName);

    }

    @Then("User basket should be displayed with {string} item")
    public void user_basket_should_be_displayed_with_item(String count){
        String cartBadgeValue = productPage.getCartBadgeValue();
        Assert.assertEquals(cartBadgeValue,count);



    }

    @When("User remove {string} item from cart")
   public void user_remove_item_from_cart(String itemName){
        productPage.removeFromCartItem(itemName);
    }

    @Then("Basket badge is not exist")
    public void basket_badge_is_not_exist(){
        Assert.assertTrue(productPage.isCartBadgeExist().isEmpty());

    }

    @When("User chooses {string} filter")
    public void user_chooses_filter(String filterName){
        productPage.chooseNewFilter(filterName);
    }


    @Then("User have new sort page with {string} filter")
    public void user_have_new_sort_page_with_filter(String filterName){
     if (filterName=="Price (low to high)") {
         String firstRezult = productPage.getFirstProductPrice();
         Assert.assertEquals("$7.99",firstRezult);
     }

     else if (filterName=="Price (high to low)") {
         String secondRezult = productPage.getProductHighPrice();
         Assert.assertEquals("$49.99",secondRezult );

     }

     else if (filterName=="Name (Z to A)") {
         String thirdRezult = productPage.getFirstNameItem();
         Assert.assertEquals("Test.allTheThings() T-Shirt (Red)",thirdRezult);
     }
     else if (filterName=="Name (A to Z)") {
         String fourRezult = productPage.getFirstNameItem();
         Assert.assertEquals("Sauce Labs Backpack",fourRezult);

     }


    }






}
