package com.hkust.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hkust.dao.TeachingRelationDAO;
import com.hkust.entity.TeachingRelation;
import com.hkust.util.DBConnection;

public class TeachingRelationDAOImpl implements TeachingRelationDAO{

	@Override
	public void addTeachingRelation(TeachingRelation c) {
		// TODO Auto-generated method stub
				Connection conn=DBConnection.getConnection();
				String addCourseSQL="INSERT INTO T_teachingRelation(Name,Section) VALUES(?,?)";
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try{
					pstmt=conn.prepareStatement(addCourseSQL);
					pstmt.setString(1,c.getName());
					pstmt.setString(2, c.getSection());
					rs=pstmt.executeQuery();
				}catch (Exception e){e.printStackTrace();}
				finally{
					DBConnection.close(rs);
					DBConnection.close(pstmt);
					DBConnection.close(conn);
				}
				
		
	}

	@Override
	public void updateTeachingRelation(TeachingRelation c) {
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="UPDATE T_teachingRelation SET Name=?, Section=? where RelationID=?";
		PreparedStatement pstmt=null;
		
		try{
			pstmt=conn.prepareStatement(addCourseSQL);
			pstmt.setString(1,c.getName());
			pstmt.setString(2, c.getSection());
			pstmt.setInt(3, c.getRelationID());
			pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
	}

	@Override
	public void deletTeachingRelation(int id) {
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="DELETE from T_teachingRelation where RelationID=?";
		PreparedStatement pstmt=null;
		
		try{
			pstmt=conn.prepareStatement(addCourseSQL);
			pstmt.setInt(1,id);	
			pstmt.executeQuery();
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		
		
	}

	@Override
	public TeachingRelation[] findTeachingRelationByProfessor_ID(
			int Professor_ID) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_teachingRelation where Professor_ID=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		TeachingRelation[] result = null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setInt(1, Professor_ID);
			rs=pstmt.executeQuery();
			result=new TeachingRelation[rs.getRow()];
			int i=0;
			if(rs.next()){
				TeachingRelation t=new TeachingRelation();
				t.setRelationID(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setSection(rs.getString(3));
				result[i++]=t;			
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return result;
	}

	@Override
	public TeachingRelation[] findTeachingRelationBySection(String Section) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_teachingRelation where Section=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		TeachingRelation[] result = null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setString(1, Section);
			rs=pstmt.executeQuery();
			result=new TeachingRelation[rs.getRow()];
			int i=0;
			while(rs.next()){
				TeachingRelation t=new TeachingRelation();
				t.setRelationID(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setSection(rs.getString(3));
				result[i++]=t;			
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return result;
	}

}
