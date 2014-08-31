package com.tolo.tabcs.common.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftSearchMessage extends JPanel {
	private static final long serialVersionUID = 7080406260912017998L;
	
	JButton b = new JButton("查看留言");
	
	public LeftSearchMessage() {
		setOpaque(false);//设置面板透明
		this.add(b);
	}
	
}
