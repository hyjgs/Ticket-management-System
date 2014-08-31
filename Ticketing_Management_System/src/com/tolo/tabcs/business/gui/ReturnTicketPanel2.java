package com.tolo.tabcs.business.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Airport;
import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.manage.gui.AirLineManagementPanel;

@SuppressWarnings("serial")
public class ReturnTicketPanel2 extends JPanel {
	private MainFrame frame;
	private JPanel SearchFlightResultHeadPanel;// 搜索顶层头面板
	private JPanel SearchFlightResultTitlePanel;// 搜索内容标题头面板
	public static JPanel SearchFlightResultItemPanel;// 搜索结果集显示面板
	private JPanel SearchFlightResultLastPanel;// 搜索面板底层信息显示面板
	private JPanel flightIdPanel, fromToPanle, startEndPanel, flightTypePanel,
			ticketmoneyPanel, sitTypePanel, pricepePanel;// 标题各分组件面板
	private JScrollPane jsp;// 滚动面板，用于搜索集滚动查询
	private JButton searchButton;

	private JTextField jtf1, jtf2, jtf3, jtf4;

	private JPanel ChangeTicketPanel;

	private JTextField field1 = null;
	private JLabel jLabel1 = null;
	private JLabel lblTickId, lblPassName, lblPassId;
	private JTextField txtTickId, txtPassName, txtPassId;

	public ReturnTicketPanel2(MainFrame frame) {
		this.frame = frame;
		SearchFlightResultHeadPanel = new JPanel();
		SearchFlightResultTitlePanel = new JPanel();
		SearchFlightResultItemPanel = new JPanel();
		SearchFlightResultLastPanel = new JPanel();

		searchButton = new JButton("查询");

		lblTickId = new JLabel("机票编号:");
		lblPassName = new JLabel("乘客姓名:");
		lblPassId = new JLabel("证件号码:");
		txtTickId = new JTextField(16);// 机票编号
		txtPassName = new JTextField(4);// 乘客姓名
		txtPassId = new JTextField(13);// 证件号码

		flightIdPanel = new JPanel();
		flightIdPanel.setLayout(new FlowLayout());
		flightIdPanel.add(new JLabel("航班号"));

		fromToPanle = new JPanel();
		fromToPanle.setLayout(new FlowLayout());
		fromToPanle.add(new JLabel("    出发地"));

		startEndPanel = new JPanel();
		startEndPanel.setLayout(new FlowLayout());
		startEndPanel.add(new JLabel("  目的地"));

		flightTypePanel = new JPanel();
		flightTypePanel.setLayout(new FlowLayout());
		flightTypePanel.add(new JLabel("乘客姓名"));

		ticketmoneyPanel = new JPanel();
		ticketmoneyPanel.setLayout(new FlowLayout());
		ticketmoneyPanel.add(new JLabel("证件号码"));

		sitTypePanel = new JPanel();
		sitTypePanel.setLayout(new FlowLayout());
		sitTypePanel.add(new JLabel("日期"));

		pricepePanel = new JPanel();
		pricepePanel.setLayout(new FlowLayout());
		pricepePanel.add(new JLabel("机票价格"));
		init();
		addEventHandler();

		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		jtf4 = new JTextField(10);
	}

