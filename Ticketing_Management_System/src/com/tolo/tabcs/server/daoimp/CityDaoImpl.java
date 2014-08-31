package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.server.dao.CityDao;
import com.tolo.tabcs.util.ConnectUtils;

public class CityDaoImpl implements CityDao{

	@Override
	public List getCity(String province) {
		List list = new ArrayList();
		String sql = "select city_name from city_cl where " +
				" province_id = (select province_id from province_cl " +
				" where province_name = '"+ province + "')";
		Connection conn = ConnectUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String cityName = rs.getString("city_name");
				list.add(cityName);
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
