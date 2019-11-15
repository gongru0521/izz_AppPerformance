package com.test.perform;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDemo {
	
	/*
	 * 判断是xls,还是xlsx文件
	 */
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
	
	/*
	 * 写入excel	
	 */
	public  static void writeExcel(String str[],String writeurl ) throws Exception{
		 FileInputStream in= new FileInputStream(writeurl);
		
			
	     XSSFWorkbook workbook = new XSSFWorkbook(in);
	     XSSFSheet sheet = workbook.getSheetAt(0);
	     XSSFRow row=sheet.getRow(1);

	     FileOutputStream out = new FileOutputStream(writeurl);
	   
	     //追加行数据
	     row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据
	    // row.createCell(0).setCellValue("测试数据"); //设置第一个（从0开始）单元格的数据
	   //  row.createCell(1).setCellValue("haha"); //设置第二个（从0开始）单元格的数据*/
	     for(int j=0;j<str.length;j++){
	         	
	         	row.createCell(j).setCellValue(str[j]);
	         }

	     try {
	         out.flush();
	         workbook.write(out);
	         out.close();
	     }catch (Exception e){
	         e.printStackTrace();
	     }
	}
	
		public static void write(String str[],String writeurl) throws Exception{
			
			Workbook wb = null;
			try {
				if (isExcel2003(writeurl)) {
					wb = new HSSFWorkbook();
				} else if (isExcel2007(writeurl)) {
					wb = new XSSFWorkbook();
				} else {
					throw new Exception("当前文件不是excel文件");
				}
			
		
		   
			}
			catch (Exception e){
				
				throw new Exception();
				
				
			}

		
		}
	
}
