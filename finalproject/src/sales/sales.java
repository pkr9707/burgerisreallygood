package sales;



import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class sales {

	private JFrame frame;
	private JTextField text_Search;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTable table1;
	private JTable table2;
	Connection dbconnection = null;
	/**
	 * Launch the application.
	 */
	public static void sale() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales window = new sales();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 461);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		text_Search = new JTextField();
		text_Search.setBounds(130, 25, 116, 21);
		panel.add(text_Search);
		text_Search.setColumns(10);
		text_Search.setVisible(false);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 102, 410, 300);
		panel.add(panel_1);
		panel_1.setLayout(null);
	
		panel_2 = new JPanel();
		panel_2.setBounds(12, 102, 410, 300);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		Choice choice = new Choice();
		choice.add("name");
		choice.add("number");
		choice.setBounds(46, 25, 61, 21);
		panel.add(choice);
		choice.setVisible(false);
		
	JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=choice.getSelectedItem();
				System.out.println(a);
				if(btnNewButton.getText()=="검색")search(a);
				else d();
			}
		});
		btnNewButton.setBounds(270, 24, 97, 23);
		panel.add(btnNewButton);
		btnNewButton.setVisible(false);
		JButton btnNewButton_1 = new JButton("매출");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String colNames[] ={
						"번호", "메뉴", "시간", "개수", "가격","장소"
					};
				DefaultTableModel model = new DefaultTableModel(colNames,0);
				table1 = new JTable( model);
				model.fireTableDataChanged();
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				JScrollPane jcs= new JScrollPane(table1);
				jcs.setBounds(0, 0, 410, 300);
				panel_1.add(jcs);
				
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
	        	String name = rs.getString("name");
	        	Time date = rs.getTime("date_created"); 
	        	int number = rs.getInt("number");
	        	int price = rs.getInt("price");
	        	String where = rs.getString("place");
	     
	        	Object row[] = { num, name,date,  number, price,where};
	        	model.addRow(row);
	        	text_Search.setVisible(true);
				btnNewButton.setVisible(true);
				btnNewButton.setText("삭제");
				choice.setVisible(false);
	        }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			}
		});
		btnNewButton_1.setBounds(35, 69, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("회원");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				text_Search.setVisible(true);
				btnNewButton.setVisible(true);
				choice.setVisible(true);
				String colNames[] ={
						"이름","포인트","번호"
					};
				DefaultTableModel model = new DefaultTableModel(colNames,0);
				table1 = new JTable( model);
				
				JScrollPane jcs= new JScrollPane(table1);
				jcs.setBounds(0, 0, 410, 300);
				panel_2.add(jcs);
				try {
					String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
		            String username="root";
		    		String password="9707";
		            Connection conn = DriverManager.getConnection(url,username,password); 
			       		
					
		            Statement stmt = conn.createStatement();
			        String query = "select * from realpoints;";
			        System.out.println(query);
			        ResultSet rs;

					rs = stmt.executeQuery(query);
			        while (rs.next()) {
			        	String name = rs.getString("name"); 
			        	int point = rs.getInt("point");
			        	String number = rs.getString("number");
			     
			        	Object row[] = { name,point,  number};
			        	model.addRow(row);
			        	btnNewButton.setText("검색");
			        }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(172, 69, 97, 23);
		panel.add(btnNewButton_2);
	
		

	}
	private void search(String field) {
		System.out.println(field);
		String colNames[] ={
				"이름","포인트","번호"
			};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		table1 = new JTable( model);
		
		JScrollPane jcs= new JScrollPane(table1);
		jcs.setBounds(0, 0, 410, 300);
		panel_2.add(jcs);
		try {
			String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
            String username="root";
    		String password="9707";
            Connection conn = DriverManager.getConnection(url,username,password); 
	       		
			String what=text_Search.getText();
            Statement stmt = conn.createStatement();
	        String sql = "select * from realpoints where "+field+" like"+""
	        		+ " '%"+what+"%' ";
	        System.out.println(sql);
	        ResultSet rs;
	        
			rs = stmt.executeQuery(sql);
			
			while((rs!=null) && (rs.next())) {
	        	String name = rs.getString("name"); 
	        	int point = rs.getInt("point");
	        	String number = rs.getString("number");
	     
	        	Object row[] = { name,point,  number};
	        	model.addRow(row);
	        	
	        }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}

	private void d(String field) {
		System.out.println(field);
		String colNames[] ={
				"이름","포인트","번호"
			};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		table1 = new JTable( model);
		
		JScrollPane jcs= new JScrollPane(table1);
		jcs.setBounds(0, 0, 410, 300);
		panel_2.add(jcs);
		try {
			String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
            String username="root";
    		String password="9707";
            Connection conn = DriverManager.getConnection(url,username,password); 
	       		
			String what=text_Search.getText();
            Statement stmt = conn.createStatement();
	        String sql = "select * from realpoints where "+field+" like"+""
	        		+ " '%"+what+"%' ";
	        System.out.println(sql);
	        ResultSet rs;
	        
			rs = stmt.executeQuery(sql);
			
			while((rs!=null) && (rs.next())) {
	        	String name = rs.getString("name"); 
	        	int point = rs.getInt("point");
	        	String number = rs.getString("number");
	     
	        	Object row[] = { name,point,  number};
	        	model.addRow(row);
	        	
	        }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	private void d() {
		String colNames[] ={
				"번호", "메뉴", "시간", "개수", "가격","장소"
			};
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		table1 = new JTable( model);
		model.fireTableDataChanged();
		panel_1.setVisible(true);
		panel_2.setVisible(false);
		JScrollPane jcs= new JScrollPane(table1);
		jcs.setBounds(0, 0, 410, 300);
		panel_1.add(jcs);
		
		try {
	String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
    String username="root";
	String password="9707";
    Connection conn = DriverManager.getConnection(url,username,password); 
   	
    String what=text_Search.getText();
    
    PreparedStatement st = conn.prepareStatement("DELETE FROM card1 WHERE id = ?");
    st.setInt(1,Integer.parseInt(what));
    st.executeUpdate(); 
    
    Statement stmt = conn.createStatement();
    String query = "select * from card1;";
    System.out.println(query);
    ResultSet rs;
   

	rs = stmt.executeQuery(query);
    while (rs.next()) {
    	int num = rs.getInt("id");
    	String name = rs.getString("name");
    	Time date = rs.getTime("date_created"); 
    	int number = rs.getInt("number");
    	int price = rs.getInt("price");
    	String where = rs.getString("place");
 
    	Object row[] = { num, name,date,  number, price,where};
    	model.fireTableDataChanged();
    	model.addRow(row);
    	text_Search.setVisible(true);
    	
    	table1.setModel(model);;
    }
} catch (SQLException e1) {
	e1.printStackTrace();
}
		
		
	}

		
	}


