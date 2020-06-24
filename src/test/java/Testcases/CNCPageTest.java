package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CorpAndCommercialPage;
import pages.HomePage;

public class CNCPageTest extends TestBase{

	public HomePage homepage;
	public CorpAndCommercialPage cncpage;
	public CNCPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		homepage = new HomePage();
		cncpage = new CorpAndCommercialPage();
		homepage.clickOnCNCOption();
	}
	
	
	@Test(groups="commercial", priority = 1)
	public void verifyAdvantageTitleTest() {
		
		cncpage.clicksuntrustAdvangeTab();
		
	String title = driver.getTitle();
	Assert.assertEquals(title, "SunTrust OneTeam Financial Advantage | SunTrust Corporate Banking");
	}

	@Test(priority = 2)
	public void verifyServiceOptions() {
		
		cncpage.chooseWhichServiceFromDropDown("Trade Services");
		String label = driver.findElement(By.id("lblHeader")).getText();
		System.out.println(label);
		Assert.assertEquals(label, "Online Trade Services");
	}
	
	
}
