package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='suntrust-header-logo-img']")
	WebElement logo;

	@FindBy(xpath = "//a[contains(text(),'Open an Account')][1]")
	WebElement openAccount;

	@FindBy(xpath = "//div[@class='suntrust-holder-link pull-right']//span[contains(text(),'Find Us')]")
	WebElement findUsBtn;

	@FindBy(xpath = "//div[@class='suntrust-holder-link pull-right']//span[contains(text(),'Search')]")
	WebElement searchBtn; // opens popup for searching

	@FindBy(xpath = "//input[@id='header-search-input']")
	WebElement searchfield;

	@FindBy(xpath = "//a[@class='suntrust-orange-button'][contains(text(),'Search')]")
	WebElement searchExecuteBtn;

	@FindBy(xpath = "//div[@class='suntrust-nav-search']//a[@class='suntrust-modal-close user-menu-accessibility-trigger']")
	WebElement closeSearchPopup;

	@FindBy(xpath = "//span[@class='suntrust-header-icon-button-text suntrust-header-icon-button-sign-on']")
	WebElement signOn;

	@FindBy(xpath = "//span[@class='suntrust-user-icon']")
	WebElement userIcon;
 
	@FindBy(xpath = "//a[@class='suntrust-subMenuanchor'][contains(text(),'Corporate & Commercial')]")
	WebElement corpAndCommercialTab;

	public void clickOnCNCOption() {
	corpAndCommercialTab.click();;
	}

	public void selectCNCOption(String option) throws Exception {
		Actions action = new Actions(driver);
		wait= new WebDriverWait(driver, 10);
		action.moveToElement(corpAndCommercialTab).build().perform();
		
		WebElement link = driver.findElement(By.linkText(option));
	    clickOn(driver, link,10);
	    Thread.sleep(5000);
		
	}
		
	//public String getCNCTitleTest() {
		//wait= new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.
		//String s1 =driver.getTitle().toString();
		//return s1;
//	}
	
	
	}

