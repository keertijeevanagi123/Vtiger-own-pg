package vtiger.GenericUtilities;

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

/**
 * This class consists of generic methods related to Excel file
 * @author ADMIN
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from Excel sheet
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws IOException 
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException  {
		// TODO Auto-generated method stub
	FileInputStream fis = new FileInputStream(IContantsUtility.excelFilePath);
	Workbook wb= WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	wb.close();
	return value;
	
	}
	/**
	 * this method will write data into excel
	 * @param sheetName
	 * @param rowNo
	 * @param cellNO
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public void writeIntoExcel(String sheetName, int rowNo, int celNo,String value) throws EncryptedDocumentException, IOException  {
	FileInputStream fis = new FileInputStream(IContantsUtility.excelFilePath);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row rw = sh.createRow(rowNo);
	Cell cel = rw.createCell(celNo);
	cel.setCellValue(value);
	
	FileOutputStream fos = new FileOutputStream(IContantsUtility.excelFilePath);
	wb.write(fos);
	wb.close();
	}
/**
 * this method will read data into excel sheet n return it to data provider
 * @param sheetName
 * @param rowNo
 * @param cellNO
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */

            public Object[][] readDatafromExcelToDataProvider(String sheetName)  throws EncryptedDocumentException, IOException  {
            FileInputStream fis = new FileInputStream(IContantsUtility.excelFilePath);
            Workbook wb= WorkbookFactory.create(fis);
                Sheet sh = wb.getSheet(sheetName);
                int lastRow = sh.getLastRowNum();
                int lastCell = sh.getRow(0).getLastCellNum();
                Object[][] data = new Object[lastRow][lastCell];
                for(int i=0;i<lastRow;i++)//row
                {
                	for(int j=0;j<lastCell;j++)//cell
                	{
                		data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
                	}
                }

            return data;
            }
            
}
	


