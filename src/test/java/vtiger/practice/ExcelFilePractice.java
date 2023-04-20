package vtiger.practice;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args, int getRow, int getCell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		

		/*Sheet sheet = wb.getSheet("organization");
		Row rw = sheet.getRow(1);
		//Cell ce = rw.getCell(2);
		Cell be = rw.createCell(7);
		be.setCellValue("keerti");*/
		
		Sheet sheet = wb.getSheet("contacts");
		Row rw = sheet.getRow(1);
		Cell ce = rw.getCell(2);
		//Cell be = rw.createCell(7);
		//be.setCellValue("keerti");*/
		
		/*FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		wb.write(fos);
		String value = ce.getStringCellValue();
		System.out.println("data added");*/
		wb.close();
		
	}

}
