package disenEsa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EsaUseDisable extends Utilies{
	public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void setup() {
		//set up the physical report path
		reporter = new ExtentHtmlReporter("E:\\Simple\\reports\\result.html");
		//Create an object for extent reports
		extent = new ExtentReports();
		//To retain the history
		reporter.setAppendExisting(true);
		//Attach the data with physical file
		extent.attachReporter(reporter);
	}

	@Test(dataProvider = "EnableEsa")	
	public void  createEsaUser(String data[]) throws Exception {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			test = extent.createTest("EsaUserLogin","Login with positive credentials");
			driver.get(data[0]);
			test.pass("navigate to chromedriver");
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data[1]);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(data[2]);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			String title= driver.getTitle();
			System.out.println("title is"+title);


			WebElement user=driver.findElement(By.xpath("//a[@href='/users']"));
			user.click();

			WebElement disable=driver.findElement(By.xpath("//div[@class='mat-slide-toggle-thumb'][1]"));
			disable.click();
			test.info("Disabled a esa user..");

		}
		catch (Exception e) {
			test.log(Status.PASS,e.getMessage());
		}
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@AfterSuite
	public void stopReports() {
		extent.flush();
		driver.close();
	}
}




