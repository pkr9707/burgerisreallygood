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
			System.out.println("����̹� ���� ����");
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("�����ͺ��̽� ���� ����");
			//System.out.println("connected");
			
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("����̹��� ã���� ����");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("�������");
		}
		
		return conn;
	
}

	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//���� �������� �״��
		//�гθ� �ٲ㼭 �г��� class�� ���� ����� �ʹ�
		new mainframe("bergerking").setVisible(true);
		Connection con =  makeConnection();
	}
	
}
