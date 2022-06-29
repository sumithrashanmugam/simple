package pickUpUser;

import org.testng.annotations.DataProvider;
public class Utils {
	@DataProvider(name = "Data")
	public String[][] getdata() {
		
		String[][] exceldata=Data.readexcel();
		return exceldata;
		
	}

	
	}

