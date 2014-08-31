package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.server.dao.ChangeTicketDao;
import com.tolo.tabcs.util.CollectionUtils;

public class ChangeTicketDaoImp implements ChangeTicketDao{
 //String[] str 里面只放了4个数据，一个是
	// 营业员的Id，另外一个是该乘客的证件号码
//	str[0] =psgName;
	//str[1]=date;
	//str[3] =userId;	
	public int getBranchId(String[] str){
		
		int userId=Integer.valueOf(str[3]);
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
		int userId=Integer.valueOf(str[3]);
		int price = Integer.parseInt(str[4]);
		
		String sql1 ="insert into business_record_cl values(buss_red_num.nextval,sysdate,"+
				"  "+userId+","+branchId+","+price+",'申请一级结算','改签')";	
		
		/*String sql2 ="delete Tickets_cl where psg_id=(select psg_id" +
				"   from passenger_cl where psg_certif_num='"+str[1]+"')";*/	
		
      String sql2 ="update Tickets_cl set sta_fly_date= to_date('"+str[1]+"','yyyy-mm-dd')" +
      		"   where psg_name='"+str[0]+"'";
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
