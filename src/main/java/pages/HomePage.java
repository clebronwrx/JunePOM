package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase {

	Actions action;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath = "//img[@class='suntrust-header-logo-img']")
	 private WebElement logo;

	 @FindBy(xpath = "//a[contains(text(),'Open an Account')][1]")
	 private WebElement openAccount;

	 @FindBy(xpath = "//div[@class='suntrust-holder-link pull-right']//span[contains(text(),'Find Us')]")
	WebElement findUsBtn;

	 @FindBy(xpath = "//div[@class='suntrust-holder-link pull-right']//span[contains(text(),'Search')]")
	private WebElement searchBtn; // opens popup for searching

	 @FindBy(xpath = "//input[@id='header-search-input']")
	 private WebElement searchfield;

	@FindBy(xpath = "//a[@class='suntrust-orange-button'][contains(text(),'Search')]")
	private WebElement searchExecuteBtn;

	@FindBy(xpath = "//div[@class='suntrust-nav-search']//a[@class='suntrust-modal-close user-menu-accessibility-trigger']")
	private WebElement closeSearchPopup;

	@FindBy(xpath = "//span[@class='suntrust-header-icon-button-text suntrust-header-icon-button-sign-on']")
	private WebElement signOn;

	@FindBy(xpath = "//span[@class='suntrust-user-icon']")
	private WebElement userIcon;

	@FindBy(xpath = "//a[@class='suntrust-subMenuanchor'][contains(text(),'Corporate & Commercial')]")
	private WebElement corpAndCommercialTab;

	@FindBy(xpath = "//form[@name='loginForm-signonblade-OLB']")
	private WebElement singOnMenu;

	@FindBy(css = "a.suntrust-subMenuanchor[data-analytics-value='Small Business']")
	private WebElement smallBusinessTab;

	public void clickOnCNCOption() {
		clickOn(driver, corpAndCommercialTab, 10);
		;
	}

	public void selectCNCOption(String option) throws Exception {
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 20);

		action.moveToElement(corpAndCommercialTab).build().perform();

		WebElement link = driver.findElement(By.linkText(option));

		clickOn(driver, link, 10);

		wait.until(ExpectedConditions.titleContains(option));

	}

	public void clickOnFindUs() {
		clickOn(driver, findUsBtn, 10);
	}

	public void clickOnSignOn() {

		clickOn(driver, signOn, 10);
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("suntrust-login-form"))));

	}

	public void clickOnOpenAccount() {
		clickOn(driver, openAccount, 10);
	}

	public boolean signOnMenuIsDisplayed() {
		boolean b = singOnMenu.isDisplayed();
		return b;
	}

	public void checkSmallBusinessLinkOptions(String option,String url) {

		action = new Actions(driver);
		wait = new WebDriverWait(driver, 25);

		action.moveToElement(smallBusinessTab).build().perform();

		WebElement link = driver.findElement(By.linkText(option));

		clickOn(driver, link, 20);

		wait.until(ExpectedConditions.titleContains(url));
	}

	public int getHomePageLinks() {
		int linksAmount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksAmount);
		return linksAmount;
	}
}
