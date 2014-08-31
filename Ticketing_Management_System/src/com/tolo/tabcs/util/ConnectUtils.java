package com.tolo.tabcs.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 工具类,负责读入属性文件中的参数*java.io),
 * 注册驱动,获得连接,关闭资源
 * 
 * */
public class ConnectUtils {
	//静态变量定义四个参数
	//由getParam方赋值,给getConnection方法使用
	private static String driver;
	private static String url;
	private static String dbUser;
	private static String dbPassword;
	
	/**
	 * 读入filenames中的键值对,根据key给四个全局变量赋值
	 */
	@SuppressWarnings("unchecked")
	public static void getParam(String fileName){
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(fileName));
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
				driver = list.get(0).elementText("driver_class");
				url = list.get(0).elementText("url");
				dbUser = list.get(0).elementText("dbuser");
				dbPassword = list.get(0).elementText("dbpassword");
//				System.out.println(e.elementText("driver_class"));
//				System.out.println(e.elementText("url"));
//				System.out.println(e.elementText("dbuser"));
//				System.out.println(e.elementText("dbpassword"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据四个静态变量参数构造连接对象并返回
	 * @return 连接对象
	 */
	public static Connection getConnection(){
		Connection conn = null;
		//给四个全局变量赋值
//		String sql = "select * from route_cl ";
//		Statement stmt = null;
//		ResultSet rs = null;
		getParam("jbconfig.xml");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbUser, dbPassword);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while(rs.next()){
//				System.out.println(rs.getInt("route_id"));
//				System.out.println(rs.getInt("from_airport_id"));
//				System.out.println(rs.getInt("to_airport_id"));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public static void main(String[] args) {
////		getParam("jbconfig.xml");
//		getConnection();
//	}
	
}
