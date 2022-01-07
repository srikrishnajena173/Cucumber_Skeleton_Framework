package baseComponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class BaseClass {
	public WebDriver driver;
	public ArrayList<String> ar;

	public ArrayList<String> readXLSXFile(String fileName, String sheetName) {
		ar = new ArrayList<String>();
		InputStream XlsxFileToRead = null;
		XSSFWorkbook workbook = null;
		try {
			XlsxFileToRead = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(XlsxFileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row;
		XSSFCell cell;
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					ar.add(cell.getStringCellValue());
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					ar.add(cell.getStringCellValue());
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					ar.add(cell.getStringCellValue());
				}
			}
			System.out.println();
			try {
				XlsxFileToRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ar;
	}

	public void writeValue(String excelName, String sheetName, int rowValue, String valueToWrite) throws IOException {
		FileInputStream fis = new FileInputStream(excelName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.createRow(rowValue);
		Cell cell = row.createCell(rowValue);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(valueToWrite);
		FileOutputStream fos = new FileOutputStream(excelName);
		workbook.write(fos);
		fos.close();
		System.out.println(valueToWrite);
		System.out.println("END OF WRITING DATA IN EXCEL");
	}

	public void lunchChromeBrowser(String url) {
		String Chromepath = ClassLoader.getSystemResource("chromedriver.exe").getFile();
		System.setProperty("webdriver.chrome.driver", Chromepath);
		driver = new ChromeDriver();
		driver.get(url);
	}

	public void waitForAnElement(WebElement element, long t) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, t);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException te) {
			System.out.println(te.getMessage());
		} catch (WebDriverException we) {
			System.out.println(we.getMessage());
		}
	}

	public void click(WebElement element) {
		try {
			waitForAnElement(element, 20);
			element.click();
		} catch (ElementNotFoundException el) {
			System.out.println(el.getMessage());
		} catch (WebDriverException we) {
			System.out.println(we.getMessage());
		}
	}

	public void setText(WebElement element, String userNameValue) {
		try {
			waitForAnElement(element, 20);
			element.sendKeys(userNameValue);
		} catch (ElementNotFoundException el) {
			System.out.println(el.getMessage());
		} catch (WebDriverException we) {
			System.out.println(we.getMessage());
		}
	}

	public void closeBrowser() {
		try {
			driver.quit();
		} catch (WebDriverException we) {
			System.out.println(we.getMessage());
		}
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public String getText(WebElement ele) {
		waitForAnElement(ele, 20);
		return ele.getText();
	}
}
