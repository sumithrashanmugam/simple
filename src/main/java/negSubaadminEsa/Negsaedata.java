package negSubaadminEsa;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;

public class Negsaedata {
	@BeforeMethod
    public static  String[][] Nedsae(){
		String fileLocation = "E:\\Simple\\test-data\\subadmin.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet= wbook.getSheetAt(1);
		int lastRowNum=sheet.getLastRowNum();
		System.out.println("Inculsive of Header"+ lastRowNum);
		int physicalNumberOfRows=sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows:"+physicalNumberOfRows);
		
		short lastCellNum=sheet.getRow(0).getLastCellNum();
		System.out.println("no of cels:"+lastCellNum);
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
		return data;
	
}
}