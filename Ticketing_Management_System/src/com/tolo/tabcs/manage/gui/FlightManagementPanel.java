package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.gui.MySimpleCal;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

@SuppressWarnings("serial")
public class FlightManagementPanel extends JPanel {
	private JFrame frame;

	private JPanel flightManagementPanelTitlePanel;

	private JPanel flightManagementPanelItemPanel;

	private JPanel flightManagementPanelLastPanel;

	private JPanel searchFlightPanel, flightIdPanel, fromPanle, toPanel,
			searchButtonPanel;

	private JLabel searchFlightLabel, flightIdLabel, fromLabel, toLabel;

	private JTextField flightIdText;// fromText, toText;
	private  JComboBox jcb1,jcb2;//可编辑下拉条
	//删除航班计划更改航班计划(起飞时间，到达时间，执行机型，基准票价)查询航班计划
	private JButton searchButton, addNewFlightPlanButton
			, searchFlightPlanButton,updateSeasonalDiscountsButton,addFlightButton//删除航班和添加航班
			;//修改季节折扣
	
	private JScrollPane jsp;// 滚动面板
	
	private Action action = new Action();
	
	private int plane_scheduler = 0;

	public FlightManagementPanel() {
		super();
		frame = new JFrame();

		flightManagementPanelTitlePanel = new JPanel();
		flightManagementPanelItemPanel = new JPanel();
		flightManagementPanelLastPanel = new JPanel();
		searchFlightPanel = new JPanel();
		flightIdPanel = new JPanel();
		fromPanle = new JPanel();
		toPanel = new JPanel();
		searchButtonPanel = new JPanel();
		searchFlightLabel = new JLabel("查询航班/计划：");
		searchFlightLabel.setFont(new Font("宋体", Font.BOLD, 16));
		flightIdLabel = new JLabel("        航班号：");
		fromLabel = new JLabel("    出发地");
		toLabel = new JLabel("    目的地");
		flightIdText = new JTextField(8);
		 jcb1=new JComboBox(new
		 String[]{"","北京-首都机场","上海-虹桥机场","上海-浦东机场","广州-白云机场","深圳-宝安机场","珠海-三沼机场","汕头-外沙机场","梅县-梅县机场","杭州-萧山机场","宁波-乐社机场","温州-永强机场","义乌-义乌机场","成都-双流机场","绵阳-绵阳机场","长春-大方身机场","吉林-二台子机场","延吉-延吉机场","乌鲁木齐-地窝堡机场","喀什-喀什机场"});
//		fromText = new JTextField(8);
		 jcb2=new JComboBox(new
		 String[]{"","北京-首都机场","上海-虹桥机场","上海-浦东机场","广州-白云机场","深圳-宝安机场","珠海-三沼机场","汕头-外沙机场","梅县-梅县机场","杭州-萧山机场","宁波-乐社机场","温州-永强机场","义乌-义乌机场","成都-双流机场","绵阳-绵阳机场","长春-大方身机场","吉林-二台子机场","延吉-延吉机场","乌鲁木齐-地窝堡机场","喀什-喀什机场"});
//		toText = new JTextField(8);
		 jcb1.setEditable(true);//------------------------------------------------------------------------
		 jcb2.setEditable(true);//-----------------------------------------------------------------------
		searchButton = new JButton("查询");
		addNewFlightPlanButton = new JButton("添加新计划");
//		deleteFlightPlanButton = new JButton("删除计划");
//		updateFlightPlanButton = new JButton("更改计划");
		searchFlightPlanButton = new JButton("查询计划");
		addFlightButton = new JButton("添加新航班");
//		deleteFlightButton = new JButton("删除航班");
//		alterSeasonalDiscountsButton = new JButton("修改季节折扣");
		updateSeasonalDiscountsButton = new JButton("批量更新季节折扣");
		jsp = new JScrollPane(flightManagementPanelItemPanel);

		init();
		addEventHandler();
		showMe();
	}

