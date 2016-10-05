package com.hkust.entity;

public class Class {

	/**
	 * @param args
	 */
	private final int LECTURE=1,TUTORIAL=2,LAB=3;
	private String Section, Time, Room, Course_name;
	private int Type, Quota, Enrol, Wait,ClassId;
	
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public String getSection() {
		return Section;
	}
	public void setSection(String section) {
		Section = section;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getRoom() {
		return Room;
	}
	public void setRoom(String room) {
		Room = room;
	}
	public String getCourse_name() {
		return Course_name;
	}
	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getQuota() {
		return Quota;
	}
	public void setQuota(int quota) {
		Quota = quota;
	}
	public int getEnrol() {
		return Enrol;
	}
	public void setEnrol(int enrol) {
		Enrol = enrol;
	}
	public int getWait() {
		return Wait;
	}
	public void setWait(int wait) {
		Wait = wait;
	}
	
	
}
