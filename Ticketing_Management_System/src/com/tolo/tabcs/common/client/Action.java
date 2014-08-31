package com.tolo.tabcs.common.client;

import java.io.*;
import java.net.*;
import java.util.Properties;
import com.tolo.tabcs.common.pro.*;
/**
 * 客户端的各种行为处理
 * @author hyj
 *
 */

public class Action {
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos; 
	private Properties pro;//读取配置文件专用的MAP
	
	public Action(){
		pro=new Properties();
		loadProperties();//读取配置文件
	}

	/**
	 * 该方法用于封装请求发送给服务器，等待接受服务器端处理后的应答并返回。
	 * @param req
	 * @return
	 */
	public Response doAction(Request req){
		createSocket();
		/**
		 * 发送请求
		 */
		try {
			oos.writeObject(req);//写出请求
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * 得到应答
		 */
		Response res=null;
		try {
			res=(Response)ois.readObject();//得到回复
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		closeSocket();//关闭该socket
		return res;
	}
	
	/**
	 * 加载客户端配置参数的方法.
	 *
	 */
	private void loadProperties(){
		try {
			pro.load(new FileInputStream("client.cfg"));//从client.cfg脚本中读取端口和IP
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建连接的方法，该方法将在doAction方法中调用。
	 */
	private void createSocket(){
		try {
			s=new Socket(pro.getProperty("ServerIP"),Integer.parseInt(pro.getProperty("ServerPort")));
			oos=new ObjectOutputStream(s.getOutputStream());//制造输出流
			ois=new ObjectInputStream(s.getInputStream());//制造输入流
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接的方法，该方法将在doAction方法中调用。
	 *
	 */
	private void closeSocket(){
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
