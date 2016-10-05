package com.hkust.main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hkust.entity.Class;
import com.hkust.entity.Course;
import com.hkust.entity.Instructor;
import com.hkust.entity.TeachingRelation;
import com.hkust.factory.ClassDAOFactory;
import com.hkust.factory.CourseDAOFactory;
import com.hkust.factory.InstructorDAOFactory;
import com.hkust.factory.TeachingRelationDAOFactory;
import com.hkust.util.ClassGetter;
import com.hkust.util.CourseGetter;
import com.hkust.util.DBConnection;
import com.hkust.util.OnlineInfoGetter;

public class Controller extends JFrame{
	JTextField num;
	JLabel hint;
	JButton b;
	JButton find;
	JTextArea sql;
	JPanel panel,top;
	public static void main(String args[]){
		new Controller();
	}
	public Controller(){
		num=new JTextField(5);
		hint=new JLabel("更新码：");
		b=new JButton("更新");
		find=new JButton("查询");
		sql=new JTextArea(5,80);
		panel=new JPanel();
		top=new JPanel();
		hint.setFont((new Font("宋体",Font.BOLD,16)));
		b.setFont((new Font("宋体",Font.BOLD,16)));
		find.setFont((new Font("宋体",Font.BOLD,16)));
		sql.setFont((new Font("宋体",Font.BOLD,16)));
		this.setLayout(new GridLayout(2,1));
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				Thread t1 = new Thread(){
					@Override
					public void run() {
					 begin();
					}
					};
					t1.start();
				
			}
			
		});
		find.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					String order=sql.getText();
					Connection conn=DBConnection.getConnection();
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try{
						pstmt=conn.prepareStatement(order);
						rs=pstmt.executeQuery();
						String result="";
						JFrame j=new JFrame();
						JTextArea t=new JTextArea();
						t.setFont((new Font("宋体",Font.BOLD,16)));
						JScrollPane sc=new JScrollPane(t);
						ResultSetMetaData rsmd = rs.getMetaData() ; 
						int columnCount = rsmd.getColumnCount();
						int k=1;
						if(rs.next()){
							do{
							try{
								result+=(""+k+++"\t");
								for(int i=1;i<=columnCount;i++){
									result+=("("+rsmd.getColumnName(i)+")"+rs.getString(i)+"\t");
								}
								result+="\n";
							}catch(Exception e){}
							}while(rs.next());
						}
						DBConnection.close(pstmt);
						DBConnection.close(conn);
						DBConnection.close(rs);
						t.setText(result);
						j.add(sc);
						j.setTitle("查询结果  共"+(k-1)+"条数据");
						j.setSize(900,600);
						j.setLocation(200,200);
						j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						j.setVisible(true);
					}catch(Exception e){
						
					}
				}catch(Exception e){
					
				}
			}
			
		});
		panel.add(sql);panel.add(find);
		top.add(hint);
		
		top.add(num);
		top.add(b);
		this.add(top);
		this.add(panel);
		this.setLocation(500,200);
		this.setSize(800,400);
		this.setVisible(true);
		this.setTitle("科大系统数据库更新程序");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	private void begin(){
		try{
			num.setEditable(false);
			b.setEnabled(false);
			Controller.this.setTitle("正在更新");
			OnlineInfoGetter onlineGetter=new OnlineInfoGetter(num.getText(),new JLabel());
			Connection conn=DBConnection.getConnection();
			PreparedStatement pstmt=null;
			try{			
				String delet1="TRUNCATE TABLE T_teachingRelation";
				String delet2="DELETE FROM T_instructor";
				String delet3="DELETE FROM T_class";
				String delet4="DELETE FROM T_course";	
				try{
					pstmt=conn.prepareStatement(delet1);
					pstmt.executeQuery();
				}catch(Exception e){}
				try{
					pstmt=conn.prepareStatement(delet2);
					pstmt.executeQuery();
				}catch(Exception e){}
				try{
					pstmt=conn.prepareStatement(delet3);
					pstmt.executeQuery();
				}catch(Exception e){}
				try{
					pstmt=conn.prepareStatement(delet4);
					pstmt.executeQuery();
				}catch(Exception e){}
				DBConnection.close(pstmt);
				DBConnection.close(conn);	
			}catch(Exception e){
				Controller.this.setTitle("无法正常删除原有数据");
				DBConnection.close(pstmt);
				DBConnection.close(conn);	
			}
			try{					
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
				num.setEditable(true);
				b.setEnabled(true);
				Controller.this.setTitle("更新成功");
				}catch(Exception e){
					e.printStackTrace();
				}
		}catch(Exception e){Controller.this.setTitle("请确认更新码");}
	}
	//private void writeln(String t,String s){
		//t=t+s+"\n";
	//}
	//private void write(String t,String s){
	//	t=t+s;
	//}
	
}
