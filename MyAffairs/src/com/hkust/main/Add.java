package com.hkust.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hkust.bean.Event;
import com.hkust.factory.EventDAOFactory;

public class Add extends JFrame{
	private JButton ok=new JButton("OK");
	private JTextField title=new JTextField(20),location=new JTextField(20),year=new JTextField(5),month=new JTextField(3),day=new JTextField(3),hour=new JTextField(3),minute=new JTextField(3),hour2=new JTextField(3),minute2=new JTextField(3);
	private JLabel titlel=new JLabel("Event Title",JLabel.CENTER),locationl=new JLabel("Location",JLabel.CENTER),yearl=new JLabel("Year",JLabel.CENTER),monthl=new JLabel("Month",JLabel.CENTER),dayl=new JLabel("Date",JLabel.CENTER),hourl=new JLabel("Start Hour",JLabel.CENTER),minutel=new JLabel("Start Minute",JLabel.CENTER),hour2l=new JLabel("End Hour",JLabel.CENTER),minute2l=new JLabel("End Minute",JLabel.CENTER),infol=new JLabel("Info",JLabel.CENTER);
	private JTextArea info=new JTextArea();
	private JScrollPane scroll=new JScrollPane(info);
	private JPanel p1=new JPanel(),p2=new JPanel(),p3=new JPanel(),p4=new JPanel(),p5=new JPanel(),p6=new JPanel();
	public Add(){
		ok.setFont((new Font("宋体",Font.BOLD,16)));
		title.setFont((new Font("宋体",Font.BOLD,16)));
		location.setFont((new Font("宋体",Font.BOLD,16)));
		titlel.setFont((new Font("宋体",Font.BOLD,16)));
		title.setFont((new Font("宋体",Font.BOLD,16)));
		hourl.setFont((new Font("宋体",Font.BOLD,16)));
		hour.setFont((new Font("宋体",Font.BOLD,16)));
		info.setFont((new Font("宋体",Font.BOLD,16)));
		infol.setFont((new Font("宋体",Font.BOLD,16)));
		minute.setFont((new Font("宋体",Font.BOLD,16)));
		minute2l.setFont((new Font("宋体",Font.BOLD,16)));
		minutel.setFont((new Font("宋体",Font.BOLD,16)));
		minute2.setFont((new Font("宋体",Font.BOLD,16)));
		hour2l.setFont((new Font("宋体",Font.BOLD,16)));
		hour2.setFont((new Font("宋体",Font.BOLD,16)));
		day.setFont((new Font("宋体",Font.BOLD,16)));
		year.setFont((new Font("宋体",Font.BOLD,16)));
		month.setFont((new Font("宋体",Font.BOLD,16)));
		locationl.setFont((new Font("宋体",Font.BOLD,16)));
		dayl.setFont((new Font("宋体",Font.BOLD,16)));
		yearl.setFont((new Font("宋体",Font.BOLD,16)));
		monthl.setFont((new Font("宋体",Font.BOLD,16)));
		Calendar cal = Calendar.getInstance();
		year.setText(cal.get(Calendar.YEAR)+"");
		month.setText((1+cal.get(Calendar.MONTH))+"");
		//day.setText((cal.get(Calendar.DATE)+1)+"");
		this.setLayout(new GridLayout(6,1));
		p1.add(titlel);p1.add(title);p1.add(locationl);p1.add(location);
		p2.add(yearl);p2.add(year);p2.add(monthl);p2.add(month);p2.add(dayl);p2.add(day);
		p3.add(hourl);p3.add(hour);p3.add(minutel);p3.add(minute);
		p4.add(hour2l);p4.add(hour2);p4.add(minute2l);p4.add(minute2);
		p5.setLayout(new BorderLayout());
		p5.add(infol,BorderLayout.NORTH);p5.add(scroll);
		p6.add(ok);
		this.add(p1);this.add(p2);this.add(p3);this.add(p4);this.add(p5);this.add(p6);
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				Event e=new Event();
				if(location.getText().length()==0){
					location.setText("TBA");
				}
				if(month.getText().length()==0){
					Add.this.setTitle("月份不能为空");
					return;
				}
				if(day.getText().length()==0){
					Add.this.setTitle("日期不能为空");
					return;
				}
				if(hour.getText().length()==0){
					hour.setText("00");
				}
				if(hour2.getText().length()==0) {
					hour2.setText("00");
				}
				if(minute.getText().length()==0) minute.setText("00");
				if(minute2.getText().length()==0) minute2.setText("00");
				
				if(month.getText().length()==1) month.setText("0"+month.getText());
				if(day.getText().length()==1) day.setText("0"+day.getText());
				if(hour.getText().length()==1) hour.setText("0"+hour.getText());
				if(hour2.getText().length()==1) hour2.setText("0"+hour2.getText());
				if(minute.getText().length()==1) minute.setText("0"+minute.getText());
				if(minute2.getText().length()==1) minute2.setText("0"+minute2.getText());
				String time=year.getText()+"/"+month.getText()+"/"+day.getText()+" "+hour.getText()+":"+minute.getText()+":00";
				String time2=year.getText()+"/"+month.getText()+"/"+day.getText()+" "+hour2.getText()+":"+minute2.getText()+":00";
				
				try{
					e.setStartTime(time);
					e.setEndTime(time2);
					e.setEventTitle(title.getText());
					e.setInfo(info.getText());
					e.setLocation(location.getText());
				}catch(Exception ex){
					Add.this.setTitle("填写有误");
				}
				EventDAOFactory.getEventDAOImpl().addEvent(e);
				Add.this.dispose();
			}
			
		});
		this.setTitle("24小时制日程表");
		this.setSize(600,600);
		this.setLocation(500,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public Add(int id){
		ok.setFont((new Font("宋体",Font.BOLD,16)));
		title.setFont((new Font("宋体",Font.BOLD,16)));
		location.setFont((new Font("宋体",Font.BOLD,16)));
		titlel.setFont((new Font("宋体",Font.BOLD,16)));
		title.setFont((new Font("宋体",Font.BOLD,16)));
		hourl.setFont((new Font("宋体",Font.BOLD,16)));
		hour.setFont((new Font("宋体",Font.BOLD,16)));
		info.setFont((new Font("宋体",Font.BOLD,16)));
		infol.setFont((new Font("宋体",Font.BOLD,16)));
		minute.setFont((new Font("宋体",Font.BOLD,16)));
		minute2l.setFont((new Font("宋体",Font.BOLD,16)));
		minutel.setFont((new Font("宋体",Font.BOLD,16)));
		minute2.setFont((new Font("宋体",Font.BOLD,16)));
		hour2l.setFont((new Font("宋体",Font.BOLD,16)));
		hour2.setFont((new Font("宋体",Font.BOLD,16)));
		day.setFont((new Font("宋体",Font.BOLD,16)));
		year.setFont((new Font("宋体",Font.BOLD,16)));
		month.setFont((new Font("宋体",Font.BOLD,16)));
		locationl.setFont((new Font("宋体",Font.BOLD,16)));
		dayl.setFont((new Font("宋体",Font.BOLD,16)));
		yearl.setFont((new Font("宋体",Font.BOLD,16)));
		monthl.setFont((new Font("宋体",Font.BOLD,16)));
		Event e=new Event();
		//2014/04/14 12:20:00		
	
		this.setLayout(new GridLayout(6,1));
		p1.add(titlel);p1.add(title);p1.add(locationl);p1.add(location);
		p2.add(yearl);p2.add(year);p2.add(monthl);p2.add(month);p2.add(dayl);p2.add(day);
		p3.add(hourl);p3.add(hour);p3.add(minutel);p3.add(minute);
		p4.add(hour2l);p4.add(hour2);p4.add(minute2l);p4.add(minute2);
		p5.setLayout(new BorderLayout());
		p5.add(infol,BorderLayout.NORTH);p5.add(scroll);
		p6.add(ok);
		this.add(p1);this.add(p2);this.add(p3);this.add(p4);this.add(p5);this.add(p6);
		try{
			e=EventDAOFactory.getEventDAOImpl().findEventById(id);
			year.setText(e.getEndTime().substring(0,4));
			month.setText(e.getEndTime().substring(5,7));
			day.setText(e.getEndTime().substring(8,10));
			hour.setText(e.getStartTime().substring(11,13));
			minute.setText(e.getStartTime().substring(14,16));
			hour2.setText(e.getEndTime().substring(11,13));
			minute2.setText(e.getEndTime().substring(14,16));
			info.setText(e.getInfo());
			location.setText(e.getLocation());
			title.setText(e.getEventTitle());
		}catch(Exception ex){ex.printStackTrace();}
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				Event e=new Event();
				if(location.getText().length()==0){
					location.setText("TBA");
				}
				if(month.getText().length()==0){
					Add.this.setTitle("月份不能为空");
					return;
				}
				if(day.getText().length()==0){
					Add.this.setTitle("日期不能为空");
					return;
				}
				if(hour.getText().length()==0){
					hour.setText("00");
				}
				if(hour2.getText().length()==0) {
					hour2.setText("00");
				}
				if(minute.getText().length()==0) minute.setText("00");
				if(minute2.getText().length()==0) minute2.setText("00");			
				if(month.getText().length()==1) month.setText("0"+month.getText());
				if(day.getText().length()==1) day.setText("0"+day.getText());
				if(hour.getText().length()==1) hour.setText("0"+hour.getText());
				if(hour2.getText().length()==1) hour2.setText("0"+hour2.getText());
				if(minute.getText().length()==1) minute.setText("0"+minute.getText());
				if(minute2.getText().length()==1) minute2.setText("0"+minute2.getText());
				String time=year.getText()+"/"+month.getText()+"/"+day.getText()+" "+hour.getText()+":"+minute.getText()+":00";
				String time2=year.getText()+"/"+month.getText()+"/"+day.getText()+" "+hour2.getText()+":"+minute2.getText()+":00";
				
				try{
					e.setStartTime(time);
					e.setEndTime(time2);
					e.setEventTitle(title.getText());
					e.setInfo(info.getText());
					e.setLocation(location.getText());
				}catch(Exception ex){
					Add.this.setTitle("填写有误");
				}
				EventDAOFactory.getEventDAOImpl().addEvent(e);
				Add.this.dispose();
			}
			
		});
		this.setTitle("24小时制日程表");
		this.setSize(600,600);
		this.setLocation(500,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String args[]){
		new Add();
	}
}
