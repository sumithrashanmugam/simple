package subAdminEsa;

import org.testng.annotations.DataProvider;



public class SubUtils {
	@DataProvider(name = "SudAdminData")
	public String[][] getdata() throws Exception{
		
		String[][] exceldata1=SubData.read1();
		return exceldata1;
	}
}
