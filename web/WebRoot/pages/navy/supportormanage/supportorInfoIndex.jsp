<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="../../common/init.jsp" %>

<%
	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
	}
	
	String src = request.getParameter("src");
	String typecode = dto.getString("TYPECODE");
	String url = "";
	if (typecode != null) {
		if (typecode.equals("A90000000")) {
			url = "/pages/navy/supportormanage/supportorInfoImport.jsp?src=" + src;
		} else if (typecode.equals("AA0000000")) {
			url = "/pages/navy/supportormanage/supportorInfoImport.jsp?src=" + src;
		} else if (typecode.equals("AB0000000")) {
			url = "/pages/navy/supportormanage/supportorInfoImport.jsp?src=" + src;
		} else {
			url = "/pages/navy/supportormanage/supportorInfo.jsp?src=" + src;
		}
	} else {
		url = "/pages/navy/supportormanage/supportorInfo.jsp?src=" + src;
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%= base %>" target="_self">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body>
		<form action="system">
			<jsp:include page="supportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= dto.showString("SUPID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		</form>
	</body>
	<script type="text/javascript">
		submit_form('Navy', 'NavyManage', 'SupportorQueryByIDService', '<%= url %>');
	</script>
</html>
