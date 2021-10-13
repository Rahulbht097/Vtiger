package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
/*
 * author @ RAHUL BHAT
 */
/**
 * @param sheetName
 * @param rownum
 * @param cellnum
 * @return
 * @throws Throwable 
 * @throws EncryptedDocumentException 
 * @throws Throwable
 */
	public String getExcelData(String sheetName, int rownum, int cellnum ) throws EncryptedDocumentException, Throwable {
	FileInputStream file = new FileInputStream(IpathConstant.EXCELPATH);
	Workbook workbook= WorkbookFactory.create(file);
	Sheet sheet= workbook.getSheet(sheetName);
	Row row =sheet.getRow(rownum);
	Cell cell= row.getCell(cellnum);
	file.close();
	return cell.getStringCellValue();
	}

/**
 * This method will return all the data in the excel sheet
 * @param sheetName
 * @return
 * @throws Throwable
 */

public Object [][] getExcelData(String sheetName) throws Throwable{
	FileInputStream file = new FileInputStream(IpathConstant.EXCELPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet= workbook.getSheet(sheetName);
	int lastRow= sheet.getLastRowNum();
	int lastCell= sheet.getRow(0).getLastCellNum();
	Object [][] data= new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++) {
		for(int j=0;i<lastCell;j++) {
			data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}	
/**
 * This method is used to write data in the excel sheet
 * @param sheetName
 * @param rownum
 * @param cellnum
 * @param value
 * @throws Throwable
 */

public void writeExcelData(String sheetname, int rownum, int column, String value ) throws Throwable {
	FileInputStream file = new FileInputStream(IpathConstant.EXCELPATH);
	Workbook workbook = WorkbookFactory.create(file);
	workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
	FileOutputStream writeFile= new FileOutputStream(IpathConstant.EXCELPATH);
	workbook.write(writeFile);
	}
}





















