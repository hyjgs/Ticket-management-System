package com.tolo.tabcs.common.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import javax.swing.*;;

/**
 * 增加面板顶部上划线
 * @author TangLiang
 */
public class SepPanel extends JPanel{
	private static final long serialVersionUID = -5712318928855884092L;

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		this.setSize(675,5);
		Graphics2D g2=(Graphics2D)g;
		Shape s1=new Line2D.Double(5,3,700,3);
		g2.setColor(Color.LIGHT_GRAY);
		g2.draw(s1);
	}
	
//	public static void main(String[] args) {
//		JFrame j = new JFrame();
//		j.setSize(300,400);
//		j.setLocation(300, 300);
//		j.add(new SepPanel());
//		j.setVisible(true);
//	}
}
