package com.test.util;
//package com.test.Util;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class ResultBack {
//	String readurl=GetDataProperty.getproperdata("readurl");
//	String writeurl=GetDataProperty.getproperdata("writeurl");
//	
//	ReadAndWriteCsv csr=new ReadAndWriteCsv();
//	
//	AllAction ac=new AllAction();
//	
//	public List<String> ListResult() throws Exception{
//		
//		//将测试结果以List<String>形式还回结果
//		List<String> resultlist=new ArrayList();
//		
//		List<String> readlist=csr.readCsv(readurl);
//		
//		
//		
//		//csv读取的数据进行数组分割
//		String strline[]=new String[8];
//		
//		String result=null;
//		String ssreult;
//		
//		Iterator ite=readlist.iterator();
//		while(ite.hasNext()){
//			
//			result=(String)ite.next();
//			strline=result.split(";");
//			//获得每行测试结果
//			ssreult=getresult(strline);
//			//将结果写入csv文件中
//			csr.writeCsv(writeurl, ssreult);
//			
//			resultlist.add(ssreult);
//			
//			
//		}
//		
//		
//		
//		return resultlist;
//		
//		
//		
//		
//	}
//	//获得每行的测试结果
//	
//	public String getresult(String arg[]){
//		
//		String resultss=null;
//		
//		String action=arg[1];
//		switch (action){
//		case "click":
//			ac.clickaction(arg);
//			break;
//		case "edit":
//			ac.editaction(arg);
//			break;
//		case "scroll":
//			ac.scrollaction(arg);
//			break;
//		case "back":
//			ac.backaction(arg);
//		
//		
//		
//		}
//			
//		
//		
//		
//	
//		
//		
//		return resultss;
//		
//		
//		
//		
//	}
//
//}
