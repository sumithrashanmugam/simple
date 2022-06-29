package edit_esaUser;

import org.testng.annotations.DataProvider;

import esaUser.Data2;

public class EditEsaUtils {
	@DataProvider(name="EditEsaUser")
	public String[][] EsaUser(){	
	String[][] exceldata=EditEsaData.Read();
	return exceldata;
	}
}
