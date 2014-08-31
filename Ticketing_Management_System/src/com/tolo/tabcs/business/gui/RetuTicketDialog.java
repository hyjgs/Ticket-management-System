package com.tolo.tabcs.business.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.gui.LoginFrame;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
/**
 * @author TangLiang
 */
@SuppressWarnings("serial")
public class RetuTicketDialog extends JDialog implements ActionListener{
	private JLabel ticketInfLabel;	
	private JLabel ticketPriceLabel;
	private JLabel airportPriceLabel;
	private JLabel oilTaxLabel;
	private JLabel progressPriceLabel;
	
	private JTextField ticketPriceText;
	private JTextField airportPriceText;
	private JTextField oilTaxText;
	private JTextField progressPriceText;
	
	private JLabel returnTitleLabel;
	private JLabel returnPriceLabel;
	
	private JButton acceptBtn;
	private JButton cancelBtn;
	
//	private TicketOrder ticket;
	
	private static boolean flag = true;
	
	private Action action;
	
	private int setprice;
	private Ticket ticket;
	
	public RetuTicketDialog (){
	//	alloc();
	//	displaySet();
	}
	
	public RetuTicketDialog(double ticket_price,int fuel_construct,int fuel_oil,Ticket ticket){
		this.ticket = ticket;
		action = new Action();
		alloc(ticket_price,fuel_construct,fuel_oil);
		displaySet();
	}
	
	private void alloc(double ticket_price,int fuel_construct,int fuel_oil){//900,50,30
		double ticketprice = ticket_price-fuel_construct-fuel_oil;//900-50-30=820
		double poundage = ticketprice*0.2;   //原票价 820*0.2=164
		double finalprice = ticket_price-poundage; // 900-164=736
		this.setprice = (int)finalprice*(-1);  //  
//		this.ticket.setTod_price(finalprice*(-1));//设置机票价为改后的价格
		
		ticketInfLabel = new JLabel("航班号：TL");
		
		ticketPriceLabel = new JLabel("机票原价");
		airportPriceLabel = new JLabel("机场建设费");
		oilTaxLabel = new JLabel("燃油税");
		progressPriceLabel = new JLabel("手续费");
		
		ticketPriceText = new JTextField(5);
		ticketPriceText.setText(ticketprice+"");
		airportPriceText = new JTextField(5);
		airportPriceText.setText(fuel_construct+"");
		oilTaxText = new JTextField(5);
		oilTaxText.setText(fuel_oil+"");
		progressPriceText = new JTextField(5);
		progressPriceText.setText((int)poundage+"");
		
		returnTitleLabel = new JLabel("应找还顾客");
		returnPriceLabel = new JLabel();
		
		returnPriceLabel.setFont(new Font("宋体",Font.BOLD, 24));
		returnPriceLabel.setForeground(Color.RED);
		returnPriceLabel.setText((int)finalprice+"");
		
		acceptBtn = new JButton("确认退票");
		acceptBtn.addActionListener(this);
		cancelBtn = new JButton("取消退票");
		cancelBtn.addActionListener(this);
		
	}
	
	private void displaySet(){
		this.setSize(600,300);
		this.setLocation(300, 200);
		JPanel jmain = new JPanel();
		this.add(jmain);
		
		jmain.setLayout(new BoxLayout(jmain, BoxLayout.Y_AXIS));
		
		TitledBorder tb = new TitledBorder("机票信息");
		JLayeredPane jlp = new JLayeredPane();
		jlp.setBorder(tb);
		jmain.add(jlp);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		jlp.add(jp);
		jp.add(ticketInfLabel);
		
		tb = new TitledBorder("应收票款");
		
		jlp = new JLayeredPane();
		jlp.setBorder(tb);
		jmain.add(jlp);
		
		jlp.setLayout(new BoxLayout(jlp, BoxLayout.Y_AXIS));
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp.add(ticketPriceLabel);
		jp.add(ticketPriceText);
		
		jp.add(airportPriceLabel);
		jp.add(airportPriceText);
		
		jp.add(oilTaxLabel);
		jp.add(oilTaxText);
		
		jp.add(progressPriceLabel);
		jp.add(progressPriceText);
		
		
		jlp.add(jp);
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp.add(returnTitleLabel);
		jp.add(returnPriceLabel);

//		returnPriceLabel.setFont(new Font("宋体",Font.BOLD, 24));
//		returnPriceLabel.setForeground(Color.RED);
		//returnPriceLabel.setText("916.00");
		
		jlp.add(jp);
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(acceptBtn);
		jp.add(cancelBtn);
		jmain.add(jp);
		
		this.repaint();
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确认退票")){
			/**
			 * 得到用户输入的数据
			 */
			
			Request req = new Request(Request.RETURN_TICKET_REQUEST);
			
			User user = (User)LoginFrame.onlineUsers.get("user");
			System.out.println("========"+user);
			//req.addData("user", user);
			//req.addData("ticket",ticket);
		//	req.addData("price", this.setprice);
			String[] str = new String[50];
			String s = String.valueOf(user.getId());			
			str[0]=s;
			str[1] =ticket.getPsg_certif_numl();
			System.out.println(str[0]);
			System.out.println(str[1]);
			req.addData("IdCertifNum",str);
			Response res = action.doAction(req);
			System.out.println("-------有返回结果了");
			
			Object  bool = res.getData("boolean");
			boolean b = (Boolean)bool;
			if(b){
				this.dispose();
				ReturnTicketPanel2.SearchFlightResultItemPanel.removeAll();
				ReturnTicketPanel2.SearchFlightResultItemPanel.updateUI();
			}else{
				this.dispose();
				JOptionPane.showConfirmDialog(this,"退票失败","退票信息",JOptionPane.INFORMATION_MESSAGE);
			}
			
			/**
			 * 封装数据
			 */
			//?????
			/**
			 * 得到查询后的数据，应该返回的是一个集合
			 */
			//??????
		}else if(e.getActionCommand().equals("取消退票")){
			System.out.println("========取消退票成功");
			this.dispose();
		}
		
	}
   
}
