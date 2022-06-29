package esabulkUser;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import esaUser.Data2;

public class User3 extends EsaBasepage{
@Test
public void BulkUser() {
	//driver.navigate().refresh();
	WebElement user=driver.findElement(By.xpath("//a[@ng-reflect-router-link='/users']"));
	user.click();
	 
	WebElement bulkele = driver.findElement(By.xpath("//span[text()[normalize-space()='Bulk Upload User']]"));
	JavascriptExecutor bulkexe = (JavascriptExecutor)driver;
	bulkexe.executeScript("arguments[0].click();", bulkele); 
	
	WebElement upload=driver.findElement(By.cssSelector("input#file"));
    upload.sendKeys("E:\\Simple\\test-data\\esa_template(1).csv");
   
	WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	 String text = element.getAttribute("value");
	 System.out.println(text);
	driver.navigate().refresh();
	
/*	WebElement edit = driver.findElement(By.xpath("//mat-icon[@mattooltip='Edit User'][1]"));
	edit.click();
	System.out.println(edit);
	
	//ArrayList<String> exlDt = Data2.ArrayList();
	//System.out.println("my excel data---"+exlDt);
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
    
    WebElement aadhaar1=driver.findElement(By.xpath("//input[@formcontrolname='aadhaar_number']"));
    String Aadhaar1=aadhaar1.getAttribute("value");
    System.out.println("given aadhaar:: "+Aadhaar1);
    
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
    dttd.add(Country1.toUpperCase());
    dttd.add(Countrycode1.toUpperCase());
    dttd.add(Postalcode1);
    dttd.add(Aadhaar1);
    dttd.add(License1);
    dttd.add(Area_code1);
    dttd.add(Login1);
    dttd.add(Pu_code1);
    dttd.add(Pu_name1);
 
    System.out.println("my datalist is::: "+dttd);
	int s=dttd.size();
	System.out.println("size---"+s);
    
	 
	//Assert.assertEquals(dttd, exlDt);*/
    
}
}
