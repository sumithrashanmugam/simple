package creditCustomer;

import org.testng.annotations.DataProvider;

import cashCustomer.DataCash;

public class CreditusUtils {
	@DataProvider(name = "CreditCustomer")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=CreditCustData.ReadEXL();
		return exceldata1;
	}
}

