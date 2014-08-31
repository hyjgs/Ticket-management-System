package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.gui.SimpleCal;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

/**
 * 这个类是添加航班计划的GUI类
 * 主要用于显示添加航班计划时的图形界面
 * 当管理员点击添加计划按钮时,此图形被激活
 */
public class AddFlightSchDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel label1;//添加航班计划
	private JLabel label2;//航班号
	private JLabel label3;//班期
//	private JLabel label4;//基准票价
	private JLabel label5;//里程 <经济舱季节折扣>
//	private JLabel label6;//飞机机型
	private JLabel label7;//目的地 <航线编号>
//	private JLabel label8;//出发地
	private JLabel label9;//起始日期
	private JLabel label10;//结束日期
	private JLabel label11;//离港时间
	private JLabel label12;//到港时间
	
	private JTextField field2;
	private JTextField field3;
//	private JTextField field4;
	private JTextField field5;
//	private JComboBox field6;//
	private JComboBox field7;//航线
//	private JComboBox field8;
	private JTextField field9;
	private JTextField field10;
	private JTextField field11;
	private JTextField field12;
	
	private String[] routes;//存储目的地数组//航线编号数组
//	private String[] fromArray;// 存储出发地数组
//	private String[] planeArray;// 存储机型数组
	
	private JButton button1;//添加按钮
	private JButton button2;//取消按钮
	private Action action;
	private JFrame frame;
	
	public AddFlightSchDialog(JFrame frame){
		super(frame);
		action = new Action();
		this.setTitle("添加航班计划");
		this.frame=frame;
		this.frame.setEnabled(false);
		label1=new JLabel("添加航班计划");
		label2=new JLabel("航  班  号:");
		label3=new JLabel("班        期:");
//		label4=new JLabel("基准票价:");
		label5=new JLabel("经济舱季节折扣:  ");
//		label6=new JLabel("飞机机型:");
		Request req = new Request(Request.SEARCH_AIRLINE_REQUEST_BYNONE);
		Response res =action.doAction(req);
		Integer[] airlines =(Integer[])res.getData("airLine");
		label7=new JLabel("    航        线:           ");
//		label8=new JLabel("出发地:");
		label9=new JLabel("起始日期:");
		label10=new JLabel("结束日期:");
		label11=new JLabel("离港时间:");
		label12=new JLabel("到港时间:");	
		
		field2=new JTextField(15);
		field3=new JTextField(15);
//		field4=new JTextField(15);
		field5=new JTextField(10);
//		fromArray=new String[]{"—请选择—"};
//		routes=new String[]{"—请选择—","100001","100002","100003"};
//		planeArray=new String[]{"—请选择—"};
//		field6=new JComboBox(planeArray);
		field7=new JComboBox(airlines);
//		field8=new JComboBox(fromArray);
		field9=new JTextField(15);
		field10=new JTextField(15);
		field11=new JTextField(15);
		field12=new JTextField(15);
		
		button1=new JButton("添加");
		button2=new JButton("取消");
		
		init();
		setFont();
		addEventListener();
		showMe();
	}
	
	public void init(){
		this.setLayout(new BorderLayout(0,10));
		
		JPanel northPanel=new JPanel();
		JPanel centerPanel=new JPanel();
		JPanel southPanel=new JPanel();
		                                  
		northPanel.add(label1);
		label2.setBounds(new Rectangle(10, 10, 100, 30));
		centerPanel.add(label2);
		centerPanel.add(field2);
		centerPanel.add(label3);
		centerPanel.add(field3);
//		centerPanel.add(label4);
//		centerPanel.add(field4);
		centerPanel.add(label5);
		centerPanel.add(field5);
//		centerPanel.add(label6);
//		centerPanel.add(field6);
		centerPanel.add(label7);
		centerPanel.add(field7);
//		centerPanel.add(label8);
//		centerPanel.add(field8);
		centerPanel.add(label9);
		centerPanel.add(field9);
		centerPanel.add(label10);
		centerPanel.add(field10);
		centerPanel.add(label11);
		centerPanel.add(field11);
		centerPanel.add(label12);
		centerPanel.add(field12);
		
		southPanel.add(button1);
		southPanel.add(button2);
		
		this.add(northPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(southPanel,BorderLayout.SOUTH);
		
	}
	
	public void setFont(){
		Font f=new Font("宋体",Font.BOLD,17);
		label1.setFont(f);
	}
	
	public void showMe(){
		this.setSize(500,300);
		this.setMiddle();
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private void setMiddle(){
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		int width=(int)(d.getWidth()/2-this.getWidth()/2);
		int height=(int)(d.getHeight()/2-this.getHeight()/2);
		this.setLocation(width, height);
	}
	
	
	private void addEventListener(){
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(AddFlightSchDialog.this, "是否关闭该窗口？",
						"确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					AddFlightSchDialog.this.dispose();
					frame.setEnabled(true);
				}
			}
			
		});
		
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(!(field2.getText().trim().equals("")||field3.getText().trim().equals("")||
				field5.getText().trim().equals("")||field9.getText().trim().equals("")||
				field10.getText().trim().equals("")||field11.getText().trim().equals("")||field12.getText().trim().equals(""))){
//					AddFlightSchDialog.this.dispose();
					FlightPlan f = new FlightPlan();
					f.setFlight_num(field2.getText().trim());
					f.setFp_scheduler(Integer.parseInt(field3.getText().trim()));
					f.setFp_season_discount(Double.parseDouble(field5.getText().trim()));
					f.setRoute_id((Integer)field7.getSelectedItem());
					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
					Date start = null;
					Date end = null;
					try {
						start = fmt.parse(field9.getText());
						end = fmt.parse(field10.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					f.setFp_start_date(start);
					f.setFp_end_date(end);
					f.setFp_departure_Date(field11.getText());
					f.setFp_arrival_Date(field12.getText());
					Request req = new Request(Request.ADD_FLIGHT_SCHEDULER_REQUEST);
					req.addData("flightPlan", f);
					Response res = action.doAction(req);
					boolean boo = (Boolean)res.getData("boolean");
					if(boo){
						JOptionPane.showMessageDialog(AddFlightSchDialog.this, "添加成功");
						AddFlightSchDialog.this.dispose();
						frame.setEnabled(true);
					}else{
						JOptionPane.showMessageDialog(AddFlightSchDialog.this, "添加失败");
						AddFlightSchDialog.this.dispose();
						frame.setEnabled(true);
					}
				}else{
					JOptionPane.showMessageDialog(AddFlightSchDialog.this, "请完整填写所有信息");
				}
			}
			
		});
		
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(AddFlightSchDialog.this, "是否关闭该窗口？",
						"确认", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					AddFlightSchDialog.this.dispose();
					frame.setEnabled(true);
				}
			}
			
		});
		
//		field9.addFocusListener(new FocusListener() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				frame.setVisible(true);
//				frame.setLocation(300, 340);
//				new SimpleCal(frame, field9).setVisible(true);
//				frame.dispose();
//				frame.setEnabled(true);
//				field9.setFocusable(false);
//				field9.setFocusable(true);
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//			}
//		});
//		field10.addFocusListener(new FocusListener() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				frame.setVisible(true);
//				frame.setLocation(300, 340);
//				new SimpleCal(frame, field10).setVisible(true);
//				frame.dispose();
//				frame.setEnabled(true);
//				field10.setFocusable(false);
//				field10.setFocusable(true);
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//			}
//		});
		
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setLocation(300, 400);
//		frame.setSize(600,600);
//		frame.setVisible(true);
//		new AddFlightSchDialog(frame).showMe();
//	}
}
