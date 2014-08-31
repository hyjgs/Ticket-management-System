package com.tolo.tabcs.business.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.tolo.tabcs.common.gui.SimpleCal;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.manage.gui.FlightManagementPanel;

/**
 * @author TangLiang
 */
@SuppressWarnings("serial")
public class SearchFlightResultPanel extends JPanel{
	private MainFrame frame;
	private JPanel SearchFlightResultHeadPanel;//搜索顶层头面板
	private JPanel SearchFlightResultTitlePanel;//搜索内容标题头面板
	private JPanel SearchFlightResultItemPanel;//搜索结果集显示面板
	private JPanel SearchFlightResultLastPanel;//搜索面板底层信息显示面板
	private JPanel flightIdPanel,fromToPanle,startEndPanel,flightTypePanel,ticketmoneyPanel,sitTypePanel;//标题各分组件面板
	private JScrollPane jsp;//滚动面板，用于搜索集滚动查询
	private JLabel flightIdLab,startDateLab;
	private JTextField flightIdText,startDateText;
	private JLabel fromLab,toLab;
	//将按钮或可编辑字段与下拉列表组合的组件。
	//用户可以从下拉列表中选择值，下拉列表在用户请求时显示。
	//如果使组合框处于可编辑状态，则组合框将包括用户可在其中键入值的可编辑字段。
	private JComboBox fromBox,toBox;
	private JButton searchButton;
	private String[] fromTitle;
	private String[] toTitle;
	private Action action = null;
	public SearchFlightResultPanel(MainFrame frame){
		this.frame=frame;
		action = new Action();
		SearchFlightResultHeadPanel=new JPanel();
		SearchFlightResultTitlePanel=new JPanel();
		SearchFlightResultItemPanel=new JPanel();
		SearchFlightResultLastPanel=new JPanel();

		flightIdLab=new JLabel("航班号：");
		fromLab=new JLabel("出发地：");
		toLab=new JLabel("目的地：");
		startDateLab=new JLabel("出发日期：");
		flightIdText=new JTextField("",6);
		startDateText=new JTextField("",9);
		searchButton=new JButton("查询");
		
		flightIdPanel=new JPanel();
		flightIdPanel.setLayout(new FlowLayout());
		flightIdPanel.add(new JLabel("航班号"));
		
		fromToPanle=new JPanel();
		fromToPanle.setLayout(new BoxLayout(fromToPanle,BoxLayout.Y_AXIS));
		fromToPanle.add(new JLabel("出发地/"));
		fromToPanle.add(new JLabel("目的地"));
		
		startEndPanel=new JPanel();
		startEndPanel.setLayout(new BoxLayout(startEndPanel,BoxLayout.Y_AXIS));
		startEndPanel.add(new JLabel("起飞时间/"));
		startEndPanel.add(new JLabel("到达时间"));
		
		flightTypePanel=new JPanel();
		flightTypePanel.setLayout(new FlowLayout());
		flightTypePanel.add(new JLabel("机型"));
		
		ticketmoneyPanel=new JPanel();
		ticketmoneyPanel.setLayout(new FlowLayout());
		ticketmoneyPanel.add(new JLabel("最低折扣价"));
		
		sitTypePanel=new JPanel();
		sitTypePanel.setLayout(new BoxLayout(sitTypePanel,BoxLayout.Y_AXIS));
		sitTypePanel.add(new JLabel("各舱剩余座位"));
		sitTypePanel.add(new JLabel("F/C/Y"));
//		System.out.println("====");
		
		fromTitle=new String[]{"","北京-首都机场","上海-虹桥机场","上海-浦东机场","广州-白云机场","深圳-宝安机场","珠海-三沼机场","汕头-外沙机场","梅县-梅县机场","杭州-萧山机场","宁波-乐社机场","温州-永强机场","义乌-义乌机场","成都-双流机场","绵阳-绵阳机场","长春-大方身机场","吉林-二台子机场","延吉-延吉机场","乌鲁木齐-地窝堡机场","喀什-喀什机场"};
		toTitle=new String[]{"","北京-首都机场","上海-虹桥机场","上海-浦东机场","广州-白云机场","深圳-宝安机场","珠海-三沼机场","汕头-外沙机场","梅县-梅县机场","杭州-萧山机场","宁波-乐社机场","温州-永强机场","义乌-义乌机场","成都-双流机场","绵阳-绵阳机场","长春-大方身机场","吉林-二台子机场","延吉-延吉机场","乌鲁木齐-地窝堡机场","喀什-喀什机场"};
		
		init();
		addEventHandler();
		showMe();
	}
	

