import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataTest {
	
	
	public ArrayList<String> getdata(String testcasename) throws IOException
	{
	ArrayList<String> arraylist=new ArrayList<String>();
		
		FileInputStream fis=new FileInputStream("/Users/jiniab/eclipse-selenium/DataDriven/Data/LoginData.xlsx");
	
XSSFWorkbook workbook=new XSSFWorkbook(fis);
    int sheet=workbook.getNumberOfSheets();
   // if(workbook.getSheetName(sheet))
    
    for(int i=0;i<sheet;i++)
    {
    	if(workbook.getSheetName(i).equalsIgnoreCase("LoginData"))
    			{
    	XSSFSheet sheets=workbook.getSheetAt(i);
    	Iterator<Row> rows=sheets.rowIterator();
    	Row firstrow=rows.next();
    	Iterator<Cell> cell=firstrow.cellIterator();
    	int k=0;
    	int column=0;
    	while(cell.hasNext()) {
    		Cell value=cell.next();
    		if(value.getStringCellValue().equalsIgnoreCase("username ")) {
    			column=k;
    		}
    		k++;
    	}
    	// System.out.println("Column number of username is " +column);
    	while(rows.hasNext())
    	{
    		Row r=rows.next();
    		if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
    			
    			//grab the cell content of the mngr137319
    			Iterator <Cell> cellvalues=r.cellIterator();
    			
    			while(cellvalues.hasNext())
    			{
    				Cell c=cellvalues.next();

    				if(c.getCellType()==CellType.STRING)
    				{
    				arraylist.add(c.getStringCellValue());
    				}
    				else {
    					arraylist.add(NumberToTextConverter.toText(c.getNumericCellValue())) ;
    					
    				}
    				
    			}
    		} 
    		
    	}
    	
    }
    	workbook.close();
    
    }
	return arraylist;
	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	

	}
}


