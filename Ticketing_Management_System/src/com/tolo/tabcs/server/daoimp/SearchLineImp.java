package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.server.dao.SearchLine;
import com.tolo.tabcs.util.CollectionUtils;

public class SearchLineImp implements SearchLine {
	
	public int[] getRouteId(Route route) {
		String sql = "select route_id from route_cl "
				+ "where from_airport_id in(select airport_id from Airport_cl "
				+ "where city_id =(select city_id from city_cl where city_name = '"
				+ route.getFrom_city_name()+ "'))"
				+"and to_airport_id in (select airport_id from Airport_cl  "
				+ "where city_id =(select city_id from city_cl where city_name ='"
				+ route.getTo_city_name() + "'))";
		System.out.println(sql);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int[] l = new int[]{};
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				l = Arrays.copyOf(l, l.length + 1);
				l[l.length - 1] = rs.getInt("route_id");				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}	
		return l;
	}
	public LinkedList<Route> getAllRoute(Route route) {		
		String sql1 ="select airport_name from airport_cl where airport_id in(select  " 
				  + " from_airport_id from route_cl where route_id="+route.getRoute_id()+")";
		
		String sql2 ="select airport_name from airport_cl where airport_id in(select  " 
			  + " to_airport_id from route_cl where route_id="+route.getRoute_id()+")";
		   
		String sql3="select route_distance from route_cl where route_id="+route.getRoute_id()+"";
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		LinkedList<Route> list = new LinkedList<Route>();
		try {
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) {
				String s1 = rs1.getString("airport_name");
				System.out.println(s1);
				route.setFrom_airport_name(s1);
			}
			rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				String s2 = rs2.getString("airport_name");
				System.out.println(s2);
				route.setTo_airport_name(s2);
			}
			rs3 = stmt.executeQuery(sql3);
			while (rs3.next()) {
				int s3= rs3.getInt("route_distance");
				System.out.println(s3);
				route.setRoute_distance(s3);
			}
			
			route.setRoute_id(route.getRoute_id());	
			System.out.println(route.getRoute_id());
			list.add(route);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs1);
			CollectionUtils.close(rs2);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return list;
	}
	
}
/*	public int[] getIdDistance(Route route) {
		String sql = "select route_id,route_distance from route_cl "
				+ "where from_airport_id in(select airport_id from Airport_cl "
				+ "where city_id =(select city_id from city_cl where city_name = '"
				+ route.getFrom_city_name()
				+ "'))"
				+ "and to_airport_id in (select airport_id from Airport_cl  "
				+ "where city_id =(select city_id from city_cl where city_name ='"
				+ route.getTo_city_name() + "'))";
		System.out.println(sql);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int[] a = new int[] {};
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				a = Arrays.copyOf(a, a.length + 1);
				a[a.length - 1] = rs.getInt("route_id");
				a = Arrays.copyOf(a, a.length + 1);
				a[a.length - 1] = rs.getInt("route_distance");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return a;
	}

	public LinkedList<Route> getFromName(Route route) {
		int[] a = getIdDistance(route);
		String sql1 = "select d.airport_full_name dname1 from city_cl e join airport_cl d on e.city_id = d.city_id  "
				+ "  where d.airport_id = (select from_airport_id from route_cl where route_id = "
				+ a[0] + ")";
		String sql2 = "select d.airport_full_name dname2 from city_cl e join airport_cl d on e.city_id = d.city_id  "
				+ "  where d.airport_id = (select to_airport_id from route_cl where route_id ="
				+ a[0] + " )";
		System.out.println(sql1);
		System.out.println(sql2);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String[] str1 = new String[100];
		String[] str2 = new String[100];

		LinkedList<Route> list = new LinkedList<Route>();
		try {
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sql1);
			
			while (rs1.next()) {
				str1[0] = rs1.getString("dname1");
				System.out.println(str1[0]);
			}
			rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				str2[0] = rs2.getString("dname2");
				System.out.println(str2[0]);
			}
			route.setRoute_id(a[0]);
			route.setRoute_distance(a[1]);
			route.setFrom_airport_name(str1[0]);
			route.setTo_airport_name(str2[0]);
			list.add(route);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs1);
			CollectionUtils.close(rs2);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return list;
	}

}*/

/*
 * 
 * @Override public LinkedList<Route> ctcData(String fromPlace, String toPlace)
 * { // TODO Auto-generated method stub return null; }
 * 
 * @Override public List<Route> getRes(cityToCity ctc) { // TODO Auto-generated
 * method stub return null; }
 * 
 * 
 * }
 * 
 * @Override public LinkedList getRes(cityToCity ctc) { String fromPlace =
 * ctc.getFrom(); String toPlace = ctc.getTo(); System.out.println(fromPlace);
 * System.out.println(toPlace); return ctcData(fromPlace,toPlace); }
 * 
 * public LinkedList ctcData(String fromPlace, String toPlace) {
 * //根据出发地城市和目的地城市来查询汉：航班编号和航程 String sql
 * ="select route_id,route_distance from route_cl"
 * +"where from_airport_id = (select airport_id from Airport_cl"
 * +"where city_id =(select city_id from city_cl where city_name = '"
 * +fromPlace+"'))"+ "and to_airport_id in (select airport_id from Airport_cl"+
 * "where city_id =(select city_id from city_cl where city_name ='"
 * +toPlace+"'))"; // String sql="select route_id,route_distance from route_cl "
 * +"where from_airport_id = (select airport_id from Airport_cl "
 * +"where city_id =(select city_id from city_cl where city_name = '"
 * +fromPlace+"'))" +"and to_airport_id in (select airport_id from Airport_cl "
 * +
 * "where city_id =(select city_id from city_cl where city_name = '"+toPlace+"'))"
 * ; System.out.println(sql); Stringsql1=
 * "select airport_full_name from airport_cl where city_id =( select city_id from City_cl "
 * +" where city_name='"+fromPlace+"')"; Stringsql2=
 * "select airport_full_name from airport_cl where city_id =( select city_id from City_cl "
 * +" where city_name='"+toPlace+"')"; System.out.println(sql1);
 * System.out.println(sql2); LinkedList list = new LinkedList(); Connection conn
 * =CollectionUtils.getConnection(); Statement stmt = null; ResultSet rs = null;
 * ResultSet rs1=null; ResultSet rs2=null; try { stmt = conn.createStatement();
 * rs=stmt.executeQuery(sql); //rs1=stmt.executeQuery(sql1);
 * //rs2=stmt.executeQuery(sql2); while(rs.next()){ int a=rs.getInt("route_id");
 * list.add(a); int b=rs.getInt("route_distance"); list.add(b); }
 * while(rs1.next()){ String airport_name = rs1.getString("airport_full_name");
 * list.add(airport_name); } while(rs2.next()){ String airport_name =
 * rs2.getString("airport_full_name"); list.add(airport_name); } } catch
 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace();
 * }finally{ CollectionUtils.close(rs); //CollectionUtils.close(rs1); //
 * CollectionUtils.close(rs2); // CollectionUtils.close(stmt);
 * CollectionUtils.close(conn); } return list; }
 * 
 * 
 * }
 */
