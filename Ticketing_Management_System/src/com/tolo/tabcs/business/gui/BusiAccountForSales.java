package com.tolo.tabcs.business.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author TangLiang
 */
@SuppressWarnings("serial")
public class BusiAccountForSales extends JPanel{
	//private Box box;
	private static BusiAccountForSalesA aPanel;
	private static BusiAccountForSalesB bPanel;
	
	public BusiAccountForSales(){
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		aPanel=new BusiAccountForSalesA();
		bPanel=new BusiAccountForSalesB();
	//	this.add(aPanel);
	//	this.add(new JLabel(" "));
	//	this.add(bPanel);
		
		this.setLayout(new BorderLayout());
		this.add(aPanel,BorderLayout.WEST);
		this.add(bPanel,BorderLayout.EAST);
	}

	public static BusiAccountForSalesA getAPanel() {
		return aPanel;
	}

	public static void setAPanel(BusiAccountForSalesA panel) {
		aPanel = panel;
	}

	public static BusiAccountForSalesB getBPanel() {
		return bPanel;
	}

	public static void setBPanel(BusiAccountForSalesB panel) {
		bPanel = panel;
	}
	
}

