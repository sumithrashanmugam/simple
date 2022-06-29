package pickBulk;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BulkUserBasePage {
	public ChromeDriver driver;
	  @BeforeMethod
	  public void beforeMethod() {
	  	WebDriverManager.chromedriver().setup();
	  	driver = new ChromeDriver();
	  	driver.get("http://d2ggk2m8z3e33q.cloudfront.net/auth/signin");
	  	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("newbdcred@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//div[contains(@class,'form-group text-left')]/following-sibling::button[1]")).click();
	  }
}
