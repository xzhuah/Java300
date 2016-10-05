package com.hkust.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JLabel;


public class OnlineEntityGetter {
	
	private  String exampleURL="https://w5.ab.ust.hk/wcq/cgi-bin/1510/subject";
	private  String page;
	private  String[] segments;
	
	public OnlineEntityGetter(String urlNum,String dep,JLabel l){
		GetAllCourseTag(urlNum,dep,l);
	}
	public String[] getSegments(){
		return this.segments;
	}
	//将页面标签放入segments数组中
	private void GetAllCourseTag(String urlNum,String dep,JLabel l){
		ReadPage(urlNum,dep,l);
		InitSegments(l);
		page="";
	}
	
	//读取整个界面
	private void ReadPage(String urlNum,String dep,JLabel l){
		BufferedReader in = null;
		String result="";
		try {
			in = new BufferedReader(new InputStreamReader(new URL(exampleURL.replace("1510", urlNum)+"/"+dep).openStream()));
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
		page=result;
		l.setText("正在读取"+dep+"的课程信息,共"+getCourseNum()+"个课程,已完成:0");
	}
	//帮助初始化数组
	private void InitSegments(JLabel l){
		segments=new String[getCourseNum()];
		for(int i=0;i<segments.length;i++){
			segments[i]=getNextTag(l);
		}
	}
	
	
	//读取下一个课程的整个标签
	private String getNextTag(JLabel l){
		
		String result="";
		int i=page.indexOf("<div class=\"course\">");
		int j=page.indexOf("</div>\n<div class=\"course\">");
		if(j==-1){
			j=page.indexOf("</div>\n</div>\n<script type=\"text/javascript\">\n$(\".courseanchor\")");
			if(j==-1) {
				return result;
			}
		}
		result=page.substring(i,j);
		page=page.substring(j+6,page.length());
		
		l.setText(l.getText().substring(0,l.getText().indexOf(":")+1)+(1+Integer.parseInt(l.getText().substring(l.getText().indexOf(":")+1, l.getText().length()))));		
		return result;	
	}
	//读取页面上的课程数量
	private int getCourseNum(){		
		return (page.length()-page.replaceAll("<h2>", "").length())/4;
	}
	
	
	
	
}
