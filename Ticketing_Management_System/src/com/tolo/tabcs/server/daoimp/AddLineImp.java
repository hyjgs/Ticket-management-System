package com.tolo.tabcs.server.daoimp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.server.dao.AddLine;
import com.tolo.tabcs.util.CollectionUtils;

public class AddLineImp implements AddLine {

	public int[] getAirportId(Route route){
		String sql1 ="select airport_id from airport_cl " +
				"  where airport_full_name='"+route.getFrom_airport_name()+"'";
		String sql2 ="select airport_id from airport_cl " +
		"  where airport_full_name='"+route.getTo_airport_name()+"'";	
		System.out.println(sql1);
		System.out.println(sql2);
		int[] a = new int[50];	
		Connection conn =CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		 try {
			stmt =conn.createStatement();
			rs1=stmt.executeQuery(sql1);
			while(rs1.next()){
				a[0]=rs1.getInt("airport_id");
				
			}
			rs2=stmt.executeQuery(sql2);
			while(rs2.next()){
				a[1]=rs2.getInt("airport_id");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			CollectionUtils.close(rs1);
			CollectionUtils.close(rs2);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		 
		
		return a;
	}
	
	
	public String insertLine(Route route){
		int[] a =getAirportId(route);
		System.out.println(a[0]);
		System.out.println(a[1]);
		String sql1 = "insert into Route_cl(route_id,from_airport_id,to_airport_id,route_distance) " +
				"values("+route.getRoute_id()+","+a[0]+","+a[1]+","+route.getRoute_distance()+")";
		System.out.println(sql1);
		Connection conn =CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
			
		 try {
			stmt =conn.createStatement();
			rs1=stmt.executeQuery(sql1);
			System.out.println("====成功插入");
		
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
