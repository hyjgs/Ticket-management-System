package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.server.dao.RoleDao;
import com.tolo.tabcs.util.ConnectUtils;

public class RoleDaoImpl implements RoleDao{

	@Override
	public List<Role> searchAllRole() {
		String sql = "select * from role_cl";
	List<Role> list = new ArrayList<Role>();
	int role_id = 0;
	String role_name = null;
	int role_privilege = 0;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		conn = ConnectUtils.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()){
		Role getRole = new Role();
		role_id = rs.getInt("role_id");
		role_name = rs.getString("role_name");
		role_privilege = rs.getInt("role_privilege");
		getRole.setId(role_id);
		getRole.setName(role_name);
		getRole.setRole_privilege(role_privilege);
		list.add(getRole);
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
	public boolean addRole(Role role) {
		boolean flag = false;
		String newRoleName = role.getName();
		int newRolePrivilege = role.getRole_privilege();
		String sql = "insert into role_cl " +
				"values(myrole.nextval, " + "'"+newRoleName+"'"+","+ newRolePrivilege+")";
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
	public boolean delRole(Role role) {
		boolean flag = false;
		String RoleName = role.getName();
		System.out.println(RoleName);
		String sql = "delete from role_cl where role_name = " + "'"+RoleName+"'";
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
	public boolean updateRole(Role role) {
		boolean flag = false;
		String RoleName = role.getName();
		int RolePrivilege = role.getRole_privilege();
		System.out.println(RoleName);
		String sql = "update role_cl set role_privilege = "+RolePrivilege+
		" where role_name = " +"'"+RoleName+"'";
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
}
