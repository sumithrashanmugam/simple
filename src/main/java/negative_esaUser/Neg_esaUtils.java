package negative_esaUser;

import org.testng.annotations.DataProvider;

public class Neg_esaUtils {
	@DataProvider(name="NegEsa")
	public String[][] NegEsaUser(){	
	String[][] excel=Negative_esaData.readNeg();
	return excel;
	}
}

