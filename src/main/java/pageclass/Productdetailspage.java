package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class Productdetailspage{
    WebDriver driver;

    @FindBy(id = "quantity") WebElement quantityField;
    @FindBy(xpath = "//button[@class='btn btn-default cart']") WebElement addToCartButton;

    public Productdetailspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setQuantity() {
        quantityField.clear();
        quantityField.sendKeys("3");
        addToCartButton.click();
   
}
}

