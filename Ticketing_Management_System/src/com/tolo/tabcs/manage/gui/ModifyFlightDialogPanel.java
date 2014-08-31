package com.tolo.tabcs.manage.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class ModifyFlightDialogPanel extends AddFlightDialog{
	/**
	 * 
	 */
	private Action action ;
	private static final long serialVersionUID = 12312123L;
	private String[] strs;
	
	protected ModifyFlightDialogPanel(JFrame frame,String[] airplanemodel,String[] strs) {
		super(frame,airplanemodel);
		action = new Action();
		this.strs = strs;
		updataVisiable();	
	}

	private void updataVisiable(){
		flightIdText.setText(strs[0]);
		flightIdText.setEditable(false);
		
		fromText.setText(strs[1].trim());
		fromText.setEditable(false);
	
		toTextf.setText(strs[2].trim());
		toTextf.setEditable(false);
		
		
		startText.setText(strs[3]);
		
		endText.setText(strs[4]);
		
		
	}

	@Override
	public void addEventHandler() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				if (str.equals("确认")) {
					String fls_num = flightIdText.getText();
					Request req1 = new Request(Request.UPDATE_FLIGHT_REQUEST);
					if(startText.getText().trim().equals("")||endText.getText().trim().equals("")||
							basicPriceText.getText().trim().equals("")){
						JOptionPane.showMessageDialog(ModifyFlightDialogPanel.this, "信息必须填写完整!");
						req1.addData("flight", null);
						return;
					}else{
						ModifyFlightDialogPanel.this.dispose();
						String flightType = (String)flightTypeText.getSelectedItem();
						int flightDate = ((Integer)flightDateText.getSelectedItem()).intValue();//航线
						Flight flight = new Flight();
						flight.setFlight_num(fls_num);
						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
						Date depu = null;
						Date arr = null;
						try {
							depu = fmt.parse(startText.getText());
							arr = fmt.parse(endText.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						flight.setFlight_departu_date(depu);
						flight.setFlight_arrival_date(arr);
						flight.setRoute_id(flightDate);
						flight.setLowest_discount_price(Integer.parseInt(basicPriceText.getText()));
						Request req = new Request(Request.SEARCH_PLANEID_REQUEST);
						req.addData("type", flightType);
						Response response= action.doAction(req);
						int plane_id =((Integer)response.getData("planeId")).intValue();
						flight.setPlane_id(plane_id);
						req1.addData("flight", flight);
//						System.out.println(plane_id+" /ss");
//						System.out.println(flight);
					}
					
//					if(!(((String)flightDateText.getSelectedItem()).trim().equals(""))){
//						
//					 int scheduler_date = Integer.parseInt(((String)flightDateText.getSelectedItem()).trim());
//				  double price = Double.parseDouble(basicPriceText.getText().trim()); 
//					
//				  String plane_type = (String)flightTypeText.getSelectedItem();
////					FlightScheduler fls = new FlightScheduler();
////					fls.setFls_airplanemodel(plane_type);
////					fls.setFls_num(fls_num);
////					fls.setFls_scheduler(scheduler_date);
////					fls.setFls_fullprice(price);
////					req.addData("flight", fls);
//					}else{
//						JOptionPane.showMessageDialog(frame, "请输入数据");
//						req1.addData("flight", null);
//					}
					
					Response res1 = action.doAction(req1);
					boolean bool = (Boolean)res1.getData("boolean");
					if(bool){
						JOptionPane.showMessageDialog(ModifyFlightDialogPanel.this, "修改成功");
						ModifyFlightDialogPanel.this.dispose();
					}else{
						JOptionPane.showMessageDialog(ModifyFlightDialogPanel.this, "修改失败");
						ModifyFlightDialogPanel.this.dispose();
					}
				} else if (str.equals("取消")) {
					ModifyFlightDialogPanel.this.dispose();
				}
			}
		};
		confirmButton.addActionListener(al);
		cancelButton.addActionListener(al);
		
	}


//	public void actionPerformed(ActionEvent e) {
//		super.actionPerformed(e);
//		String str = e.getActionCommand();
//		if (str.equals("确认")) {
//			
//			System.out.println("jinglaimei===============");
//			ModifyFlightDialogPanel.this.dispose();	
//			int scheduler_date = Integer.parseInt(flightDateText.getText());
//		  double price = Double.parseDouble(basicPriceText.getText()); 
//			
//		  String plane_type = (String)flightTypeText.getSelectedItem();
//			FlightScheduler fls = new FlightScheduler();
//			fls.setFls_airplanemodel(plane_type);
//			fls.setFls_num(fls_num);
//			fls.setFls_scheduler(scheduler_date);
//			fls.setFls_fullprice(price);
//			
//			Request req = new Request(Request.UPDATE_FLIGHT_SCHEDULER_REQUEST);
//			req.addData("flight", fls);
//			
//			Response res = action.doAction(req);
//			boolean bool = (Boolean)res.getData("boolean");
//			if(bool){
//				JOptionPane.showMessageDialog(frame, "修改成功");
//				ModifyFlightDialogPanel.this.dispose();
//			}else{
//				JOptionPane.showMessageDialog(frame, "修改失败");
//				ModifyFlightDialogPanel.this.dispose();
//			}
//			
//			
//		}else if(str.equals("取消")){
//			ModifyFlightDialogPanel.this.dispose();
//		}
//	}
	
}
