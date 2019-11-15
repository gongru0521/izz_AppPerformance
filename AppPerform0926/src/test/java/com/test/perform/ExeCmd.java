package com.test.perform;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

import com.test.util.GetNowtime;

public class ExeCmd {

//	static String writeperurl="E:\\workspace\\AppPerform0926\\Logs\\MemResult.xlsx";
	@Test
	
	public void test001() throws Exception{
		//| grep 'TOTAL'
		String cmd="adb shell dumpsys   meminfo com.jpxx.zhzzclient.android.zhzzclient  | grep 'TOTAL:'";
		String replacestr="TOTAL:";
		
		//execcommand(cmd, replacestr);
		
		
		
	}
	//执行命令方法
		public static void execcommand(String writeperurl,String cmd,String replacestr) throws Exception{
			int i=0;
			String resultapp[]=null;
			
			 StringBuilder sb =new StringBuilder();
			 String getnowtime=GetNowtime.getTime();
		        try {
		            Process process=Runtime.getRuntime().exec(cmd);
		            System.out.println("process..."+process);
		            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
		            String line;
		            while((line=bufferedReader.readLine())!=null)
		            {
		            	
		                sb.append(line);
		              //  System.out.println("sb...."+sb);
		               // int index=line.indexOf("TOTAL");
		              //  resultapp=line.substring(index).split(";");
		               // resultapp=line.substring(0,30).replace(replacestr, "").concat(";"+getnowtime).split(";");
		                if(cmd.contains("meminfo")){
		                	resultapp=line.substring(0,30).replace(replacestr, "").concat(";"+getnowtime).split(";");
		                }
		                if(cmd.contains("cpuinfo")){
		                	
		                	resultapp=line.replace(replacestr, "").concat(";"+getnowtime).split(";");
		                }
		                if(cmd.contains("battery")){
		                	
		                	resultapp=line.replace(replacestr, "").concat(";"+getnowtime).split(";");
		                }
		                if(cmd.contains("gfx")){
		                	
		                	resultapp=line.replace(replacestr, "").concat(";"+getnowtime).split(";");
		                }
		               
						WriteDemo.writeExcel(resultapp,writeperurl);
						System.out.println("i:"+i+"....."+line);
				     	i++;
		            }
		        } catch (Exception e) {
		              e.toString();
		        }
	
			//System.out.println("sb.toString():"+sb.toString());
		}
	
}
