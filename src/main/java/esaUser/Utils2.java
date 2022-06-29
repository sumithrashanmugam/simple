package esaUser;

import org.testng.annotations.DataProvider;

public class Utils2 {
//multiples value in same testcase
@DataProvider(name="EsaUser")
public String[][] EsaUser(){	
String[][] exceldata=Data2.ExcelData();
return exceldata;
}
}