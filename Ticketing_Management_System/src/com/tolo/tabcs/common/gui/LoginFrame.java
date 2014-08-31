package com.tolo.tabcs.common.gui;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.business.gui.*;
import com.tolo.tabcs.manage.gui.*;
public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 5955783734870603667L;

	private JButton btnCancle; //退出按钮
	private JButton btnSubmit; //登录按钮
	private JPasswordField jpfPwd; //密码文本框
	private JTextField jtfUid;	//用户名文本框
	
	public static  Map<String,Object> onlineUsers; //用于统计在线人数和防止重复登录
	

	public LoginFrame() {
		initComponents();
		addHandlers();
		
		onlineUsers=new Hashtable<String,Object>();

		// 将图片添加到layeredPane
		ImageIcon img = new ImageIcon("res"+File.separator+"login"+File.separator+"login.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		((JPanel) getContentPane()).setOpaque(false);
		setIconImage(new ImageIcon("res"+File.separator+"logolabel.png").getImage());//设置logo
	}

	
	private void initComponents() {
		jtfUid = new JTextField();
		jpfPwd = new JPasswordField();
		btnSubmit = new JButton();
//		btnSubmit.setEnabled(false);
		btnCancle = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置窗口关闭模式,关闭即结束程序
	//	setBackground(new Color(255, 255, 255));
	//	setMinimumSize(new Dimension(360, 225));

		btnSubmit.setIcon(new ImageIcon("res"+File.separator+"login"+File.separator+"login_n.jpg")); // File.separator可以根据系统不同表示分割符
	//	btnSubmit.setMaximumSize(new Dimension(73, 25));
	//	btnSubmit.setMinimumSize(new Dimension(73, 25));
		btnSubmit.setPreferredSize(new Dimension(73, 25)); //设置登录按钮大小
		btnSubmit.setPressedIcon(new ImageIcon("res"+File.separator+"login"+File.separator+"login_p.jpg")); 
		btnSubmit.setRolloverIcon(new ImageIcon("res"+File.separator+"login"+File.separator+"login_p.jpg")); //鼠标移动到按钮上显示的图片

		btnCancle.setIcon(new ImageIcon("res"+File.separator+"login"+File.separator+"cancle_n.jpg")); 
		btnCancle.setPreferredSize(new Dimension(73, 25));
		btnCancle.setPressedIcon(new ImageIcon("res"+File.separator+"login"+File.separator+"cancle_p.jpg")); 
		btnCancle.setRolloverIcon(new ImageIcon("res"+File.separator+"login"+File.separator+"cancle_p.jpg")); 

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(112, 112, 112).addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(27, 27, 27).addComponent(btnCancle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(99, 99, 99)).addGroup(GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(145, 145, 145).addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jpfPwd, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								167, Short.MAX_VALUE).addComponent(jtfUid, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)).addGap(72, 72, 72)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(64, 64, 64).addComponent(jtfUid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jpfPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnCancle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)).addContainerGap(31, Short.MAX_VALUE)));

		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的大小
		setBounds((screenSize.width - 360) / 2, (screenSize.height - 224) / 2, 360, 224); 
		
	}// 组件添加完毕

	// GEN-END:initComponents

	/**
	 * 添加监听方法
	 */
	public void addHandlers() {
		this.btnSubmit.addActionListener(new ActionListener() {
			//点击了登陆按钮，调用登录方法
			public void actionPerformed(ActionEvent e) {
					login();
			}
		});
		
		this.btnCancle.addActionListener(new ActionListener() {
			//点击了退出按钮，程序结束
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
	}

	
	private void login(){
		Action action = new Action();
		//		判断输入框中登录名和登录密码是否为空，若为空则返回
		if(jtfUid.getText().trim().equals("") || new String(jpfPwd.getPassword()).trim().equals("")){
			JOptionPane.showMessageDialog(this,"登录名和登录密码不能为空");
			return;
		}
		String name = jtfUid.getText().trim();
		String pwd =new String(jpfPwd.getPassword());
		User user=new User(name,pwd);
		Request req = new Request(Request.LOGIN_REQUEST);
		req.addData("user", user);
		Response res = action.doAction(req);
		User user1 = (User)res.getData("result");

		if(user1.getRole_id()>=1){
			LoginFrame.onlineUsers.put("user",user1);
			System.out.println("succeeded!");
//			switch(user1.getRole_id()){
//			case 7:
//				break;
//			case 6:
//				break;
//			case 5:
//				break;
//			case 4:
//				break;
//			case 3:
//				break;
//			case 2:
//				break;
//			case 1:
//				break;
//			}
			if (user1.getRole_id() >= 3) {
				com.tolo.tabcs.manage.gui.MainFrame maneger = new com.tolo.tabcs.manage.gui.MainFrame();
				maneger.showMe();
				maneger.setVisible(true);
				this.setVisible(false);
			} else {
				com.tolo.tabcs.business.gui.MainFrame business = new com.tolo.tabcs.business.gui.MainFrame();
				business.showMe();
				business.setVisible(true);
				this.setVisible(false);
			}
		}else if(user1.getRole_id()==0){
			System.out.println("failed");
			JOptionPane.showMessageDialog(LoginFrame.this, "没有该用户！请重新输入！");
		}else {
			JOptionPane.showMessageDialog(LoginFrame.this, "登录失败！");
			System.out.println("filter,failed");
		}
	}

	private void showMe() {
		this.setVisible(true);//设置窗口可见
		this.setResizable(false); //设置窗口不可移动
		setSize(357,213); //设置窗口大小
	}

	/**
	 * @param args
	 *  程序运行
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame().showMe();
			}
		});
	}

	// GEN-BEGIN:variables
}