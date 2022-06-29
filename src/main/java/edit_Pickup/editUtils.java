package edit_Pickup;

import org.testng.annotations.DataProvider;

import pickUpUser.Data;

public class editUtils {
	@DataProvider(name = "EditData")
	public String[][] getdata() {
		
		String[][] exceldata=editData.readexcel();
		return exceldata;
		
}
}
