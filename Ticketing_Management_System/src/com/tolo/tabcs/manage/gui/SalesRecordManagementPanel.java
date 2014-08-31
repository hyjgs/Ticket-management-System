package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.BusinessRecord;
import com.tolo.tabcs.common.gui.SimpleCal;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;




@SuppressWarnings("serial")
public class SalesRecordManagementPanel extends JPanel implements ActionListener{
	private JLabel label1,label2,label3,label4,label5,label6;
	private JButton button1,button2;
	private JTextField fromDate,toDate;
	private JScrollPane tableScrollPane;
	private JTable table;
	private JButton refresh;
	
	private String[] arr1;//wangdian
	private String[] arr2;//yingyeyuan
	private String[] arr3;//time
	private String[] arr4;
	private String[] arr5;
	private Object[][] arrs;
	private JComboBox box1,box2,box3,box4;
	private JFrame frame;
	private List<String> currentList;
	Action action = new Action();
	public SalesRecordManagementPanel(JFrame frame){
		this.frame=frame;
		currentList=new ArrayList<String>();
		label1=new JLabel("网点");
		label2=new JLabel("营业员");
		label3=new JLabel("营业日期 自：");
		label5=new JLabel("至：");
		label4=new JLabel("营业类型");
		label6=new JLabel("结算状态");
		
		button1=new JButton("查询");
		button2=new JButton("导出到文本");
		refresh=new JButton("刷新");
		
		fromDate=new JTextField(8);
		fromDate.setEditable(false);
		
		toDate=new JTextField(8);
		toDate.setEditable(false);
//		if(getBranchNames()==null){
//			arr1=new String[]{"所有"};
//			arr2=new String[]{"所有"};
//		}else{
		arr1 = getBranchNames();
		arr2 = new String[]{"所有"};
		box2=new JComboBox(arr2);
//		box2.addItem("所有");
//		getUsers();
//		}
//		box2=new JComboBox();
//		getUsers();
		
		arr3=new String[]{"所有","订票","退票","改签"};
		arr4=new String[]{"所有","未结算","申请一级结算","一级已结算","申请二级结算","二级已结算"};
		arr5=new String[]{"网点编号","网点名称","营业员编号","营业员姓名","营业时间","营业类型","金额","结算状态"};
		arrs=new Object[100][arr5.length];
		
		box1=new JComboBox(arr1);
		box3=new JComboBox(arr3);
		box4=new JComboBox(arr4);
		
		table=new JTable(arrs,arr5);
		tableScrollPane=new JScrollPane(table);
		tableScrollPane=new JScrollPane(table);
		
		init();
		addEventHandler();
	}
	
	public void init(){
		JPanel northPane=new JPanel();
		northPane.add(label1);
		northPane.add(box1);
		northPane.add(label2);
		northPane.add(box2);
		northPane.add(label3);
		northPane.add(fromDate);
		northPane.add(label5);
		northPane.add(toDate);
		northPane.add(label4);
		northPane.add(box3);
		
		northPane.add(label6);
		northPane.add(box4);
		northPane.add(button1);
		
		JPanel southPane=new JPanel();
		southPane.add(button2);
		southPane.add(refresh);
		this.setLayout(new BorderLayout());
		this.add(northPane, BorderLayout.NORTH);
		this.add(tableScrollPane,BorderLayout.CENTER);
		this.add(southPane,BorderLayout.SOUTH);
	}
	
	public void addEventHandler(){
		button2.addActionListener(this);
		refresh.addActionListener(this);
		fromDate.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {
				new SimpleCal(frame,fromDate).setVisible(true);
				fromDate.setFocusable(false);
				fromDate.setFocusable(true);
			}
			public void focusLost(FocusEvent e) {}
		});
		
		toDate.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {
				new SimpleCal(frame,toDate).setVisible(true);
				toDate.setFocusable(false);
				toDate.setFocusable(true);
			}
			public void focusLost(FocusEvent e) {}
		});
		
		box1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					box2.removeAllItems();
					String str=(String)e.getItem();
					List<String> us=new ArrayList<String>();
