package yournumberis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainframe.mainframe;
import point.point;
import startpage.startpage;

public class yournumberis extends JPanel {

final private mainframe mf;
public static int numberis=0;
public static int dontgonextpage=0;
public void inasecond(int a) {
	Timer timer= new Timer();
	int b=0;
	if(b<a) {
	timer.schedule(new TimerTask() {
		
		@Override
		public  void run() {
			// TODO Auto-generated method stub
			
	
	
	mf.showpanel(new startpage(mf));
	}
		 
	}, 5*1000);
	
	}	
}
public yournumberis(mainframe mf) {
 super();
 
 this.mf = mf;
	this.setPreferredSize(new Dimension(500, 1000));
	this.setBackground(Color.white);
	setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(0, 0, 500, 1000);
	add(panel);
	panel.setLayout(null);
	
	JLabel label = new JLabel("고객님의 번호는");
	label.setBounds(194, 300, 96, 15);
	panel.add(label);
	
	try {
		String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
        String username="root";
		String password="9707";
        Connection conn = DriverManager.getConnection(url,username,password); 
       		
		
        Statement stmt = conn.createStatement();
        String query = "select * from card1;";
        System.out.println(query);
        ResultSet rs;

		rs = stmt.executeQuery(query);
        while (rs.next()) {
        	int num = rs.getInt("id");
        	if(numberis<num)numberis=num;
        	System.out.println(numberis);
        	
        }
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
	
	JLabel lblNewLabel = new JLabel(numberis+"번");
	lblNewLabel.setBounds(227, 400, 57, 15);
	panel.add(lblNewLabel);
	
	
	JButton btnNewButton = new JButton("적립");
	btnNewButton.setBackground(Color.ORANGE);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
			mf.showpanel(new point(mf,null));
			System.out.println(dontgonextpage);
		}
	});
	btnNewButton.setBounds(294, 631, 97, 23);
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("처음으로");
	btnNewButton_1.setBackground(Color.ORANGE);
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dontgonextpage=1;
			mf.showpanel(new startpage(mf));
			System.out.println("startpage");
		}
	});
	btnNewButton_1.setBounds(120, 631, 97, 23);
	panel.add(btnNewButton_1);
	
	//System.out.println(dontgonextpage);
	if(dontgonextpage==0) {System.out.println(dontgonextpage); }
}

}
