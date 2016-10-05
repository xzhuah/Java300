package com.hkust.factory;

import com.hkust.impldao.EventDAOImpl;

public class EventDAOFactory {
	public static EventDAOImpl getEventDAOImpl(){
		return new EventDAOImpl();
	}
}
