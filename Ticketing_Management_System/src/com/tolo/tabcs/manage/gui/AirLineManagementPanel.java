package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
import javax.swing.border.Border;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Airport;
import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

@SuppressWarnings("serial")
public class AirLineManagementPanel extends JPanel {
	private Border bo;
	private Border b1;
	private Border b2;
	private Border b3;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JLabel jl1, jl2, jl3;
	private JComboBox jcbb1, jcbb2, jcbb3;
	private JButton jb;

	private JScrollPane jsp;
	// private JTable jtt;
	// private JTable jtt1;

	private JButton jb1;
	private JButton jb2;

	private JFrame jf;

	private int al_id;

	private JLabel x1, x2, x3, x4;
	private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf10,
			jtf11, jtf12, jtf13;

	public AirLineManagementPanel(JFrame jf) {
		this.jf = jf;
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jl1 = new JLabel("查询航线");
		Font f = new Font("宋体", Font.BOLD, 15);
		jl1.setFont(f);
		jl2 = new JLabel("出  发  地：");
		jl3 = new JLabel("目  的  地");
		jcbb1 = new JComboBox();// 出发地
		jcbb1.addItem("北京");
		jcbb1.addItem("上海");
		jcbb1.addItem("杭州");
		jcbb1.addItem("宁波");
		jcbb1.addItem("长沙");
		jcbb1.addItem("义乌");
		jcbb1.addItem("温州");
		jcbb1.addItem("厦门");
		jcbb2 = new JComboBox();// 目的地
		jcbb2.addItem("北京");
		jcbb2.addItem("上海");
		jcbb2.addItem("宁波");
		jcbb2.addItem("长沙");
		jcbb2.addItem("义乌");
		jcbb2.addItem("温州");
		jcbb2.addItem("厦门");
		jcbb2.addItem("杭州");

		jcbb3 = new JComboBox();
		jcbb3.addItem("北京");
		jcbb3.addItem("上海");
		jcbb3.addItem("浙江");
		jcbb3.addItem("广东");
		jcbb3.addItem("四川");
		jcbb3.addItem("新疆");
		jcbb3.addItem("吉林");

		jb = new JButton("查询");
		jb1 = new JButton("添加新航线");
		jb2 = new JButton("添加新机场");

		jsp = new JScrollPane(jp2);

		x1 = new JLabel("航线编号1：");
		x2 = new JLabel("出发机场2：");
		x3 = new JLabel("目的机场3：");
		x4 = new JLabel("航  程4：");
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		jtf4 = new JTextField(10);
		jtf5 = new JTextField(10);
		jtf6 = new JTextField(10);
		jtf7 = new JTextField(10);
		jtf8 = new JTextField(10);
		jtf10 = new JTextField(10);
		jtf11 = new JTextField(10);
		jtf12 = new JTextField(10);
		jtf13 = new JTextField(10);
		init();
		m1();
		m2();
		m4();
		m5();
		m6();// 监听的添加
	}

	private void init() {
		this.setLayout(new BorderLayout());
		bo = BorderFactory.createTitledBorder("航线管理");
		this.setBorder(bo);

		Color c0 = new Color(255, 0, 0);
		jb.setForeground(c0);
		b1 = BorderFactory.createTitledBorder("");
		jp1.setBorder(b1);
		jp1.setLayout(new GridLayout(1, 10));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jcbb1);
		jp1.add(new JLabel(""));
		jp1.add(jl3);
		jp1.add(jcbb2);
		jp1.add(new JLabel(""));
		jp1.add(jb);

