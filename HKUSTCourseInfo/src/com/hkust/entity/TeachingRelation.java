package com.hkust.entity;

public class TeachingRelation {

	/**
	 * @param args
	 */
	
	private int RelationID;
	private String Section ,Name;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRelationID() {
		return RelationID;
	}
	public void setRelationID(int relationID) {
		RelationID = relationID;
	}
	public String getSection() {
		return Section;
	}
	public void setSection(String section) {
		Section = section;
	}

}
