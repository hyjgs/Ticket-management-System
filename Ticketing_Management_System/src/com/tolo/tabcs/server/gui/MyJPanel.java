package com.tolo.tabcs.server.gui;

import java.awt.*;

import javax.swing.*;

/**
 * 一个自定义的可以生成图像功能的面板
 * @author TangLiang
 */
@SuppressWarnings("serial")
public class MyJPanel extends JPanel {
	private Image img;
	private int width;//设置图片的宽
	private int height;//设置图片的高
	private int left;//距离上层容器左端的距离
	private int top;//距离上层容器的上端的距离

	public MyJPanel(String imgPath) {
		img = new ImageIcon(imgPath).getImage();// 根据图片路径得到Icon，并得到image图片对象
	}

	public MyJPanel(String imgPath,int width,int height) {
		img = new ImageIcon(imgPath).getImage();
		this.width=width;
		this.height=height;
	}
	
	public MyJPanel(String imgPath,int width,int height,int left,int top) {
		img = new ImageIcon(imgPath).getImage();
		this.width=width;
		this.height=height;
		this.left=left;
		this.top=top;
	}
	
	public MyJPanel() {
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
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel panel=new MyJPanel("images/1.jpg",200,200);
		frame.setLocation(200, 200);
		frame.add(panel);
	}
}