	private void init() {
		frame.add(this);
		this.setLayout(new BorderLayout());
		this.add(flightManagementPanelTitlePanel, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(flightManagementPanelLastPanel, BorderLayout.SOUTH);
		flightManagementPanelTitlePanel.setLayout(new FlowLayout());
		flightManagementPanelTitlePanel.add(searchFlightPanel);
		flightManagementPanelTitlePanel.add(flightIdPanel);
		flightManagementPanelTitlePanel.add(fromPanle);
		flightManagementPanelTitlePanel.add(toPanel);
		flightManagementPanelTitlePanel.add(searchButtonPanel);
		searchFlightPanel.add(searchFlightLabel);
		flightIdPanel.setLayout(new GridLayout(1, 2));
		flightIdPanel.add(flightIdLabel);
		flightIdPanel.add(flightIdText);
		fromPanle.setLayout(new FlowLayout());
		fromPanle.add(fromLabel);
		fromPanle.add(jcb1);// -----------------------------
		toPanel.setLayout(new FlowLayout());
		toPanel.add(toLabel);
		toPanel.add(jcb2);// ---------------------------------
		searchButtonPanel.setLayout(new GridLayout(1, 2, 6, 0));
		searchButtonPanel.add(searchButton);
		searchButtonPanel.add(searchFlightPlanButton);
;		flightManagementPanelLastPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 12, 0));
		flightManagementPanelLastPanel.add(addNewFlightPlanButton);
//		flightManagementPanelLastPanel.add(deleteFlightPlanButton);
//		flightManagementPanelLastPanel.add(updateFlightPlanButton);
		flightManagementPanelLastPanel.add(addFlightButton);
//		flightManagementPanelLastPanel.add(deleteFlightButton);
//		flightManagementPanelLastPanel.add(alterSeasonalDiscountsButton);
		flightManagementPanelLastPanel.add(updateSeasonalDiscountsButton);
		flightManagementPanelItemPanel.setLayout(new BoxLayout(
				flightManagementPanelItemPanel, BoxLayout.Y_AXIS));

		this.setBorder(BorderFactory.createTitledBorder("航班管理"));
		flightManagementPanelTitlePanel.setBorder(BorderFactory
				.createTitledBorder(""));
		flightManagementPanelItemPanel.setBorder(BorderFactory
				.createTitledBorder(""));
		flightManagementPanelLastPanel.setBorder(BorderFactory
				.createTitledBorder(""));
	}

	private void addEventHandler() {
		//增加新计划
		addNewFlightPlanButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(true);
				new AddFlightSchDialog(frame);
//				frame.dispose();
			}
			
		});
		//增加新航班
		addFlightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Request req = new Request(Request.SEARCH_AIRPLANE_REQUEST_BYNONE);
				Response res = action.doAction(req);
				String[] st1 = (String[])res.getData("airplanemodel");
				new AddFlightDialog(frame,st1);
			}
		});
		updateSeasonalDiscountsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(JOptionPane.showConfirmDialog(FlightManagementPanel.this, "接入更新折扣界面",
						"确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					final JDialog jd2 = new JDialog();
					JPanel jpz1 = new JPanel();
					JPanel jpz2 = new JPanel();
					
					jpz1.setLayout(new FlowLayout());
					JButton jbz1 = new JButton("确定");
					JButton jbz2 = new JButton("取消");
					jpz1.add(jbz1);
					jpz1.add(new JLabel("   "));
					jpz1.add(new JLabel("   "));
					jpz1.add(new JLabel("  "));
					jpz1.add(jbz2);

					jpz2.setLayout(new GridLayout(2,1));
					final JTextField jt = new JTextField(9);
					jpz2.add(new JLabel("新季节折扣:"));
					jpz2.add(jt);
					jbz1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(jt.getText().trim().equals("")){
								JOptionPane.showMessageDialog(FlightManagementPanel.this, "信息不能为空!");
							}else{
								if(jt.getText().trim().matches("^0\\.(\\d){1,2}")){
									Request req = new Request(Request.BATCH_UPDATE_SEASON_DISCOUNT_REQUEST);
									req.addData("disc", jt.getText().trim());
									Response res = action.doAction(req);
									boolean boo = (Boolean)res.getData("boolean");
									if(boo){
										JOptionPane.showMessageDialog(FlightManagementPanel.this, "更新成功");
										jd2.dispose();
										flightManagementPanelItemPanel.updateUI();
									}else{
										JOptionPane.showMessageDialog(FlightManagementPanel.this, "更新失败");
									}
								}else{
									JOptionPane.showMessageDialog(FlightManagementPanel.this, "数字格式不对,请输入小于1的两位小数");
									jt.setText("");
								}
							}
						}
					});
					jbz2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jd2.dispose();
						}
					});
					jd2.add(jpz1, BorderLayout.SOUTH);
					jd2.add(jpz2, BorderLayout.CENTER);
					jd2.setLocation(500, 300);
					jd2.setSize(200, 120);
					jd2.setVisible(true);
					jd2.setDefaultCloseOperation(jd2.DISPOSE_ON_CLOSE);
				}
