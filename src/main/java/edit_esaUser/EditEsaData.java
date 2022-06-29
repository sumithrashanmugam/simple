package edit_esaUser;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class EditEsaData {
	public static String[][] Read(){
		String fileLocation = "E:\\Simple\\test-data\\sub.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet= wbook.getSheetAt(1);
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
			
			e.printStackTrace();
		}
		return data;
}
public static ArrayList<String> ArrayList () throws Exception{
		
		String fileLocation = "E:\\Simple\\test-data\\sub.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(1);
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("No.of Rows without header: "+lastRowNum);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows including header: "+physicalNumberOfRows);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No.of columns: "+lastCellNum);
		ArrayList<String> list= new ArrayList<String>();
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
		   if(!FirstRow.equalsIgnoreCase("url") &&!FirstRow.equalsIgnoreCase("email") && !FirstRow.equalsIgnoreCase("pass")&& !FirstRow.equalsIgnoreCase("Aadharnumber") )
       			list.add(secondRow);
            	}
		   System.out.println(list);
	           }
	try {
		wbook.close();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	return list;
}
}