//					if(str.equals("所有")){
//						box2.addItem("所有");
//					}					
//					int id=0;
					Request req = new Request(Request.SEARCH_USER_NAME_REQUEST);
					req.addData("branchName",str);
					Response res = action.doAction(req);
					us = (List<String>) res.getData("userName");
					//String[] con=new String[us.size()];
					box2.addItem("所有");
					for(int i=0;i<us.size();i++){
						box2.addItem(us.get(i));
					}			
				}
			}
			
		});
		
		button1.addActionListener(new ActionListener(){

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("fromDate.getText()="+fromDate.getText());
				if(fromDate.getText().equals("")||toDate.getText().equals("")){
					JOptionPane.showMessageDialog(SalesRecordManagementPanel.this, "请输入日期");
					return;
				}
				for(int i=0;i<table.getRowCount();i++){
					for(int j=0;j<table.getColumnCount();j++){
						table.setValueAt("", i, j);
					}
				}
				search();

			}
			
		});
	}

	protected List search() {
		Request req = new Request(Request.SEARCH_RESULT_REQUEST);
		String[] state=new String[6];
		state[0]=(String)box1.getSelectedItem();
		state[1]=(String)box2.getSelectedItem();
		state[4]=(String)box3.getSelectedItem();
		state[5]=(String)box4.getSelectedItem();
		state[2]=fromDate.getText();
		state[3]=toDate.getText();
		req.addData("message", state);
		Response res = action.doAction(req);
		List list = (List)res.getData("result");
		
		for(int m=0;m<20;m++){
			for(int n=1;n<6;n++){
				table.setValueAt("",m,n);
			}
		}
		if(list.size()==0){
			JOptionPane.showMessageDialog(SalesRecordManagementPanel.this, "没有该网点记录！");
		}
		for(int i = 0;i<list.size();i++){
			BusinessRecord record = (BusinessRecord) list.get(i);
			table.setValueAt(record.getBranch_id()+"", i, 0);
			table.setValueAt(record.getBranch_name(), i, 1);
			table.setValueAt(record.getUser_id()+"", i, 2);
			table.setValueAt(record.getUser_name(), i, 3);
			table.setValueAt(record.getBuss_red_date(), i, 4);
			table.setValueAt(record.getBuss_type(), i, 5);
			table.setValueAt(record.getBuss_red_price(), i, 6);
			table.setValueAt(record.getBuss_red_account_state(), i, 7);
		}
			
			
		return list;
		
		
	}

	public void actionPerformed(ActionEvent e) {
		List list = search();
		if(e.getActionCommand().equals("导出到文本")){
			if(list.size()==0){
				JOptionPane.showMessageDialog(SalesRecordManagementPanel.this, "内容为空");
				return;
			}
			JFileChooser f=new JFileChooser();
			f.showSaveDialog(SalesRecordManagementPanel.this);
			File file=f.getSelectedFile();
			getLoad(file);
		}	
		if(e.getActionCommand().equals("刷新")){
			box1.removeAllItems();
			
			fromDate.setText("");
			toDate.setText("");
			for(int i=0;i<table.getRowCount();i++){
				for(int j=0;j<table.getColumnCount();j++){
					table.setValueAt("", i, j);					
				}
			}
			if(getBranchNames()==null){
				box1.addItem("所有");
				box2.addItem("所有");
			}else{
				arr1=getBranchNames();
				for(int i=0;i<arr1.length;i++){
					box1.addItem(arr1[i]);
				}
				getUsers();
				box2.addItem("所有");
			}
			
		}
		
	}
	
	private void getLoad(File file) {
		// TODO Auto-generated method stub
				List list = search();
				List list2 = new ArrayList();
				System.out.println(list);
				try {
					//创建新的Excel工作薄
					HSSFWorkbook workbook = new HSSFWorkbook();
					//在Excel中建一个工作表,其名为默认值
					//如果建造一张为"ucap字段"的工作表，那么语句就是HSSFSheet sheet =workbook.createSheet("ucap字段");
					HSSFSheet sheet =workbook.createSheet();
					//在索引0的位置创建行（最顶端的行）
					HSSFRow row = sheet.createRow(0);
					//在索引0的位置创建单元格（左上端）
					HSSFCell cell = row.createCell(0);
					//定义单元格为字符串类型
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					//在单元格中输入一些内容
					row.createCell(0).setCellValue("网点编号");
					row.createCell(1).setCellValue("网点名称");
					row.createCell(2).setCellValue("营业员编号");
					row.createCell(3).setCellValue("营业员姓名");
					row.createCell(4).setCellValue("营业时间");
					row.createCell(5).setCellValue("营业类型");
					row.createCell(6).setCellValue("金额");
					row.createCell(7).setCellValue("结算状态");
					int k = 0;
					for(int i = 0;i<list.size();i++){
						BusinessRecord record = (BusinessRecord) list.get(i);
						int branchId = record.getBranch_id();
						String branchName = record.getBranch_name();
						int user_id = record.getUser_id();
						String user_name = record.getUser_name();
						String date = record.getBuss_red_date();
						String type = record.getBuss_type();
						int price = record.getBuss_red_price();
						String state = record.getBuss_red_account_state();
						list2.add(branchId);
						list2.add(branchName);
						list2.add(user_id);
						list2.add(user_name);
						list2.add(date);
						list2.add(type);
						list2.add(price);
						list2.add(state);
					}
				
					for(int i = 1;i<list2.size()/8;i++){
						HSSFRow row1 = sheet.createRow(i);
					   for(int g = 0;g<8;g++){
						row1.createCell(g).setCellValue(""+list2.get(k++));
					   }
					}
//					sheet.createRow(1).createCell(0).setCellValue(""+list.get(1));
//					sheet.createRow(1).createCell(1).setCellValue(""+list.get(2));
//					sheet.createRow(1).createCell(2).setCellValue(""+list.get(3));
//					sheet.createRow(1).createCell(3).setCellValue(""+list.get(4));
//					sheet.createRow(1).createCell(4).setCellValue(""+list.get(5));
//					sheet.createRow(1).createCell(5).setCellValue(""+list.get(6));
//					sheet.createRow(1).createCell(6).setCellValue(""+list.get(7));
//					sheet.createRow(1).createCell(7).setCellValue(""+list.get(8));
//					sheet.createRow(2).createCell(0).setCellValue(""+list.get(9));
//					sheet.createRow(2).createCell(1).setCellValue(""+list.get(10));
//					sheet.createRow(2).createCell(2).setCellValue(""+list.get(11));
//					sheet.createRow(2).createCell(3).setCellValue(""+list.get(12));
//					sheet.createRow(2).createCell(4).setCellValue(""+list.get(13));
//					sheet.createRow(2).createCell(5).setCellValue(""+list.get(14));
//					sheet.createRow(2).createCell(6).setCellValue(""+list.get(15));
//					sheet.createRow(2).createCell(7).setCellValue(""+list.get(16));
//					//begin,设置单元格格式-----------------------------------
//					HSSFFont font = workbook.createFont();
//					font.setColor(HSSFFont.COLOR_RED);//设置红色
//					font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//设置粗体
//					//创建格式
//					HSSFCellStyle cellStyle = workbook.createCellStyle();
//					cellStyle.setFont(font);
//					//应用格式
//					cell.setCellStyle(cellStyle); //设置格式
//					cell.setCellType(HSSFCell.CELL_TYPE_STRING);//定义单元格为字符串类型
//					cell.setCellValue("宝哥霸气");//设置文本内容
//					//end,------------------------------------------------
//					
					//输出文件流
					FileOutputStream fOut = new FileOutputStream(file);
					//把相应的excel工作表保存到硬盘上
					workbook.write(fOut);
					fOut.flush();
					fOut.close();//关闭文件，操作结束
					JOptionPane.showMessageDialog(SalesRecordManagementPanel.this, "文件生成完毕...");
					System.out.println("文件生成完毕....");
				} catch (Exception e) {
					System.out.println("已运行出错" + e);
				}
			}
		

	@SuppressWarnings("unchecked")
	private String[] getBranchNames(){
		Request req = new Request(Request.SEARCH_BRANCH_NAME1_REQUEST);
		Response res = action.doAction(req);
		String[] branchNames = (String[]) res.getData("branchName");
		System.out.println(Arrays.toString(branchNames));
		return branchNames;
		
	}
	
	@SuppressWarnings("unchecked")
	private void getUsers(){
		box2.removeAllItems();
	}
	//1111
