package cashCustomer;

import org.testng.annotations.DataProvider;

import pickupCustomer.Data1;

public class DAtaUtils {
	@DataProvider(name = "CashCustomer")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=DataCash.ReadEXL();
		return exceldata1;
	}
}