//				JOptionPane.showMessageDialog(frame, "接入更新折扣界面");
			}
		});
		
		
		//查询航班计划
		searchFlightPlanButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flightManagementPanelItemPanel.removeAll();
				flightManagementPanelItemPanel.updateUI();
				JPanel panel = new JPanel();
				
				JPanel flightIdPanel = new JPanel();
				JPanel startsPanle = new JPanel();
				JPanel endsPanel = new JPanel();
				JPanel startPanel = new JPanel();
				JPanel endPanel = new JPanel();
				JPanel disPanel = new JPanel();
				JPanel timePanel = new JPanel();
				JPanel operatorPanel = new JPanel();
				panel.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 0));
				panel.setMaximumSize(new Dimension(1000, 40));
				panel.setMinimumSize(new Dimension(1000, 40));
				panel.setOpaque(false);
				panel.setPreferredSize(new Dimension(1000, 40));
				panel.add(flightIdPanel.add(new JLabel("航班号")));
				panel.add(startsPanle.add(new JLabel("       计划开始日期      ")));
				panel.add(endsPanel.add(new JLabel("  计划结束日期  ")));
				panel.add(startPanel.add(new JLabel("       离港时间      ")));
				panel.add(endPanel.add(new JLabel("    到港时间    ")));
				panel.add(timePanel.add(new JLabel("    班期   ")));
				panel.add(disPanel.add(new JLabel(" 经济舱季节折扣  ")));
				panel.add(operatorPanel.add(new JLabel("              操作")));
				panel.setBorder(BorderFactory.createTitledBorder(""));
				flightManagementPanelItemPanel.add(panel);
				String fls_int = flightIdText.getText().trim();
				String from_place = ((String)(jcb1.getSelectedItem())).trim();
				String to_place  = ((String)(jcb2.getSelectedItem())).trim();
				if(fls_int.equals("")&&from_place.equals("")&&to_place.equals("")){
					JOptionPane.showMessageDialog(FlightManagementPanel.this, "请输入有效完整信息!");
				}else{
				if(!fls_int.equals("")){
					Request req = new Request(Request.SEARCH_FLIGHT_SCHEDULER_REQUEST_BYID);
					req.addData("flight_num", fls_int);
					Response res = action.doAction(req);
					List<FlightPlan> flight = new ArrayList<FlightPlan>();
					flight.clear();
					flight=(List<FlightPlan>)res.getData("flightPlan");
					for (FlightPlan f : flight) {
						Date fd = f.getFp_start_date();//计划出发
						Date td = f.getFp_end_date();//计划结束
						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
						String fds = fmt.format(fd);
						String tds = fmt.format(td);
						fmt = new SimpleDateFormat("hh:mm:ss");//hh24:mi:ss
						String sds = f.getFp_departure_Date();//离港时期
						String eds = f.getFp_arrival_Date();//到港时间
						System.out.println(f.getFp_departure_Date());
						System.out.println(f.getFp_arrival_Date());
						System.out.println(sds);
						System.out.println(eds);
						int time = f.getFp_scheduler();
						double discount = f.getFp_season_discount();
						System.out.println("班期："+time);
						System.out.println("折扣:"+discount);
						JPanel p = getSearchFlightPlanResultItem(f.getFlight_num(), fds, tds, "       "+sds, "       "+eds, time, discount);
						flightManagementPanelItemPanel.add(p);
					   }
				}else{
					if(from_place.equals(to_place)){
						JOptionPane.showConfirmDialog(FlightManagementPanel.this, "出发地和目的地不能相同!");
					}else{
					if(from_place.equals("")||to_place.equals("")){
						
					}else{
						Request req = new Request(Request.SEARCH_FLIGHT_SCHEDULER_REQUEST);
						req.addData("from_place", from_place);
						req.addData("to_place", to_place);
						Response res = action.doAction(req);
						List<FlightPlan> flight = new ArrayList<FlightPlan>();
						flight.clear();
						flight = (List<FlightPlan>)res.getData("flightPlanMessage");
//						System.out.println(flight);
//						String[] tp = from_place.split("-");
//						String[] tp1 = to_place.split("-");
//						String from = tp[0];
//						String to = tp1[0];
					for (FlightPlan f : flight) {
						Date fd = f.getFp_start_date();//计划出发
						Date td = f.getFp_end_date();//计划结束
						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
						String fds = fmt.format(fd);
						String tds = fmt.format(td);
						fmt = new SimpleDateFormat("hh:mm:ss");//hh24:mi:ss
						String sds = f.getFp_departure_Date();//离港时期
						String eds = f.getFp_arrival_Date();//到港时间
						int time = f.getFp_scheduler();
						double discount = f.getFp_season_discount();
						JPanel p = getSearchFlightPlanResultItem(f.getFlight_num(),fds, tds, "       "+sds, "       "+eds, time, discount);
						flightManagementPanelItemPanel.add(p);
					   }
					}
				}
			}
		}
		     flightManagementPanelItemPanel.updateUI();	
			}
		});
		
		
		
		//查询航班
		searchButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {

				flightManagementPanelItemPanel.removeAll();
				flightManagementPanelItemPanel.updateUI();
				
				JPanel panel = new JPanel();
				
				JPanel flightIdPanel = new JPanel();
				JPanel fromPanle = new JPanel();
				JPanel toPanel = new JPanel();
				JPanel startPanel = new JPanel();
				JPanel endPanel = new JPanel();
				JPanel flightTypePanel = new JPanel();
				JPanel flightDatePanel = new JPanel();
				JPanel operatorPanel = new JPanel();
				panel.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 0));
				panel.setMaximumSize(new Dimension(1000, 40));
				panel.setMinimumSize(new Dimension(1000, 40));
				panel.setOpaque(false);
				panel.setPreferredSize(new Dimension(1000, 40));
				panel.add(flightIdPanel.add(new JLabel("航班号")));
				panel.add(fromPanle.add(new JLabel("           出发地      ")));
				panel.add(toPanel.add(new JLabel("  目的地")));
				panel.add(startPanel.add(new JLabel("       起飞时间      ")));
				panel.add(endPanel.add(new JLabel("    到达时间    ")));
				panel.add(flightTypePanel.add(new JLabel("  执行机型     ")));
				panel.add(flightDatePanel.add(new JLabel("   航班日历        ")));
				panel.add(operatorPanel.add(new JLabel("                   操作")));
				panel.setBorder(BorderFactory.createTitledBorder(""));
				flightManagementPanelItemPanel.add(panel);
				
				String fls_int = flightIdText.getText().trim();
				String from_place = ((String)(jcb1.getSelectedItem())).trim();
				String to_place  = ((String)(jcb2.getSelectedItem())).trim();
				if(fls_int.equals("")&&from_place.equals("")&&to_place.equals("")){
					JOptionPane.showMessageDialog(FlightManagementPanel.this, "请输入有效完整信息!");
				}else{
				if(!fls_int.equals("")){
					Request req = new Request(Request.SEARCH_FLIGHT_REQUEST_BYID);
					req.addData("flight_num", fls_int);
					Response res = action.doAction(req);
					List<Flight> flight = new ArrayList<Flight>();
					flight.clear();
					flight = (List<Flight>)res.getData("flight");
					for (Flight f : flight) {
						Date fd = f.getFlight_departu_date();
						Date td = f.getFlight_arrival_date();
						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
						String fds = fmt.format(fd);
						String tds = fmt.format(td);
						Request req1 = new Request(Request.SEARCH_AIRPLANE_REQUEST);
						req1.addData("plane_id", f.getPlane_id());
						Response res1 = action.doAction(req1);
						String pmodel = (String)res1.getData("pmodel");
						Request req2 = new Request(Request.SEARCH_FTPLACE_BYROUTEID_REQUEST);
						req2.addData("routeId", f.getRoute_id());
						Response res2 =action.doAction(req2);
						String from = (String)res2.getData("from");
						String to = (String)res2.getData("to");
//						System.out.println(from+" /  s");
//						System.out.println(to+" /  s");
						JPanel p = getSearchFlightResultItem(f.getFlight_num(), from, "         "+to, fds, tds, pmodel,4);
						flightManagementPanelItemPanel.add(p);
					   }
				}else{
					if(from_place.equals(to_place)){
						JOptionPane.showMessageDialog(FlightManagementPanel.this, "出发地和目的地不能相同!");
					}else{
					if(from_place.equals("")||to_place.equals("")){
						
					}else{
						Request req = new Request(Request.SEARCH_FLIGHT_REQUEST);
						req.addData("from_place", from_place);
						req.addData("to_place", to_place);
						Response res = action.doAction(req);
						List<Flight> flight = new ArrayList<Flight>();
						flight.clear();
						flight = (List<Flight>)res.getData("flightMessage");
//						System.out.println(flight);
						String[] tp = from_place.split("-");
						String[] tp1 = to_place.split("-");
						String from = tp[0];
						String to = tp1[0];
					for (Flight f : flight) {
						Date fd = f.getFlight_departu_date();
						Date td = f.getFlight_arrival_date();
						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
						String fds = fmt.format(fd);
						String tds = fmt.format(td);
						Request req1 = new Request(Request.SEARCH_AIRPLANE_REQUEST);
						req1.addData("plane_id", f.getPlane_id());
						Response res1 = action.doAction(req1);
						String pmodel = (String)res1.getData("pmodel");
						JPanel p = getSearchFlightResultItem(f.getFlight_num(), from, "         "+to, fds, tds, pmodel,4);
						flightManagementPanelItemPanel.add(p);
					   }
					}
				}
			}
			}

				// 数据测试
				flightManagementPanelItemPanel.updateUI();
			}
		});
		//增加新计划
		addNewFlightPlanButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
	}
	
	
	
		/**
		 * 得到查询航班计划的结果
		 * @param flightId航班号
		 * @param starts计划开始日期
		 * @param ends计划结束
		 * @param start离港
		 * @param end到港
		 * @param time班期
		 * @param dis季节折扣
		 * @return
		 */
		private JPanel getSearchFlightPlanResultItem(String flightId, String starts,
				String ends, String start, String end, int time,double dis) {
			
			final String[] strs = { flightId, starts, ends, start,end };

			final JPanel panel = new JPanel();
			JPanel flightIdPanel = new JPanel();
			JPanel startsPanle = new JPanel();
			JPanel endsPanel = new JPanel();
			JPanel startPanel = new JPanel();
			JPanel endPanel = new JPanel();
			JPanel timePanel = new JPanel();
			JPanel disPanel = new JPanel();
			JPanel buttonPanel = new JPanel();
//			final JTextField flightDate = new JTextField("航班日历", 9);
//			flightDate.addFocusListener(new FocusListener() {

//				public void focusGained(FocusEvent e) {
//					frame.setVisible(true);
//					frame.setLocation(300, 340);
//					System.out.println();
//					new MySimpleCal(frame, flightDate,FlightManagementPanel.this.plane_scheduler).setVisible(true);
//					frame.dispose();
//					flightDate.setFocusable(false);
//					flightDate.setFocusable(true);
//				}
//				public void focusLost(FocusEvent e) {
//				}
//			  });
				//flightIdText, fromText, toTextf,startText, endText, 
			JButton modifyButton = new JButton("修改计划");
			modifyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					Request req = new Request(Request.SEARCH_AIRPLANE_REQUEST_BYNONE);
//					Response res = action.doAction(req);
//					String[] st1 = (String[])res.getData("airplanemodel");
					new ModifyFlightDialogschPanel(frame, strs);
				}
			});
			
			
			JButton removeButton = new JButton("删除计划");
			removeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// 删除航班计划
					String flightId = strs[0];
					Request req = new Request(Request.REMOVE_FLIGHT_SCHEDULER_REQUEST);
					req.addData("flight_num", flightId);
					Response res = action.doAction(req);
					boolean boo =(Boolean)res.getData("boolean");
					if(boo){
						JOptionPane.showMessageDialog(FlightManagementPanel.this, "删除成功");
						flightManagementPanelItemPanel.remove(panel);
						flightManagementPanelItemPanel.setVisible(false);
						flightManagementPanelItemPanel.setVisible(true);
						flightManagementPanelItemPanel.updateUI();
					}else{
						JOptionPane.showMessageDialog(FlightManagementPanel.this, "删除失败");
					}
				

				}
			});
			
			JButton updateDiscount = new JButton("更新折扣");
			updateDiscount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(JOptionPane.showConfirmDialog(FlightManagementPanel.this, "接入更新折扣界面",
							"确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
						final JDialog jd2 = new JDialog();
						JPanel jpz1 = new JPanel();
						JPanel jpz2 = new JPanel();
						
						jpz1.setLayout(new FlowLayout());
						JButton jbz1 = new JButton("确定");
						JButton jbz2 = new JButton("取消");
						jpz1.add(jbz1);
						jpz1.add(new JLabel("   "));
						jpz1.add(new JLabel("   "));
						jpz1.add(new JLabel("  "));
						jpz1.add(jbz2);

						jpz2.setLayout(new GridLayout(2,1));
						final JTextField jt = new JTextField(9);
						jpz2.add(new JLabel("新季节折扣:"));
						jpz2.add(jt);
						jbz1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(jt.getText().trim().equals("")){
									JOptionPane.showMessageDialog(FlightManagementPanel.this, "信息不能为空!");
								}else{
									if(jt.getText().trim().matches("^0\\.(\\d){1,2}")){
										String flightId = strs[0];
										Request req = new Request(Request.UPDATE_SEASON_DISCOUNT_REQUEST);
										req.addData("disc", jt.getText().trim());
										req.addData("flight_num", flightId);
										Response res = action.doAction(req);
										boolean boo = (Boolean)res.getData("boolean");
										if(boo){
											JOptionPane.showMessageDialog(FlightManagementPanel.this, "更新成功");
											jd2.dispose();
											flightManagementPanelItemPanel.setVisible(false);
											flightManagementPanelItemPanel.setVisible(true);
											flightManagementPanelItemPanel.updateUI();
										}else{
											JOptionPane.showMessageDialog(FlightManagementPanel.this, "更新失败");
										}
									}else{
										JOptionPane.showMessageDialog(FlightManagementPanel.this, "数字格式不对,请输入小于1的至多两位小数");
										jt.setText("");
									}
								}
							}
						});
						jbz2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								jd2.dispose();
							}
						});
						jd2.add(jpz1, BorderLayout.SOUTH);
						jd2.add(jpz2, BorderLayout.CENTER);
						jd2.setLocation(500, 300);
						jd2.setSize(200, 120);
						jd2.setVisible(true);
						jd2.setDefaultCloseOperation(jd2.DISPOSE_ON_CLOSE);
					}
