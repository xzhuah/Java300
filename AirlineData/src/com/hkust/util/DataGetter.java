package com.hkust.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import com.hkust.bean.Flight;

public class DataGetter {

	
	private String path;
	private String page;
	public DataGetter(String path) throws Exception{
		this.path=path;
		this.page=new TxtReader().getTextFromTxt(path);
		
	}
	public Flight[] getData(){
		page=page.substring(page.indexOf("<th class=\"colheadone\" scope=\"col\">Delay<br>Late Aircraft Arrival<br>(Minutes)</th>"),page.lastIndexOf("<table width=\"98%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"));
		page=page.substring(page.indexOf("</tr>")+5,page.lastIndexOf("</tbody></table><br><br>"));
		Flight[] v=new Flight[(page.length()-page.replace("<tr>", "").length())/4];
		
		for(int i=0;i<v.length;i++){
			v[i]=GetFirstFlightFromString();
		}
		return v;
	}
	private Flight GetFirstFlightFromString(){
		String s=page.substring(page.indexOf("<tr>"),page.indexOf("</tr>"));
		page=page.substring(page.indexOf("</tr>")+5,page.length());
		Flight f=new Flight();
		f.setCarrierCode(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDate(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setFlightNumber(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setTailNumber(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDestAirport(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setSDeptTime(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));		
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setADeptTime(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setSElapsedTime(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setAElapsedTime(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDeptDelay(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setWheelsOffTime(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setTaxiOutTime(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDelayCarrier(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDelayWeather(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDNAS(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDS(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		f.setDLAA(s.substring(s.indexOf("\">")+2,s.indexOf("</td>")));
		s=s.substring(s.indexOf("</td>")+5,s.length());
		return f;
	}
	private class TxtReader {   
	    public TxtReader() {           
	    }   
	    /**  
	     * @param filePath 文件路径  
	     * @return 读出的txt的内容  
	     */  
	    public String getTextFromTxt(String filePath) throws Exception {   
	           
	        FileReader fr = new FileReader(filePath);   
	        BufferedReader br = new BufferedReader(fr);   
	        StringBuffer buff = new StringBuffer();   
	        String temp = null;   
	        while((temp = br.readLine()) != null){   
	            buff.append(temp + "\r\n");   
	        }   
	        br.close();        
	        return buff.toString();        
	    }  
	   
	}  

}
