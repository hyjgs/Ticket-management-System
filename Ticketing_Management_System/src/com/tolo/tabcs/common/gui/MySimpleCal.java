package com.tolo.tabcs.common.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class MySimpleCal extends JDialog{
	
	/**
	 * 日历对话框
	 */
	private static final long serialVersionUID = 24956879L;
	private JButton btn;
	private JSpinner yearSpi;
	private JComboBox monthBox;
	private Calendar cal;
	private JPanel panel;
	private int startPoint_x=20;
	private int startPoint_y=10;
	private JLabel lastLabel;
	private JFrame owner;//父窗口
	private JTextField text;//填写日期的文本框
	
	private int plane_scheduler;
	
	public MySimpleCal(JFrame owner,JTextField text,int t){
		super(owner,true);
		this.plane_scheduler = t;
		System.out.println(plane_scheduler+"班期");
		this.owner=owner;
		this.text=text;
		cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		
		panel=new JPanel();
		initCalPanel();
		
		JPanel southPanel=new JPanel();
		btn=new JButton("确定");
		southPanel.add(btn);
		
		SpinnerNumberModel snm=new SpinnerNumberModel(year,year-10,year+10,1);	
		
		yearSpi=new JSpinner(snm);
//		yearSpi.getEditor().setEnabled(false);
		String[] str={"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		monthBox=new JComboBox(str);
		
		JPanel northPanel=new JPanel();
		northPanel.add(yearSpi);
		northPanel.add(monthBox);
		monthBox.setSelectedIndex(month);
		
		this.setLayout(new BorderLayout());
		this.add(northPanel,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		this.add(southPanel,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(310, 350);
		this.setMiddle();
		this.addEventListener();
	}
	
	private void setMiddle(){
		Point point=owner.getLocationOnScreen();
		int x=point.x;
		int y=point.y;
		int width=(int)((owner.getWidth()-this.getWidth())/2);
		int height=(int)((owner.getHeight()-this.getHeight())/2);
		this.setLocation(x+width, y+height);
	}
	
	private void initCalPanel(){
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int maxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int mark=1;
		int firstDayOfWeek=new GregorianCalendar(year,month,1).get(Calendar.DAY_OF_WEEK);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		String[] week={"日","一","二","三","四","五","六"};
		for(int i=0;i<7;i++){
			addLabelOnPanel(i,week[i],false);
		}
		for(int i=1;i<firstDayOfWeek;i++){
			startPoint_x+=40;
		}
		for(int i=firstDayOfWeek-1;i<7;i++){
			addLabelOnPanel(i,""+mark++,true);
		}
		while(mark<=maxDay){
			for(int i=0;i<7;i++){
				addLabelOnPanel(i,""+mark++,true);
				if(mark>=maxDay) break;
			}
		}
		
	}
	
	private void addLabelOnPanel(int i,String str,boolean listenerSign){
		final JLabel label=new JLabel(str);
		label.setBackground(Color.WHITE);
		label.setBounds(startPoint_x, startPoint_y, 20, 20);
		startPoint_x+=40;
		if(i==6){
			startPoint_x=20;
			startPoint_y+=35;
		}
		panel.add(label);
		if(listenerSign){
			////????????????????????????????
			if(getNum(7-i)==1){
			int selected=Integer.parseInt(str);
			if(cal.get(Calendar.DAY_OF_MONTH)==selected){
				lastLabel=label;
				lastLabel.setForeground(Color.RED);
			}
			label.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent e) {
					lastLabel.setForeground(Color.BLACK);
					label.setForeground(Color.RED);
					lastLabel=label;
				}
				
			});
			}else{
				int selected=Integer.parseInt(str);
				if(cal.get(Calendar.DAY_OF_MONTH)==selected){
					lastLabel=label;
					lastLabel.setForeground(Color.BLUE);
				}
				label.addMouseListener(new MouseAdapter(){

					@Override
					public void mouseClicked(MouseEvent e) {
						lastLabel.setForeground(Color.BLACK);
						label.setForeground(Color.BLUE);
						lastLabel=label;
					}
					
				});
			}
		}
	}
	
	private void resetPanel(){
		cal=new GregorianCalendar(Integer.parseInt(yearSpi.getValue().toString()),
				monthBox.getSelectedIndex(),Integer.parseInt(lastLabel.getText()));
		startPoint_x=20;
		startPoint_y=10;
		panel.removeAll();
		panel.repaint();
		initCalPanel();
	}
	
	private void addEventListener(){
		btn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int year=cal.get(Calendar.YEAR);
				int month=cal.get(Calendar.MONTH);
				String date=lastLabel.getText();
				String str2=month+1+"";
				String str3=date;
				if(month+1<10){
					str2="0"+(month+1);
				}
				
				if(Integer.valueOf(date)<10){
					str3="0"+date;
				}
				text.setText(year+"-"+str2+"-"+str3);
				MySimpleCal.this.dispose();
			}
			
		});
		
		monthBox.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				resetPanel();
			}
			
		});
		
		yearSpi.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				resetPanel();
			}
		});
	}
	
	//得到第t位的数字
	private int getNum(int t){
		int m=1;
		for(int i=0;i<t-1;i++){
			 m = m*10;
		}
		int x = (this.plane_scheduler/m)%10;
		
		
		return x;
	}
	
//	public static void main(String[] args) {
//		for(int i=1;i<=7;i++){
//		System.out.println(getNum(i)+"\t");
//		}
//	}
	
//	public static void main(String[] args) {
//	JFrame j = new JFrame();
//	j.setLocation(300, 400);
//	j.setSize(200, 200);
//	j.setVisible(true);
//	MySimpleCal c = new MySimpleCal(j, new JTextField("日利"),10);
//	c.setVisible(true);
//}
//	
	
}
