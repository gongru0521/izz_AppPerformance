package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.test.util.GetDataProperty;

public class ReadWriteExcel {

	String readurl=GetDataProperty.getproperdata("readurl");
	String writeurl=GetDataProperty.getproperdata("writeurl");
	//读取excel文件
	public List<String[]> ReadExcel() throws IOException, InvalidFormatException{
		List<String[]> readliststr=new ArrayList<String[]>();
		
		//开始读取
		File readexcel = new File(readurl);
		
		FileInputStream fis = new FileInputStream(readexcel);   //文件流对象
		//Workbook   wb = new HSSFWorkbook(fis);
		Workbook   wb=new XSSFWorkbook(readexcel);
		
		 //开始解析
        Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
        //获得行数信息

        int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        /*
        System.out.println("firstRowIndex: "+firstRowIndex);
        System.out.println("lastRowIndex: "+lastRowIndex);
*/
	    try{
        
        for(int rIndex = firstRowIndex; rIndex <=lastRowIndex; rIndex++) {   //遍历行
          //  System.out.println("rIndex: " + rIndex);
            Row row = sheet.getRow(rIndex);
            int firstCellIndex = row.getFirstCellNum();
            int lastCellIndex = row.getLastCellNum();
//            System.out.println("firstCellIndex: "+firstCellIndex);
//            System.out.println("lastCellIndex: "+lastCellIndex);
            if (row != null) {
            	
            	//获取列数信息
               

                
                String[] strarray=new String[lastCellIndex];
                
                for (int cIndex = 0; cIndex < lastCellIndex; cIndex++) {   //遍历列
                	
                    Cell cell = row.getCell(cIndex);
                    if (cell != null) {
                     //   System.out.println("cell.toString():"+cell.toString());
                        strarray[cIndex]=cell.toString();
                        //strarray.add(cell.toString());
                    }
                }
                
                
                readliststr.add(strarray);
                
            }
        }
	
	    }
	    catch(Exception e){
	    	
	    	System.out.println("error");
	    }



        
		
		return readliststr;
 		
	}
	
	//
	
	
	//@Test
	public void test() throws IOException, InvalidFormatException{
		ReadExcel();
	}
	
	
	/*
	 * 写入excel文件中
	 */

	
	
	
}
