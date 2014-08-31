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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.AppliedRecord;
import com.tolo.tabcs.common.gui.CheckBoxRenderer;
import com.tolo.tabcs.common.gui.CheckButtonEditor;
import com.tolo.tabcs.common.gui.LoginFrame;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

/**
 * @author TangLiang
 */

@SuppressWarnings("serial")
public class BusiAccountForManagerA extends JPanel{
	private JLabel title;
	private JTable table;
	private JScrollPane tableScrollPane;//中间用于存放Table的滚动面板。
	private JLabel message;//显示当前选中的营业记录信息
	private JButton settleAccountsButton,showListButton,chooseAllButton,clearButton,chooseButton;
	private JCheckBox[] checkBoxs;
	private JButton refresh;
	private List<String> flist;//处理过的记录
//	private double money;
	private int m;
	private double allMoney1;
	private double allMoney2;
	private int num;
	private int num1;
	private int num2;
	//private int num3;
	/**构造方法
	 * 初始化各种标签，按钮
	 * */
	public BusiAccountForManagerA(){
		title=new JLabel("营业员申请结算的营业记录：");
		String[] col=new String[]{"选择","营业员","申请结算的记录笔数/金额","未提交的记录笔数/金额"};
		Object[][] date=new Object[50][col.length];

//		JScrollPane滚动面板和表的初始化，并将表添加到面板中。
		
		checkBoxs=new JCheckBox[date.length];
		for(int i=0;i<date.length;i++){
			checkBoxs[i]=new JCheckBox(); 
			date[i][0] = checkBoxs[i];
		}
		
		table=new JTable(date,col);

		table.getColumn(table.getColumnName(0)).setCellEditor(new CheckButtonEditor(new JCheckBox()));
		table.getColumn(table.getColumnName(0)).setCellRenderer(new CheckBoxRenderer());
		table.getColumn(table.getColumnName(0)).setMaxWidth(30);
		
		table.getColumn(table.getColumnName(1)).setMaxWidth(60);
//		table.getColumn(table.getColumnName(2)).setMaxWidth(100);
//		table.getColumn(table.getColumnName(3)).setMaxWidth(80);
//		table.getColumn(table.getColumnName(4)).setMaxWidth(80);
		tableScrollPane=new JScrollPane(table);
		
		message=new JLabel("共选中0项结算申请，总共0项营业记录,合计金额：0元");
		message.setForeground(Color.RED);
		//JButton的初始化
		settleAccountsButton=new JButton("确认结算>>");
		showListButton=new JButton("查看明细");
		chooseAllButton=new JButton("全选");
		clearButton=new JButton("清除");
		chooseButton=new JButton("反向选择");
		refresh=new JButton("刷新");
		init();  //设置面板
		addEventListener();
		for(int i=0;i<50;i++){
			for(int j=1;j<4;j++){
				table.setValueAt("",i,j);
			}
		}
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
		
		buttonPanelLeft.add(chooseAllButton);
		buttonPanelLeft.add(clearButton);
		buttonPanelLeft.add(chooseButton);
		buttonPanelRight.add(refresh);//向按钮面板添加刷新按钮。
		buttonPanelRight.add(settleAccountsButton);//向按钮面板添加结算按钮。
		
		buttonPanel.add(buttonPanelLeft);
		buttonPanel.add(buttonPanelRight);
		
		JPanel messagePanel=new JPanel();
		messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		messagePanel.add(message);
		messagePanel.add(showListButton);
		
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
			for(int j=1;j<table.getColumnCount();j++){
				table.setValueAt("", i, j);
			}
		}
	}

	private void addEventListener(){
		chooseAllButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				table.repaint();
				
				for(int i=0;i<checkBoxs.length;i++){
					if(table.getValueAt(i, 1)!=""){
						checkBoxs[i].setSelected(true);
					}
				}
				table.repaint();
				showMessage();
			}
			
		});
		clearButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				table.repaint();
				showMessage();
			}
			
		});
		chooseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(!checkBoxs[i].isSelected());
				}
				table.repaint();
				showMessage();
			}
		});
		
		refresh.addActionListener(new ActionListener(){

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++){
					for(int j=1;j<table.getColumnCount();j++){
						table.setValueAt("", i, j);
					}
				}
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				table.repaint();
				flist=new ArrayList<String>();
				Action action = new Action();
				Request req = new Request(Request.APPLIED_AND_UNAPPLIED_REQUEST);
				req.addData("user",LoginFrame.onlineUsers.get("user"));
				Response res = action.doAction(req);
				if (res.getData("result")!=null){
					 AppliedRecord[] record = (AppliedRecord[])res.getData("result");
					System.out.println("got data succeeded!");
					int rows= record.length;
					for(int i=0; i<rows;i++){
				table.setValueAt(String.valueOf(record[i].getSeller_id()), i, 1);
					table.setValueAt(record[i].getApplied_count()+"/"+record[i].getApplied_sum(), i, 2);
					table.setValueAt(record[i].getUnapplied_count()+"/"+record[i].getUnapplied_sum(), i, 3);
				}
				}
//				res.getData("result");
				int count=0;
				double money1=0;
				
				}

