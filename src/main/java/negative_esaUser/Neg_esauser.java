package negative_esaUser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Neg_esauser extends Neg_esaUtils{

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

	@Test(dataProvider = "NegEsa")	
	public void  NegcreateEsaUser(String data[]) throws Exception {
		try {
			test = extent.createTest("EsaUserLogin","Login with positive credentials");
	        WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			test.pass("navigate to chromedriver");
			driver.get(data[0]);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data[1]);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(data[2]);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			String title= driver.getTitle();
			System.out.println("title is"+title);

            WebElement user=driver.findElement(By.xpath("//a[@href='/users']"));
			user.click();

			WebElement ele = driver.findElement(By.xpath("//mat-icon[@role='img']"));
			JavascriptExecutor exe = (JavascriptExecutor)driver;
			exe.executeScript("arguments[0].click();", ele); 

			WebElement Esa_id=driver.findElement(By.xpath("//input[@formcontrolname='esa_id']"));
			Esa_id.sendKeys(data[3]);
			String esaid=Esa_id.getAttribute("value");
			Assert.assertEquals(esaid, data[3]);
			System.out.println("given esaid:: "+esaid);

			WebElement password=driver.findElement(By.xpath("//input[@formcontrolname='password']"));
			password.sendKeys(data[4]);
			String Password=password.getAttribute("value");
			Assert.assertEquals(Password, data[4]);
			System.out.println("given password:: "+Password);


			WebElement first_name=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
			first_name.sendKeys(data[5]);
			String First_name= first_name.getAttribute("value");
			Assert.assertEquals(First_name, data[5]);
			System.out.println("given firstname:: "+First_name);


			WebElement last_name=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
			last_name.sendKeys(data[6]);
			String  Last_name= last_name.getAttribute("value");
			Assert.assertEquals( Last_name, data[6]);
			System.out.println("given lastname:: "+Last_name);

			WebElement contact_number=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
			contact_number.sendKeys(data[7]);
			String Contact_number=contact_number.getAttribute("value");
			Assert.assertEquals(Contact_number, data[7]);
			System.out.println("given contact:: "+Contact_number);

			WebElement email_id=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
			email_id.sendKeys(data[8]);
			String  Email_id= email_id.getAttribute("value");
			Assert.assertEquals( Email_id, data[8]);
			System.out.println("given emailid:: "+ Email_id);

			WebElement add1 =driver.findElement(By.xpath("//input[@formcontrolname='address_1']"));
			add1.sendKeys(data[9]);
			String Add1=add1.getAttribute("value");
			Assert.assertEquals(Add1, data[9]);
			System.out.println("given Address1:: "+Add1);

			WebElement add2 =driver.findElement(By.xpath("//input[@formcontrolname='address_2']"));
			add2.sendKeys(data[10]);
			String Add2=add2.getAttribute("value");
			Assert.assertEquals(Add2,data[10]);
			System.out.println("given Address2:: "+Add2);


			WebElement add3 =driver.findElement(By.xpath("//input[@formcontrolname='address_3']"));
			add3.sendKeys(data[11]);
			String Add3=add3.getAttribute("value");
			Assert.assertEquals(Add3, data[11]);
			System.out.println("given Address3:: "+Add3);

			WebElement city=driver.findElement(By.xpath("//input[@formcontrolname='city']"));
			city.sendKeys(data[12]);
			String City=city.getAttribute("value");
			Assert.assertEquals(City, data[12]);
			System.out.println("given city:: "+City);

			WebElement state=driver.findElement(By.xpath("//input[@formcontrolname='state']"));
			state.sendKeys(data[13]);
			String State=state.getAttribute("value");
			Assert.assertEquals(State, data[13]);
			System.out.println("given state:: "+State);

			WebElement country=driver.findElement(By.xpath("//input[@formcontrolname='country']"));
			country.sendKeys(data[14]);
			String Country=country.getAttribute("value");
			Assert.assertEquals(Country,data[14]);
			System.out.println("given country:: "+Country);

			WebElement countrycode=driver.findElement(By.xpath("//input[@formcontrolname='country_code']"));
			countrycode.sendKeys(data[15]);
			String Countrycode=countrycode.getAttribute("value");
			Assert.assertEquals(Countrycode,data[15]);
			System.out.println("given countrycode:: "+Countrycode);

			WebElement postalcode=driver.findElement(By.xpath("//input[@formcontrolname='postal_code']"));
			postalcode.sendKeys(data[16]);
			String Postalcode=postalcode.getAttribute("value");
			Assert.assertEquals(Postalcode, data[16]);
			System.out.println("given Postalcode:: "+Postalcode);

			WebElement aadhaar=driver.findElement(By.xpath("//input[@formcontrolname='aadhaar_number']"));
			aadhaar.sendKeys(data[17]);
			String Aadhaar=aadhaar.getAttribute("value");
			Assert.assertEquals(Aadhaar, data[17]);
			System.out.println("given aadhaar:: "+Aadhaar);

			WebElement license=driver.findElement(By.xpath("//input[@formcontrolname='license_key']"));
			license.sendKeys(data[18]);
			String License=license.getAttribute("value");
			Assert.assertEquals(License,data[18]);
			System.out.println("given license:: "+License);

			WebElement area_code =driver.findElement(By.xpath("//input[@formcontrolname='area_code']"));
			area_code.sendKeys(data[19]);
			String  Area_code= area_code.getAttribute("value");
			Assert.assertEquals( Area_code,data[19]);
			System.out.println("given areacode:: "+ Area_code);

			WebElement login =driver.findElement(By.xpath("//input[@formcontrolname='login_id']"));
			login.sendKeys(data[20]);
			String  Login= login.getAttribute("value");
			Assert.assertEquals( Login,data[20]);
			System.out.println("given loginid:: "+ Login);

			WebElement pu_code =driver.findElement(By.xpath("//input[@formcontrolname='pu_code']"));
			pu_code.sendKeys(data[21]);
			String  Pu_code= pu_code.getAttribute("value");
			Assert.assertEquals(Pu_code,data[21]);
			System.out.println("given pucode:: "+Pu_code);

			WebElement pu_name =driver.findElement(By.xpath("//input[@formcontrolname='pu_name']"));
			pu_name.sendKeys(data[22]);
			String  Pu_name= pu_name.getAttribute("value");
			Assert.assertEquals(Pu_name,data[22]);
			System.out.println("given puname:: "+ Pu_name);

			WebElement usercreation = driver.findElement(By.xpath("(//div[@ng-reflect-ng-switch='true']/following-sibling::div)[2]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", usercreation);

			WebElement addclick=driver.findElement(By.xpath("//span[text()='Surface']"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();",addclick);
			
			WebElement elem = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-dialog-modal/mat-dialog-actions/button[2]"));
			JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor2.executeScript("arguments[0].click();", elem);
		
			Alert alert = driver.switchTo().alert();
			System.out.println("requirements are not filled properly:::"+alert.getText());
			}
			catch(Exception e) {
			
			File userScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


			FileHandler.copy(userScreenShot, new File("./snaps/negesa.png"));
			
			try {
				test.log(Status.FAIL, "Failed Shipment:: ",MediaEntityBuilder.createScreenCaptureFromPath("./snaps/user.png").build());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			}
	}
	}