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
	//�� ���� �˾Ƽ� ����^^
	
	private JPanel bottom;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public mainframe(String title) {
		///Ÿ��Ʋ�� �ΰ� �ֱ�
		
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
		showpanel(new startpage(this));//���� �������� �Ѿ
	}
	public void showpanel(JPanel panel) {
		bottom.removeAll();
		bottom.add(panel);//�����ӿ� �г� �߰����ֱ�
		bottom.revalidate();
		bottom.repaint();
		
	}
	
	public void showpanelsales(salesmanagement panel) {
		bottom.removeAll();
		bottom.add(panel);//�����ӿ� �г� �߰����ֱ�
		bottom.revalidate();
		bottom.repaint();
		
	}
	
	public void showpanelnum(yournumberis yn) {
		bottom.removeAll();
		bottom.add(yn);//�����ӿ� �г� �߰����ֱ�
		bottom.revalidate();
		bottom.repaint();
		
	}
}


