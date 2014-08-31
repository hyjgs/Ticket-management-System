package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.server.dao.ProvinceDao;
import com.tolo.tabcs.util.ConnectUtils;

public  class ProvinceDaoImpl implements ProvinceDao{

	@Override
	public List getProvince() {
		List list = new ArrayList();
		String sql = "select province_name from province_cl";
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String provinceName = rs.getString("province_name");
				list.add(provinceName);
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
