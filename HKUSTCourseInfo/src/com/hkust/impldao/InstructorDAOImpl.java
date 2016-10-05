package com.hkust.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hkust.dao.InstructorDAO;
import com.hkust.entity.Instructor;
import com.hkust.util.DBConnection;

public class InstructorDAOImpl implements InstructorDAO{

	@Override
	public void addInstructor(Instructor c) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="INSERT INTO T_instructor(Name) VALUES(?)";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(addCourseSQL);
			pstmt.setString(1,c.getName());
			rs=pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	

	@Override
	public void updateInstructor(Instructor c) {
	
	}

	@Override
	public void deletInstructor(String Name) {
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="DELETE from T_instructor where Name=?";
		PreparedStatement pstmt=null;
		
		try{
			pstmt=conn.prepareStatement(addCourseSQL);
			pstmt.setString(1,Name);
			pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
		
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public Instructor findInstructorByName(String Name) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_instructor where Name=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Instructor instructor=null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setString(1, Name);
			rs=pstmt.executeQuery();
			if(rs.next()){
				instructor=new Instructor();
				instructor.setName(rs.getString(1));
				
				
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
		return instructor;
	}

}
