package com.hkust.factory;

import com.hkust.impldao.ClassDAOImpl;

public class ClassDAOFactory {
	public static ClassDAOImpl getClassDAOImpl(){
		return new ClassDAOImpl();
	}
}
