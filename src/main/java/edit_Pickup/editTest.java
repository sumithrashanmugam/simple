package edit_Pickup;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class editTest extends editUtils {
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
	@Test(dataProvider = "EditData" )
	public void EditPickup(String url,String email,String pass,String firstName,String lastName,String emailid,String contactNo,String password) throws Exception {
	try {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		test = extent.createTest("EsaUserLogin","Login with positive credentials");
		driver.get(url);
		test.pass("navigate to chromedriver");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.getTitle();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		
		driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Users']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", User);
		
		
		
		WebElement Edit=driver.findElement(By.xpath("//mat-icon[text()='edit']"));
		Edit.click();
		
		WebElement fName=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
		fName.clear();
		fName.sendKeys(firstName);
		String fname=fName.getAttribute("value");
		Assert.assertEquals(fname, firstName);
		System.out.println("first name is validated");
		
		WebElement lName=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
		lName.clear();
		lName.sendKeys(lastName);
		String lname=lName.getAttribute("value");
		Assert.assertEquals(lname, lastName);
		System.out.println("last name is validated");
		
		
		WebElement email1=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		email1.clear();
		email1.sendKeys(emailid);
		String Email=email1.getAttribute("value");
		Assert.assertEquals(Email, emailid);
		System.out.println("email.id is validated");
		
		WebElement contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
		contact.clear();
		contact.sendKeys(contactNo);
		String No=contact.getAttribute("value");
		Assert.assertEquals(No, contactNo);
		System.out.println("number is validated");
		
		
		WebElement pwd=driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		pwd.clear();
		pwd.sendKeys(password);
		String Pwd=pwd.getAttribute("value");
		Assert.assertEquals(Pwd, password);
		System.out.println("password is validated");
		
		
		WebElement  clickServices =driver.findElement(By.xpath("//mat-select[@id='mat-select-2']/div[1]/div[2]/div[1]")); 
		clickServices.click();
	    
		WebElement ele = driver.findElement(By.xpath("//span[text()='Surface']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		//WebElement clickService=driver.findElement(By.xpath("//span[text()='Surface']"));
	    //clickService.click();
	    
	
		WebElement User1 = driver.findElement(By.xpath("(//span[@class='mat-option-text'])[2]"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", User1);
	    
		WebElement User2 = driver.findElement(By.xpath("//span[text()='DomesticPriority']"));
		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("arguments[0].click();", User2);
	    
	    
	   // WebElement clickService2=driver.findElement(By.xpath("//span[text()='DomesticPriority']"));
	  //  clickService2.click();
	    
	    
	
	    WebElement user = driver.findElement(By.xpath("//span[text()='Update']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", user);

	 
		
	 driver.navigate().refresh();
		
		WebElement edit = driver.findElement(By.xpath("//mat-icon[text()='edit']"));
		edit.click();
		System.out.println(edit);

		ArrayList<String> excDt = editData.List();
		System.out.println("my excel data---"+excDt);
		ArrayList<String> dattd= new ArrayList<String>();
		
	    WebElement validate_fname=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
		String f_name=validate_fname.getAttribute("value");
	    System.out.println("created firstname::"+f_name);
		
		WebElement validate_lname=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
		String l_name1=validate_lname.getAttribute("value");
		System.out.println("created lastname::"+l_name1);
		
		WebElement validate_email=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		String email_id=validate_email.getAttribute("value");
		System.out.println("email.id is validated::"+email_id);
		
		WebElement validate_contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
		String Contact_no=validate_contact.getAttribute("value");
		System.out.println("number is validated::"+Contact_no);
		
	
		
		dattd.add(f_name.toUpperCase());
		
		dattd.add(l_name1.toUpperCase());
		
		dattd.add(email_id.toUpperCase());
		
		dattd.add(Contact_no.toUpperCase());
		
		System.out.println("my datalist is::: "+dattd);
		
	
	    
		 
		Assert.assertEquals(dattd, excDt);
		test.info("All Data are validated successfully..");
		
		}
catch (Exception e) {
		test.log(Status.FAIL,e.getMessage());
	}
	}
	
	@AfterSuite
	public void stopReports() {
		extent.flush();
		driver.close();
	}
	

}

