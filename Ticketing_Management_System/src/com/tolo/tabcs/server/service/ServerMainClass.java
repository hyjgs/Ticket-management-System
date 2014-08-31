package com.tolo.tabcs.server.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * 两用服务器类
 * @author TangLiang
 */
public class ServerMainClass {//服务器端主类
	private ServerSocket ss_business;//接收营业请求的ServerSocket
	private ServerSocket ss_manager;//接收管理请求的ServerSocket
	
	public static Controller controller;//控制器，处理一系列的业务请求
	public static  Map<Integer,Long> onlineUsers; //统计和记录在线用户sessionId
	
	private Properties pro;
	
	static{
		controller=new Controller();
		onlineUsers=new Hashtable<Integer,Long>();
	}
	
	public ServerMainClass(){
		pro=new Properties();
		loadProperties();
	}
	
	private void loadProperties(){
		try {
			pro.load(new FileInputStream("server.cfg"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startService(){//开始服务器
		if(pro.getProperty("ManagerService").equals("ON")){//如果是管理，则启动管理服务器
			startManagerService();
		}
		if(pro.getProperty("BusinessService").equals("ON")){//如果是营业，则启动营业服务器
			startBusinessService();
		}
	}
	
	/**
	 * 该方法用于启动服务器端服务。
	 *
	 */
	public void startManagerService(){
		try {
			int port=Integer.parseInt(pro.getProperty("ManagerServicePort"));
			ss_manager=new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(true){
			try {
				Socket s = ss_manager.accept();
				new ServerThread(s).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startBusinessService(){
		try {
			int port=Integer.parseInt(pro.getProperty("BusinessServicePort"));
			ss_business=new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		
		}
		while(true){
			try {
				Socket s = ss_business.accept();
				new ServerThread(s).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(){
		try {
			ss_business.close();
			ss_manager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerMainClass().startService();
	}
}
