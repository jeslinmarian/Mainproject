package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Assert;

public class Paymentpage {
    WebDriver driver;
    JavascriptExecutor js;


    @FindBy(name = "name_on_card") WebElement nameOnCard;
    @FindBy(name = "card_number") WebElement cardNumber;
    @FindBy(name = "cvc") WebElement cvc;
    @FindBy(name = "expiry_month") WebElement expiryMonth;
    @FindBy(name = "expiry_year") WebElement expiryYear;
    @FindBy(xpath = "//button[text()='Pay and Confirm Order']") WebElement confirmPayment;

    public Paymentpage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify the presence of payment input fields
    public void verifyPaymentFieldsPresence() {
        Assert.assertTrue(nameOnCard.isDisplayed(), "Name on Card field is not present");
        Assert.assertTrue(cardNumber.isDisplayed(), "Card Number field is not present");
        Assert.assertTrue(cvc.isDisplayed(), "CVC field is not present");
        Assert.assertTrue(expiryMonth.isDisplayed(), "Expiration Month field is not present");
        Assert.assertTrue(expiryYear.isDisplayed(), "Expiration Year field is not present");
    }

    // Method to make the payment
    public void makePayment(String name, String number, String cvcVal, String month, String year) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        cvc.sendKeys(cvcVal);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
        js.executeScript("window.scrollBy(0, 100)");
        confirmPayment.click();
    }
}
