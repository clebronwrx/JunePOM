/*
 * author chris lebron
 */

package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.HomePage;
import utilities.TestUtil;

public class HomePageTest extends TestBase {

	public HomePage homepage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod

	public void setup() {
		homepage = new HomePage();
	}

	@Test(groups = "home", priority = 1)
	public void getHomePageLinksAmount() {

		int linksAmount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksAmount);

	}

//	@Test()
//	public void checkCNCHoverByOptions(String option) throws Exception {
//
//		option="Treasury Management" ;
//		
//		homepage.selectCNCOption(option);
//
//		
//		System.out.println("Expected Title :" + option);
//		String acTitle = driver.getTitle().toString();
//
//		System.out.println("Title is: " + acTitle);
//
//		Assert.assertTrue(acTitle.contains(option));
//
//	}

	@Test(dataProvider = "getCNCOptionsData", groups = "links", priority = 4)
	public void checkCNCHoverOptionsWithDP(String option, String title) throws Exception {

		homepage.selectCNCOption(option);

		System.out.println("Expected Title :" + title);
		String acTitle = driver.getTitle().toString();

		System.out.println("Title is: " + acTitle);

		Assert.assertTrue(acTitle.contains(title));

	}

	@DataProvider
	public Object[] getCNCOptionsData() {
		Object info[][] = TestUtil.getTestData("Commercial Tab");
		return info;
	}

	

	@Test(priority = 3)
	public void verifySignOnMenuOpens() {
		homepage.clickOnSignOn();
		wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("User ID"))));
		boolean menu = homepage.SignOnMenuIsDisplayed();
		Assert.assertTrue(menu);
	}

}
