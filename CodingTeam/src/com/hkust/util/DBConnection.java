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
	public static void close(Connection conn) {//�ر����Ӷ���
		if(conn != null) {				//���conn���Ӷ���Ϊ��
			try {
				conn.close();			//�ر�conn���Ӷ������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement pstmt) {//�ر�Ԥ�������
		if(pstmt != null) {				//���pstmtԤ�������Ϊ��
			try {
				pstmt.close();			//�ر�pstmtԤ�������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {//�رս��������
		if(rs != null) {				//���rs���������Ϊnull
			try {
				rs.close();				//�ر�rs���������
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
