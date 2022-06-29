package negativePickup_customer;

import org.testng.annotations.DataProvider;



public class Neg_pickupUtils {
	@DataProvider(name = "NegCustomerData")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=Neg_customerData.Readcus();
		return exceldata1;
	}
}

