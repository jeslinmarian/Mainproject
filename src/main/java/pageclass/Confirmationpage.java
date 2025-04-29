package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Confirmationpage{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//b[text()='Order Placed!']") WebElement confirmationText;
    @FindBy(xpath = "//a[text()='Download Invoice']") WebElement downloadInvoice;
    @FindBy(xpath = "//a[text()='Continue']") WebElement continueShopping;

    public Confirmationpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void verifyAndDownloadInvoice() {
        wait.until(ExpectedConditions.visibilityOf(confirmationText));
        downloadInvoice.click();
        continueShopping.click();
    }
}
