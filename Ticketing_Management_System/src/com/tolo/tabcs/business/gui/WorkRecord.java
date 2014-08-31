package com.tolo.tabcs.business.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.gui.CheckBoxRenderer;
import com.tolo.tabcs.common.gui.CheckButtonEditor;
import com.tolo.tabcs.common.gui.LoginFrame;
import com.tolo.tabcs.common.gui.SimpleCal;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

/**
 * 营业记录面板
 * 
 * @author TangLiang
 */
public class WorkRecord extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField field1 = null;
	private JTextField field2 = null;
	private JScrollPane jScrollPane = null;// 可滚屏面板
	private JTable jTable = null;// 显示表格
	private JRadioButton nowRadio = null;// 当前记录选项按钮
	private JRadioButton pastRadio = null;// 当前记录选项按钮
	private JButton search = null;// 查询按钮
//	private JButton superSearch = null;// 高级查询按钮
	// private JButton balance = null;//结算按钮
	private JButton all = null;// 全选按钮
	private JButton none = null;// 撤销按钮
	private JButton redirection = null;// 反向按钮
	private JButton load = null;// 导出到文本按钮
	private JFrame frame;// 父窗口
	private JCheckBox[] checkBoxs;
	private Object[][] obj;
	
	/**
	 * @return 含有table的可滚屏面板
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			String[] str = new String[] { "选择", "编号", "记录发生时间", "类型", "网点",
					"员工", "金额", "结算状态" };
			obj = new Object[50][8];
			checkBoxs = new JCheckBox[obj.length];
			for (int i = 0; i < obj.length; i++) {
				checkBoxs[i] = new JCheckBox();
				obj[i][0] = checkBoxs[i];
			}
			jTable = new JTable(obj, str);
			jTable.getColumn(jTable.getColumnName(0)).setCellEditor(
					new CheckButtonEditor(new JCheckBox()));
			jTable.getColumn(jTable.getColumnName(0)).setCellRenderer(
					new CheckBoxRenderer());
			jTable.getColumn(jTable.getColumnName(0)).setMaxWidth(30);
			jScrollPane = new JScrollPane(jTable);
			jScrollPane.setBounds(new Rectangle(30, 100, 800, 410));
		}
		return jScrollPane;
	}

	/**
	 * @return 当前记录radioButton
	 */
	private JRadioButton getNowRadio() {
		if (nowRadio == null) {
			nowRadio = new JRadioButton();
			nowRadio.setPreferredSize(new Dimension(35, 30));
			nowRadio.setSize(new Dimension(100, 25));
			nowRadio.setLocation(new Point(45, 45));
			nowRadio.setText("当天记录");
		}
		return nowRadio;
	}

	/**
	 * @return 历史记录radioButton
	 */
	private JRadioButton getPastRadio() {
		if (pastRadio == null) {
			pastRadio = new JRadioButton();
			pastRadio.setPreferredSize(new Dimension(35, 30));
			pastRadio.setSize(new Dimension(100, 25));
			pastRadio.setLocation(new Point(45, 65));
			pastRadio.setText("历史记录");
		}
		return pastRadio;
	}

	/**
	 * @return 查询button
	 */
	private JButton getPrevious() {
		if (search == null) {
			search = new JButton();
			search.setText("查询");
			search.setLocation(new Point(500, 60));
			search.setSize(new Dimension(60, 25));
		}
		return search;
	}

	/**
	 * @return 高级搜索按钮
	 */
