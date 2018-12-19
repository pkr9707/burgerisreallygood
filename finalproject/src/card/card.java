package card;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainframe.mainframe;
import menupage.menupage;
import startpage.startpage;
import yournumberis.yournumberis;


	public class card extends JFrame {
	private int x = 0, y = 0;
	private  mainframe mf;
	public menupage mp;
	public static int c=0;
	public static int n=0;
	public static int count=0;
	public static String a="";
	// set up GUI and register mouse event handler

	public card(menupage mp, mainframe mf)
	{
	// create a label and place it in SOUTH of BorderLayout
		System.out.println(menupage.name[0]);
	JButton button = new JButton("싸인 후 눌러주세요");
//	String a =menupage.name[0][0];
	int b=menupage.num[0][0];
	for(int i=0; i<3; i++) {
		for(int j=0; j<10; j++) {
		
		if((menupage.name[i][j]!=null)&&(a!=null)) {a =menupage.name[i][j]; }	
		if(menupage.name[i][j]!=null) count++;
		n+=menupage.num[i][j];
		System.out.println(n);
		 c+=menupage.itemcost[i][j];
		
		}
	}
	System.out.println(b+"   "+menupage.num[0][1]+"  "+n+"  "+c);
	a+="외"+(count-1)+"개";
	String d=menupage.where;
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		
			
			 try { 
		            String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Seoul"; 
		            String username="root";
		    		String password="9707";
		            Connection conn = DriverManager.getConnection(url,username,password); 
		            Statement st = conn.createStatement(); 

		    		
		    		Calendar cal = new GregorianCalendar();
		    		Timestamp ts = new Timestamp(cal.getTimeInMillis());
		    		String stringDate = ts.toString();
		    		
		    		System.out.println("timestamp : " + ts);

		            String query = " insert into card1 (name, date_created, number, price,place)"
		                    + " values (?, ?, ?, ?,?)";
		            
		            PreparedStatement preparedStmt = conn.prepareStatement(query);
		            preparedStmt.setString (1, a);
		            preparedStmt.setString   (2, stringDate);
		            preparedStmt.setInt	(3, n);
		            preparedStmt.setInt   (4, c);
		            preparedStmt.setString   (5, d);
		            preparedStmt.execute();
		            
		            conn.close(); 
		        } catch (Exception ee) { 
		            System.err.println("Got an exception! "); 
		            System.err.println(ee.getMessage()); 
		        } 
	
			
			//mf.showpanel(new startpage(mf));
			 mf.showpanel(new yournumberis(mf));
		}
	});
	getContentPane().add(
			button,
	BorderLayout.SOUTH );
	addMouseMotionListener(
	// anonymous inner class
	new MouseMotionAdapter() {
	// store drag coordinates and repaint
	public void mouseDragged( MouseEvent event )
	{
	x = event.getX();
	y = event.getY();
	repaint();
	}
	}
	// end anonymous inner class
	); // end call to addMouseMotionListener
	setSize( 400, 400 );
	setVisible( true );
	}
	// draw oval in a 4-by-4 bounding box at the specified
	// location on the window
	public void paint( Graphics g )
	{
			g.fillRect( x, y, 10, 10 );
	}
	// execute application
//	public static void main( String args[] )
//	{
//	card application = new card();
//	application.addWindowListener(
//	// adapter to handle only windowClosing event
//	new WindowAdapter() {
//	public void windowClosing( WindowEvent event )
//	{
//	System.exit( 0 );
//	}
//	}
//	// end anonymous inner class
//	); // end call to addWindowListener
//	}
	}
	// end class card


	