		b3 = BorderFactory.createTitledBorder("");
		jp2.setBorder(b3);
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));

		Color c1 = new Color(0, 0, 255);
		jb1.setForeground(c1);
		Color c2 = new Color(0, 0, 255);
		jb2.setForeground(c2);
		b2 = BorderFactory.createTitledBorder("");
		jp3.setBorder(b2);
		jp3.add(jb1);
		jp3.add(new JLabel("   "));
		jp3.add(new JLabel("   "));
		jp3.add(new JLabel("   "));
		jp3.add(new JLabel("   "));
		jp3.add(new JLabel("   "));
		jp3.add(new JLabel("   "));
		jp3.add(new JLabel("   "));
		jp3.add(jb2);

		this.add(jp1, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
	}

	Action action = new Action();

	private void m1() {
		jb.addActionListener(new ActionListener() {// 添加查询按钮的监听
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0) {
						// 添加中间面板的东西
						jp2.removeAll();
						jp2.updateUI();
						JPanel m = new JPanel(new GridLayout(1, 5));
						JPanel m1 = new JPanel();
						JPanel m2 = new JPanel();
						JPanel m3 = new JPanel();
						JPanel m4 = new JPanel();
						JPanel m5 = new JPanel();
						m1.add(new JLabel("航线编号"));
						m2.add(new JLabel("出发机场"));
						m3.add(new JLabel("到达机场"));
						m4.add(new JLabel("航      程"));
						m5.add(new JLabel("操      作"));
						m.add(m1);
						m.add(m2);
						m.add(m3);
						m.add(m4);
						m.add(m5);
						m.setBorder(BorderFactory.createTitledBorder(""));
						m.setMaximumSize(new Dimension(900, 40));
						m.setMinimumSize(new Dimension(900, 40));
						m.setOpaque(false);
						jp2.add(m);
						// 得到查询数据

						String from_place = (String) jcbb1.getSelectedItem();
						String to_place = (String) jcbb2.getSelectedItem();
						// 测试输出
						System.out.println(from_place);
						System.out.println(to_place);
						// Route route= new Route(from_place,to_place);
						Route route = new Route(from_place, to_place);
						Request req = new Request(
								Request.SEARCH_AIRLINE_REQUEST);
						req.addData("route0", route);
						Response res = action.doAction(req);

						System.out.println("***********返回结果了1");
						// LinkedList<Route> list = (LinkedList<Route>)
						// res.getData("result");

						int[] l = (int[]) res.getData("result");
						System.out.println(l.length);
						if (l.length == 0) {
							JOptionPane.showMessageDialog(
									AirLineManagementPanel.this, "不存在该航线");
							return;
						}

						System.out.println("=======" + l);

						for (int i = 0; i < l.length; i++) {
							System.out.println(l[i]);
						}
						for (int i = 0; i < l.length; i++) {
							Route route1 = new Route(l[i]);
							Request req1 = new Request(
									Request.SEARCH_AIRLINE2_REQUEST);
							req1.addData("route1", route1);
							Response res1 = action.doAction(req1);
							LinkedList<Route> list = (LinkedList<Route>) res1
									.getData("result1");
							System.out.println("***********返回结果了2");
							Route r = list.get(0);
							System.out.println(r.getRoute_id());
							System.out.println(r.getFrom_airport_name());
							System.out.println(r.getTo_airport_name());
							System.out.println(r.getRoute_distance());

							long route_id = (long) r.getRoute_id();
							String routeId = String.valueOf(route_id);
							int route_distance = (int) r.getRoute_distance();
							String routeDistance = String
									.valueOf(route_distance);

							if (routeId.equals("")) {

							}

							jp2.add(getPanleMei(routeId, r
									.getFrom_airport_name(), r
									.getTo_airport_name(), routeDistance, 1));
						}

					}
				});
	}

	private JPanel getPanleMei(final String x1, String x2, String x3,
			String x4, int al_id) {
		AirLineManagementPanel.this.al_id = al_id;
		final JPanel m = new JPanel(new GridLayout(1, 5));
		JPanel m1 = new JPanel();
		JPanel m2 = new JPanel();
		JPanel m3 = new JPanel();
		JPanel m4 = new JPanel();
		JPanel m5 = new JPanel();
		final JButton jbm1 = new JButton("修改");
		final JButton jbm2 = new JButton("删除");
		JLabel jlm1 = new JLabel(x1);
		JLabel jlm2 = new JLabel(x2);
		JLabel jlm3 = new JLabel(x3);
		JLabel jlm4 = new JLabel(x4);
		m1.add(jlm1);
		m2.add(jlm2);
		m3.add(jlm3);
		m4.add(jlm4);
		m5.add(jbm1);
		m5.add(jbm2);
		m.add(m1);
		m.add(m2);
		m.add(m3);
		m.add(m4);
		m.add(m5);
		m.setBorder(BorderFactory.createTitledBorder(""));
		m.setMaximumSize(new Dimension(900, 40));
		m.setMinimumSize(new Dimension(900, 40));
		m.setOpaque(false);

		jbm1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				// ???修改按钮的监听
				jtf5.setEditable(false);
				jtf6.setEditable(false);
				jtf7.setEditable(false);

				final JDialog jdx = new JDialog();
				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
				jdx.add(panel);
				JPanel jpz1 = new JPanel(new FlowLayout());
				JPanel jpz2 = new JPanel(new BorderLayout());
				JPanel jpz2_1 = new JPanel();
				JPanel jpz2_2 = new JPanel();
				JPanel jpz2_3 = new JPanel();
				JPanel jpz2_4 = new JPanel();
				JButton jbz1 = new JButton("确定");
				JButton jbz2 = new JButton("取消");

				jpz1.add(jbz1);
				jpz1.add(jbz2);

				jpz2.setLayout(new BoxLayout(jpz2, BoxLayout.Y_AXIS));
				jpz2_1.add(new JLabel("航班编号"));
				jpz2_1.add(jtf5);
				jpz2_2.add(new JLabel("出  发  地"));
				jpz2_2.add(jtf6);
				jpz2_3.add(new JLabel("目  的  地"));
				jpz2_3.add(jtf7);
				jpz2_4.add(new JLabel("航        程"));
				jpz2_4.add(jtf8);
				jpz2.add(jpz2_1);
				jpz2.add(jpz2_2);
				jpz2.add(jpz2_3);
				jpz2.add(jpz2_4);

				panel.add(jpz1, BorderLayout.SOUTH);
				panel.add(jpz2, BorderLayout.CENTER);
				jdx.setSize(200, 300);
				jdx.setLocation(600, 200);
				jdx.setVisible(true);
				jdx.setDefaultCloseOperation(jdx.DISPOSE_ON_CLOSE);

				jbz1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// 修改面板的确认按钮

						String mileag = jtf8.getText();
						int mileage = Integer.parseInt(mileag);
						String route_Id = x1;
						int routeId = Integer.parseInt(route_Id);
						System.out.println(mileage);
						System.out.println(routeId);
						Request req = new Request(
								Request.UPDATE_FLIGHT_MILEAGE_REQUEST);
						Route route = new Route(routeId, mileage);
						req.addData("mileage", route);
						Response res = action.doAction(req);
						System.out.println("***********返回结果了==Update Milage");
						String str = (String) res.getData("result");
						System.out.println(str);

						jdx.dispose();
					}

				});
				jbz2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// 修改面板的取消按钮

						jdx.dispose();
					}

				});

			}
		});
		jbm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 删除按钮的监听
				// 得到数据
				int alid = AirLineManagementPanel.this.al_id;
				String route_Id = x1;
				int routeId = Integer.parseInt(route_Id);
				Request req = new Request(Request.REMOVE_AIRLINE_REQUEST);
				req.addData("routeId", routeId);
				Response res = action.doAction(req);
				System.out.println("***********返回结果了==remove Airline");
				String str = (String) res.getData("result");
				System.out.println(str);

				jp2.remove(m);
				jp2.updateUI();
			}
		});
		return m;
	}

	private void m2() {

		// 添加新航线
		jb1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				final JDialog jd = new JDialog();
				JPanel jpx1 = new JPanel(new BorderLayout());
				JPanel jpx2 = new JPanel(new BorderLayout());
				JPanel jpx2_1 = new JPanel();
				JPanel jpx2_2 = new JPanel();
				JPanel jpx2_3 = new JPanel();
				JPanel jpx2_4 = new JPanel();
				jpx1.setLayout(new FlowLayout());
				JButton jbx1 = new JButton("确定");
				JButton jbx2 = new JButton("取消");
				jpx1.add(jbx1);

				jpx1.add(jbx2);

				jpx2.setLayout(new GridLayout(4, 1));
				jpx2_1.add(x1);
				jpx2_1.add(jtf1);
				jpx2_2.add(x2);
				jpx2_2.add(jtf2);
				jpx2_3.add(x3);
				jpx2_3.add(jtf3);
				jpx2_4.add(x4);
				jpx2_4.add(jtf4);

				jbx1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// /自己写的代码
						String route = jtf1.getText().trim();
						int route_id = Integer.parseInt(route);

						String from_airport_name = jtf2.getText().trim();
						String to_airport_name = jtf3.getText().trim();

						String route_dis = jtf4.getText().trim();
						int route_distance = Integer.parseInt(route_dis);

						System.out.println(route_id);
						System.out.println(from_airport_name);
						System.out.println(to_airport_name);
						System.out.println(route_distance);

						Route route5 = new Route(route_id, from_airport_name,
								to_airport_name, route_distance);
						Request req5 = new Request(Request.ADD_AIRLINE_REQUEST);
						req5.addData("addRoute", route5);
						Response res = action.doAction(req5);
						System.out.println("=====addRoute有返回结果");
						String str = (String) res.getData("okAdd");
						System.out.println(str);

						jd.dispose();
					}
				});
				jbx2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						jd.dispose();
					}
				});
				jpx2.add(jpx2_1);
				jpx2.add(jpx2_2);
				jpx2.add(jpx2_3);
				jpx2.add(jpx2_4);
				jd.add(jpx1, BorderLayout.SOUTH);
				jd.add(jpx2, BorderLayout.CENTER);
				jd.setSize(200, 300);
				jd.setLocation(450, 300);
				jd.setVisible(true);
				jd.setDefaultCloseOperation(jd.DISPOSE_ON_CLOSE);
			}
		});
	}

	private void m4() {
		// /??????????????添加新机场
		jb2.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {

				final JDialog jd2 = new JDialog();
				JPanel jpz1 = new JPanel(new BorderLayout());
				JPanel jpz2 = new JPanel(new BorderLayout());
				JPanel jpz2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JPanel jpz2_2 = new JPanel();
				JPanel jpz2_3 = new JPanel();
				JPanel jpz2_4 = new JPanel();
				jpz1.setLayout(new FlowLayout());
				JButton jbz1 = new JButton("确定");
				JButton jbz2 = new JButton("取消");
				jpz1.add(jbz1);
				/*
				 * jpz1.add(new JLabel("    ")); jpz1.add(new JLabel("    "));
				 * jpz1.add(new JLabel("    "));
				 */
				jpz1.add(jbz2);

				jpz2.setLayout(new GridLayout(4, 1));
				jpz2_1.add(new JLabel("机场省份："));
				jpz2_1.add(jcbb3);
				jpz2_2.add(new JLabel("机场城市："));
				jpz2_2.add(jtf10);
				jpz2_3.add(new JLabel("机场简称："));
				jpz2_3.add(jtf11);
				jpz2_3.add(new JLabel("机场全称："));
				jpz2_3.add(jtf13);
				jpz2_4.add(new JLabel("机场代码："));
				jpz2_4.add(jtf12);

				jbz1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String province_name = (String) jcbb3.getSelectedItem();
						String city_name = jtf10.getText().trim();
						String airport_name = jtf11.getText().trim();
						String airportCode = jtf12.getText().trim();

						String airport_full_name = jtf13.getText().trim();
						// int airport_id =Integer.parseInt(airportId);

						// System.out.println(airport_code);
						System.out.println(airport_name);
						System.out.println(city_name);
						System.out.println(province_name);
						Airport airport = new Airport(airportCode,
								airport_name, airport_full_name, city_name,
								province_name);
						Request req6 = new Request(Request.ADD_AIRPORT_REQUEST);
						req6.addData("addAirport", airport);
						Response res = action.doAction(req6);
						System.out.println("=====addRoute有返回结果");

						String str = (String) res.getData("okadd");
						System.out.println(str);

						jd2.dispose();
					}
				});
				jbz2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jd2.dispose();
					}
				});
				jpz2.add(jpz2_1);
				jpz2.add(jpz2_2);
				jpz2.add(jpz2_3);
				jpz2.add(jpz2_4);
				jd2.add(jpz1, BorderLayout.SOUTH);
				jd2.add(jpz2, BorderLayout.CENTER);
				jd2.setLocation(500, 300);
				jd2.setSize(200, 300);
				jd2.setVisible(true);
				jd2.setDefaultCloseOperation(jd2.DISPOSE_ON_CLOSE);

			}
		});
	}

	private void m5() {
		jcbb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}

	private void m6() {
		jcbb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}

}
