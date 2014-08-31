package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tolo.tabcs.server.dao.ManagerDao;
import com.tolo.tabcs.util.CollectionUtils;

public class ManagerDaoImp implements ManagerDao {

	@Override
	public ArrayList<Integer> managerAll() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		 String sql = "select user_id from user_cl where role_id=2";
// System.out.println(sql);
 Connection conn = CollectionUtils.getConnection();
 Statement stmt = null;
 ResultSet rs = null;
		 try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			 list.add(rs.getInt("user_id"));
				}
			System.out.println(list.get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
			CollectionUtils.close(rs);
		}

		
		return list;
	}

}
