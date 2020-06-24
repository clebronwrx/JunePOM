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
	
	@FindBy(xpath="//select[@id='suntrust-control-drop-544098144']")
	WebElement serviceDropDown;
	
	@FindBy(xpath="//a[contains(text(),'The SunTrust Advantage')][@title='The SunTrust Advantage']")
	WebElement suntrustAdvantageTab;
	
	@FindBy(xpath="//span[@class='alert-close-button-left']")
	WebElement closeCovidAlert;
	
	
	public void clicksuntrustAdvangeTab() {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(suntrustAdvantageTab));
			closeCovidAlert.click();

			suntrustAdvantageTab.click();
			if(closeCovidAlert.isDisplayed()) {
				closeCovidAlert.click();
			}
		}
		
	
	
	public void chooseWhichServiceFromDropDown(String value) {
		selectOptionByVisibleText(serviceDropDown, value);
	}
	
	
	
}
