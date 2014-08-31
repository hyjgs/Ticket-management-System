package com.tolo.tabcs.manage.gui;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.gui.LeftAboutAuthor;
import com.tolo.tabcs.common.gui.LeftEverydayManager;
import com.tolo.tabcs.common.gui.LeftHandLog;
import com.tolo.tabcs.common.gui.LeftSearchMessage;
import com.tolo.tabcs.common.gui.LeftSqlPlus;
import com.tolo.tabcs.common.gui.LeftUseHelp;
import com.tolo.tabcs.common.gui.LoginFrame;
public class MainFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 6479133950501259157L;

	// Variables declaration - do not modify
		private javax.swing.JButton btnAccountInfo;
		private javax.swing.JButton btnBalanceMan;//营业结算
		private javax.swing.JButton btnBranchMan;//网点管理
		private javax.swing.JButton btnAirlineMan;//航线管理
		private javax.swing.JButton btnFlightSchMan;//航班管理
		private javax.swing.JButton btnSalesMan;//营业员管理
		private javax.swing.JButton btnGeneral;
		private javax.swing.JButton btnHandLog;
		private javax.swing.JButton btnHelp;
		private javax.swing.JButton btnRecordMan;//营业记录
		private javax.swing.JButton btnTotal;
		private javax.swing.JButton btnUsrMan;//账户管理
		private javax.swing.JButton jButton6;
		private javax.swing.JTextArea jTextArea1;
		private javax.swing.JScrollPane jtfInfo;
		private javax.swing.JLabel labLogo,labTips;
		
		private javax.swing.JPanel panCenter;//主面板
		private javax.swing.JPanel panNorth;
		private javax.swing.JPanel panWest;
		// End of variables declaration//GEN-END:variables
		
	/** Creates new form Main */
	public MainFrame() {
		initComponents();
		addHandler();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置窗口关闭模式,关闭即结束程序
		this.cardLayout = new CardLayout();
		panCenter.setLayout(this.cardLayout);
		
		//-------------------------------------------------------------------------------------
		panCenter.add("FlightMan", new FlightManagementPanel()); //加载航班管理 界面
		panCenter.add("AirlineMan", new AirLineManagementPanel(this));//加载航线管理 界面
		panCenter.add("BranchMan", new BranchManagementPanel(null)); //加载网点管理 界面
		panCenter.add("SalesMan",new UserPanel(null)); //加载营业员管理 界面
		panCenter.add("SaleRecordMan", new SalesRecordManagementPanel(this));//加载营业记录 界面
		panCenter.add("BalanceSubmit", new SalesRecordAccountsPanel());//加载营业结算 界面 
		panCenter.add("UserManPane", new UserAndRolesManagementPanel(this));//加载角色管理 界面
		
		panCenter.add("EverydayManager",new LeftEverydayManager()); //加载日常管理界面
		panCenter.add("SqlPlus",new LeftSqlPlus()); //加载SQLPLUS界面
		panCenter.add("SearchMessage",new LeftSearchMessage());//加载查看留言界面
		panCenter.add("HandLog",new LeftHandLog());//加载手动日志界面
		panCenter.add("UseHelp",new LeftUseHelp());//加载使用帮助界面
		panCenter.add("AboutAuthor",new LeftAboutAuthor());//加载关于作者界面
		
		this.setCard("FlightMan"); //默认优先显示的界面
		/*
		 * 	根据角色的不同，可以优先不同的界面
*/
		if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==7){
			this.setCard("UserManPane");
			this.btnBranchMan.setEnabled(false);//网点管理
			this.btnBalanceMan.setEnabled(false);//营业结算
			this.btnAirlineMan.setEnabled(false);//航线管理
			this.btnFlightSchMan.setEnabled(false);//航班管理
			this.btnSalesMan.setEnabled(false);//营业员管理
			this.btnRecordMan.setEnabled(false);//营业记录
		}else if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==6){
			this.setCard("BalanceSubmit");
			this.btnBranchMan.setEnabled(false);//网点管理
			this.btnAirlineMan.setEnabled(false);//航线管理
			this.btnFlightSchMan.setEnabled(false);//航班管理
			this.btnSalesMan.setEnabled(false);//营业员管理
			this.btnUsrMan.setEnabled(false);//账户管理
		}else if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==5){
			this.setCard("FlightMan");
			this.btnBranchMan.setEnabled(false);//网点管理
			this.btnBalanceMan.setEnabled(false);//营业结算
			this.btnAirlineMan.setEnabled(false);//航线管理
			this.btnSalesMan.setEnabled(false);//营业员管理
			this.btnRecordMan.setEnabled(false);//营业记录
			this.btnUsrMan.setEnabled(false);//账户管理
		}else if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==4){
			this.setCard("AirlineMan");
			this.btnBranchMan.setEnabled(false);//网点管理
			this.btnBalanceMan.setEnabled(false);//营业结算
			this.btnFlightSchMan.setEnabled(false);//航班管理
			this.btnSalesMan.setEnabled(false);//营业员管理
			this.btnRecordMan.setEnabled(false);//营业记录
			this.btnUsrMan.setEnabled(false);//账户管理
		}else if(((User)LoginFrame.onlineUsers.get("user")).getRole_id()==3){
			this.setCard("BranchMan");
			this.btnBalanceMan.setEnabled(false);//营业结算
			this.btnAirlineMan.setEnabled(false);//航线管理
			this.btnFlightSchMan.setEnabled(false);//航班管理
			this.btnRecordMan.setEnabled(false);//营业记录
			this.btnUsrMan.setEnabled(false);//账户管理
		}

