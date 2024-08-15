package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartBtn;

    @FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement backpackCartBtn;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement onesieCartBtn;

    @FindBy(css = "[data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement bikeLightCartBtn;

    @FindBy(className = "product_sort_container")
    private WebElement filterBtn;

    @FindBy(css = "option[value='lohi']")
    private WebElement lthFilter;

    @FindBy(css = "option[value='hilo']")
    private WebElement htlFilter;

    @FindBy(css = "option[value='az']")
    private WebElement azFilter;

    @FindBy(css = "option[value='za']")
    private WebElement zaFilter;

    @FindBy(className = "inventory_item_price")
    private WebElement firstProductPrice;

    @FindBy(className = "inventory_item_price")
    private WebElement productHighPrice;

    @FindBy(className = "inventory_item_name")
    private WebElement firstItem;

    @FindBy(xpath = "//*[contains(text(), 'Sauce Labs Bike Light')]")
    private WebElement bikeLightItem;

    @FindBy(xpath = "//*[contains(text(), 'Sauce Labs Backpack')]")
    private WebElement backpackItem;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackCartBtn;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeBikeLightCartBtn;

    public void addToCartItem(String itemName) {
        Map<String, WebElement> itemsList = createItemsList();
        WebElement itemLocator = itemsList.get(itemName);
        itemLocator.click();
    }

    public void removeFromCartItem(String itemName) {
        Map<String, WebElement> RemoveItemsList = createRemoveFromCartItemsList();
        WebElement removeItemLocator = RemoveItemsList.get(itemName);
        removeItemLocator.click();
    }

    public Map<String, WebElement> createItemsList() {
        Map<String, WebElement> productItems = new HashMap<String, WebElement>();
        productItems.put("Backpack", backpackCartBtn);
        productItems.put("Bike light", bikeLightCartBtn);
        productItems.put("Onesie", onesieCartBtn);
        return productItems;
    }

    public void chooseNewFilter(String filterName) {
        filterBtn.click();
        Map<String, WebElement> filters = this.createFilterList();
        WebElement filter = filters.get(filterName);
        filter.click();
    }

    public Map<String, WebElement> createFilterList() {
        Map<String, WebElement> filters = new HashMap<String, WebElement>();
        filters.put("Name (A to Z)", azFilter);
        filters.put("Name (Z to A)", zaFilter);
        filters.put("Price (low to high)", lthFilter);
        filters.put("Price (high to low)", htlFilter);
        return filters;
    }

    public Map<String, WebElement> createRemoveFromCartItemsList() { //по аналогии с пред методом
        Map<String, WebElement> productItems = new HashMap<String, WebElement>();
        productItems.put("Backpack", removeBackpackCartBtn);
        productItems.put("Bike light", removeBikeLightCartBtn);
        return productItems;
    }

    public String getCartBadgeValue() { //String выводится, тк возвращается строка
        return cartBadge.getText();
    }

    public WebElement getItemByName(String itemName) {
        Map<String, WebElement> productItems = new HashMap<String, WebElement>();
        productItems.put("Backpack", backpackItem);
        productItems.put("Bike light", bikeLightItem);
        return productItems.get(itemName);
    }

    public List<WebElement> isCartBadgeExist() {
        List<WebElement> cartBadge = this.driver.findElements(By.className("shopping_cart_badge"));
        return cartBadge;
    }

    public String getFirstProductPrice() {
        return firstProductPrice.getText();
    }

    public String getProductHighPrice() {
        return productHighPrice.getText();
    }

    public String getFirstNameItem() {
        return firstItem.getText();
    }

    public void clickOnCart() {
        this.cartBtn.click();
    }
}
