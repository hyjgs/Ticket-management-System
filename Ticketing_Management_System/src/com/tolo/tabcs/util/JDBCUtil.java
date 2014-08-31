package com.tolo.tabcs.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JDBCUtil {
//连接池代码begin----------------------------------------
	private static List<Connection> pool = new ArrayList<Connection>();
	public static final int MAX_CONNECTIONS = 10;

	/**
	 * 静态代码块。连接池，容量是10个,用集合保存Connections，首先添加10个
	 */
	static {
		for (int i = 0; i < MAX_CONNECTIONS; i++) {
			try {
				pool.add(getConnection("MYSQL"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 得到连接池里的连接
	 */
	public static Connection getConnection() {
		if (pool.size() > 0) {
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		} else {
			return null;
		}
	}
	/**
	 * 还回连接
	 */
	public static void releaseConnection(Connection conn) {
		pool.add(conn);
	}
//连接池代码over----------------------------------------------------
	
	public static Connection getConnection(String databaseName)
			throws Exception {
		String driverClass = null;
		String url = null;
		String userName = null;
		String password = null;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File("jdbc_config.xml"));
		Element root = doc.getDocumentElement();
		NodeList list = root.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) n;
				if (ele.getAttribute("name").equals(databaseName)) {
					NodeList eList = ele.getChildNodes();
					for (int j = 0; j < eList.getLength(); j++) {
						Node nTemp = eList.item(j);
						if (nTemp.getNodeType() == Node.ELEMENT_NODE) {
							Element eTemp = (Element) nTemp;
							if (eTemp.getTagName().equals("driver_class")) {
								driverClass = eTemp.getTextContent().trim();
							} else if (eTemp.getTagName().equals("url")) {
								url = eTemp.getTextContent().trim();
							} else if (eTemp.getTagName().equals("user_name")) {
								userName = eTemp.getTextContent().trim();
							} else if (eTemp.getTagName().equals("password")) {
								password = eTemp.getTextContent().trim();
							}
						}
					}
				}
			}// outer if
		}// outer for end!
		// JDBC connect to SQL
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url+"?useUnicode=true&characterEncoding=utf8", userName, password);
		return conn;
	}// method end!

	public static void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = null;
		rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println();
		for (int i = 0; i < rsmd.getColumnCount() * 8; i++) {
			System.out.print("-");
		}
		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				int type = rsmd.getColumnType(i);
				String str = "";
				switch (type) {
				case Types.SMALLINT:
				case Types.NUMERIC:
				case Types.INTEGER:
					str = str + rs.getInt(i);
					break;
				case Types.BIGINT:
					str = str + rs.getLong(i);
					break;
				case Types.DOUBLE:
				case Types.FLOAT:
				case Types.DECIMAL:
					str = str + rs.getDouble(i);
					break;
				case Types.CHAR:
				case Types.VARCHAR:
					str = rs.getString(i);
					break;
				case Types.DATE:
					str = str + rs.getDate(i);
					break;
				}
				System.out.print(str + "\t");
			}
			System.out.println();
		}
	}
}// class end!
