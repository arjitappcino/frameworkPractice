import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class dataFetch {

	FileInputStream fileInputStream = new FileInputStream("D:\\GIT Automation Practice\\frameworkPractice\\Scratch\\AutomationProject\\UserData.xlsx"); // Excel sheet file location get mentioned
															// here
	workbook=new HSSFWorkbook(fileInputStream); // get my workbook
	worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
	HSSFRow Row = worksheet.getRow(0); // get my Row which start from 0

	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	int ColNum = Row.getLastCellNum(); // get last ColNum

	Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

	for(
	int i = 0;i<RowNum-1;i++) // Loop work for Rows
	{
		HSSFRow row = worksheet.getRow(i + 1);

		for (int j = 0; j < ColNum; j++) // Loop work for colNum
		{
			if (row == null)
				Data[i][j] = "";
			else {
				HSSFCell cell = row.getCell(j);
				if (cell == null)
					Data[i][j] = ""; // if it get Null value it pass no data
				else {
					String value = formatter.formatCellValue(cell);
					Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
										// data value
				}
			}
		}
	}
}