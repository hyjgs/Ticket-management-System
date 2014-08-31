package com.tolo.tabcs.business.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author TangLiang
 */
public class ChangeTicketPanel extends JPanel implements ActionListener{
	private JFrame frame;
	private JLabel lblTickId,lblPassName,lblPassId;
	private JTextField txtTickId,txtPassName,txtPassId;
	private JButton btnCheck;
	
	public ChangeTicketPanel(JFrame frame){
		this.frame=frame;
		lblTickId = new JLabel("机票编号:");
		lblPassName = new JLabel("乘客姓名:");
		lblPassId = new JLabel("证件号码:");
		txtTickId = new JTextField("1314567896543214752",16);
		txtPassName = new JTextField("张三",4);
		txtPassId = new JTextField("1234567890123456",13);
		btnCheck = new JButton("查询");
		btnCheck.addActionListener(this);
		init();
	}
	
	private void init(){
		JPanel retuTickNorthPane = new JPanel();
		this.setLayout(new BorderLayout());
		
		retuTickNorthPane.add(lblTickId);
		retuTickNorthPane.add(txtTickId);
		retuTickNorthPane.add(lblPassName);
		retuTickNorthPane.add(txtPassName);
		retuTickNorthPane.add(lblPassId);
		retuTickNorthPane.add(txtPassId);
		retuTickNorthPane.add(btnCheck);
		
		this.add(retuTickNorthPane,BorderLayout.NORTH);
		frame.add(this);
	}
	
	public void showMe(){
		frame.setBounds(180, 210, 690, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询")){
			/**
			 * 得到用户输入的数据
			 */
			//???????
			/**
			 * 封装数据
			 */
			//??????????
			/**
			 * 得到查询后的数据，应该返回的是一个集合
			 */
			//?????????
			/**
			 * 界面显示数据
			 */
			ShowTicketInfoPanel stp = null;
			JButton retuTicketBtn=null;
			JPanel retuTickInfoPane=null;
			JPanel retuTickCenPane=new JPanel();
			JScrollPane jsp=new JScrollPane(retuTickCenPane);
			retuTickCenPane.setLayout(new BoxLayout(retuTickCenPane,BoxLayout.Y_AXIS));
			//假数据
			for(int i=0;i<5;i++){
				@SuppressWarnings("unused")
				String str="航班号:TL1210 出发地:北京－首都国际机场 目的地:上海－虹桥机场 日期:2010-08-30\n" +
				"乘客姓名:张三 证件号码:1234567890123456 机票价格:1020 退票规定:退票收取20％手续费";
				stp = new ShowTicketInfoPanel();
				retuTicketBtn=new JButton("改签");
				retuTicketBtn.addActionListener(this);
				retuTickInfoPane=new JPanel();
				retuTickInfoPane.setLayout(new FlowLayout(FlowLayout.CENTER,25,5));
				retuTickInfoPane.add(stp);
				retuTickInfoPane.add(retuTicketBtn);

				retuTickInfoPane.setBorder(BorderFactory.createTitledBorder(""));
				retuTickCenPane.add(retuTickInfoPane);
			}
			this.add(jsp,BorderLayout.CENTER);
//			frame.setBounds(180, 210, 690, 301);
			frame.setVisible(true);
		}else if(e.getActionCommand().equals("改签")){
//			JOptionPane.showConfirmDialog(frame,"改签信息","提示",JOptionPane.INFORMATION_MESSAGE);
		//	new ChanTicketDialog((java.util.List) new List(),new TicketOrder()).setVisible(true);
		}
	}

}

