package com.tolo.tabcs.common.client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.tolo.tabcs.common.gui.LoginFrame;
public class ClientMainClass {
	private JFrame frame;
	private JProgressBar progressBar;
	private JLabel label;
	public ClientMainClass() {
		frame = new JFrame();
		label = new JLabel("欢迎使用TOLO航空公司国内航线营业柜员系统！");
		progressBar = new JProgressBar(0, 100);// 设置一个读取条
		progressBar.setPreferredSize(new Dimension(600,20));
		init();
	}

	private void init() {
		label.setFont(new Font("宋体", Font.BOLD, 25));

		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.add(progressBar);
		frame.setIconImage(new ImageIcon("res" + File.separator + "logolabel.png").getImage());
	}

	public void showMe() {
		frame.setVisible(true);
		frame.setSize(650, 100);
		frame.setLocation(400, 400);
		frame.setResizable(false);
	}

	class modifyThread extends Thread {
		@Override
		public void run() {
			for (int i = 1; i < 11; i++) {
				try {
					Thread.sleep(100);
					progressBar.setValue(i * 10);// 每秒读取条走动一下
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void go() {
		new modifyThread().run();
		
		frame.dispose();//销毁当前读取条
		new LoginFrame().setVisible(true);//弹出登录界面
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientMainClass b = new ClientMainClass();
		b.showMe();
		b.go();
	}

}
