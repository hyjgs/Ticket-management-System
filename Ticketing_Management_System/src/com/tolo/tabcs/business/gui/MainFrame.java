package com.tolo.tabcs.business.gui;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.gui.LeftAboutAuthor;
import com.tolo.tabcs.common.gui.LeftEverydayManager;
import com.tolo.tabcs.common.gui.LeftHandLog;
import com.tolo.tabcs.common.gui.LeftSearchMessage;
import com.tolo.tabcs.common.gui.LeftSqlPlus;
import com.tolo.tabcs.common.gui.LeftUseHelp;
import com.tolo.tabcs.common.gui.LoginFrame;

/**
 * @author TangLiang
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 6479133950501259157L;

	// Variables declaration - do not modify
		private JButton btnAccountInfo;//营业记录按钮
		private JButton btnBookTicket;
		private JButton btnBounceTicket;
		private JButton btnLogout;
		private JButton btnGeneral;
		private JButton btnHandLog;
		private JButton btnHelp;
		private JButton btnSaleRecorder;
		private JButton btnSubmit;
		private JButton btnManSubmit;
		private JButton btnTotal;
		private JButton btnAbout;
		private JScrollPane jScrollPane1;
		private JTextArea jtaInfo;
		private JLabel labLogo;
		private JLabel labTips;
		private JPanel panCenter;
		private JPanel panNorth;
		private JPanel panWest;
		OrderTicketPanel otp;
		// End of variables declaration//GEN-END:variables
	
	/** Creates new form Main */
	public MainFrame() {
		initComponents();
		addHandles();
		this.cardLayout = new CardLayout();
		panCenter.setLayout(this.cardLayout);

		panCenter.add("SearchTicket", new SearchFlightResultPanel(this));// 订票--查询航班
		panCenter.add("BounceTicket", new ReturnTicketPanel2(this));//退票、改签
		panCenter.add("SaleReorder", new WorkRecord(this));//营业记录
		panCenter.add("SaleSubmit", new BusiAccountForSales());//营业结算--营业员
		panCenter.add("ManagerSubmit", new BusiAccountForManager());//营业结算--经理

		panCenter.add("EverydayManager",new LeftEverydayManager()); //加载日常管理界面
		panCenter.add("SqlPlus",new LeftSqlPlus()); //加载SQLPLUS界面
		panCenter.add("SearchMessage",new LeftSearchMessage());//加载查看留言界面
		panCenter.add("HandLog",new LeftHandLog());//加载手动日志界面
		panCenter.add("UseHelp",new LeftUseHelp());//加载使用帮助界面
		panCenter.add("AboutAuthor",new LeftAboutAuthor());//加载关于作者界面
		
		this.setCard("SearchTicket");

		// 将图片添加到layeredPane
		ImageIcon img = new ImageIcon("res"+File.separator+"background.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// 将contentPane设置成透明的
		((JPanel) getContentPane()).setOpaque(false);
		setIconImage(new ImageIcon("res"+File.separator+"logolabel.png").getImage());
		
		if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==2){
			this.setCard("ManagerSubmit");
			this.btnBookTicket.setEnabled(false);//订票
			this.btnBounceTicket.setEnabled(false);//退票
			this.btnSubmit.setEnabled(false);//营业结算1
		}else if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==1){
			this.setCard("SearchTicket");
			this.btnManSubmit.setEnabled(false);//营业结算2
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		panNorth = new JPanel();
		btnSubmit = new JButton();
		btnManSubmit=new JButton();
		btnSaleRecorder = new JButton();
		btnLogout = new JButton();
		btnBounceTicket = new JButton();
		btnBookTicket = new JButton();
		labLogo = new JLabel();
		panWest = new JPanel();
		btnGeneral = new JButton();
		btnTotal = new JButton();
		btnHandLog = new JButton();
		btnAccountInfo = new JButton();
		btnHelp = new JButton();
		btnAbout = new JButton();
		panCenter = new JPanel();
		labTips = new JLabel();
		jScrollPane1 = new JScrollPane();
		jtaInfo = new JTextArea();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("\u0054\u004f\u004c\u004f\u822a\u7a7a\u516c\u53f8\u56fd\u5185\u822a\u7ebf\u8425\u4e1a\u67dc\u5458\u7cfb\u7edf\u002d\u002d\u8425\u4e1a\u7ec8\u7aef");
		setBackground(new java.awt.Color(78, 160, 210));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//		setMaximizedBounds(new java.awt.Rectangle(0, 0, 1024, 768));
//		setMinimumSize(new java.awt.Dimension(800, 600));
		setName("fraMain");
//		setResizable(false);

		panNorth.setBackground(new java.awt.Color(78, 160, 210));
		panNorth.setBorder(BorderFactory.createEtchedBorder());
		panNorth.setName("panNorth");
		panNorth.setOpaque(false);

		btnManSubmit.setIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_jiesuan_1.png")); 
		btnManSubmit.setMaximumSize(new java.awt.Dimension(80, 80));
		btnManSubmit.setMinimumSize(new java.awt.Dimension(80, 80));
		btnManSubmit.setPreferredSize(new java.awt.Dimension(80, 80));
		btnManSubmit.setRolloverIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_jiesuan_1.jpg")); 
		btnManSubmit.setContentAreaFilled(false);
		btnManSubmit.setBorder(null);

		btnSubmit.setIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_jiesuan_1.png")); 
		btnSubmit.setMaximumSize(new java.awt.Dimension(80, 80));
		btnSubmit.setMinimumSize(new java.awt.Dimension(80, 80));
		btnSubmit.setPreferredSize(new java.awt.Dimension(80, 80));
		btnSubmit.setRolloverIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_jiesuan_1.jpg")); 
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(null);
		
		btnSaleRecorder.setIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"yingyejilu_b_3.png")); 
		btnSaleRecorder.setMaximumSize(new java.awt.Dimension(80, 80));
		btnSaleRecorder.setMinimumSize(new java.awt.Dimension(80, 80));
		btnSaleRecorder.setPreferredSize(new java.awt.Dimension(80, 80));
		btnSaleRecorder.setRolloverIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"yingyejilu_b_3.jpg")); 
		btnSaleRecorder.setContentAreaFilled(false);
		btnSaleRecorder.setBorder(null);
		
		btnBounceTicket.setIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_tuipiao_1.png")); 
		btnBounceTicket.setMaximumSize(new java.awt.Dimension(80, 80));
		btnBounceTicket.setMinimumSize(new java.awt.Dimension(80, 80));
		btnBounceTicket.setPreferredSize(new java.awt.Dimension(80, 80));
		btnBounceTicket.setRolloverIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_tuipiao_1.jpg")); 
		btnBounceTicket.setContentAreaFilled(false);
		btnBounceTicket.setBorder(null);
		
		btnBookTicket.setIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"dingpiao.png")); 
		btnBookTicket.setMaximumSize(new java.awt.Dimension(80, 80));
		btnBookTicket.setMinimumSize(new java.awt.Dimension(80, 80));
		btnBookTicket.setOpaque(false);
		btnBookTicket.setPreferredSize(new java.awt.Dimension(80, 80));
		btnBookTicket.setRolloverIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"dingpiao.jpg")); 
		btnBookTicket.setContentAreaFilled(false);
		btnBookTicket.setBorder(null);
		
		btnLogout.setIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_logout_1.png")); 
		btnLogout.setMaximumSize(new java.awt.Dimension(80, 80));
		btnLogout.setMinimumSize(new java.awt.Dimension(80, 80));
		btnLogout.setPreferredSize(new java.awt.Dimension(80, 80));
		btnLogout.setRolloverIcon(new ImageIcon("res"+File.separator+"business"+File.separator+"b_logout_1.jpg")); 
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		
		labLogo.setIcon(new ImageIcon("res"+File.separator+"logo.png")); 

		labLogo.setPreferredSize(new java.awt.Dimension(80, 80));

		GroupLayout panNorthLayout = new GroupLayout(panNorth);
		panNorth.setLayout(panNorthLayout);

		panNorthLayout.setHorizontalGroup(panNorthLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				panNorthLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(labLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
						.addComponent(btnBookTicket,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(33, 33, 33).addComponent(btnBounceTicket,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(39, 39, 39).addComponent(btnSaleRecorder,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(35, 35, 35).addComponent(btnSubmit,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(35, 35, 35).addComponent(btnManSubmit,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(36, 36, 36).addComponent(btnLogout,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(161, 161, 161)));
		panNorthLayout.setVerticalGroup(panNorthLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				panNorthLayout.createSequentialGroup().addContainerGap().addGroup(
						panNorthLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labLogo, GroupLayout.PREFERRED_SIZE,
								
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnSubmit, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnManSubmit, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnSaleRecorder, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnLogout, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnBounceTicket, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnBookTicket, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		panWest.setBackground(new java.awt.Color(78, 160, 210));
		panWest.setBorder(BorderFactory.createEtchedBorder());
		panWest.setOpaque(false);

		btnGeneral.setIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"general_n.jpg")); // NOI18N
		btnGeneral.setMaximumSize(new java.awt.Dimension(120, 53));
		btnGeneral.setMinimumSize(new java.awt.Dimension(120, 53));
		btnGeneral.setPreferredSize(new java.awt.Dimension(161, 60));
		btnGeneral.setRolloverIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"general_o.jpg")); // NOI18N

		btnTotal.setIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"total_n.jpg")); // NOI18N
		btnTotal.setRolloverIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"total_o.jpg")); // NOI18N
		btnTotal.setMaximumSize(new java.awt.Dimension(120, 53));
		btnTotal.setMinimumSize(new java.awt.Dimension(120, 53));
		btnTotal.setPreferredSize(new java.awt.Dimension(161, 60));

		btnHandLog.setIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"log_n.jpg")); // NOI18N
		btnHandLog.setRolloverIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"log_o.jpg")); // NOI18N
		btnHandLog.setMaximumSize(new java.awt.Dimension(120, 53));
		btnHandLog.setMinimumSize(new java.awt.Dimension(120, 53));
		btnHandLog.setPreferredSize(new java.awt.Dimension(161, 60));

		btnAccountInfo.setIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"account_n.jpg")); // NOI18N
		btnAccountInfo.setRolloverIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"account_o.jpg")); // NOI18N
		btnAccountInfo.setMaximumSize(new java.awt.Dimension(120, 53));
		btnAccountInfo.setMinimumSize(new java.awt.Dimension(120, 53));
		btnAccountInfo.setPreferredSize(new java.awt.Dimension(161, 60));

		btnHelp.setIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"help_n.jpg")); // NOI18N
		btnHelp.setRolloverIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"help_o.jpg")); // NOI18N
		btnHelp.setMaximumSize(new java.awt.Dimension(120, 53));
		btnHelp.setMinimumSize(new java.awt.Dimension(120, 53));
		btnHelp.setPreferredSize(new java.awt.Dimension(161, 60));

		btnAbout.setIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"about_n.jpg")); // NOI18N
		btnAbout.setMaximumSize(new java.awt.Dimension(120, 53));
		btnAbout.setMinimumSize(new java.awt.Dimension(120, 53));
		btnAbout.setPreferredSize(new java.awt.Dimension(161, 60));
		btnAbout.setRolloverIcon(new ImageIcon("res"+File.separator+"leftpanel"+File.separator+"about_o.jpg")); // NOI18N

		GroupLayout panWestLayout = new GroupLayout(panWest);
		panWest.setLayout(panWestLayout);
		panWestLayout.setHorizontalGroup(panWestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				panWestLayout.createSequentialGroup().addGroup(
						panWestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnTotal, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnHandLog, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnAccountInfo, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnHelp, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnAbout, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnGeneral, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(20, 20, 20)));
		panWestLayout.setVerticalGroup(panWestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				panWestLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(btnGeneral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnHandLog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnAccountInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addContainerGap(127, Short.MAX_VALUE)));

		panCenter.setBackground(new java.awt.Color(255, 255, 255));
		panCenter.setBorder(BorderFactory.createEtchedBorder());
		panCenter.setMaximumSize(new java.awt.Dimension(800, 600));
		panCenter.setMinimumSize(new java.awt.Dimension(800, 600));
		panCenter.setOpaque(false);
		panCenter.setPreferredSize(new java.awt.Dimension(800, 600));

		GroupLayout panCenterLayout = new GroupLayout(panCenter);
		panCenter.setLayout(panCenterLayout);
		panCenterLayout.setHorizontalGroup(panCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 798, Short.MAX_VALUE));
		panCenterLayout.setVerticalGroup(panCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 456, Short.MAX_VALUE));

		labTips.setText("\u63d0\u793a\u4fe1\u606f");

		jtaInfo.setColumns(20);
		jtaInfo.setEditable(false);
		jtaInfo.setRows(5);
		jtaInfo.setOpaque(false);
		jScrollPane1.setViewportView(jtaInfo);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
								GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(panWest, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
												.addComponent(panCenter, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))).addComponent(panNorth, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
								layout.createSequentialGroup().addContainerGap().addComponent(labTips, GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(panNorth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addComponent(panCenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 127,
														GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(
										layout.createSequentialGroup().addComponent(panWest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(4, 4,
												4))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(labTips).addGap(6, 6, 6)));

		panNorth.getAccessibleContext().setAccessibleName("panNorth");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1011) / 2, (screenSize.height - 751) / 2, 1011, 751);
	}// </editor-fold>
	//GEN-END:initComponents

	public void addHandles() {
		this.btnGeneral.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("EverydayManager");
			}
		});
	
		btnTotal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("SqlPlus");
			}
		});
		
		btnAccountInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("HandLog");
			}
		});
		
		btnHandLog.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("SearchMessage");
			}
		});
		
		btnHelp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("UseHelp");
			}
		});
		
		btnAbout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				MainFrame.this.setCard("AboutAuthor");
			}
		});
		
		//-----------------------------------------------------------------

		this.btnBookTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("SearchTicket");

			}
		});
		this.btnBounceTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("BounceTicket");
			}
		});
		this.btnManSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					MainFrame.this.setCard("ManagerSubmit");
			}
		});
		this.btnSaleRecorder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setCard("SaleReorder");
			}
		});
		this.btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					
					MainFrame.this.setCard("SaleSubmit");
			}
		});
		
		
		this.btnLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(MainFrame.this, "确定要退出吗？", "确认退出", JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		this.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				winCloseConfim();
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
		});

	}

	public void setCard(String cardTitle) {
		this.cardLayout.show(panCenter, cardTitle);
	}

	public void winCloseConfim() {
		int op = JOptionPane.showConfirmDialog(this, "确定要退出吗？", "确认退出", JOptionPane.YES_NO_OPTION);
		if (op == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void showMe() {
		this.setVisible(true);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	public void setTip(String tip) {
		this.labTips.setText(tip);
	}

	private CardLayout cardLayout;


	//GEN-BEGIN:variables
	
	
	public OrderTicketPanel getOtp() {
		return otp;
	}

	@SuppressWarnings("unchecked")
	public void setOtp(List l) {
		this.otp = new OrderTicketPanel(this,l);
		panCenter.add("BookTicket", otp);// 订票 --购票
	}

	public static void main(String[] args){
		new MainFrame().showMe();
	}

}