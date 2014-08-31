package com.tolo.tabcs.server.service;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.action.AddAirportAction;
import com.tolo.tabcs.server.action.AddBranchAction;
import com.tolo.tabcs.server.action.AddFlightAction;
import com.tolo.tabcs.server.action.AddFlightSchAction;
import com.tolo.tabcs.server.action.AddLineAction;
import com.tolo.tabcs.server.action.AppliedOrUnappliedAction;
import com.tolo.tabcs.server.action.ApplyUncheckedAction;
import com.tolo.tabcs.server.action.Batch_UpdateDiscountAction;
import com.tolo.tabcs.server.action.CancelWaitingAction;
import com.tolo.tabcs.server.action.CertifNumTicketInfoAction;
import com.tolo.tabcs.server.action.ChangeTicketAction;
import com.tolo.tabcs.server.action.ConfirmFirstAction;
import com.tolo.tabcs.server.action.IdTicketInfoAction;
import com.tolo.tabcs.server.action.OrderTicketAction;
import com.tolo.tabcs.server.action.RemoveAirlineAction;
import com.tolo.tabcs.server.action.RemoveBranchAction;
import com.tolo.tabcs.server.action.RemoveFlightAction;
import com.tolo.tabcs.server.action.RemoveFlightPlanAction;
import com.tolo.tabcs.server.action.ReturnTicketAction;
import com.tolo.tabcs.server.action.SearchAirlineByNoneAction;
import com.tolo.tabcs.server.action.SearchBranchAction;
import com.tolo.tabcs.server.action.SearchBranchName1Action;
import com.tolo.tabcs.server.action.SearchCityAction;
import com.tolo.tabcs.server.action.SearchFTPlaceByRouteId;
import com.tolo.tabcs.server.action.SearchFlightByidAction;
import com.tolo.tabcs.server.action.SearchFlightPlanAction;
import com.tolo.tabcs.server.action.SearchFlightPlanByidAction;
import com.tolo.tabcs.server.action.SearchLineAction;
import com.tolo.tabcs.server.action.SearchOilfuelAction;
import com.tolo.tabcs.server.action.SearchPlaneIDByModelAction;
import com.tolo.tabcs.server.action.SearchPlaneModelAction;
import com.tolo.tabcs.server.action.SearchProvinceAction;
import com.tolo.tabcs.server.action.SearchResultAction;
import com.tolo.tabcs.server.action.SearchSalesRecordAction;
import com.tolo.tabcs.server.action.SearchSecondBalanceAction;
import com.tolo.tabcs.server.action.SearchSellerAction;
import com.tolo.tabcs.server.action.SearchUncheckedSalesRecordAction;
import com.tolo.tabcs.server.action.SearchUserNameAction;
import com.tolo.tabcs.server.action.SearchairPlaneModelByNoneAction;
import com.tolo.tabcs.server.action.SearchconfuelAction;
import com.tolo.tabcs.server.action.ServerAddRoleAction;
import com.tolo.tabcs.server.action.ServerDelRoleAction;
import com.tolo.tabcs.server.action.ServerLoginAction;
import com.tolo.tabcs.server.action.ServerRemoveUserAction;
import com.tolo.tabcs.server.action.ServerRoleAction;
import com.tolo.tabcs.server.action.ServerSearchFlightAction;
import com.tolo.tabcs.server.action.ServerUpdateRoleAction;
import com.tolo.tabcs.server.action.ServerUserByIDAction;
import com.tolo.tabcs.server.action.ServerUserByNameAction;
import com.tolo.tabcs.server.action.ServerUserByRoleNameAction;
import com.tolo.tabcs.server.action.ShowAllBranchesAction;
import com.tolo.tabcs.server.action.ShowSomeBranchesAction;
import com.tolo.tabcs.server.action.UpdateBranchAction;
import com.tolo.tabcs.server.action.UpdateFlightAction;
import com.tolo.tabcs.server.action.UpdateFlightPlanAction;
import com.tolo.tabcs.server.action.UpdateMileageAction;
import com.tolo.tabcs.server.action.UpdateSeasonDiscountAciton;
import com.tolo.tabcs.server.action.WaitingSalesRecordAction;
import com.tolo.tabcs.server.action.serverCSBRAction;

/**
 * @author TangLiang
 */

