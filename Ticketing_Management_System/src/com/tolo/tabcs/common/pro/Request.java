package com.tolo.tabcs.common.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Request implements Serializable {
	private int type;//区分何种类型的请求
	private Map<String, Object> data;//存放数据
	private static final long serialVersionUID = -371890756421779L;

	public Request(int type) {
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

	public static final int LOGIN_REQUEST = 1;
	// 1登录请求
	public static final int UPDATE_PASSWORD_REQUEST = 2;
	// 2更改密码请求
	public static final int EXIT_REQUEST = 3;
	//3退出请求

	public static final int ORDER_TICKET_REQUEST = 4;
	//4 购票请求
	public static final int RETURN_TICKET_REQUEST = 5;
	// 5退票请求
	public static final int CHANGE_TICKET_REQUEST = 6;
	// 6改签请求

	public static final int APPLY_FIRST_BALANCE_REQUEST = 7;
	// 7申请一级结算请求
	public static final int CONFIRM_FIRST_BALANCE_REQUEST = 8;
	// 8确认一级结算请求
	public static final int APPLY_SECOND_BALANCE_REQUEST = 9;
	//9 申请二级结算请求
	public static final int CONFIRM_SECOND_BALANCE_REQUEST = 10;
	// 10确认二级结算请求
	public static final int SEARCH_BRANCH_SALES_RECORD_REQUEST = 1122; //经理查询该网点的
	public static final int APPLIED_AND_UNAPPLIED_REQUEST = 1120;//查询该网点申请和未申请的记录
	public static final int NEED_SELLER_REQUEST = 1118;//根据编号查询营业员请求
	public static final int CANCEL_WAITING_SALES_RECORD_REQUEST = 1116;//撤销申请的营业结算
	public static final int SEARCH_WAITING_SALES_RECORD_REQUEST = 1114; //	申请本人等待结算的请求
	public static final int APPLY_UNCHECKED_SALES_RECORD_REQUEST = 1112;//申请本人营业未结算的请求
	public static final int SEARCH_UNCHECKED_SALES_RECORD_REQUEST = 1110;//查询本人营业未结算的请求
	public static final int SEARCH_SALES_RECORD_REQUEST = 11;
	// 11查询本人营业记录请求
	public static final int SEARCH_ALL_RECORD_REQUEST = 12;
	// 12查询本网点所有人的营业记录请求
	public static final int SEARCH_ALL_SALES_RECORD_REQUEST = 13;
	//  13查询所有营业记录请求
	public static final int EXPORT_TO_EXCEL_REQUEST = 14;
	// 14导出营业记录到Excel表请求

	public static final int ADD_FLIGHT_REQUEST = 15;
	// 15添加航班请求
	public static final int REMOVE_FLIGHT_REQUEST = 16;
	// 16删除航班请求
	public static final int UPDATE_FLIGHT_REQUEST = 17;//////////
	// 17修改航班请求
	public static final int SEARCH_FLIGHT_REQUEST = 18;////////
	// 18查询航班请求

	public static final int ADD_FLIGHT_SCHEDULER_REQUEST = 19;
	// 19添加航班计划请求
	public static final int REMOVE_FLIGHT_SCHEDULER_REQUEST = 20;
	//20 删除航班计划请求
	public static final int UPDATE_FLIGHT_SCHEDULER_REQUEST = 21;
	//21 更改航班计划请求
	public static final int SEARCH_FLIGHT_SCHEDULER_REQUEST = 22;
	// 22查询航班计划请求
	public static final int SEARCH_FLIGHT_SCHEDULER_REQUEST_BYID = 74;
	// 22通过航班号号查询航班计划请求
	public static final int SEARCH_SEASON_DISCOUNT_REQUEST = 23;
	// 23查询季节折扣
	public static final int UPDATE_SEASON_DISCOUNT_REQUEST = 24;
	//24 修改季节折扣请求
	public static final int BATCH_UPDATE_SEASON_DISCOUNT_REQUEST = 25;
	// 25批量修改航班季节折扣请求

	public static final int SEARCH_CABIN_DISCOUNT_REQUEST = 26;
	// 26查询舱位折扣
	public static final int UPDATE_CABIN_DISCOUNT_REQUEST = 27;
	// 27修改舱位折扣
	public static final int SEARCH_PASSENGER_DISCOUNT_REQUEST = 28;
	// 28查询乘客折扣
	public static final int UPDATE_PASSENGER_DISCOUNT_REQUEST = 29;
	// 29修改乘客折扣

	public static final int ADD_AIRPLANE_REQUEST = 30;
	// 30添加机型请求
	public static final int REMOVE_AIRPLANE_REQUEST = 31;
	// 31删除机型请求
	public static final int SEARCH_AIRPLANE_REQUEST = 32;////////////////
	// 32查询机型请求
	public static final int SEARCH_AIRPLANE_REQUEST_BYNONE = 71;////////////////
	//查询所有机型
	public static final int SEARCH_PLANEID_REQUEST = 73;////////////////
	//查询飞机id
	public static final int ADD_AIRPORT_REQUEST = 33;
	// 33添加机场请求
	public static final int REMOVE_AIRPORT_REQUEST = 34;
	// 34删除机场请求
	public static final int SEARCH_AIRPORT_REQUEST = 35;
	// 35查询机场请求

	public static final int ADD_AIRLINE_REQUEST = 36;
	// 36添加航线请求
	public static final int REMOVE_AIRLINE_REQUEST = 37;
	//37 删除航线请求
	public static final int UPDATE_FLIGHT_MILEAGE_REQUEST = 38;
	// 38修改航线里程请求
	public static final int SEARCH_AIRLINE_REQUEST = 39;
	//39 查询航线请求
	public static final int SEARCH_AIRLINE_REQUEST_BYNONE = 72;
	//查询航线编号
	public static final int ADD_SALES_REQUEST = 40;
	// 40添加营业员请求
	public static final int REMOVE_SALES_REQUEST = 41;
	// 41删除营业员请求
	public static final int UPDATE_SALES_REQUEST = 42;
	// 42修改营业员请求
	public static final int SEARCH_SALES_REQUEST = 43;
	// 查询用户（各种角色）请求

	public static final int SHOW_ALL_BRANCHES_REQUEST = 400;//新增的
	public static final int ADD_BRANCH_REQUEST = 44;
	// 添加营业网点请求
	public static final int REMOVE_BRANCH_REQUEST = 45;
	// 删除营业网点请求
	public static final int UPDATE_BRANCH_REQUEST = 46;
	// 修改营业网点请求
	public static final int SEARCH_BRANCH_REQUEST = 47;
	// 查询营业网点请求

	public static final int ADD_USER_REQUEST = 48;
	// 创建用户请求
	public static final int REMOVE_USER_REQUEST = 49;
	// 删除用户请求
	public static final int SHIELD_USER_REQUEST = 50;
	// 屏蔽用户请求
	public static final int RESTART_USER_REQUEST = 51;
	// 启用用户请求
	public static final int UPDATE_USER_AUT_REQUEST = 52;
	// 修改用户权限请求
	public static final int RESET_USER_PASSWORD_REQUEST = 53;
	// 重置用户密码请求
	public static final int UPDATE_USER_ROLE_REQUEST = 54;
	// 修改用户角色请求
	public static final int SEARCH_USER_REQUEST = 55;
	// 查询用户请求
	public static final int UPDATE_USER_REQUEST=200;//???????????????????????
	//更新用户请求
	public static final int ADD_ROLE_REQUEST = 56;
	// 创建角色请求
	public static final int REMOVE_ROLE_REQUEST = 57;
	// 删除角色请求
	public static final int UPDATE_ROLE_AUT_REQUEST = 58;
	// 修改角色权限请求
	public static final int SEARCH_ROLE_REQUEST = 59;
	// 查询角色请求

	public static final int ADD_SYSTEM_ERRLOG_REQUEST = 60;
	// 增加系统异常记录请求
	public static final int SEARCH_SYSTEM_ERRLOG_REQUEST = 61;
	// 查询系统异常请求
	public static final int REMOVE_SYSTEM_ERRLOG_REQUEST = 62;
	// 删除系统异常请求

	public static final int SYSTEM_LOG_REQUEST = 63;
	// 系统记录请求
	public static final int SEARCH_SYSTEM_LOG_REQUEST = 64;
	// 查询系统记录请求
	public static final int REMOVE_SYSTEM_LOG_REQUEST = 65;
	// 删除系统记录请求

	public static final int FLIGHT_LOG_REQUEST = 66;
	// 航班日志记录请求
	public static final int SEARCH_FLIGHT_LOG_REQUEST = 67;
	// 查询航班日志记录请求
	public static final int REMOVE_FLIGHT_LOG_REQUEST = 68;
	// 删除航班日志记录请求
	public static final int SEARCH_FLIGHT_REQUEST_BYID = 69;
	//通过航班号查询航班
	public static final int SEARCH_FTPLACE_BYROUTEID_REQUEST = 70;
	//通过航线号查找出发目的地
	
	 public static final int SEARCH_AIRLINE2_REQUEST=80;
	 public static final int SEARCH_TICKET2_REQUEST = 81;
	
	
	
	public static final int SEARCH_TICKET_REQUEST = 0;
	public static final int SEARCH_FUEL_CONSTRUCT_REQUEST = 600;
	public static final int SEARCH_FUEL_OIL_REQUEST = 700;
	public static final int CANCEL_FIRST_BALANCE_REQUEST = 800;
	public static final int SEARCH_SALESBYSEARCH_REQUEST = 1000;
	
	public static final int SEARCH_FFPC_REQUEST=250;//查询所有折扣和费用请求  
	public static final int SEARCH_OIL_CONSTRUCT_REQUEST = 100000;
	public static final int SEARCH_PROVINCE_NAME_REQUEST = 529;//查询省份请求
	public static final int SEARCH_CITY_NAME_REQUEST = 630;//查询城市请求
	public static final int SEARCH_BRANCH_NAME_REQUEST = 631;//查询wangdian请求
	public static final int SEARCH_BRANCH_NAME1_REQUEST = 632;//查询wangdian1请求
	public static final int SEARCH_USER_NAME_REQUEST = 633;//查询用户名字请求
	public static final int CONFIRM_SECOND_BALANCE2_REQUEST = 634;
	public static final int SEARCH_RESULT_REQUEST = 635;
	public static final int SEARCH_USER_REQUEST1 = 101;
	public static final int SEARCH_USER_REQUEST2 = 102;
	public static final int SEARCH_USER_REQUEST3 = 103;
}
