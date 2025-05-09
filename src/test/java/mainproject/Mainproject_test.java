package mainproject;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageclass.Cartpage;
import pageclass.Checkoutpage;
import pageclass.Confirmationpage;
import pageclass.Homepage;
import pageclass.Loginpage;
import pageclass.Paymentpage;
import pageclass.Productdetailspage;
import pageclass.Productlistpage;


public class Mainproject_test extends Mainproject_base {
	
	
	
	@Test(priority = 1)
	public void loginfunction() 
	{
	    Loginpage login = new Loginpage(driver);    

	    String actualTitle = login.getTitleOfLogin();
	    String expectedTitle = "Automation Exercise - Signup / Login";  

	    // Assert the title after login
	    Assert.assertEquals(actualTitle, expectedTitle, "Login failed: Page title does not match!");
	    
	    login.loginfunction("jeslinmarian8420@gmail.com", "Test123@");
	}
	
	@Test(priority = 2)
	public void homepagefunction() 
	{
		new Homepage(driver).navigateToTShirts();
		String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Automation Exercise - Tshirts Products", "Login failed: Title mismatch!");
	}
	
	@Test(priority = 3)
	 public void Productlistpagefunction() {
        // Initialize the Productlistpage (assuming this is already set up to navigate to the product details page)
        Productlistpage productlist = new Productlistpage(driver);
        productlist.waitForProductsToLoad();
        productlist.scrollToProduct();
        productlist.viewProductDetails();

        // Now, initialize the Productdetailspage
        Productdetailspage productDetailsPage = new Productdetailspage(driver);

        // Call the method to verify the product image is displayed
        boolean isImageDisplayed = productDetailsPage.setQuantity(); // This will also click addToCartButton
        Assert.assertTrue(isImageDisplayed, "Product image is not displayed!");
    }
	
	@Test(priority = 4)
	public void Productdetailspagefunction() 
	{
		 Productdetailspage details= new Productdetailspage (driver);
		 details.setQuantity();
	}
	
	@Test(priority = 5)
	public void Cartpagefunction() 

	{
	    Cartpage cart = new Cartpage(driver);

	    cart.goToCart();

	    Assert.assertTrue(cart.isProceedToCheckoutButtonEnabled(), "Proceed to Checkout button should be enabled");


	    cart.click();
	}
	
	@Test(priority = 6)
	public void Checkoutpagefunction() 

	{
        // Instantiate the Checkoutpage object
        Checkoutpage checkout = new Checkoutpage(driver);

        // Verify that the URL contains "/checkout"
        checkout.verifyCheckoutPageURL();

        // Fill the message box and place the order
        checkout.fillMessageAndPlaceOrder("This is used to test");
    }
	@Test(priority = 7)
	public void Paymentpagefunction() 

	{
    
        Paymentpage payment = new Paymentpage(driver);

        payment.verifyPaymentFieldsPresence();

        payment.makePayment("Test user name", "789612345875", "658", "30", "2030");
    }
	
	@Test(priority = 8)
	public void Confirmationpagefunction() 

	{
        // Initialize the page object
        Confirmationpage confirmationPage = new Confirmationpage(driver);

        // Perform actions
       

        // Assertions
        Assert.assertTrue(confirmationPage.isConfirmationTextDisplayed(), "Order placed confirmation message is not displayed!");
        Assert.assertTrue(confirmationPage.isDownloadInvoiceButtonEnabled(), "Download Invoice button is not enabled!");
        
        String expectedTitle = "Automation Exercise - Order Placed";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
   
        confirmationPage.clickDownloadInvoice();
        confirmationPage.clickContinueShopping();
	
	}
}
	

