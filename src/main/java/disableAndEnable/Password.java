package disableAndEnable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Password extends EsaUtility {
	 public static ExtentReports extent;
		ExtentHtmlReporter reporter;
		public static ExtentTest test;
		public static WebDriver driver;
		@BeforeSuite
		public void setup() {
			reporter = new ExtentHtmlReporter("E:\\Simple\\reports\\result.html");
			extent = new ExtentReports();
			reporter.setAppendExisting(true);
	        extent.attachReporter(reporter);
		}
	@Test(dataProvider = "EsaAdminData" )
	public void Login(String url,String email,String pass) throws Exception {
		try {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Change password']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Password);
		
	    //enable the user
		//WebElement enable=driver.findElement(By.xpath("//div[@class='mat-slide-toggle-thumb']"));
		//enable.click();
		
		WebElement change_pass=driver.findElement(By.xpath("//input[@type='password']"));
	    change_pass.sendKeys("password1");
	    System.out.println("old password"+change_pass);
	    

		WebElement new_pass=driver.findElement(By.xpath("(//input[@type='password'])[2]"));
	    new_pass.sendKeys("password");
	    System.out.println("new password"+new_pass);
	    
	    WebElement Submit=driver.findElement(By.xpath("//button[text()='Submit']"));
	    Submit.click();
	    System.out.println("Disable the user"+Submit);
	    String dd=Submit.getAttribute("value");
		System.out.println("password change for pickuser::::"+dd);
		test.info("password change for pickuser::::"+dd);
		}
	    
	  
		
catch (Error e) {
	test.log(Status.FAIL,e.getCause());
	test.getStatus();
	
}
	}
	
	@AfterSuite
	public void stopReports() {
		extent.flush();
		driver.close();
	}
	}