	private void init() {
		frame.add(this);
		this.setLayout(new BorderLayout());
		this.add(SearchFlightResultHeadPanel, BorderLayout.NORTH);
		JPanel centerPanel = new JPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(SearchFlightResultLastPanel, BorderLayout.SOUTH);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(SearchFlightResultTitlePanel, BorderLayout.NORTH);
		jsp = new JScrollPane(SearchFlightResultItemPanel);
		centerPanel.add(jsp, BorderLayout.CENTER);

		// SearchFlightResultHeadPanel面板设计
		SearchFlightResultHeadPanel.setLayout(new FlowLayout());
		SearchFlightResultHeadPanel.add(lblTickId);
		SearchFlightResultHeadPanel.add(txtTickId);

		SearchFlightResultHeadPanel.add(lblPassName);
		SearchFlightResultHeadPanel.add(txtPassName);
		SearchFlightResultHeadPanel.add(lblPassId);
		SearchFlightResultHeadPanel.add(txtPassId);

		SearchFlightResultHeadPanel.add(searchButton);

		// SearchFlightResultTitlePanel面板设计
		SearchFlightResultTitlePanel.setLayout(new GridLayout(1, 7));
		SearchFlightResultTitlePanel.add(flightIdPanel);
		SearchFlightResultTitlePanel.add(fromToPanle);
		SearchFlightResultTitlePanel.add(startEndPanel);
		SearchFlightResultTitlePanel.add(flightTypePanel);
		SearchFlightResultTitlePanel.add(ticketmoneyPanel);
		SearchFlightResultTitlePanel.add(sitTypePanel);
		SearchFlightResultTitlePanel.add(pricepePanel);
		SearchFlightResultTitlePanel.add(new JPanel().add(new JLabel()));

		// SearchFlightResultItemPanel面板设计
		SearchFlightResultItemPanel.setLayout(new BoxLayout(
				SearchFlightResultItemPanel, BoxLayout.Y_AXIS));

		// SearchFlightResultLastPanel面板设计
		SearchFlightResultLastPanel.setLayout(new FlowLayout());
		SearchFlightResultLastPanel.add(new JLabel("页面信息显示面板"));

		// 画边框
		SearchFlightResultHeadPanel.setBorder(BorderFactory
				.createTitledBorder(""));
		SearchFlightResultTitlePanel.setBorder(BorderFactory
				.createTitledBorder(""));
		SearchFlightResultItemPanel.setBorder(BorderFactory
				.createTitledBorder(""));
		SearchFlightResultLastPanel.setBorder(BorderFactory
				.createTitledBorder(""));
	}

	Action action = new Action();

	private void addEventHandler() {

		searchButton.addActionListener(new ActionListener() {// 查询按钮
					public void actionPerformed(ActionEvent e) {
						/**
						 * 得到用户输入的数据
						 */
						String ticketID = txtTickId.getText().trim();
						String pass_name = txtPassName.getText().trim();
						String pass_num = txtPassId.getText().trim();
						System.out.println(ticketID);
						if (ticketID.equals("") && pass_name.equals("")
								&& pass_num.equals("")) {
							JOptionPane.showMessageDialog(
									ReturnTicketPanel2.this, "您没有添写查询信息");
							return;
						}
						/**
						 * 封装数据
						 */

						/**
						 * 得到查询后的数据，应该返回的是一个集合
						 */
						SearchFlightResultItemPanel.removeAll();
						SearchFlightResultItemPanel.updateUI();
						if (!ticketID.equals("")) {
							int id = Integer.parseInt(ticketID);
							System.out.println(id);
							Request req = new Request(
									Request.SEARCH_TICKET_REQUEST);
							req.addData("ticketID", (Integer) id);
							Response res = action.doAction(req);
							System.out.println("=========有返回结果了");
							ArrayList<Ticket> list = (ArrayList<Ticket>) res
									.getData("result");

							Ticket t = list.get(0);
							System.out.println(t);

							int flight = t.getFlight_num();
							String flightNum = String.valueOf(flight);
							int price = t.getTicket_price();
							String ticketPrice = String.valueOf(price);
							// SearchFlightResultItemPanel.add(getSearchFlightResultItem("TL1001",
							// "北京-首都国际机场","上海—虹桥机场","张三","142356","2011－10－12","2000"));
							// SearchFlightResultItemPanel.add(getSearchFlightResultItem("1",
							// "2","3","4","5","6","7"));
							SearchFlightResultItemPanel
									.add(getSearchFlightResultItem(flightNum, t
											.getSta_from_airport(), t
											.getEnd_from_airport(), t
											.getPsg_name(), t
											.getPsg_certif_numl(), t
											.getTicket_start_date(),
											ticketPrice));

						} else {
							Request req = new Request(
									Request.SEARCH_TICKET2_REQUEST);
							req.addData("num", pass_num);
							Response res = action.doAction(req);
							System.out.println("=========有返回结果了pass_num");
							ArrayList<Ticket> list = (ArrayList<Ticket>) res
									.getData("result1");
							Ticket t = list.get(0);
							int flight = t.getFlight_num();
							String flightNum = String.valueOf(flight);
							int price = t.getTicket_price();
							String ticketPrice = String.valueOf(price);
							SearchFlightResultItemPanel
									.add(getSearchFlightResultItem(flightNum, t
											.getSta_from_airport(), t
											.getEnd_from_airport(), t
											.getPsg_name(), t
											.getPsg_certif_numl(), t
											.getTicket_start_date(),
											ticketPrice));
						}
						// SearchFlightResultItemPanel.add(getSearchFlightResultItem("TL1001","北京-首都国际机场","上海—虹桥机场","张三",142356,"2011－10－12","2000"));
						SearchFlightResultItemPanel.updateUI();
						// }
					}
				});

	}

