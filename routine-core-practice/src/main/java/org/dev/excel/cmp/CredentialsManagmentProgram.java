package org.dev.excel.cmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CredentialsManagmentProgram {
	
	public static void writeExcelFile() throws IOException {

		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("student details");
		
        Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
        data.put("1", new Object[]{ "ID", "NAME", "LASTNAME" }); 
        data.put("2", new Object[]{ 1, "Pankaj", "Kumar" }); 
        data.put("3", new Object[]{ 2, "Prakashni", "Yadav" }); 
        data.put("4", new Object[]{ 3, "Ayan", "Mondal" }); 
        data.put("5", new Object[]{ 4, "Virat", "kohli" }); 
        
        Set<String> keyset=data.keySet();
        int rownum=0;
        
        for (String key : keyset) {
			Row row=sheet.createRow(rownum++);
			Object[] objArr=data.get(key);
			
			int cellno=0;
			for (Object obj : objArr) {
				Cell cell=row.createCell(cellno++);
				if(obj instanceof String) {
					cell.setCellValue((String) obj);
				}else if(obj instanceof Integer){
					cell.setCellValue((Integer) obj);
				}
			}
		}
        try {
			FileOutputStream out= new FileOutputStream(new File("C:\\Users\\Dev\\Desktop\\ecentric\\student.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("File Generated Successfully!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	public static void readExcelFile() throws IOException {
		try {
			FileInputStream fis=new FileInputStream(new File("C:\\Users\\Dev\\Desktop\\ecentric\\student.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0); 
			
			Iterator<Row> rowIterator=sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next(); 
					switch (cell.getCellType()) { 
                    case Cell.CELL_TYPE_NUMERIC: 
                        System.out.print(cell.getNumericCellValue() + " "); 
                        break; 
                    case Cell.CELL_TYPE_STRING: 
                        System.out.print(cell.getStringCellValue() + " "); 
                        break; 
                        
					}     
				}
				System.out.println(""); 
				
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void appendExistingExcelFile() throws IOException {
		String FILE_NAME="C:\\Users\\Dev\\Desktop\\ecentric\\student.xlsx";
		try {
			InputStream inp=new FileInputStream(FILE_NAME);
			XSSFWorkbook workbook = new XSSFWorkbook(inp); 
			Sheet sheet = workbook.getSheetAt(0); 
			
			int num = sheet.getLastRowNum();
			Row row = sheet.createRow(++num);
			row.createCell(0).setCellValue("6");
			row.createCell(1).setCellValue("Devdyuti");
			row.createCell(2).setCellValue("SINGH");
			
			
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME); 
			workbook.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		//writeExcelFile();
		//readExcelFile();
		appendExistingExcelFile();
	}
}
