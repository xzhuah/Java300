package com.hkust.factory;

import com.hkust.impldao.CourseDAOImpl;

public class CourseDAOFactory {
	public static CourseDAOImpl getCourseDAOImpl(){
		return new CourseDAOImpl();
	}
}
