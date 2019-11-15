package com.test.util;

import java.util.ArrayList;
import java.util.List;

public class StringTypeChange {
	
	/*
	 * List<String>转换为List<String[]>
	 */
	public static List<String[]> listArrayChange( List<String> liststr){
		List<String[]> listarrays=new  ArrayList<String[]>();
		
		for(int i=0;i<liststr.size();i++){
			
			String[] strattar=liststr.get(i).split(";");
			
			listarrays.add(strattar);
			
		}
		
		return listarrays;
		
		
	}
/*
 * List<String[]>转换为Object[][]
 */
	
	
	public static Object[][] listObject(List<String[]> listarray){
		
		String[][] resultback=new String[listarray.size()][];
	    
	    //
	    for(int i=0;i<resultback.length;i++){
	    	
	    	resultback[i]=(String[]) listarray.get(i);    	
	    	
	    }
	    
	    return resultback;
	
	}
		
	
	
}
