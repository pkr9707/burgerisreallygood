package mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import salesmanagement.salesmanagement;
import startpage.startpage;
import yournumberis.yournumberis;

public class mainframe extends JFrame{
	//그 뭐니 알아서 하자^^
	
	private JPanel bottom;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public mainframe(String title) {
		///타이틀에 로고 넣기
		
		super(title);
		ImageIcon im = new ImageIcon("logo.png");
		this.setIconImage(im.getImage());
		this.setVisible(true);
		initialize();
		pack();
	}

	/**
	 * Initialize the contents of the frame.	
	 */
	private void initialize() {
		
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 1000));
		ImageIcon im = new ImageIcon("logo.png");
		this.setIconImage(im.getImage());
		this.setVisible(true);
		this.setTitle("burgerking");
		
		 bottom = new JPanel();
		 bottom.setBackground(Color.BLACK);
		add(bottom,BorderLayout.CENTER);
		showpanel(new startpage(this));//다음 페이지로 넘어감
	}
	public void showpanel(JPanel panel) {
		bottom.removeAll();
		bottom.add(panel);//프레임에 패널 추가해주기
		bottom.revalidate();
		bottom.repaint();
		
	}
	
	public void showpanelsales(salesmanagement panel) {
		bottom.removeAll();
		bottom.add(panel);//프레임에 패널 추가해주기
		bottom.revalidate();
		bottom.repaint();
		
	}
	
	public void showpanelnum(yournumberis yn) {
		bottom.removeAll();
		bottom.add(yn);//프레임에 패널 추가해주기
		bottom.revalidate();
		bottom.repaint();
		
	}
}


