package disenEsa;

import org.testng.annotations.DataProvider;

import esaUser.Data2;

public class Utilies {
	@DataProvider(name="EnableEsa")
	public String[][] EsaUtilies(){
		String[][] exceldata=BaseEsa.ExcelData();
		return exceldata;
		}
		}

