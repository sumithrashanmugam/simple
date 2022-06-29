package negativeEdit_pickupuser;

import org.testng.annotations.DataProvider;
public class Neg_editpickUtils {
@DataProvider(name = "NegData")
	public String[][] negdata() {
		String[][] exceldata=Neg_editpichupData.Negreadexcel();
		return exceldata;
		}
}

