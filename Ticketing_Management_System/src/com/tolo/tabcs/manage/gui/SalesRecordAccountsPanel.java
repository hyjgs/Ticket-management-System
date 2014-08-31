package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.gui.CheckBoxRenderer;
import com.tolo.tabcs.common.gui.CheckButtonEditor;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;


@SuppressWarnings("serial")
public class SalesRecordAccountsPanel extends JPanel{
	private JLabel Province,City,BusinessSite;
	//private JLabel Employee;
	private JComboBox ProvinceBox,CityBox,BusinessSiteBox;//标识营业网点和营业员的下拉列表
//	private Vector<String> BusinessSites,Provinces,Citys;// 存储营业网点等
	private JTable table;
	private JScrollPane tableScrollPane;//中间用于存放Table的滚动面板。
	private JButton searchButton,settleAccountsButton,chooseAllButton,clearButton,chooseButton;
	private JCheckBox[] checkBoxs;
	Action action = new Action();
	//private List<String> currentList;
	private JButton refresh;
	/**构造方法
	 * 初始化各种标签，按钮
	 * */
	public SalesRecordAccountsPanel(){
		
		String[] col=new String[]{"","营业网点编号","营业网点名称","营业网点经理","总笔数","总金额"};
		Object[][] date=new Object[20][col.length];
//		String temp="所有";
//		BusinessSites=new Vector<String>();
//		Provinces=new Vector<String>();
//		Citys=new Vector<String>();
//		BusinessSites.add(temp);
//		Provinces.add(temp);
//		Citys.add(temp);
		
		//JLabel的初始化
		Province=new JLabel("省(直辖市):");
		City=new JLabel("市:");
		BusinessSite=new JLabel("营业网点:");
	//	Employee=new JLabel("营业员:");
		//JScrollPane滚动面板和表的初始化，并将表添加到面板中。
		
		checkBoxs=new JCheckBox[date.length];
		for(int i=0;i<date.length;i++){
			checkBoxs[i]=new JCheckBox(); 
			date[i][0] = checkBoxs[i];
			
		}
		
		table=new JTable(date,col);
		tableScrollPane=new JScrollPane(table);
		table.getColumn(table.getColumnName(0)).setCellEditor(new CheckButtonEditor(new JCheckBox()));
		table.getColumn(table.getColumnName(0)).setCellRenderer(new CheckBoxRenderer());
		table.getColumn(table.getColumnName(0)).setMaxWidth(23);
		tableScrollPane=new JScrollPane(table);
		
		//JButton的初始化
		searchButton=new JButton("查询");
		settleAccountsButton=new JButton("确认二级结算");
		refresh=new JButton("刷新");
		//JComboBox的初始化
			ProvinceBox=new JComboBox();
			ProvinceBox.addItem("-请选择-");
			Request req = new Request(Request.SEARCH_PROVINCE_NAME_REQUEST);
			Response res = action.doAction(req);
			List list = (List)res.getData("查询省份");
			for(int i=0;i<list.size();i++){
				ProvinceBox.addItem(list.get(i));
			}
			CityBox=new JComboBox();
			CityBox.addItem("-请选择-");
			ProvinceBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					CityBox.removeAllItems();
					CityBox.addItem("-请选择-");
					Request req = new Request(Request.SEARCH_CITY_NAME_REQUEST);
					String province =(String) ProvinceBox.getSelectedItem();
					req.addData("省份下的城市名称", province);
					Response res = action.doAction(req); 
					List list1 = (List)res.getData("省份下的城市名称");
					for(int i=0;i<list1.size();i++){
						CityBox.addItem(list1.get(i));
					}
				}
			});
			
			BusinessSiteBox=new JComboBox();
			BusinessSiteBox.addItem("-请选择-");
			CityBox.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e) {
					BusinessSiteBox.removeAllItems();
					BusinessSiteBox.addItem("-请选择-");
					Request req = new Request(Request.SEARCH_BRANCH_NAME_REQUEST);
					String cityName = (String)CityBox.getSelectedItem();
					req.addData("城市下的网点", cityName);
					Response res = action.doAction(req);
					
					List list2 = (List)res.getData("城市下的网点");
//					/*System.out.println(list2);*/
					for(int i=0;i<list2.size();i++){
						BusinessSiteBox.addItem(list2.get(i));
					}
				}
				
			});
		

		
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
		
		//定义北边面板并添加组件，北边面板使用默认的FlowLayout布局。分别设置营业网点、营业员的标签和下拉列表，还添加了查询按钮。
		JPanel northPanel=new JPanel();
		
		northPanel.add(Province);
		northPanel.add(ProvinceBox);
		northPanel.add(City);
		northPanel.add(CityBox);
		northPanel.add(BusinessSite);//营业网点标签
		northPanel.add(BusinessSiteBox);//营业网点下拉列表
		//northPanel.add(Employee);//营业员标签
		northPanel.add(searchButton);//把查询按钮添加到北边面板
		
		Box box=new Box(BoxLayout.Y_AXIS);
		JPanel centerPanelD=new JPanel();
		centerPanelD.add(chooseAllButton);
		centerPanelD.add(clearButton);
		centerPanelD.add(chooseButton);
		box.add(tableScrollPane);
		box.add(centerPanelD);
		
        //定义南边面板并添加组件，南边面板使用默认的FlowLayout布局。设置结算按钮。
		JPanel southPanel=new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER,150,5));
		southPanel.add(settleAccountsButton);//向南边面板添加结算按钮。
		southPanel.add(refresh);//向南边面板添加结算按钮。
		
		//设置面板布局BorderLayout，将方向面板添加到总面板中
		this.setLayout(new BorderLayout());
		this.add(northPanel,BorderLayout.NORTH);
		this.add(box,BorderLayout.CENTER);
		this.add(southPanel,BorderLayout.SOUTH);
		
	}
	
	private List search() {
		String provinceName = (String)ProvinceBox.getSelectedItem();
		String cityName = (String)CityBox.getSelectedItem();
		String branchName = (String)BusinessSiteBox.getSelectedItem();
//		System.out.println("provinceName"+provinceName);
//		System.out.println("cityName"+cityName);
//		System.out.println("branchName"+branchName);
		Request req = new Request(Request.CONFIRM_SECOND_BALANCE_REQUEST);
		List list = null;
		if(branchName!="-请选择-"){
			req.addData("branchName", branchName);
			Response res = action.doAction(req);
			 list = (List) res.getData("CSBR_branch");
		}else if(cityName!="-请选择-"){
			req.addData("cityName",cityName);
			Response res = action.doAction(req);
			list = (List) res.getData("CSBR_city");
		}else if(provinceName!="-请选择-"){
			req.addData("provinceName",provinceName);
			Response res = action.doAction(req);
			list = (List)res.getData("CSBR_province");
			
		}else{
			Response res = action.doAction(req);
			list = (List)res.getData("CSBR");
//			System.out.println(list);
		}
		for(int m=0;m<20;m++){
			for(int n=1;n<6;n++){
				table.setValueAt("",m,n);
			}
		}
		for(int i = 0;i<list.size();i++){
			Branch branch = (Branch) list.get(i);
			table.setValueAt(branch.getBranch_id()+"", i, 1);
			table.setValueAt(branch.getBranch_name(), i, 2);
			table.setValueAt(branch.getUser_id()+"", i, 3);
			table.setValueAt(branch.getCount()+"", i, 4);
			table.setValueAt(branch.getPrice()+"", i, 5);
		}
//		System.out.println(list);
//		List list1 = (List)list.get(0);
//		List list2 = (List)list.get(1);
//		List list3 = (List)list.get(2);
//		List list4 = (List)list.get(3);
//		List list5 = (List)list.get(4);
//		for(int m=0;m<20;m++){
//			for(int n=1;n<6;n++){
//				table.setValueAt("",m,n);
//			}
//		}
//		int j = 0;
//		for(int i=0;i<list.size();i++){
//			table.setValueAt(String.valueOf(list.get(j++)), i, 1);
//			table.setValueAt(String.valueOf(list.get(j++)), i, 2);
//			table.setValueAt(String.valueOf(list.get(j++)), i, 3);
//			table.setValueAt(String.valueOf(list.get(j++)), i, 4);
//			table.setValueAt(String.valueOf(list.get(j++)), i, 5);
//		}
//		int k = 0;
//		for(int j = 0;j<(list.size())/5;j++){
//			for(int i=1;i<6;i++){
//				table.setValueAt(String.valueOf(list.get(k++)), j, i);
//			}
		

		return list;	
	}
	private void addEventListener(){
		settleAccountsButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean result = settleAccounts();
				if(result == true){
					JOptionPane.showMessageDialog(SalesRecordAccountsPanel.this, "确认二级结算成功！");
				}else{
					JOptionPane.showMessageDialog(SalesRecordAccountsPanel.this, "请重新结算！");
				}
				
			}
			
		});
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//System.out.println("jinlaimei");
				List list = search();
			    if(list.size()==0){
							JOptionPane.showMessageDialog(SalesRecordAccountsPanel.this, "没有该网点记录");
						return; 
				}
			}
		});
		
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
		
	}

	protected Boolean settleAccounts() {
		Request req  = new Request(Request.CONFIRM_SECOND_BALANCE2_REQUEST);
		for(int i = 0;i<checkBoxs.length;i++){
			if(checkBoxs[i].isSelected()){
				int id = Integer.parseInt((String)table.getValueAt(i,1));
				System.out.println("id"+id);
				req.addData("branch_Id",id );
			}
		}
		Response res = action.doAction(req);
		Boolean result = (Boolean) res.getData("result");
		return result;
		
	}
}