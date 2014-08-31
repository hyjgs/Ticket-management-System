package com.tolo.tabcs.business.gui;

public class ShowListFrame {
//	private JFrame frame;
//	private JTable table;
//	private JScrollPane tableScrollPane;//中间用于存放Table的滚动面板。
////	private List<SalesBusinessLog> list;//总记录
//	public ShowListFrame(List<SalesBusinessLog> list){
//		for(int i=0;i<list.size();i++){
//			System.out.println("33333="+list.get(i).toString());
//		}
//		this.list=list;
//		for(int i=0;i<this.list.size();i++){
//			System.out.println("4444444="+this.list.get(i).toString());
//		}
//		frame=new JFrame("营业员申请结算的营业记录");
//		
//		String[] col=new String[]{ "编号", "记录发生时间", "类型", "网点",
//				"员工", "金额", "结算状态"};
//		Object[][] date=new Object[100][col.length];
//
////		JScrollPane滚动面板和表的初始化，并将表添加到面板中。
//		
//		table=new JTable(date,col);
////		table.getColumn(table.getColumnName(0)).setCellEditor(new CheckButtonEditor(new JCheckBox()));
////		table.getColumn(table.getColumnName(0)).setCellRenderer(new CheckBoxRenderer());
//	//	table.getColumn(table.getColumnName(0)).setMaxWidth(30);
//		tableScrollPane = new JScrollPane(table);
//		init();
//		show();
//
//	}
//	
//	private void init(){
//		frame.add(tableScrollPane);
//	}
//	
//	private void show(){
//		if(list==null){
//			return;
//		}
//		for(int i=0;i<list.size();i++){
//			System.out.println("22222="+list.get(i).toString());
//		}
//		for(int i=0;i<list.size();i++){
//			table.setValueAt(list.get(i).getSbl_num(),i,0);
//			table.setValueAt(list.get(i).getSbl_time(),i,1);
//			table.setValueAt(list.get(i).getSbl_type(),i,2);
//			table.setValueAt(list.get(i).getSbl_bra_id(),i,3);
//			table.setValueAt(list.get(i).getSbl_sales_id(),i,4);
//			table.setValueAt(list.get(i).getSbl_money(),i,5);
//			table.setValueAt(list.get(i).getSbl_balance_type(),i,6);
//		}
//	}
//	public void showMe(){
//		frame.setSize(800, 400);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//	}
	
	public static void main(String[] aegs){
		//new ShowListFrame().showMe();
	}
}
