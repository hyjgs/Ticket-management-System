package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.util.ConnectUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUserByID(User user) {
		int user_id = user.getId();
		String user_name = null;
		String user_role_name = null;
		String sql = "select u.user_id user_id,u.user_name user_name," +
				"u.temp_privilege temp_privilege,u.user_telephone user_telephone,	" +
				"r.role_name role_name , b.branch_name branch_name, c.city_name city_name, " +
				"p.province_name province_name " +
				"from user_cl u	" +
				"join branch_cl b on u.branch_id = b.branch_id		" +
				"join city_cl c on b.city_id = c.city_id 		" +
				"join province_cl p on b.province_id = p.province_id		" +
				"join role_cl r on u.role_id = r.role_id		"			+
				"where u.user_id  = " + user_id ;
		
//		System.out.println(sql);
		List<User> list = new ArrayList<User>();
		String user_telephone = null;
		String user_branch_name = null;
		//String temp_privilege = null;
		String user_city_name = null;
		String user_privince_name = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()){
			User getUser = new User();
			user_id = rs.getInt("user_id");
			user_name = rs.getString("user_name");
			user_role_name = rs.getString("role_name");
		//	temp_privilege = rs.getString("temp_privilege");
			user_branch_name = rs.getString("branch_name");
			user_telephone = rs.getString("user_telephone");
			user_city_name = rs.getString("city_name");
			user_privince_name = rs.getString("province_name");
			getUser.setId(user_id);
			getUser.setName(user_name);
			getUser.setRole_name(user_role_name);
			//getUser.setTemp_privilege(temp_privilege);
			getUser.setBranch_name(user_branch_name);
			getUser.setUser_telephone(user_telephone);
			getUser.setCity_name(user_city_name);
			getUser.setPrivince_name(user_privince_name);
			list.add(getUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
	return list;
	}

	@Override
	public List<User> getUserByName(User user) {

		int user_id = 0;
		String user_name = user.getName();
		String user_role_name = null;
	//	System.out.println(user_name);
		String sql = "select u.user_id user_id,u.user_name user_name," +
		"u.temp_privilege temp_privilege,u.user_telephone user_telephone,	" +
		"r.role_name role_name , b.branch_name branch_name, c.city_name city_name, " +
		"p.province_name province_name " +
		"from user_cl u	" +
		"join branch_cl b on u.branch_id = b.branch_id		" +
		"join city_cl c on b.city_id = c.city_id 		" +
		"join province_cl p on b.province_id = p.province_id		" +
		"join role_cl r on u.role_id = r.role_id		"			+
		"where u.user_name  = " + "'"+user_name+"'" ;
		List<User> list = new ArrayList<User>();
		String user_telephone = null;
		String user_branch_name = null;
		String user_city_name = null;
		String user_privince_name = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
					
			while (rs.next()){
			User getUser = new User();
			user_id = rs.getInt("user_id");
			user_name = rs.getString("user_name");
			user_role_name = rs.getString("role_name");
			user_branch_name = rs.getString("branch_name");
			user_telephone = rs.getString("user_telephone");
			user_city_name = rs.getString("city_name");
			user_privince_name = rs.getString("province_name");
			getUser.setId(user_id);
			getUser.setName(user_name);
			getUser.setRole_name(user_role_name);
			getUser.setBranch_name(user_branch_name);
			getUser.setUser_telephone(user_telephone);
			getUser.setCity_name(user_city_name);
			getUser.setPrivince_name(user_privince_name);
			list.add(getUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
	return list;
	}

	
	@Override
	public List<User> getUserByRoleName(User user) {
		int user_id = 0;
		String user_name = null;
		String user_role_name = user.getRole_name();
		String sql =  "select u.user_id user_id,u.user_name user_name," +
		"u.temp_privilege temp_privilege,u.user_telephone user_telephone,	" +
		"r.role_name role_name , b.branch_name branch_name, c.city_name city_name, " +
		"p.province_name province_name " +
		"from user_cl u	" +
		"join branch_cl b on u.branch_id = b.branch_id		" +
		"join city_cl c on b.city_id = c.city_id 		" +
		"join province_cl p on b.province_id = p.province_id		" +
		"join role_cl r on u.role_id = r.role_id		"			+
		"where r.role_name  = " + "'"+user_role_name+"'" ;
		
//		System.out.println(sql);
		List<User> list = new ArrayList<User>();
		String user_telephone = null;
		String user_branch_name = null;
	//	String temp_privilege = null;
		String user_city_name = null;
		String user_privince_name = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()){
			User getUser = new User();
			user_id = rs.getInt("user_id");
			user_name = rs.getString("user_name");
			user_role_name = rs.getString("role_name");
			user_branch_name = rs.getString("branch_name");
			user_telephone = rs.getString("user_telephone");
			user_city_name = rs.getString("city_name");
			user_privince_name = rs.getString("province_name");
			getUser.setId(user_id);
			getUser.setName(user_name);
			getUser.setRole_name(user_role_name);
			getUser.setBranch_name(user_branch_name);
			getUser.setUser_telephone(user_telephone);
			getUser.setCity_name(user_city_name);
			getUser.setPrivince_name(user_privince_name);
			list.add(getUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
	return list;
	}

	
	@Override
	public boolean removeUser(User user) {
		boolean flag = false;
		int id = user.getId();
		System.out.println(id);
		String sql = "delete from user_cl where user_id = "+id;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectUtils.getConnection();
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n == 1){
				flag = true;
			}
		} catch (Exception e) {
			
		}
		return flag;
	}

	@Override
	public User getUser2(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
