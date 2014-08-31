package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.server.dao.SecondBalanceDao;
import com.tolo.tabcs.util.ConnectUtils;

public class SecondBalanceDaoImpl implements SecondBalanceDao{

	public Boolean getResult(int branchId) {
			boolean flag = false;
			String sql = "update business_record_cl set buss_red_account_state = '二级已结算'" +
					"where branch_id =  "+branchId;
			Connection conn = ConnectUtils.getConnection();
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				int n = stmt.executeUpdate(sql);
				if(n > 0)
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				ConnectUtils.close(stmt);
				ConnectUtils.close(conn);
			}
			return flag;
	}
//	public static void main(String[] arg){
//		Boolean a = getResult(1002);
//		System.out.println(a);
//	}
}
