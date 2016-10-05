package com.hkust.dao;

import com.hkust.entity.Course;

public interface CourseDAO {
	public void addCourse(Course c);
	public void updateCourse(Course c);
	public void deletCourse(String Section);
	public Course findCourseByName(String Name);
}