//	private JButton getSuperSearch() {
//		if (superSearch == null) {
//			superSearch = new JButton();
//			superSearch.setText("高级查询");
//			superSearch.setLocation(new Point(600, 60));
//			superSearch.setSize(new Dimension(100, 25));
//		}
//		return superSearch;
//	}

	/**
	 * @return 全选button
	 */
	private JButton getAll() {
		if (all == null) {
			all = new JButton();
			all.setText("全选");
			all.setFont(new Font("宋体", Font.BOLD, 12));
			all.setLocation(new Point(30, 520));
			all.setSize(new Dimension(100, 25));
		}
		return all;
	}

	/**
	 * @return 撤销button
	 */
	private JButton getNone() {
		if (none == null) {
			none = new JButton();
			none.setText("撤销");
			none.setFont(new Font("宋体", Font.BOLD, 12));
			none.setLocation(new Point(130, 520));
			none.setSize(new Dimension(100, 25));
		}
		return none;
	}

	/**
	 * @return 导处到文本button
	 */
	private JButton getLoad() {
		if (load == null) {
			load = new JButton();
			load.setText("导出到文本");
			load.setLocation(new Point(550, 520));
			load.setSize(new Dimension(150, 25));
		}
		return load;
	}

	/**
	 * @return 反向button
	 */
	private JButton getRedirection() {
		if (redirection == null) {
			redirection = new JButton();
			redirection.setText("反向");
			redirection.setFont(new Font("宋体", Font.BOLD, 12));
			redirection.setLocation(new Point(230, 520));
			redirection.setSize(new Dimension(100, 25));
		}
		return redirection;
	}

	/**
	 * @return 结算button
	 */
	// private JButton getNext() {
	// if (balance == null) {
	// balance = new JButton();
	// balance.setText("(一级/二级)结算");
	// balance.setLocation(new Point(230, 450));
	// balance.setSize(new Dimension(200, 25));
	// }
	// return balance;
	// }
	//	
	/**
	 * 构造方法
	 */
	public WorkRecord(JFrame frame) {
		this.frame = frame;
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(150, 65, 65, 19));
		jLabel2.setText("自：");
		field1 = new JTextField();
		field1.setBounds(175, 65, 100, 19);
		field1.setEditable(false);
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(300, 65, 64, 19));
		jLabel1.setText("至：");
		field2 = new JTextField();
		field2.setBounds(325, 65, 100, 19);
		field2.setEditable(false);
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(10, 10, 100, 30));
		jLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		jLabel.setText("营业记录");
		this.setLayout(null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(field1, null);
		this.add(field2, null);
		this.add(getJScrollPane(), null);
		this.add(getNowRadio(), null);
		this.add(getPastRadio(), null);
		this.add(getPrevious(), null);
//		this.add(getSuperSearch(), null);
		// this.add(getNext(), null);
		this.add(getAll(), null);
		this.add(getNone(), null);
		this.add(getLoad(), null);
		this.add(getRedirection(), null);
		this.addEventListener();
		ButtonGroup bg = new ButtonGroup();
		bg.add(nowRadio);
		bg.add(pastRadio);
		for(int i=0;i<jTable.getRowCount();i++){
			for(int j=1;j<jTable.getColumnCount();j++){
				jTable.setValueAt("", i, j);
			}
		}
		
	}

	private void addEventListener() {
		nowRadio.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				field1.setText("");
				field2.setText("");
			}
		});

		search.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 50; i++) {
					for (int j = 1; j < 8; j++) {
						jTable.setValueAt("", i, j);
					}
				}
				
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				jTable.repaint();
				if (nowRadio.isSelected()) {
					Date date = new Date();

					Request req = new Request(
							Request.SEARCH_SALES_RECORD_REQUEST);
					String str2 = date.getMonth() + 1 + "";
					String str3 = date.getDate() + "";
					if (Integer.valueOf(str2) < 10) {
						str2 = "0" + str2;
					}

					if (Integer.valueOf(str3) < 10) {
						str3 = "0" + str3;
					}
					System.out.println((date.getYear() + 1900) + "-"
							+ (date.getMonth() + 1) + "-" + date.getDate());
					req.addData("from", (date.getYear() + 1900) + "-" + str2
							+ "-" + str3);
					req.addData("to", (date.getYear() + 1900) + "-" + str2
							+ "-" + str3);
					Action action=new Action();
					req.addData("user_id",((User)LoginFrame.onlineUsers.get("user")).getId());
					Response res = action.doAction(req);
					SalesRecord[] records =(SalesRecord[])res.getData("result");
					if (!(records.length==0)) {
//						jTable.setValueAt("data", 0, 1);
						int rows=records.length;
						for(int i=0; i<rows;i++){
							jTable.setValueAt(String.valueOf(records[i].getBuss_red_id()), i, 1);
							jTable.setValueAt(records[i].getBuss_red_date(), i, 2);
							jTable.setValueAt(records[i].getBuss_type(), i, 3);
							jTable.setValueAt(String.valueOf(records[i].getBranch_id()), i, 4);
							jTable.setValueAt(String.valueOf(records[i].getUser_id()), i, 5);
							jTable.setValueAt(String.valueOf(records[i].getBuss_red_price()), i, 6);
							jTable.setValueAt(records[i].getState(), i, 7);
						}
					} else {
						JOptionPane.showMessageDialog(WorkRecord.this, "没有对应日期的记录");
					}

				} else if (pastRadio.isSelected()) {
					String str1 = field1.getText().trim();
					String str2 = field2.getText().trim();
					System.out.println("str1="+str1);
					System.out.println("str2="+str2);
					if (!str1.equals("") && (!str2.equals(""))) {
						Action action = new Action();
						Request req = new Request(
								Request.SEARCH_SALES_RECORD_REQUEST);

						// System.out.println(str1);
						// System.out.println(str2);
						req.addData("from", str1);
						req.addData("to", str2);
						req.addData("user_id",((User)LoginFrame.onlineUsers.get("user")).getId());
						Response res = action.doAction(req);
						SalesRecord[] records =(SalesRecord[])res.getData("result");
						if (!(records.length==0)) {
//							jTable.setValueAt("data", 0, 1);
							int rows=records.length;
							for(int i=0; i<rows;i++){
								jTable.setValueAt(String.valueOf(records[i].getBuss_red_id()), i, 1);
								jTable.setValueAt(records[i].getBuss_red_date(), i, 2);
								jTable.setValueAt(records[i].getBuss_type(), i, 3);
								jTable.setValueAt(String.valueOf(records[i].getBranch_id()), i, 4);
								jTable.setValueAt(String.valueOf(records[i].getUser_id()), i, 5);
								jTable.setValueAt(String.valueOf(records[i].getBuss_red_price()), i, 6);
								jTable.setValueAt(records[i].getState(), i, 7);
							}
						} else {
							JOptionPane.showMessageDialog(WorkRecord.this, "没有对应日期的记录");
						}
						
	//					JOptionPane.showMessageDialog(WorkRecord.this, "请输入日期");
					}
				}
			}
		});

