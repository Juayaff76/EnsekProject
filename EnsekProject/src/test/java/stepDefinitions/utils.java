package stepDefinitions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import managers.FileReaderManager;
import static io.restassured.RestAssured.given;

public class utils {
	public static String DateToUse(int add)
	{
		LocalDate currentDate = LocalDate.now();
		return currentDate.plusDays(add).toString();
	}

}
	

