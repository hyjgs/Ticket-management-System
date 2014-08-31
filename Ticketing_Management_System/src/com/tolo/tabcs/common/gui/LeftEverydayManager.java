package com.tolo.tabcs.common.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftEverydayManager extends JPanel {
	private static final long serialVersionUID = 7080406260912017999L;
	
	JButton b = new JButton("日常管理");
	
	public LeftEverydayManager() {
		setOpaque(false);//设置面板透明
		this.add(b);
	}
	
}