//	private String[] showAll(){
//		String[] state=new String[6];
//		state[0]=(String)box1.getSelectedItem();
//		state[1]=(String)box2.getSelectedItem();
//		state[2]=(String)box3.getSelectedItem();
//		state[3]=(String)box4.getSelectedItem();
//		state[3]=fromDate.getText();
//		state[4]=toDate.getText();
//		return state;
//	}
//	
//	//0000
//	private List showZero(){
//		currentList=new ArrayList<String>();
//		String[] state=new String[6];
//		state[1]=(String) box1.getSelectedItem();
//		state[2]=(String) box2.getSelectedItem();
//		state[3]=fromDate.getText();
//		state[4]=toDate.getText();
//		state[5]=(String)box3.getSelectedItem();
//		if(((String)box4.getSelectedItem()).equals("未结算")){
//			state[6]=0+"";
//		}else if(((String)box4.getSelectedItem()).equals("申请一级结算")){
//			state[6]=1+"";
//		}else if(((String)box4.getSelectedItem()).equals("一级已结算")){
//			state[6]=2+"";
//		}else if(((String)box4.getSelectedItem()).equals("申请二级结算")){
//			state[6]=3+"";
//		}else if(((String)box4.getSelectedItem()).equals("二级已结算")){
//			state[6]=4+"";
//		}
//		int num=0;
//		return currentList;
//	}
//	
//	
//	//0111
//	private void showOne(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//	}
//	
//	//1011
//	private void showTwo(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String userName=(String)box2.getSelectedItem();
//		int userId=0;
//	}
//	
//	//1101
//	private void showThree(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String salesType=(String)box3.getSelectedItem();
//		int num=0;
//	}
//	
//	//1110
//	private void showFour(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String salesType=(String)box4.getSelectedItem();
//		int type=balanceType1(salesType);
//		int num=0;
//	}
//	
//	//0011
//	private void showFive(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//	}
//	
//	//0101
//	private void showSix(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//	}
//
//	//0110
//	private void showSeven(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//	}
//	
//	//1001
//	private void showEight(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String userName=(String)box2.getSelectedItem();
//		int userId=0;
//	}
//	
//	//1010
//	private void showNine(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String userName=(String)box2.getSelectedItem();
//		int userId=0;
//	}
//	
//	//1100
//	private void showTen(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String salesType=(String)box3.getSelectedItem();
//		String salesType1=(String)box4.getSelectedItem();
//		int type=balanceType1(salesType1);
//		int num=0;
//	}
//	
//	//0001
//	private void showEleven(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//	}
//	
//	//0010
//	private void showTwelve(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//	}
//	
//	//0100
//	private void showThirteen(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String branchName=(String)box1.getSelectedItem();
//		int branchId=0;
//
//
//		String salesType=(String)box3.getSelectedItem();
//
//		String salesType1=(String)box4.getSelectedItem();
//		int type=balanceType1(salesType1);
//		int num=0;
//	}
//	
//	//1000
//	private void showFourteen(){
//		currentList=new ArrayList<String>();
//		
//		String fromTime=fromDate.getText();
//		String toTime=toDate.getText();
//		String userName=(String)box2.getSelectedItem();
//		int userId=0;
//
//		String salesType=(String)box3.getSelectedItem();
//
//		String salesType1=(String)box4.getSelectedItem();
//		int type=balanceType1(salesType1);
//		int num=0;
//	}
//	
//	private void print(int num,int i){
//		String str="";
//			currentList.add(str);
//	}
//	
//	private int balanceType1(String str){
//		if(str.equals("未结算")){
//			return 0;
//		}else if(str.equals("申请一级结算")){
//			return 1;
//		}else if(str.equals("一级已结算")){
//			return 2;
//		}else if(str.equals("申请二级结算")){
//			return 3;
//		}else if(str.equals("二级已结算")){
//			return 4;
//		}else{
//			return 100;
//		}
//	}
//	
//	
//	
//	private String balanceType(int n,int num){
//		String str="";
//		switch(n){
//		case 0:	table.setValueAt("未结算", num,7);str="未结算";break;
//		case 1:	table.setValueAt("申请一级结算", num,7);str="申请一级结算";break;
//		case 2:	table.setValueAt("一级已结算", num,7);str="一级已结算";break;
//		case 3:	table.setValueAt("申请二级结算", num,7);str="申请二级结算";break;
//		case 4:	table.setValueAt("二级已结算", num,7);str="二级已结算";break;
//		}
//		return str;
//	}



}