//					JOptionPane.showMessageDialog(frame, "接入更新折扣界面");
				}
			});

			flightIdPanel.setLayout(new FlowLayout());
			JLabel flightIdLabel = new JLabel(flightId);

			flightIdPanel.add(flightIdLabel);

			startsPanle.setLayout(new FlowLayout());

			startsPanle.add(new JLabel(starts));

			endsPanel.setLayout(new FlowLayout());

			endsPanel.add(new JLabel(ends));

			startPanel.setLayout(new FlowLayout());

			startPanel.add(new JLabel(start));

			endPanel.setLayout(new FlowLayout());

			endPanel.add(new JLabel(end));

			timePanel.setLayout(new FlowLayout());

			timePanel.add(new JLabel("      "+time+"     "));

			disPanel.setLayout(new FlowLayout());

			disPanel.add(new JLabel(dis+"     "));

			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(modifyButton);
			buttonPanel.add(removeButton);
			buttonPanel.add(updateDiscount);

			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 0));
			panel.setMaximumSize(new Dimension(1000, 40));
			panel.setMinimumSize(new Dimension(1000, 40));
			panel.setOpaque(false);
			panel.setPreferredSize(new Dimension(1000, 40));
			panel.add(flightIdPanel);
			panel.add(startsPanle);
			panel.add(endsPanel);
			panel.add(startPanel);
			panel.add(endPanel);
			panel.add(timePanel);
			panel.add(disPanel);
			panel.add(buttonPanel);

			panel.setBorder(BorderFactory.createTitledBorder(""));

			return panel;
		}

