package negSubaadminEsa;

import org.testng.annotations.DataProvider;

import negSubaadminEsa.*;

public class Negsaeutils {
	@DataProvider(name = "NegSudAdminData")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=Negsaedata.Nedsae();
		return exceldata1;
	}
}