	private void init(){
		frame.add(this);
		this.setLayout(new BorderLayout());
		this.add(SearchFlightResultHeadPanel,BorderLayout.NORTH);
		JPanel centerPanel=new JPanel();
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(SearchFlightResultLastPanel,BorderLayout.SOUTH);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(SearchFlightResultTitlePanel,BorderLayout.NORTH);
		jsp=new JScrollPane(SearchFlightResultItemPanel);
		centerPanel.add(jsp,BorderLayout.CENTER);
		
		//SearchFlightResultHeadPanel面板设计
		SearchFlightResultHeadPanel.setLayout(new FlowLayout());
		SearchFlightResultHeadPanel.add(flightIdLab);
		SearchFlightResultHeadPanel.add(flightIdText);//航班号文本框
		
		fromBox=new JComboBox(fromTitle);//出发地
		toBox=new JComboBox(toTitle);//目的地
		SearchFlightResultHeadPanel.add(fromLab);
		SearchFlightResultHeadPanel.add(fromBox);
		SearchFlightResultHeadPanel.add(toLab);
		SearchFlightResultHeadPanel.add(toBox);

		SearchFlightResultHeadPanel.add(startDateLab);
		SearchFlightResultHeadPanel.add(startDateText);//出发日期文本框
		SearchFlightResultHeadPanel.add(searchButton);
		
		//SearchFlightResultTitlePanel面板设计
		SearchFlightResultTitlePanel.setLayout(new GridLayout(1,7));
		SearchFlightResultTitlePanel.add(flightIdPanel);
		SearchFlightResultTitlePanel.add(fromToPanle);
		SearchFlightResultTitlePanel.add(startEndPanel);
		SearchFlightResultTitlePanel.add(flightTypePanel);
		SearchFlightResultTitlePanel.add(ticketmoneyPanel);
		SearchFlightResultTitlePanel.add(sitTypePanel);
		SearchFlightResultTitlePanel.add(new JPanel().add(new JLabel("  ")));
		
		//SearchFlightResultItemPanel面板设计
		SearchFlightResultItemPanel.setLayout(new BoxLayout(SearchFlightResultItemPanel,BoxLayout.Y_AXIS));

		//SearchFlightResultLastPanel面板设计
		SearchFlightResultLastPanel.setLayout(new FlowLayout());
		SearchFlightResultLastPanel.add(new JLabel("页面信息显示面板"));

		//画边框
		SearchFlightResultHeadPanel.setBorder(BorderFactory.createTitledBorder(""));
		SearchFlightResultTitlePanel.setBorder(BorderFactory.createTitledBorder(""));
		SearchFlightResultItemPanel.setBorder(BorderFactory.createTitledBorder(""));
		SearchFlightResultLastPanel.setBorder(BorderFactory.createTitledBorder(""));
	}
	