/**
 * 得到查询航班的结果
 * @param flightId 航班号
 * @param from 出发地
 * @param to 目的地
 * @param start 起飞时间
 * @param end 到达时间
 * @param flightType 机型
 * @param f 航班日历
 * @return JPanel
 */
	private JPanel getSearchFlightResultItem(String flightId, String from,
			String to, String start, String end, String flightType,int f) {
		
		this.plane_scheduler = f;
		final String[] strs = { flightId, from, to, start, end, flightType };

		final JPanel panel = new JPanel();
		JPanel flightIdPanel = new JPanel();
		JPanel fromPanle = new JPanel();
		JPanel toPanel = new JPanel();
		JPanel startPanel = new JPanel();
		JPanel endPanel = new JPanel();
		JPanel flightTypePanel = new JPanel();
		JPanel flightDatePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		final JTextField flightDate = new JTextField("航班日历", 9);
		flightDate.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				frame.setVisible(true);
				frame.setLocation(300, 340);
				System.out.println();
				new MySimpleCal(frame, flightDate,FlightManagementPanel.this.plane_scheduler).setVisible(true);
				frame.dispose();
				flightDate.setFocusable(false);
				flightDate.setFocusable(true);
			}
			public void focusLost(FocusEvent e) {
			}
		  });
			//flightIdText, fromText, toTextf,startText, endText, 
		JButton modifyButton = new JButton("修改航班");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request req = new Request(Request.SEARCH_AIRPLANE_REQUEST_BYNONE);
				Response res = action.doAction(req);
				String[] st1 = (String[])res.getData("airplanemodel");
				new ModifyFlightDialogPanel(frame, st1, strs);
			
			}
		});
		
		
		JButton removeButton = new JButton("删除航班");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 删除航班
				String flightId = strs[0];
				Request req = new Request(Request.REMOVE_FLIGHT_REQUEST);
				req.addData("flight_num", flightId);
				Response res = action.doAction(req);
				boolean boo =(Boolean)res.getData("boolean");
				if(boo){
					JOptionPane.showMessageDialog(FlightManagementPanel.this, "删除成功");
					flightManagementPanelItemPanel.remove(panel);
					flightManagementPanelItemPanel.setVisible(false);
					flightManagementPanelItemPanel.setVisible(true);
					flightManagementPanelItemPanel.updateUI();
				}else{
					JOptionPane.showMessageDialog(FlightManagementPanel.this, "删除失败");
				}
			

			}
		});
		
