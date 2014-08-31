/*
 * SaleSubmitPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.tolo.tabcs.business.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;


/**
 * @author TangLiang
 */
@SuppressWarnings("serial")
public class BusiAccountForManager extends javax.swing.JPanel {

	//private Box box;
	private static BusiAccountForManagerA aPanel;
	private static BusiAccountForManagerB bPanel;
	
	public BusiAccountForManager(){
	//	box=new Box(BoxLayout.X_AXIS);
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		aPanel=new BusiAccountForManagerA();
		bPanel=new BusiAccountForManagerB();
		this.add(aPanel);
		this.add(new JLabel("          "));
		this.add(bPanel);
	}

	public static BusiAccountForManagerA getAPanel() {
		return aPanel;
	}

	public static void setAPanel(BusiAccountForManagerA panel) {
		aPanel = panel;
	}

	public static BusiAccountForManagerB getBPanel() {
		return bPanel;
	}

	public static void setBPanel(BusiAccountForManagerB panel) {
		bPanel = panel;
	}	
	
}