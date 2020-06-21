/*
 * author chris lebron
 */


package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

	@Test(groups = "home")
	public void getHomePageLinks() {
		int linksAmount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksAmount);

	}

	@Test(dataProvider = "getOptionsData", groups= "links")
	public void checkCNCHoverOptions(String option, String title) throws Exception {

		homepage.selectCNCOption(option);
		
		System.out.println("Expected Title :" + title);
		String acTitle = driver.getTitle().toString();

		System.out.println("Title is: " + acTitle);
		
		Assert.assertTrue(acTitle.contains(title));
	}

	@DataProvider
	public Object[] getOptionsData() {
		Object info[][] = TestUtil.getTestData("Commercial Tab");
		return info;
	}

}
