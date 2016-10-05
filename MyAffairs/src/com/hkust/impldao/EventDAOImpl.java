package com.hkust.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.hkust.bean.Event;
import com.hkust.dao.EventDAO;
import com.hkust.util.DBConnection;

public class EventDAOImpl implements EventDAO{

	@Override
	public void addEvent(Event e) {
		Connection conn=DBConnection.getConnection();
		String addEventSQL="INSERT INTO T_Event(EventTitle,StartTime,EndTime,Location,Info) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(addEventSQL);
			pstmt.setString(1,e.getEventTitle());
			pstmt.setString(2, e.getStartTime());
			pstmt.setString(3, e.getEndTime());
			pstmt.setString(4, e.getLocation());
			pstmt.setString(5, e.getInfo());
			rs=pstmt.executeQuery();
		}catch (Exception ee){System.out.println(ee.toString());updateEvent(e);}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void removeEvent(int id) {
		Connection conn=DBConnection.getConnection();
		String addCourseSQL="DELETE from T_Event where EventID=?";
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
	public void updateEvent(Event e) {
		Connection conn=DBConnection.getConnection();
		String updateEventSQL="UPDATE T_Event SET StartTime=?,EndTime=?,Location=?,Info=? where EventTitle=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(updateEventSQL);
			pstmt.setString(1, e.getStartTime());
			pstmt.setString(2, e.getEndTime());
			pstmt.setString(3, e.getLocation());
			pstmt.setString(4, e.getInfo());
			pstmt.setString(5, e.getEventTitle());
			pstmt.executeQuery();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public Event[] findEventByTime(String endTime) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Select * from T_Event where EndTime> '"+endTime+"' order by EndTime ASC";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Event[] result = null;
		System.out.println(findNameSQL);
		
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			//pstmt.setString(1,endTime);
			rs=pstmt.executeQuery();
			int rowCount = 0; 
			while(rs.next()) { 
			  rowCount++; 
			}
			System.out.println(rowCount);
			rs=pstmt.executeQuery();
			result=new Event[rowCount];
			int i=0;
			if(rs.next()){
				do{
					Event c=new Event();
					c.setEventId(rs.getInt(1));
					c.setEventTitle(rs.getString(2));
					c.setStartTime(rs.getString(3));
					c.setEndTime(rs.getString(4));
					c.setLocation(rs.getString(5));
					c.setInfo(rs.getString(6));
					result[i]=c;i++;
				}while(rs.next());
				
			}
		}catch (Exception e){e.printStackTrace();}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return result;
	}

	@Override
	public Event findEventByTitle(String title) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_Event where EventTitle=?";
		PreparedStatement pstmt=null;
		Event c = new Event();
		ResultSet rs=null;
		try{
			
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setString(1,title);
			rs=pstmt.executeQuery();
			if(rs.next()){
				c.setEventId(rs.getInt(1));
				c.setEventTitle(rs.getString(2));
				c.setStartTime(rs.getString(3));
				c.setEndTime(rs.getString(4));
				c.setLocation(rs.getString(5));
				c.setInfo(rs.getString(6));
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
	public Event[] findEventByKeyWord(String keyWord) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="Selcet * from T_Event where Title LIKE('%"+keyWord+"%')";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Event[] result = null;
		Event c=null;
		try{
			pstmt=conn.prepareStatement(findNameSQL);
			rs=pstmt.executeQuery();
			result=new Event[rs.getRow()];
			int i=0;
			while(rs.next()){
				c=new Event();
				c.setEventId(rs.getInt(1));
				c.setEventTitle(rs.getString(2));
				c.setStartTime(rs.getString(3));
				c.setEndTime(rs.getString(4));
				c.setLocation(rs.getString(5));
				c.setInfo(rs.getString(6));
				result[i++]=c;
			}
		}catch (Exception e){}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return result;
	}

	@SuppressWarnings({ "null", "resource" })
	@Override
	public Event findEventById(int id) {
		Connection conn=DBConnection.getConnection();
		String findNameSQL="select * from T_Event where EventId=?";
		PreparedStatement pstmt=null;
		Event c = new Event();
		ResultSet rs=null;
		try{			
			pstmt=conn.prepareStatement(findNameSQL);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				c.setEventId(rs.getInt(1));
				c.setEventTitle(rs.getString(2));
				c.setStartTime(rs.getString(3));
				c.setEndTime(rs.getString(4));
				c.setLocation(rs.getString(5));
				c.setInfo(rs.getString(6));
				//System.out.println("11111111111111111111111");
			}
		}catch (Exception e){System.out.println(e.toString());}
		finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return c;
	}

	

}
