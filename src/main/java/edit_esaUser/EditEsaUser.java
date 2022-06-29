package edit_esaUser;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import esaUser.Data2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditEsaUser extends EditEsaUtils {
	public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void setup() {
		reporter = new ExtentHtmlReporter("E:\\Simple\\reports.html");
		extent = new ExtentReports();
		reporter.setAppendExisting(true);
		extent.attachReporter(reporter);;
	}
	@Test(dataProvider = "EditEsaUser")	
	public void  createEsaUser(String data[]) throws Exception {
		try {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		test = extent.createTest("EsaUserLogin","Login with positive credentials");
		driver.get(data[0]);
		test.pass("navigate to chromedriver");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data[1]);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(data[2]);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/users']")));
		WebElement user=driver.findElement(By.xpath("//a[@href='/users']"));
		user.click();
		
	    WebElement ele = driver.findElement(By.xpath("//mat-icon[text()='edit']"));
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();", ele); 
		
	    WebElement Esa_id=driver.findElement(By.xpath("//input[@ng-reflect-name='esa_id']"));
	    Esa_id.clear();
	    Esa_id.sendKeys(data[3]);
	    String esaid=Esa_id.getAttribute("value");
	    Assert.assertEquals(esaid, data[3]);
	    System.out.println("given esaid:: "+esaid);
	
	    
	    WebElement first_name=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
	    first_name.clear();
	    first_name.sendKeys(data[4]);
	    String First_name= first_name.getAttribute("value");
	    Assert.assertEquals(First_name, data[4]);
	    System.out.println("given firstname:: "+First_name);
	    
	    
	    WebElement last_name=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
	    last_name.clear();
	    last_name.sendKeys(data[5]);
	    String  Last_name= last_name.getAttribute("value");
	    Assert.assertEquals( Last_name, data[5]);
	    System.out.println("given lastname:: "+Last_name);
	    
	    WebElement contact_number=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
	    contact_number.clear();
	    contact_number.sendKeys(data[6]);
	    String Contact_number=contact_number.getAttribute("value");
	    Assert.assertEquals(Contact_number, data[6]);
	    System.out.println("given contact:: "+Contact_number);
	    
	    WebElement email_id=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
	    email_id.clear();
	    email_id.sendKeys(data[7]);
	    String  Email_id= email_id.getAttribute("value");
	    Assert.assertEquals( Email_id, data[7]);
	    System.out.println("given emailid:: "+ Email_id);
	    
	    WebElement add1 =driver.findElement(By.xpath("//input[@formcontrolname='address_1']"));
	    add1.clear();
	    add1.sendKeys(data[8]);
	    String Add1=add1.getAttribute("value");
	    Assert.assertEquals(Add1, data[8]);
	    System.out.println("given Address1:: "+Add1);
	    
	    WebElement add2 =driver.findElement(By.xpath("//input[@formcontrolname='address_2']"));
	    add2.clear();
	    add2.sendKeys(data[9]);
	    String Add2=add2.getAttribute("value");
	    Assert.assertEquals(Add2,data[9]);
	    System.out.println("given Address2:: "+Add2);
	    
	    
	    WebElement add3 =driver.findElement(By.xpath("//input[@formcontrolname='address_3']"));
	    add3.clear();
	    add3.sendKeys(data[10]);
	    String Add3=add3.getAttribute("value");
	    Assert.assertEquals(Add3, data[10]);
	    System.out.println("given Address3:: "+Add3);
	    
	    WebElement city=driver.findElement(By.xpath("//input[@formcontrolname='city']"));
	    city.clear();
	    city.sendKeys(data[11]);
	    String City=city.getAttribute("value");
	    Assert.assertEquals(City, data[11]);
	    System.out.println("given city:: "+City);
	    
	    WebElement state=driver.findElement(By.xpath("//input[@formcontrolname='state']"));
	    state.clear();
	    state.sendKeys(data[12]);
	    String State=state.getAttribute("value");
	    Assert.assertEquals(State, data[12]);
	    System.out.println("given state:: "+State);
	    
	    WebElement country=driver.findElement(By.xpath("//input[@formcontrolname='country']"));
	    country.clear();
	    country.sendKeys(data[13]);
	    String Country=country.getAttribute("value");
	    Assert.assertEquals(Country,data[13]);
	    System.out.println("given country:: "+Country);
	    
	    WebElement countrycode=driver.findElement(By.xpath("//input[@formcontrolname='country_code']"));
	    countrycode.clear();
	    countrycode.sendKeys(data[14]);
	    String Countrycode=countrycode.getAttribute("value");
	    Assert.assertEquals(Countrycode,data[14]);
	    System.out.println("given countrycode:: "+Countrycode);
	    
	    WebElement postalcode=driver.findElement(By.xpath("//input[@formcontrolname='postal_code']"));
	    postalcode.clear();
	    postalcode.sendKeys(data[15]);
	    String Postalcode=postalcode.getAttribute("value");
	    Assert.assertEquals(Postalcode, data[15]);
	    System.out.println("given Postalcode:: "+Postalcode);
	    
	    WebElement aadhaar=driver.findElement(By.xpath("//input[@formcontrolname='aadhaar_number']"));
	    aadhaar.clear();
	    aadhaar.sendKeys(data[16]);
	    String Aadhaar=aadhaar.getAttribute("value");
	    Assert.assertEquals(Aadhaar, data[16]);
	    System.out.println("given aadhaar:: "+Aadhaar);
	    
	    WebElement license=driver.findElement(By.xpath("//input[@formcontrolname='license_key']"));
	    license.clear();
	    license.sendKeys(data[17]);
	    String License=license.getAttribute("value");
	    Assert.assertEquals(License,data[17]);
	    System.out.println("given license:: "+License);
	    
	    WebElement area_code =driver.findElement(By.xpath("//input[@formcontrolname='area_code']"));
	    area_code.clear();
	    area_code.sendKeys(data[18]);
	    String  Area_code= area_code.getAttribute("value");
	    Assert.assertEquals( Area_code,data[18]);
	    System.out.println("given areacode:: "+ Area_code);
	    
	    WebElement login =driver.findElement(By.xpath("//input[@formcontrolname='login_id']"));
	    login.clear();
	    login.sendKeys(data[19]);
	    String  Login= login.getAttribute("value");
	    Assert.assertEquals( Login,data[19]);
	    System.out.println("given loginid:: "+ Login);
	    
	    WebElement pu_code =driver.findElement(By.xpath("//input[@formcontrolname='pu_code']"));
	    pu_code.clear();
	    pu_code.sendKeys(data[20]);
	    String  Pu_code= pu_code.getAttribute("value");
	    Assert.assertEquals(Pu_code,data[20]);
	    System.out.println("given pucode:: "+Pu_code);
	    
	    WebElement pu_name =driver.findElement(By.xpath("//input[@formcontrolname='pu_name']"));
	    pu_name.clear();
	    pu_name.sendKeys(data[21]);
	    String  Pu_name= pu_name.getAttribute("value");
	    Assert.assertEquals(Pu_name,data[21]);
	    System.out.println("given puname:: "+ Pu_name);
	    
	    WebElement usercreation = driver.findElement(By.xpath("//*[@id=\"mat-select-2\"]/div/div[2]/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", usercreation);
		
		WebElement addclick=driver.findElement(By.xpath("//span[text()='Surface']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();",addclick);
		
		WebElement elem = driver.findElement(By.xpath("//span[text()='Update']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", elem);
		
	    driver.navigate().refresh();
		
	    
		
		WebElement edit = driver.findElement(By.xpath("//mat-icon[@mattooltip='Edit User']"));
		edit.click();
		System.out.println(edit);
		
		ArrayList<String> exlDt = EditEsaData.ArrayList();
		System.out.println("my excel data---"+exlDt);
		ArrayList<String> dttd= new ArrayList<String>();
		
		WebElement Esa_id1=driver.findElement(By.xpath("//input[@formcontrolname='esa_id']"));
	    String esaid1=Esa_id1.getAttribute("value");
	    System.out.println("given esaid:: "+esaid1);
	    
	    WebElement first_name1=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
	    String First_name1= first_name1.getAttribute("value");
	    System.out.println("given firstname:: "+First_name1);
	    
	    
	    WebElement last_name1=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
	    String  Last_name1= last_name1.getAttribute("value");
	    System.out.println("given lastname:: "+Last_name1);
	    
	    WebElement contact_number1=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
	    String Contact_number1=contact_number1.getAttribute("value");
	    System.out.println("given contact:: "+Contact_number1);
	    
	    WebElement email_id1=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
	    String  Email_id1= email_id1.getAttribute("value");
	    System.out.println("given emailid:: "+ Email_id1);
	    
	    WebElement add_1 =driver.findElement(By.xpath("//input[@formcontrolname='address_1']"));
	    String Add_1=add_1.getAttribute("value");
	    System.out.println("given Address1:: "+Add_1);
	    
	    WebElement add_2 =driver.findElement(By.xpath("//input[@formcontrolname='address_2']"));
	    String Add_2=add_2.getAttribute("value");
	    System.out.println("given Address2:: "+Add_2);
	    
	    
	    WebElement add_3 =driver.findElement(By.xpath("//input[@formcontrolname='address_3']"));
	    String Add_3=add_3.getAttribute("value");
	    System.out.println("given Address3:: "+Add_3);
	    
	    WebElement city1=driver.findElement(By.xpath("//input[@formcontrolname='city']"));
	    String City1=city1.getAttribute("value");
	    System.out.println("given city:: "+City1);
	    
	    WebElement state1=driver.findElement(By.xpath("//input[@formcontrolname='state']"));
	    String State1=state1.getAttribute("value");
	    System.out.println("given state:: "+State1);
	    
	    WebElement country1=driver.findElement(By.xpath("//input[@formcontrolname='country']"));
	    String Country1=country1.getAttribute("value");
	    System.out.println("given country:: "+Country1);
	    
	    WebElement countrycode1=driver.findElement(By.xpath("//input[@formcontrolname='country_code']"));
	    String Countrycode1=countrycode1.getAttribute("value");
	    System.out.println("given countrycode:: "+Countrycode1);
	    
	    WebElement postalcode1=driver.findElement(By.xpath("//input[@formcontrolname='postal_code']"));
	    String Postalcode1=postalcode1.getAttribute("value");
	    System.out.println("given Postalcode:: "+Postalcode1);
	    
	   
	    
	    WebElement license1=driver.findElement(By.xpath("//input[@formcontrolname='license_key']"));
	    String License1=license1.getAttribute("value");
	    System.out.println("given license:: "+License1);
	    
	    WebElement area_code1 =driver.findElement(By.xpath("//input[@formcontrolname='area_code']"));
	    String  Area_code1= area_code1.getAttribute("value");
	    System.out.println("given areacode:: "+ Area_code1);
	    
	    WebElement login1 =driver.findElement(By.xpath("//input[@formcontrolname='login_id']"));
	    String  Login1= login1.getAttribute("value");
	    System.out.println("given loginid:: "+ Login1);
	    
	    WebElement pu_code1 =driver.findElement(By.xpath("//input[@formcontrolname='pu_code']"));
	    String  Pu_code1= pu_code1.getAttribute("value");
	    System.out.println("given pucode:: "+Pu_code1);
	    
	    WebElement pu_name1 =driver.findElement(By.xpath("//input[@formcontrolname='pu_name']"));
	    String  Pu_name1= pu_name1.getAttribute("value");
	    System.out.println("given puname:: "+ Pu_name1);
	    
	    dttd.add(esaid1);
	    dttd.add(First_name1);
	    dttd.add(Last_name1);
	    dttd.add(Contact_number1);
	    dttd.add(Email_id1);
	    dttd.add(Add_1);
	    dttd.add(Add_2);
	    dttd.add(Add_3);
	    dttd.add(City1);
	    dttd.add(State1.toUpperCase());
	    dttd.add(Country1);
	    dttd.add(Countrycode1.toUpperCase());
	    dttd.add(Postalcode1);
	 
	    dttd.add(License1);
	    dttd.add(Area_code1);
	    dttd.add(Login1);
	    dttd.add(Pu_code1);
	    dttd.add(Pu_name1);
	 
	    System.out.println("my datalist is::: "+dttd);
		int s=dttd.size();
		System.out.println("size---"+s);
	    
		 
		Assert.assertEquals(dttd, exlDt);
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
	    
				
		
