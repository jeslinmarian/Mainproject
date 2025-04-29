package pageclass;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Productlistpage{
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2") WebElement productsHeader;
    @FindBy(xpath = "(//i[@class='fa fa-plus-square'])[6]") WebElement viewButton;

    public Productlistpage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForProductsToLoad() {
        wait.until(ExpectedConditions.visibilityOf(productsHeader));
    }

    public void scrollToProduct() {
        js.executeScript("window.scrollBy(0, 800)");
    }

    public void viewProductDetails() {
        viewButton.click();
    }
}
