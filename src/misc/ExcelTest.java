package misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static XSSFCell getCellByName(XSSFWorkbook book, String name) {
		XSSFName one=book.getName(name);
		//System.out.println(one.getRefersToFormula());
		CellReference ref=new CellReference(one.getRefersToFormula());
		return book.getSheet(one.getSheetName()).getRow(ref.getRow()).getCell(ref.getCol());
	}
	
	public static void main(String[] args) {
		
		try {
		
			File excelFile=new File("excel/data.xlsx");		
			FileInputStream excelStream = new FileInputStream(excelFile); //throws FileNotFoundException
			
			XSSFWorkbook wb=new XSSFWorkbook(excelStream);
			
			XSSFSheet s =wb.getSheet("A");
			
			
			
			
			int rowStart=0;
			int colStart=0;
			int a,b;
			if(s==null) {
				System.out.println("Sheet is NULL");
				return;
			}
				
			do {
				
				XSSFRow row=s.getRow(rowStart);
				if(row==null)
					break;
				XSSFCell a_cell=row.getCell(colStart);
				XSSFCell b_cell=row.getCell(colStart+1);
				if(a_cell==null || b_cell==null)
					break;
				a = (int) a_cell.getNumericCellValue();
				b = (int) b_cell.getNumericCellValue();
				
				row.createCell(colStart+2).setCellValue(a+b);
				
				rowStart++;
			}while(true);
			
					
			double tot=getCellByName(wb, "one").getNumericCellValue() + getCellByName(wb, "two").getNumericCellValue();
			
			XSSFName newName=wb.createName();
			newName.setNameName("total");
			newName.setRefersToFormula(Double.toString(tot));//wb.getSheetAt(0).getSheetName()+"!$A$1");
			//getCellByName(wb, "total").setCellValue(tot);
			
			if(rowStart>0) {
				FileOutputStream fout=new FileOutputStream(new File("excel/data_out.xlsx"));
				wb.write(fout);
				fout.close();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}
}
	