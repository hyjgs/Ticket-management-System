/*
 * SaleRecorderPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.tolo.tabcs.business.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tolo.tabcs.common.gui.CheckBoxRenderer;
import com.tolo.tabcs.common.gui.CheckButtonEditor;
import com.tolo.tabcs.common.gui.SimpleCal;

/**
 * @author TangLiang
 */
public class SaleRecorderPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6216615034958243833L;

	/** Creates new form SaleRecorderPanel */
	public SaleRecorderPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		initComponents();
		addHandler();
	}

	/**
	 * @return 含有table的可滚屏面板
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane1 == null) {
			String[] str = new String[]{"","编号","记录发生时间","类型","网点","员工","金额"};
			Object[][] obj = new Object[50][7];
			checkBoxs=new JCheckBox[obj.length];
			for(int i=0;i<obj.length;i++){
				checkBoxs[i]=new JCheckBox(); 
				obj[i][0] = checkBoxs[i];
			}
			jtabTicketRecInfo = new JTable(obj,str);
			jtabTicketRecInfo.getColumn(jtabTicketRecInfo.getColumnName(0)).setCellEditor(new CheckButtonEditor(new JCheckBox()));
			jtabTicketRecInfo.getColumn(jtabTicketRecInfo.getColumnName(0)).setCellRenderer(new CheckBoxRenderer());
			jtabTicketRecInfo.getColumn(jtabTicketRecInfo.getColumnName(0)).setMaxWidth(23);
			jScrollPane1 = new JScrollPane(jtabTicketRecInfo);
			jScrollPane1.setBounds(new Rectangle(30, 100, 700, 310));
		}
		return jScrollPane1;
	}

	/**
	 * 注册监听
	 */
	private void addHandler(){
		this.btnSearch.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if (SaleRecorderPanel.this.jtfFrom.getText().trim().equals("")
						&& SaleRecorderPanel.this.jtfTo.getText().trim().equals("")){
					JOptionPane.showMessageDialog(SaleRecorderPanel.this, "请输入日期");
					return;
				}
			}
			
		});
		
		this.btnSuperSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.btnSubmit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(SaleRecorderPanel.this, "确定对以上账目结算？",
						"确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(SaleRecorderPanel.this, "结算成功");
				}
			}
			
		});
		
		this.btnToExcel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.out.println(11);
				new JFileChooser().showSaveDialog(SaleRecorderPanel.this);
			}
		});
		
		this.jtfFrom.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {
				new SimpleCal(SaleRecorderPanel.this.parentFrame,jtfFrom).setVisible(true);
				jtfFrom.setFocusable(false);
				jtfFrom.setFocusable(true);
			}
			public void focusLost(FocusEvent e) {}
		});
		
		this.jtfTo.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {
				new SimpleCal(SaleRecorderPanel.this.parentFrame,jtfTo).setVisible(true);
				jtfTo.setFocusable(false);
				jtfTo.setFocusable(true);
			}
			public void focusLost(FocusEvent e) {}
		});

		this.btnSelA.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(true);
				}
				SaleRecorderPanel.this.jtabTicketRecInfo.repaint();
			}
			
		});
		this.btnSelC.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(false);
				}
				SaleRecorderPanel.this.jtabTicketRecInfo.repaint();
			}
			
		});
		this.btnSelR.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<checkBoxs.length;i++){
					checkBoxs[i].setSelected(!checkBoxs[i].isSelected());
				}
				SaleRecorderPanel.this.jtabTicketRecInfo.repaint();
			}
			
		});
	}
	
	/**
	 * 初始化窗体控件
	 */
	private void initComponents() {

		btnSelA = new javax.swing.JButton();
		labTitle = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		labSaler = new javax.swing.JLabel();
		jcbSaler = new javax.swing.JComboBox();
		labFrom = new javax.swing.JLabel();
		jtfFrom = new javax.swing.JTextField();
		labTo = new javax.swing.JLabel();
		jtfTo = new javax.swing.JTextField();
		btnSearch = new javax.swing.JButton();
		btnSuperSearch = new javax.swing.JButton();
		btnSelR = new javax.swing.JButton();
		btnSelC = new javax.swing.JButton();
		btnSubmit = new javax.swing.JButton();
		btnToExcel = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtabTicketRecInfo = new javax.swing.JTable();
		labTicketRecoder = new javax.swing.JLabel();
		jsp1 = new javax.swing.JSeparator();

		setMaximumSize(new java.awt.Dimension(800, 460));
		setMinimumSize(new java.awt.Dimension(800, 460));
		setOpaque(false);

		btnSelA.setText("\u5168\u9009");

		labTitle.setText("\u8425\u4e1a\u8bb0\u5f55:");

		jPanel2.setOpaque(false);

		labSaler.setText("\u8425\u4e1a\u5458:");

		jcbSaler.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));

		labFrom.setText("\u81ea");

		labTo.setText("\u81f3");

		btnSearch.setText("\u67e5\u8be2");

		btnSuperSearch.setText("\u9ad8\u7ea7\u67e5\u8be2");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												labSaler,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jcbSaler,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												72,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(labFrom)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jtfFrom,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												91,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(labTo)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jtfTo,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												93,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnSearch)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnSuperSearch)
										.addContainerGap(290, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(labSaler)
														.addComponent(
																jcbSaler,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(labFrom)
														.addComponent(
																jtfFrom,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(labTo)
														.addComponent(
																jtfTo,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btnSearch)
														.addComponent(
																btnSuperSearch))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		btnSelR.setText("\u53cd\u9009");

		btnSelC.setText("\u6e05\u7a7a");

		btnSubmit.setText("\u7ed3\u7b97");

		btnToExcel.setText("\u5bfc\u51fa\u5230EXCEL");

		jPanel1.setAutoscrolls(true);
		jPanel1.setOpaque(false);

		jtabTicketRecInfo.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(jtabTicketRecInfo);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 770,
								Short.MAX_VALUE).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 254,
								Short.MAX_VALUE).addContainerGap()));

		labTicketRecoder.setText("\u8425\u4e1a\u8bb0\u5f55");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												labTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												81,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(719, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(
										jPanel2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(labTicketRecoder)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jsp1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												720,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(28, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				btnSelA)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btnSelR)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btnSelC)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				372,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnSubmit)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btnToExcel)
																		.addGap(
																				73,
																				73,
																				73))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addContainerGap()))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addComponent(
												labTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				labTicketRecoder)
																		.addGap(
																				2,
																				2,
																				2))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jsp1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(btnSelA)
														.addComponent(btnSelR)
														.addComponent(btnSelC)
														.addComponent(
																btnToExcel)
														.addComponent(btnSubmit))
										.addContainerGap()));
	}// </editor-fold>
	//GEN-END:initComponents

	private JFrame parentFrame;
	private JCheckBox[] checkBoxs;
	
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnSearch;
	private javax.swing.JButton btnSelA;
	private javax.swing.JButton btnSelC;
	private javax.swing.JButton btnSelR;
	private javax.swing.JButton btnSubmit;
	private javax.swing.JButton btnSuperSearch;
	private javax.swing.JButton btnToExcel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JComboBox jcbSaler;
	private javax.swing.JSeparator jsp1;
	private javax.swing.JTable jtabTicketRecInfo;
	private javax.swing.JTextField jtfFrom;
	private javax.swing.JTextField jtfTo;
	private javax.swing.JLabel labFrom;
	private javax.swing.JLabel labSaler;
	private javax.swing.JLabel labTicketRecoder;
	private javax.swing.JLabel labTitle;
	private javax.swing.JLabel labTo;
	// End of variables declaration//GEN-END:variables

}