package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tolo.tabcs.server.dao.RouteDao;
import com.tolo.tabcs.util.ConnectUtils;

public class RouteDaoImpl implements RouteDao{
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ResultSet rs2 = null;
	private String[] str = new String[]{};
	private Integer[] routes = new Integer[]{};
	public RouteDaoImpl(){
//		System.out.println(Arrays.toString(findPlaceByRouteId(100006)));
//		System.out.println(Arrays.toString(searchAllRouteId()));
	}
	@Override
	public String[] findPlaceByRouteId(int routeId) {
		conn = ConnectUtils.getConnection();
		String sql = "select e.city_name from city_cl e join airport_cl d on e.city_id = d.city_id where d.airport_id = (select from_airport_id from route_cl where route_id ="+routeId+ ")";
		String sql1 = "select e.city_name from city_cl e join airport_cl d on e.city_id = d.city_id"+
        " where d.airport_id = (select to_airport_id from route_cl where route_id = "+routeId+ ")";
		try {
			str = Arrays.copyOf(str, str.length+1);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				str[str.length-1]=rs.getString("city_name");
			}
			rs2 = stmt.executeQuery(sql1);
			str = Arrays.copyOf(str, str.length+1);
			if(rs2.next()){
				str[str.length-1] = rs2.getString("city_name");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	@Override
	public Integer[] searchAllRouteId() {
		conn = ConnectUtils.getConnection();
		String sql ="select route_id from route_cl";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				routes = Arrays.copyOf(routes, routes.length+1);
				routes[routes.length-1]= new Integer(rs.getInt("route_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return routes;
	}
	@Override
	public int findOilFuel(int flightairline) {
		
		conn = ConnectUtils.getConnection();
		String sql ="select oil_tax from route_cl where Route_id="+flightairline;
		int oil_tax = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				oil_tax = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return oil_tax;
	}
	
//	public static void main(String[] args) {
//		new RouteDaoImpl();
//	}
	
}
