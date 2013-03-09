<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="../../common/init.jsp" %>

<%
	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
	}
	
	String typecode = dto.getString("TYPECODE");
	String src = request.getParameter("src");
	String supid = request.getParameter("supid");
	String url = "";
	if (typecode != null) {
		if (typecode.equals("110000000")) {
			url = "/pages/navy/importmanage/importDataDetailsNation.jsp?src=" + src + "&supid=" + supid;
		} else if (typecode.equals("120000000")) {
			url = "/pages/navy/importmanage/importDataDetails.jsp?src=" + src + "&supid=" + supid;
		} else if (typecode.equals("130000000")) {
			url = "/pages/navy/importmanage/importDataDetails.jsp?src=" + src + "&supid=" + supid;
		} else if (typecode.equals("160000000")) {
			url = "/pages/navy/importmanage/importDataDetails.jsp?src=" + src + "&supid=" + supid;
		} else {
			url = "/pages/navy/importmanage/importDataDetails.jsp?src=" + src + "&supid=" + supid;
		}
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
			<jsp:include page="importDataQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_importid" name="str_importid" type="hidden" value="<%= dto.getString("IMPORTID") == null ? "" : dto.getString("IMPORTID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		</form>
	</body>
	<script type="text/javascript">
		submit_form('Navy', 'NavyManage', 'ImportQueryByIDService', '<%= url %>');
	</script>
</html>
