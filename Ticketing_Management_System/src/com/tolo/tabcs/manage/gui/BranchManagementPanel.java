package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.*;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.util.CollectionUtils;


public class BranchManagementPanel extends JPanel {

	/**
	 * 管理界面
	 */
	private static final long serialVersionUID = -5025550840037339852L;
	private JLabel[] jls;//标签组
	private JTextField jtf;//文本框
	private JComboBox[] jcbs;//下拉框组
	private JTable jt;//表
	private JScrollPane jsp;//滚动面板
	private JButton[] jbs;//按钮组
	private JPanel[] jps;//上下两个面板
	private Frame owner;
	
	/*
	 * 构造方法
	 */
	public BranchManagementPanel(Frame owner){
		this.owner = owner;
		
		
		init();
		setLayout();
		addListener();
	}

	/*
	 * 初始化
	 */
	@SuppressWarnings("unchecked")
	private void init() {
		jls = new JLabel[4];//标签组
		jls[0] = new JLabel("网点编号");
		jls[1] = new JLabel("省份");
		jls[2] = new JLabel("城市");
		jls[3] = new JLabel("网点名称");
		jtf = new JTextField(10);//文本框,为输入编号准备
		jcbs = new JComboBox[3];//下拉框组
		for(int i = 0;i < jcbs.length;i++){
			jcbs[i] = new JComboBox();
			jcbs[i].addItem("-请选择-");//应该有个单独的方法，从数据库中读出各个网点信息加入这里
			String[] s = getNames(i);
			for(int j =0;j<s.length;j++){
				jcbs[i].addItem(s[j]);
			}
		}
//		StringBuilder s = new StringBuilder("四川");
//		jcbs[0].addItem(s);
//		jcbs[0].addItem("广东");
//		jcbs[0].addItem("浙江");
//		jcbs[0].addItem("北京");
//		
//		jcbs[1].addItem("广州");
//		jcbs[1].addItem("成都");
//		jcbs[1].addItem("宁波");
//		jcbs[1].addItem("北京");
		
		String[][] stri=new String[100][7];
		jt = new JTable(stri,new String[]{
				"网点编号","省份","城市","网点名称","地址","电话","经理编号"
		});//表
		
		
//		jt.setValueAt("1001", 2, 1);
		jsp = new JScrollPane(jt);//滚动面板
		jbs = new JButton[4];//按钮组
		jbs[0] = new JButton("查询");
		jbs[1] = new JButton("添加新营业网点");
		jbs[2] = new JButton("删除营业网点");
		jbs[3] = new JButton("更改营业网点");
		jps = new JPanel[2];//上下两个面板
		jps[0] = new JPanel();
		jps[1] = new JPanel();
	}

	/*
	 * 整体布局
	 */
	private void setLayout() {
		this.setLayout(new BorderLayout());//设定为BorderLayout
		this.add(jps[0],BorderLayout.NORTH);//查询条件放在北边
		jps[0].setLayout(new FlowLayout(10));//设定查询条件的布局是流式布局
		((FlowLayout)jps[0].getLayout()).setAlignment(FlowLayout.CENTER);
		jps[0].add(jls[0]);
		jps[0].add(jtf);
		jps[0].add(jls[1]);
		jps[0].add(jcbs[0]);
		jps[0].add(jls[2]);
		jps[0].add(jcbs[1]);
		jps[0].add(jls[3]);
		jps[0].add(jcbs[2]);
		jps[0].add(jbs[0]);//增加一系列查询条件
		
		this.add(jsp,BorderLayout.CENTER);//将表加到中间
		
		this.add(jps[1],BorderLayout.SOUTH);//将增删改操作面板加到南边
		FlowLayout fl = new FlowLayout(10);
		fl.setAlignment(FlowLayout.CENTER);//流式布局的排布方式是居中
		jps[1].setLayout(fl);//按钮的排布也按照流式布局
		jps[1].add(jbs[1]);
		jps[1].add(jbs[2]);
		jps[1].add(jbs[3]);//将操作按钮加入操作面板
	}
	
