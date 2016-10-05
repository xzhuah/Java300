package com.hkust.main;
import java.util.Vector;

import javax.swing.JLabel;

import com.hkust.entity.*;
import com.hkust.entity.Class;
import com.hkust.factory.*;
import com.hkust.util.ClassGetter;
import com.hkust.util.CourseGetter;
import com.hkust.util.OnlineInfoGetter;
public class GetDataReady {
	public static void main(String args[]){
		try{
		OnlineInfoGetter onlineGetter=new OnlineInfoGetter("1510",new JLabel());
		String s[][]=onlineGetter.getAllInfo();
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[i].length;j++){
				Course course=null;
				course=CourseGetter.getCourse(s[i][j]);
				CourseDAOFactory.getCourseDAOImpl().addCourse(course);
			}
		}
		String ss[][]=onlineGetter.getAllInfo();
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[i].length;j++){
				Vector<Instructor> instr = new Vector<Instructor>();
				Vector<TeachingRelation> teach = new Vector<TeachingRelation>();
				Class c[];
				c=ClassGetter.getClass(ss[i][j], instr, teach);
				for(int k=0;k<c.length;k++){
					ClassDAOFactory.getClassDAOImpl().addClass(c[k]);
				}
				for(int k=0;k<instr.size();k++){
					InstructorDAOFactory.getInstructorDAOImpl().addInstructor(instr.get(k));
				}
				for(int k=0;k<teach.size();k++){
					TeachingRelationDAOFactory.getTeachingRelationDAOInstance().addTeachingRelation(teach.get(k));
				}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("OK");
	}
}
