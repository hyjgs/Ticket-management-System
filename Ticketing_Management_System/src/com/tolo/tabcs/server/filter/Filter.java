package com.tolo.tabcs.server.filter;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

/**
 * 抽象的过滤器接口
 *
 */
public interface Filter {
	/**
	 * 对请求过滤的方法。
	 * @param req
	 * @param res
	 */
	public Response doFilter(Request req,Response res);

}
