package com.hkust.factory;

import com.hkust.impldao.TeachingRelationDAOImpl;

public class TeachingRelationDAOFactory {
	public static TeachingRelationDAOImpl getTeachingRelationDAOInstance(){
		return new TeachingRelationDAOImpl();
	}
}
