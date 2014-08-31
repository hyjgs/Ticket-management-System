package com.tolo.tabcs.business.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.gui.CheckBoxRenderer;
import com.tolo.tabcs.common.gui.CheckButtonEditor;
import com.tolo.tabcs.common.gui.LoginFrame;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

/**
 * 
 * @author TangLiang
 *
 */
@SuppressWarnings("serial")
public class BusiAccountForSalesB extends JPanel{
	private JLabel title;
	private static JTable table;
	private JScrollPane tableScrollPane;//中间用于存放Table的滚动面板。
	private JLabel message;//显示当前选中的营业记录信息
	private JButton settleAccountsButton,chooseAllButton,clearButton,chooseButton;
	private JCheckBox[] checkBoxs;
	private JButton refresh;
	private int m;
	private double allMoney;
	private int num;
	private int num1;
	private int num2;
	private int num3;
	private SalesRecord[] recordsAll;
	/**构造方法
	 * 初始化各种标签，按钮
	 * */
	public BusiAccountForSalesB(){
		title=new JLabel("等待确认结算的营业记录：");
		String[] col=new String[]{"选择","营业记录编号","记录发生时间","营业类型","金额"};
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
		
//		table.getColumn(table.getColumnName(1)).setMaxWidth(200);
//		table.getColumn(table.getColumnName(2)).setMaxWidth(200);
//		table.getColumn(table.getColumnName(3)).setMaxWidth(100);
//		table.getColumn(table.getColumnName(4)).setMaxWidth(100);
		
		tableScrollPane=new JScrollPane(table);
		
		message=new JLabel("共选中0笔营业记录，其中购票0，退票0，改签0；合计金额：0元");
		message.setForeground(Color.RED);
		//JButton的初始化
		settleAccountsButton=new JButton("<<撤销结算申请");
		refresh=new  JButton("刷新");
		chooseAllButton=new JButton("全选");
		clearButton=new JButton("清除");
		chooseButton=new JButton("反向选择");
      
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
		recordsAll = new SalesRecord[1];
		JPanel northPanel=new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		title.setFont(new Font("宋体",Font.BOLD,20));
		title.setForeground(Color.BLUE);
		northPanel.add(title);
		
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
		buttonPanelLeft.add(refresh);
		buttonPanelRight.add(settleAccountsButton);//向南边面板添加结算按钮。
		
		buttonPanel.add(buttonPanelLeft);
		buttonPanel.add(buttonPanelRight);
		
		box.add(tableScrollPane);
		box.add(buttonPanel);
		
		JPanel messagePanel=new JPanel();
		messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		messagePanel.add(message);
		
		//设置面板布局BorderLayout，将方向面板添加到总面板中
		this.setLayout(new BorderLayout());
		this.add(northPanel,BorderLayout.NORTH);
		this.add(box,BorderLayout.CENTER);
		this.add(messagePanel,BorderLayout.SOUTH);
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
					//System.out.println("fdddd="+table.getValueAt(i, 1));
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

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(!checkBoxs[i].isSelected());
				}
				table.repaint();
				showMessage();
			}
			
		});
		refresh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<table.getRowCount();i++){
					for(int j=1;j<table.getColumnCount();j++){
						table.setValueAt("", i, j);
					}
				}
				Action action = new Action();
				Request req = new Request(Request.SEARCH_WAITING_SALES_RECORD_REQUEST);
				//System.out.println(ServerMainClass.onlineUsers1.get("user_id"));
				//System.out.println(LoginFrame.onlineUsers.get("user_id"));
				req.addData("user_id",((User)LoginFrame.onlineUsers.get("user")).getId());
				req.addData("state","1");
				Response res = action.doAction(req);
				SalesRecord[] records =(SalesRecord[])res.getData("result");
//				System.out.println(records[0].toString());
				if (!(records.length==0)) {
					recordsAll = records;
					int rows=records.length;
//					System.out.println("records.length is"+rows);
					for(int i=0; i<rows;i++){
//						System.out.println("the current re is "+i);
						table.setValueAt(String.valueOf(records[i].getBuss_red_id()), i, 1);
						table.setValueAt(records[i].getBuss_red_date(), i, 2);
						table.setValueAt(records[i].getBuss_type(), i, 3);
						table.setValueAt(String.valueOf(records[i].getBuss_red_price()), i, 4);
					}
				} else {
					JOptionPane.showMessageDialog(BusiAccountForSalesB.this, "没有等待结算的记录");
				}
				int buy_num=0;//购票数量
				int back_num=0;//退票数量
				int update_num=0;//改签数量	
				double money=0;//总金额；
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				table.repaint();
				showMessage();
				//message.setText("共"+list.size()+"笔营业记录，其中购票"+buy_num+",退票"+back_num+",改签"+update_num+"；合计金额："+money+"元");
			}
		
		//	message=new JLabel();
		});
		
		for(m=0;m<checkBoxs.length-1;m++){
			
			checkBoxs[m].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showMessage();
			}
			
		});
		}
		settleAccountsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Action action = new Action();
				Request req = new Request(Request.CANCEL_WAITING_SALES_RECORD_REQUEST);
				req.addData("user_id",((User)LoginFrame.onlineUsers.get("user")).getId());

				for(int j=0;j<checkBoxs.length;j++){
//					System.out.println("the box's number"+j);
					if(checkBoxs[j].isSelected()){
//						System.out.println("the entered is "+j);
//						System.out.println("the value is "+table.getValueAt(j, 1));
						int id = Integer.parseInt((String)table.getValueAt(j, 1));
						System.out.println("the record id is "+id);
					req.addData("buss_red_id",id )	;
					}
				}
				Response res = action.doAction(req);
				boolean flag = (Boolean)res.getData("result");
				if(flag){
					JOptionPane.showMessageDialog(BusiAccountForSalesB.this,	"撤销结算成功，请等待结果");
				}else {
					JOptionPane.showMessageDialog(BusiAccountForSalesB.this,	"撤销结算失败，请重试");
				}
				for (int i = 0; i < 50; i++) {
					for (int j = 1; j < 5; j++) {
						table.setValueAt("", i, j);
					}
				}
				if (recordsAll.length == 0) {
					JOptionPane.showMessageDialog(BusiAccountForSalesB.this,	"没有未结算的记录");
				} else {
					int buy_num = 0;// 购票数量
					int back_num = 0;// 退票数量
					int update_num = 0;// 改签数量
					double money = 0;// 总金额
			//		message.setText("共"+list.size()+"笔营业记录，其中购票"+buy_num+",退票"+back_num+",改签"+update_num+"；合计金额："+money+"元");

					for (int i = 0; i < checkBoxs.length; i++) {
						checkBoxs[i].setSelected(false);
					}
					table.repaint();

					showMessage();
			}
			}
		});
	}
	
	private void showMessage(){
		allMoney=0;
		num=0;
		num1=0;
		num2=0;
		num3=0;
		// TODO Auto-generated method stub
		for(int i=0;i<checkBoxs.length;i++){
			if(checkBoxs[i].isSelected()&&table.getValueAt(i, 1)!=""){
				allMoney+=(Double)table.getValueAt(i, 4);
				num++;
				if(table.getValueAt(i, 3).equals("订票")){
					num1++;
				}else if(table.getValueAt(i, 3).equals("退票")){
					num2++;
				}else if(table.getValueAt(i, 3).equals("改签")){
					num3++;
				}
			}
		}
		message.setText("共选中" + num+"笔营业记录，其中订票" + num1+",退票"+ num2+",改签" + num3+"；合计金额：" +allMoney+"元");
	}
	
}
