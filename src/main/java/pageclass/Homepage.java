package pageclass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @FindBy(xpath = "(//h4[@class='panel-title']//child::span)[2]") WebElement menDropdown;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[1]/div[2]/div[2]/div/ul/li[1]/a") WebElement tshirtLink;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.js =(JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToTShirts() {
    	js.executeScript("window.scrollBy(0,400)");
        menDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(tshirtLink));
        tshirtLink.click();
    }
}
