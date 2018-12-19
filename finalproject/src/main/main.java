package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mainframe.mainframe;

public class main {
	public static Connection makeConnection(){
		String url="jdbc:mysql://localhost:3306/tutorial?serverTimezone=UTC";
		String username="root";
		String password="9707";
		Connection conn = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			System.out.println("드라이버 적재 성공");
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 적재 성공");
			//System.out.println("connected");
			
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버를 찾을수 ㄴㄴ");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("연결실패");
		}
		
		return conn;
	
}

	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//메인 프레임은 그대로
		//패널만 바꿔서 패널은 class로 빼서 만들고 싶다
		new mainframe("bergerking").setVisible(true);
		Connection con =  makeConnection();
	}
	
}
