package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataProperty {
public static String getproperdata(String key) {
		
	/*
	 * 接口测试配置文件
	 */
	//	String url="./Property/data.properties";
		
	/*
	 * 移动端测试配置文件
	 */
	String url="./Property/comd.properties";
	
		Properties prop=new Properties();
		
		String value=null;
		
		File file=new File(url);
		
		FileInputStream fileins;
		try {
			fileins = new FileInputStream(file);
	
			prop.load(fileins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		value=prop.getProperty(key);
		
		
		return value;
		
		
	}


}
