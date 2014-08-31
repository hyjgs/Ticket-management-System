package com.tolo.tabcs.server.daoimp;

import java.sql.*;
import java.util.ArrayList;

import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.server.dao.BranchDao;
import com.tolo.tabcs.util.CollectionUtils;
/**
 *与网点操作有关的接口实现
 * @author hyj
 *
 */
public class BranchDaoImp implements BranchDao {
	@Override
	public boolean getAllBranches() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * 根据各种条件，查询网点
	 * @param branch 要查询的网点
	 * @return 查询到的网点
	 */
	public Branch[] getSomeBranches(Branch branch) {
		Branch[] branches = new Branch[1];
		String sql = null;
		int rowCount = 0;
		if (branch.getBranch_id() != 0) {
			int branch_id = branch.getBranch_id();
			rowCount = getRowCount(branch_id);
			branches = new Branch[rowCount];
			sql = "select * from finished_branch_hyj where branch_id = "
					+ branch_id;
		} else if (branch.getBranch_name() != null) {
			String branch_name = branch.getBranch_name();
			rowCount = getRowCount(branch_name, 3);
			branches = new Branch[rowCount];
			sql = "select * from finished_branch_hyj where branch_name = '"
					+ branch_name + "'";
		} else if (branch.getCity_name() != null) {
			String city_name = branch.getCity_name();
			rowCount = getRowCount(city_name, 2);
			branches = new Branch[rowCount];
			// System.out.println("branches'rows "+branches.length);
			sql = "select * from finished_branch_hyj where city_name = '"
					+ city_name + "'";
		} else if (branch.getProvince_name() != null) {
			String province_name = branch.getProvince_name();
			rowCount = getRowCount(province_name, 1);
			branches = new Branch[rowCount];
			sql = "select * from finished_branch_hyj where province_name = '"
					+ province_name + "'";
		} else {
			return branches;
		}

		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// System.out.println("rowcount ="+rowCount);
			for (int i = 0; i < rowCount; i++) {
				// System.out.println("i= "+i);
				if (rs.next()) {
					// System.out.println("the id is "+branch_id);
					// System.out.println("the length is "+branches.length);
					branches[i] = new Branch();
					branches[i].setBranch_id(rs.getInt("branch_id"));
					branches[i].setBranch_name(rs.getString("branch_name"));
					branches[i].setProvince_name(rs.getString("province_name"));
					branches[i].setCity_name(rs.getString("city_name"));
					branches[i].setBranch_telephone1(rs
							.getString("branch_telephone1"));
					branches[i].setBranch_address(rs
							.getString("branch_address"));
					branches[i].setUser_id(rs.getInt("user_id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
			CollectionUtils.close(rs);
		}

		return branches;
	}

	public int getRowCount(int branch_id) {
		int rowCount = 0;
		String sql = "select count(*) from finished_branch_hyj where branch_id = "
				+ branch_id;
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				rowCount = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
			CollectionUtils.close(rs);
		}
		return rowCount;
	}
/**
 * 通过省份，城市，网点名字找出对应的有多少网点
 * @param name 名字
 * @param i 1:代表输入的是省份名字 ； 2 ： 城市名字 ；3：网点名字 
 * @return 找到的记录的行数
 */
	public int getRowCount(String name, int i) {
		int rowCount = 0;
		String sql = null;
		if (i == 1) {
			sql = "select count(*) from finished_branch_hyj where province_name = '"
					+ name + "'";
		} else if (i == 2) {
			sql = "select count(*) from finished_branch_hyj where city_name = '"
					+ name + "'";
		} else if (i == 3) {
			sql = "select count(*) from finished_branch_hyj where branch_name = '"
					+ name + "'";
		} else {
			return rowCount;
		}
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				rowCount = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
			CollectionUtils.close(rs);
		}
		return rowCount;
	}
	@Override
	/**
	 * 更新网点信息
	 * @param branch 要更新的网点
	 * @return 更新是否成功
	 */
	public boolean updateBranch(Branch branch) {
		boolean flag = false;
		int province_id = getProvincenId(branch.getProvince_name());
		int city_id = getCityId(branch.getCity_name());
		String sql = "update branch_cl set branch_name= '"
				+ branch.getBranch_name() + "',province_id =" + province_id
				+ ",city_id =" + city_id + ",branch_telephone1 = '"
				+ branch.getBranch_telephone1() + "',branch_address = '"
				+ branch.getBranch_address() + "' where  " + "branch_id = "
				+ branch.getBranch_id();
		System.out.println(sql);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;// 如果把stmt放入try中，则finally中就看不见stmt
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);// *****
			if (n == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		flag = flag
				&& changeManager(branch.getUser_id(), branch.getBranch_id());
		return flag;

	}
/**
 * 得到城市ID
 * @param cityName 城市名称
 * @return 城市ID
 */
	private int getCityId(String cityName) {
		int city_id = 0;
		String sql = "select city_id from city_cl where city_name = '"
				+ cityName + "'";
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);// *****
			if (rs.next()) {
				city_id = rs.getInt("city_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return city_id;
	}

/**
 * 得到省份ID	
 * @param provinceName 省份名字
 * @return  省份ID
 */
private int getProvincenId(String provinceName) {
		int province_id = 0;
		String sql = "select province_id from province_cl where province_name = '"
				+ provinceName + "'";
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);// *****
			if (rs.next()) {
				province_id = rs.getInt("province_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return province_id;
	}
	@Override
	/**
	 * 添加新网点
	 * @param branch 要添加的网点信息
	 * @return 添加是否成功
	 */
	public boolean addBranch(Branch branch) {
		boolean flag = false;
		int province_id = getProvincenId(branch.getProvince_name());
		int city_id = getCityId(branch.getCity_name());
		int max_branch_id = 0;
		String sql1 = "select max(branch_id) max from branch_cl";
		String sql = "insert into branch_cl (branch_id,branch_name,province_id,city_id,branch_telephone1,branch_address) values(?,?,?,?,?,?)";
		Connection conn = CollectionUtils.getConnection();
		PreparedStatement stmt = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql1);
			if (rs.next()) {
				max_branch_id = rs.getInt("max");
			}
			// System.out.println(max_branch_id);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, max_branch_id + 1);
			stmt.setString(2, branch.getBranch_name());
			stmt.setInt(3, province_id);
			stmt.setInt(4, city_id);
			stmt.setString(5, branch.getBranch_telephone1());
			stmt.setString(6, branch.getBranch_address());
			int n = stmt.executeUpdate();
			if (n == 1)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(st);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		flag = flag && changeManager(branch.getUser_id(), max_branch_id + 1);
		return flag;
	}
	@Override
	/**
	 * 删除网点
	 * @param branch_id 要删除的网点ID
	 * @return 删除是否成功
	 */
	public boolean removeBranch(int branch_id) {
		boolean flag = false;
		String sql = "delete from branch_cl where branch_id = " + branch_id;
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if (n == 1)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return flag;

	}
/**
 * 改变网点经理
 * @param userId 网点经理的ID
 * @param branchId 网点的ID
 * @return 改变网点经理是否成功
 */
	private boolean changeManager(int userId, int branchId) {
		boolean flag = false;
		String sql = "update user_cl set role_id = 2,branch_id = " + branchId
				+ " where user_id = " + userId;
		System.out.println(sql);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);// *****
			if (n == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		return flag;
	}

}
