package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class Paymentpage{
    WebDriver driver;

    @FindBy(name = "name_on_card") WebElement nameOnCard;
    @FindBy(name = "card_number") WebElement cardNumber;
    @FindBy(name = "cvc") WebElement cvc;
    @FindBy(name = "expiry_month") WebElement expiryMonth;
    @FindBy(name = "expiry_year") WebElement expiryYear;
    @FindBy(xpath = "//button[text()='Pay and Confirm Order']") WebElement confirmPayment;

    public Paymentpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void makePayment(String name, String number, String cvcVal, String month, String year) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        cvc.sendKeys(cvcVal);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
        confirmPayment.click();
    }
}
