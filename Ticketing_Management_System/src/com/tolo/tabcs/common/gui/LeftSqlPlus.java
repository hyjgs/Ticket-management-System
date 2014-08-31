package com.tolo.tabcs.common.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftSqlPlus extends JPanel {
	private static final long serialVersionUID = 7080406260912017991L;
	
	JButton b = new JButton("SQLPLUS");
	
	public LeftSqlPlus() {
		setOpaque(false);//设置面板透明
		this.add(b);
	}
	
}
