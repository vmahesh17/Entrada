package Entrada.MobileApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;


import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import android.inputmethodservice.Keyboard.Row;

public class Utils {
	
	public static String testDataFile = getDataFromTestConfig("Test Data Path");

	public static String getDataFromTestData(String autoTestCaseNameVal, String label) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(testDataFile);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");
			int rowNum = ws.getLastRowNum() + 1;

			Iterator rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}
			for (int index = 0; index < rowNum; index++) {

				XSSFRow row = ws.getRow(index);
				XSSFCell cell = row.getCell(0);
				String cellVal = cellToString(cell);
				// System.out.println(cellVal);
				if (cellVal.equals(autoTestCaseNameVal)) {
					// System.out.println("Entered"+cellVal+"Row Index:"+index);
					for (int cellIndex = 1; cellIndex < numberOfCells; cellIndex++) {
						XSSFCell findLable = row.getCell(cellIndex);
						String labelString = cellToString(findLable);
						if (labelString.equals(label)) {
							// System.out.println("Cell Index: "+cellIndex);
							XSSFRow nextRow = ws.getRow(index + 1);
							XSSFCell adjacentRowCell = nextRow.getCell(cellIndex);
							String adjacentRowCellVal = cellToString(adjacentRowCell);
							// System.out.println("Cell Val:
							// "+adjacentRowCellVal);
							requiredCellVal = adjacentRowCellVal;
							break;
						}
					}

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requiredCellVal.trim();
	}

	public static String getDataFromTestConfig(String component) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/TestConfiguration.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

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

	@Test
	public static String multipleDataExecution(String Path, int ColumnNum, int RowNum) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

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
					if ((cellIndex == ColumnNum) && (index == RowNum)) {
						XSSFCell adjacentCell = row.getCell(cellIndex);
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

	public static int getNoOfRows(String Path) {
		int rowNum = 0;
		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			/*
			 * if (rowIterator.hasNext()) { Row headerRow = (Row)
			 * rowIterator.next(); //get the number of cells in the header row
			 * numberOfCells = headerRow.getLastCellNum(); } for (int index = 0;
			 * index < rowNum; index++) { XSSFRow row = ws.getRow(index);
			 * for(int cellIndex=0; cellIndex<numberOfCells; cellIndex++) {
			 * XSSFCell cell = row.getCell(cellIndex);
			 * 
			 * XSSFCell adjacentCell = row.getCell(cellIndex); String
			 * adjacentCellVal = cellToString(adjacentCell); requiredCellVal =
			 * adjacentCellVal;
			 * System.out.println(requiredCellVal+"requiredCellVal");
			 * 
			 * }
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowNum;
	}

	public static void writeDataintoExcel(String productName, String startTime, String endTime, String duration)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Performance Testing");
		
		// create column names for an excel sheet
		String[] headers = new String[] { "Product Name", "Start Time", "End Time", "Duration" };
		Row r = sheet.createRow(0);
		for (int rn = 0; rn < headers.length; rn++) {
			r.createCell(rn).setCellValue(headers[rn]);
		}

		Object[] productData = { productName, startTime, endTime, duration };
		int rowCount = sheet.getLastRowNum();
		Row row = sheet.createRow(++rowCount);
		int columnCount=0;
		Cell cell = row.createCell(columnCount);
		for(int count=0;count<productData.length;count++)
		{
			cell = row.createCell(count);
			if (productData[count] instanceof String) {
				cell.setCellValue((String) productData[count]);
			} else if (productData[count] instanceof Long) {
				cell.setCellValue((Long) productData[count]);
			}
		}
		
		/*int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("u24398789234"+rowCount);
		//for (int rn = 0; rn < bookData.length; rn++) {
			Row row = sheet.createRow(rowCount);
			int columnCount = 0;
			for (int cl = 0; cl < productData.length; cl++) {
				Cell cell = row.createCell(cl);
				if (productData[cl] instanceof String) {
					cell.setCellValue((String) productData[cl]);
				} else if (productData[cl] instanceof Long) {
					cell.setCellValue((Long) productData[cl]);
				}
			}
		//}
*/
		try (FileOutputStream outputStream = new FileOutputStream(
				"C:\\Users\\Siva Paritala\\Desktop\\PerformanceTesting.xlsx")) {
			workbook.write(outputStream);
		}
	}
}
	
}
