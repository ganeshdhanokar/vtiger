package com.vtiger.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vtiger.qa.base.TestBase;




public class ReadExcel extends TestBase{
	static Workbook workbook;

	public static Object[][] getData(String sheetName) throws IOException {
		String path = property.getProperty("testDataPath");
		FileInputStream fs = new FileInputStream(path);
		workbook = new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()-1][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum()-1; i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
		}
		return data;
	}
}
