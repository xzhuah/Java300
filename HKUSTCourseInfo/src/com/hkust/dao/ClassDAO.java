package com.hkust.dao;
import com.hkust.entity.Class;
public interface ClassDAO {
	public void addClass(Class c);
	public void updateClass(Class c);
	public void deletClass(String Section);
	public Class findClassBySection(String Section);
	public Class findClassByClassId(int Id);
}
