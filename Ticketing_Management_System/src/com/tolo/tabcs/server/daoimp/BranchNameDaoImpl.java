package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.server.dao.BranchNameDao;
import com.tolo.tabcs.util.ConnectUtils;

public class BranchNameDaoImpl implements BranchNameDao{

	public  List getBranchName(String cityName) {
		List list = new ArrayList();
		String sql = "select branch_name from branch_cl where" +
				" city_id = (select city_id from city_cl where" +
				" city_name = '"+cityName+"')";
//		System.out.println(sql);
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String branchName = rs.getString("branch_name");
				list.add(branchName);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return list;
	}
	
	/*public static void main(String[] arg){
		getBranchName("北京");
	}*/

}
