package com.hkust.util;

import javax.swing.JLabel;

//�������а�����Ϣ�Ķ�ά�ַ�������
public class OnlineInfoGetter {
	private String[][] AllInfo;
	public OnlineInfoGetter(String IndentityNum,JLabel l){
		String dept[]=new DepatGetter(IndentityNum).getDept();
		l.setText("��ȡԺϵ��Ϣ�ɹ�����"+dept.length+"��Ժϵ");
		AllInfo=new String[dept.length][];
		String[] o=null;
		for(int i=0;i<dept.length;i++){
			o=new OnlineEntityGetter(IndentityNum,dept[i],l).getSegments();
			AllInfo[i]=new String[o.length];
			for(int j=0;j<AllInfo[i].length;j++){
				AllInfo[i][j]=o[j];
			}
		}
		o=null;
	}
	public String[][] getAllInfo(){
		String[][] r=new String[AllInfo.length][];
		for(int i=0;i<r.length;i++){
			r[i]=new String[AllInfo[i].length];
			for(int j=0;j<AllInfo[i].length;j++){
				r[i][j]=AllInfo[i][j];
			}
		}
		return r;
	}
}
