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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.OrderItem;
import com.tolo.tabcs.common.entity.Passenger;
import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.common.gui.LoginFrame;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
/**
 * @author TangLiang
 */
public class OrderTicketPanel extends JPanel{
	private Action action;
	private static int seat = 1;
	private JScrollPane jsp;
	private JPanel jp1;//放在北边的面板
	private JPanel jp1_1;private JPanel jp1_2;private JPanel jp1_2_1;private JPanel jp1_2_2;
	private JLabel jl1;private JLabel jl2;private JLabel jl3;private JLabel jl4;private JLabel jl5;private JLabel jl6;private JLabel jl7;private JLabel jl8;
	private Border bo1;
	
	private JPanel jp2;//放在中间的面板
	private Border bo2;
	private JPanel jp2_1;
	private JPanel jp2_2;
	private JComboBox jcbb;
	
	private JPanel jp3;//放在南边的面板
	private JPanel jp3_1;
	private JPanel jp3_2;
	private Border bo3;
	private static JTextField jf1;private static JTextField jf2;private static JTextField jf3;
	private static JLabel jl9;
	private JButton jb1;private JButton jb2;
	private MainFrame frame;
//	private SearchFlightResultPanel resultPanel;
	private int fuel_consA;
	private int fuel_consB;
	private int fuel_consC;
	private int fuel_oilA,fuel_oilB,fuel_oilC;
	private double pass_disA,pass_disB,pass_disC;
	private double BasePrice;
	private double cabin_disF,cabin_disC,cabin_disY;
	private int airlinenum;//航线号
	private int fli_id;//航班编号
	private MyJPanel[] ticket =  new MyJPanel[0];
	public OrderTicketPanel(MainFrame frame,List<String> l){
		//public OrderTicketPanel(MainFrame frame,SearchFlightResultPanel resultPanel){
		action=new Action();
	//	this.resultPanel=resultPanel;
		this.frame=frame;
		Font font=new Font("宋体",Font.BOLD,15);
		jp1 = new JPanel();
		jp1_1  = new JPanel();
		jp1_2  = new JPanel();
		jp1_2_1 = new JPanel();jp1_2_2 = new JPanel();
		jl1 = new JLabel (l.get(0));
		jl2 = new JLabel (l.get(1));
		jl3 = new JLabel (l.get(2));
		jl4 = new JLabel (l.get(3));
		jl5 = new JLabel (l.get(4));
		jl6 = new JLabel (l.get(5));
		jl7 = new JLabel (l.get(6)+"");
		jl8 = new JLabel ("免费改签一次，退票收取5%手续费");
		fuel_consA = Integer.parseInt(l.get(7).trim());
		fuel_consB = Integer.parseInt(l.get(8).trim());
		fuel_consC = Integer.parseInt(l.get(9).trim());
		fuel_oilA = Integer.parseInt(l.get(10).trim());
		fuel_oilB = Integer.parseInt(l.get(11).trim());
		fuel_oilC = Integer.parseInt(l.get(12).trim());
		airlinenum = Integer.parseInt(l.get(13).trim());
		pass_disA =  Double.parseDouble(l.get(14).trim());
		pass_disB = Double.parseDouble(l.get(15).trim());
		pass_disC = Double.parseDouble(l.get(16).trim());
		cabin_disF= Double.parseDouble(l.get(17).trim());
		cabin_disC= Double.parseDouble(l.get(18).trim());
		cabin_disY= Double.parseDouble(l.get(19).trim());
		fli_id = Integer.parseInt(l.get(20).trim());
		
		BasePrice = Double.parseDouble(l.get(6));
		
		jl1.setFont(font);jl2.setFont(font);jl3.setFont(font);jl4.setFont(font);
		jl5.setFont(font);jl6.setFont(font);jl7.setFont(font);jl8.setFont(font);
		jp2 = new JPanel();
		jp2_1  = new JPanel();
		jp2_2  = new JPanel();
		jcbb = new JComboBox();
		jsp = new JScrollPane(jp2_2);
		jp3 = new JPanel();
		jp3_1 = new JPanel();jp3_2 = new JPanel();
		jl9 = new JLabel ("");
		jf1 = new JTextField(8);jf2 = new JTextField(8);jf3 = new JTextField(8);
		jf1.setEditable(false);jf2.setEditable(false);jf3.setEditable(false);
		jb1 = new JButton("出票");jb2 = new JButton("取消");
		init();
		prompt();
		disposeDialog();
		addComboListener();
	}
	private void init(){
		jp1.setLayout(new BorderLayout());
		jp1_1.add(new JLabel("订票"));
		jp1.add(jp1_1,BorderLayout.NORTH);
		bo1 = BorderFactory.createTitledBorder("航班信息");
		jp1_2.setBorder(bo1);
		jp1_2.setLayout(new GridLayout(2,1));
		jp1_2_1.add(new JLabel("航班号"));jp1_2_1.add(jl1);
		jp1_2_1.add(new JLabel("日期"));jp1_2_1.add(jl2);
		jp1_2_1.add(new JLabel("出发地"));jp1_2_1.add(jl3);
		jp1_2_1.add(new JLabel("目的地"));jp1_2_1.add(jl4);
		jp1_2_1.add(new JLabel("起飞时间"));jp1_2_1.add(jl5);
		jp1_2.add(jp1_2_1);
		jp1_2_2.add(new JLabel("到达时间"));jp1_2_2.add(jl6);
		jp1_2_2.add(new JLabel("票价"));jp1_2_2.add(jl7);
		jp1_2_2.add(new JLabel("退改签规定:"));jp1_2_2.add(jl8);
		Color c = new Color(255,0,0);
		jl8.setForeground(c);
		jp1_2.add(jp1_2_2);
		jp1.add(jp1_2,BorderLayout.CENTER);
		
		jp2.setLayout(new BorderLayout());
		bo2 = BorderFactory.createTitledBorder("乘客信息");
		jp2.setBorder(bo2);
		jp2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_1.add(new JLabel("乘客人数："));
		
		List<String> list = new ArrayList<String>();//添加人数
		jcbb.addItem("无");
		for(int i=1;i<10;i++){
			list.add((i)+"人");
			jcbb.addItem(list.get(i-1));
		}
		
		jp2_1.add(jcbb);
		jp2.add(jp2_1,BorderLayout.NORTH);
		jp2.add(jsp,BorderLayout.CENTER);
		
		jp3.setLayout(new BorderLayout());
		bo3 = BorderFactory.createTitledBorder("应收款项");
		jp3_1.setBorder(bo3);
		jp3_1.add(new JLabel("机票款:"));	jp3_1.add(jf1);
		jp3_1.add(new JLabel("机场建设费:"));	jp3_1.add(jf2);
		jp3_1.add(new JLabel("燃油税:"));	jp3_1.add(jf3);
		jp3_1.add(new JLabel("合计:"));
		Font f = new Font("宋体",Font.BOLD,30);
		jl9.setFont(f);
		Color cc = new Color(255,0,0);
		jl9.setForeground(cc);
		jp3_1.add(jl9);
		jp3.add(jp3_1,BorderLayout.CENTER);
		jp3_2.add(jb1);jp3_2.add(new JLabel("                      "));jp3_2.add(jb2);
		jp3.add(jp3_2,BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
	}
	
	public void showMe(){
		frame.setSize(900,500);
		frame.setVisible(true);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void prompt(){
		jb1.addActionListener(new ActionListener(){//???????出票
			public void actionPerformed(ActionEvent e) {
				List<Ticket> list = new ArrayList<Ticket>();
				List<OrderItem> list2 = new ArrayList<OrderItem>();
				List<Passenger> list3 = new ArrayList<Passenger>();
				String s = "";
				if(ticket.length==0){
					JOptionPane.showMessageDialog(OrderTicketPanel.this, "购票失败");	
					return;
				}else {
					
					type:for(int i=0;i<ticket.length;i++){
						if(ticket[i].getPasstype().equals("婴儿")){
							int n1 = 0,n2 = 0;
							for (int j = 0; j < ticket.length; j++) {
								if(ticket[j].getPasstype().equals("婴儿")){
									n1++;
								}
								if(ticket[j].getPasstype().equals("成人")){
									n2++;
								}
							}
							System.out.println("婴儿人数"+n1);
							System.out.println("成人人数"+n2);
							if(n2 >= n1){
								JOptionPane.showMessageDialog(OrderTicketPanel.this, "符合要求,可以购票");
								System.out.println("----------------------------------------------------符合要求");
								break type;
								
							}else{
								JOptionPane.showMessageDialog(OrderTicketPanel.this, "婴儿人数大于成人人数,不能购票!");
								System.out.println("不能购票");
								return;
							}
						}
					}
					for(int i=0;i<ticket.length;i++){
						String s1 = "";
						Ticket k = new Ticket();
						OrderItem t = new OrderItem();
						Passenger p = new Passenger();
						System.out.println(("航线号"+airlinenum));
						System.out.println("航班号"+jl1.getText());
						System.out.println("出发日期"+jl2.getText());
						System.out.println("出发时间"+jl5.getText());
						System.out.println("乘客姓名"+ticket[i].getPassname());
						if(ticket[i].getPassname().equals("")||ticket[i].getPasscetnum().equals("")){
							JOptionPane.showMessageDialog(OrderTicketPanel.this, "请填写完整信息");	
							return;
						}
						System.out.println("乘客证件号"+ticket[i].getPasscetnum());
						System.out.println("乘客类型"+ticket[i].getPasstype());
						System.out.println("舱位类型"+ticket[i].getclasstype());
						System.out.println("票价"+"====="+ticket[i].getTicketPrice());
						p.setCertif_type("身份证");
						p.setCertif_num(ticket[i].getPasstype());
						p.setName(ticket[i].getPassname());
						if(ticket[i].getPasstype().equals("成人")){
							p.setPsg_type("A");
						}else if(ticket[i].getPasstype().equals("儿童")){
							p.setPsg_type("C");
						}else{
							p.setPsg_type("I");
						}
						t.setFlight_id(fli_id);
						if(ticket[i].getclasstype().equals("头等舱")){
						t.setOrd_cabin_class("F");
						}else if(ticket[i].getclasstype().equals("公务舱")){
							t.setOrd_cabin_class("C");
						}else{
							t.setOrd_cabin_class("Y");
						}
						t.setTicket_price((int)ticket[i].getTicketPrice());
						k.setFlight_num(fli_id);
						k.setPsg_name(ticket[i].getPassname());
						k.setSta_from_airport(jl3.getText());
						k.setEnd_from_airport(jl4.getName());
						k.setTicket_start_date(jl2 .getText());
						if(ticket[i].getclasstype().equals("头等舱")){
							k.setCabin_class_id(1001);
							}else if(ticket[i].getclasstype().equals("公务舱")){
								k.setCabin_class_id(1002);
							}else{
								k.setCabin_class_id(1003);
							}
						if(!ticket[i].getPasstype().equals("婴儿")){
						k.setSeat_number(seat++);
						}else{
							k.setSeat_number(0);
						}
						list.add(k);
						list2.add(t);
						list3.add(p);
						s1 ="第"+(i+1)+"位乘客"+"航班号:"+jl1.getText()+",乘客姓名:"+ticket[i].getPassname()+",出发日期:"+jl2.getText()+jl5.getText()+
						",乘客证件号:"+ticket[i].getPasscetnum()+",乘客类型:"+ticket[i].getPasstype()+",舱位类型:"+ticket[i].getclasstype()+
						"票价:"+ticket[i].getTicketPrice()+"元。\n";
						s = s+s1;
					}
						//Request req = new Request(Request.ORDER_TICKET_REQUEST);
						//req.addData("tickets", list);
						//req.addData("orderItem", list2);
						//req.addData("Passenger", list3);
						//Response res = action.doAction(req);
//						boolean flag = (Boolean) res.getData("state");
						System.out.println(list);
						System.out.println(list2);
						System.out.println(list3);
						boolean flag = true;
						System.out.println(flag);
						if(flag==true){
							JOptionPane.showMessageDialog(OrderTicketPanel.this, "购票成功\n"+s);	
							jp2_2.removeAll();
							jp2_2.updateUI();
						}else {
							JOptionPane.showMessageDialog(OrderTicketPanel.this, "购票失败");	
						}
					}			
				}
		});
	}
	private void disposeDialog(){
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//转到前一个窗口
					frame.setCard("SearchTicket");
			}
		});
	}
	private void addComboListener(){
		jcbb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int i = jcbb.getSelectedIndex()-1;
				
				jp2_2.setLayout(new GridLayout(10,1));
				jp2_2.removeAll();
				

				ticket = new MyJPanel[i+1];
				System.out.println(ticket.length);	
				for(int j=0;j<=i;j++){
//					JPanel x = new MyJPanel(j,fuel_consA,fuel_consB,fuel_consC,fuel_oilA,fuel_oilB,fuel_oilC,BasePrice,
//							pass_disA,pass_disB,pass_disC,cabin_disF,cabin_disC,cabin_disY).getMyJPanel();
					ticket[j] = new MyJPanel(j,fuel_consA,fuel_consB,fuel_consC,fuel_oilA,fuel_oilB,fuel_oilC,BasePrice,
					pass_disA,pass_disB,pass_disC,cabin_disF,cabin_disC,cabin_disY);
					jp2_2.add(ticket[j]);
				}
				jp2_2.updateUI();
				jf1.setText(Double.parseDouble(jl7.getText())*(i+1)+"");
				jf2.setText(fuel_consA*(i+1)+"");//机场建设费
				jf3.setText(fuel_oilA*(i+1)+"");//燃油费
				refresh();
				
			}	
		});

	}
	
	public static void refresh(){
		jl9.setText(Double.parseDouble(jf1.getText())+Double.parseDouble(jf2.getText())+Double.parseDouble(jf3.getText())+"");
	}
	public static JTextField getjf1(){
		return jf1;
	}
	public static JTextField getjf2(){
		return jf2;
	}
	public static JTextField getjf3(){
		return jf3;
	}
}

class MyJPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp1;
	private JPanel jp2;
	
	private JLabel jl0;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JLabel jl5;
	
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	
	private JComboBox jcbb1;
	private JComboBox jcbb2;
	
	private String passtype = "成人";
	private String classtype="经济舱";
	private int A,B,C;//机场建设费
	private int OA,OB,OC;//燃油费
	private double BasePrice;//基准价格
	private double PA,PB,PC;//乘客折扣
	private double CF,CC,CY;//舱位折扣
	private double TicketPrice;//票价
	public MyJPanel(int i,int A,int B,int C,int OA,int OB,int OC,double BasePrice,Double PA,Double PB,Double PC,
			double CF,double CC,double CY){
		jl0 = new JLabel("第"+(i+1)+"位乘客:");
		jl0.setForeground(Color.BLUE);
		jl1 = new JLabel("乘客姓名：");jl2 = new JLabel("证件号码：");jl3=new JLabel("联系电话：");jl4 = new JLabel("乘客类型：");jl5 = new JLabel("舱位等级：");
		jt1 = new JTextField(5);jt2 = new JTextField(20);
		jt3=new JTextField(13);
		jp1 = new JPanel();jp2 = new JPanel();
		jcbb1 = new JComboBox();jcbb2 = new JComboBox();
		this.A = A;this.B = B;	this.C = C;
		this.OA = OA;this.OB = OB;this.OC = OC;
		this.PA = PA;this.PB = PB;this.PC = PC;
		this.CF =  CF;this.CC =  CC;this.CY =  CY;
		this.BasePrice = BasePrice;
		init();
	}
	
	private void init(){
		this.setLayout(new GridLayout(2,1));
		this.setBorder(BorderFactory.createTitledBorder(""));
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.add(jl0);
		
		jp2.add(jl1);jp2.add(jt1);
		jp2.add(jl2);jp2.add(jt2);
		jp2.add(jl3);jp2.add(jt3);
		jp2.add(jl4);jcbb1.addItem("成人");jcbb1.addItem("儿童");jcbb1.addItem("婴儿");jp2.add(jcbb1);
		jp2.add(jl5);jcbb2.addItem("经济舱");jcbb2.addItem("公务舱");jcbb2.addItem("头等舱");jp2.add(jcbb2);
		
		this.add(jp1);
		this.add(jp2);
		
		jcbb1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String str=(String) jcbb1.getSelectedItem();
				System.out.println("=======乘客类型是"+str);
				if(str.equals("成人")){
					System.out.println("成人");
					//机场建设费
					String ss = OrderTicketPanel.getjf2().getText().trim();
					int t = Integer.parseInt(ss);
					//燃油费
					String os = OrderTicketPanel.getjf3().getText().trim();
					int ot = Integer.parseInt(os);
					if(passtype.equals("成人")){
						t = t - A;ot = ot - OA;
					}else if(passtype.equals("儿童")){
						t = t - C;ot = ot - OC;
					}else if(passtype.equals("婴儿")){
						t = t - B;ot = ot - OB;
					}
					t = t+A;ot = ot+ OA;
					OrderTicketPanel.getjf2().setText(t+"");
					OrderTicketPanel.getjf3().setText(ot+"");		
					refreshpass(str,classtype);
					OrderTicketPanel.refresh();
				}else if(str.equals("儿童")){
					System.out.println("儿童");
					//机场建设费
					String ss = OrderTicketPanel.getjf2().getText().trim();
					int t = Integer.parseInt(ss);
					//燃油费
					String os = OrderTicketPanel.getjf3().getText().trim();
					int ot = Integer.parseInt(os);
					if(passtype.equals("成人")){
						t = t - A;ot = ot - OA;	
					}else if(passtype.equals("儿童")){
						t = t - C;ot = ot - OC;	
					}else if(passtype.equals("婴儿")){
						t = t - B;ot = ot - OB;	
					}
					t = t+C;ot = ot+ OC;
					OrderTicketPanel.getjf2().setText(t+"");
					OrderTicketPanel.getjf3().setText(ot+"");		
					refreshpass(str,classtype);
					OrderTicketPanel.refresh();
				}else if(str.equals("婴儿")){
					System.out.println("婴儿");
					//机场建设费
					String ss = OrderTicketPanel.getjf2().getText().trim();
					int t = Integer.parseInt(ss);
					//燃油费
					String os = OrderTicketPanel.getjf3().getText().trim();
					int ot = Integer.parseInt(os);
					if(passtype.equals("成人")){
						t = t - A;ot = ot - OA;				
					}else if(passtype.equals("儿童")){
						t = t - C;ot = ot - OC;			
					}else if(passtype.equals("婴儿")){
						t = t - B;ot = ot - OB;		
					}
					t = t+B;ot = ot+ OB;
					OrderTicketPanel.getjf2().setText(t+"");
					OrderTicketPanel.getjf3().setText(ot+"");			
					refreshpass(str,classtype);
					OrderTicketPanel.refresh();
				}
			}
		});
		jcbb2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println(CF+CC+CY+"");
				String str=(String) jcbb2.getSelectedItem();
				if(str.equals("经济舱")){
					refreshpass(passtype,str);
				}else if(str.equals("公务舱")){
					refreshpass(passtype,str);
				}else if(str.equals("头等舱")){
					refreshpass(passtype,str);
				}
				
			}
		});
	}

	
	public void refreshpass(String str,String str1){
		if(str.equals("成人")&&str1.equals("经济舱")){
			System.out.println("成人");
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PA*CY;	
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("儿童")&str1.equals("经济舱")){
			System.out.println("儿童");
			//乘客类型折扣
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PC*CY;
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("婴儿")&str1.equals("经济舱")){
			System.out.println("婴儿");
			//乘客类型折扣
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CY;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PB*CY;
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("成人")&&str1.equals("公务舱")){
			System.out.println("成人");
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
								if(classtype.equals("经济舱")){
									po = po - BasePrice*PA*CY;
								}else if(classtype.equals("公务舱")){
									po = po - BasePrice*PA*CC;
								}else if(classtype.equals("头等舱")){
									po = po - BasePrice*PA*CF;
								}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CC;
								if(classtype.equals("经济舱")){
									po = po - BasePrice*PC*CY;
								}else if(classtype.equals("公务舱")){
									po = po - BasePrice*PC*CC;
								}else if(classtype.equals("头等舱")){
									po = po - BasePrice*PC*CF;
								}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CC;
								if(classtype.equals("经济舱")){
									po = po - BasePrice*PB*CY;
								}else if(classtype.equals("公务舱")){
									po = po - BasePrice*PB*CC;
								}else if(classtype.equals("头等舱")){
									po = po - BasePrice*PB*CF;
								}
			}
			po = po + BasePrice*PA*CC;	
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("儿童")&str1.equals("公务舱")){
			System.out.println("儿童");
			//乘客类型折扣
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CC;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CC;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CC;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PC*CC;
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("婴儿")&str1.equals("公务舱")){
			System.out.println("婴儿");
			//乘客类型折扣
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CC;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CC;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CC;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PB*CC;
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("成人")&&str1.equals("头等舱")){
			System.out.println("成人");
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PA*CF;	
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("儿童")&str1.equals("头等舱")){
			System.out.println("儿童");
			//乘客类型折扣
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PC*CF;
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}else if(str.equals("婴儿")&str1.equals("头等舱")){
			System.out.println("婴儿");
			//乘客类型折扣
			String ps = OrderTicketPanel.getjf1().getText().trim();
			double po = Double.parseDouble(ps);
			if(passtype.equals("成人")){
//				po = po - BasePrice*PA*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PA*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PA*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PA*CF;
				}
			}else if(passtype.equals("儿童")){
//				po = po - BasePrice*PC*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PC*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PC*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PC*CF;
				}
			}else if(passtype.equals("婴儿")){
//				po = po - BasePrice*PB*CF;
				if(classtype.equals("经济舱")){
					po = po - BasePrice*PB*CY;
				}else if(classtype.equals("公务舱")){
					po = po - BasePrice*PB*CC;
				}else if(classtype.equals("头等舱")){
					po = po - BasePrice*PB*CF;
				}
			}
			po = po + BasePrice*PB*CF;
			OrderTicketPanel.getjf1().setText(po+"");
			OrderTicketPanel.refresh();
			passtype = str;
			classtype = str1;
		}
	}
	
	
	
	public double getTicketPrice(){//得到票价
		System.out.println("得到票价方法");
		System.out.println(BasePrice);
		System.out.println("pa"+PA);
		System.out.println("pc"+PC);
		System.out.println("pb"+PB);
		System.out.println("cy"+CY);
		System.out.println("CC"+CC);
		System.out.println("CF"+CF);
		System.out.println("A"+A);
		System.out.println("OA"+OA);
		System.out.println("C"+C);
		System.out.println("oc"+OC);
		System.out.println("B"+B);
		System.out.println("OB"+OB);
		TicketPrice = BasePrice;
		if(passtype.equals("成人")){
			TicketPrice = TicketPrice*PA;
		}else if(passtype.equals("儿童")){
			TicketPrice = TicketPrice*PC;
		}else if(passtype.equals("婴儿")){
			TicketPrice = TicketPrice*PB;
		}
		if(classtype.equals("经济舱")){
			TicketPrice = TicketPrice*CY;
		}else if(classtype.equals("公务舱")){
			TicketPrice = TicketPrice*CC;
		}else if(classtype.equals("头等舱")){
			TicketPrice = TicketPrice*CF;
		}
		if(passtype.equals("成人")){
			TicketPrice = TicketPrice+A+OA;
		}else if(passtype.equals("儿童")){
			TicketPrice = TicketPrice+C+OC;
		}else if(passtype.equals("婴儿")){
			TicketPrice = TicketPrice+B+OB;
		}
		return TicketPrice;
	}
	
	public String getPassname(){
		return jt1.getText();
	}
	public String getPasscetnum(){
		return jt2.getText();
	}
	public String getPassTel(){
		return jt3.getText();
	}
	public String getPasstype(){
		return passtype;
	}
	public String getclasstype(){
		return classtype;
	}
	public JPanel getMyJPanel(){
		return this;
	}
	
	public String getJTextField1(){
		
		return null;
	}
	
	public String getJTextField2(){
		
		return null;
	}
	
	public String getJComboBox1(){
		
		return null;
	}

	public String getJComboBox2(){
	
	return null;
	}
	
}

