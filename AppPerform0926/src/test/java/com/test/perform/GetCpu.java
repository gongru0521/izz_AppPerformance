package com.test.perform;

import java.io.IOException;

import org.apache.tools.ant.property.GetProperty;
import org.testng.annotations.Test;

import com.test.util.GetDataProperty;

public class GetCpu extends Thread {
	
	String writeurl=GetDataProperty.getproperdata("cpuurl");
	String comdcpu=GetDataProperty.getproperdata("comdcpu");
	
//@Override
	@Test
	public void run(){
		System.out.println("cpuTest执行run方法:");
		try {
			
		//	for(int i=0;i<10;i++){
			String comdcpu=GetDataProperty.getproperdata("comdcpu");
			String name=" ";
			ExeCmd.execcommand(writeurl,comdcpu,name);
		//	}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
