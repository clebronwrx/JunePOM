package Testcases;

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
	
	
	@Test(groups="commercial")
	public void verifyCNCPageTitleTest() {
		cncpage.clicksuntrustAdvangeTab();
	String title = driver.getTitle();
	Assert.assertEquals(title, "SunTrust OneTeam Financial Advantage | SunTrust Corporate Banking");
	}

}
