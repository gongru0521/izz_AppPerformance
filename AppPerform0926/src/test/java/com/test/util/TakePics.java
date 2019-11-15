package com.test.util;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
public class TakePics {
	
	public static void takepics(AppiumDriver driver,String str[]) throws IOException{
		String picurl=GetDataProperty.getproperdata("picurl");
		
		String timesfilename=GetNowtime.getTime().replaceAll(" ", "").replaceAll("-", "").replaceAll(":", "");;
		
		String filename=picurl+"/"+str[0]+str[6]+"_"+timesfilename+".jpg";
		System.out.println("filename:"+filename);
		
		File screenshot=driver.getScreenshotAs(OutputType.FILE);
		
		File screenfile=new File(filename);
		
		FileUtils.copyFile(screenshot, screenfile);
		
		}
	

}
