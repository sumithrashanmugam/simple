package cashCustomer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataCashCustomer extends DAtaUtils {
	@Test(dataProvider = "CashCustomer")
	public void Login(String url,String email,String pass,String Aadhar) throws Exception {
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

	    WebElement clickCustomer=driver.findElement(By.xpath("(//mat-icon[text()='edit'])[3]"));
		clickCustomer.click();
		
		WebElement reffernce_id=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div/app-esa-customers/div[2]/div/app-card/div/div[2]/div/table/tbody/tr[4]/td[1]/a"));
		String text = reffernce_id.getText();
		System.out.println("previous refference id:::"+text);
		
		WebElement pan_card=driver.findElement(By.xpath("//input[@formcontrolname='pancard_number']"));
	    pan_card.clear();
	    
		WebElement Aadhaar_card=driver.findElement(By.xpath("//input[@formcontrolname='aadhaar_number']"));
		Aadhaar_card.sendKeys(Aadhar);
		String Aadhaar=Aadhaar_card.getAttribute("value");
		Assert.assertEquals(Aadhaar,Aadhar);
		System.out.println("Aadhaar is validated::  "+Aadhaar);
		
		WebElement update=driver.findElement(By.xpath("//span[text()='Update']"));
		update.click();
		
		
		
}
}
