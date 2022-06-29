package pickupCustomer;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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


public class Customer extends Utils1 {
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
	@Test(dataProvider= "CustomerData")
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
		
		/*WebElement pan_card=driver.findElement(By.xpath("//input[@formcontrolname='pancard_number']"));
	    pan_card.sendKeys(pancard);
	    String Pancard=pan_card.getAttribute("value");
	    Assert.assertEquals(Pancard, pancard);
	    System.out.println("pancard is validated::  "+Pancard);
	    
		WebElement Aadhaar_card=driver.findElement(By.xpath("//input[@formcontrolname='aadhaar_number']"));
		Aadhaar_card.sendKeys(aadhaar);
		String Aadhaar=Aadhaar_card.getAttribute("value");
		Assert.assertEquals(Aadhaar,aadhaar);
		System.out.println("Aadhaar is validated::  "+Aadhaar);*/
		
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
		
		//WebDriverWait wait1 = new WebDriverWait(driver, 20);
		//wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add']")));
		
		
		WebElement searchButton = driver.findElement(By.xpath("//span[text()='Add']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchButton);
		//WebElement Add= driver.findElement(By.xpath("//span[text()='Add']"));
		//Add.click();
		
		
		//driver.navigate().refresh();
		//driver.close();
		
		
		
		
		WebElement edit = driver.findElement(By.xpath("//mat-icon[text()='edit']"));
		edit.click();
		//System.out.println(edit);
		
		ArrayList<String> dt= Data1.ArrayList();
        System.out.println("my excel data::"+dt);
		ArrayList<String> lbl = new ArrayList<String>();

	/*	WebElement pan_card1=driver.findElement(By.xpath("//input[@formcontrolname='pancard_number']"));
	    String Pancard1=pan_card1.getAttribute("value");
	    System.out.println("pancard is validated::  "+Pancard1);
	    
		WebElement Aadhaar_card1=driver.findElement(By.xpath("//input[@formcontrolname='aadhaar_number']"));
		String Aadhaar1=Aadhaar_card1.getAttribute("value");
		System.out.println("Aadhaar is validated::  "+Aadhaar1);*/
		
		WebElement Customer_Code1=driver.findElement(By.xpath("//input[@formcontrolname='customer_code']"));
	    String Customer1=Customer_Code1.getAttribute("value");
		System.out.println("CustomerCode is validated::  "+Customer1);

        WebElement username1=driver.findElement(By.xpath("//input[@formcontrolname='username']"));
		String UserName1=username1.getAttribute("value");
		System.out.println(" is validated::  "+UserName1);
		
		
		WebElement address_11=driver.findElement(By.xpath("//input[@formcontrolname='addressline1']"));
        String Address_1 =address_11.getAttribute("value");
		System.out.println(" is validated::  "+Address_1);
		
		WebElement address_21=driver.findElement(By.xpath("//input[@formcontrolname='addressline2']"));
	    String Address_2 =address_21.getAttribute("value");
		System.out.println(" is validated::  "+Address_2);
		
		WebElement address_31=driver.findElement(By.xpath("//input[@formcontrolname='addressline3']"));
		String Address_3 =address_31.getAttribute("value");
	    System.out.println(" is validated::  "+Address_3);
			
		
		WebElement company1=driver.findElement(By.xpath("//input[@formcontrolname='company_name']"));
	    String Company1=company1.getAttribute("value");
	    System.out.println(" is validated::  "+Company1);
		
		WebElement cty1=driver.findElement(By.xpath("//input[@formcontrolname='city']"));
	    String City1=cty1.getAttribute("value");
	    System.out.println(" is validated::  "+City1);
		
		WebElement pincode1=driver.findElement(By.xpath("//input[@formcontrolname='pincode']"));
		String Pincode1 =pincode1.getAttribute("value");
		System.out.println(" is validated::  "+Pincode1);
		
		WebElement st1=driver.findElement(By.xpath("//input[@formcontrolname='state']"));
	    String State1=st1.getAttribute("value");
		System.out.println(" is validated::  "+State1);
		
		WebElement phone_number1 =driver.findElement(By.xpath("//input[@formcontrolname='phone_number']"));
		String Phone_number1 =phone_number1.getAttribute("value");
		System.out.println(" is validated::  "+Phone_number1);
		
		WebElement email_id1=driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		String Email1=email_id1.getAttribute("value");
		System.out.println(" is validated::  "+Email1);
		

		
		//lbl.add(Pancard1);
		//lbl.add(Aadhaar1);
		lbl.add(Customer1);
		lbl.add(UserName1.toUpperCase());
		lbl.add(Address_1.toUpperCase());
		lbl.add(Address_2.toUpperCase());
		lbl.add(Address_3.toUpperCase());
		lbl.add(Company1.toUpperCase());
		lbl.add(City1.toUpperCase());
		lbl.add(Pincode1);
		lbl.add(State1.toUpperCase());
		lbl.add(Phone_number1);
		lbl.add(Email1.toUpperCase());
		
		System.out.println("my datalist is::: "+lbl);
		int s=lbl.size();
		System.out.println("size---"+s);
		Assert.assertEquals(dt, lbl);
		

		test.info("All Data are validated successfully..");
		
		}
catch (Exception e) {
		test.log(Status.FAIL,e.getMessage());
	
	}
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
