package com.tolo.tabcs.common.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Response implements Serializable {

	private int type;

	private Map<String, Object> data;

	private static final long serialVersionUID = -251908567123096814L;
	
	public Response(){
		data = new HashMap<String, Object>();
	}

	public Response(int type) {
		this.type = type;
		data = new HashMap<String, Object>();
	}

	public void addData(String name, Object value) {
		data.put(name, value);
	}

	public Object getData(String name) {
		return data.get(name);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type=type;
	}
	public static final int LOGIN_RESPONSE = 1;
	// 登录应答
	public static final int UPDATE_PASSWORD_RESPONSE = 2;
	// 更改密码应答
	public static final int EXIT_RESPONSE = 3;
	// 退出应答

	public static final int ORDER_TICKET_RESPONSE = 4;
	// 购票应答
	public static final int RETURN_TICKET_RESPONSE = 5;
	// 退票应答
	public static final int CHANGE_TICKET_RESPONSE = 6;
	// 改签应答

	public static final int APPLY_FIRST_BALANCE_RESPONSE = 7;
	// 申请一级结算应答
	public static final int CONFIRM_FIRST_BALANCE_RESPONSE = 8;
	// 确认一级结算应答
	public static final int APPLY_SECOND_BALANCE_RESPONSE = 9;
	// 申请二级结算应答
	public static final int CONFIRM_SECOND_BALANCE_RESPONSE = 10;
	// 确认二级结算应答

	public static final int SEARCH_BRANCH_SALES_RECORD_RESPONSE= 1122; //经理查询该网点的
	public static final int APPLIED_AND_UNAPPLIED_RESPONSE = 1120;//查询该网点申请和未申请的记录
	public static final int NEED_SELLER_RESPONSE = 1118;//根据编号查询营业员请求
	public static final int CANCEL_WAITING_SALES_RECORD_RESPONSE = 1116; //撤销要申请结算的请求
	public static final int SEARCH_WAITING_SALES_RECORD_RESPONSE = 1114; //	申请本人等待结算的请求
	public static final int APPLY_UNCHECKED_SALES_RECORD_RESPONSE = 1112;//申请本人营业未结算的请求
	public static final int SEARCH_UNCHECKED_SALES_RECORD_RESPONSE = 1110;//查询本人营业未结算的请求

	public static final int SEARCH_SALES_RECORD_RESPONSE = 11;
	// 查询本人营业记录应答
	public static final int SEARCH_ALL_RECORD_RESPONSE = 12;
	// 查询本网点所有人的营业记录应答
	public static final int SEARCH_ALL_SALES_RECORD_RESPONSE = 13;
	//  查询所有营业记录应答
	public static final int EXPORT_TO_EXCEL_RESPONSE = 14;
	// 导出营业记录到Excel表应答

	public static final int ADD_FLIGHT_RESPONSE = 15;
	// 添加航班应答
	public static final int REMOVE_FLIGHT_RESPONSE = 16;
	// 删除航班应答
	public static final int UPDATE_FLIGHT_RESPONSE = 17;
	// 修改航班应答
	public static final int SEARCH_FLIGHT_RESPONSE = 18;
	// 查询航班应答

	public static final int ADD_FLIGHT_SCHEDULER_RESPONSE = 19;
	// 添加航班计划应答
	public static final int REMOVE_FLIGHT_SCHEDULER_RESPONSE = 20;
	// 删除航班计划应答
	public static final int UPDATE_FLIGHT_SCHEDULER_RESPONSE = 21;
	// 更改航班计划应答
	public static final int SEARCH_FLIGHT_SCHEDULER_RESPONSE = 22;
	// 查询航班计划应答
	public static final int SEARCH_FLIGHT_SCHEDULER_RESPONSE_BYID = 74;
	// 22通过航班号号查询航班计划请求应答

	public static final int SEARCH_SEASON_DISCOUNT_RESPONSE = 23;
	// 查询季节折扣
	public static final int UPDATE_SEASON_DISCOUNT_RESPONSE = 24;
	// 修改季节折扣应答
	public static final int BATCH_UPDATE_SEASON_DISCOUNT_RESPONSE = 25;
	// 批量修改航班季节折扣应答

	public static final int SEARCH_CABIN_DISCOUNT_RESPONSE = 26;
	// 查询舱位折扣
	public static final int UPDATE_CABIN_DISCOUNT_RESPONSE = 27;
	// 修改舱位折扣
	public static final int SEARCH_PASSENGER_DISCOUNT_RESPONSE = 28;
	// 查询乘客折扣
	public static final int UPDATE_PASSENGER_DISCOUNT_RESPONSE = 29;
	// 修改乘客折扣

	public static final int ADD_AIRPLANE_RESPONSE = 30;
	// 添加机型应答
	public static final int REMOVE_AIRPLANE_RESPONSE = 31;
	// 删除机型应答
	public static final int SEARCH_AIRPLANE_RESPONSE = 32;/////////////
	// 查询机型应答
	public static final int SEARCH_AIRPLANE_RESPONSE_BYNONE = 71;/////////////
	// 查询机型应答
	public static final int ADD_AIRPORT_RESPONSE = 33;
	// 添加机场应答
	public static final int REMOVE_AIRPORT_RESPONSE = 34;
	// 删除机场应答
	public static final int SEARCH_AIRPORT_RESPONSE = 35;
	// 查询机场应答

	public static final int ADD_AIRLINE_RESPONSE = 36;
	// 添加航线应答
	public static final int REMOVE_AIRLINE_RESPONSE = 37;
	// 删除航线应答
	public static final int UPDATE_FLIGHT_MILEAGE_RESPONSE = 38;
	// 修改航线里程应答
	public static final int SEARCH_AIRLINE_RESPONSE = 39;
	// 查询航线应答
	public static final int SEARCH_AIRLINE_RESPONSE_BYNONE = 72;
	//查询航线编号应答
	public static final int SEARCH_PLANEID_RESPONSE = 73;////////////////
	//查询飞机id应答

	public static final int ADD_SALES_RESPONSE = 40;
	// 添加营业员应答
	public static final int REMOVE_SALES_RESPONSE = 41;
	// 删除营业员应答
	public static final int UPDATE_SALES_RESPONSE = 42;
	// 修改营业员应答
	public static final int SEARCH_SALES_RESPONSE = 43;
	// 查询用户（各种角色）应答


	public static final int SHOW_ALL_BRANCHES__RESPONSE = 400;
	public static final int ADD_BRANCH_RESPONSE = 44;
	// 添加营业网点应答
	public static final int REMOVE_BRANCH_RESPONSE = 45;
	// 删除营业网点应答
	public static final int UPDATE_BRANCH_RESPONSE = 46;
	// 修改营业网点应答
	public static final int SEARCH_BRANCH_RESPONSE = 47;
	// 查询营业网点应答

	public static final int ADD_USER_RESPONSE = 48;
	// 创建用户应答
	public static final int REMOVE_USER_RESPONSE = 49;
	// 删除用户应答
	public static final int SHIELD_USER_RESPONSE = 50;
	// 屏蔽用户应答
	public static final int RESTART_USER_RESPONSE = 51;
	// 启用用户应答
	public static final int UPDATE_USER_AUT_RESPONSE = 52;
	// 修改用户权限应答
	public static final int RESET_USER_PASSWORD_RESPONSE = 53;
	// 重置用户密码应答
	public static final int UPDATE_USER_ROLE_RESPONSE = 54;
	// 修改用户角色应答
	public static final int SEARCH_USER_RESPONSE = 55;
	// 查询用户应答
	public static final int UPDATE_USER_REQUEST=200;//???????????????????????

	public static final int ADD_ROLE_RESPONSE = 56;
	// 创建角色应答
	public static final int REMOVE_ROLE_RESPONSE = 57;
	// 删除角色应答
	public static final int UPDATE_ROLE_AUT_RESPONSE = 58;
	// 修改角色权限应答
	public static final int SEARCH_ROLE_RESPONSE = 59;
	// 查询角色应答

	public static final int ADD_SYSTEM_ERRLOG_RESPONSE = 60;
	// 增加 系统异常记录应答
	public static final int SEARCH_SYSTEM_ERRLOG_RESPONSE = 61;
	// 查询系统异常应答
	public static final int REMOVE_SYSTEM_ERRLOG_RESPONSE = 62;
	// 删除系统异常应答

	public static final int SYSTEM_LOG_RESPONSE = 63;
	// 系统记录应答
	public static final int SEARCH_SYSTEM_LOG_RESPONSE = 64;
	// 查询系统记录应答
	public static final int REMOVE_SYSTEM_LOG_RESPONSE = 65;
	// 删除系统记录应答

	public static final int FLIGHT_LOG_RESPONSE = 66;
	// 航班日志记录应答
	public static final int SEARCH_FLIGHT_LOG_RESPONSE = 67;
	// 查询航班日志记录应答
	public static final int REMOVE_FLIGHT_LOG_RESPONSE = 68;
	// 删除航班日志记录应答
	public static final int SEARCH_FLIGHT_RESPONSEBYID = 69;
	// 通过航班号查询航班应答
	public static final int SEARCH_FTPLACE_BYROUTEID_RESPONSE = 70;
	//通过航线号查找出发目的地应答
	
	public static final int SEARCH_AIRLINE2_RESPONSE=80;
	public static final int  SEARCH_TICKET2_RESPONSE=81;

	public static final int SEARCH_TICKET_RESPONSE = 0;

	public static final int SEARCH_FUEL_CONSTRUCT_RESPONSE = 600;

	public static final int SEARCH_FUEL_OIL_RESPONSE = 700;

	public static final int CANCEL_FIRST_BALANCE_RESPONSE = 800;

	public static final int SEARCH_SALESBYSEARCH_RESPONSE = 1000;
	
	public static final int SEARCH_FFPC_RESPONSE=250;//所有折扣和费用应答

	public static final int SEARCH_OIL_CONSTRUCT_RESPONSE = 100000;
	public static final int SEARCH_PROVINCE_NAME_RESPONSE = 529;//查询省份应答
	
	public static final int SEARCH_CITY_NAME_RESPONSE = 630;//查询城市应答
	
	public static final int SEARCH_BRANCH_NAME_RESPONSE = 631;//查询网点应答
	
	public static final int SEARCH_BRANCH_NAME1_RESPONSE = 632;//查询wangdian1请求
	
	public static final int SEARCH_USER_NAME_RESPONSE = 633;//查询用户名字应答
	
	public static final int CONFIRM_SECOND_BALANCE2_RESPONSE = 634;
	
	public static final int SEARCH_RESULT_RESPONSE = 635;

	public static final int SEARCH_USER_RESPONSE1 = 101;

	public static final int SEARCH_USER_RESPONSE2 = 102;

	public static final int SEARCH_USER_RESPONSE3 = 103;
}
