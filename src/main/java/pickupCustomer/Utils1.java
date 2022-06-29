package pickupCustomer;

import org.testng.annotations.DataProvider;

public class Utils1 {
	@DataProvider(name = "CustomerData")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=Data1.Readdt();
		return exceldata1;
	}
}
