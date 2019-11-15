package com.test.util;
//package com.test.Util;
//
//import org.junit.*;
//import java.io.IOException;
//import java.net.URL;
//import java.util.Set;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//public class LaunchApp {
//
//	public  AppiumDriver driver;
//	
//	 public void switchToWindow(String sWindow) {  
//	     //   LogManager.getLogger(this.getClass()).info("Swith to window: " + sWindow);  
//	        Set<String> contextNames = driver.getContextHandles();  
//	       // LogManager.getLogger(this.getClass()).info("Exists windows: " + contextNames.toString());  
//	        for (String contextName : contextNames) {  
//	            if (contextName.contains(sWindow)) {  
//	                driver.context(contextName);  
//	                break;  
//	            }  
//	        }  
//	    }  
//	 @BeforeClass
//		public  void setup() throws IOException{
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			//金立s10配置信息
//
//	        //魅族note手机配置
//	        capabilities.setCapability("deviceName","GIONEE S10");  
//	        capabilities.setCapability("automationName","Appium");  
//	        capabilities.setCapability("platformName","Android");  
//	        capabilities.setCapability("platformVersion","7.0");
//	
//	       // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//	        //    capabilities.setCapability("browserName", "");
//	            capabilities.setCapability("appPackage", "com.jpxx.zhzzclient.android.zhzzclient");  
//	            capabilities.setCapability("appActivity", ".ui.MainActivity");  
////	        capabilities.setCapability("appPackage", "com.itsenpupulai.courierport");  
////	        capabilities.setCapability("appActivity", ".activity.BeforeWelcomeActivity");  
//	            capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session  
//	            capabilities.setCapability("unicodeKeyboard", true);    //设置键盘  
//	            capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘  
//	            
//	            //
//	          //关键是加上这段
//	            ChromeOptions options = new ChromeOptions();
//	            options.setExperimentalOption("androidProcess","WEBVIEW_chrome");
//	            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	            
//	            
//	            
//	            
//	            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);  
//	
//	 }
//	
//	
//	
//	@Test
//	 public void testcase001() throws InterruptedException, IOException{
//  
//        System.out.println("driver:"+driver);
//        	
//        Thread.sleep(10000);
//		WebElement we1=driver.findElement(By.id("com.jpxx.zhzzclient.android.zhzzclient:id/iv_layout"));
//		we1.click();
//		Thread.sleep(10000);
//	}
//	
//	
//	
//	
//
//}