	/*
	 * 监听的设置类
	 */         
	private void addListener() {
		jcbs[0].addItemListener(new ItemListener(){

			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				String s=((String) jcbs[0].getSelectedItem()).trim();
				
				
			}
		});
		
		
		jcbs[1].addItemListener(new ItemListener(){
			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( jcbs[1].getSelectedItem()==null){
						return;
				}
				String s=((String) jcbs[1].getSelectedItem()).trim();

			
			}
		});
		
		
		
		jbs[0].addActionListener(new ActionListener(){//查询按钮
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {

				if(!(jtf.getText().trim().equals(""))){
					showSome();
				}else if((String)jcbs[2].getSelectedItem()!="-请选择-"){
					showByBranchName();
				}else if((String)jcbs[1].getSelectedItem()!="-请选择-"){
					showByCity();
			}else if((String)jcbs[0].getSelectedItem()!="-请选择-"){
				showByProvince();
			}
			}
		});
		
		jbs[1].addActionListener(new ActionListener(){//添加按钮监听
			public void actionPerformed(ActionEvent arg0) {
				new AddBranchDialog(owner).setVisible(true);
			}
		});
		jbs[2].addActionListener(new ActionListener(){//删除营业网点监听 
			public void actionPerformed(ActionEvent arg0) {
				new RemoveBranchDialog(owner).setVisible(true);
			}
		});
		jbs[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new EditBranchDialog(owner).setVisible(true);
				
			}
		});
	}
	public void showSome(){
		
			Action action = new Action();
			Request req = new Request(Request.SEARCH_BRANCH_REQUEST);
			if(!(jtf.getText().trim().equals(""))){
				int branch_id = Integer.parseInt(jtf.getText());
				System.out.println(branch_id);
				Branch branch = new Branch(branch_id);
				req.addData("branch", branch);
//				 int branch_id1 = branch.getBranch_id();
				Response res = action.doAction(req);
				if(res.getData("result")!=null){
//					DefaultTableModel model = (DefaultTableModel)this.jt.getModel();
//					int numT;
//					numT = model.getRowCount();
//					while(numT>0){
//						model.removeRow(0);
//						numT--;
//					}//该方法不行，强制类型转换错误
					Branch[] branches = (Branch[])res.getData("result");
					for(int m=0;m<7;m++){
						for(int n=0;n<7;n++){
							jt.setValueAt("",m,n);
						}
					}
					jt.setValueAt(String.valueOf(branches[0].getBranch_id()), 0, 0);
					jt.setValueAt(branches[0].getProvince_name(), 0, 1);
					jt.setValueAt(branches[0].getCity_name(), 0, 2);
					jt.setValueAt(branches[0].getBranch_name(), 0, 3);
					jt.setValueAt(branches[0].getBranch_address(), 0, 4);
					jt.setValueAt(branches[0].getBranch_telephone1(), 0, 5);
					jt.setValueAt(String.valueOf(branches[0].getUser_id()), 0, 6);
//				System.out.println("rows "+jt.getRowCount());
				}else{
					System.out.println("nothing!");
				}
			}else{
				System.out.println("no information");
			}

	}
	
	public void showByProvince(){
		String province_name = (String)jcbs[0].getSelectedItem();
		Branch branch = new Branch();
		branch.setProvince_name(province_name);
		Action action = new Action();
		Request req = new Request(Request.SEARCH_BRANCH_REQUEST);
		req.addData("branch", branch);
		Response res = action.doAction(req);
		if(res.getData("result")!=null){
			Branch[] branches = (Branch[])res.getData("result");
			for(int m=0;m<10;m++){
				for(int n=0;n<7;n++){
					jt.setValueAt("",m,n);
				}
			}
			int rows=branches.length;
			for(int i=0; i<rows;i++){
				jt.setValueAt(String.valueOf(branches[i].getBranch_id()), i, 0);
				jt.setValueAt(branches[i].getProvince_name(), i, 1);
				jt.setValueAt(branches[i].getCity_name(), i, 2);
				jt.setValueAt(branches[i].getBranch_name(), i, 3);
				jt.setValueAt(branches[i].getBranch_address(), i, 4);
				jt.setValueAt(branches[i].getBranch_telephone1(), i, 5);
				jt.setValueAt(String.valueOf(branches[i].getUser_id()), i, 6);
			}
//		System.out.println("rows "+jt.getRowCount());
		}else{
			System.out.println("nothing!");
		}
	}
	public void showByCity(){
		String city_name = (String)jcbs[1].getSelectedItem();
		Branch branch = new Branch();
		branch.setCity_name(city_name);
		Action action = new Action();
		Request req = new Request(Request.SEARCH_BRANCH_REQUEST);
		req.addData("branch", branch);
		Response res = action.doAction(req);
		if(res.getData("result")!=null){
			Branch[] branches = (Branch[])res.getData("result");
			for(int m=0;m<7;m++){
				for(int n=0;n<7;n++){
					jt.setValueAt("",m,n);
				}
			}
			int rows=branches.length;
//			System.out.println("rows"+rows);

			for(int i=0; i<rows;i++){
				jt.setValueAt(String.valueOf(branches[i].getBranch_id()), i, 0);
				jt.setValueAt(branches[i].getProvince_name(), i, 1);
				jt.setValueAt(branches[i].getCity_name(), i, 2);
				jt.setValueAt(branches[i].getBranch_name(), i, 3);
				jt.setValueAt(branches[i].getBranch_address(), i, 4);
				jt.setValueAt(branches[i].getBranch_telephone1(), i, 5);
				jt.setValueAt(String.valueOf(branches[i].getUser_id()), i, 6);
			}
	}
	}
	public void showByBranchName(){
		String branch_name = (String)jcbs[2].getSelectedItem();
		Branch branch = new Branch();
		branch.setBranch_name(branch_name);
		Action action = new Action();
		Request req = new Request(Request.SEARCH_BRANCH_REQUEST);
		req.addData("branch", branch);
		Response res = action.doAction(req);
		if(res.getData("result")!=null){
			Branch[] branches = (Branch[])res.getData("result");
			for(int m=0;m<7;m++){
				for(int n=0;n<7;n++){
					jt.setValueAt("",m,n);
				}
			}
			int rows=branches.length;
			for(int i=0; i<rows;i++){
				jt.setValueAt(String.valueOf(branches[i].getBranch_id()), i, 0);
				jt.setValueAt(branches[i].getProvince_name(), i, 1);
				jt.setValueAt(branches[i].getCity_name(), i, 2);
				jt.setValueAt(branches[i].getBranch_name(), i, 3);
				jt.setValueAt(branches[i].getBranch_address(), i, 4);
				jt.setValueAt(branches[i].getBranch_telephone1(), i, 5);
				jt.setValueAt(String.valueOf(branches[i].getUser_id()), i, 6);
			}

	}
	}
	private String[] getNames(int i){
		String[] arr1 = new String[]{};
		String sql;
		String name;
		if(i==0){
			sql = "select distinct province_name from finished_branch_hyj";
			name = "province_name";
		}else if(i==1){
			sql = "select distinct city_name from finished_branch_hyj";
			name = "city_name";
		}else{
			sql = "select distinct branch_name from finished_branch_hyj";
			name = "branch_name";
		}
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				arr1 = Arrays.copyOf(arr1, arr1.length+1);
				arr1[arr1.length-1] = rs.getString(name);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr1;
		
	}

}
