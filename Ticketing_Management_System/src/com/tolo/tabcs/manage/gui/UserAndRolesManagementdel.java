package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class UserAndRolesManagementdel {
	private JFrame frame;
	private JLabel title,title1,title2,title3,title4,title5,title6,title7,title8,title9,title10,title11;
	private JTextField nameField;
	private JCheckBox checkbox,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7;
	private JButton ok,cannel;
	private Action action;
	public UserAndRolesManagementdel(String s){
		action=new Action();
		frame=new JFrame("修改角色");
		title=new JLabel("角色修改");
		title1=new JLabel("角色名");
		title2=new JLabel(" >权限");
		title3=new JLabel("  (1)营业权限");
		title4=new JLabel("      >营业员");
		checkbox=new JCheckBox("购票，退票等");
		title5=new JLabel("      >网点经理 ");
		checkbox2=new JCheckBox("确认一级结算，申请二级结算等");
		
		title6=new JLabel("  (2)管理权限");
		title7=new JLabel("      >营业员管理");
		checkbox3=new JCheckBox("添加营业员，删除营业员");
		title8=new JLabel("      >航线管理");
		checkbox4=new JCheckBox("添加航线，删除航线");
		title9=new JLabel("      >航班管理");
		checkbox5=new JCheckBox("添加航班，删除航班");
		title10=new JLabel("     >财务管理");
		checkbox6=new JCheckBox("查询所有营业记录");
		title11=new JLabel("     >系统管理");
		checkbox7=new JCheckBox("创建帐户，删除帐户");
		
		ok=new JButton("确定");
		cannel=new JButton("取消");
		
		
		nameField=new JTextField(8);
		title.setFont(new Font("宋体",Font.BOLD,24));
		title.setForeground(Color.red);
		nameField.setText(s);
		nameField.setEnabled(false);
		init();
	}
	
	private void init(){
		JPanel n_panel=new JPanel();
		n_panel.setLayout(new FlowLayout());
		n_panel.add(title);
		JPanel c_panel=new JPanel(new FlowLayout());
		c_panel.add(title1);
		c_panel.add(nameField);
		JPanel s_panel=new JPanel();
		
		JPanel s_panel1=new JPanel(new BorderLayout());//	title2=new JLabel(" >权限");
		s_panel1.add(title2);
		title2.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel2=new JPanel(new BorderLayout());//		title3=new JLabel("  (1)营业权限");
		s_panel2.add(title3);
		title3.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel3=new JPanel(new BorderLayout());//		title4=new JLabel("      >营业员");
		s_panel3.add(title4);
		title4.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel4=new JPanel(new FlowLayout());//		checkbox=new JCheckBox("购票，退票等");
		s_panel4.add(checkbox);
		
		JPanel s_panel5=new JPanel(new BorderLayout());//		title5=new JLabel("      >网点经理 ");
		s_panel5.add(title5);
		title5.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel6=new JPanel(new FlowLayout());//		checkbox2=new JCheckBox("确认一级结算，申请二级结算等");
		s_panel6.add(checkbox2);
		
		JPanel s_panel7=new JPanel(new BorderLayout());	//	title6=new JLabel("  (2)管理权限");
		s_panel7.add(title6);
		title6.setHorizontalAlignment(JLabel.LEFT);

		JPanel s_panel8=new JPanel(new BorderLayout());	//title7=new JLabel("      >航班管理");
		s_panel8.add(title7);
		title7.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel9=new JPanel(new FlowLayout());	//	checkbox3=new JCheckBox("添加航班，删除航班");
		s_panel9.add(checkbox3);
		
		JPanel s_panel10=new JPanel(new BorderLayout());//		title8=new JLabel("      >营业员管理");
		s_panel10.add(title8);
		title8.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel11=new JPanel(new FlowLayout());		//checkbox4=new JCheckBox("添加营业员，删除营业员");
		s_panel11.add(checkbox4);
		
		JPanel s_panel12=new JPanel(new BorderLayout());	//	title9=new JLabel("      >系统管理");
		s_panel12.add(title9);
		title9.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel13=new JPanel(new FlowLayout());//		checkbox5=new JCheckBox("创建帐户，删除帐户");
		s_panel13.add(checkbox5);
		
		JPanel s_panel14=new JPanel(new BorderLayout());			//title10=new JLabel("      >财务管理");
		s_panel14.add(title10);
		title10.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel15=new JPanel(new FlowLayout());//				checkbox6=new JCheckBox("查询所有营业记录");
		s_panel15.add(checkbox6);
		
		JPanel s_panel16=new JPanel(new BorderLayout());	//		title11=new JLabel("     >航线管理");
		s_panel16.add(title11);
		title11.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel s_panel17=new JPanel(new FlowLayout());//		checkbox7=new JCheckBox("添加航线，删除航线");
		s_panel17.add(checkbox7);
		
		
		JPanel s_panel18=new JPanel(new FlowLayout());
		s_panel18.add(ok);
		s_panel18.add(cannel);
		cannel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
				
			}
			
		});
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				if(checkbox.isSelected()){
					i=i+1;
				}
				if(checkbox2.isSelected()){
					i=i+2;
				}
				if(checkbox3.isSelected()){
					i=i+4;
				}
				if(checkbox4.isSelected()){
					i=i+8;
				}
				if(checkbox5.isSelected()){
					i=i+16;
				}
				if(checkbox6.isSelected()){
					i=i+32;
				}
				if(checkbox7.isSelected()){
					i=i+64;
				}
				System.out.println("i==="+i);
				String name = nameField.getText().trim();
				System.out.println(name);
				Request req=new Request(Request.UPDATE_ROLE_AUT_REQUEST);
				Role role = new Role();
				role.setRole_privilege(i);
				role.setName(name);
				req.addData("updaterole", role);
//				req.addData("角色名", nameField.getText().trim());
//				req.addData("权限编号",i+"");
				Response res=action.doAction(req);
				boolean flag=(Boolean) res.getData("修改状态");
				if(flag){
					JOptionPane.showMessageDialog(null, "修改成功");
					exit();
				} else{
					JOptionPane.showMessageDialog(null, "修改失败");
					
				}
			}
			
		});
		
		frame.setLayout(new BorderLayout());
		frame.add(n_panel,BorderLayout.NORTH);
		frame.add(c_panel,BorderLayout.CENTER);
		frame.add(s_panel,BorderLayout.SOUTH);
		s_panel.setLayout(new BoxLayout(s_panel,BoxLayout.Y_AXIS));
		s_panel.add(s_panel1);
		s_panel.add(s_panel2);
		s_panel.add(s_panel3);
		s_panel.add(s_panel4);
		s_panel.add(s_panel5);
		s_panel.add(s_panel6);
		s_panel.add(s_panel7);
		s_panel.add(s_panel8);
		s_panel.add(s_panel9);
		s_panel.add(s_panel10);
		s_panel.add(s_panel11);
		s_panel.add(s_panel12);
		s_panel.add(s_panel13);
		s_panel.add(s_panel14);
		s_panel.add(s_panel15);
		s_panel.add(s_panel16);
		s_panel.add(s_panel17);
		s_panel.add(s_panel18);
		
	
	}
	
	public void exit(){
		frame.dispose();
	}
	
	public void showMe(){
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(500, 200, 270, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
//	public static void main(String[] args){
//		new UserAndRolesManagementdel("hahaha").showMe();
//	}

}