	/*
	 * SearchFlightResultItemPanel.add(getSearchFlightResultItem("TL1001",
	 * "北京-首都国际机场","上海—虹桥机场","张三","142356","2011－10－12","2000"));
	 */
	// 获得查询结果
	/*
	 * private JPanel getSearchFlightResultItem(String flightId,String from,
	 * String end,String name,String num ,String date, String price)
	 */
	private JPanel getSearchFlightResultItem(String flightId, String from,
			String start, final String flightType, final String ticketMoney,
			String sitspaceType, final String s1) {
		JPanel panel = new JPanel();// 1
		JPanel flightIdPanel = new JPanel();// 2
		JPanel fromToPanle = new JPanel();// 3
		JPanel startEndPanel = new JPanel();// 4
		JPanel flightTypePanel = new JPanel();// 5
		JPanel ticketMoneyPanel = new JPanel();// 6
		JPanel sitTypePanel = new JPanel();// 7
		JPanel sit1TypePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JButton chooseButton = new JButton("退票");
		JButton choose2Button = new JButton("改签");
		flightIdPanel.setLayout(new FlowLayout());
		JLabel flightIdLabel = new JLabel(flightId);
		flightIdLabel.setFont(new Font("宋体", Font.BOLD, 10));
		flightIdPanel.add(flightIdLabel);

		fromToPanle.setLayout(new FlowLayout());
		fromToPanle.add(new JLabel(from));

		startEndPanel.setLayout(new FlowLayout());
		startEndPanel.add(new JLabel(start));

		flightTypePanel.setLayout(new FlowLayout());
		flightTypePanel.add(new JLabel(flightType));

		ticketMoneyPanel.setLayout(new FlowLayout());
		JLabel ticketMenoyLabel = new JLabel("" + ticketMoney);
		ticketMenoyLabel.setFont(new Font("宋体", Font.BOLD, 9));
		ticketMenoyLabel.setForeground(Color.RED);
		ticketMoneyPanel.add(ticketMenoyLabel);

		sitTypePanel.setLayout(new FlowLayout());
		sitTypePanel.add(new JLabel(sitspaceType));

		sit1TypePanel.setLayout(new FlowLayout());
		sit1TypePanel.add(new JLabel(s1));

		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(chooseButton);
		buttonPanel.add(choose2Button);

		panel.setLayout(new GridLayout(1, 8));
		panel.add(flightIdPanel);
		panel.add(fromToPanle);
		panel.add(startEndPanel);
		panel.add(flightTypePanel);
		panel.add(ticketMoneyPanel);
		panel.add(sitTypePanel);
		panel.add(sit1TypePanel);
		panel.add(buttonPanel);
		System.out.println("0fadfafdafa");

		// 退票按钮监听
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new RetuTicketDialog(ticket_price, fuel_construct, fuel_oil);

				int a = Integer.parseInt(s1);
				System.out.println(a);
				// int b =Integer.parseInt(ticketMoney);//ticketMoney 为证件号码
				Ticket ticket = new Ticket();
				ticket.setPsg_certif_numl(ticketMoney);// ticketMoney 为证件号码
				RetuTicketDialog r = new RetuTicketDialog(a, 50, 100, ticket);
				r.setVisible(true);
			}
		});

		// 改签
		choose2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Double> list = new ArrayList<Double>();
				list.add(1.0);
				list.add(0.8);
				list.add(0.6);
				String psgName = flightType;
				new ChanTicketDialog(psgName, 1800, list);

			}
		});

		panel.setBorder(BorderFactory.createTitledBorder(""));

		return panel;
	}

	@SuppressWarnings("unused")
	private void showMe() {
		frame.setSize(900, 500);
		frame.setVisible(true);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
