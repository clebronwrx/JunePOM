package ExtentReport;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private ExtentManager() {
		
	}
	public static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("/Users/chrislebron/eclipse-workspace/June20POMFramework/reports/");
		//new File(directory).MacDraw's();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Name", "Chris Lebron");
		extent.setSystemInfo("OS", "Mac");
		extent.setSystemInfo("browser", "chrome");
		extent.attachReporter(htmlReporter);
		
		return extent;
	}
	
	

	public static String getReportName() {
		Date date = new Date();
		String fileName = "Automation Report" + "_" + date.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;

	}
}
