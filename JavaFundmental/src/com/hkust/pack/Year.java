package com.hkust.pack;
import java.math.BigDecimal;
import java.util.Scanner;
public class Year {
	public static void main(String args[]){
		double i=1.0;
		BigDecimal result=new BigDecimal(0.0);
		while(i<11.0){
			result=result.add(new BigDecimal(1/func(i)));
			i=i+1;
		}
		System.out.println(result);
	}
	private static double func(double i){
		if(i==1) return i;
		else return(i*func(i-1));
	}
}
