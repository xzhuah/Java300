package com.hkust.pack;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetHttp {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		BufferedInputStream b=new BufferedInputStream(new URL("http://course.cse.ust.hk/comp2012h").openStream());
		int i=b.read();
		do{
			System.out.print((char)i);i=b.read();
		}while(i!=-1);
	}

}
