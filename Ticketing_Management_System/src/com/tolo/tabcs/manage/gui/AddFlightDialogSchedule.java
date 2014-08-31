package com.tolo.tabcs.manage.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

/**
 * 
 * 增加新航班
 */
@SuppressWarnings("serial")
public class AddFlightDialogSchedule extends JDialog{
	protected JFrame frame;

	protected JLabel flightIdLabel, fromLabel, toLabel, flightDateLabel,
			startLabel, endLabel, flightTypeLabel, basicPriceLable;

	protected JTextField flightIdText, fromText, toTextf,
			startText, endText, basicPriceText,flightTypeText;

	protected JComboBox flightDateText;

	protected String[] flightTypes;

	protected JButton confirmButton, cancelButton;
	
	private Action action;

	protected AddFlightDialogSchedule(JFrame frame) {
		action = new Action(); //{ flightId, starts, ends, start,end }
		this.frame = frame;
		flightIdLabel = new JLabel("航班号");
		fromLabel = new JLabel("计划开始日期");
		toLabel = new JLabel("计划结束日期");
		flightDateLabel = new JLabel("航线编号");
		startLabel = new JLabel("离港时间");
		endLabel = new JLabel("到港时间");
		flightTypeLabel = new JLabel("航班班期");
		basicPriceLable = new JLabel("经济舱季节折扣");
		flightIdText = new JTextField(9);
		fromText = new JTextField(9);
		toTextf = new JTextField(9);
		Request req = new Request(Request.SEARCH_AIRLINE_REQUEST_BYNONE);
		Response res = action.doAction(req);
		Integer[] airlines = (Integer[])res.getData("airLine");
		flightDateText = new JComboBox(airlines);
		startText = new JTextField(9);
		endText = new JTextField(9);
//		flightTypeText = new JComboBox(flightTypes);//飞机机型
		flightTypeText = new JTextField(9);
		basicPriceText = new JTextField(9);//经济舱季节折扣
		
		confirmButton = new JButton("确认");
//		confirmButton.addActionListener(AddFlightDialog.this);
		cancelButton = new JButton("取消");
//		cancelButton.addActionListener(AddFlightDialog.this);

		init();
		addEventHandler();
		showMe();
	}

	protected void init() {
		this.setLayout(new GridLayout(10, 1));
		JPanel Panel1 = new JPanel();
		Panel1.setLayout(new FlowLayout());
		JPanel Panel2 = new JPanel();
		Panel2.setLayout(new FlowLayout());
		JPanel Panel3 = new JPanel();
		Panel3.setLayout(new FlowLayout());
		JPanel Panel4 = new JPanel();
		Panel4.setLayout(new FlowLayout());
		JPanel Panel5 = new JPanel();
		Panel5.setLayout(new FlowLayout());
		JPanel Panel6 = new JPanel();
		Panel6.setLayout(new FlowLayout());
		JPanel Panel7 = new JPanel();
		Panel7.setLayout(new FlowLayout());
		JPanel Panel8 = new JPanel();
		Panel8.setLayout(new FlowLayout());
		JPanel Panel9 = new JPanel();
		Panel9.setLayout(new FlowLayout());
		JPanel Panel10 = new JPanel();
		Panel10.setLayout(new FlowLayout());

		Panel1.add(flightIdLabel);
		Panel1.add(flightIdText);

		Panel2.add(fromLabel);
		Panel2.add(fromText);

		Panel3.add(toLabel);
		Panel3.add(toTextf);

		Panel4.add(flightDateLabel);
		Panel4.add(flightDateText);//航线列表

		Panel5.add(startLabel);
		Panel5.add(startText);

		Panel6.add(endLabel);
		Panel6.add(endText);

		Panel7.add(flightTypeLabel);
		Panel7.add(flightTypeText);//航班班期

		Panel8.add(confirmButton);
		Panel8.add(cancelButton);

		Panel9.add(basicPriceLable);
		Panel9.add(basicPriceText);

		this.add(Panel1);
		this.add(Panel2);
		this.add(Panel3);
		this.add(Panel4);
		this.add(Panel5);
		this.add(Panel6);
		this.add(Panel7);
		this.add(Panel9);
		this.add(Panel10);
		this.add(Panel8);
	}

