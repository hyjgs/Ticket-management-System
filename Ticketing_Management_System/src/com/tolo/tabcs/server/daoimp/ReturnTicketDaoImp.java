package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.common.entity.Airport;
import com.tolo.tabcs.server.dao.ReturnTicketDao;
import com.tolo.tabcs.util.CollectionUtils;

public class ReturnTicketDaoImp  implements ReturnTicketDao{
   //String[] str 里面只放了2个数据，一个是
	// 营业员的Id，另外一个是该乘客的证件号码
	public int getBranchId(String[] str){
		
		int userId=Integer.valueOf(str[0]);
		String sql = "select branch_id from user_cl where user_id="+userId+"";
    System.out.println(sql);
	Connection conn =CollectionUtils.getConnection();
	Statement stmt = null;
	ResultSet rs1 = null;
		int a = 0;
	 try {
		stmt =conn.createStatement();
		rs1=stmt.executeQuery(sql);
		while(rs1.next())
		a= rs1.getInt("branch_id");

	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally{
		CollectionUtils.close(rs1);
	
		CollectionUtils.close(stmt);
		CollectionUtils.close(conn);
	}
		
		
		return a;
	}
	
	
	public boolean insertBusRec(String[] str){
		//int userId=Integer.valueOf(str[0]);
		int branchId = getBranchId(str);
		System.out.println(branchId);
		int userId=Integer.valueOf(str[0]);
		
		String sql1 ="insert into business_record_cl values(buss_red_num.nextval,sysdate,"+
				"  "+userId+","+branchId+",-1470,'申请一级结算','退票')";	
		
		String sql2 ="delete Tickets_cl where psg_id=(select psg_id" +
				"   from passenger_cl where psg_certif_num='"+str[1]+"')";	

		System.out.println(sql1);
		System.out.println(sql2);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sql1);
			rs2 = stmt.executeQuery(sql2);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs1);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return true;

	
	}
}
