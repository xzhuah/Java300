package com.hkust.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JSplitPane;
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

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NewNum;
	private JPanel WritePanel,ShowPanel,top,bottom;
	private JSplitPane splite;
	private JTextArea write,show;
	private JScrollPane Swrite,Sshow;
	private JLabel hintNum,hintbottom;
	private JButton renew,begin,clear;
	public static void main(String[] args) {
		new MainWindow();

	}
	MainWindow(){
		NewNum=new JTextField(5);
		WritePanel=new JPanel();
		ShowPanel=new JPanel();
		top=new JPanel();
		bottom=new JPanel();
		
		write=new JTextArea();
		show=new JTextArea();
		Swrite=new JScrollPane(write);
		Sshow=new JScrollPane(show);
		hintNum=new JLabel("更新码");
		hintbottom=new JLabel("欢迎使用");
		renew=new JButton("更新");
		begin=new JButton("执行");
		clear=new JButton("清除");
		clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				show.setText("");
				hintbottom.setText("");
			}
		});
		begin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					String order=write.getText();
					Connection conn=DBConnection.getConnection();
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try{
						pstmt=conn.prepareStatement(order);
						rs=pstmt.executeQuery();
						String result="";
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
						show.setText(result);
						hintbottom.setText("查询结束，共"+(k-1)+"条结果");
						
					}catch(Exception e){
						show.setText(e.toString().replace("com.microsoft.sqlserver.jdbc.SQLServerException: ", ""));
						hintbottom.setText("查询失败");
					}
				}catch(Exception e){
					
				}
			}
			
		});
		renew.addActionListener(new ActionListener(){

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
		
	
		write.setFont((new Font("宋体",Font.BOLD,16)));
		show.setFont((new Font("宋体",Font.BOLD,16)));
		hintbottom.setFont((new Font("宋体",Font.BOLD,16)));
		show.setEditable(false);
		
		WritePanel.setLayout(new BorderLayout());
		ShowPanel.setLayout(new BorderLayout());
		bottom.setLayout(new BorderLayout());
		WritePanel.setPreferredSize(new Dimension(900,400));
		
		WritePanel.add(Swrite);ShowPanel.add(Sshow);
		top.add(hintNum);top.add(NewNum);top.add(renew);top.add(begin);top.add(clear);
		bottom.add(hintbottom);
		
		splite=new JSplitPane(JSplitPane.VERTICAL_SPLIT, WritePanel,ShowPanel);
		splite.setOneTouchExpandable(true);
		
		this.add(top,BorderLayout.NORTH);
		this.add(splite);
		this.add(bottom,BorderLayout.SOUTH);
		
		this.setLocation(400,100);
		this.setSize(900,800);
		this.setVisible(true);
		this.setTitle("科大课程数据库");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void begin(){
		try{
			NewNum.setEditable(false);
			renew.setEnabled(false);
			hintbottom.setText("正在连接网上资源");
			OnlineInfoGetter onlineGetter=new OnlineInfoGetter(NewNum.getText(),hintbottom);
			hintbottom.setText("正在删除旧数据");
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
				hintbottom.setText("无法正常删除原有数据");
				DBConnection.close(pstmt);
				DBConnection.close(conn);	
			}
			try{	
				hintbottom.setText("正在录入新数据");
				String s[][]=onlineGetter.getAllInfo();
				for(int i=0;i<s.length;i++){
					for(int j=0;j<s[i].length;j++){
						Course course=null;
						course=CourseGetter.getCourse(s[i][j]);
						CourseDAOFactory.getCourseDAOImpl().addCourse(course);
						hintbottom.setText("正在录入"+course.getName());
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
							hintbottom.setText("正在录入"+c[k].getSection());
						}
						for(int k=0;k<instr.size();k++){
							InstructorDAOFactory.getInstructorDAOImpl().addInstructor(instr.get(k));
						}
						for(int k=0;k<teach.size();k++){
							TeachingRelationDAOFactory.getTeachingRelationDAOInstance().addTeachingRelation(teach.get(k));
						}
					}
				}
				NewNum.setEditable(true);
				renew.setEnabled(true);
				hintbottom.setText("更新成功");
				}catch(Exception e){
					
				}
		}catch(Exception e){e.printStackTrace();}//hintbottom.setText("请确认更新码");}
	}

}
