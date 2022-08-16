package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WailHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	
	WailHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WailHelper(ldriver);
	}
	
	@FindBy(id="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumn;
	
	public void setEmail(String email) {
		waithelper.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void clickOnSearch() {
		btnSearch.click();
		waithelper.waitForElement(btnSearch, 20);
	}
	
	public int getNoOfRows() {
		return (tableRows.size());
	}
	
	public int getNumOfColumns() {
		return (tableColumn.size());
	}
	
	public boolean searchCutomerByEmail(String email) throws Exception {
		boolean flag = false;

		for (int i = 1; i < getNoOfRows(); i++) {
			Thread.sleep(3000);

			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"))
					.getText();
			
			Thread.sleep(3000);

			System.out.println(emailId);

			if (emailId.equals("victoria_victoria@nopCommerce.com")) {
				flag = true;
			}
		}
		return flag;

	}
}
