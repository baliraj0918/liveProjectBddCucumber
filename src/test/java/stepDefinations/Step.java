package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.AddCustomerPage;
public class Step extends BaseClass {


	
	@Given("User Lunch Chrome Browser")
	public void user_lunch_chrome_browser() throws Exception {
	   // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\QE9_Software\\chromedriver_win32\\chromedriver.exe");

		driver=new ChromeDriver();
	    Thread.sleep(2000);
	    lp=new LoginPage(driver);
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) throws Exception {
	   driver.get(url);
	   driver.manage().window().maximize();
	    Thread.sleep(2000);

	}

	@When("Users enter Email as {string}and password as{string}")
	public void users_enter_email_as_and_password_as(String email,String password) throws Exception {
	   lp.setUsername(email);
	   lp.setPassword(password);
	    Thread.sleep(2000);

	}

	@When("Click on login")
	public void click_on_login() throws Exception {
	    lp.clickLogin();
	    Thread.sleep(2000);

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws Exception {
	    Thread.sleep(2000);
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertEquals(title,driver.getTitle());
		    Thread.sleep(2000);

	    }
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws Exception {
	    lp.clickLogout();
	    Thread.sleep(3000);

	}

	@Then("Close browser")
	public void close_browser() throws Exception {
	   driver.quit();
	    Thread.sleep(3000);

	}
	
	//customer
	
	@Then("user can view Dashboad")
	public void user_can_view_dashboad() throws Exception {
       addCust=new AddCustomerPage(driver);
       Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
       Thread.sleep(2000);
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws Exception {
		Thread.sleep(3000);
      addCust.clickOnCustomersMenu();
	}

	@When("click on customers menu Item")
	public void click_on_customers_menu_item() throws Exception {
     Thread.sleep(2000);
     addCust.clickOnCustometMenuItem();
	}

	@When("click on add new button")
	public void click_on_add_new_button() throws Exception {
	 addCust.clickOnAddNew();
	 Thread.sleep(3000);
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
     Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws Exception {
	  addCust.setEmail("Bali1@gmail.com");
	  addCust.setPassword("1234");
	//  addCust.setCustomerRole("Registered");
	  
	  Thread.sleep(3000);
	  
	  addCust.setManagerOfVendor("Vendor 2");
	  addCust.setGender("Male");
	  addCust.setFirstName("Bali");
	  addCust.setLastName("Raj");
	  addCust.setDob("9/07/1988");//format d/mm/yyyy
	  addCust.setCompanyName("BalirajAuto");
	  addCust.setAdminContent("This is for testing ...");
	  Thread.sleep(2000);
	  
	  
	}

	@When("click on save button")
	public void click_on_save_button() throws Exception {
	 addCust.clickOnSave();
	 Thread.sleep(2000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) throws Exception {
	
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully")); 
		 Thread.sleep(2000);

	}
	
	//step for searching a customer using email id
	
	@When("Enter customer email")
	public void enter_customer_email() {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws Exception {
		searchCust.clickOnSearch();
		Thread.sleep(3000);
	}

	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() throws Exception {
	    boolean status=searchCust.searchCutomerByEmail("victoria_victoria@nopCommerce.com");
	    
	    Assert.assertEquals(true,status);
	    Thread.sleep(3000);
	}
}
