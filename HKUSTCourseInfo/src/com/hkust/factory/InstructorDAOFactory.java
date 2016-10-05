package com.hkust.factory;

import com.hkust.impldao.InstructorDAOImpl;

public class InstructorDAOFactory {
	public static InstructorDAOImpl getInstructorDAOImpl(){
		return new InstructorDAOImpl();
	}
}
