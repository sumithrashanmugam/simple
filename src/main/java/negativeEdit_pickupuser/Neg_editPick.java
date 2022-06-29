package negativeEdit_pickupuser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pickUpUser.Data;

public class Neg_editPick extends Neg_editpickUtils {
	public static ExtentReports extent;
		ExtentHtmlReporter reporter;
		public static ExtentTest test;
		public static WebDriver driver;
		@BeforeSuite
		public void setup() {
			//set up the physical report path
			reporter = new ExtentHtmlReporter("/Simple/reports/result.html");
			//Create an object for extent reports
			extent = new ExtentReports();
			//To retain the history
			reporter.setAppendExisting(true);
			//Attach the data with physical file
			extent.attachReporter(reporter);
			//s ffailue
			
		}
		@Test(dataProvider = "NegData" )
		public void Login(String url,String email,String pass,String firstName,String lastName,String emailid,String contactNo,String password) throws Exception {
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
			WebElement User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/users']")));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", User);
			
			WebElement user1 = driver.findElement(By.xpath("//mat-icon[text()='add']"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", user1);
			
			WebElement fName=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
			fName.sendKeys(firstName);
			String fname=fName.getAttribute("value");
			Assert.assertEquals(fname, firstName);
			System.out.println("first name is validated");

			WebElement lName=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
			lName.sendKeys(lastName);
			String lname=lName.getAttribute("value");
			Assert.assertEquals(lname, lastName);
			System.out.println("last name is validated");
			
			WebElement email1=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
			email1.sendKeys(emailid);
			String Email=email1.getAttribute("value");
			Assert.assertEquals(Email, emailid);
			System.out.println("email.id is validated");
			
			WebElement contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
			contact.sendKeys(contactNo);
			String No=contact.getAttribute("value");
			Assert.assertEquals(No, contactNo);
			System.out.println("number is validated");
			
			
			WebElement pwd=driver.findElement(By.xpath("//input[@formcontrolname='password']"));
			pwd.sendKeys(password);
			String Pwd=pwd.getAttribute("value");
			Assert.assertEquals(Pwd, password);
			System.out.println("password is validated");
			
			
			WebElement  clickServices =driver.findElement(By.xpath("(//div[@ng-reflect-ng-switch='true']/following-sibling::div)[2]")); 
			clickServices.click();
		    
			WebElement clickService=driver.findElement(By.xpath("//span[text()='Surface']"));
		    clickService.click();
		
		    WebElement user = driver.findElement(By.xpath("//span[text()='Add']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", user);

		    //driver.navigate().refresh();
			
			Alert alert = driver.switchTo().alert();
			System.out.println("requirements are not filled properly:::"+alert.getText());
			}
			catch (Exception e) {
				// TODO: handle exception
			
			//WebElement user3 = driver.findElement(By.xpath("//*[@id=\"mat-select-3\"]/div/div[2]/div"));
			//JavascriptExecutor executor31 = (JavascriptExecutor)driver;
			//executor31.executeScript("arguments[0].click();", user3);
			File userScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//FileHandler fileHandler = new FileHandler();
	
			FileHandler.copy(userScreenShot, new File("./snaps/user.png"));
			
			try {
				test.log(Status.FAIL, "Failed Shipment:: ",MediaEntityBuilder.createScreenCaptureFromPath("./snaps/user.png").build());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			}
		}
}
		
		
			