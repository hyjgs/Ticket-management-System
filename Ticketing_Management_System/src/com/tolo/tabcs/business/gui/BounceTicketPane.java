/*
 * BounceTicketPane.java
 *
 * Created on __DATE__, __TIME__
 */

package com.tolo.tabcs.business.gui;

import javax.swing.JFrame;

public class BounceTicketPane extends javax.swing.JPanel {
	private static final long serialVersionUID = 8431189215266597286L;

	/** Creates new form BounceTicketPane */
	public BounceTicketPane(JFrame parentFrame) {
		//this.parentFrame = parentFrame;
		initComponents();
	}
	
	private void initComponents() {
		
		labTitle = new javax.swing.JLabel();
		btnBounce = new javax.swing.JButton();
		btnCancle = new javax.swing.JButton();
		jsp1 = new javax.swing.JSeparator();
		labTicketID = new javax.swing.JLabel();
		jtfTicketID = new javax.swing.JTextField();
		labPassName = new javax.swing.JLabel();
		jtfPassName = new javax.swing.JTextField();
		labID = new javax.swing.JLabel();
		jtfID = new javax.swing.JTextField();
		btnSearch = new javax.swing.JButton();
		jsp2 = new javax.swing.JSeparator();
		panFlightInfo = new javax.swing.JPanel();
		labFilghtID = new javax.swing.JLabel();
		jtfFlightID = new javax.swing.JTextField();
		labDate = new javax.swing.JLabel();
		jtfDate = new javax.swing.JTextField();
		labFrom = new javax.swing.JLabel();
		jtfFrom = new javax.swing.JTextField();
		labTo = new javax.swing.JLabel();
		jtfTo = new javax.swing.JTextField();
		labLeaveTime = new javax.swing.JLabel();
		jtfLeaveTime = new javax.swing.JTextField();
		labArrTime = new javax.swing.JLabel();
		jtfArrTime = new javax.swing.JTextField();
		labPrice = new javax.swing.JLabel();
		jtfPrice = new javax.swing.JTextField();
		labDesc = new javax.swing.JLabel();
		jtfDesc = new javax.swing.JTextField();
		panTicketInfo = new javax.swing.JPanel();
		labTicketTotal = new javax.swing.JLabel();
		jtfTicketTotal = new javax.swing.JTextField();
		labTax = new javax.swing.JLabel();
		jtfTax = new javax.swing.JTextField();
		labBuildFee = new javax.swing.JLabel();
		jtfBuildFee = new javax.swing.JTextField();
		jSeparator4 = new javax.swing.JSeparator();
		labCommCharge = new javax.swing.JLabel();
		jtfCommCharge = new javax.swing.JTextField();
		lanBounceMon = new javax.swing.JLabel();
		jtfBounceMon = new javax.swing.JTextField();
		panPassInfo = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtabFlightInfo = new javax.swing.JTable();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		labPassInfo = new javax.swing.JLabel();
		labFlightInfo = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jSeparator3 = new javax.swing.JSeparator();

		setMaximumSize(new java.awt.Dimension(800, 460));
		setMinimumSize(new java.awt.Dimension(800, 460));
		setOpaque(false);

		labTitle.setText("\u9000\u7968 :");

		btnBounce.setText("\u9000\u6b3e");

		btnCancle.setText("\u53d6\u6d88");

		labTicketID.setText("\u673a\u7968\u7f16\u53f7:");

		labPassName.setText("\u4e58\u5ba2\u59d3\u540d:");

		labID.setText("\u8bc1\u4ef6\u53f7\u7801:");

		btnSearch.setText("\u67e5\u8be2");

		jsp2.setOrientation(javax.swing.SwingConstants.VERTICAL);

		panFlightInfo.setToolTipText("");
		panFlightInfo.setName("");
		panFlightInfo.setOpaque(false);

		labFilghtID.setText("\u822a\u73ed\u53f7:");

		jtfFlightID.setEditable(false);

		labDate.setText("\u65e5\u671f:");

		jtfDate.setEditable(false);
		jtfDate.setEnabled(false);

		labFrom.setText("\u59cb\u53d1\u5730:");

		jtfFrom.setEditable(false);
		jtfFrom.setEnabled(false);

		labTo.setText("\u76ee\u7684\u5730:");

		jtfTo.setEditable(false);
		jtfTo.setEnabled(false);

		labLeaveTime.setText("\u79bb\u6e2f\u65f6\u95f4:");

		jtfLeaveTime.setEditable(false);
		jtfLeaveTime.setEnabled(false);

		labArrTime.setText("\u5230\u6e2f\u65f6\u95f4:");

		jtfArrTime.setEditable(false);
		jtfArrTime.setEnabled(false);

		labPrice.setText("\u7968\u4ef7:");

		jtfPrice.setEditable(false);
		jtfPrice.setEnabled(false);

		labDesc.setText("\u6709\u5173\u8bf4\u660e:");

		jtfDesc.setEditable(false);
		jtfDesc.setForeground(new java.awt.Color(255, 0, 51));
		jtfDesc.setText(" \u9000\u7968\u6536\u53d620%\u624b\u7eed\u8d39.");

		javax.swing.GroupLayout panFlightInfoLayout = new javax.swing.GroupLayout(panFlightInfo);
		panFlightInfo.setLayout(panFlightInfoLayout);
		panFlightInfoLayout.setHorizontalGroup(panFlightInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panFlightInfoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(
						panFlightInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								panFlightInfoLayout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labFilghtID).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfFlightID, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labDate).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labFrom).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jtfFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labTo).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jtfTo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labPrice).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
								panFlightInfoLayout.createSequentialGroup().addComponent(labLeaveTime).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfLeaveTime,
										javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(labArrTime).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfArrTime, javax.swing.GroupLayout.PREFERRED_SIZE,
												105, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labDesc).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
												javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(188, Short.MAX_VALUE)));
		panFlightInfoLayout.setVerticalGroup(panFlightInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panFlightInfoLayout.createSequentialGroup().addContainerGap().addGroup(
						panFlightInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labFilghtID, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
								javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jtfFlightID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labDate).addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labFrom).addComponent(jtfFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labTo).addComponent(jtfTo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(labPrice).addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(12, 12, 12).addGroup(
								panFlightInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labLeaveTime).addComponent(jtfLeaveTime,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labArrTime).addComponent(
										jtfArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labDesc).addComponent(jtfDesc,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(14, Short.MAX_VALUE)));

		panTicketInfo.setOpaque(false);

		labTicketTotal.setText("\u673a\u7968\u603b\u8ba1:");

		jtfTicketTotal.setEditable(false);

		labTax.setText("\u71c3\u6cb9\u7a0e:");

		jtfTax.setEditable(false);

		labBuildFee.setText("\u673a\u573a\u5efa\u8bbe\u8d39:");

		jtfBuildFee.setEditable(false);

		jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

		labCommCharge.setText("\u624b\u7eed\u8d39:");

		jtfCommCharge.setEditable(false);

		lanBounceMon.setText("\u9000\u6b3e\u91d1\u989d:");

		jtfBounceMon.setEditable(false);

		javax.swing.GroupLayout panTicketInfoLayout = new javax.swing.GroupLayout(panTicketInfo);
		panTicketInfo.setLayout(panTicketInfoLayout);
		panTicketInfoLayout.setHorizontalGroup(panTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panTicketInfoLayout.createSequentialGroup().addComponent(labTicketTotal).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfTicketTotal,
						javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labTax)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfTax, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labBuildFee).addGap(6, 6, 6).addComponent(jtfBuildFee,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
								jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(labCommCharge).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfCommCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
								javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lanBounceMon,
								javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
								jtfBounceMon, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(246, Short.MAX_VALUE)));
		panTicketInfoLayout.setVerticalGroup(panTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panTicketInfoLayout.createSequentialGroup().addGroup(
						panTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								panTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labCommCharge).addComponent(jtfCommCharge,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lanBounceMon).addComponent(
										jtfBounceMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
								panTicketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labTicketTotal).addComponent(jtfTicketTotal,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labTax).addComponent(jtfTax,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labBuildFee).addComponent(
										jtfBuildFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jSeparator4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panPassInfo.setAutoscrolls(true);
		panPassInfo.setMaximumSize(new java.awt.Dimension(800, 460));
		panPassInfo.setMinimumSize(new java.awt.Dimension(800, 460));
		panPassInfo.setOpaque(false);

		jtabFlightInfo.setBackground(new java.awt.Color(213, 251, 251));
		jtabFlightInfo.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3",
						"Title 4" }));
		jtabFlightInfo.setOpaque(false);
		jScrollPane1.setViewportView(jtabFlightInfo);

		javax.swing.GroupLayout panPassInfoLayout = new javax.swing.GroupLayout(panPassInfo);
		panPassInfo.setLayout(panPassInfoLayout);
		panPassInfoLayout.setHorizontalGroup(panPassInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panPassInfoLayout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE).addContainerGap()));
		panPassInfoLayout.setVerticalGroup(panPassInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192,
				Short.MAX_VALUE));

		labPassInfo.setText("\u4e58\u5ba2\u4fe1\u606f");

		labFlightInfo.setText("\u822a\u73ed\u4fe1\u606f");

		jLabel1.setText("\u673a\u7968\u8be6\u5355");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup().addComponent(jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED, 529, Short.MAX_VALUE).addComponent(btnBounce).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnCancle).addGap(158, 158, 158)).addGroup(
								layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(labFlightInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
												.addComponent(labTicketID)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
												layout.createSequentialGroup().addComponent(jtfTicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labPassName).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfPassName, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
																javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labID)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
																javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jsp2,
																javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnSearch)).addComponent(jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(112, 112, 112)).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(panFlightInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()).addGroup(
								layout.createSequentialGroup().addComponent(labPassInfo).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jSeparator2,
										javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(113, 113, 113)).addGroup(
								layout.createSequentialGroup().addComponent(panTicketInfo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()).addGroup(
								layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(panPassInfo, javax.swing.GroupLayout.Alignment.LEADING, 0, 760,
												Short.MAX_VALUE).addGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator3,
														javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(30, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnBounce).addComponent(btnCancle)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labTicketID).addComponent(jtfTicketID,
																javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
																labPassName).addComponent(jtfPassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labID).addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jsp2,
														javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnSearch)).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
												layout.createSequentialGroup().addComponent(labFlightInfo).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)).addGroup(
												layout.createSequentialGroup().addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(17,
														17, 17))).addComponent(panFlightInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(jSeparator2).addComponent(labPassInfo,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panPassInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addGroup(
												layout.createSequentialGroup().addGap(8, 8, 8).addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(panTicketInfo,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(14, 14, 14)));
	}// </editor-fold>

	// GEN-END:initComponents

	public void addHandles() {

	}

//	private JFrame parentFrame;
	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBounce;
	private javax.swing.JButton btnCancle;
	private javax.swing.JButton btnSearch;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jsp1;
	private javax.swing.JSeparator jsp2;
	private javax.swing.JTable jtabFlightInfo;
	private javax.swing.JTextField jtfArrTime;
	private javax.swing.JTextField jtfBounceMon;
	private javax.swing.JTextField jtfBuildFee;
	private javax.swing.JTextField jtfCommCharge;
	private javax.swing.JTextField jtfDate;
	private javax.swing.JTextField jtfDesc;
	private javax.swing.JTextField jtfFlightID;
	private javax.swing.JTextField jtfFrom;
	private javax.swing.JTextField jtfID;
	private javax.swing.JTextField jtfLeaveTime;
	private javax.swing.JTextField jtfPassName;
	private javax.swing.JTextField jtfPrice;
	private javax.swing.JTextField jtfTax;
	private javax.swing.JTextField jtfTicketID;
	private javax.swing.JTextField jtfTicketTotal;
	private javax.swing.JTextField jtfTo;
	private javax.swing.JLabel labArrTime;
	private javax.swing.JLabel labBuildFee;
	private javax.swing.JLabel labCommCharge;
	private javax.swing.JLabel labDate;
	private javax.swing.JLabel labDesc;
	private javax.swing.JLabel labFilghtID;
	private javax.swing.JLabel labFlightInfo;
	private javax.swing.JLabel labFrom;
	private javax.swing.JLabel labID;
	private javax.swing.JLabel labLeaveTime;
	private javax.swing.JLabel labPassInfo;
	private javax.swing.JLabel labPassName;
	private javax.swing.JLabel labPrice;
	private javax.swing.JLabel labTax;
	private javax.swing.JLabel labTicketID;
	private javax.swing.JLabel labTicketTotal;
	private javax.swing.JLabel labTitle;
	private javax.swing.JLabel labTo;
	private javax.swing.JLabel lanBounceMon;
	private javax.swing.JPanel panFlightInfo;
	private javax.swing.JPanel panPassInfo;
	private javax.swing.JPanel panTicketInfo;
	// End of variables declaration//GEN-END:variables
}