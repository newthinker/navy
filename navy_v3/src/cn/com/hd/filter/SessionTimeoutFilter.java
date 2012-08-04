/*******************************************************************************
 * 文件名：SessionTimeoutFilter.java
 * 
 * Copyright 2007 HD Co.[www.huadi.com.cn]
 * 
 * 作者：Huadi
 * 
 * 创建日期：2007-09-11
 * 
 * 说明：主要设计类为SessionTimeoutFilter
 ******************************************************************************/
package cn.com.hd.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * 该类为session过滤器，判断有没有session和有没有登陆系统
 * 
 * @author Huadi
 * 
 * @version 1.0 2007-09-11
 */
public class SessionTimeoutFilter implements Filter {

	/**
	 * 过滤配置
	 */
	private FilterConfig filterConfig;

	/**
	 * 过滤器是否有效
	 */
	private String enable;

	/**
	 * 出现没有session或没有登陆系统时，跳转页面url
	 */
	private String redirectURL;

	/**
	 * 过滤排除文件，以"#"分割
	 */
	private String exceptFiles;
	
	/**
	 * 登陆后用户信息在session中的标识常量
	 */
	private String userSession;

	/**
	 * 初始化参数
	 */
	public SessionTimeoutFilter() {
		filterConfig = null;
		enable = null;
		redirectURL = null;
		exceptFiles = null;
		userSession = null;
	}

	/**
	 * 检查有没有session和有没有登陆系统，正常返回true，否则false
	 * 
	 * @param request 页面请求
	 * 
	 * @return 是否正常
	 */
	private boolean checkSession(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		requestURI = requestURI.substring(contextPath.length());
		
		String exceptFileList[] = exceptFiles.split("#");
		for (int i = 0; i < exceptFileList.length; i++) {
			if (requestURI.indexOf(exceptFileList[i]) != -1) {
				return true;
			}
		}
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("The Session is null.......................");
		} else if (session.getAttribute(userSession) == null) {
			System.out.println("The Session isn't null, but user is null.......................");
		}
		
		return session != null && (session.getAttribute(userSession) != null);
	}

	/**
	 * 过滤终止时，回收资源
	 */
	public void destroy() {
		filterConfig = null;
		enable = null;
		exceptFiles = null;
		userSession = null;
	}

	/**
	 * 开始进行过滤
	 * 
	 * @param request 页面请求request
	 * @param response 页面响应response
	 * @param filterChain 过滤链
	 * 
	 * @exception IOExcepion, ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		if (enable.equalsIgnoreCase("false")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (checkSession(httpRequest)) {
			filterChain.doFilter(request, response);
		} else {
			httpResponse.getWriter().println("<script language='javascript'>window.top.location = '" + redirectURL + "';</script>");
		}
	}

	/**
	 * 设置初始化参数
	 * 
	 * @param filterConfig 过滤配置
	 * 
	 * @exception ServletException
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		enable = this.filterConfig.getInitParameter("enable");
		if (enable == null) {
			enable = "true";
		}
		
		redirectURL = this.filterConfig.getInitParameter("redirectURL");
		if (redirectURL == null) {
			redirectURL = "/";
		}
		
		exceptFiles = this.filterConfig.getInitParameter("exceptFiles");
		if (exceptFiles == null) {
			exceptFiles = "";
		}
		
		userSession = this.filterConfig.getInitParameter("userSession");
		if (userSession == null) {
			userSession = "USER_ID";
		}
	}
}