package salesmanagement;



import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainframe.mainframe;

public class salesmanagement extends JFrame {
	
	final private mainframe mf;
	
	public salesmanagement(mainframe mf) {
		
	super();
	this.mf=mf;
	
	JPanel panel = new JPanel();
	panel.setSize(new Dimension(400, 400));
	panel.setBackground(Color.red);
	add(panel);
	
	
	
}
	
	
}
