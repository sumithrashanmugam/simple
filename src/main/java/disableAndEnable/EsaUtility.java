package disableAndEnable;

import org.testng.annotations.DataProvider;



public class EsaUtility {

		@DataProvider(name = "EsaAdminData")
		public String[][] EsaAdmindata() {
			
			String[][] exceldata=BasepageFormEsa.readexcelEsa();
			return exceldata;
			
		}
}
		
		

