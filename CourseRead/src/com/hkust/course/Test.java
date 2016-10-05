package com.hkust.course;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new URL("https://w5.ab.ust.hk/wcq/cgi-bin/1510/subject/ACCT").openStream()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char c = 0 ;
		String result="";
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
		try {
			BufferedOutputStream b=new BufferedOutputStream(new FileOutputStream("D:/ø∆¥Û—ßœ∞/CourseReg/Courseweb.txt"));
			b.write(result.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.print(result);
		
		result=result.substring(result.indexOf("<h2>"),result.length());
		
	}

}
