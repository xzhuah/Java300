package com.hkust.dao;

import java.sql.Timestamp;

import com.hkust.bean.Event;

public interface EventDAO {
	public void addEvent(Event e);
	public void removeEvent(int id);
	public void updateEvent(Event e);
	public Event[] findEventByTime(String endTime);
	public Event findEventByTitle(String title);
	public Event findEventById(int id);
	public Event[] findEventByKeyWord(String keyWord);
	
}
