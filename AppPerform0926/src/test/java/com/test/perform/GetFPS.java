package com.test.perform;

import org.testng.annotations.Test;

import com.test.util.GetDataProperty;

public class GetFPS extends Thread{

	String writeurl=GetDataProperty.getproperdata("gfxurl");
	String comdgfx=GetDataProperty.getproperdata("comdgfx");

	//@Override
	@Test
	public void run() {
		
		String replacestr="90th percentile:";
		
		try {
			ExeCmd.execcommand(writeurl,comdgfx, replacestr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	
}
