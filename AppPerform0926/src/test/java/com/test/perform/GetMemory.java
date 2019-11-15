package com.test.perform;

import org.testng.annotations.Test;

import com.test.util.GetDataProperty;

public class GetMemory extends Thread{

	String writeurl=GetDataProperty.getproperdata("memurl");
	String memcomd=GetDataProperty.getproperdata("comdmem");
	
	

	@Override
	public void run() {
		
		String replacestr="TOTAL:";
		
		try {
			ExeCmd.execcommand(writeurl,memcomd, replacestr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
