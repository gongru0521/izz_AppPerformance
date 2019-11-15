package com.test.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
//import org.junit.Test;
import org.testng.annotations.DataProvider;


public class ReadAndWriteCsv {
	
	
//	public String readurl="./CSVFiles/ApiTestData.csv";
//	
//	public String writeurl="./CSVFiles/ResultApiTest.csv";
	
	
	
	//@DataProvider(name="casesprovider")
	String readcsvurl=GetDataProperty.getproperdata("readcsvurl");
	
	public List<String> readCsv() throws Exception {

	    FileInputStream in ;



	    List<String> allstring =  new ArrayList<String>();

	    try {

	        
	        File file = new File(readcsvurl);
	        
	      //  System.out.println("url:"+readurl);
	        in = new FileInputStream(file);




	        //读取文件
	        BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
	         // br.readLine();
	   


	        String line=null ;

	        while ((line = br.readLine()) != null) {
	            //这条与语句很重要
	            //  Log.loguuu("","","开始执行：");


	        	

	            allstring.add(line);

	           System.out.println("EveryLine:"+line);
	          //  System.out.println("allstring:" + allstring);




	        }
	        in.close();
	        br.close();


	    } catch (IOException e) {
	        e.printStackTrace();
	    }



	    return allstring;



	}
	//@Test
	public void testRead() throws Exception{
	//	readCsv();
		
	}
	    //写入csv文件(电脑目录)
	//第一个url是写入地址
	//第二个url是读取地址
	    public void writeCsv(String writeurl, String str) throws Exception {
	     //   Log.v(TAG, "开始写入测试结果:");
	 

	    
	        try {
	            File file2 = new File(writeurl);
	            FileOutputStream fos = new FileOutputStream(file2,true);
	            OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");
	            BufferedWriter bw=new BufferedWriter(osw);







	         //   bw.write("Test Result:");
	        
	            bw.write(str);
	            bw.write("\n");
	          //  fos.close();

	            bw.close();



	        }catch(IOException e){
	            e.printStackTrace();
	        } finally{



	        }



	        }
	
	

}
