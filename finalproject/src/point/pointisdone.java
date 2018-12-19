package point;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainframe.mainframe;
import startpage.startpage;


public class pointisdone extends JPanel {
final private mainframe mf;
	
public void inasecond() {
	Timer timer= new Timer();
	
	timer.schedule(new TimerTask() {
		
		@Override
		public  void run() {
			// TODO Auto-generated method stub

	mf.showpanel(new startpage(mf));
	}
		 
	}, 5*1000);
	
		
}
	public pointisdone(mainframe mf) {
	 super();
	 
	 this.mf = mf;
	
		this.setPreferredSize(new Dimension(500, 1000));
	
		this.setBackground(Color.white);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("안녕히가세요");
		lblNewLabel.setBounds(183, 377, 105, 15);
		add(lblNewLabel);
		
		inasecond();
		
		
		
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

