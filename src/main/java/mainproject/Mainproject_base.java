package mainproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mainproject_base{

    public WebDriver driver;
    String url = "https://automationexercise.com/login";    

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();  
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest
    public void teardown() throws InterruptedException 
    {
    		Thread.sleep(5000);
            driver.quit();  
    }
}
