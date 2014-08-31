package com.tolo.tabcs.common.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftUseHelp extends JPanel {
	private static final long serialVersionUID = 7080406260912017199L;
	
	JButton b = new JButton("使用帮助");
	
	public LeftUseHelp() {
		setOpaque(false);//设置面板透明
		this.add(b);
	}
	
}
