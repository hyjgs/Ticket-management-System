package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tolo.tabcs.server.dao.BranchName1Dao;
import com.tolo.tabcs.util.ConnectUtils;

public class BranchName1DaoImpl implements BranchName1Dao{

	
	public  String[] getBranchName() {
//		System.out.println("to the name");
		String[] branchName = new String[]{"所有"};
		String sql = "select branch_name from branch_cl";
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String branchName1 = rs.getString("branch_name");
				branchName = Arrays.copyOf(branchName, branchName.length+1);
				branchName[branchName.length-1] = branchName1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return branchName;
	}
	
//	public static void main(String[] arg){
//		String[] a = getBranchName();
//		System.out.println(Arrays.toString(a));
//	}
	
}
