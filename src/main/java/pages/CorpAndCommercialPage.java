package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CorpAndCommercialPage extends TestBase{
	
	public CorpAndCommercialPage(){
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'The SunTrust Advantage')][@title='The SunTrust Advantage']")
	WebElement suntrustAdvantageTab;
	
	@FindBy(xpath="//span[@class='alert-close-button-left']")
	WebElement closeCovidAlert;
	
	
	public void clicksuntrustAdvangeTab() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(closeCovidAlert)).click();
		suntrustAdvantageTab.click();
	
		
	}
	
	
	
	
	
}
