package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.server.dao.RemoveAirline;
import com.tolo.tabcs.util.CollectionUtils;

public class RemoveAirlineImp implements RemoveAirline{
	  public String removeAirline(int n){
		   String sql = "delete Route_cl where route_id ="+n+"";
		   System.out.println(sql);
			Connection conn =CollectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs1 = null;
				
			 try {
				stmt =conn.createStatement();
				rs1=stmt.executeQuery(sql);
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
