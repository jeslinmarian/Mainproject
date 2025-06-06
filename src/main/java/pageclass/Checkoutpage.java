package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;

public class Checkoutpage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//h2[text()='Address Details']") WebElement addressHeader;
    @FindBy(name = "message") WebElement messageBox;
    @FindBy(xpath = "//a[text()='Place Order']") WebElement placeOrderButton;

    public Checkoutpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify that the URL contains "/checkout"
    public void verifyCheckoutPageURL() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/checkout"), "URL does not contain /checkout");
    }

    // Method to fill the message and place the order
    public void fillMessageAndPlaceOrder(String message) {
        wait.until(ExpectedConditions.visibilityOf(addressHeader));
        js.executeScript("window.scrollBy(0, 800)");
        messageBox.sendKeys(message);
        placeOrderButton.click();
    }
}
