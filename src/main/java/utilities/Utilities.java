package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Utilities {
	
	public static String read_propert_value(String prop_name) {
		String prop_value="";
		try {
			Properties prop=new Properties();
			FileInputStream inputstream=new FileInputStream("./src/test/resources/config.properties");
			prop.load(inputstream);
			prop_value=prop.getProperty(prop_name);
			
		}
	   catch(Exception e) {
		   e.printStackTrace();
	   }
		return prop_value;
	}
	
	@DataProvider(name="testdata")
	public Object[][] read_excel_data(Method m) throws EncryptedDocumentException, IOException {
		String Excel_SheetName=m.getName();
		File f= new File("./src/test/resources/TestData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sheetname=wb.getSheet(Excel_SheetName);
		int total_rows=sheetname.getLastRowNum();
		Row rowCells=sheetname.getRow(0);
		int total_cols=rowCells.getLastCellNum();
		
		DataFormatter format= new DataFormatter();
		String testData[][] =new String[total_rows][total_cols];
		
		for(int i=1;i<=total_rows;i++) {
			for(int j=0;j<total_cols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
			}
		}
		
		return testData;
		
	}

}
