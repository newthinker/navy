<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.InputStream"%>
<%@ include file="../../common/init.jsp" %>
<%
	if (resp.getDto().get("DOWNLOAD") != null) {
		InputStream is = (InputStream)resp.getDto().get("DOWNLOAD");
		response.addHeader("Content-Disposition","attachment;filename=" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xls");

		try {
			byte[] b = new byte[1024];
			int i = 0;
			
			while((i = is.read(b)) > 0) {
				response.getOutputStream().write(b, 0, i);
			}
	        
			response.getOutputStream().flush();
		} catch(Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self">

		<title>字典类型管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta content="MSHTML 6.00.3790.2666" name="GENERATOR">
		
		<title></title>

		<script type="text/javascript">
			<% 
				if (resp != null && resp.getErrorInfo() != null) { %>
					alert("<%= resp.getErrorInfo() %>");
			<% 
				} else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0){ %>
					alert("删除成功！");
			<% 
				}
			%>
		</script>
	</head>
	
	<body style="displan:none">
		<form action="system" method="post">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		</form>
	</body>
</html>
