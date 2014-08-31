package com.tolo.tabcs.server.dao;

import com.tolo.tabcs.common.entity.AppliedRecord;
import com.tolo.tabcs.common.entity.SalesRecord;

 /**
  * 与营业记录表操作有关的
 * 
 * @author hyj
 * 
 */
public interface SalesRecordDao {
	/**
	 * 得到指定日期的所有的营业记录
	 * @param from 日期1
	 * @param to 日期2
	 * @return 查到的营业记录
	 */
	SalesRecord[] getRecord(String from, String to);
/**
 * 得到未结算的营业记录
 * @param user_id 用户编号
 * @return 查到的营业记录
 */
	SalesRecord[] getUncheckedRecord(int user_id);
/**
 * 把未结算的变成未结算的
 * @param buss_red_id 营业记录ID
 * @param user_id 用户编号
 * @return 更改是否成功
 */
	boolean changeUnchecked(int buss_red_id, int user_id);
/**
 * 显示正在申请一级结算的营业记录
 * @param user_id 用户编号
 * @return 查到的营业记录
 */
	SalesRecord[] showWaiting(int user_id);
/**
 * 取消申请一级结算
 * @param buss_red_id 营业记录
 * @param user_id 用户编号
 * @return 取消申请一级结算是否成功
 */
	boolean cancelWaiting(int buss_red_id, int user_id);
/**
 * 供网点经理查询所有营业记录的统计
 * @param branch_id 营业点ID
 * @return 得到的记录
 */
	AppliedRecord[] getApplied(int branch_id);
/**
 * 确认一级结算
 * @param seller_id 营业员ID
 * @return 确认结算是否成功
 */
	boolean toFirstCheck(int seller_id);
}
