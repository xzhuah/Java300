package com.hkust.util;
import java.util.Vector;

import com.hkust.entity.Class;
import com.hkust.entity.Instructor;
import com.hkust.entity.TeachingRelation;
public class ClassGetter {
	public static void main(String args[]){
		/*
		//String ss="<div class=\"course\"><div class=\"courseanchor\" style=\"position:relative; float:left; visibility:hidden;\"><a name=\"COMP2012H\">&nbsp;</a></div><div class=\"courseinfo\"><div class=\"courseattr popup\"><span style=\"font-size: 12px; color: #688; font-weight: bold;\">COURSE INFO</span><div class=\"popupdetail\"><table width=\"400\"><tr><th>PRE-REQUISITE</th><td>Grade A or above in COMP 1002 / COMP 1021 / COMP 1022P / COMP 1022Q / ISOM 3230</td></tr><tr><th>EXCLUSION</th><td>COMP 1003 (prior to 2011-12), COMP 1004 (prior to 2013-14), COMP 2011, COMP 2012</td></tr><tr><th>PREVIOUS CODE</th><td>COMP 152H</td></tr><tr><th>DESCRIPTION</th><td>This course is an accelerated and intensive course on concepts and techniques behind object-oriented programming (OOP) and data structures using an OOP language. It covers the major materials of COMP2011 and COMP2012, and its curriculum is designed for students with excellent programming background or substantial programming experience. Topics include: functions; pointers; abstract data types and their class implementation; static and dynamic construction and destruction of objects; data member and member functions; public interface and encapsulation; class hierarchies; polymorphism; inheritance and dynamic binding; standard template library; generic programming using templates; object-oriented view of data structures: linked lists, queues, stacks, trees, and their algorithms such as searching, sorting and hashing.</td></tr>	</table></div></div></div><h2>COMP 2012H - Honors Object-Oriented Programming and Data Structures (5 units)</h2><table class=\"sections\" width=\"1012\"><tr><th width=\"85\">Section</th><th width=\"190\" style=\"text-align: left\">Date & Time</th><th width=\"160\" style=\"text-align: left\">Room</th><th width=\"190\" style=\"text-align: left\">Instructor</th><th width=\"45\">Quota</th><th width=\"45\">Enrol</th><th width=\"45\">Avail</th><th width=\"45\">Wait</th><th width=\"81\">Remarks</th></tr><tr class=\"newsect secteven\"><td align=\"center\">L1 (1772)</td><td>TuTh 12:30PM - 02:20PM</td><td>Rm 2406, Lift 17-18 (76)</td><td><a href=\"/wcq/cgi-bin/1510/instructor/CHAN, Gary Shueng Han\">CHAN, Gary Shueng Han</a></td><td align=\"center\">60</td><td align=\"center\">34</td><td align=\"center\">26</td><td align=\"center\">0</td><td align=\"center\">&nbsp;</td></tr><tr class=\"newsect sectodd\"><td align=\"center\">LA1 (1773)</td><td>Th 02:30PM - 04:20PM</td><td>Rm 4210, Lift 19 (67)</td><td><a href=\"/wcq/cgi-bin/1510/instructor/CHAN, Gary Shueng Han\">CHAN, Gary Shueng Han</a></td><td align=\"center\">60</td><td align=\"center\">34</td><td align=\"center\">26</td><td align=\"center\">0</td><td align=\"center\">&nbsp;</td></tr></table>";
		Vector<Instructor> instr = new Vector<Instructor>();
		Vector<TeachingRelation> teach = new Vector<TeachingRelation>();
		Class c[];
		String s[][]=new OnlineInfoGetter("1510").getAllInfo();
		c=getClass(s[9][14],instr,teach);
		for(int i=0;i<c.length;i++){
			System.out.print("Course_name:"+c[i].getCourse_name()+" Section:"+c[i].getSection()+" Time:"+c[i].getTime()+" Room:"+c[i].getRoom()+" Quota: "+c[i].getQuota()+" Enroll:"+c[i].getEnrol()+" Wait:"+c[i].getWait()+" Type:"+c[i].getType());
			System.out.println();
		}
		for(int i=0;i<instr.size();i++){
			System.out.print("Professor:"+instr.get(i).getName());
			System.out.println();
		}
		for(int i=0;i<teach.size();i++){
			System.out.print("Name:"+teach.get(i).getName()+" Session:"+teach.get(i).getSection());
			System.out.println();
		}
		
		System.out.println("-------------------------------------------------------------");
		instr = new Vector<Instructor>();
		teach = new Vector<TeachingRelation>();
		c=getClass(s[20][2],instr,teach);
		for(int i=0;i<c.length;i++){
			System.out.print("Course_name:"+c[i].getCourse_name()+"Section:"+c[i].getSection()+" Time:"+c[i].getTime()+" Room:"+c[i].getRoom()+" Quota: "+c[i].getQuota()+" Enroll:"+c[i].getEnrol()+" Wait:"+c[i].getWait()+" Type:"+c[i].getType());
			System.out.println();
		}
		for(int i=0;i<instr.size();i++){
			System.out.print("Professor:"+instr.get(i).getName());
			System.out.println();
		}
		for(int i=0;i<teach.size();i++){
			System.out.print("Name:"+teach.get(i).getName()+" Session:"+teach.get(i).getSection());
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------");
		instr = new Vector<Instructor>();
		teach = new Vector<TeachingRelation>();
		c=getClass(s[5][3],instr,teach);
		for(int i=0;i<c.length;i++){
			System.out.print("Course_name:"+c[i].getCourse_name()+"Section:"+c[i].getSection()+" Time:"+c[i].getTime()+" Room:"+c[i].getRoom()+" Quota: "+c[i].getQuota()+" Enroll:"+c[i].getEnrol()+" Wait:"+c[i].getWait()+" Type:"+c[i].getType());
			System.out.println();
		}
		for(int i=0;i<instr.size();i++){
			System.out.print("Professor:"+instr.get(i).getName());
			System.out.println();
		}
		for(int i=0;i<teach.size();i++){
			System.out.print("Name:"+teach.get(i).getName()+" Session:"+teach.get(i).getSection());
			System.out.println();
		}*/
	}
	public static Class[] getClass(String s,Vector<Instructor> instr,Vector<TeachingRelation> teach){
		
		Class c[]=new Class[getClassNum(s)];
		
		String[] classInfo=getClassString(s);
		for(int i=0;i<c.length;i++){
			try{
			c[i]=new Class();
			c[i].setCourse_name(s.substring(s.indexOf("<h2>")+4,s.indexOf("</h2>")).substring(0,s.substring(s.indexOf("<h2>")+4,s.indexOf("</h2>")).indexOf("-")-1).replaceAll("\n", " "));	
			classInfo[i]=classInfo[i].replaceAll("<tr class=\"newsect sectodd\">","");
			classInfo[i]=classInfo[i].replaceAll("<tr class=\"newsect secteven\">","");
			String temp=classInfo[i].substring(0, classInfo[i].indexOf("</td>"));
			int timeNum;
			if(temp.indexOf("rowspan")==-1){
				timeNum=1;
			}else{
				timeNum=Integer.parseInt(temp.substring(temp.indexOf("rowspan=\"")+9,temp.indexOf("rowspan=\"")+10));
			}
			
			String section=classInfo[i].substring(classInfo[i].indexOf(">")+1, classInfo[i].indexOf("</td>",classInfo[i].indexOf(">")));			
			String classId=section.substring(section.indexOf("(")+1,section.indexOf(")",section.indexOf("(")));
			if(section.contains("LA")){
				c[i].setType(3);
			}else if(section.contains("T")){
				c[i].setType(2);
			}else{
				c[i].setType(1);
			}
			c[i].setSection(section);
			c[i].setClassId(Integer.parseInt(classId));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5, classInfo[i].length());
			
			
			
			String time=classInfo[i].substring(classInfo[i].indexOf("<td>")+4,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td>")));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			String Room=classInfo[i].substring(classInfo[i].indexOf("<td>")+4,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td>")));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			c[i].setTime(time);
			c[i].setRoom(Room);
			