	private void addEventHandler(){
		startDateText.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				JDialog jdi=new SimpleCal(SearchFlightResultPanel.this.frame,SearchFlightResultPanel.this.startDateText);
				jdi.setVisible(true);
				startDateText.setFocusable(false);
				startDateText.setFocusable(true);
			}
			public void focusLost(FocusEvent e) {
			}
		});

		searchButton.addActionListener(new ActionListener(){//查询按钮
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				SearchFlightResultItemPanel.removeAll();
				SearchFlightResultItemPanel.updateUI();
				if(flightIdText.getText().trim().equals("")&&
						((String)fromBox.getSelectedItem()).trim().equals("")&&
						((String)toBox.getSelectedItem()).trim().equals("")&&
						startDateText.getText().trim().equals("")){
					JOptionPane.showMessageDialog(SearchFlightResultPanel.this, "请输入有效完整信息!");
				}else{
				
					if(!flightIdText.getText().trim().equals("")){
						String fls_num = flightIdText.getText().trim();
						List<Flight> flight = searchFlightByNum(fls_num);
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
							double ticketlowprice = f.getLowest_discount_price();
							int fseats =f.getF_seats_remain();
							int bseats = f.getB_seats_remain();
							int eseats = f.getE_seats_remian();
							String sitType = fseats+"/"+bseats+"/"+eseats;
							JPanel pan = getSearchFlightResultItem(fls_num, from, to, fds, tds, pmodel, ticketlowprice, sitType, f.getRoute_id() , f.getFlight_id());
							SearchFlightResultItemPanel.add(pan);
						}		
					}else{
						String from_place = ((String)fromBox.getSelectedItem()).trim();
						String to_place = ((String)toBox.getSelectedItem()).trim();
						if(from_place.equals(to_place)){
							JOptionPane.showMessageDialog(SearchFlightResultPanel.this, "出发地和目的地不能相同!");
						}else{
						if(from_place.equals("")||to_place.equals("")){
							
						}else{
							List<Flight> flight = searchFlightByFT(from_place,to_place);
							System.out.println(flight);
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
							double ticketlowprice = f.getLowest_discount_price();
							int fseats =f.getF_seats_remain();
							int bseats = f.getB_seats_remain();
							int eseats = f.getE_seats_remian();
							String sitType = fseats+"/"+bseats+"/"+eseats;
							if(!(startDateText.getText().trim().equals(""))){
								if(startDateText.getText().trim().equals(fds)){
							JPanel pan = getSearchFlightResultItem(f.getFlight_num(), from, to, fds, tds, pmodel, ticketlowprice, sitType, f.getRoute_id() , f.getFlight_id());
							SearchFlightResultItemPanel.add(pan);
							}
							}else{
								JPanel pan = getSearchFlightResultItem(f.getFlight_num(), from, to, fds, tds, pmodel, ticketlowprice, sitType, f.getRoute_id() , f.getFlight_id());
								SearchFlightResultItemPanel.add(pan);
							}
						}
						}
					}
					}
					
					
					
					SearchFlightResultItemPanel.updateUI();//数据更新
				}
					}
		});
	}
	
	private List<Flight> searchFlightByFT(String from_place,String to_place) {
		Request req = new Request(Request.SEARCH_FLIGHT_REQUEST);
		req.addData("from_place", from_place);
		req.addData("to_place", to_place);
		Response res = action.doAction(req);
		List<Flight> flight = new ArrayList<Flight>();
		flight.clear();
		flight = (List<Flight>)res.getData("flightMessage");
		return flight;
	}

	private List<Flight> searchFlightByNum(String fls_num) {
		Request req = new Request(Request.SEARCH_FLIGHT_REQUEST_BYID);
		req.addData("flight_num", fls_num);
		Response res = action.doAction(req);
		List<Flight> flight = new ArrayList<Flight>();
		flight.clear();
		flight = (List<Flight>)res.getData("flight");
		return flight;
	}
	
	//	获得查询结果
	/**查询航班结果
	 * @param flightId航班号
	 * @param from 出发地
	 * @param to 目的地
	 * @param start 出发时间
	 * @param end 到达时间
	 * @param flightType 机型
	 * @param double ticketMoney 机票价格(基准价格)
	 * @param sitspaceType 座位空余
	 * @param intflightairline航线
	 * @param int fli_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JPanel getSearchFlightResultItem(String flightId,String from,String to,String start,String end,String flightType,double ticketMoney,String sitspaceType,int flightairline, int fli_id){
		JPanel panel=new JPanel();
		JPanel flightIdPanel=new JPanel();
		JPanel fromToPanle=new JPanel();
		JPanel startEndPanel=new JPanel();
		JPanel flightTypePanel=new JPanel();
		JPanel ticketMoneyPanel=new JPanel();
		JPanel sitTypePanel=new JPanel();
		JPanel buttonPanel=new JPanel();
		JButton chooseButton=new JButton("订票");
		
		flightIdPanel.setLayout(new FlowLayout());
		JLabel flightIdLabel=new JLabel(flightId);
		flightIdLabel.setFont(new Font("宋体",Font.BOLD,16));
		flightIdPanel.add(flightIdLabel);
		fromToPanle.setLayout(new BoxLayout(fromToPanle,BoxLayout.Y_AXIS));
		fromToPanle.add(new JLabel(from));
		fromToPanle.add(new JLabel(to));//出发和目的机场
		startEndPanel.setLayout(new BoxLayout(startEndPanel,BoxLayout.Y_AXIS));
		startEndPanel.add(new JLabel(start));
		startEndPanel.add(new JLabel(end));//起飞和到达时间
		flightTypePanel.setLayout(new FlowLayout());
		flightTypePanel.add(new JLabel(flightType));//机型
		ticketMoneyPanel.setLayout(new FlowLayout());
		JLabel ticketMenoyLabel=new JLabel(""+ticketMoney);//基准票价
		ticketMenoyLabel.setFont(new Font("宋体",Font.BOLD,20));
		ticketMenoyLabel.setForeground(Color.RED);
		ticketMoneyPanel.add(ticketMenoyLabel);
		sitTypePanel.setLayout(new FlowLayout());
		sitTypePanel.add(new JLabel(sitspaceType));//各舱剩余舱位
		buttonPanel.add(chooseButton);
		
		Request req = new Request(Request.SEARCH_FLIGHT_SCHEDULER_REQUEST_BYID);
		req.addData("flight_num", flightId);
		System.out.println("search:"+flightId);
		Response res = action.doAction(req);
		List<FlightPlan> flight = new ArrayList<FlightPlan>();
		flight.clear();
		flight=(List<FlightPlan>)res.getData("flightPlan");
		String st = flight.get(0).getFp_departure_Date();
		String tt = flight.get(0).getFp_arrival_Date();
		int tmoney = flight.get(0).getFp_base_price();
		
		panel.setLayout(new GridLayout(1,7));
		panel.add(flightIdPanel);
		panel.add(fromToPanle);
		panel.add(startEndPanel);
		panel.add(flightTypePanel);
		panel.add(ticketMoneyPanel);
		panel.add(sitTypePanel);
		panel.add(buttonPanel);
		final List l=new ArrayList();
		l.add(flightId);
		l.add(start);
		l.add(from);
		l.add(to);
		l.add(st);
		l.add(tt);
		l.add(tmoney+"");
		System.out.println(l);
		System.out.println(l.size());
		
		
		//机场建设费
		Request req1 = new Request(Request.SEARCH_FUEL_CONSTRUCT_REQUEST);
		req1.addData("flightype", flightType);
		Response res1=action.doAction(req1);
		l.add(res1.getData("con")+"");
		System.out.println(res1.getData("con"));
		l.add(0+"");
		l.add(0+"");
		
		Request req2 = new Request(Request.SEARCH_FUEL_OIL_REQUEST);
		req2.addData("flightairline", flightairline);
		Response res2=action.doAction(req2);
		int oil = (Integer)res2.getData("tax");
		//燃油费
		l.add(oil+"");
		l.add(0+"");
		l.add(oil/2+"");
		l.add(flightairline+"");
		//乘客类型折扣
		l.add(1.0+"");
		l.add(0.1+"");
		l.add(0.5+"");
		//舱位折扣
		l.add(1.8+"");
		l.add(1.5+"");
		l.add(1.0+"");
		l.add(fli_id+"");//航班编号
		/*
		 * 
		 * 弹出面板的监听**************************************************
		 */
		//订票按钮监听
		chooseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//连接订票弹出窗口		
				frame.setOtp(l);	
				frame.setCard("BookTicket");
			}
		});
		
		panel.setBorder(BorderFactory.createTitledBorder(""));

		return panel;
	}
	
	@SuppressWarnings("unused")
	private void showMe(){
//		frame.pack();
		frame.setSize(900,500);
		frame.setVisible(true);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
