package com.tolo.tabcs.server.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.tolo.tabcs.server.service.ServerMainClass;

public class ServerFrame{
	private JFrame frame;
	private JButton button1,button2;
	private MyJPanel mj;
	private ServerMainClass smc=new ServerMainClass();
	public ServerFrame() {
		super();
		this.frame = new JFrame("服务控制中心");
		this.button1 = new JButton("开启服务器");
		this.button2 = new JButton("关闭服务器");
		mj=new MyJPanel("res"+File.separator+"logolabel.png");
		init();
		addHandler();
		frame.setIconImage(new ImageIcon("res"+File.separator+"logolabel.png").getImage());
	}
	public void init(){
		mj.setLayout(new FlowLayout());
		frame.add(mj);
		mj.add(button1);
		mj.add(button2);
	}
	public void showMe(){
	 frame.setSize(300,300);
	 frame.setVisible(true);
	 frame.setLocation(550,250);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public void addHandler(){
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			//	frame.dispose();
			//	smc.startService();
				go();
				button1.setEnabled(false);
			}
			
		});
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				smc.close();
				System.exit(0);
			}
			
		});
	}
	
	private void go(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				smc.startService();
			}
			
		}).start();
	}
	
	public static void main(String[] args) {
		new ServerFrame().showMe();
	}
	
}
