package com.test.util;


	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class GetNowtime {

		public static String getTime(){
			
			 String stime=null;
		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		        stime=df.format(new Date()).toString();

		        return stime;
			
			
		}
	

	
}
