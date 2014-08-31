package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tolo.tabcs.server.dao.UserNameDao;
import com.tolo.tabcs.util.ConnectUtils;

public class UserNameDaoImpl implements UserNameDao{

	@Override
	public List getUserName(String branchName) {
		List list = new ArrayList();
		String sql = "select user_name from user_cl where " +
				"branch_id = (select branch_id from branch_cl where branch_name = '" +
				branchName+"')";
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String userName = rs.getString("user_name");
				list.add(userName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return list;
	}

}
