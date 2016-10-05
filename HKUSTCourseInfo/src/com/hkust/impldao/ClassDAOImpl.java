package com.hkust.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hkust.dao.ClassDAO;
import com.hkust.entity.Class;
import com.hkust.util.DBConnection;

public class ClassDAOImpl implements ClassDAO{

	@Override
	public void addClass(Class c) {
		Connection conn=DBConnection.getConnection();
		String addClassSQL="INSERT INTO T_class VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(addClassSQL);
			pstmt.setString(1,c.getSection());
			pstmt.setString(2,c.getTime());
			pstmt.setInt(3,c.getType());
			pstmt.setString(4,c.getRoom());
			pstmt.setInt(5,c.getQuota());
			pstmt.setInt(6,c.getEnrol());
			pstmt.setInt(7,c.getWait());
			pstmt.setString(8,c.getCourse_name());
			pstmt.setInt(9,c.getClassId());
			rs=pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}
		
	

	@Override
	public void updateClass(Class c) {
		Connection conn=DBConnection.getConnection();
		String updateClassSQL="UPDATE T_class SET Time=?,Type=?,Room=?,Quota=?,Enrol=?,Wait=?,Course_name=?,ClassId=? where Section=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(updateClassSQL);
			
			pstmt.setString(1,c.getTime());
			pstmt.setInt(2,c.getType());
			pstmt.setString(3,c.getRoom());
			pstmt.setInt(4,c.getQuota());
			pstmt.setInt(5,c.getEnrol());
			pstmt.setInt(6,c.getWait());
			pstmt.setString(7,c.getCourse_name());
			pstmt.setInt(8,c.getClassId());
			pstmt.setString(9,c.getSection());		
			pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void deletClass(String Section) {
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="DELETE from T_class where Section=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(addCourseSQL);
			pstmt.setString(1,Section);
			pstmt.executeQuery();
				
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public Class findClassBySection(String Section) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="select * from T_class where Section=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Class c=null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setString(1, Section);
			rs=pstmt.executeQuery();
			if(rs.next()){
				c=new Class();
				c.setSection(rs.getString(1));
				c.setTime(rs.getString(2));
				c.setType(rs.getInt(3));
				c.setRoom(rs.getString(4));
				c.setQuota(rs.getInt(5));
				c.setEnrol(rs.getInt(6));
				c.setWait(rs.getInt(7));
				c.setCourse_name(rs.getString(8));
				c.setClassId(rs.getInt(9));
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
		return c;
	}

	@Override
	public Class findClassByClassId(int Id) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_class where ClassId=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Class c=null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setInt(1, Id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				c=new Class();
				c.setSection(rs.getString(1));
				c.setTime(rs.getString(2));
				c.setType(rs.getInt(3));
				c.setRoom(rs.getString(4));
				c.setQuota(rs.getInt(5));
				c.setEnrol(rs.getInt(6));
				c.setWait(rs.getInt(7));
				c.setCourse_name(rs.getString(8));
				c.setClassId(rs.getInt(9));
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
		return c;
	}

}
