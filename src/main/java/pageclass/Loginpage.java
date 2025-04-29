package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	 WebDriver driver;

	    @FindBy(name = "email") WebElement emailInput;
	    @FindBy(name = "password") WebElement passwordInput;
	    @FindBy(xpath = "//button[text()='Login']") WebElement loginButton;

	    public Loginpage(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void login(String email, String password) 
	    {
	        emailInput.sendKeys(email);
	        passwordInput.sendKeys(password);
	        loginButton.click();
	    }
	}


