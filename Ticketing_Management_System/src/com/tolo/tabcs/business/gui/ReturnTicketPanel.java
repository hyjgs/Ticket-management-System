package com.tolo.tabcs.business.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
/**
 * @author TangLiang
 */
public class ReturnTicketPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 52418612315L;
	private JFrame frame;
	private JLabel lblTickId,lblPassName,lblPassId;
	private JTextField txtTickId,txtPassName,txtPassId;
	private JButton btnCheck;
	private Action action;

//	public TicketOrder ticket;//票
//	public FlightScheduler fls;//航班计划
	
	public ReturnTicketPanel(JFrame frame){
		action = new Action();
		this.frame=frame;
		lblTickId = new JLabel("机票编号:");
		lblPassName = new JLabel("乘客姓名:");
		lblPassId = new JLabel("证件号码:");
		txtTickId = new JTextField(16);//机票编号
		txtPassName = new JTextField(4);//乘客姓名
		txtPassId = new JTextField(13);//证件号码
		btnCheck = new JButton("查询");
	//	btnCheck.addActionListener(this);
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
		frame.setBounds(100, 200, 690, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

//	public static JPanel retuTickCenPane;//静态退票面板
 
//	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("查询")){
////			TicketOrder req_ticket = new TicketOrder();//请求票
////			TicketOrder res_ticket = null;//应答票
//			/**
//			 * 得到用户输入的数据
//			 */
//			String ticketID = txtTickId.getText().trim();
//			String pass_name = txtPassName.getText().trim();
//			String pass_num = txtPassId.getText().trim();
//			/**
//			 * 封装数据
//			 */
//
//			if(!ticketID.equals("")){
//			int id = Integer.parseInt(ticketID);
////			req_ticket.setOrd_id(id);
////			}else{
////				req_ticket.setTod_pass_name(pass_name);
////				req_ticket.setTod_pass_certnum(pass_num);
////			}
//			/**
//			 * 得到查询后的数据，应该返回的是一个集合
//			 */
//			
//			Request req = new Request(Request.SEARCH_TICKET_REQUEST);
////			req.addData("req_ticket", req_ticket);
////			
////			Response res = action.doAction(req);
////			Object obj = res.getData("res_ticket");
////			if(obj!=null){
////			res_ticket = (TicketOrder)obj;
////			ticket = res_ticket;
////			FlightScheduler fs = (FlightScheduler)res.getData("flightscheduler");
////			this.fls = fs;
////			Airline al = fs.getFls_airline();
////			String str3 = al.getAl_from().getAp_city()+al.getAl_from().getAp_name();
////			String str4 = al.getAl_to().getAp_city()+al.getAl_to().getAp_name();
//			
//			/**
//			 * 界面显示数据
//			 */
//			//******
//
//			retuTickCenPane=new JPanel();
//			
//			JScrollPane jsp=new JScrollPane(retuTickCenPane);
//			
//			retuTickCenPane.setLayout(new BoxLayout(retuTickCenPane,BoxLayout.Y_AXIS));
//			
////			ShowTicketInfoPanel stp = new ShowTicketInfoPanel(res_ticket,str3,str4);
////				JButton retuTicketBtn=new JButton("退票");
////				retuTicketBtn.addActionListener(this);
////				JButton chanTicketBtn=new JButton("改签");
////				chanTicketBtn.addActionListener(this);
////				JPanel retuTickInfoPane=new JPanel();
////				retuTickInfoPane.setLayout(new FlowLayout(FlowLayout.CENTER,25,5));
////				retuTickInfoPane.add(stp);
////				retuTickInfoPane.add(retuTicketBtn);
////				retuTickInfoPane.add(chanTicketBtn);
////				retuTickInfoPane.setBorder(BorderFactory.createTitledBorder(""));
////				retuTickCenPane.removeAll();
////
////				retuTickCenPane.add(retuTickInfoPane);
////				retuTickCenPane.updateUI();
////			this.add(jsp,BorderLayout.CENTER);
////			frame.setVisible(true);   //******************************************
////			}else{
////				JOptionPane.showMessageDialog(frame, "没有此记录");
////				if(retuTickCenPane!=null){
////					retuTickCenPane.removeAll();
////					retuTickCenPane.updateUI();
////				}
////			}
////		}else if(e.getActionCommand().equals("退票")){
////			TicketOrder ticket = this.ticket;
////			FlightScheduler fls = this.fls;
////			double ticket_price = ticket.getTod_price();	
////			Request req = new Request(Request.SEARCH_OIL_CONSTRUCT_REQUEST);
////			req.addData("ticket",ticket);
////			req.addData("flightscheduler", fls);
////			
////			Response res = action.doAction(req);
////			int fuel_cons = (Integer)res.getData("fuelcons");
////			int fuel_oil = (Integer)res.getData("fueloil");
////			new RetuTicketDialog(ticket_price,fuel_cons,fuel_oil,this.ticket).setVisible(true);		
////		}else if(e.getActionCommand().equals("改签")){
////			Request req3 = new Request(Request.SEARCH_CABIN_DISCOUNT_REQUEST);
////			Response res3=action.doAction(req3);
////			List l = new ArrayList();
////			l.add(res3.getData("cabin_disF"));l.add(res3.getData("cabin_disC"));l.add(res3.getData("cabin_disY"));
////			new ChanTicketDialog(l,this.ticket).setVisible(true);
////		}
//	}

}
