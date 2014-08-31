package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.common.entity.Airport;
import com.tolo.tabcs.server.dao.AddAirport;
import com.tolo.tabcs.util.CollectionUtils;

public class AddAirportImp implements AddAirport {

	public int[] getProviceIdCityId(Airport airport) {
		String sql1 = "select province_id p from province_cl where province_name='"+airport.getProvince_name()+"'";
		String sql2 = "select city_id c from city_cl where city_name='"+airport.getCity_name()+"'";
		System.out.println(sql1);
		System.out.println(sql2);
		int[] a = new int[100];
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) {
				a[0] = rs1.getInt("p");

			}
			rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				a[1] = rs2.getInt("c");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs1);
			CollectionUtils.close(rs2);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}

		return a;
	}
	
	
	public String addAirport(Airport airport){
		int[] a =getProviceIdCityId(airport);
		System.out.println(a[0]);
		System.out.println(a[1]);
		String sql1 = "insert into airport_cl(airport_id,airport_name,airport_full_name,city_id," +
				"province_id,airport_code) values(airportNum.nextval," +
						"'"+airport.getAirport_name()+"','"+airport.getAirport_full_name()+"',"+a[1]+","+a[0]+"  " +
								",'"+airport.getAirport_code()+"')";
			
		System.out.println(sql1);  
		Connection conn =CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
			
		 try {
			stmt =conn.createStatement();
			rs1=stmt.executeQuery(sql1);
			System.out.println("====成功插入新机场");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			CollectionUtils.close(rs1);
		
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		
		return "ok";
	}
	
}
