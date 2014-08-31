package com.tolo.tabcs.business.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * @author TangLiang
 */
public class ShowTicketInfoPanel extends JPanel{
	private static final long serialVersionUID=123456789456431L;
	private JLabel flightNoLbl,fromPlaceLbl,toPlaceLbl,dateLbl,passageNameLbl,idNoLbl,ticketPriceLbl,ruleLbl;
	public ShowTicketInfoPanel(){
		super();
		flightNoLbl=new JLabel("TL1210");
		flightNoLbl.setForeground(new Color(255,0,0));
		flightNoLbl.setFont(new Font("宋体",Font.BOLD,16));
		flightNoLbl.setForeground(new Color(255,0,0));
		fromPlaceLbl=new JLabel("北京－首都国际机场");
		toPlaceLbl=new JLabel("上海－虹桥机场");
		dateLbl=new JLabel("2010-08-30");
		passageNameLbl=new JLabel("张三");
		passageNameLbl.setForeground(new Color(255,0,0));
		passageNameLbl.setFont(new Font("宋体",Font.BOLD,16));
		idNoLbl=new JLabel("1234567890123456");
		ticketPriceLbl=new JLabel("1020");
		ticketPriceLbl.setForeground(new Color(255,0,0));
		ticketPriceLbl.setFont(new Font("宋体",Font.BOLD,18));
		ruleLbl=new JLabel("退票收取20％手续费");
		
		init();
		
	}
	
	
//	public ShowTicketInfoPanel(TicketOrder ticket,String from,String to){
//		super();
//		
//		flightNoLbl=new JLabel(ticket.getTod_fli_name());
//		flightNoLbl.setForeground(new Color(255,0,0));
//		flightNoLbl.setFont(new Font("宋体",Font.BOLD,16));
//		flightNoLbl.setForeground(new Color(255,0,0));
//		fromPlaceLbl=new JLabel(from);
//		toPlaceLbl=new JLabel(to);
//		dateLbl=new JLabel(ticket.getTod_go_date());
//		passageNameLbl=new JLabel(ticket.getTod_pass_name());
//		passageNameLbl.setForeground(new Color(255,0,0));
//		passageNameLbl.setFont(new Font("宋体",Font.BOLD,16));
//		idNoLbl=new JLabel(ticket.getTod_pass_certnum());
//		
//		ticketPriceLbl=new JLabel(ticket.getTod_price()+"");
//		ticketPriceLbl.setForeground(new Color(255,0,0));
//		ticketPriceLbl.setFont(new Font("宋体",Font.BOLD,18));
//		ruleLbl=new JLabel("退票收取20％手续费");
//		
//		init();
//		
//	}
	
	
	
	private void init(){
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		panel1.add(new JLabel("航班号:"));
		panel1.add(flightNoLbl);
		panel1.add(new JLabel("出发地:"));
		panel1.add(fromPlaceLbl);
		panel1.add(new JLabel("目的地:"));
		panel1.add(toPlaceLbl);
		
		panel1.add(new JLabel("乘客姓名:"));
		panel1.add(passageNameLbl);
		panel1.add(new JLabel("证件号码:"));
		panel1.add(idNoLbl);
		panel1.add(new JLabel("日期:"));
		panel1.add(dateLbl);
		
		JLabel price=new JLabel("机票价格:",JLabel.LEFT);
		panel3.add(price);
		panel3.add(ticketPriceLbl);
		panel3.add(new JLabel("退票规定:"));
		panel3.add(ruleLbl);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}

}
