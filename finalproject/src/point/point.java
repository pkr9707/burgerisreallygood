package point;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import card.card;
import mainframe.mainframe;
import yournumberis.yournumberis;

public class point extends JPanel{

	final private mainframe mf;
	private JTextField textField;
	public static int num;
	public static int points;	
	public static int ck;	
	private JTextField textField_1;
	
	public point(mainframe mf, card cd) {
	 super();
	 
	 this.mf = mf;
	 	int c =cd.c;
		setLayout(null);
		
		ck=0;
		
		textField = new JTextField();
		textField.setBounds(169, 197, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("번호를 입력해주세요");
		lblNewLabel.setBounds(169, 141, 130, 15);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 235, 116, 21);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JLabel label = new JLabel("전화번호");
		label.setBounds(75, 200, 57, 15);
		add(label);
		label.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(75, 238, 57, 15);
		add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JButton btn = new JButton("적립하기");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
			String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
	        String username="root";
			String password="9707";
	        Connection conn = DriverManager.getConnection(url,username,password); 
	       		
			
	        Statement stmt = conn.createStatement();
	        String query = "select * from realpoints;";
	        System.out.println(query);
	        ResultSet rs;
	        //update
			rs = stmt.executeQuery(query);
			 while (rs.next()) {
		        	 num = rs.getInt("number");
		        	 System.out.println(num);
		        	int number=Integer.parseInt(textField.getText());
		        	 System.out.println(number);
		        	 
		        	if(num==number) {
		        		points=rs.getInt("point");
		        		try {
							String query1 = " UPDATE realpoints SET point=?"+" WHERE number=?";
							PreparedStatement preparedStmt = conn.prepareStatement(query1);
							preparedStmt.setInt   (1, (points+(c/10)));
							preparedStmt.setString(2, textField.getText());
							preparedStmt.executeUpdate();
						} catch (Exception e) {
							// TODO: handle exception
							 System.out.println(e.getMessage());
						}

		        		mf.showpanel(new pointisdone(mf));
		        	
		        	}
		        	
		        }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
				ck++;
			
			label.setVisible(true);
			lblNewLabel_1.setVisible(true);
			textField_1.setVisible(true);
			btn.setText("가입 및 적립하기");
			System.out.println(ck);
			if(ck>1) {
			try {
				String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
		        String username="root";
				String password="9707";
		        Connection conn = DriverManager.getConnection(url,username,password); 
		       		
		  
		       
		        String query = " insert into realpoints (name,point,number)"
		                + " values (?, ?, ?)";

		              // create the mysql insert preparedstatement
		              PreparedStatement preparedStmt = conn.prepareStatement(query);
		              preparedStmt.setString (1, textField_1.getText() );
		              preparedStmt.setInt (2,(c/10) );
		              preparedStmt.setString   (3, textField.getText());
		        
		              preparedStmt.execute();
		        conn.close();
		    	mf.showpanel(new pointisdone(mf));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
			}
		});
		JPanel panel = new JPanel();
		panel.setBounds(169, 717, 130, 50);
		
		add(panel, BorderLayout.SOUTH);
		panel.add(btn,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(500, 1000));
		this.add(panel,BorderLayout.SOUTH);
		panel.setBackground(Color.white);
		btn.setBackground(Color.RED);
		btn.setForeground(Color.white);
		btn.setBorderPainted(false);
		btn.setPreferredSize(new Dimension(120, 40));
		this.setBackground(Color.white);
		
		
		
		
	}
	
}
