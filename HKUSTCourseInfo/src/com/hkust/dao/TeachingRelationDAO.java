package com.hkust.dao;

import com.hkust.entity.TeachingRelation;

public interface TeachingRelationDAO {
	public void addTeachingRelation(TeachingRelation c);
	public void updateTeachingRelation(TeachingRelation c);
	public TeachingRelation[] findTeachingRelationByProfessor_ID(int Professor_ID);
	public TeachingRelation[] findTeachingRelationBySection(String Section);
	public void deletTeachingRelation(int id);
}
