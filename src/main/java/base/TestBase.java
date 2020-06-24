package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtil;
import utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	public static WebDriverWait wait;
	public SoftAssert sa;
	public static ExtentReports extent;

	@BeforeMethod
	@Parameters({ "browser", "url" })

	public void initialize(String browser, String url) throws Exception {

//		DesiredCapabilities cap = new DesiredCapabilities().chrome();
//		
//		
//		cap.setBrowserName("chrome");
//		cap.setPlatform(Platform.MAC);
//		
//		
//		ChromeOptions chrome = new ChromeOptions();
//		chrome.merge(cap);
//		
//		String hubURL = " http://10.0.0.161:4444/wd/hub";
//		WebDriver driver = new RemoteWebDriver(new URL(hubURL), cap);
//		

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("enter browser name");
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();

		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(url);
	}

	public TestBase() {
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					"/Users/chrislebron/eclipse-workspace/June20POMFramework/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<WebElement> getListOfWebElementsByTag(String option) {
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.tagName("a"));

		return list;
	}

	public void clickOn(WebDriver driver, WebElement element, int timeout) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void getPageTitle(WebDriver driver, int timeout, String title) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(title));

	}

	public void clickOnElement(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
		} else if (!element.isDisplayed()) {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	}

	public void selectOptionByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

//	@AfterTest
//	public void AfterTest() {
//		sa.assertAll();
//	}
}
