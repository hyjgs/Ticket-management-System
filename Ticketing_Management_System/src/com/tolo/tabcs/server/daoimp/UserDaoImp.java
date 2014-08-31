package com.tolo.tabcs.server.daoimp;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.util.CollectionUtils;
import java.sql.*;
import java.util.List;
public class UserDaoImp implements UserDao {
	/**
	 *登录判断
	 * @author hyj
	 *
	 */
	@Override
	public User getUser2(User user) {
		// TODO Auto-generated method stub
//		  if(user.getName().equals("1234")&&user.getPwd().equals("1234"))
//			  return 1;
//			  return 0;
		String name = user.getName();
		String pwd = user.getPwd();
		return userPrivilege(name,pwd);
	}

	 public User userPrivilege(String name,String pwd){
		 User user = new User();
		 String sql = "select * from user_cl where user_login_name ='"+name+"' and user_password='"
				 +pwd+"'";
//		 System.out.println(sql);
		 Connection conn = CollectionUtils.getConnection();
		 Statement stmt = null;
		 ResultSet rs = null;
				 try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()){
						user.setId(rs.getInt("user_id"));
						user.setName(rs.getString("user_login_name"));
						user.setUser_name(rs.getString("user_name"));
						user.setPwd(rs.getString("user_password"));
						user.setRole_id(rs.getInt("role_id"));
						user.setBranch_id(rs.getInt("branch_id"));
						System.out.println("user_role_id = "+ user.getRole_id());
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					CollectionUtils.close(stmt);
					CollectionUtils.close(conn);
					CollectionUtils.close(rs);
				}
		
		 return user;
	 }

	@Override
	public List<User> getUserByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByRoleName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
