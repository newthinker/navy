<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.com.hd.transfer.LoginInfo"%>
<%@ include file="common/init.jsp" %>

<%
	LoginInfo logininfo = new LoginInfo(request);
	
	String username = logininfo.getUsername() == null ? "" : logininfo.getUsername();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%= base %>" target="_self">
		<title>海军物资管理系统</title>
		<link href="resources/css/index.css" rel="stylesheet" type="text/css">
	</head>
	
	<body style="background-color:#1f9bcc;">
		<div id="index_top">
			<ul>
				<li id="index_topleft"></li>
				<li id="index_topright">
					<span id="linkweb" class="index_date"></span>
					<script language="javascript" src="resources/javascript/date.js"></script>
					<span>欢迎您：<%= username %>&nbsp;&nbsp;<a target="ifrm" href="pages/priv/changePass.jsp">修改密码</a>&nbsp;&nbsp;<a href="pages/welcome.htm" target="ifrm">系统首页</a>&nbsp;&nbsp;<a href="pages/logout.jsp" target="_parent">退出系统</a>&nbsp;&nbsp;<a href="help/help.html" target="_blank">帮助</a></span>
				</li>
			</ul>
		</div>
	</body>

</html>
