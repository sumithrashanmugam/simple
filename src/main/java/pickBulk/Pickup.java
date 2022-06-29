package pickBulk;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Pickup extends BulkUserBasePage{
	public void BulkUser() {
	WebElement user=driver.findElement(By.xpath("//span[text()='Users']"));
	user.click();
	 
	//WebElement bulkele = driver.findElement(By.xpath("//button[@data-backdrop='static']//span[1]"));
	//JavascriptExecutor bulkexe = (JavascriptExecutor)driver;
	//bulkexe.executeScript("arguments[0].click();", bulkele); 
	
	//WebElement upload=driver.findElement(By.cssSelector("input#file"));
   // upload.sendKeys("E:\\Simple\\test-data\\pickup_template.csv");
    
     
    //driver.findElement(By.xpath("//button[@type='submit']")).click();
	
    //WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Upload']"));
   //  JavascriptExecutor executor = (JavascriptExecutor)driver;
   // executor.executeScript("arguments[0].click();", element);
	 
   // WebElement element1=driver.findElement(By.xpath("//mat-icon[text()='edit']"));
   // element1.click();



	//	WebElement List1= driver.findElement(By.xpath("//mat-icon[text()='edit'][1]"));
	//List1.click();
	//List<WebElement> List11 = new ArrayList<WebElement>();
	
	//WebDriverWait wait = new WebDriverWait(driver, 20);
   // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='mat-select-3']/div[1]/div[2]/div[1]")));
	//WebElement ele1= driver.findElement(By.xpath("//mat-option[@ng-reflect-value='100']//span[1]"));
	//JavascriptExecutor exec1 = (JavascriptExecutor)driver;
	//exec1.executeScript("arguments[0].click();", ele1);
	 

	
	
	// all webelement
	List<String> Lbl = new ArrayList<String>();
	WebElement allwebelements=driver.findElement(By.xpath("//mat-icon[text()='edit']"));
    allwebelements.click();
	////span[text()='Cancel']System.out.println(st);
    String s=allwebelements.getText();

	for (int i = 0; i<s.length(); i++) {
	System.out.println(s);
	  WebElement validate_fname=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
	     String f_name=validate_fname.getAttribute("value");
	
	   System.out.println("created firstname::"+f_name);
		
		WebElement validate_lname=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
		String l_name1=validate_lname.getAttribute("value");
		System.out.println("created lastname::"+l_name1);
		
		WebElement validate_email=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
		String email_id=validate_email.getAttribute("value");
		
		System.out.println("email.id is validated::"+email_id);
		
		WebElement validate_contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
		String Contact_no=validate_contact.getAttribute("value");
		System.out.println("number is validated::"+Contact_no);
		
		Lbl.add(f_name);
		System.out.println(f_name);
		Lbl.add(l_name1);
		Lbl.add(email_id);
		Lbl.add(Contact_no);
		System.out.println("my datalist is::: "+Lbl);
		int s1=Lbl.size();
		System.out.println("size---"+s1);
	    
 	WebElement ele1= driver.findElement(By.xpath("//span[text()='Cancel']"));
	JavascriptExecutor exec1 = (JavascriptExecutor)driver;
	exec1.executeScript("arguments[0].click();", ele1);
	//driver.findElement(By.xpath("//span[text()='Cancel']")).click();
	
	}
//for element .click
	
    
 
	}
    
    
	
	/*for (Iterator<String> i = List1.iterator(); i.hasNext();) {
	    String item = i.next();
	    System.out.println(item);
	  
	}
	
     
     /*   
        //for(int i = 0; i<a; i++){
        
        //System.out.println(a.get(i).getText());
        	//System.out.println(a);
         WebElement validate_fname=driver.findElement(By.xpath("//input[@formcontrolname='first_name']"));
     	     String f_name=validate_fname.getAttribute("value");
     	
     	   System.out.println("created firstname::"+f_name);
     		
     		WebElement validate_lname=driver.findElement(By.xpath("//input[@formcontrolname='last_name']"));
     		String l_name1=validate_lname.getAttribute("value");
     		System.out.println("created lastname::"+l_name1);
     		
     		WebElement validate_email=driver.findElement(By.xpath("//input[@formcontrolname='email_id']"));
     		String email_id=validate_email.getAttribute("value");
     		
     		System.out.println("email.id is validated::"+email_id);
     		
     		WebElement validate_contact=driver.findElement(By.xpath("//input[@formcontrolname='contact_number']"));
     		String Contact_no=validate_contact.getAttribute("value");
     		System.out.println("number is validated::"+Contact_no);
     		
     		lbl.add(f_name);
     		System.out.println(f_name);
     		lbl.add(l_name1);
     		lbl.add(email_id);
     		lbl.add(Contact_no);
     		System.out.println("my datalist is::: "+lbl);
    		int s=lbl.size();
    		System.out.println("size---"+s);*/
    	    
        	
        
  
		

	//driver.navigate().refresh();
}