//		 balance.addActionListener(new ActionListener(){
//		
//		 public void actionPerformed(ActionEvent e) {
//		 if(JOptionPane.showConfirmDialog(WorkRecord.this, "确定对以上账目结算？",
//		 "确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
//		 JOptionPane.showMessageDialog(WorkRecord.this, "结算成功");
//		 }
//		 }
//					
//		 });

		load.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// System.out.println(11);
				
				JFileChooser f=new JFileChooser();
				f.showSaveDialog(WorkRecord.this);
				File file=f.getSelectedFile();
			}
		});

		field1.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				new SimpleCal(frame, field1).setVisible(true);
				field1.setFocusable(false);
				field1.setFocusable(true);
			}

			public void focusLost(FocusEvent e) {
			}
		});

		field2.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				new SimpleCal(frame, field2).setVisible(true);
				field2.setFocusable(false);
				field2.setFocusable(true);
			}

			public void focusLost(FocusEvent e) {
			}
		});
//		superSearch.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//
//			}
//
//		});
		all.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				for (int i = 0; i < checkBoxs.length; i++) {
//					checkBoxs[i].setSelected(true);
//				}
//				jTable.repaint();
				
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				jTable.repaint();
				
				for(int i=0;i<checkBoxs.length;i++){
					if(jTable.getValueAt(i, 1)!=""){
						checkBoxs[i].setSelected(true);
					}
				}
				jTable.repaint();
			}

		});
		none.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < checkBoxs.length; i++) {
					checkBoxs[i].setSelected(false);
				}
				jTable.repaint();
			}

		});
		redirection.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < checkBoxs.length; i++) {
					checkBoxs[i].setSelected(!checkBoxs[i].isSelected());
				}
				jTable.repaint();
			}

		});
	}
}
