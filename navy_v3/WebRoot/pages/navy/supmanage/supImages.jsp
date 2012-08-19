<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	String downloadurl = "";
	if (resp.getDto().get("DOWNLOAD") != null) {
		String download = (String)resp.getDto().get("DOWNLOAD");
		String downloadFilename = (String)resp.getDto().get("DOWNLOAD_FILENAME");
		downloadurl = "download?download=" + download + "&filename=" + downloadFilename;
	}
	List list = resp.getDto().getList("RESULT");
	if (list == null) {
		list = new ArrayList();
	}
	
	String imageid = request.getParameter("imageid");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self">

		<title>海军战略储备物资信息管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta content="MSHTML 6.00.3790.2666" name="GENERATOR">
		
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		
	</head>
	
	<body  style="background:url(../../../resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<% if (!downloadurl.equals("")) { %>
		<script type="text/javascript">
			window.location = "<%=downloadurl%>";
		</script>
		<% } else { %>
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="str_imageid" name="str_imageid" type="hidden" value="<%= imageid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			<input id="int_rownumber" name="int_rownumber" value="50" type="hidden">
			<input id="int_pageindex" name="int_pageindex" type="hidden">
		
			<center>
				<table border="0" cellpadding="0" cellspacing="0">
					<%
						for (int i = 0; i < list.size(); i ++) {
							DTO dto = (DTO)list.get(i);
					%>
					<tr>
						<td align="center">
							<img src="<%= dto.getString("IMAGEPATH") %>" /> 
						</td>
					</tr>
					<tr>
						<td height="20px">
							&nbsp;
						</td>
					</tr>
					<%
						}
					%>
				<!--	<tr>
						<td>
							<%
								if (pages.getPageIndex() > 1) {
							%>
							<div class="linepage1">
								第<%= pages.getPageIndex() %>页/共<%= pages.getPageCount() == null ? 0 : pages.getPageCount() %>页 共<%= pages.getRowsCount() == null ? 0 : pages.getRowsCount() %>条记录
								<a href="javascript:firstpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importQuery.jsp')">首页</a>
								<a href="javascript:prevpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importQuery.jsp')">上一页</a>
								<a href="javascript:nextpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importQuery.jsp')">下一页</a>
								<a href="javascript:lastpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importQuery.jsp')">末页</a>
								转到 
								<select id="page" name="page" 
									onchange="gopage(this.value, 'Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importQuery.jsp')">
									<% 
										for (int i = 0; i < pages.getPageCount(); i ++) { 
									%>
									<option value="<%= i + 1 %>"><%= i + 1 %></</option>
									<% 
										} 
									%>
								</select>
								&nbsp;&nbsp;&nbsp;
							</div>
							<%
								}
							%>
						</td>
					</tr>  -->
				</table>
				<div align="center">
					<input type="button" name="back" id="button" value="关 闭" class="btu_input"
						onclick="window.close();" />
				</div> 
			</center>
		</form>
		<script type="text/javascript">
			init('Navy', 'NavyManage', 'SupImageQueryService', '/pages/navy/supmanage/supImages.jsp?imageid=<%= imageid%>');
		</script>
		<% } %>
	</body>
</html>