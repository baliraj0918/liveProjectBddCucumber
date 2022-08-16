package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WailHelper {

	public WebDriver driver;
	
	public WailHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElement(WebElement element,long timeoutForSec) {
		
		WebDriverWait wait=new WebDriverWait(driver,timeoutForSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
