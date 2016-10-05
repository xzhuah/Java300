package com.hkust.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hkust.bean.Event;
import com.hkust.factory.EventDAOFactory;

public class UI extends JFrame{
	private JPanel panel=new JPanel();
	private JButton see=new JButton("未来事件"),add=new JButton("添加/修改事件"),remove=new JButton("删除事件"),look=new JButton("查看所有事件");
	private JTextArea text=new JTextArea();
	private JScrollPane scroll=new JScrollPane(text);
	private JTextField id=new JTextField(5);
	public static void main(String args[]){
		new UI();
	}
	public UI(){
		text.setFont((new Font("宋体",Font.BOLD,16)));
		this.add(panel,BorderLayout.SOUTH);
		this.add(scroll);
		panel.add(see);panel.add(add);panel.add(id);panel.add(remove);panel.add(look);
		see.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				Event[] evs=null;
				Calendar cal = Calendar.getInstance();
				String time="";
				String month=(1+cal.get(Calendar.MONTH))+"";
				String day=cal.get(Calendar.DATE)+"";
				String hour=cal.get(Calendar.HOUR_OF_DAY)+"";
				String minute=cal.get(Calendar.MINUTE)+"";
				if(month.length()==1) month="0"+month;
				if(day.length()==1) day="0"+day;
				if(hour.length()==1) hour="0"+hour;
				if(minute.length()==1) minute="0"+minute;
				time+=(cal.get(Calendar.YEAR)+"/"+month+"/"+day+" "+hour+":"+minute+":00");
				System.out.println(time);
				evs=EventDAOFactory.getEventDAOImpl().findEventByTime(time);
				String result="";		
				System.out.println(time);
				for(int i=0;i<evs.length;i++){
					result+="ID: ";
					result+=evs[i].getEventId();
					result+="\t";
					result+="事件: ";
					result+=evs[i].getEventTitle();
					result+="\t\t\t";
					result+="地点: ";
					result+=evs[i].getLocation();
					result+="\t\t";
					result+="时间: ";
					result+=evs[i].getStartTime();
					result+=" -- ";
					result+=evs[i].getEndTime().substring(11,19);		
					result+="\t\t";
					result+="信息: ";
					result+=evs[i].getInfo();
					result+="\n\n";	
				}
				//System.out.println(result);2015/08/15 10:30:00
				text.setText(result);
				text.setEditable(false);
			}
			
		});
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				try{
					int i=Integer.parseInt(id.getText());
					new Add(i);
				}catch(Exception e){
					new Add();
				}
				
				
			}
			
		});
		remove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				EventDAOFactory.getEventDAOImpl().removeEvent(Integer.parseInt(id.getText()));
			}
			
		});
		look.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				Event evs[]=EventDAOFactory.getEventDAOImpl().findEventByTime("2015/08/18 00:00:00");
				String result="";		
				for(int i=0;i<evs.length;i++){
					result+="ID: ";
					result+=evs[i].getEventId();
					result+="\t";
					result+="事件: ";
					result+=evs[i].getEventTitle();
					result+="\t\t\t";
					result+="地点: ";
					result+=evs[i].getLocation();
					result+="\t\t";
					result+="时间: ";
					result+=evs[i].getStartTime();
					result+=" -- ";
					result+=evs[i].getEndTime().substring(11,19);		
					result+="\t\t";
					result+="信息: ";
					result+=evs[i].getInfo();
					result+="\n\n";	
				}
				//System.out.println(result);
				text.setText(result);
			}
			
		});
		//this.add(panel,Bor)
		this.setTitle("事件管理器");
		this.setSize(1500,600);
		this.setLocation(200,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
