package creditCustomer;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;

public class CreditCustData {
	@BeforeMethod(enabled = true)
	public static String[][] ReadEXL(){
		String fileLocation = "E:\\Simple\\test-data\\customer.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet= wbook.getSheetAt(4);
		int lastRowNum=sheet.getLastRowNum();
		int physicalNumberOfRows=sheet.getPhysicalNumberOfRows();
		System.out.println("Inculsive of Header"+ physicalNumberOfRows);
        short lastCellNum=sheet.getRow(0).getLastCellNum();
        String[][] data= new String[lastRowNum][lastCellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value=dft.formatCellValue(cell);
			    data[i-1][j]=value;
			} 
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
