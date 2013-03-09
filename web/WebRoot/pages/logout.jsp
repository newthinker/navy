<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = "http" + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	Enumeration enmus = session.getAttributeNames();
	while (enmus.hasMoreElements()) {
		Object obj = enmus.nextElement();
		try {
			String name = (String)obj;
			session.removeAttribute(name);
		} catch (Exception ex) {
			continue;
		}
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<base target="_top">
		<title></title>

		<script language="JavaScript">
	    	window.top.document.location = "login.jsp";
	    </script>
	</head>

	<body>
		<br>
		<a href="login.faces">登录</a>
	</body>
</html>