public class Controller {// 服务器端控制类
	/**
	 * 该方法用于为各种客户端请求分别指定相应的处理方法。
	 * @param req 从客户端接收过来的请求数据
	 * @return Response 返回给客户端的应答
	 * @author Baonie 2014-08-12 19:12:48
	 */
	public Response execute(Request req) {
		ServerAction action = null;
		Response res = new Response();
		int type = req.getType();
		switch (type) {
		case Request.LOGIN_REQUEST:
//			action = new ServerLoginAction();
//			res.setType(Response.LOGIN_RESPONSE);// 设置回复类型为登陆型的回复
//			action.doActionOne(req, res);
			action = new ServerLoginAction();
//			Filter filter = new LoginAuthFilter();
//			action.addFilter(filter);
			res.setType(Response.LOGIN_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SHOW_ALL_BRANCHES_REQUEST:
			action = new ShowAllBranchesAction();
			res.setType(Response.SHOW_ALL_BRANCHES__RESPONSE);
			action.doAction(req, res);
			break;
		case Request.CANCEL_WAITING_SALES_RECORD_REQUEST:
			action = new CancelWaitingAction();
			res.setType(Response.CANCEL_WAITING_SALES_RECORD_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_WAITING_SALES_RECORD_REQUEST:   
			action = new WaitingSalesRecordAction();
//			System.out.println("is getting search_wationg _sales");
			res.setType(Response.SEARCH_WAITING_SALES_RECORD_RESPONSE);
			action.doAction(req,res);
			break;
		case Request.APPLY_UNCHECKED_SALES_RECORD_REQUEST:
			action = new ApplyUncheckedAction();
			res.setType(Response.APPLY_UNCHECKED_SALES_RECORD_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_UNCHECKED_SALES_RECORD_REQUEST:
			action = new SearchUncheckedSalesRecordAction();
			res.setType(Response.SEARCH_UNCHECKED_SALES_RECORD_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_SALES_RECORD_REQUEST:
			action = new SearchSalesRecordAction();
			res.setType(Response.SEARCH_SALES_RECORD_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.APPLY_FIRST_BALANCE_REQUEST:
			break;
		case Request.SEARCH_FLIGHT_REQUEST:
			action = new ServerSearchFlightAction();
			res.setType(Response.SEARCH_FLIGHT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_FLIGHT_REQUEST_BYID:
			action = new SearchFlightByidAction();
			res.setType(Response.SEARCH_FLIGHT_RESPONSEBYID);
			action.doActionOne(req, res);
			break;	
		case Request.UPDATE_FLIGHT_REQUEST:
			action = new UpdateFlightAction();
			res.setType(Response.UPDATE_FLIGHT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.REMOVE_FLIGHT_REQUEST:
			action = new RemoveFlightAction();
			res.setType(Response.REMOVE_FLIGHT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_AIRPORT_REQUEST:
			break;
		case Request.SEARCH_TICKET_REQUEST:
			action = new IdTicketInfoAction();
			//Filter filter = new LoginAuthFilter();
			//action.addFilter(filter);
			res.setType(Response.SEARCH_TICKET_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_TICKET2_REQUEST:
			action = new CertifNumTicketInfoAction();
			//Filter filter = new LoginAuthFilter();
			//action.addFilter(filter);
			res.setType(Response.SEARCH_TICKET2_RESPONSE);
			action.doActionOne(req, res);	
			break;
		case Request.SEARCH_FUEL_CONSTRUCT_REQUEST:
			action = new SearchconfuelAction();
			res.setType(Response.SEARCH_FUEL_CONSTRUCT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_FUEL_OIL_REQUEST:
			action = new SearchOilfuelAction();
			res.setType(Response.SEARCH_FUEL_OIL_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_PASSENGER_DISCOUNT_REQUEST:
			break;
		case Request.SEARCH_CABIN_DISCOUNT_REQUEST:
			break;
		case Request.ORDER_TICKET_REQUEST:
			action = new OrderTicketAction();
			res.setType(Response.ORDER_TICKET_RESPONSE);
			action.doActionOne(req, res);
			break;	
		case Request.CANCEL_FIRST_BALANCE_REQUEST:
			break;
			
		case Request.CONFIRM_FIRST_BALANCE_REQUEST:
			action = new ConfirmFirstAction();
			res.setType(Response.CONFIRM_FIRST_BALANCE_RESPONSE);
			action.doAction(req, res);			
			break;
			
		case Request.APPLY_SECOND_BALANCE_REQUEST:
			break;
		case Request.RETURN_TICKET_REQUEST:
			action = new ReturnTicketAction();
			//Filter filter = new LoginAuthFilter();
			//action.addFilter(filter);
			res.setType(Response.RETURN_TICKET_RESPONSE);
			action.doActionOne(req, res);	
			break;
		case Request.CHANGE_TICKET_REQUEST:
			action = new ChangeTicketAction();
			//Filter filter = new LoginAuthFilter();
			//action.addFilter(filter);
			res.setType(Response.CHANGE_TICKET_RESPONSE);
			action.doActionOne(req, res);	
			break;
		case Request.EXIT_REQUEST:
			break;
		case Request.SEARCH_BRANCH_REQUEST:
			action = new ShowSomeBranchesAction();
			res.setType(Response.SEARCH_BRANCH_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.ADD_BRANCH_REQUEST:
//			System.out.println("controller");
			action = new AddBranchAction();
			res.setType(Response.ADD_BRANCH_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.REMOVE_BRANCH_REQUEST:
			action = new RemoveBranchAction();
			res.setType(Response.REMOVE_BRANCH_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.UPDATE_BRANCH_REQUEST:
			action = new UpdateBranchAction();
			res.setType(Response.UPDATE_BRANCH_RESPONSE);
			action.doAction(req, res);
			break;
		case	Request.NEED_SELLER_REQUEST:
			action = new SearchSellerAction();
			res.setType(Response.NEED_SELLER_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.APPLIED_AND_UNAPPLIED_REQUEST:
			action = new AppliedOrUnappliedAction();
			res.setType(Response.APPLIED_AND_UNAPPLIED_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_ROLE_REQUEST:
			action = new ServerRoleAction();
			res.setType(Response.SEARCH_ROLE_RESPONSE);// 设置回复类型为查找角色的回复
			action.doActionOne(req, res);
			break;
		case Request.ADD_ROLE_REQUEST:
			action = new ServerAddRoleAction();
			res.setType(Response.ADD_ROLE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.REMOVE_ROLE_REQUEST:
			action = new ServerDelRoleAction();
			res.setType(Response.REMOVE_ROLE_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.UPDATE_ROLE_AUT_REQUEST:
			action = new ServerUpdateRoleAction();
			res.setType(Response.UPDATE_ROLE_AUT_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_USER_REQUEST1:
			action = new ServerUserByIDAction();
			res.setType(Response.SEARCH_USER_RESPONSE1);// 设置回复类型为查找用户的回复
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_USER_REQUEST2:
			action = new ServerUserByNameAction();
			res.setType(Response.SEARCH_USER_RESPONSE2);// 设置回复类型为查找用户的回复
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_USER_REQUEST3:
			action = new ServerUserByRoleNameAction();
			res.setType(Response.SEARCH_USER_RESPONSE3);// 设置回复类型为查找用户的回复
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_SALES_REQUEST:
			break;
		case Request.SEARCH_FLIGHT_SCHEDULER_REQUEST:
			action = new SearchFlightPlanAction();
			res.setType(Response.SEARCH_FLIGHT_SCHEDULER_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_FLIGHT_SCHEDULER_REQUEST_BYID:
			action = new SearchFlightPlanByidAction();
			res.setType(Response.SEARCH_FLIGHT_SCHEDULER_RESPONSE_BYID);
			action.doActionOne(req, res);
			break;
		case Request.REMOVE_FLIGHT_SCHEDULER_REQUEST:
				action = new RemoveFlightPlanAction();
				res.setType(Response.REMOVE_FLIGHT_SCHEDULER_RESPONSE);
				action.doActionOne(req, res);
			break;
		case Request.ADD_FLIGHT_REQUEST:
			action = new AddFlightAction();
			res.setType(Response.ADD_FLIGHT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.ADD_FLIGHT_SCHEDULER_REQUEST:
			action = new AddFlightSchAction();
			res.setType(Response.ADD_FLIGHT_SCHEDULER_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_AIRLINE_REQUEST:
			action = new SearchLineAction();
			//Filter filter = new LoginAuthFilter();
		//	action.addFilter(filter);
			res.setType(Response.SEARCH_AIRLINE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.ADD_AIRLINE_REQUEST:
			action = new AddLineAction();
			//Filter filter = new LoginAuthFilter();
		//	action.addFilter(filter);
			res.setType(Response.ADD_AIRLINE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_AIRLINE2_REQUEST:
			action = new SearchLineAction();
			//Filter filter = new LoginAuthFilter();
		//	action.addFilter(filter);
			res.setType(Response.SEARCH_AIRLINE2_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.ADD_AIRPORT_REQUEST:
			action = new AddAirportAction();
			//Filter filter = new LoginAuthFilter();
		//	action.addFilter(filter);
			res.setType(Response.ADD_AIRPLANE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.UPDATE_FLIGHT_MILEAGE_REQUEST:
			action = new UpdateMileageAction();
			//Filter filter = new LoginAuthFilter();
		//	action.addFilter(filter);
			res.setType(Response.UPDATE_FLIGHT_MILEAGE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.REMOVE_AIRLINE_REQUEST:
			action = new RemoveAirlineAction();
			//Filter filter = new LoginAuthFilter();
		//	action.addFilter(filter);
			res.setType(Response.REMOVE_AIRLINE_RESPONSE);
			action.doActionOne(req, res);
			break;
			//-------------------------------------------------
		case Request.ADD_USER_REQUEST:
			break;
		case Request.REMOVE_USER_REQUEST:
			action = new ServerRemoveUserAction();
			res.setType(Response.REMOVE_USER_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.UPDATE_USER_REQUEST:
			break;
		case Request.RESET_USER_PASSWORD_REQUEST:
			break;
		case Request.UPDATE_FLIGHT_SCHEDULER_REQUEST:
			action = new UpdateFlightPlanAction();
			res.setType(Response.UPDATE_FLIGHT_SCHEDULER_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_AIRPLANE_REQUEST:
			action = new SearchPlaneModelAction();
			res.setType(Response.SEARCH_AIRLINE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_AIRPLANE_REQUEST_BYNONE://查询所有机型
			action = new SearchairPlaneModelByNoneAction();
			res.setType(Response.SEARCH_AIRPLANE_RESPONSE_BYNONE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_AIRLINE_REQUEST_BYNONE:
			action = new SearchAirlineByNoneAction();
			res.setType(Response.SEARCH_AIRLINE_RESPONSE_BYNONE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_PLANEID_REQUEST:
			action = new SearchPlaneIDByModelAction();
			res.setType(Response.SEARCH_PLANEID_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.CONFIRM_SECOND_BALANCE_REQUEST:
			System.out.println("-----进到Controll");
			action = new serverCSBRAction();
			res.setType(Response.CONFIRM_SECOND_BALANCE_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_SALESBYSEARCH_REQUEST:
			break;
		case Request.SEARCH_FFPC_REQUEST:
			break;
		case Request.SEARCH_OIL_CONSTRUCT_REQUEST:
			break;
		case Request.SEARCH_FTPLACE_BYROUTEID_REQUEST:
			action = new SearchFTPlaceByRouteId();
			res.setType(Response.SEARCH_FTPLACE_BYROUTEID_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_PROVINCE_NAME_REQUEST:
			action = new SearchProvinceAction();
			res.setType(Response.SEARCH_PROVINCE_NAME_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_CITY_NAME_REQUEST:
			action = new SearchCityAction();
			res.setType(Response.SEARCH_CITY_NAME_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_BRANCH_NAME_REQUEST:
			action = new SearchBranchAction();
			res.setType(Response.SEARCH_BRANCH_NAME_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_BRANCH_NAME1_REQUEST:
			action = new SearchBranchName1Action();
			res.setType(Response.SEARCH_BRANCH_NAME1_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.SEARCH_USER_NAME_REQUEST:
			action = new SearchUserNameAction();
			res.setType(Response.SEARCH_USER_NAME_RESPONSE);
			action.doAction(req, res);
			break;
		case Request.UPDATE_SEASON_DISCOUNT_REQUEST:
			action = new UpdateSeasonDiscountAciton();
			res.setType(Response.UPDATE_SEASON_DISCOUNT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.BATCH_UPDATE_SEASON_DISCOUNT_REQUEST:
			action = new Batch_UpdateDiscountAction();
			res.setType(Response.BATCH_UPDATE_SEASON_DISCOUNT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.SEARCH_RESULT_REQUEST:
			action = new SearchResultAction();
			res.setType(Response.SEARCH_RESULT_RESPONSE);
			action.doActionOne(req, res);
			break;
		case Request.CONFIRM_SECOND_BALANCE2_REQUEST:
			action = new SearchSecondBalanceAction();
			res.setType(Response.CONFIRM_SECOND_BALANCE2_RESPONSE);
			action.doAction(req, res);
			break;
		}
		//SEARCH_FTPLACE_BYROUTEID_REQUEST
		return res;
	}
}
