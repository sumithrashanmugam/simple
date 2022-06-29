package pickBulkCustomer;
import org.openqa.selenium.By;import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
@Test
public class BulkCustomer extends BulkCustomerBasepage{
	public void Customer() {
		WebElement customer=driver.findElement(By.xpath("//span[text()='Customers']"));
		customer.click();
        
	    WebElement Bulk=driver.findElement(By.xpath("//span[normalize-space()='Bulk Upload Customer']"));
	    Bulk.click();
	    
	    WebElement click=driver.findElement(By.id("file"));
	    click.sendKeys("E:\\Simple\\test-data\\bulk.csv");
	    WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		driver.navigate().refresh();
		
		
		
		
		
		
		
}
}
