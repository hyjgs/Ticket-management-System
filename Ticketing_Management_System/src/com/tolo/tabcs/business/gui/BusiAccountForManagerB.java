package com.tolo.tabcs.business.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tolo.tabcs.common.gui.LoginFrame;
import com.tolo.tabcs.common.pro.Request;

/**
 * @author TangLiang
 */

@SuppressWarnings("serial")
public class BusiAccountForManagerB extends JPanel{
	private JLabel title;
	private JTable table;
	private JScrollPane tableScrollPane;//中间用于存放Table的滚动面板。
	//private JLabel message;//显示当前选中的营业记录信息
	private JButton settleAccountsButton,showListButton,chooseAllButton,clearButton,chooseButton;
	private JCheckBox[] checkBoxs;
	private JButton refresh;
	private  List<String> list=new ArrayList<String>();
	private int num;
	private double money;
	
	/**构造方法
	 * 初始化各种标签，按钮
	 * */
	public BusiAccountForManagerB(){
		title=new JLabel("本网点已完成一级结算的营业记录：");
		String[] col=new String[]{"记录发生日期","总笔数/金额","已完成一级结算的笔数/金额","未完成一级结算的笔数/金额"};
		Object[][] date=new Object[50][col.length];

//		JScrollPane滚动面板和表的初始化，并将表添加到面板中。
		
		table=new JTable(date,col);

		table.getColumn(table.getColumnName(0)).setMaxWidth(100);
		table.getColumn(table.getColumnName(1)).setMaxWidth(90);
		tableScrollPane=new JScrollPane(table);
		
		//message=new JLabel("总共0项营业记录,合计金额：0元");
		//message.setForeground(Color.RED);
		//JButton的初始化
		settleAccountsButton=new JButton("申请二级结算>>");
		showListButton=new JButton("查看明细");
		chooseAllButton=new JButton("全选");
		clearButton=new JButton("清除");
		chooseButton=new JButton("反向选择");
		refresh=new JButton("刷新");
      
		init();  //设置面板
		addEventListener();
	}
	/**
	 * 添加各面板组件
	 * 设置面板布局
	 * */
	public void init(){
//设置面板布局BorderLayout
		
		//定义北边面板并添加title。
		JPanel titlePanel=new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		title.setFont(new Font("宋体",Font.BOLD,20));
		title.setForeground(Color.BLUE);
		titlePanel.add(title);
		
		Box box=new Box(BoxLayout.Y_AXIS);

        //定义按钮面板并添加组件，南边面板使用默认的FlowLayout布局。设置结算按钮。
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		
		JPanel buttonPanelLeft=new JPanel();
		buttonPanelLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel buttonPanelRight=new JPanel();
		buttonPanelRight.setLayout(new FlowLayout(FlowLayout.CENTER));

		// buttonPanelLeft.add(chooseAllButton);
		// buttonPanelLeft.add(clearButton);
		// buttonPanelLeft.add(chooseButton);
		// buttonPanelRight.add(refresh);//向按钮面板添加刷新按钮。
		// buttonPanelRight.add(settleAccountsButton);//向按钮面板添加结算按钮。
		
		buttonPanel.add(buttonPanelLeft);
		buttonPanel.add(buttonPanelRight);
		
		JPanel messagePanel=new JPanel();
		messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//messagePanel.add(message);
		messagePanel.add(showListButton);
		messagePanel.add(settleAccountsButton);
		messagePanel.add(refresh);
		
		box.add(titlePanel);
		box.add(tableScrollPane);
		box.add(buttonPanel);
		box.add(messagePanel);
		
		//设置面板布局BorderLayout，将方向面板添加到总面板中
//		this.setLayout(new BorderLayout());
//		this.add(northPanel,BorderLayout.NORTH);
		this.add(box);
//		this.add(messagePanel,BorderLayout.SOUTH);
		for(int i=0;i<table.getRowCount();i++){
			for(int j=0;j<table.getColumnCount();j++){
				table.setValueAt("", i, j);
			}
		}
	}

	private void addEventListener(){
		chooseAllButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(true);
				}
				table.repaint();
			}
		});
		clearButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				table.repaint();
			}
		});
		chooseButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(!checkBoxs[i].isSelected());
				}
				table.repaint();
			}
		});
		

		settleAccountsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Request req = new Request(Request.APPLY_SECOND_BALANCE_REQUEST);
				req.addData("user",LoginFrame.onlineUsers.get("user"));
			}	
		});
		
		showListButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Request req = new Request(Request.SEARCH_SALES_RECORD_REQUEST);
				req.addData("user",LoginFrame.onlineUsers.get("user"));
			}		
		});
		
		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<table.getRowCount();i++){
					for(int j=0;j<table.getColumnCount();j++){
						table.setValueAt("", i, j);
					}
				}
				Request req = new Request(Request.SEARCH_SALES_RECORD_REQUEST);
				req.addData("user",LoginFrame.onlineUsers.get("user"));
				//System.out.println(((User)LoginFrame.onlineUsers.get("user")).getUser_id());
				int nm=0;
				int nm1=0;
				money=0;
				num=0;
				Date date=new Date();
				String str1 = date.getYear()+1900+"";
				String str2 = date.getMonth() + 1 + "";
				String str3 = date.getDate() + "";
				String str4 = date.getHours()+"";
				String str5 = date.getMinutes()+"";
				String str6 = date.getSeconds()+"";
				
				if (Integer.valueOf(str2) < 10) {
					str2 = "0" + str2;
				}

				if (Integer.valueOf(str3) < 10) {
					str3 = "0" + str3;
				}
				if (Integer.valueOf(str4) < 10) {
					str4 = "0" + str4;
				}
				if (Integer.valueOf(str5) < 10) {
					str5 = "0" + str5;
				}
				if (Integer.valueOf(str6) < 10) {
					str6 = "0" + str6;
				}
				String str=str1+"-"+str2+"-"+str3+" "+str4+":"+str5+":"+str6;
				
				//String str=date.getYear()+1900+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
				table.setValueAt(str, num, 0);
				table.setValueAt(nm+nm1+"/"+money, num, 1);
				table.setValueAt(nm, num, 2);
				table.setValueAt(nm1, num, 3);
				num++;
			}
			
		});
	}
}