//		 将图片添加到layeredPane
		ImageIcon img = new ImageIcon("res"+File.separator+"background.jpg");
		JLabel imgLabel = new JLabel(img);
		
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		((JPanel) getContentPane()).setOpaque(false);
		
		setIconImage(new ImageIcon("res"+File.separator+"logolabel.png").getImage());
	}


	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		panNorth = new javax.swing.JPanel(); //<---------北边的面板----------->
		btnFlightSchMan = new javax.swing.JButton();	//航班管理
		btnAirlineMan = new javax.swing.JButton(); // 航线管理按钮
		btnBranchMan = new javax.swing.JButton();	//网点管理按钮
		btnSalesMan=new javax.swing.JButton();		//营业员管理按钮
		btnRecordMan = new javax.swing.JButton();	//营业记录按钮
		btnBalanceMan = new javax.swing.JButton();  //营业结算按钮
		btnUsrMan = new javax.swing.JButton();	//账户管理
		labLogo = new javax.swing.JLabel(); //航空公司logo图标
		
		panWest = new javax.swing.JPanel(); //<-------西边的面板------->
		btnGeneral = new javax.swing.JButton();//日常管理按钮
		btnTotal = new javax.swing.JButton();//SQLPLUS按钮
		btnAccountInfo = new javax.swing.JButton();//查看留言按钮
		btnHandLog = new javax.swing.JButton();//手动日志按钮
		btnHelp = new javax.swing.JButton();//使用帮助按钮
		jButton6 = new javax.swing.JButton();//关于作者按钮
		
		panCenter = new javax.swing.JPanel();//<-------中间主面板------>
		labTips = new javax.swing.JLabel();
		jtfInfo = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);//设置窗口关闭模式为不操作
		setTitle("\u0054\u004f\u004c\u004f\u822a\u7a7a\u516c\u53f8\u56fd\u5185\u822a\u7ebf\u8425\u4e1a\u67dc\u5458\u7cfb\u7edf\u002d\u540e\u53f0\u7ba1\u7406");
		setBackground(new java.awt.Color(78, 160, 210));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//		setMaximizedBounds(new java.awt.Rectangle(0, 0, 800, 600));
//		setMinimumSize(new java.awt.Dimension(800, 600));
		setName("fraMain");
