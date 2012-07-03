/*******************************************************************************
 * �ļ�����SessionTimeoutFilter.java
 * 
 * Copyright 2007 HD Co.[www.huadi.com.cn]
 * 
 * ���ߣ�Huadi
 * 
 * �������ڣ�2007-09-11
 * 
 * ˵������Ҫ�����ΪSessionTimeoutFilter
 ******************************************************************************/
package cn.com.hd.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * ����Ϊsession���������ж���û��session����û�е�½ϵͳ
 * 
 * @author Huadi
 * 
 * @version 1.0 2007-09-11
 */
public class SessionTimeoutFilter implements Filter {

	/**
	 * ��������
	 */
	private FilterConfig filterConfig;

	/**
	 * �������Ƿ���Ч
	 */
	private String enable;

	/**
	 * ����û��session��û�е�½ϵͳʱ����תҳ��url
	 */
	private String redirectURL;

	/**
	 * �����ų��ļ�����"#"�ָ�
	 */
	private String exceptFiles;
	
	/**
	 * ��½���û���Ϣ��session�еı�ʶ����
	 */
	private String userSession;

	/**
	 * ��ʼ������
	 */
	public SessionTimeoutFilter() {
		filterConfig = null;
		enable = null;
		redirectURL = null;
		exceptFiles = null;
		userSession = null;
	}

	/**
	 * �����û��session����û�е�½ϵͳ����������true������false
	 * 
	 * @param request ҳ������
	 * 
	 * @return �Ƿ�����
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
	 * ������ֹʱ��������Դ
	 */
	public void destroy() {
		filterConfig = null;
		enable = null;
		exceptFiles = null;
		userSession = null;
	}

	/**
	 * ��ʼ���й���
	 * 
	 * @param request ҳ������request
	 * @param response ҳ����Ӧresponse
	 * @param filterChain ������
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
	 * ���ó�ʼ������
	 * 
	 * @param filterConfig ��������
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