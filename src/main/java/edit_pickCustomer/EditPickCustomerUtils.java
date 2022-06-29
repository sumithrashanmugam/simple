package edit_pickCustomer;

import org.testng.annotations.DataProvider;

import pickupCustomer.Data1;

public class EditPickCustomerUtils {
	@DataProvider(name = "CustomerEdit")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=EditPickCustomerData.Readdt();
		return exceldata1;
	}
}
