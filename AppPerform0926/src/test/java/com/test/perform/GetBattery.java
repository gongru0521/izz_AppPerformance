package com.test.perform;

import org.testng.annotations.Test;

import com.test.util.GetDataProperty;

public class GetBattery extends Thread{

	String writeurl=GetDataProperty.getproperdata("batteryurl");
	String batterycomd=GetDataProperty.getproperdata("comdbattery");
	
	

//	@Override
	@Test
	public void run() {
		
		String replacestr="level:";
		
		try {
			ExeCmd.execcommand(writeurl,batterycomd, replacestr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
