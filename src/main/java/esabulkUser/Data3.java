package esabulkUser;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data3 {
	public static String[][] ReadData(){
		String fileLocation = "";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet= wbook.getSheetAt(0);
		int lastRowNum=sheet.getLastRowNum();
		int physicalNumberOfRows=sheet.getPhysicalNumberOfRows();
		System.out.println("Inculsive of Header"+ physicalNumberOfRows);
		//System.out.println("no of rows:"+Row);
		short lastCellNum=sheet.getRow(0).getLastCellNum();
		//System.out.println("no of cels:"+lastCellNum);
		String[][] data= new String[lastRowNum][lastCellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value=dft.formatCellValue(cell);
				//String value = cell.getStringCellValue();
				//System.out.println(value);
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
