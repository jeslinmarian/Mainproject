package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Confirmationpage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//b[text()='Order Placed!']") 
    WebElement confirmationText;

    @FindBy(xpath = "//a[text()='Download Invoice']") 
    WebElement downloadInvoice;

    @FindBy(xpath = "//a[text()='Continue']") 
    WebElement continueShopping;

    public Confirmationpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void clickDownloadInvoice() {
        wait.until(ExpectedConditions.visibilityOf(confirmationText));
        downloadInvoice.click();
    }

    public void clickContinueShopping() 
    {
        continueShopping.click();
    }

    public boolean isConfirmationTextDisplayed() 
    {
        return confirmationText.isDisplayed();
    }

    public boolean isDownloadInvoiceButtonEnabled() 
    {
        return downloadInvoice.isEnabled();
    }

    public String gettitle() 
    {
    	String title = driver.getTitle();
    	return title;

    }
}
