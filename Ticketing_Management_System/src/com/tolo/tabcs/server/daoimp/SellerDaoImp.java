package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.entity.Seller;
import com.tolo.tabcs.server.dao.SellerDao;
import com.tolo.tabcs.util.CollectionUtils;
/**
 * 营业员的查询操作
 * @author hyj
 *
 */
public class SellerDaoImp implements SellerDao{
	public Seller getSeller(int user_id){
		Seller seller = new Seller();
		String sql = "select * from user_cl where user_id = "+user_id;

		 Connection conn = CollectionUtils.getConnection();
		 Statement stmt = null;
		 ResultSet rs = null;
		 ResultSet rs1 = null;
		 try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					seller.setUser_id(user_id);
					seller.setName(rs.getString("user_name"));
					seller.setTelephone(rs.getString("user_telephone"));
					seller.setBranch_id(rs.getInt("branch_id"));
				}
				String sql1 = "select * from finished_branch_hyj where branch_id = "+seller.getBranch_id();
				rs1 = stmt.executeQuery(sql1);
				if(rs1.next()){
					seller.setBranch_name(rs1.getString("branch_name"));
					seller.setBranch_address(rs1.getString("branch_address"));
					seller.setCity(rs1.getString("city_name"));
					seller.setProvince(rs1.getString("province_name"));
					seller.setManager_id(rs1.getInt("user_id"));
					System.out.println("the manager id is "+ seller.getManager_id());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				CollectionUtils.close(stmt);
				CollectionUtils.close(conn);
				CollectionUtils.close(rs);
			}
		return seller;
	}

}
