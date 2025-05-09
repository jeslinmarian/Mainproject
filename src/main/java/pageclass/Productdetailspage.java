package pageclass;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class Productdetailspage {
    WebDriver driver;

    @FindBy(id = "quantity") WebElement quantityField;
    @FindBy(xpath = "//button[@class='btn btn-default cart']") WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='view-product']//child::img") WebElement image;

    public Productdetailspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean setQuantity() {
        quantityField.clear();
        quantityField.sendKeys("3");
        addToCartButton.click();
        return image.isDisplayed(); // Returns whether the image is displayed
    }

    public WebElement getProductImage() {
        return image; // This allows the test to access the product image
    }
}
