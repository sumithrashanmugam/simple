package subAdminEsa;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;

public class SubData {
	@BeforeMethod
    public static  String[][] read1(){
		String fileLocation = "E:\\Simple\\test-data\\subadmin.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet= wbook.getSheetAt(0);
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
		try {
			wbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	
	public static ArrayList<String> valid () throws Exception{
		
		String fileLocation = "E:\\Simple\\test-data\\subadmin.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("No.of Rows without header: "+lastRowNum);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows including header: "+physicalNumberOfRows);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No.of columns: "+lastCellNum);
		ArrayList<String> list1= new ArrayList<String>();
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow valueRow = sheet.getRow(i);
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum; j++) {
				XSSFCell cell = headerRow.getCell(j);
				XSSFCell cell1 = valueRow.getCell(j);
				String FirstRow = cell.getStringCellValue();
				DataFormatter formatter = new DataFormatter();
       		    String secondRow = formatter.formatCellValue(cell1);
		
       		 if(!FirstRow.equalsIgnoreCase("url") && !FirstRow.equalsIgnoreCase("email") && !FirstRow.equalsIgnoreCase("password") &&!FirstRow.equalsIgnoreCase("lastname")&&!FirstRow.equalsIgnoreCase("pass"))
       			list1.add(secondRow.toUpperCase());
            	
            
		}
		System.out.println(list1);
	}
	try {
		wbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list1;
}

	}