//		setResizable(true);

		panNorth.setBackground(new java.awt.Color(78, 160, 210));
		panNorth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panNorth.setName("panNorth");
		panNorth.setOpaque(false);

		ImageIcon ico=new ImageIcon("res"+File.separator+"manager"+File.separator+"jiesuan.jpg");
		ico.setImage(ico.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		btnBalanceMan.setIcon(new ImageIcon("res"+File.separator+"manager"+File.separator+"jiesuan.png")); // NOI18N
		btnBalanceMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnBalanceMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnBalanceMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnBalanceMan.setRolloverIcon(ico); // NOI18N
		btnBalanceMan.setContentAreaFilled(false);
		btnBalanceMan.setBorder(null);
		
		btnRecordMan.setIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"jilu_3.png")); // NOI18N
		btnRecordMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnRecordMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnRecordMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnRecordMan.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"jilu_3.jpg")); // NOI18N
		btnRecordMan.setContentAreaFilled(false);
		btnRecordMan.setBorder(null);
		
		btnBranchMan.setIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"wangdian.png")); // NOI18N
		btnBranchMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnBranchMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnBranchMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnBranchMan.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"wangdian.jpg")); // NOI18N
		btnBranchMan.setContentAreaFilled(false);
		btnBranchMan.setBorder(null);
		
		btnAirlineMan.setIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"hangxian.png")); // NOI18N
		btnAirlineMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnAirlineMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnAirlineMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnAirlineMan.setContentAreaFilled(false);//设置按钮全透明------------------------------>
		btnAirlineMan.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"hangxian.jpg")); // NOI18N
		btnAirlineMan.setContentAreaFilled(false);
		btnAirlineMan.setBorder(null);
		
		btnFlightSchMan.setIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"hangban.png")); // NOI18N
		btnFlightSchMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnFlightSchMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnFlightSchMan.setOpaque(false);
		btnFlightSchMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnFlightSchMan.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"hangban.jpg")); // NOI18N
		btnFlightSchMan.setContentAreaFilled(false);
		btnFlightSchMan.setBorder(null);//去除按钮边框
		
		btnSalesMan.setIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"yingyeyuan.png")); // NOI18N
		btnSalesMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnSalesMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnSalesMan.setOpaque(false);
		btnSalesMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnSalesMan.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"yingyeyuan.jpg")); // NOI18N
		btnSalesMan.setContentAreaFilled(false);
		btnSalesMan.setBorder(null);
		
		labLogo.setPreferredSize(new java.awt.Dimension(80, 80));
		labLogo.setIcon(new javax.swing.ImageIcon("res"+File.separator+"logo.png"));
		
		btnUsrMan.setIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"yonghu.png")); // NOI18N
		btnUsrMan.setMaximumSize(new java.awt.Dimension(80, 80));
		btnUsrMan.setMinimumSize(new java.awt.Dimension(80, 80));
		btnUsrMan.setPreferredSize(new java.awt.Dimension(80, 80));
		btnUsrMan.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"manager"+File.separator+"yonghu.jpg")); // NOI18N
		btnUsrMan.setContentAreaFilled(false);
		btnUsrMan.setBorder(null);
		
		javax.swing.GroupLayout panNorthLayout = new javax.swing.GroupLayout(panNorth);
		panNorth.setLayout(panNorthLayout);
		
		panNorthLayout.setHorizontalGroup(panNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				panNorthLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(labLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE).addComponent(btnFlightSchMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(33, 33, 33).addComponent(btnAirlineMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(36, 36, 36).addComponent(btnBranchMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(39, 39, 39).addComponent(btnSalesMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(39, 39, 39).addComponent(btnRecordMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(35, 35, 35).addComponent(btnBalanceMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(28, 28, 28).addComponent(btnUsrMan,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(53, 53, 53)));
		panNorthLayout.setVerticalGroup(panNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panNorthLayout.createSequentialGroup().addContainerGap().addGroup(
						panNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(labLogo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnBalanceMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnRecordMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnSalesMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnBranchMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnAirlineMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnFlightSchMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnUsrMan, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		panWest.setBackground(new java.awt.Color(78, 160, 210));
		panWest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panWest.setOpaque(false);

		btnGeneral.setIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left1@manage.jpg")); // NOI18N
		btnGeneral.setMaximumSize(new java.awt.Dimension(120, 53));
		btnGeneral.setMinimumSize(new java.awt.Dimension(120, 53));
		btnGeneral.setPreferredSize(new java.awt.Dimension(161, 60));
		btnGeneral.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left1@manage_2.jpg")); // NOI18N

		btnTotal.setIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left2@SQLPLUS.jpg")); // NOI18N
		btnTotal.setMaximumSize(new java.awt.Dimension(120, 53));
		btnTotal.setMinimumSize(new java.awt.Dimension(120, 53));
		btnTotal.setPreferredSize(new java.awt.Dimension(161, 60));
		btnTotal.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left2@SQLPLUS_2.jpg")); // NOI18N

		btnHandLog.setIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left3@message.jpg")); // NOI18N
		btnHandLog.setMaximumSize(new java.awt.Dimension(120, 53));
		btnHandLog.setMinimumSize(new java.awt.Dimension(120, 53));
		btnHandLog.setPreferredSize(new java.awt.Dimension(161, 60));
		btnHandLog.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left3@message_2.jpg")); // NOI18N

		btnAccountInfo.setIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left4@log.jpg")); // NOI18N
		btnAccountInfo.setMaximumSize(new java.awt.Dimension(120, 53));
		btnAccountInfo.setMinimumSize(new java.awt.Dimension(120, 53));
		btnAccountInfo.setPreferredSize(new java.awt.Dimension(161, 60));
		btnAccountInfo.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left4@log_2.jpg")); // NOI18N

		btnHelp.setIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left5@usehelp.jpg")); // NOI18N
		btnHelp.setMaximumSize(new java.awt.Dimension(120, 53));
		btnHelp.setMinimumSize(new java.awt.Dimension(120, 53));
		btnHelp.setPreferredSize(new java.awt.Dimension(161, 60));
		btnHelp.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left5@usehelp_2.jpg")); // NOI18N

		jButton6.setIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left6@aboutAuthor.jpg")); // NOI18N
		jButton6.setMaximumSize(new java.awt.Dimension(120, 53));
		jButton6.setMinimumSize(new java.awt.Dimension(120, 53));
		jButton6.setPreferredSize(new java.awt.Dimension(161, 60));
		jButton6.setRolloverIcon(new javax.swing.ImageIcon("res"+File.separator+"leftpanel"+File.separator+"left6@aboutAuthor_2.jpg")); // NOI18N

		javax.swing.GroupLayout panWestLayout = new javax.swing.GroupLayout(panWest);
		panWest.setLayout(panWestLayout);
		panWestLayout.setHorizontalGroup(panWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panWestLayout.createSequentialGroup().addGroup(
						panWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnHandLog, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnAccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(20, 20, 20)));
		panWestLayout.setVerticalGroup(panWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panWestLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(btnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnHandLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnAccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(124, Short.MAX_VALUE)));

		panCenter.setBackground(new java.awt.Color(255, 255, 255));
		panCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panCenter.setMaximumSize(new java.awt.Dimension(800, 600));
		panCenter.setMinimumSize(new java.awt.Dimension(800, 600));
		panCenter.setOpaque(false);
		panCenter.setPreferredSize(new java.awt.Dimension(800, 600));

		javax.swing.GroupLayout panCenterLayout = new javax.swing.GroupLayout(panCenter);
		panCenter.setLayout(panCenterLayout);
		panCenterLayout.setHorizontalGroup(panCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 798, Short.MAX_VALUE));
		panCenterLayout.setVerticalGroup(panCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 457, Short.MAX_VALUE));

		labTips.setText("\u63d0\u793a\u4fe1\u606f");

		jtfInfo.setAutoscrolls(true);
		jtfInfo.setOpaque(false);

		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setRows(5);
		jtfInfo.setViewportView(jTextArea1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(panWest, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jtfInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
												.addComponent(panCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))).addComponent(panNorth, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
								layout.createSequentialGroup().addContainerGap().addComponent(labTips, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(panNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addComponent(panCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
												javax.swing.GroupLayout.PREFERRED_SIZE).addGap(6, 6, 6)).addGroup(
										layout.createSequentialGroup().addComponent(panWest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(4, 4,
												4))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labTips).addGap(6, 6, 6)));

		panNorth.getAccessibleContext().setAccessibleName("panNorth");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1011) / 2, (screenSize.height - 751) / 2, 1011, 751);
	}// </editor-fold>
	//GEN-END:initComponents

	public void setCard(String cardTitle) {
		this.cardLayout.show(panCenter, cardTitle);
	}

	public void showMe() {
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//初始化即界面最大化

	}

	public void setTip(String tip) {
		this.labTips.setText(tip);
	}

	private CardLayout cardLayout;


	//GEN-BEGIN:variables
	
	/**
	 * 监听
	 */
	public void addHandler() {
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
		
		jButton6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("AboutAuthor");
			}
		});
		//----------------------------------------------------------
		this.btnBranchMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("BranchMan");
			}
		});
		this.btnAirlineMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("AirlineMan");
			}
		});
		this.btnFlightSchMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("FlightMan");
			}
		});
		
		this.btnSalesMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("SalesMan");
			}
		});
		
		this.btnRecordMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("SaleRecordMan");
			}
		});
		this.btnBalanceMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("BalanceSubmit");
			}
		});
		this.btnUsrMan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.setCard("UserManPane");
			}
		});
		//-------------------------------------------------------------
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

	//GEN-BEGIN:initComponents
	
	public void winCloseConfim() {
		int op = JOptionPane.showConfirmDialog(this, "确定要退出吗？", "确认退出", JOptionPane.YES_NO_OPTION);
		if (op == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		// to be deleted
	}
	
	
	public static void main(String[] args){
		new MainFrame().showMe();
	}

}