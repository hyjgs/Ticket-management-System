package com.tolo.tabcs.server.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tolo.tabcs.common.entity.Branch;
/**
 * 与网点操作有关的接口
 * @author hyj
 *
 */
public interface BranchDao {
	/**
	 * 查询现在的所有网点
	 * @return 查询是否成功
	 */
	boolean getAllBranches();
/**
 * 根据各种条件，查询网点
 * @param branch 要查询的网点
 * @return 查询到的网点
 */
	public Branch[] getSomeBranches(Branch branch);
/**
 * 更新网点信息
 * @param branch 要更新的网点
 * @return 更新是否成功
 */
	boolean updateBranch(Branch branch);
/**
 * 添加新网点
 * @param branch 要添加的网点信息
 * @return 添加是否成功
 */
	boolean addBranch(Branch branch);
/**
 * 删除网点
 * @param branch_id 要删除的网点ID
 * @return 删除是否成功
 */
	boolean removeBranch(int branch_id);

}
