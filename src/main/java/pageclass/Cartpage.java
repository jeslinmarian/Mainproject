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

    public Cartpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToCart() {
        wait.until(ExpectedConditions.visibilityOf(viewCartLink));
        viewCartLink.click();
    }

    // Method to check if Proceed to Checkout button is enabled
    public boolean isProceedToCheckoutButtonEnabled() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        return proceedToCheckoutButton.isEnabled();
    }

    // Click the "Proceed to Checkout" button
    public void click() {
        proceedToCheckoutButton.click();
    }
}
