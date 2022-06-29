package pickUpUser;
import java.time.Duration;
import java.util.ArrayList;

import javax.naming.directory.NoSuchAttributeException;

import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.PRINT_SCALING;
import org.bytedeco.javacpp.tools.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
public class User extends Utils {
    public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void setup() {
		//set up the physical report path
		reporter = new ExtentHtmlReporter("./reports/result.html");
		//Create an object for extent reports
		extent = new ExtentReports();
		//To retain the history
		reporter.setAppendExisting(true);
		//Attach the data with physical file
		extent.attachReporter(reporter);
		//s ffailue
		
	}
	@Test(dataProvider = "Data" )
	public void Login(String email,String pass,String firstName,String lastName,String emailid,String contactNo,String password) throws Exception {
		try {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		test = extent.createTest("loginpickupuser");
		driver.get("http://d2ggk2m8z3e33q.cloudfront.net/auth/signin");
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
		
		
		WebElement  clickServices =driver.findElement(By.xpath("//*[@id=\"mat-select-2\"]/div/div[2]/div")); 
		clickServices.click();
	    
		WebElement clickService=driver.findElement(By.xpath("//span[text()='Surface']"));
	    clickService.click();
	
	    WebElement user = driver.findElement(By.xpath("//span[text()='Add']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", user);

	    //driver.navigate().refresh();
		
		WebElement user2 = driver.findElement(By.xpath("//div[@ng-reflect-ng-switch='false']/following-sibling::div[1]"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", user2);
		
		
		WebElement click1=driver.findElement(By.xpath("//mat-option[@id='mat-option-3']//span[1]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", click1);
		driver.getTitle();
		
		WebElement edit = driver.findElement(By.xpath("//mat-icon[text()='edit']"));
		edit.click();
		System.out.println(edit);

		ArrayList<String> excelDt = Data.validArrayList();
		System.out.println("my excel data---"+excelDt);
		ArrayList<String> datatd= new ArrayList<String>();
		
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
		
		datatd.add(f_name.toUpperCase());
		String a=datatd.get(0);
		System.out.println(a);
		datatd.add(l_name1.toUpperCase());
		String b=datatd.get(1);
		System.out.println(b);
		datatd.add(email_id.toUpperCase());
		String c=datatd.get(2);
		System.out.println(c);
		datatd.add(Contact_no.toUpperCase());
		String d=datatd.get(3);
		System.out.println(d);
		//label.add(Password);
		System.out.println("my datalist is::: "+datatd);
		int s=datatd.size();
		System.out.println("size---"+s);
	    
		Assert.assertEquals(datatd,excelDt); 
		test.info("All Data are validated successfully..");
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



