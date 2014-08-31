package com.tolo.tabcs.business.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import com.tolo.tabcs.common.gui.SimpleCal;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class ChanTicketDialog extends JDialog implements ActionListener{

	//private JFrame frame;// 父窗口
	private JLabel ticketInfLabel;
	private JLabel beforePriceLabel;
	private JLabel afterPriceLabel;
	private JLabel flightIdLabel;
	private JLabel dateLabel;
	private JLabel typeSeatsLabel;
		
	
	private JTextField field1 = null;
	private JFrame frame;// 父窗口
	
	private JTextField beforePriceText;
	private JTextField afterPriceText;
	private JTextField flightIdText;//航班号
	private JTextField DateText; //日期
	private JComboBox jcbb; // 可选项
	
	private JLabel getTitleLabel;
	private JLabel getPriceLabel;
	
	private JButton acceptBtn;
	private JButton cancelBtn;
	
	private List list;      //传递的参数
	private String cabin_type;  //舱位类型
	
//	private TicketOrder ticket;
	private Action action;   //
	private double discount2; //折扣
	
	private int ticketPrice;    //价格
	private Ticket ticket;
	private int Price;
	private String psgName;
/*	public ChanTicketDialog(String dat){
		action = new Action();

		//this.list = l;
		alloc();
		displaySet();
	}*/
	
	public ChanTicketDialog (String psgName,int ticketPrice,List l){
//		this.ticket = ticket;
		action = new Action();

		this.list = l;
		this.ticketPrice =ticketPrice;
		this.psgName =psgName;
		alloc();
		displaySet();
	}

	private void alloc(){
		System.out.println(psgName);System.out.println(ticketPrice);
	//	discount2 = this.ticket.getTod_cabin().getCd_re();	
//		cabin_type = this.ticket.getTod_cabin().getCd_type();	
		ticketInfLabel = new JLabel("航班号：TL");
		
		beforePriceLabel = new JLabel("原机票票价");
		afterPriceLabel = new JLabel("现机票票价");
		flightIdLabel = new JLabel("航班号");
		dateLabel = new JLabel("日期");
		typeSeatsLabel=new JLabel("舱位等级");
		
	
		
//		beforePriceText = new JTextField(this.ticket.getTod_price()+"",5);
		beforePriceText = new JTextField(5);
		afterPriceText = new JTextField(5);
		flightIdText = new JTextField(5);
		
		DateText = new JTextField(8);		
		jcbb=new JComboBox();
		
		jcbb.addItem("头等舱");jcbb.addItem("公务舱");jcbb.addItem("经济舱");
		
		jcbb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			 	discount2=1.0;
				double discount1 = discount2; // 1
				System.out.println("舱位系数2  "+discount2);
				String str = (String)jcbb.getSelectedItem();
				if(str.equals("头等舱")){
					cabin_type = "F";
					discount1 = (Double)list.get(0);   // 0.9头等藏打9折
					
					System.out.println("+++++++"+list.get(0));
				}else if(str.equals("公务舱")){    //0.8
				cabin_type = "C";
				 discount1 = (Double)list.get(1);
				}else if(str.equals("经济舱")){
					cabin_type = "Y";
					discount1 = (Double)list.get(2);  //0.6
				}
				System.out.println("舱位系数1"+   discount1);
	
			//	int afterprice = (int)(ticketPrice/discount2*discount1);
				int afterprice = (int)(ticketPrice/discount2*discount1);
				 beforePriceText.setText(ticketPrice+"");
				 afterPriceText.setText(afterprice+""); 
				 //差价为
				 int price=(int)(afterprice-ticketPrice);
				 String p =String.valueOf(price);
				 getPriceLabel.setText(p);
				 
				 
			// int afterprice = (int)(ChanTicketDialog.this.ticket.getTod_price()/discount2*discount1);
//			 afterPriceText.setText(afterprice+"");
//			 getPriceLabel.setText((afterprice-ChanTicketDialog.this.ticket.getTod_price())+"");
			 
			// ticket.setTod_price(afterprice-ChanTicketDialog.this.ticket.getTod_price());//设置为改签后的机票价
//			 price = (int)(afterprice-ChanTicketDialog.this.ticket.getTod_price());
			}
		});
		
		getTitleLabel = new JLabel("应收取顾客");
		getPriceLabel = new JLabel();
		
		acceptBtn = new JButton("确认改签");
		acceptBtn.addActionListener(this);
		cancelBtn = new JButton("取消改签");
		cancelBtn.addActionListener(this);
		
		
	}
	private void displaySet(){
		this.setSize(600,300);
		this.setVisible(true);
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
		
		
		tb = new TitledBorder("改签内容");
		jlp = new JLayeredPane();
		jlp.setBorder(tb);
		jmain.add(jlp);
		
		jlp.setLayout(new BoxLayout(jlp, BoxLayout.Y_AXIS));
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jp.add(flightIdLabel);
		jp.add(flightIdText);
		
		jp.add(dateLabel);
	    jp.add(DateText);

		

		
		jp.add(typeSeatsLabel);
		jp.add(jcbb);
		
		jlp.add(jp);
		
		tb = new TitledBorder("应收款项");
		jlp = new JLayeredPane();
		jlp.setBorder(tb);
		jmain.add(jlp);
		
		jlp.setLayout(new BoxLayout(jlp, BoxLayout.Y_AXIS));
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jp.add(beforePriceLabel);
		jp.add(beforePriceText);
		
		jp.add(afterPriceLabel);
		jp.add(afterPriceText);
		
		jlp.add(jp);
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp.add(getTitleLabel);
		jp.add(getPriceLabel);

		getPriceLabel.setFont(new Font("宋体",Font.BOLD, 24));
		getPriceLabel.setForeground(Color.GREEN);
	//	getPriceLabel.setText("0");
		
		
		jlp.add(jp);
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(acceptBtn);
		jp.add(cancelBtn);
		jlp.add(jp);
		jmain.add(jp);
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确认改签")){
//			ticket.setTod_go_date(DateText.getText());
//			ClassDiscount discount = new ClassDiscount();
//			discount.setCd_type(cabin_type);
//			ticket.setTod_cabin(discount);
//			ticket.setTod_price(Double.parseDouble(afterPriceText.getText()));
			/*
			 String p =String.valueOf(price);
			 getPriceLabel.setText(p);*/
			String s1 = getPriceLabel.getText();
			User user = (User)LoginFrame.onlineUsers.get("user");
			System.out.println("========"+user);
			
			//String[] str = new String[50];
			String userId = String.valueOf(user.getId());
			
			String[]  str = new String[50];
			String date = DateText.getText();
			System.out.println("============当前日期"+date);
			str[0] =psgName;
			str[1]=date;
			str[3] =userId;	
			str[4] =s1;
			Request req = new Request(Request.CHANGE_TICKET_REQUEST);
			req.addData("change", str);
//			req.addData("ticket", ticket);
		// req.addData("user", LoginFrame.onlineUsers.get("user"));
	
			Response res = action.doAction(req);
		    System.out.println("=========改签有返回数据了拉");
		 boolean b = (Boolean)res.getData("boolean");
			if(b){
				this.dispose();
//				ReturnTicketPanel.retuTickInfoPane.removeAll();
//				ReturnTicketPanel.retuTickInfoPane.updateUI();
			}else{
				JOptionPane.showConfirmDialog(this,"改签失败","改签信息",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
			
		}else if(e.getActionCommand().equals("取消改签")){
			this.dispose();
		}		
    
	}
		
}
