package com.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AssertString {

	public String assertstr(AndroidDriver driver,String str[]){
		
		
		String resultstr="";
		
		
		
		//如果没有设置断言，结果为NA
		if(str[5].equals("null")){
			
			resultstr="NA";
		}
		//如果有断言
		else{
		
			boolean resultassert=true;
			try{
				
				WebElement assertstr=driver.findElement(By.name(str[5]));
				//如果元素存在结果为pass;否则为false
				if(assertstr!=null){
				
					resultassert=true;
				}
				else{
					
					resultassert=false;
					
				}
			}
			//如果抛出异常返回false
			catch(Exception e){
				
				System.out.println("异常....断言信息不存在");
				resultassert=false;
			}
		
			resultstr=String.valueOf(resultassert);
		}
		
		
		System.out.println("result:"+resultstr);
		
		return resultstr;
	}
	
	
	
	
}
