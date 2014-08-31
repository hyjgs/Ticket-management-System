package com.tolo.tabcs.util;
//工具类，负责读入属性文件中的参数(java.io)，1,注册驱动，2,获得连接，3,关闭资源
import java.io.*;
import java.sql.*;
import java.util.*;
/**
 * 操作oracle数据库有关的工具包
 * @author hyj
 *
 */
public class CollectionUtils {
	//把四个参数定义为全局静态变量
	//由getParam方法赋值，给getConnection方法用
	private static String driver;
	private static String url;
	private static String dbUser;
	private static String dbPwd;
	/**
	 * 读入filename中的键值对，根据key给四个全局变量赋值，跟jdbc没关系
	 * @param filename
	 */
	public static void getParam(String filename){
		Properties props = new Properties();
		File file = new File(filename);
		try{
			props.load(new FileInputStream(file));
//			String value = props.getProperty(key);
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			dbUser = props.getProperty("dbUser");
			dbPwd = props.getProperty("dbPwd");		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return 连接对象
	 */
	public static Connection getConnection(){
		Connection conn = null;
		getParam("oracle.properties");
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,dbUser,dbPwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs){
		if(rs !=null)
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	public static void close(Statement stmt){
		if(stmt !=null)
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	public static void close(Connection conn){
		if(conn !=null)
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}

	
}