//public void refreshpass(String str){
//	if(str.equals("成人")){
//		System.out.println("成人");
//		//机场建设费
//		String ss = OrderTicketPanel.getjf2().getText().trim();
//		int t = Integer.parseInt(ss);
//		//燃油费
//		String os = OrderTicketPanel.getjf3().getText().trim();
//		int ot = Integer.parseInt(os);
//		//乘客类型折扣
//		String ps = OrderTicketPanel.getjf1().getText().trim();
//		double po = Double.parseDouble(ps);
//		if(passtype.equals("成人")){
//			t = t - A;ot = ot - OA;po = po - BasePrice*PA;
//		}else if(passtype.equals("儿童")){
//			t = t - C;ot = ot - OC;po = po - BasePrice*PC;
//		}else if(passtype.equals("婴儿")){
//			t = t - B;ot = ot - OB;po = po - BasePrice*PB;
//		}
//		t = t+A;ot = ot+ OA;
//		po = po + BasePrice*PA;
//		OrderTicketPanel.getjf2().setText(t+"");
//		OrderTicketPanel.getjf3().setText(ot+"");		
//		OrderTicketPanel.getjf1().setText(po+"");
//		OrderTicketPanel.refresh();
//		passtype = str;
//	}else if(str.equals("儿童")){
//		System.out.println("儿童");
//		//机场建设费
//		String ss = OrderTicketPanel.getjf2().getText().trim();
//		int t = Integer.parseInt(ss);
//		//燃油费
//		String os = OrderTicketPanel.getjf3().getText().trim();
//		int ot = Integer.parseInt(os);
//		//乘客类型折扣
//		String ps = OrderTicketPanel.getjf1().getText().trim();
//		double po = Double.parseDouble(ps);
//		if(passtype.equals("成人")){
//			t = t - A;ot = ot - OA;		po = po - BasePrice*PA;
//		}else if(passtype.equals("儿童")){
//			t = t - C;ot = ot - OC;		po = po - BasePrice*PC;
//		}else if(passtype.equals("婴儿")){
//			t = t - B;ot = ot - OB;		po = po - BasePrice*PB;
//		}
//		t = t+C;ot = ot+ OC;
//		po = po + BasePrice*PC;
//		OrderTicketPanel.getjf2().setText(t+"");
//		OrderTicketPanel.getjf3().setText(ot+"");		
//		OrderTicketPanel.getjf1().setText(po+"");
//		OrderTicketPanel.refresh();
//		passtype = str;
//	}else if(str.equals("婴儿")){
//		System.out.println("婴儿");
//		//机场建设费
//		String ss = OrderTicketPanel.getjf2().getText().trim();
//		int t = Integer.parseInt(ss);
//		//燃油费
//		String os = OrderTicketPanel.getjf3().getText().trim();
//		int ot = Integer.parseInt(os);
//		//乘客类型折扣
//		String ps = OrderTicketPanel.getjf1().getText().trim();
//		double po = Double.parseDouble(ps);
//		if(passtype.equals("成人")){
//			t = t - A;ot = ot - OA;				po = po - BasePrice*PA;
//		}else if(passtype.equals("儿童")){
//			t = t - C;ot = ot - OC;				po = po - BasePrice*PC;
//		}else if(passtype.equals("婴儿")){
//			t = t - B;ot = ot - OB;				po = po - BasePrice*PB;
//		}
//		t = t+B;ot = ot+ OB;
//		po = po + BasePrice*PB;
//		OrderTicketPanel.getjf2().setText(t+"");
//		OrderTicketPanel.getjf3().setText(ot+"");			
//		OrderTicketPanel.getjf1().setText(po+"");
//		OrderTicketPanel.refresh();
//		passtype = str;
//	}
//}
