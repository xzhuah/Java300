package com.hkust.dao;

import com.hkust.entity.Instructor;

public interface InstructorDAO {
	public void addInstructor(Instructor c);
	public void updateInstructor(Instructor c);
	public void deletInstructor(String Section);
	public Instructor findInstructorByName(String Name);
}
