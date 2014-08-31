package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tolo.tabcs.common.entity.BusinessRecord;
import com.tolo.tabcs.server.dao.SearchResultDao;
import com.tolo.tabcs.util.ConnectUtils;
/**
 * 查找各网点的营业记录
 * @author hyj
 *
 */
public class SearchResultDaoImpl implements SearchResultDao{
	/**
	 * 根据条件查询各网点的营业记录
	 * @param message 从客户端传来的条件数组
	 * 
	 * */
	@Override
	public List getResult(String[] message) {
//		System.out.println(Arrays.toString(message));
		String branch_name = message[0];
		String user_name = message[1];
		String fromDate = message[2];
		String toDate = message[3];
		String type = message[4];
		String state = message[5];
		List list = new ArrayList();
		String sql = "select e.*,d.user_name,f.branch_name from business_record_cl e join user_cl d on e.user_id =d.user_id " +
				"join branch_cl f on f.branch_id= e.branch_id where buss_red_date between to_date('" +
				fromDate+"','yyyy-mm-dd') and to_date('"+toDate+"','yyyy-mm-dd')";		 
		if(branch_name.equals("所有")&&user_name.equals("所有")&&type.equals("所有")&&state.equals("所有")){
			//1111
			sql = sql;
		}else if(!branch_name.equals("所有")&&user_name.equals("所有")&&type.equals("所有")&&state.equals("所有")){
			//0111
			sql = sql+"and branch_name = '"+branch_name+"'";
		}else if(branch_name.equals("所有")&&!user_name.equals("所有")&&type.equals("所有")&&state.equals("所有")){
			//1011
			sql = sql+"and user_name = '"+user_name+"'";
		}else if(branch_name.equals("所有")&&user_name.equals("所有")&&!type.equals("所有")&&state.equals("所有")){
			//1101
			sql = sql+"and buss_type = '"+type+"'";
		}else if(branch_name.equals("所有")&&user_name.equals("所有")&&type.equals("所有")&&!state.equals("所有")){
			//1110
			sql = sql+"and buss_red_account_state = '"+state+"'";
		}else if(branch_name.equals("所有")&&!user_name.equals("所有")&&type.equals("所有")&&state.equals("所有")){
			//0011
			sql = sql+"and branch_name = '"+branch_name+"'and user_name = '"+user_name+"'";
		}else if(branch_name.equals("所有")&&user_name.equals("所有")&&!type.equals("所有")&&state.equals("所有")){
			//0101
			sql = sql+"and branch_name = '"+branch_name+"'and buss_type = "+type+"'";
		}else if(branch_name.equals("所有")&&user_name.equals("所有")&&type.equals("所有")&&!state.equals("所有")){
			//0110
			sql = sql+"and branch_name = '"+branch_name+"'and buss_red_account_state = '"+state+"'";
		}else if(branch_name.equals("所有")&&!user_name.equals("所有")&&!type.equals("所有")&&state.equals("所有")){
			//1001
			sql = sql+"and user_name = '"+user_name+"'and buss_type = '"+type+"'";
		}else if(branch_name.equals("所有")&&!user_name.equals("所有")&&type.equals("所有")&&!state.equals("所有")){
			//1010
			sql = sql+"and user_name = '"+user_name+"'and buss_red_account_state = '"+state+"'";
		}else if(branch_name.equals("所有")&&user_name.equals("所有")&&!type.equals("所有")&&!state.equals("所有")){
			//1100
			sql = sql+"and buss_type = '"+type+"'and buss_red_account_state = '"+state+"'";
		}else if(!branch_name.equals("所有")&&!user_name.equals("所有")&&!type.equals("所有")&&state.equals("所有")){
			//0001
			sql = sql+"and branch_name = '"+branch_name+"'and user_name = '"+user_name+"'and buss_type = '"+type+"'";
		}else if(!branch_name.equals("所有")&&!user_name.equals("所有")&&type.equals("所有")&&!state.equals("所有")){
			//0010
			sql = sql+"and branch_name = '"+branch_name+"'and user_name = '"+user_name+"'and buss_red_account_state = '"+state+"'";
		}else if(!branch_name.equals("所有")&&user_name.equals("所有")&&!type.equals("所有")&&!state.equals("所有")){
			//0100
			sql = sql+"and branch_name = '"+branch_name+"'and buss_type = '"+type+"'and buss_red_account_state = '"+state+"'";
		}else if(branch_name.equals("所有")&&!user_name.equals("所有")&&!type.equals("所有")&&!state.equals("所有")){
			//1000
			sql = sql+"and user_name = '"+user_name+"'and buss_type = '"+type+"'and buss_red_account_state = '"+state+"'";
		}else{
			//0000
			sql = sql+"and branch_name = '"+branch_name+"'and user_name = '"+user_name+"'and buss_type = '"+type+"'and buss_red_account_state = '"+state+"'";
		}
//		System.out.println(sql);
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int branchId = rs.getInt("branch_id");
				String branchName = rs.getString("branch_name");
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String bussTime = rs.getString("buss_red_date");
				String bussType = rs.getString("buss_type");
				int price = rs.getInt("buss_red_price");
				String bussState = rs.getString("buss_red_account_state");
				BusinessRecord record = new BusinessRecord();
				record.setBranch_id(branchId);
				record.setBranch_name(branchName);
				record.setUser_id(userId);
				record.setUser_name(userName);
				record.setBuss_red_date(bussTime);
				record.setBuss_type(bussType);
				record.setBuss_red_price(price);
				record.setBuss_red_account_state(bussState);
				list.add(record);
				
				
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
