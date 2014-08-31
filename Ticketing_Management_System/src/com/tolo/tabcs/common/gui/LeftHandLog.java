package com.tolo.tabcs.common.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftHandLog extends JPanel {
	private static final long serialVersionUID = 7080406260912017919L;
	
	JButton b = new JButton("手动日志");
	
	public LeftHandLog() {
		setOpaque(false);//设置面板透明
		this.add(b);
	}
	
}
