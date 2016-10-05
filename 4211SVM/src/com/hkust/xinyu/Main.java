package com.hkust.xinyu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_problem;
public class Main {
	public static String path="D:/科大学习/在读科目/COMP 4211/Assignment/work";
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		//do_train();
		//getSV();
		draw_all();
	}
	public static void getSV() throws IOException{
		for(int d=1;d<=5;d++){
			//for(int i=-5;i<=5;i++){
				//String pp=path+"/model_file_d"+d+"_c"+Math.pow(2, i)+".txt";
				String pp=path+"/model_file_d"+d+".txt";
				System.out.println(pp);
				BufferedReader bur=new BufferedReader(new FileReader(pp));
				String all="";
				String line=bur.readLine();
				while(line!=null){
					all+=line;
					line=bur.readLine();
				}
				all=all.substring(all.indexOf("SV")+2,all.length());
				bur.close();
				//BufferedWriter buw=new BufferedWriter(new FileWriter(path+"/sv_d"+d+"_c"+Math.pow(2, i)+".txt"));
				BufferedWriter buw=new BufferedWriter(new FileWriter(path+"/sv_d"+d+".txt"));
				buw.write(all);
				buw.close();
			//}
		}
	}
	
	public static void do_train() throws IOException{
		BufferedWriter buw=new BufferedWriter(new FileWriter(path+"/do_train.bat"));
		String all="";
		for(int d=1;d<=5;d++){
			for(int i=-5;i<=5;i++){
				all+="svm-train -t 1 -v 5 -d "+d+" -c "+Math.pow(2, i)+" train.txt>model_file_d"+d+"_c"+Math.pow(2, i)+".txt\r\n";
				//all+="svm-predict test.txt model_file_d"+d+"_c"+Math.pow(2, i)+".txt output_d"+d+"_c"+Math.pow(2, i)+".txt\n\r";
			}
		}
		buw.write(all);
		buw.close();
	}
	public static void draw_all() throws IOException{
		BufferedWriter buw=new BufferedWriter(new FileWriter(path+"/draw_all.bat"));
		String all="python plot_train.py train.txt train_data.png\r\n";
		for(int d=1;d<=5;d++){
			//for(int i=-5;i<=5;i++){
				//all+="python plot_train.py train.txt sv_d"+d+"_c"+Math.pow(2, i)+".txt sv_d"+d+"_c"+i+".png\n\r";
				//all+="python plot_test.py test.txt output_d"+d+"_c"+Math.pow(2, i)+".txt test_data_d"+d+"_c"+i+".png\n\r";
				all+="python plot_train.py train.txt sv_d"+d+".txt sv_d"+d+".png\r\n";
				all+="python plot_test.py test.txt output_d"+d+".txt test_data_d"+d+".png\r\n";
			//}
		}
		buw.write(all);
		buw.close();
	}

}
