package creditCustomer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreditCus extends CreditusUtils{
	@Test(dataProvider = "CreditCustomer")
	public void Login(String url,String email,String pass,String customerno ) throws Exception {
        //try {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//test = extent.createTest("customerLogin");
		driver.get(url);
		//test.pass("navigate to url");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		//test.pass("email is passed");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
       // test.pass("password is given");
		driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
		String title= driver.getTitle();
		System.out.println("title is"+title);


		WebElement clk=driver.findElement(By.xpath("//a[@href='/customersDetails']"));
		clk.click();

		WebElement edit1 = driver.findElement(By.xpath("//mat-icon[text()='edit']"));
	    edit1.click();
	   
	    WebElement reffernce_id=driver.findElement(By.xpath("//td[@role='gridcell']//a"));
		String text = reffernce_id.getText();
		System.out.println("previous refference id:::"+text);
		
		WebElement Customer_Code=driver.findElement(By.xpath("//input[@formcontrolname='customer_code']"));
		
	    Customer_Code.clear();
		Customer_Code.sendKeys(customerno);
		String Customer=Customer_Code.getAttribute("value");
		Assert.assertEquals(Customer, customerno);
		System.out.println("CustomerCode is validated::  "+Customer);
	    
	
		
		WebElement update=driver.findElement(By.xpath("//span[text()='Update']"));
		update.click();
		
		driver.navigate().refresh();
		 
		 WebElement reffernce_id1=driver.findElement(By.xpath("//td[@role='gridcell']//a"));
			String text1 = reffernce_id1.getText();
			System.out.println("previous refference id:::"+text1);
			
			Assert.assertNotEquals(reffernce_id, reffernce_id1);
			
}
}


