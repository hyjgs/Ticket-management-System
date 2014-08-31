package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tolo.tabcs.common.entity.AppliedRecord;
import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.util.CollectionUtils;
/**
 * 与营业记录表操作有关的
* 
* @author hyj
* 
*/
public class SalesRecordDaoImp implements SalesRecordDao {

	@Override
	/**
	 * 得到指定日期的所有的营业记录
	 * @param from 日期1
	 * @param to 日期2
	 * @return 查到的营业记录
	 */
	public SalesRecord[] getRecord(String from, String to) {
		SalesRecord[] records = new SalesRecord[1];
		int count = getRowCount(from, to);
		String sql2 = "select * from business_record_cl where buss_red_date between to_date('"
				+ from
				+ "','yyyy-mm-dd')"
				+ " and to_date('"
				+ to
				+ "','yyyy-mm-dd')";
		//
		// System.out.println(sql2);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt2 = null;
		ResultSet rs2 = null;
		try {
			// System.out.println("sum is"+count);
			records = new SalesRecord[count];
			stmt2 = conn.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			for (int i = 0; i < count; i++) {
				if (rs2.next()) {
					// System.out.println("the current i is "+ i);
					records[i] = new SalesRecord();
					records[i].setBranch_id(rs2.getInt("branch_id"));
					records[i].setBuss_red_date(rs2.getString("buss_red_date"));
					records[i].setBuss_red_id(rs2.getInt("buss_red_id"));
					records[i].setBuss_red_price(rs2.getInt("buss_red_price"));
					records[i].setBuss_type(rs2.getString("buss_type"));
					records[i].setUser_id(rs2.getInt("user_id"));
					records[i]
							.setState(rs2.getString("buss_red_account_state"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs2);
			CollectionUtils.close(stmt2);
			CollectionUtils.close(conn);
		}
		return records;
	}

	public int getRowCount(String from, String to) {
		int rowCount = 0;
		String sql1 = "select count(*) sum from business_record_cl where buss_red_date between to_date('"
				+ from
				+ "','yyyy-mm-dd')"
				+ " and to_date('"
				+ to
				+ "','yyyy-mm-dd')";
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				rowCount = rs.getInt("sum");
			}
		} catch (SQLException e) {
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
	 * 得到未结算的营业记录
	 * @param user_id 用户编号
	 * @return 查到的营业记录
	 */
	public SalesRecord[] getUncheckedRecord(int user_id) {
		SalesRecord[] records = new SalesRecord[1];
		int count = 1;
		String sql2 = "select * from business_record_cl where user_id = "
				+ user_id + " and buss_red_account_state ='未结算'";
		String sql1 = "select count(*) sum from business_record_cl where user_id = "
				+ user_id + " and buss_red_account_state ='未结算'";
		Connection conn = CollectionUtils.getConnection();
		Statement stmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			records = new SalesRecord[count];
			stmt2 = conn.createStatement();
			rs1 = stmt2.executeQuery(sql1);
			if (rs1.next()) {
				count = rs1.getInt("sum");
			}
			System.out.println("sum is " + count);
			records = new SalesRecord[count];
			rs2 = stmt2.executeQuery(sql2);
			for (int i = 0; i < count; i++) {
				System.out.println("it is " + i);
				if (rs2.next()) {
					records[i] = new SalesRecord();
					records[i].setBranch_id(rs2.getInt("branch_id"));
					records[i].setBuss_red_date(rs2.getString("buss_red_date"));
					records[i].setBuss_red_id(rs2.getInt("buss_red_id"));
					records[i].setBuss_red_price(rs2.getInt("buss_red_price"));
					records[i].setBuss_type(rs2.getString("buss_type"));
					records[i].setUser_id(rs2.getInt("user_id"));
					records[i]
							.setState(rs2.getString("buss_red_account_state"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs2);
			CollectionUtils.close(rs1);
			CollectionUtils.close(stmt2);
			CollectionUtils.close(conn);
		}
		return records;
	}

	@Override
	/**
	 * 把未结算的变成未结算的
	 * @param buss_red_id 营业记录ID
	 * @param user_id 用户编号
	 * @return 更改是否成功
	 */
	public boolean changeUnchecked(int buss_red_id, int user_id) {
		boolean flag = false;
		String sql = "update business_record_cl set buss_red_account_state = '申请一级结算'  where user_id = "
				+ user_id + " and buss_red_id = " + buss_red_id;
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if (n >= 1) {
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

	@Override
	public SalesRecord[] showWaiting(int user_id) {
		SalesRecord[] records = new SalesRecord[1];
		int count = 1;
		String sql2 = "select * from business_record_cl where user_id = "
				+ user_id + " and buss_red_account_state ='申请一级结算'";
		String sql1 = "select count(*) sum from business_record_cl where user_id = "
				+ user_id + " and buss_red_account_state ='申请一级结算'";
		Connection conn = CollectionUtils.getConnection();
		Statement stmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			records = new SalesRecord[count];
			stmt2 = conn.createStatement();
			rs1 = stmt2.executeQuery(sql1);
			if (rs1.next()) {
				count = rs1.getInt("sum");
			}
			System.out.println("sum is " + count);
			records = new SalesRecord[count];
			rs2 = stmt2.executeQuery(sql2);
			for (int i = 0; i < count; i++) {
				System.out.println("it is " + i);
				if (rs2.next()) {
					records[i] = new SalesRecord();
					records[i].setBranch_id(rs2.getInt("branch_id"));
					records[i].setBuss_red_date(rs2.getString("buss_red_date"));
					records[i].setBuss_red_id(rs2.getInt("buss_red_id"));
					records[i].setBuss_red_price(rs2.getInt("buss_red_price"));
					records[i].setBuss_type(rs2.getString("buss_type"));
					records[i].setUser_id(rs2.getInt("user_id"));
					records[i]
							.setState(rs2.getString("buss_red_account_state"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs2);
			CollectionUtils.close(rs1);
			CollectionUtils.close(stmt2);
			CollectionUtils.close(conn);
		}
		return records;
	}

	@Override
	/**
	 * 取消申请一级结算
	 * @param buss_red_id 营业记录
	 * @param user_id 用户编号
	 * @return 取消申请一级结算是否成功
	 */
	public boolean cancelWaiting(int buss_red_id, int user_id) {
		boolean flag = false;
		String sql = "update business_record_cl set buss_red_account_state = '未结算'  where user_id = "
				+ user_id + " and buss_red_id = " + buss_red_id;
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;// 如果把stmt放入try中，则finally中就看不见stmt
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);// *****
			if (n >= 1) {
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

	@Override
	/**
	 * 供网点经理查询所有营业记录的统计
	 * @param branch_id 营业点ID
	 * @return 得到的记录
	 */
	public AppliedRecord[] getApplied(int branch_id) {
		AppliedRecord[] records = new AppliedRecord[1];
		int count = 1;
		String sql1 = "select user_id,count(*) count1,sum(buss_red_price) sum1 from business_record_cl "
				+ " where buss_red_account_state like '申请一级结算'  and branch_id = "
				+ branch_id + " group by user_id";
		String sql2 = "select user_id,count(*) count0,sum(buss_red_price) sum0 from business_record_cl "
				+ " where buss_red_account_state like '未结算'  and branch_id = "
				+ branch_id + " group by user_id";
		// 测试SQL语句
		// System.out.println(sql1);
		// System.out.println(sql2);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sql1);
			for (int i = 0; i < count; i++) {
				records[i] = new AppliedRecord();
				if (rs1.next()) {
					records[i].setSeller_id(rs1.getInt("user_id"));

					records[i].setApplied_count(rs1.getString("count1"));
					records[i].setApplied_sum(rs1.getString("sum1"));
					System.out.println("the user is " + rs1.getInt("user_id"));
				}
			}
			rs2 = stmt.executeQuery(sql2);
			for (int i = 0; i < count; i++) {
				System.out.println("it is " + i);
				if (rs2.next()) {
					records[i].setUnapplied_count(rs2.getString("count0"));
					records[i].setUnapplied_sum(rs2.getString("sum0"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CollectionUtils.close(rs2);
			CollectionUtils.close(rs1);
			CollectionUtils.close(stmt);
			CollectionUtils.close(conn);
		}
		System.out.println("the records is ");
		System.out.println(records[0].getSeller_id() + " bishi "
				+ records[0].getApplied_count());
		return records;
	}

	@Override
	/**
	 * 确认一级结算
	 * @param seller_id 营业员ID
	 * @return 确认结算是否成功
	 */
	public boolean toFirstCheck(int seller_id) {
		boolean flag = false;
		String sql = "update business_record_cl set buss_red_account_state = '一级已结算'   where user_id = "
				+ seller_id + " and buss_red_account_state = '申请一级结算'";
		System.out.println(sql);
		Connection conn = CollectionUtils.getConnection();
		Statement stmt = null;// 如果把stmt放入try中，则finally中就看不见stmt
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);// *****
			if (n >= 1) {
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
