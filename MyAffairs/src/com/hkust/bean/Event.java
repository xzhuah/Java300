package com.hkust.bean;

import  java.sql.Timestamp;

public class Event {

	/**
	 * @param args
	 */
	private int EventId;
	private String EventTitle;
	private String StartTime;
	private String EndTime;
	private String Location;
	private String Info;
	public Event(){
		
	}
	public int getEventId() {
		return EventId;
	}
	public void setEventId(int eventId) {
		EventId = eventId;
	}
	public String getEventTitle() {
		return EventTitle;
	}
	public void setEventTitle(String eventTitle) {
		EventTitle = eventTitle;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	
}
