package com.tolo.tabcs.common.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftAboutAuthor extends JPanel {
	private static final long serialVersionUID = 7080406260911017999L;
	
	private Image img;
	private int width;//设置图片的宽
	private int height;//设置图片的高
	private int left;//距离上层容器左端的距离
	private int top;//距离上层容器的上端的距离

	public LeftAboutAuthor(String imgPath) {
		img = new ImageIcon(imgPath).getImage();// 根据图片路径得到Icon，并得到image图片对象
	}

	public LeftAboutAuthor(String imgPath,int width,int height) {
		img = new ImageIcon(imgPath).getImage();
		this.width=width;
		this.height=height;
	}
	
	public LeftAboutAuthor(String imgPath,int width,int height,int left,int top) {
		img = new ImageIcon(imgPath).getImage();
		this.width=width;
		this.height=height;
		this.left=left;
		this.top=top;
	}
	
	public LeftAboutAuthor() {
	//	this("res"+File.separator+"author.jpg",600,400,280,100);
		
		setOpaque(false);//设置面板透明
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screenSize.width/2-400; //得到屏幕尺寸
		int y = screenSize.height/2-300;
		
		img = new ImageIcon("res"+File.separator+"author.jpg").getImage();
		this.width=600;
		this.height=400;
		this.left=x;
		this.top=y;
		
	}

	@Override
	public void paintComponent(Graphics g) {// 覆盖paintComponent方法,绘图功能
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (width==0 && height==0 && left==0 && top==0) {
			g2.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);// 绘制图片到面板,控制图片
		}else if( (width!=0 || height!=0) && (left==0 && top==0) ){
			g2.drawImage(img,0,0,width,height,null);
		}else {
			g2.drawImage(img,left,top,width,height,null);
		}
	}
	
}
