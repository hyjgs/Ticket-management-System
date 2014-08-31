package com.tolo.tabcs.server.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
/**
 * @author TangLiang
 */
public class ServerThread extends Thread{//服务器端服务线程类
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ServerThread(Socket s){
		try {
			ois=new ObjectInputStream(s.getInputStream());
			oos=new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void run(){
		try {
			Request req=(Request)ois.readObject();//读取请求
			Response res=ServerMainClass.controller.execute(req);
			oos.writeObject(res);//写出回复
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
