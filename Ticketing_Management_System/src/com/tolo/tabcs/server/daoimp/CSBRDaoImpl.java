package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.server.dao.CSBRDao;
import com.tolo.tabcs.util.ConnectUtils;
/**
 * 客户端传来查询所有申请二级结算记录请求
  * @author hyj
 */


public  class CSBRDaoImpl implements CSBRDao{
	
	@Override
	public List getCSBR(){
		List list4 = new ArrayList();
		String sql = "select b.branch_name branch_name,r.branch_id branch_id," +
		" r.user_id user_id,count(*) count ,sum(buss_red_price) price" +
		" from business_record_cl r join branch_cl b on r.branch_id = b.branch_id" +
		" and buss_red_account_state = '申请二级结算' group by b.branch_name,r.branch_id,r.user_id";
//		System.out.println(sql);
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int branchId = rs.getInt("branch_id");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				String branchName = rs.getString("branch_name");
				int userId = rs.getInt("user_id");
				Branch branch1 = new Branch();
				branch1.setBranch_id(branchId);
				branch1.setPrice(price);
				branch1.setCount(count);
				branch1.setBranch_name(branchName);
				branch1.setUser_id(userId);
				list4.add(branch1);
				
			}
//			System.out.println(list4+"list4");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
	return list4;
	
	}
	/**
	 * 根据网点名称查询营业记录
	 * @param branch网点名称
	 * @return list  
	 * */
	@Override
	public List getCSBR_branch(String branch) {
		List list1 = new ArrayList();
		String sql = "select b.branch_name ,r.branch_id,r.user_id,count(*) count,sum(buss_red_price) price"+
		 " from business_record_cl r join branch_cl b on r.branch_id = b.branch_id"+
		 " where branch_name = '"+branch+"' and buss_red_account_state = '申请二级结算' group by b.branch_name,r.branch_id,r.user_id ";
//		System.out.println(sql);
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int branchId = rs.getInt("branch_id");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				String branchName = rs.getString("branch_name");
				int userId = rs.getInt("user_id");
				Branch branch1 = new Branch();
				branch1.setBranch_id(branchId);
				branch1.setPrice(price);
				branch1.setCount(count);
				branch1.setBranch_name(branchName);
				branch1.setUser_id(userId);
				list1.add(branch1);				
			}
//			System.out.println("list1"+list1);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		
		return list1;
	}
	/**
	 * 根据城市名称查询营业记录
	 * @param city城市名称
	 * @return list  
	 * */
	@Override
	public List getCSBR_city(String city) {
		List list2 = new ArrayList();
		String sql = "select d.branch_id,d.branch_name,t.user_id ,count(e.branch_id)count,sum(e.buss_red_price) price"+
		 " from business_record_cl e join Branch_cl d on e.branch_id = d.branch_id"+
		 " join user_cl t on t.user_id = e.user_id where d.city_id = "+
		 " (select city_id from city_cl where city_name ='"+city+"') and t.role_id = 2 and buss_red_account_state = '申请二级结算' group by d.branch_id,d.branch_name,t.user_id";
//		System.out.println(sql);
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int branchId = rs.getInt("branch_id");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				String branchName = rs.getString("branch_name");
				int userId = rs.getInt("user_id");
				Branch branch1 = new Branch();
				branch1.setBranch_id(branchId);
				branch1.setPrice(price);
				branch1.setCount(count);
				branch1.setBranch_name(branchName);
				branch1.setUser_id(userId);
				list2.add(branch1);				
			}
//			System.out.println("list2"+list2);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		
		return list2;
	}
	/**
	 * 根据省份名称查询营业记录
	 * @param province城市名称
	 * @return list  
	 * */

	@Override
	public List getCSBR_province(String province) {
		List list3 = new ArrayList();
		String sql = "select d.branch_id,d.branch_name,t.user_id ,count(e.branch_id)count ,sum(e.buss_red_price)price"+
		 " from business_record_cl e join Branch_cl d on e.branch_id = d.branch_id"+
		 " join user_cl t on t.user_id = e.user_id where d.province_id = "+
		 "(select province_id from province_cl where province_name ='"+province+"')  and t.role_id = 2 "+
		 " and buss_red_account_state = '申请二级结算' group by d.branch_id,d.branch_name,t.user_id";
//		System.out.println(sql);
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int branchId = rs.getInt("branch_id");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				String branchName = rs.getString("branch_name");
				int userId = rs.getInt("user_id");
				Branch branch1 = new Branch();
				branch1.setBranch_id(branchId);
				branch1.setPrice(price);
				branch1.setCount(count);
				branch1.setBranch_name(branchName);
				branch1.setUser_id(userId);
				list3.add(branch1);				
			}
//			System.out.println("list3"+list3);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		
		return list3;
		
	}
}