//		JButton updateDiscount = new JButton("更新折扣");
//		updateDiscount.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if(JOptionPane.showConfirmDialog(frame, "接入更新折扣界面",
//						"确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
//					final JDialog jd2 = new JDialog();
//					JPanel jpz1 = new JPanel();
//					JPanel jpz2 = new JPanel();
//					
//					jpz1.setLayout(new FlowLayout());
//					JButton jbz1 = new JButton("确定");
//					JButton jbz2 = new JButton("取消");
//					jpz1.add(jbz1);
//					jpz1.add(new JLabel("    "));
//					jpz1.add(new JLabel("    "));
//					jpz1.add(new JLabel("    "));
//					jpz1.add(jbz2);
//
//					jpz2.setLayout(new FlowLayout());
//					final JTextField jt = new JTextField(9);
//					jpz2.add(new JLabel("新季节折扣:"));
//					jpz2.add(jt);
//					jbz1.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							if(jt.getText().trim().equals("")){
//								JOptionPane.showMessageDialog(frame, "信息不能为空!");
//							}else{
//								if(jt.getText().trim().matches("^0\\.(\\d){2}")){
//									Request req = new Request(Request.UPDATE_SEASON_DISCOUNT_REQUEST);
//									req.addData("disc", jt.getText().trim());
//									Response res = action.doAction(req);
//									boolean boo = (Boolean)res.getData("boolean");
//									if(boo){
//										JOptionPane.showMessageDialog(frame, "更新成功");
//									}else{
//										JOptionPane.showMessageDialog(frame, "更新失败");
//									}
//								}else{
//									JOptionPane.showMessageDialog(frame, "数字格式不对,请输入小于1的两位小数");
//								}
//							}
//						}
//					});
//					jbz2.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							jd2.dispose();
//						}
//					});
//					jd2.add(jpz1, BorderLayout.SOUTH);
//					jd2.add(jpz2, BorderLayout.CENTER);
//					jd2.setLocation(500, 300);
//					jd2.setSize(200, 150);
//					jd2.setVisible(true);
//					jd2.setDefaultCloseOperation(jd2.DISPOSE_ON_CLOSE);
//				}
////				JOptionPane.showMessageDialog(frame, "接入更新折扣界面");
//			}
//		});

		flightIdPanel.setLayout(new FlowLayout());
		JLabel flightIdLabel = new JLabel(flightId);

		flightIdPanel.add(flightIdLabel);

		fromPanle.setLayout(new FlowLayout());

		fromPanle.add(new JLabel(from));

		toPanel.setLayout(new FlowLayout());

		toPanel.add(new JLabel(to));

		startPanel.setLayout(new FlowLayout());

		startPanel.add(new JLabel(start));

		endPanel.setLayout(new FlowLayout());

		endPanel.add(new JLabel(end));

		flightDatePanel.setLayout(new FlowLayout());

		flightDatePanel.add(flightDate);

		flightTypePanel.setLayout(new FlowLayout());

		flightTypePanel.add(new JLabel(flightType));

		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(modifyButton);
		buttonPanel.add(removeButton);
//		buttonPanel.add(updateDiscount);

		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 0));
		panel.setMaximumSize(new Dimension(1000, 40));
		panel.setMinimumSize(new Dimension(1000, 40));
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(1000, 40));
		panel.add(flightIdPanel);
		panel.add(fromPanle);
		panel.add(toPanel);
		panel.add(startPanel);
		panel.add(endPanel);
		panel.add(flightTypePanel);
		panel.add(flightDate);
		panel.add(buttonPanel);

		panel.setBorder(BorderFactory.createTitledBorder(""));

		return panel;
	}

	private void showMe() {
		// frame.pack();
		frame.setSize(200, 150);
//		frame.setVisible(true);
		frame.setLocation(150, 120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//	public static void main(String[] args) {
//		new FlightManagementPanel().showMe();
//	}
}
