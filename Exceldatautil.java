package com.exceltest.jsp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatautil {
	
	
	public static List<Personaldata> getExceldata() throws IOException{
		
		List<Personaldata> datalist=new ArrayList<>();
		
		
		BufferedInputStream In=new BufferedInputStream(new FileInputStream("F:\\Java\\test.xlsx"));
		XSSFWorkbook  workbook = new XSSFWorkbook(In);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		
		for(Row row:worksheet) {
			
			Personaldata DT=new Personaldata();
			DT.setRowno(row.getRowNum());
			DT.setFirstName(row.getCell(0).getStringCellValue());
			DT.setLastName(row.getCell(1).getStringCellValue());
			DT.setGender(row.getCell(2).getStringCellValue());
			DT.setAge(row.getCell(3).getStringCellValue());
			DT.setCity(row.getCell(4).getStringCellValue());
			DT.setCountry(row.getCell(5).getStringCellValue());
			datalist.add(DT);
			
		}
		
		workbook.close();
		In.close();		
		return datalist;
	}

	
	
	public static boolean writeExceldata(List<Personaldata> list) throws IOException {
		
		BufferedInputStream In=new BufferedInputStream(new FileInputStream("F:\\Java\\test.xlsx"));
		XSSFWorkbook  workbook = new XSSFWorkbook(In);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		
		for(Row row:worksheet) {
			
			for(Personaldata P:list) {
				
				if(row.getRowNum()==P.getRowno()) {
					
					row.getCell(4).setCellValue(P.getCity());
					row.getCell(5).setCellValue(P.getCountry());
				}
			}
		}
		In.close();
		
		BufferedOutputStream Out=new BufferedOutputStream(new FileOutputStream("F:\\Java\\test.xlsx"));
		workbook.write(Out);
		workbook.close();
		Out.close();		
		return true;
	}
	
}
