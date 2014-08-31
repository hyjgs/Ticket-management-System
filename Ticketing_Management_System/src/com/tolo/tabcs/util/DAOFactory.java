package com.tolo.tabcs.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {
	public static Properties props;
	
	public static Object getInstance(Class c){
		try {
			props = new Properties();
			props.load(new FileInputStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String name1=c.getSimpleName();
		String name2= props.getProperty(name1);
		Object obj=null;
		try{
			obj=Class.forName(name2).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String[] args) {
//		UserDao u = (UserDao)DAOFactory.getInstance(UserDao.class);
//		u.go();
	}
	
}
