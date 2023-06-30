package com.test.newjob;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\TARUN\\OneDrive\\Documents\\Test.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int sheets = workBook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workBook.getSheetName(i).equalsIgnoreCase("Records")) {

				XSSFSheet sheet = workBook.getSheetAt(i);

				Iterator<Row> row = sheet.iterator();// sheet is a collection of rows

				Row firstRow = row.next();

				Iterator<Cell> cell = firstRow.cellIterator();// row is collection of cells
				int coloumn = 0;
				int k = 0;
				while (cell.hasNext()) {

					Cell value = cell.next();

					if (value.getStringCellValue().equalsIgnoreCase("Salary")) {
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);
				
				while (row.hasNext()) {
					
					Cell Values=row.next().getCell(coloumn);
					
					System.out.println(Values.getNumericCellValue());
				}
						
			}

		}

	}

}
