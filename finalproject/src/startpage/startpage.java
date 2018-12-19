package startpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import choose.choose;
//import login.login;
import mainframe.mainframe;
import menupage.menupage;
import sales.sales;
import salesmanagement.salesmanagement;

public class startpage extends JPanel {
	//첫번째 페이지
	final private mainframe mf;
	
	
	public startpage(mainframe mf) {
	 super();
	 
	 this.mf = mf;
	 
		insetpic();
		
		JButton staff = new JButton("관리자");
		staff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sales s= new sales();
				s.sale();
			}
		});
		
		JButton btn = new JButton("주문하기");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mf.showpanel(new menupage(mf));
			}
		});
		JPanel panel = new JPanel();
		
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
		staff.setSize(new Dimension(40, 40));
		this.add(staff,BorderLayout.NORTH);
		
		
	}
	public void insetpic() {
		
		ImageIcon im= new ImageIcon("logo.png");
		Image newim = im.getImage();
		Image newnewim=newim.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(newnewim);
		JLabel label1 = new JLabel("",Icon, JLabel.CENTER);
		setLayout(new BorderLayout());
		add(label1);
		
	}
	
}
