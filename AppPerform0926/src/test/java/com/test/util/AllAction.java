package com.test.util;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import javax.swing.text.html.ListView;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AllAction {
	

	
	AssertString ast=new AssertString();

	
	public String clickaction(AndroidDriver driver,String str[]) throws IOException{
		System.out.println("driver:"+driver);
		
		String resultback=null;
		
	//	System.out.println("str[0]:"+str[0]);
		String idorxpath=str[2];
	try{
		WebElement clickact = null;
		switch(idorxpath){
	
		case "Id":
			
			clickact=driver.findElement(By.id(str[3]));
			break;
			
		case "Xpath":
			clickact=driver.findElement(By.xpath(str[3]));
			break;
		case "Text":
		   clickact=driver.findElement(By.name(str[3]));
		case "Coordinates":
			clickCoordinates(driver,str);
			
		default:
				break;
		}

		if(clickact!=null){
			
				clickact.click();
			
		
			}
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
	}catch(Exception e){
		
		System.out.println("动作元素不存在");
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+"FAIL动作未执行"+";"+GetNowtime.getTime();
	}
	
	
		TakePics.takepics(driver, str);
		
		return resultback;
		
	}
	
	public String editaction(AndroidDriver driver,String str[]) throws IOException{
		
		String resultback=null;
		
		WebElement editact=null;
		
		//=driver.findElement(By.id(str[2]));
		String idorxpath=str[2];
	try{
		switch(idorxpath){
		case "Id":
			
			editact=driver.findElement(By.id(str[3]));
			break;
			
		case "Xpath":
			editact=driver.findElement(By.xpath(str[3]));
			break;
		
		default:
				break;
		}
		
		TakePics.takepics(driver, str);
	
		if(editact!=null){
		
			editact.sendKeys(str[4]);	
			
		
		}
		else{
			System.out.println("no element!");
			
			
		}
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
	}catch(Exception e){
		
		System.out.println("动作元素不存在");
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+"FAIL动作未执行"+";"+GetNowtime.getTime();
	}
		TakePics.takepics(driver, str);
		
		
		return resultback;
		
	}
	//下拉滑动
	
	public String scrollaction(AndroidDriver<WebElement> driver,String str[]) throws InterruptedException, IOException{
		
		String resultback=null;
		
		
		
		
		
		TakePics.takepics(driver, str);
		int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height;//获取当前屏幕的高
		//driver.swipe(width/2,height/4,width/2,height *3 /4,1000);//向下滑动
		
		 String scrollparam=str[7];
		 
		 switch (scrollparam){
		 //向下滑动
		 case "verticalDown":
			 VerticalDown(driver, width, height);
			  break;
		 case "verticalUp":
			 VerticalUp(driver, width, height);
			 break;
		 case "transverseLeft":
			 TransverseLeft(driver, width, height);
			 break;
		 case "transverseRight":
			 TransverseRight(driver, width, height);
			 break;
		 default:
				break;
		 }

		 TakePics.takepics(driver, str);
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
		return resultback;
	}
	//系统返回键
	public String backaction(AndroidDriver driver,String str[]) throws InterruptedException, IOException{
		
		String resultback=null;
		TakePics.takepics(driver, str);
		String cmdstr="adb shell input keyevent 4";
		Runtime.getRuntime().exec(cmdstr).waitFor();
		Thread.sleep(1000);
		
		TakePics.takepics(driver, str);
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
		return resultback;
	}
	//清空编辑框
	public String clearEdit(AndroidDriver driver,String str[]) throws IOException{
		String resultback=null;
		TakePics.takepics(driver, str);
		String ele=str[3];
		WebElement text=null;
		String idorpath=str[2];
	try{
		switch(idorpath){
		case "Id":
			
			text=driver.findElement(By.id(str[3]));
			break;
			
		case "Xpath":
			text=driver.findElement(By.xpath(str[3]));
			break;
		default:
				break;
		}
		TakePics.takepics(driver, str);
		
	//	WebElement text=driver.findElement(By.id(ele));
		String strtext=text.getText();
		
		
		
		for(int i=0;i<strtext.length();i++){
			
			text.clear();
			//driver.sendKeys(AndroidKeyCode.BACKSPACE);
			
		}
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
	}catch(Exception e){
		TakePics.takepics(driver, str);
		System.out.println("动作元素不存在");
		resultback=str[0]+";"+str[1]+";"+str[3]+";"+str[6]+";"+"FAIL动作未执行"+";"+GetNowtime.getTime();
	}
		
		
		return resultback;
		
		
	}
	//
	public String NativeToWebViewChange(AndroidDriver driver,String str[]) throws IOException{
		
		String resultback=null;
		
		driver.context("");
		resultback=str[0]+";"+str[1]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
		TakePics.takepics(driver, str);
		return resultback;
		
	}
	
	public String WebViewToNative(AndroidDriver driver,String str[]){
		
		String resultback=null;
		
		driver.context("NATIVE_APP");
		resultback=str[0]+";"+str[1]+";"+str[2]+";"+str[6]+";"+ast.assertstr(driver,str)+";"+GetNowtime.getTime();
		
		return resultback;
		
	}
	//向上滑动
	public void VerticalUp(AndroidDriver<WebElement> driver,int width, int  height) throws InterruptedException{
		
		for(int j=0;j<10;j++){
			Thread.sleep(500);
			new TouchAction(driver).longPress(PointOption.point(width / 2, height*3/4))
	         .moveTo(PointOption.point(width / 2, height/4)).release()
	         .perform();

			
		}
	}
	
	//向下滑动
	public void VerticalDown(AndroidDriver<WebElement> driver,int width, int  height) throws InterruptedException{
		
		for(int j=0;j<10;j++){
			Thread.sleep(500);
			new TouchAction(driver).longPress(PointOption.point(width / 2, height/2))
	         .moveTo(PointOption.point(width / 2, height*3/4)).release()
	         .perform();

			
		}
		
	}
	//向左滑动
	public void TransverseLeft(AndroidDriver<WebElement> driver,int width, int  height) throws InterruptedException{
		
		for(int j=0;j<5;j++){
			
			Thread.sleep(500);
			new TouchAction(driver).longPress(PointOption.point(width*3 / 4, height/2))
	         .moveTo(PointOption.point(width/ 4, height/2)).release()
	         .perform();
			
		
	
			}
	}
	
	//向右滑动
	public void TransverseRight(AndroidDriver<WebElement> driver,int width, int  height) throws InterruptedException{
		for(int j=0;j<5;j++){
			
			Thread.sleep(500);
			new TouchAction(driver).longPress(PointOption.point(width/ 4, height/2))
	         .moveTo(PointOption.point(width*3/ 4, height/2)).release()
	         .perform();
			
		
	
			}
	}
	/*
	 * 根据坐标点击
	 */
	
	public void clickCoordinates(AndroidDriver<WebElement> driver,String str[] ){
		
		String Coordinates=str[4];
		
		String[] location=Coordinates.split(";");
		try{
		int x1=Integer.valueOf(location[0]);
		int y1=Integer.valueOf(location[1]);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap tapObject = new HashMap();
		tapObject.put("x", x1);
		tapObject.put("y", y1);
		tapObject.put("duration", 100);
		js.executeScript("mobile: tap", tapObject);
		}catch(Exception e){
			
			System.out.println("点击坐标位置操作失败!!!!");
		}
		
	}
	

}
