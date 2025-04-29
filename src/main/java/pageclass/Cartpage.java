package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Cartpage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//u[text()='View Cart']") WebElement viewCartLink;
    @FindBy(xpath = "//a[text()='Proceed To Checkout']") WebElement proceedToCheckoutButton;

    public Cartpage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToCart() {
        wait.until(ExpectedConditions.visibilityOf(viewCartLink));
        viewCartLink.click();
        proceedToCheckoutButton.click();
    }

    
}
