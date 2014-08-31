package com.tolo.tabcs.manage.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class ModifyFlightDialogschPanel extends AddFlightDialogSchedule{
	private Action action ;
	private static final long serialVersionUID = 12312123L;
	private String[] strs;  //{ flightId, starts, ends, start,end
	protected ModifyFlightDialogschPanel(JFrame frame,String[] strs) {
		super(frame);
		action = new Action();
		this.strs = strs;
		updataVisiable();	
	}

	private void updataVisiable(){
		flightIdText.setText(strs[0]);
		flightIdText.setEditable(false);
		
		fromText.setText(strs[1]);
//		fromText.setEditable(false);
	
		toTextf.setText(strs[2]);
//		toTextf.setEditable(false);
		
		
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
					Request req1 = new Request(Request.UPDATE_FLIGHT_SCHEDULER_REQUEST);
					if(startText.getText().trim().equals("")||endText.getText().trim().equals("")||
				basicPriceText.getText().trim().equals("")||fromText.getText().trim().equals("")||toTextf.getText().trim().equals("")){
						JOptionPane.showMessageDialog(ModifyFlightDialogschPanel.this, "信息必须填写完整!");
						req1.addData("flight", null);
						return;
						}else{
							ModifyFlightDialogschPanel.this.dispose();
							FlightPlan f = new FlightPlan();
							f.setFlight_num(fls_num);
							SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");
							Date depu = null;
							Date arr = null;
							Date start = null;
							Date end = null;
							try {
								depu = fmt.parse(startText.getText());
								arr = fmt.parse(endText.getText());
								fmt =new SimpleDateFormat("yyyy-MM-dd");
								start = fmt.parse(fromText.getText());
								end = fmt.parse(toTextf.getText());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							int flightDate = ((Integer)flightDateText.getSelectedItem()).intValue();//航线
							int flighttime = Integer.parseInt(flightTypeText.getText());//班期数
							double pricedis = Double.parseDouble(basicPriceText.getText());//经济舱季节折扣
							f.setFp_departure_Date(startText.getText().trim());
							f.setFp_arrival_Date(endText.getText().trim());
							
							f.setFp_start_date(start);
							f.setFp_end_date(end);
							f.setRoute_id(flightDate);
							f.setFp_scheduler(flighttime);
							f.setFp_season_discount(pricedis);
							req1.addData("flight", f);
							System.out.println(f);
						}
					Response res1 = action.doAction(req1);
					boolean bool = (Boolean)res1.getData("boolean");
					if(bool){
						JOptionPane.showMessageDialog(ModifyFlightDialogschPanel.this, "修改成功");
						ModifyFlightDialogschPanel.this.dispose();
					}else{
						JOptionPane.showMessageDialog(ModifyFlightDialogschPanel.this, "修改失败");
						ModifyFlightDialogschPanel.this.dispose();
					}
				} else if (str.equals("取消")) {
					ModifyFlightDialogschPanel.this.dispose();
				}
			}
		};
		confirmButton.addActionListener(al);
		cancelButton.addActionListener(al);
		
	}


}
