package com.hkust.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hkust.dao.CourseDAO;
import com.hkust.entity.Course;
import com.hkust.util.DBConnection;

public class CourseDAOImpl implements CourseDAO{

	@Override
	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="INSERT INTO T_course VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(addCourseSQL);
			pstmt.setString(1,c.getName());
			pstmt.setString(2, c.getTitle());
			pstmt.setInt(3, c.getCredit());
			pstmt.setString(4, c.getInfo());
			pstmt.setString(5, c.getPre_request());
			pstmt.setString(6, c.getCo_request());
			pstmt.setBoolean(7, c.isIsCCC());
			pstmt.setString(8,c.getExclusion());
			pstmt.setBoolean(9, c.isNeedMatch());
			rs=pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void updateCourse(Course c) {
		// TODO Auto-generated method stub
				Connection conn=DBConnection.getConnection();
				String updateCourseSQL="UPDATE T_course SET Title=?,Credit=?,Info=?,Pre_request=?,Co_request=?,IsCCC=?,Exclusion=?,NeedMatch=? where Name=?";
				PreparedStatement pstmt=null;
				try{
					pstmt=conn.prepareStatement(updateCourseSQL);			
					pstmt.setString(1, c.getTitle());
					pstmt.setInt(2, c.getCredit());
					pstmt.setString(3, c.getInfo());
					pstmt.setString(4, c.getPre_request());
					pstmt.setString(5, c.getCo_request());
					pstmt.setBoolean(6, c.isIsCCC());
					pstmt.setString(7,c.getExclusion());
					pstmt.setBoolean(8, c.isNeedMatch());
					pstmt.setString(9,c.getName());
					pstmt.executeQuery();
				}catch (Exception e){e.printStackTrace();}
				finally{
					
					DBConnection.close(pstmt);
					DBConnection.close(conn);
				}
		
	}

	@Override
	public void deletCourse(String Name) {
		Connection conn=DBConnection.getConnection();
		String deletCourseSQL="DELETE from T_course where Name=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(deletCourseSQL);			
			pstmt.setString(1, Name);	
			pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
		
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}	
	}

	@Override
	public Course findCourseByName(String Name) {
	
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_course where Name=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Course course=null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setString(1, Name);
			rs=pstmt.executeQuery();
			if(rs.next()){
				course=new Course();
				course.setName(rs.getString(1));
				course.setTitle(rs.getString(2));
				course.setCredit(rs.getInt(3));
				course.setInfo(rs.getString(4));
				course.setPre_request(rs.getString(5));
				course.setCo_request(rs.getString(6));
				course.setIsCCC(rs.getBoolean(7));
				course.setExclusion(rs.getString(8));
				course.setNeedMatch(rs.getBoolean(9));
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
		return course;
	}

}