	protected void showMe() {
		this.pack();
		this.setVisible(true);
		this.setLocation(300, 240);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	protected void addEventHandler() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				if (str.equals("确认")) {
					AddFlightDialogSchedule.this.dispose();
					// ????确认数据
					AddFlightDialogSchedule.this.dispose();
//					Airline aline = new Airline();
//					Airport ap1 = new Airport();
//					Airport ap2 = new Airport();
//					
					String fls_num = flightIdText.getText();
					String go_place = fromText.getText();
					String arr_place = toTextf.getText();
//					ap1.setAp_city(go_place);
//					ap2.setAp_city(arr_place);
//					
//					aline.setAl_from(ap1);
//					aline.setAl_to(ap2);
					
					Request req = new Request(Request.ADD_FLIGHT_SCHEDULER_REQUEST);
					if(!(((String)flightDateText.getSelectedItem()).trim().equals(""))){
					
					int scheduler_date = Integer.parseInt(((String)flightDateText.getSelectedItem()));
				  String go_time = startText.getText().trim();
				  String arr_time = endText.getText().trim();
				  double price = Double.parseDouble(basicPriceText.getText().trim()); 
					
				  String plane_type = (String)flightTypeText.getText();
//					FlightScheduler fls = new FlightScheduler();
//					fls.setFls_airline(aline);
//					fls.setFls_airplanemodel(plane_type);
//					fls.setFls_num(fls_num);
//					fls.setFls_departure(go_time);
//					fls.setFls_arrival(arr_time);
//					fls.setFls_scheduler(scheduler_date);
//					fls.setFls_fullprice(price);
//
//					req.addData("flight", fls);
					}else{
						req.addData("flight", null);
					}
					
					Response res = action.doAction(req);
					boolean bool = (Boolean)res.getData("boolean");
					if(bool){
						JOptionPane.showMessageDialog(frame, "添加成功");
						AddFlightDialogSchedule.this.dispose();
					}else{
						JOptionPane.showMessageDialog(frame, "添加失败");
						AddFlightDialogSchedule.this.dispose();
					}
				} else if (str.equals("取消")) {
					AddFlightDialogSchedule.this.dispose();
				}
			}
		};
		confirmButton.addActionListener(al);
		cancelButton.addActionListener(al);
	}
//		flightDateText.addFocusListener(new FocusListener() {
//			public void focusGained(FocusEvent e) {
//				frame.setVisible(true);
//				frame.setLocation(300, 340);
//				new SimpleCal(frame, flightDateText).setVisible(true);
//				frame.dispose();
//				flightDateText.setFocusable(false);
//				flightDateText.setFocusable(true);
//			}
//
//			public void focusLost(FocusEvent e) {
//			}
//		});
//	}
//	
	
	
	
	
	
//	public void actionPerformed(ActionEvent e) {
//		String str = e.getActionCommand();
//		if (str.equals("确认")) {
//			AddFlightDialog.this.dispose();
//			Airline aline = new Airline();
//			Airport ap1 = new Airport();
//			Airport ap2 = new Airport();
//			
//			String fls_num = flightIdText.getText();
//			String go_place = fromText.getText();
//			String arr_place = toTextf.getText();
//			ap1.setAp_city(go_place);
//			ap2.setAp_city(arr_place);
//			
//			aline.setAl_from(ap1);
//			aline.setAl_to(ap2);
//			
//			int scheduler_date = Integer.parseInt(flightDateText.getText());
//		  String go_time = startText.getText();
//		  String arr_time = endText.getText();
//		  double price = Double.parseDouble(basicPriceText.getText()); 
//			
//		  String plane_type = (String)flightTypeText.getSelectedItem();
//			FlightScheduler fls = new FlightScheduler();
//			fls.setFls_airline(aline);
//			fls.setFls_airplanemodel(plane_type);
//			fls.setFls_num(fls_num);
//			fls.setFls_departure(go_time);
//			fls.setFls_arrival(arr_time);
//			fls.setFls_scheduler(scheduler_date);
//			fls.setFls_fullprice(price);
//			
//			Request req = new Request(Request.ADD_FLIGHT_SCHEDULER_REQUEST);
//			req.addData("flight", fls);
//			
//			Response res = action.doAction(req);
//			boolean bool = (Boolean)res.getData("boolean");
//			if(bool){
//				JOptionPane.showMessageDialog(frame, "添加成功");
//				AddFlightDialog.this.dispose();
//			}else{
//				JOptionPane.showMessageDialog(frame, "添加失败");
//				AddFlightDialog.this.dispose();
//			}
//			
//			
//		}else if(str.equals("取消")){
//			AddFlightDialog.this.dispose();
//		}
//	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("asdfa");
		f.setLocation(150, 150);
		f.setSize(600, 600);
		f.setVisible(true);
		new AddFlightDialogSchedule(f).showMe();
	}
	
}
