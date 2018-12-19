package menupage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import card.card;
import mainframe.mainframe;
import startpage.startpage;
import javax.sound.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import java.awt.Scrollbar;

public class menupage extends JPanel {
	//두번째페이지
	final private  mainframe mf;
	public menupage mp;
	public JLabel menunametext[][]= new JLabel[3][10];
	public JLabel numbertext[][] = new JLabel[3][10];
	public JLabel pricetextfi[][] = new JLabel[3][10];
	public JButton plusnumber;
	public JButton plusnone;
	public JFrame frame;
	public JLabel menupricef;
	public JTextArea showallprice;
	public JPanel first[]= new JPanel[10];
public static int [][]itemcost= new int[3][10];
public static int []itemcount= new int[10];
public static boolean []valid= new boolean [12];
public static int [][]num= new int[3][10];
public static String [][]name= new String[3][12];
public static String []prices= new String[12];
public static boolean [][]check= new boolean[3][12];
public static boolean changepage;
public static boolean chk;
public static String where;
public JTable table;
	/**
	 * Launch the application.
//	 */
//	public static void menup() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					menupage window = new menupage();
//					window.mf.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	//소리 "메뉴를 선택하세요" 삽입
	static void PlaySound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public menupage(mainframe mf) {
		 
		super();
		 this.mf = mf;
		 
		 //소리 넣기
		 File file = new File("order.wav");
		PlaySound(file);

			for(int i=0; i<3; i++) {
				
				for(int j=0; j<10; j++) {
				itemcost[i][j]=0;itemcount[j]=0;num[i][j]=0;check[i][j]=false; }}

			
			JPanel panel = new JPanel();//가장 밑에 깔리는 패널
			add(panel);
			this.setPreferredSize(new Dimension(500, 1000));//사이즈 정해주기
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setPreferredSize(new Dimension(500, 1000));//사이즈 정해주기
			this.setBackground(Color.white);
			panel.setLayout(null);//setBounds하려면 꼭 필요
			
		
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			
			
			
			tabbedPane.setBounds(5, 37, 485, 500);
			panel.add(tabbedPane);
			tabbedPane.setBackground(Color.WHITE);
	
			


			
			
			
			JPanel mainpanel2 = new JPanel();
			tabbedPane.addTab("  단품  ", null, mainpanel2, null);
			mainpanel2.setBackground(Color.WHITE);
			mainpanel2.setLayout(null);
			
			JPanel f_f = new JPanel();
			f_f.setBackground(Color.WHITE);
			f_f.setBounds(0, 0, 239, 135);
			mainpanel2.add(f_f);
			f_f.setLayout(null);
			
			JLabel menutablef = new JLabel(new ImageIcon("menu1_1.png") );
			menutablef.setBounds(0, 0, 143, 135);
			f_f.add(menutablef);
			
			JLabel menunamesf = new JLabel("햄버거");
			menunamesf.setBounds(155, 39, 57, 15);
			f_f.add(menunamesf);
			
			JLabel menupricef = new JLabel("20000");
			menupricef.setBounds(155, 78, 57, 15);
			f_f.add(menupricef);
			
			
			
			JPanel f_s = new JPanel();
			f_s.setBackground(Color.WHITE);
			f_s.setBounds(241, 0, 239, 135);
			mainpanel2.add(f_s);
			f_s.setLayout(null);
			
			JLabel menutables = new JLabel(new ImageIcon("menu1_1.png") );
			menutables.setBounds(0, 0, 143, 135);
			f_s.add(menutables);
			
			JLabel menunamess = new JLabel("세인버거");
			menunamess.setBounds(155, 39, 57, 15);
			f_s.add(menunamess);
			
			JLabel menuprices = new JLabel("30000");
			menuprices.setBounds(155, 78, 57, 15);
			f_s.add(menuprices);
			
			JPanel f_t = new JPanel();
			f_t.setLayout(null);
			f_t.setBackground(Color.WHITE);
			f_t.setBounds(0, 137, 239, 135);
			mainpanel2.add(f_t);
			
			JLabel menutablet = new JLabel(new ImageIcon("menu1_1.png"));
			menutablet.setBounds(0, 0, 143, 135);
			f_t.add(menutablet);
			
			JLabel menunamest = new JLabel("새우와퍼");
			menunamest.setBounds(155, 38, 57, 15);
			f_t.add(menunamest);
			
			JLabel menupricet = new JLabel("50000");
			menupricet.setBounds(155, 77, 57, 15);
			f_t.add(menupricet);
			
			JPanel f_four = new JPanel();
			f_four.setLayout(null);
			f_four.setBackground(Color.WHITE);
			f_four.setBounds(241, 137, 239, 135);
			mainpanel2.add(f_four);
			
			JLabel label_6 = new JLabel(new ImageIcon("menu1_1.png"));
			label_6.setBounds(0, 0, 143, 135);
			f_four.add(label_6);
			
			JLabel menunamesfour = new JLabel("몬스터 와퍼");
			menunamesfour.setBounds(155, 39, 72, 15);
			f_four.add(menunamesfour);
			
			JLabel menupricefour = new JLabel("40000");
			menupricefour.setBounds(155, 78, 57, 15);
			f_four.add(menupricefour);
			
			JPanel f_five = new JPanel();
			f_five.setLayout(null);
			f_five.setBackground(Color.WHITE);
			f_five.setBounds(0, 273, 239, 135);
			mainpanel2.add(f_five);
			
			JLabel label_9 = new JLabel(new ImageIcon("menu1_1.png"));
			label_9.setBounds(0, 0, 143, 135);
			f_five.add(label_9);
			
			JLabel menunamesfive = new JLabel("불고기 와퍼");
			menunamesfive.setBounds(155, 40, 72, 15);
			f_five.add(menunamesfive);
			
			JLabel menupricefive = new JLabel("35000");
			menupricefive.setBounds(155, 79, 57, 15);
			f_five.add(menupricefive);
			
	
			JPanel allprice = new JPanel();
			allprice.setBackground(Color.WHITE);
			allprice.setBounds(5, 859, 242, 102);
			panel.add(allprice);
			allprice.setLayout(null);
			
			
			showallprice = new JTextArea();
			showallprice.setBounds(79, 35, 85, 24);
			allprice.add(showallprice);

			
			
			
			JPanel showselected = new JPanel();
			showselected.setBounds(5, 565, 484, 293);
			panel.add(showselected);
			
			DefaultListModel<String> dlm = new DefaultListModel<String>();
			JList<String> list = new JList<String>();
			
			///////f_F
			JPanel f_F= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			BoxLayout b1= new BoxLayout(f_F, BoxLayout.Y_AXIS);
			f_F.setLayout(b1);
			//f_F.setBackground(Color.YELLOW);
			
			
			f_f.addMouseListener(new MouseListener() {
				//@Override
				boolean chk= false;
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}	
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					name[0][0]=menunamesf.getText();
					System.out.print(name[0][0]);
					if(check[0][0]==false)itemcost[0][1]=Integer.parseInt(menupricef.getText());
					check[0][0]=true;
					
					System.out.println(chk);
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
					showallprice.setText(s);
					num[0][0]=itemcost[0][1]/Integer.parseInt(menupricef.getText());
						
					String price= Integer.toString(itemcost[0][1]);
					
					JPanel np = new JPanel();
					np.setSize(440,40);
					np.setMinimumSize(new Dimension(440, 40));
					np.repaint();
					
					if(chk==false) {
					f_F.setVisible(true);
					f_F.add(np);
					
					
					fillthepanel(0,1, price, np);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("**"+pricetextfi[0]);
							System.out.println("***"+pricetextfi[1]);
							System.out.println("**"+numbertext[0]);
							
							plus(0,1,menupricef.getText());	
							pricetextfi[0][0].setText("                                    "+itemcost[0][1]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np.add(plusnumber);
					chk=true;
					
					fillthepanel1(0,1, price, np);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(0,1,f_F, np);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(f_F);
					
				}
			});
			
			///////f_S
			JPanel f_S= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			f_S.setLayout(new BoxLayout(f_S, BoxLayout.PAGE_AXIS));
			f_s.addMouseListener(new MouseListener() {
				boolean chk= false;
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
	}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					name[0][1]=menunamess.getText();
					
					//itemcost[0][0]=Integer.parseInt(menuprices.getText());
					
					if(check[0][1]==false)itemcost[0][2]=Integer.parseInt(menuprices.getText());
					check[0][1]=true;
					
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
					showallprice.setText(s);
					num[0][1]=itemcost[0][2]/Integer.parseInt(menuprices.getText());
					
					String price= Integer.toString(itemcost[0][2]);

					
					JPanel np1 = new JPanel();
					np1.setSize(440,40);
					np1.setMinimumSize(new Dimension(440, 40));
					np1.repaint();
					
					if(chk==false) {
					f_S.setVisible(true);
					f_S.add(np1);
					
					
					fillthepanel(0,2, price, np1);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							plus(0,2,menuprices.getText());		
							pricetextfi[0][1].setText("                                    "+itemcost[0][2]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np1.add(plusnumber);
					chk=true;
					
					fillthepanel1(0,2, price, np1);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(0,2,f_S, np1);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np1.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(f_S);
				}
				
			});
			
			

			///////f_T
			JPanel f_T= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			f_T.setLayout(new BoxLayout(f_T, BoxLayout.PAGE_AXIS));
			f_t.addMouseListener(new MouseListener() {
				boolean chk= false;
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					name[0][2]=menunamest.getText();
					
					//itemcost[0][0]=Integer.parseInt(menuprices.getText());
					
					if(check[0][2]==false)itemcost[0][3]=Integer.parseInt(menupricet.getText());
					check[0][2]=true;
					
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
					showallprice.setText(s);
					num[0][2]=itemcost[0][3]/Integer.parseInt(menupricet.getText());
					
					String price= Integer.toString(itemcost[0][3]);

					
					JPanel np1 = new JPanel();
					np1.setSize(440,40);
					np1.setMinimumSize(new Dimension(440, 40));
					np1.repaint();
					
					if(chk==false) {
					f_T.setVisible(true);
					f_T.add(np1);
					
					
					fillthepanel(0,3, price, np1);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("000"+pricetextfi[0][3]);
							plus(0,3,menupricet.getText());		
							pricetextfi[0][2].setText("                                    "+itemcost[0][3]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np1.add(plusnumber);
					chk=true;
					
					fillthepanel1(0,3, price, np1);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(0,3,f_T, np1);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np1.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(f_T);
				}
				
			});
			
			
			JPanel f_Four= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			f_Four.setLayout(new BoxLayout(f_Four, BoxLayout.PAGE_AXIS));
			f_four.addMouseListener(new MouseListener() {
				boolean chk= false;
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					name[0][3]=menunamesfour.getText();
					
					//itemcost[0][0]=Integer.parseInt(menuprices.getText());
					
					if(check[0][3]==false)itemcost[0][4]=Integer.parseInt(menupricefour.getText());
					check[0][3]=true;
					
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
					showallprice.setText(s);
					num[0][3]=itemcost[0][4]/Integer.parseInt(menupricefour.getText());
					
					String price= Integer.toString(itemcost[0][4]);

					
					JPanel np1 = new JPanel();
					np1.setSize(440,40);
					np1.setMinimumSize(new Dimension(440, 40));
					np1.repaint();
					
					if(chk==false) {
					f_Four.setVisible(true);
					f_Four.add(np1);
					
					
					fillthepanel(0,4, price, np1);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("000"+pricetextfi[0][3]);
							plus(0,4,menupricefour.getText());		
							pricetextfi[0][3].setText("                                    "+itemcost[0][4]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np1.add(plusnumber);
					chk=true;
					
					fillthepanel1(0,4, price, np1);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(0,4,f_Four, np1);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np1.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(f_Four);
				}
				
			});
			
			JPanel f_Five= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			f_Five.setLayout(new BoxLayout(f_Five, BoxLayout.PAGE_AXIS));
			f_five.addMouseListener(new MouseListener() {
				boolean chk= false;
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					name[0][4]=menunamesfive.getText();
					
					//itemcost[0][0]=Integer.parseInt(menuprices.getText());
					
					if(check[0][4]==false)itemcost[0][5]=Integer.parseInt(menupricefive.getText());
					check[0][4]=true;
					
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1])+itemcost[1][2];
					showallprice.setText(s);
					num[0][4]=itemcost[0][5]/Integer.parseInt(menupricefive.getText());
					
					String price= Integer.toString(itemcost[0][5]);

					
					JPanel np1 = new JPanel();
					np1.setSize(440,40);
					np1.setMinimumSize(new Dimension(440, 40));
					np1.repaint();
					
					if(chk==false) {
					f_Five.setVisible(true);
					f_Five.add(np1);
					
					
					fillthepanel(0,5, price, np1);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("000"+pricetextfi[0][3]);
							plus(0,5,menupricefive.getText());		
							pricetextfi[0][4].setText("                                    "+itemcost[0][5]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np1.add(plusnumber);
					chk=true;
					
					fillthepanel1(0,5, price, np1);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(0,5,f_Five, np1);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np1.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(f_Five);
				}
				
			});
			
			
			
			
			
			
			
			
			
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			JPanel mainpanel1 = new JPanel();
			tabbedPane.addTab("몬스터X 팩", null, mainpanel1, null);
			mainpanel1.setBackground(Color.white);
			mainpanel1.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(0, 0, 239, 135);
			mainpanel1.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel(new ImageIcon("menu1_1.png"));
			lblNewLabel.setBounds(0, 0, 143, 135);
			panel_1.add(lblNewLabel);
			
			JLabel label_1 = new JLabel("X2 팩");
			label_1.setBounds(170, 39, 57, 15);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("30000");
			label_2.setBounds(170, 78, 57, 15);
			panel_1.add(label_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(241, 0, 239, 135);
			mainpanel1.add(panel_2);
			
			JLabel label_3 = new JLabel(new ImageIcon("menu1_1.png"));
			label_3.setBounds(0, 0, 143, 135);
			panel_2.add(label_3);
			
			JLabel label_4 = new JLabel("X1 팩");
			label_4.setBounds(170, 39, 57, 15);
			panel_2.add(label_4);
			
			JLabel label_5 = new JLabel("45000");
			label_5.setBounds(170, 78, 57, 15);
			panel_2.add(label_5);
			mf.setVisible(true);
			
			JPanel s_f= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			s_f.setLayout(new BoxLayout(s_f, BoxLayout.PAGE_AXIS));
			panel_1.addMouseListener(new MouseListener() {
				boolean chk= false;
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
	}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					name[1][0]=label_1.getText();
					System.out.println(name[1][0]+""+label_1.getText());
					
					//itemcost[0][0]=Integer.parseInt(menuprices.getText());
					
					if(check[1][0]==false)itemcost[1][1]=Integer.parseInt(label_2.getText());
					check[1][0]=true;
					
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
					showallprice.setText(s);
					num[1][0]=itemcost[1][1]/Integer.parseInt(label_2.getText());
					
					String price= Integer.toString(itemcost[1][1]);
					System.out.println("hi");
					
					JPanel np2 = new JPanel();
					np2.setSize(440,40);
					np2.setMinimumSize(new Dimension(440, 40));
					np2.repaint();
					
					if(chk==false) {
						s_f.setVisible(true);
						s_f.add(np2);
					
					
					fillthepanel(1,1, price, np2);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							plus(1,1,label_2.getText());		
							pricetextfi[1][0].setText("                                    "+itemcost[1][1]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np2.add(plusnumber);
					chk=true;
					
					fillthepanel1(1,1, price, np2);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(1,1,s_f, np2);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np2.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(s_f);
				}
				
			});
			
			JPanel s_S= new JPanel();//addpanel이 리턴해주는 패널을 받는 패널<-요거 해야지 패널 계속 늘어나지 않음
			s_S.setLayout(new BoxLayout(s_S, BoxLayout.PAGE_AXIS));
			panel_2.addMouseListener(new MouseListener() {
				boolean chk= false;
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
	}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					name[1][1]=label_4.getText();
					System.out.println(name[1][1]+""+label_4.getText());
					
					//itemcost[0][0]=Integer.parseInt(menuprices.getText());
					
					if(check[1][1]==false)itemcost[1][2]=Integer.parseInt(label_5.getText());
					check[1][1]=true;
					
					String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+itemcost[0][4]+itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
					showallprice.setText(s);
					num[1][1]=itemcost[1][2]/Integer.parseInt(label_5.getText());
					
					String price= Integer.toString(itemcost[1][2]);
					System.out.println("hi");
					
					JPanel np2 = new JPanel();
					np2.setSize(440,40);
					np2.setMinimumSize(new Dimension(440, 40));
					np2.repaint();
					
					if(chk==false) {
						s_S.setVisible(true);
						s_S.add(np2);
					
					
					fillthepanel(1,2, price, np2);
					
					//플러스가 중간에 들어가야함...하나로 묶고 싶은디 못 묶음
					plusnumber = new JButton("+");
					plusnumber.setBackground(Color.orange);
					plusnumber.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							plus(1,2,label_5.getText());		
							pricetextfi[1][1].setText("                                    "+itemcost[1][2]);//간격 맞추기
							
						}
					});
					plusnumber.setBounds(221, 10, 41, 20);
					np2.add(plusnumber);
					chk=true;
					
					fillthepanel1(1,2, price, np2);
					
					JButton plusnone;//메뉴 삭제
					plusnone = new JButton("X");//메뉴
					plusnone.setBackground(Color.orange);
					plusnone.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							theX(1,2,s_S, np2);
							chk=false;
						}
					});
					
					plusnone.setBounds(381, 10, 41, 20);
					np2.add(plusnone);
					}					
					showallprice.setText(s);
					showselected.add(s_S);
				}
				
			});
						
			JPanel menunumberprice = new JPanel();
			menunumberprice.setBounds(5, 536, 485, 30);
			menunumberprice.setBackground(Color.WHITE);
			panel.add(menunumberprice);
			
			JLabel label = new JLabel("메뉴                                      수량                                           가격");
			menunumberprice.add(label);
			
			
			
			JPanel nextpage = new JPanel();
			nextpage.setBackground(Color.WHITE);
			nextpage.setBounds(246, 859, 242, 102);
			//nextpage.setBackground(Color.WHITE);
			panel.add(nextpage);
			
			JButton goback = new JButton("실행 취소");
			goback.setBackground(Color.WHITE);
			goback.setBounds(31, 37, 98, 23);
			goback.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					mf.showpanel(new startpage(mf));
					
					
				}
			});
			nextpage.setLayout(null);
			nextpage.add(goback);
			
			JButton gonext = new JButton("결재");
			gonext.setBackground(Color.WHITE);
			gonext.setBounds(141, 37, 69, 23);
			gonext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					frame = new JFrame();
					frame.setVisible(true);
					frame.setSize
					(400,600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					
					JButton takein = new JButton("매장식사");
					takein.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							where="IN";
							card carrd = new card(mp,mf);
							frame.dispose();
						}
					});
					takein.setBounds(61, 528, 97, 23);
					frame.getContentPane().add(takein);
					frame.setBackground(Color.WHITE);
					JButton takeout = new JButton("포장");
					takeout.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							where="OUT";
							card carrd = new card(mp,mf);
							frame.dispose();
						}
					});
					takeout.setBounds(226, 528, 97, 23);
					frame.getContentPane().add(takeout);
					
			
					   DefaultListModel<String> l1 = new DefaultListModel<>();  
				       
					   	for(int i=0; i<3; i++) {
					   		for(int j=0; j<10; j++)
					   	  if(name[i][j]!=null) {
					   		l1.addElement(name[i][j]+"  "+num[i][j]+" "+itemcost[i][j+1]); 
					   	  }
					   	}
					   	
					   	
				          JList<String> list = new JList<>(l1);  
				          list.setBounds(24, 38, 332, 469);  
				          frame.getContentPane().add(list);  
				           
				          frame.getContentPane().setLayout(null);  
				          frame.setVisible(true);  
					
				}
			});
			nextpage.add(gonext);
			
			

			
		}
	
	//클릭안하면 15초 뒤 처음으로 돌아감
	
	
	
	public void fillthepanel(int a,int n, String price, JPanel np) {
		menunametext[a][n-1] = new JLabel();//메뉴이름
		menunametext[a][n-1].setText("      "+name[a][n-1]+"                          ");//간격 맞추기
		menunametext[a][n-1].setBounds(0, 0, 94, 20);
		np.add(menunametext[a][n-1]);
		//menunametext.setColumns(10);
		
		numbertext[a][n-1] = new JLabel();//메뉴 갯수
		numbertext[a][n-1].setText("          "+num[a][n-1]);//간격 맞추기
		numbertext[a][n-1].setBounds(168, 10, 41, 21);
		np.add(numbertext[a][n-1]);
		System.out.println(numbertext[a][n-1]);
		//numbertext.setColumns(10)
		pricetextfi[a][n-1]=new JLabel();
		pricetextfi[a][n-1].setBounds(280, 10, 87, 21);
	}
	
	public void fillthepanel1(int a, int n, String price, JPanel np) {
		//메누가격
				pricetextfi[a][n-1]=new JLabel();
				pricetextfi[a][n-1].setText("                                    "+price);//간격 맞추기
				pricetextfi[a][n-1].setBounds(280, 10, 87, 21);
				np.add(pricetextfi[a][n-1]);
				System.out.println(pricetextfi[a][n-1]);
		
		
	}
	
	public void plus(int a,int n,String menupricef) {
		num[a][n-1]++;		

		menupage.itemcost[a][n]+=Integer.parseInt(menupricef);
		numbertext[a][n-1].setText("          "+num[a][n-1]);//간격 맞추기
		
		String price=Integer.toString(menupage.itemcost[0][n]);

		pricetextfi[a][n-1].repaint();

		
		String s= Integer.toString(menupage.itemcost[0][1]+menupage.itemcost[0][2]+menupage.itemcost[0][3]+menupage.itemcost[0][4]+menupage.itemcost[0][5]+menupage.itemcost[1][1]+itemcost[1][2]);
		showallprice.setText(s);
		repaint();
		
		
		
	}
	
	public void theX(int a,int n,JPanel f_F,JPanel np) {
		
				f_F.removeAll();
				np.repaint();
				f_F.setVisible(false);
				itemcost[a][n]=0;
				num[a][n-1]=0;
				name[a][n-1]=null;
			
				String s= Integer.toString(itemcost[0][1]+itemcost[0][2]+itemcost[0][3]+menupage.itemcost[0][4]+menupage.itemcost[0][5]+itemcost[1][1]+itemcost[1][2]);
				
				showallprice.setText(s);
		
		check[a][n-1]=false;
		repaint();
		
	}
	}
	
			



	/**
	 * Initialize the contents of the frame.
	 */



