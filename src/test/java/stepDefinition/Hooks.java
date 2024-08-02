package stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/gulya/Documents/Java_projects_/Cucumber_test/Cucumber_project/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


}
