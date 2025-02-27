package Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	String [] [] credentials = new String [100] [100];
	ArrayList<String> practice = new ArrayList<String>();
	int i = 0,j=0;

public String readExcelSheet(int rowvalue, int colvalue, String sheetname) throws IOException {
	
		String path = System.getProperty("user.dir")+"/src/test/resources/testdata/testdata.xlsx";
		File Excelfile = new File(path);
		
		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		Iterator<Row> row = sheet.rowIterator();
		
		while(row.hasNext()) {
			
			Row currRow = row.next();
			Iterator<Cell> cell = currRow.cellIterator();
			
			while(cell.hasNext()) {
				Cell currCell = cell.next();
				i=currCell.getRowIndex();
				j=currCell.getColumnIndex();				
				credentials[i][j] = currCell.getStringCellValue();
			}
		}
		workbook.close();
		String cellvalue = credentials[rowvalue][colvalue];
		return cellvalue;
	}

public String getusername(int rownumber) throws IOException {
	String username = null;	
	String sheetname = "Sheet1";
	username = readExcelSheet(rownumber, 0, sheetname);
	LoggerLoad.info("Username is:"+username);
	return username;	
}

public String getpassword(int rownumber) throws IOException {
	String password = null;	
	String sheetname = "Sheet1";
	password = readExcelSheet(rownumber, 1, sheetname);
	LoggerLoad.info("Password is:"+password);
	return password;	
}

public String gettryherecode(int rownumber) throws IOException {
	String tryherecode = null;	
	String sheetname = "tryeditor";
	tryherecode = readExcelSheet(rownumber, 0, sheetname);
	LoggerLoad.info("Try here code is:"+tryherecode);
	return tryherecode;
}

public String gettryheremessage(int rownumber) throws IOException {
	String tryherecodemessage = null;	
	String sheetname = "tryeditor";
	tryherecodemessage = readExcelSheet(rownumber, 1, sheetname);
	LoggerLoad.info("Expected output is:"+tryherecodemessage);
	return tryherecodemessage;
}
public ArrayList<String> getpracticeques(int rownumber) throws IOException {
	ArrayList<String> practiceques = new ArrayList<String>();
	String sheetname = "practiceq";
	practiceques = readpracticeques(rownumber, 0, sheetname);
	LoggerLoad.info("Practice Question:"+practiceques);
	return practiceques;
}
public String getPQoutput(int rownumber) throws IOException {
	String pqoutput = null;	
	String sheetname = "practiceq";
	pqoutput = readExcelSheet(rownumber, 1, sheetname);
	pqoutput=pqoutput.replace("Output", "");
	LoggerLoad.info("Expected output is:"+pqoutput);
	return pqoutput;
}
public ArrayList<String> readpracticeques(int rowvalue, int colvalue, String sheetname) throws IOException {
	
	String path = System.getProperty("user.dir")+"/src/test/resources/testdata/testdata.xlsx";
	File Excelfile = new File(path);
	
	FileInputStream Fis = new FileInputStream(Excelfile);
	XSSFWorkbook workbook = new XSSFWorkbook(Fis);
	XSSFSheet sheet = workbook.getSheet(sheetname);
	
	Iterator<Row> row = sheet.rowIterator();
	
	while(row.hasNext()) {
		
		Row currRow = row.next();
		Iterator<Cell> cell = currRow.cellIterator();
		
		while(cell.hasNext()) {
			Cell currCell = cell.next();
			i=currCell.getRowIndex();
			j=currCell.getColumnIndex();				
			credentials[i][j] = currCell.getStringCellValue();
		}
	}
	workbook.close();
	practice.add(credentials[rowvalue][colvalue]);
	System.out.println(practice);
	return practice;
}


}