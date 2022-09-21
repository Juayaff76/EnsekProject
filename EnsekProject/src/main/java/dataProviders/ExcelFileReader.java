package dataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import managers.FileReaderManager;



public class ExcelFileReader {
	
	public static File file;
	
	public ExcelFileReader()
	{
		 file=new File(FileReaderManager.getInstance().getConfigReader().getExcelFile());
	}
	
	public static void ReadExcelData() throws IOException
	{
	
	
	FileInputStream fi=new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet sh=wb.getSheet("Sheet1");
	
	int nor=sh.getLastRowNum();
	System.out.println("Number of rows -->"+nor);
	Row row1 = sh.getRow(nor);
	int  noc = row1.getLastCellNum();
	System.out.println("Number of columns -->" +noc);
	System.out.println("");
			
	for(int i=1; i<nor; i++)  //if  i<nor it will executed all the test case (number of rows) 
		{	
		
		}
	}
}


