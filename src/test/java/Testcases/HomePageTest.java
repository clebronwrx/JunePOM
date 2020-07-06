/*
 * author chris lebron
 */

package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import pages.HomePage;
import utilities.RetryFailure;
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

	@Test(groups = "home",retryAnalyzer = RetryFailure.class)
	public void getHomePageLinksAmountTest() {

		int linksAmount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksAmount);

	}

	@Test(enabled = false)
	public void checkCNCHoverByOptionsTest() throws Exception {

		String option = "Treasury Management";

		homepage.selectCNCOption(option);

		System.out.println("Expected Title :" + option);
		String acTitle = driver.getTitle();

		System.out.println("Title is: " + acTitle);

		Assert.assertTrue(acTitle.contains(option));

	}

	@Test(dataProvider = "getCNCOptionsData", groups = "links")
	public void checkCNCHoverOptionsWithDPTest(String option, String title) throws Exception {

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

	@Test(retryAnalyzer = RetryFailure.class)
	public void verifySignOnMenuOpensTest() {
		homepage.clickOnSignOn();
		wait = new WebDriverWait(driver, 20);
		
		boolean menu = homepage.signOnMenuIsDisplayed();
		Assert.assertTrue(menu);
	}

	@Test(retryAnalyzer = RetryFailure.class)
	public void verifySmallBusiness_PayrollOptionTitleTest() {
		homepage.checkSmallBusinessLinkOptions("Payroll", "Payroll"); //"https://www.suntrust.com/small-business-banking/payroll-services");

		String title = driver.getTitle();
		Assert.assertEquals(title, "Small Business Online Payroll Services | SunTrust Small Business");
	}
	
	@Test(retryAnalyzer = RetryFailure.class)
	public void verifySmallBusiness_CCOptionTitleTest() {
		homepage.checkSmallBusinessLinkOptions("Business Credit Cards","Cards"); //"https://www.suntrust.com/small-business-banking/business-credit-cards");

		String title = driver.getTitle();
		Assert.assertEquals(title, "Business Credit Cards | SunTrust Small Business Banking");
	}
	
	@Test(retryAnalyzer = RetryFailure.class)
	public void verifySmallBusiness_CashMngmntOptionTitleTest() {
		homepage.checkSmallBusinessLinkOptions("Cash Management", "Cash");//"https://www.suntrust.com/small-business-banking/cash-management-services");

		String title = driver.getTitle();
		Assert.assertEquals(title, "Cash Flow Management | SunTrust Small Business Banking");
	}
	
	
}
