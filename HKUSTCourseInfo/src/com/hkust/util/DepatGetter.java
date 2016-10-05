package com.hkust.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DepatGetter {
	private  String exampleURL="https://w5.ab.ust.hk/wcq/cgi-bin/1510/";
	private  String[] dept;
	public DepatGetter(String urlNum){
		ReadPage(urlNum);
	}
	public String[] getDept(){
		return dept;
	}
	private  void ReadPage(String urlNum){
		String page;
		BufferedReader in = null;
		String result="";
		try {
			in = new BufferedReader(new InputStreamReader(new URL(exampleURL.replace("1510", urlNum)).openStream()));
		} catch (MalformedURLException e) {		
		} catch (IOException e) {		
		}
		char c = 0 ;
		int i=0;
		do{
			try {
				i=in.read();
				c=(char)i;
				result+=c;
			} catch (IOException e) {
				break;			
			}		
		}while(i!=-1);
		result=result.substring(0,result.length()-1);
		page=result.substring(result.indexOf("<div class=\"depts\">"),result.indexOf("</div>\n<script type=\"text/javascript\">\n	var navHeight = $('#navigator').outerHeight(true);"));
		dept=new String[getDeptNum(page)];
		for(int ii=0;ii<dept.length;ii++){
			dept[ii]=page.substring(page.indexOf("</a>")-4,page.indexOf("</a>"));
			page=page.replaceFirst("</a>", "");
		}
	}
	private  int getDeptNum(String s){
		return (s.length()-s.replaceAll("</a>", "").length())/4;
	}
	
	
}
