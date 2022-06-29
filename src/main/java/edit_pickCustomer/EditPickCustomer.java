package edit_pickCustomer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
public class EditPickCustomer extends EditPickCustomerUtils {
	public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void setup() {
		//set up the physical report path
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
	
	@Test(dataProvider= "CustomerEdit")
	public void EditCustomer(String email,String pass,String customerno,String name,String address1,String address2,String address3,String companyname,String city,String pin,String state,String phoneno,String emailid) throws Exception {
		try {
		test = extent.createTest("EsaUserLogin","Login with positive credentials");
		driver.get("http://d2ggk2m8z3e33q.cloudfront.net/auth/signin");
		test.pass("navigate to chromedriver");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);

		driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);

		WebElement clk=driver.findElement(By.xpath("//a[@href='/customersDetails']"));
		clk.click();

		WebElement edit1 = driver.findElement(By.xpath("//mat-icon[text()='edit']"));
	    edit1.click();
		
		WebElement Customer_Code=driver.findElement(By.xpath("//input[@formcontrolname='customer_code']"));
		Customer_Code.clear();
		Customer_Code.sendKeys(customerno);
		String Customer=Customer_Code.getAttribute("value");
		Assert.assertEquals(Customer, customerno);
		System.out.println("CustomerCode is validated::  "+Customer);

	    WebElement username=driver.findElement(By.xpath("//input[@formcontrolname='username']"));
		username.clear();
		username.sendKeys(name);
		String UserName=username.getAttribute("value");
		Assert.assertEquals(UserName,name );
		System.out.println(" is validated::  "+UserName);
		
		
		WebElement address_1=driver.findElement(By.xpath("//input[@formcontrolname='addressline1']"));
		address_1.clear();
		address_1.sendKeys(address1);
		String Address1 =address_1.getAttribute("value");
		Assert.assertEquals(Address1,address1 );
		System.out.println(" is validated::  "+Address1);
		
		
		WebElement address_2=driver.findElement(By.xpath("//input[@formcontrolname='addressline2']"));
	    address_2.clear();
		address_2.sendKeys(address2);
	    String Address2 =address_2.getAttribute("value");
		Assert.assertEquals(Address2, address2);
		System.out.println(" is validated::  "+Address2);
		
		WebElement address_3=driver.findElement(By.xpath("//input[@formcontrolname='addressline3']"));
		address_3.clear();
		address_3.sendKeys(address3);
	    String Address3 =address_3.getAttribute("value");
		Assert.assertEquals(Address3, address3);
		System.out.println(" is validated::  "+Address3);
			
		
		WebElement company=driver.findElement(By.xpath("//input[@formcontrolname='company_name']"));
		company.clear();
		company.sendKeys(companyname);
		String Company=company.getAttribute("value");
		Assert.assertEquals(Company,companyname );
		System.out.println(" is validated::  "+Company);
		
		WebElement cty=driver.findElement(By.xpath("//input[@formcontrolname='city']"));
		cty.clear();
		cty.sendKeys(city);
		String City=cty.getAttribute("value");
		Assert.assertEquals(City,city );
		System.out.println(" is validated::  "+City);
		
		WebElement pincode=driver.findElement(By.xpath("//input[@formcontrolname='pincode']"));
		pincode.clear();
		pincode.sendKeys(pin);
		String Pincode =pincode.getAttribute("value");
		Assert.assertEquals(Pincode,pin );
		System.out.println(" is validated::  "+Pincode);
		
		WebElement st=driver.findElement(By.xpath("//input[@formcontrolname='state']"));
		st.clear();
		st.sendKeys(state);
		String State=st.getAttribute("value");
		Assert.assertEquals(State,state );
		System.out.println(" is validated::  "+State);
		
		WebElement phone_number =driver.findElement(By.xpath("//input[@formcontrolname='phone_number']"));
		phone_number.clear();
		phone_number.sendKeys(phoneno);
		String Phone_number =phone_number.getAttribute("value");
		Assert.assertEquals(Phone_number,phoneno );
		System.out.println(" is validated::  "+Phone_number);
		
		WebElement email_id=driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email_id.clear();
		email_id.sendKeys(emailid);
		String Email=email_id.getAttribute("value");
		Assert.assertEquals(Email,emailid );
		System.out.println(" is validated::  "+Email);
		
	    WebElement update=driver.findElement(By.xpath("//span[text()='Update']"));
		update.click();
	    
		driver.navigate().refresh();
		//Object timeout = 20;
		//new WebDriverWait(driver, (long) timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[@color='primary']")));
		//driver.findElement(By.xpath("//mat-icon[@color='primary']")).click();
	
		WebElement edit = driver.findElement(By.xpath("//mat-icon[@color='primary']"));
		edit.click();
	
		
        ArrayList<String> dtedit=EditPickCustomerData.ArrayEdit();
        System.out.println("my excel data::"+dtedit);
		ArrayList<String> lbledit = new ArrayList<String>();

		
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
		
        lbledit.add(Customer1);
		lbledit.add(UserName1.toUpperCase());
		lbledit.add(Address_1.toUpperCase());
		lbledit.add(Address_2.toUpperCase());
		lbledit.add(Address_3.toUpperCase());
		lbledit.add(Company1.toUpperCase());
		lbledit.add(City1.toUpperCase());
		lbledit.add(Pincode1);
		lbledit.add(State1.toUpperCase());
		lbledit.add(Phone_number1);
		lbledit.add(Email1.toUpperCase());
		
		System.out.println("my datalist is::: "+lbledit);
		int s=lbledit.size();
		System.out.println("size---"+s);
		
		
		Assert.assertEquals(dtedit, lbledit);
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
