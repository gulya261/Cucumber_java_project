package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
    public static WebDriver driver;
    public ChromeOptions options;
    public BrowserDriver(){
//        this.driver=driver;
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
//                + "/src/test/resources/drivers/chromedriver.exe"); //используем хромдрайвер и указали его путь
//
//        this.driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        driver = null;
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
                    + "/src/test/resources/drivers/chromedriver.exe"); //используем хромдрайвер и указали его путь
        driver= new ChromeDriver();
        }
        return driver;
    }
    public static void quite(){

       if (driver != null) {
           driver.quit();

       }

    }



}
