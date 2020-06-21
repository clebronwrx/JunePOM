package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	public static WebDriverWait wait;

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void initialize(String browser, String url) {

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

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
