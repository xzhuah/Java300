package com.hkust.util;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBConnection {
	
	
	/*

	private static final String DBDRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DataBaseName=HKUST";
	private static final String DBUSER="sa";
	private static final String PASSWORD="960911nbr";
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName(DBDRIVER);
			conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {//关闭连接对象
		if(conn != null) {				//如果conn连接对象不为空
			try {
				conn.close();			//关闭conn连接对象对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement pstmt) {//关闭预处理对象
		if(pstmt != null) {				//如果pstmt预处理对象不为空
			try {
				pstmt.close();			//关闭pstmt预处理对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {//关闭结果集对象
		if(rs != null) {				//如果rs结果集对象不为null
			try {
				rs.close();				//关闭rs结果集对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	public static void main(String args[]) throws MalformedURLException{
		URL url=new URL("http://aaa");
		URL url2=new URL("http://aa");
		for(int i=0;i<100;i++){
			System.out.println(url.hashCode());
			url=new URL(url.toString()+"a");
		}
		
	}
}
