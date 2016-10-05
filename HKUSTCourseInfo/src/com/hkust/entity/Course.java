package com.hkust.entity;

public class Course {

	/**
	 * @param args
	 */
	
	private String Name,Title,Info,Pre_request,Co_request,Exclusion;
	public String getExclusion() {
		return Exclusion;
	}
	public void setExclusion(String exclusion) {
		Exclusion = exclusion;
	}
	private int Credit;
	private boolean IsCCC,NeedMatch;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	public String getPre_request() {
		return Pre_request;
	}
	public void setPre_request(String pre_request) {
		Pre_request = pre_request;
	}
	public String getCo_request() {
		return Co_request;
	}
	public void setCo_request(String co_request) {
		Co_request = co_request;
	}
	public int getCredit() {
		return Credit;
	}
	public void setCredit(int credit) {
		Credit = credit;
	}
	public boolean isIsCCC() {
		return IsCCC;
	}
	public void setIsCCC(boolean isCCC) {
		IsCCC = isCCC;
	}
	public boolean isNeedMatch() {
		return NeedMatch;
	}
	public void setNeedMatch(boolean needMatch) {
		NeedMatch = needMatch;
	}
	
}
