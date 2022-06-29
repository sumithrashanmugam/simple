package disableAndEnable;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pickupdisable extends EsaUtility{
	 public static ExtentReports extent;
		ExtentHtmlReporter reporter;
		public static ExtentTest test;
		public static WebDriver driver;
		@BeforeSuite
		public void setup() {
			reporter = new ExtentHtmlReporter("E:\\Simple\\reports.html");
			extent = new ExtentReports();
			reporter.setAppendExisting(true);
	        extent.attachReporter(reporter);
		}
	@Test(dataProvider = "EsaAdminData" )
	public void Login(String url,String email,String pass) throws IOException {
		try {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		test = extent.createTest("loginpickupuser");
		driver.get(url);
		test.pass("Navigated to channelsmart");
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.getTitle();
		test.pass("email is passed");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		test.pass("Given password ");
		driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);
		

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Users']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", User);
		
		//Disable
		WebElement disable=driver.findElement(By.xpath("//div[@class='mat-slide-toggle-thumb']"));
		disable.click();
		
		WebElement dis1=driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']"));
	    dis1.click();
	    String dd=dis1.getText();
		System.out.println("Disable the pickupUser:::::"+dd);
		test.info("Disabled the pickuser::::"+dd);
		}
		
        catch (Error e) {
        	test.log(Status.FAIL,e.getCause());
        	test.getStatus();
        	//test.error(e.getMessage());
        	
		}
	}
	
	@AfterSuite
	public void stopReports() {
		extent.flush();
		driver.close();
	}
	}
