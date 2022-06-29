package negativePickup_customer;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
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
import org.testng.Assert;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import negativePickup_customer.Neg_pickupUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class neg_pickCust extends Neg_pickupUtils {
	public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void startReport() {
		//physical report path
		reporter = new ExtentHtmlReporter("E:\\Simple\\reports");
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(dataProvider= "NegCustomerData")
	public void Login(String url,String email,String pass,String customerno,String name,String address1,String address2,String address3,String companyname,String city,String pin,String state,String phoneno,String emailid) throws Exception {
        try {
		test = extent.createTest("customerLogin");
		driver.get(url);
		test.pass("navigate to url");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		test.pass("email is passed");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
        test.pass("password is given");
		driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);

		WebElement clk=driver.findElement(By.xpath("//a[@href='/customersDetails']"));
		clk.click();

	
		
		WebElement clickCustomer=driver.findElement(By.xpath("//span[text()=' Add Customer ']"));
		clickCustomer.click();
		
		
		WebElement Customer_Code=driver.findElement(By.xpath("//input[@formcontrolname='customer_code']"));
		Customer_Code.sendKeys(customerno);
		String Customer=Customer_Code.getAttribute("value");
		Assert.assertEquals(Customer, customerno);
		System.out.println("CustomerCode is validated::  "+Customer);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@ng-reflect-ng-switch='true']/following-sibling::div[1]")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", User);
		
		WebElement Apex=driver.findElement(By.xpath("(//span[@class='mat-option-text'])[2]"));
		Apex.click();

		WebElement username=driver.findElement(By.xpath("//input[@formcontrolname='username']"));
		username.sendKeys(name);
		String UserName=username.getAttribute("value");
		Assert.assertEquals(UserName,name );
		System.out.println(" is validated::  "+UserName);
		
		
		WebElement address_1=driver.findElement(By.xpath("//input[@formcontrolname='addressline1']"));
		address_1.sendKeys(address1);
		String Address1 =address_1.getAttribute("value");
		Assert.assertEquals(Address1,address1 );
		System.out.println(" is validated::  "+Address1);
		
		
		WebElement address_2=driver.findElement(By.xpath("//input[@formcontrolname='addressline2']"));
	    address_2.sendKeys(address2);
	    String Address2 =address_2.getAttribute("value");
		Assert.assertEquals(Address2, address2);
		System.out.println(" is validated::  "+Address2);
		
		WebElement address_3=driver.findElement(By.xpath("//input[@formcontrolname='addressline3']"));
		address_3.sendKeys(address3);
	    String Address3 =address_3.getAttribute("value");
		Assert.assertEquals(Address3, address3);
		System.out.println(" is validated::  "+Address3);
			
		
		WebElement company=driver.findElement(By.xpath("//input[@formcontrolname='company_name']"));
		company.sendKeys(companyname);
		String Company=company.getAttribute("value");
		Assert.assertEquals(Company,companyname );
		System.out.println(" is validated::  "+Company);
		
		WebElement cty=driver.findElement(By.xpath("//input[@formcontrolname='city']"));
		cty.sendKeys(city);
		String City=cty.getAttribute("value");
		Assert.assertEquals(City,city );
		System.out.println(" is validated::  "+City);
		
		WebElement pincode=driver.findElement(By.xpath("//input[@formcontrolname='pincode']"));
		pincode.sendKeys(pin);
		String Pincode =pincode.getAttribute("value");
		Assert.assertEquals(Pincode,pin );
		System.out.println(" is validated::  "+Pincode);
		
		WebElement st=driver.findElement(By.xpath("//input[@formcontrolname='state']"));
		st.sendKeys(state);
		String State=st.getAttribute("value");
		Assert.assertEquals(State,state );
		System.out.println(" is validated::  "+State);
		
		WebElement phone_number =driver.findElement(By.xpath("//input[@formcontrolname='phone_number']"));
		phone_number.sendKeys(phoneno);
		String Phone_number =phone_number.getAttribute("value");
		Assert.assertEquals(Phone_number,phoneno );
		System.out.println(" is validated::  "+Phone_number);
		
		WebElement email_id=driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email_id.sendKeys(emailid);
		String Email=email_id.getAttribute("value");
		Assert.assertEquals(Email,emailid );
		System.out.println(" is validated::  "+Email);
		
		WebElement ele = driver.findElement(By.xpath("//label[@class='mat-checkbox-layout']//div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		
		
		WebElement searchButton = driver.findElement(By.xpath("//span[text()='Add']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchButton);
		
		Alert alert = driver.switchTo().alert();
		System.out.println("requirements are not filled properly:::"+alert.getText());
		
		}
		catch (Exception e) {
			// TODO: handle exception
		
	
		File userScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		

		FileHandler.copy(userScreenShot, new File("./snaps/user.png"));
		
		try {
			test.log(Status.FAIL, "Failed Shipment:: ",MediaEntityBuilder.createScreenCaptureFromPath("./snaps/user.png").build());
		} catch (IOException e2) {
			
			//e2.printStackTrace();
			e2.getStackTrace()[0].getLineNumber();
		}
		
		}
	}

}
