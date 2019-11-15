package om.test.AppPerform0926;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.util.ReadWriteExcel;
import com.test.util.AllAction;
import com.test.util.StringTypeChange;
import com.test.util.WriteExcel;


public class LaunchAppium {
	public static AndroidDriver<WebElement> driver;
	AllAction ac=new AllAction();
	ReadWriteExcel rwe=new ReadWriteExcel();
	WriteExcel write=new WriteExcel();
	@BeforeTest
	public   void setup() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
        //金立手机配置
//        capabilities.setCapability("deviceName","GIONEE S10");  
//        capabilities.setCapability("automationName","Appium");  
//        capabilities.setCapability("platformName","Android");  
//        capabilities.setCapability("platformVersion","7.0");
        //红米手机配置
//        capabilities.setCapability("deviceName","RedPro");  
//        capabilities.setCapability("automationName","Appium");  
//        capabilities.setCapability("platformName","Android");  
//        capabilities.setCapability("platformVersion","8.1.0");
        //华为p8手机配置
        capabilities.setCapability("deviceName","GRA-UL00C00B370");  
        capabilities.setCapability("automationName","Appium");  
        capabilities.setCapability("platformName","Android");  
        capabilities.setCapability("platformVersion","6.0");
        
		capabilities.setCapability("appPackage", "com.jpxx.zhzzclient.android.zhzzclient");  
		capabilities.setCapability("appActivity", ".ui.MainActivity");  
      capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session  
      capabilities.setCapability("unicodeKeyboard", true);    //设置键盘  
      capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘  
//      
      
     driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);  
   
  
        
        
        
        
        
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
        System.out.println("app...");
        
        
    	Set<String> contexts = driver.getContextHandles();

		for(String context:contexts) {

		        System.out.println("context:"+context);

		//会打印出  NATIVE_APP（原生app handle）和WEBVIEW_com.example.testapp(webview的 handle)

		}
        
	
}
	
	/*
	 * testng 参数化
	 */
	
	 @DataProvider(name="dataProvider")
		public Object[][] providerTestData() throws InvalidFormatException, IOException{
			
			List<String[]> liststr=rwe.ReadExcel();
			
			Object[][] strparam=StringTypeChange.listObject(liststr);
			
			
			
			return strparam;
		}
	 
	 @Test(dataProvider="dataProvider",threadPoolSize =1, invocationCount = 1)
	 public void test(String ID,String action,String idorpath,String elements,String contents,String assertdata,String casetitle,String verortranse) throws Exception{
		 
		 String resultstr="";
		 String str[]={ID, action, idorpath,elements,contents,assertdata, casetitle,verortranse};
		 switch (action){
			
		 
		 case "Native":
			 resultstr=ac.WebViewToNative(driver,str);
			 break;
		 case "Webview":
			 resultstr=ac.NativeToWebViewChange(driver,str);
			 break;
		 case "Click":
			 resultstr=ac.clickaction(driver,str);
			 break;
		 case "Edit":
			 resultstr=ac.editaction(driver,str);
			 break;
		 case "Clear":
			 resultstr=ac.clearEdit(driver,str);
			 break;
		 case "Back":
			 resultstr=ac.backaction(driver,str);
			 break;
		 case "Scroll": 
			 resultstr=ac.scrollaction(driver,str);
			 break;
		 default:
				break;
		 
			
		}
		
		String writestr[]=resultstr.split(";");
		write.write(writestr);
		 
		 
		 
		 
		 
		 
	 }

}
