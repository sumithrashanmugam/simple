package subAdminEsa;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pickUpUser.Data;

public class SubAdminUser extends SubUtils {
	public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void startReport() {
		//physical report path
		reporter = new ExtentHtmlReporter("E:\\Simple\\reports.html");
		//Create an object for extent reports
		extent = new ExtentReports();
		//To retain the history
		reporter.setAppendExisting(true);
		//Attach the data with physical file
		extent.attachReporter(reporter);
	}
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test(dataProvider= "SudAdminData")
	public void Login(String url,String email,String pass,String firstName,String lastName,String password,String contactNo,String emailid) throws Exception {
		test = extent.createTest("SubLogin","Login with positive credentials");
		driver.get(url);
		test.pass("Navigated to channelsmart");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);

		driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);
		

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Users']")));
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
		
		WebElement pwd=driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		pwd.sendKeys(password);
		String Pwd=pwd.getAttribute("value");
		Assert.assertEquals(Pwd, password);
		System.out.println("password is validated");
		
		WebElement contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
		contact.sendKeys(contactNo);
		String No=contact.getAttribute("value");
		Assert.assertEquals(No, contactNo);
		System.out.println("number is validated");
		
		WebElement email1=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		email1.sendKeys(emailid);
		String Email=email1.getAttribute("value");
		Assert.assertEquals(Email, emailid);
		System.out.println("email.id is validated");
		
	    WebElement user = driver.findElement(By.xpath("//span[text()='Add']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", user);
		
		driver.navigate().refresh();
		
		WebElement edit = driver.findElement(By.xpath("//tbody/tr[5]/td[5]/mat-icon[1]"));
		edit.click();
		System.out.println(edit);

		ArrayList<String> exceldata = SubData.valid();
		System.out.println("my excel data---"+exceldata);
		ArrayList<String> valdiation= new ArrayList<String>();
		
	    WebElement validate_fname=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
        String f_name=validate_fname.getAttribute("value");
        System.out.println("created firstname::"+f_name);
		
	
		
		WebElement validate_contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
		String Contact_no=validate_contact.getAttribute("value");
		System.out.println("number is validated::"+Contact_no);
		
		
		WebElement validate_email=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		String email_id=validate_email.getAttribute("value");
		System.out.println("email.id is validated::"+email_id);
		
		valdiation.add(f_name.toUpperCase());
		
		valdiation.add(Contact_no.toUpperCase());
		valdiation.add(email_id.toUpperCase());
	
		System.out.println("my datalist is::: "+valdiation);
		int s=valdiation.size();
		System.out.println("size---"+s);
	    
		Assert.assertEquals(valdiation, exceldata);
		test.log(Status.PASS,f_name);
		test.log(Status.PASS,Contact_no);
		test.log(Status.PASS,email_id);

		test.info("All Data are validated successfully..");
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@AfterSuite
	public void stopReports() {
		extent.flush();
	}
}

		
		


