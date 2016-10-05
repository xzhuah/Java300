package com.hkust.pack;

import java.io.PrintStream;

import javax.swing.JFrame;

public class JavaLearning1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] a={"Hello","Hell","Hel","He"};
		String [] b=new String[4];
		System.arraycopy(a,0,b,0,b.length);
		b[3]="HHHHH";
		PrintStream p=new PrintStream(System.out);
		int j = 0;
		for(int i=0;i<a.length;i++){
			p.println("a:"+a[i]+j);p.println("b"+b[i]);
		}
		for(String aa:args){
			p.println(aa);
		}
		System.gc();
		
		

	}

}