			String InstructorInfo=classInfo[i].substring(classInfo[i].indexOf("<td>")+4,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td>")));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			int profNum=(InstructorInfo.length()-InstructorInfo.replaceAll("<br>", "").length())/4;
			for(int count=0;count<=profNum;count++){
				try{
				String name=InstructorInfo.substring(InstructorInfo.indexOf("instructor/")+11,InstructorInfo.indexOf("\">",InstructorInfo.indexOf("instructor/")));
				Instructor ins=new Instructor();
				ins.setName(name);
				instr.add(ins);
				TeachingRelation te=new TeachingRelation();
				te.setName(name);te.setSection(section);
				teach.add(te);
				try{
				InstructorInfo=InstructorInfo.substring(InstructorInfo.indexOf("<br>")+4,InstructorInfo.length());
				}catch(Exception e){break;}
				}catch(Exception e){
					//TBA 
					break;
				}
			}
			
			String QutaInfo=classInfo[i].substring(classInfo[i].indexOf("<td")+3,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td")));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			
			String quota;
			if(QutaInfo.indexOf("<span>")!=-1){
				quota=QutaInfo.substring(QutaInfo.indexOf("<span>")+6,QutaInfo.indexOf("</span>",QutaInfo.indexOf("<span>")));
			}else{
				quota=QutaInfo.substring(QutaInfo.indexOf("\">")+2,QutaInfo.length());
			}
			c[i].setQuota(Integer.parseInt(quota));
						
			String EntollInfo=classInfo[i].substring(classInfo[i].indexOf("<td")+3,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td")));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			String enroll=EntollInfo.substring(EntollInfo.indexOf("\">")+2,EntollInfo.length());
			c[i].setEnrol(Integer.parseInt(enroll));
			
			String WaitInfo=classInfo[i].substring(classInfo[i].indexOf("<td")+3,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td")));
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			if(WaitInfo.indexOf("<strong>")==-1){
				c[i].setWait(0);
			}else{
				String wait=WaitInfo.substring(WaitInfo.indexOf("<strong>")+8,WaitInfo.indexOf("</strong>",WaitInfo.indexOf("<strong>")));
				c[i].setWait(Integer.parseInt(wait));
			}
				
				
				
			for(int ii=1;ii<timeNum;ii++){
				String Stime=classInfo[i].substring(classInfo[i].indexOf("<td>")+4,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td>")));
				classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
				String SRoom=classInfo[i].substring(classInfo[i].indexOf("<td>")+4,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td>")));
				classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
				c[i].setTime(c[i].getTime()+" AND "+Stime);
				c[i].setRoom(c[i].getRoom()+" AND "+SRoom);
				
				String SInstructorInfo=classInfo[i].substring(classInfo[i].indexOf("<td")+3,classInfo[i].indexOf("</td>",classInfo[i].indexOf("<td")));
				classInfo[i]=classInfo[i].substring(classInfo[i].indexOf("</td>")+5,classInfo[i].length());
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		return c;
		
	}
	private static int getClassNum(String s){		
		return (s.length()-s.replace("<tr class=\"newsect sect", "").length())/23;
	}
	private static String[] getClassString(String s){
		String st[]=new String[getClassNum(s)];
		if(st.length%2==1){
			
		}
		for(int i=0;i<st.length;i+=2){
			int x=s.indexOf("<tr class=\"newsect secteven\">");
			int y=s.indexOf("<tr class=\"newsect sectodd\">");
			if(y==-1){
				y=s.length();
				st[i]=s.substring(x, y);
				break;
			}else{
				st[i]=s.substring(x, y);
				s=s.substring(y,s.length());
				int yy=s.indexOf("<tr class=\"newsect secteven\">");
				int xx=s.indexOf("<tr class=\"newsect sectodd\">");
				if(yy==-1){
					yy=s.length();
					st[i+1]=s.substring(xx,yy);
					break;
				}else{
					st[i+1]=s.substring(xx,yy);
					s=s.substring(yy,s.length());
				}
			}
			
		}
		return st;
	}
}