//				for(int i=0;i<count1.length;i++){
//					System.out.println("count1[i]"+count1[i]);
//				}
//				for(int i=0;i<count2.length;i++){
//					System.out.println("count2[i]"+count2[i]);
//				}
			
		});
		
		settleAccountsButton.addActionListener(new ActionListener(){

			@SuppressWarnings({ "unchecked", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				if(flist==null){				
//					return;
//				}
//				if(flist.size()==0){
//					return; 
//				}
//				for(int i=0;i<flist.size();i++){
//					System.out.println("ffflist=="+flist.get(i));
//				}
//				List<String> list1=new ArrayList<String>();//选中的记录；
//				List<String> list2=new ArrayList<String>();//未选中的记录；
//				for(int i=0;i<flist.size();i++){
//					if(checkBoxs[i].isSelected()){
//						list1.add(flist.get(i));
//					}else{
//						list2.add(flist.get(i));
//					}		
//				}
//				for(int i=0;i<list2.size();i++){
//					System.out.println("list2222222=="+list2.get(i));
//				}
//				flist=list2;
				List<Integer> list1=new ArrayList<Integer>();//选中的记录；
				for(int i=0;i<20;i++){
				if(checkBoxs[i].isSelected()){
					int id = Integer.parseInt((String)table.getValueAt(i, 1));
					list1.add(id);
				}
				}
				Action action = new Action();
				Request req=new Request(Request.CONFIRM_FIRST_BALANCE_REQUEST);
				Date date=new Date();
				String str0 = date.getYear()+1900+"";
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
				String str=str0+"-"+str2+"-"+str3+" "+str4+":"+str5+":"+str6;
				req.addData("user", LoginFrame.onlineUsers.get("user"));
				req.addData("list",list1);
				req.addData("date",str);
				System.out.println("the date is "+str);
				System.out.println("the list1 is "+list1);
				Response res = action.doAction(req);
				if((Boolean)res.getData("result")){
					JOptionPane.showMessageDialog(BusiAccountForManagerA.this,	"一级结算成功!!!");

				for(int i=0;i<50;i++){
					for(int j=1;j<4;j++){
						table.setValueAt("",i,j);
					}
				}
				
//				for(int i=0;i<flist.size();i++){
//					String[] str1=flist.get(i).split(":");
//					System.out.println("ffflist=="+flist.get(i));
//					for(int j=0;j<str1.length;j++){
//						table.setValueAt(str1[j],i,j+1);
//					}
				}	else {
					JOptionPane.showMessageDialog(BusiAccountForManagerA.this,	"一级结算失败!!!");
				}
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				table.repaint();
				showMessage();
				//message.setText("共"+has.size()+"项结算申请，总共"+count+"项营业记录,合计金额："+money1+"元");
			}
		});
		
		showListButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Request req = new Request(Request.SEARCH_SALES_RECORD_REQUEST);
				req.addData("user",LoginFrame.onlineUsers.get("user"));
			}		
		});
		
		for(m=0;m<checkBoxs.length-1;m++){
			checkBoxs[m].addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e) {
					showMessage();
				}		
			});
		}
	}
	private void showMessage(){
		allMoney1=0;
		allMoney2=0;
		num=0;
		num1=0;
		num2=0;
	//	num3=0;
		for(int i=0;i<checkBoxs.length;i++){
			if(checkBoxs[i].isSelected()&&table.getValueAt(i, 1)!=""){
				num2++;
				allMoney1+=new Double(((String)table.getValueAt(i, 2)).split("/")[1]);
				allMoney2+=new Double(((String)table.getValueAt(i, 3)).split("/")[1]);
				num+=Integer.valueOf(((String)table.getValueAt(i, 2)).split("/")[0]);
				num1+=Integer.valueOf(((String)table.getValueAt(i, 3)).split("/")[0]);
			}
		}
		message.setText("共选中"+num+"项结算申请，总共"+(num+num1)+"项营业记录,"+"合计金额："+(allMoney1+allMoney2)+"元");
	}
}
