package Entrada.MobileApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static String getData(String component) {
		String requiredCellVal = "";
		
		String excellsheet ="Data1";
		try {
			
			
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/Data/AppData.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(excellsheet);

			int rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}

			for (int index = 0; index < rowNum; index++) {
				XSSFRow row = ws.getRow(index);

				for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);
					String cellVal = cellToString(cell);
					if (cellVal.equals(component)) {
						XSSFCell adjacentCell = row.getCell(cellIndex + 1);
						String adjacentCellVal = cellToString(adjacentCell);
						requiredCellVal = adjacentCellVal;
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requiredCellVal;
	}

	public static String cellToString(XSSFCell cell) {
		int type;
		String result;
		type = cell.getCellType();

		switch (type) {

		case Cell.CELL_TYPE_NUMERIC: // numeric value in Excel
			result = "" + cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA: // precomputed value based on formula
			result = "" + cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_STRING: // String Value in Excel
			result = "" + cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			result = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN: // boolean value
			result = "" + cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
			result = "Error";
		default:
			throw new RuntimeException("There is no support for this type of cell");
		}

		return result.toString();
	}

}
	


