package com.hkust.util;
import com.hkust.entity.Course;
public class CourseGetter {
	public static Course getCourse(String segment){
		Course c=new Course();
		c.setNeedMatch(segment.contains("class=\"matching\""));
		try{
		String information=segment.substring(segment.indexOf("<table width=\"400\">"),segment.indexOf("</table>"));		
		c.setIsCCC(information.contains("ATTRIBUTES"));
		c.setPre_request("");
		c.setCo_request("");
		c.setExclusion("");
		c.setInfo("");
		if(information.contains("PRE-REQUISITE</th><td>")){
			information=information.substring(information.indexOf("PRE-REQUISITE</th><td>")+22,information.length());
			c.setPre_request(information.substring(0,information.indexOf("</td></tr>")).replaceAll("\n", " "));
			information=information.substring(information.indexOf("</td></tr>")+10,information.length());
		}
		if(information.contains("CO-REQUISITE</th><td>")){
			information=information.substring(information.indexOf("CO-REQUISITE</th><td>")+21,information.length());
			c.setCo_request(information.substring(0,information.indexOf("</td></tr>")).replaceAll("\n", " "));
			information=information.substring(information.indexOf("</td></tr>")+10,information.length());
		}
		if(information.contains("EXCLUSION</th><td>")){
			information=information.substring(information.indexOf("EXCLUSION</th><td>")+18,information.length());
			c.setExclusion(information.substring(0,information.indexOf("</td></tr>")).replaceAll("\n", " "));
			information=information.substring(information.indexOf("</td></tr>")+10,information.length());
		}
		if(information.contains("DESCRIPTION</th><td>")){
			information=information.substring(information.indexOf("DESCRIPTION</th><td>")+20,information.length());
			c.setInfo(information.substring(0,information.indexOf("</td></tr>")).replaceAll("\n", " "));
			information=information.substring(information.indexOf("</td></tr>")+10,information.length());
		}
		
		
		segment=segment.substring(segment.indexOf("<h2>")+4,segment.indexOf("</h2>"));
		c.setName(segment.substring(0,segment.indexOf("-")-1).replaceAll("\n", " "));
		c.setTitle(segment.substring(segment.indexOf("- ")+2,segment.lastIndexOf(" (")).replaceAll("\n", " "));
		c.setCredit(Integer.parseInt(segment.substring(segment.lastIndexOf("(")+1,segment.indexOf(" unit"))));
		}catch(Exception e){return c;}
		return c;
	}
	
}
