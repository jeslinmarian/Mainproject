package mainproject;

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
		
		new Loginpage(driver).login("jeslinmarian8420@gmail.com","Test123@");
	}
	
	@Test(priority = 2)
	public void homepagefunction() 
	{
		new Homepage(driver).navigateToTShirts();
	}
	
	@Test(priority = 3)
	public void Productlistpagefunction() 
	{
		 Productlistpage productlist= new Productlistpage(driver);
		 productlist.waitForProductsToLoad();
		 productlist.scrollToProduct();
		 productlist.viewProductDetails();
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
		Cartpage cart= new Cartpage(driver);
		 cart.goToCart();
	}
	
	@Test(priority = 6)
	public void Checkoutpagefunction() 

	{
		 new Checkoutpage(driver).fillMessageAndPlaceOrder("this is used to test ");
	}
	@Test(priority = 7)
	public void Paymentpagefunction() 

	{
		new Paymentpage (driver).makePayment("Test user name","789612345875","658","30","2030");
	}
	
	@Test(priority = 8)
	public void Confirmationpagefunction() 

	{
		 new Confirmationpage (driver).verifyAndDownloadInvoice();	
	}
}
	

