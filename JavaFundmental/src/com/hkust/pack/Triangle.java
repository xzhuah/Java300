package com.hkust.pack;
import java.util.Scanner;
public class Triangle {
	public static void main(String arg[]){
		Scanner s=new Scanner(System.in);
		while(true){
		String ss=s.next();
		char[] arr=ss.toCharArray();
		for(int i=0;i<arr.length;i++){
			arr[i]=(char)(arr[i]^20000);
		}
		System.out.println(new String(arr));
		}
	}
}
