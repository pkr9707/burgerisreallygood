package checkselected;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainframe.mainframe;
import menupage.menupage;

import javax.swing.JList;

public class checkselected extends JPanel{

	final private  mainframe mf;

	/**
	 * Launch the application.
	 */
//	public static void newcheck() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					checkselected window = new checkselected();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public checkselected(mainframe mf) {
		this.mf=mf;
		
		initialize();
	}

	
	private void initialize() {
		JPanel panel = new JPanel();//가장 밑에 깔리는 패널
		add(panel);
		panel.setSize
		(400,600);
		panel.setLayout(null);
		
		JButton takein = new JButton("매장식사");
		takein.setBounds(61, 528, 97, 23);
		panel.add(takein);
		
		JButton takeout = new JButton("포장");
		takeout.setBounds(226, 528, 97, 23);
		panel.add(takeout);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> list = new JList<String>();
		list.setBounds(12, 59, 360, 446);
		panel.add(list);
	}

}
