<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

	DTO dto = null;
	List list = resp.getDto().getList("RESULT");
	if (list.size() > 0) {
		dto = (DTO)list.get(0);
	} else {
		dto = new DTO();
	}
	
	String src = request.getParameter("src");
	String service = "";
	String url = "";
	if (src != null) {
		if (src.equals("import")) {
			service ="ImportQueryService";
			url = "/pages/navy/importmanage/importQuery.jsp";
		} else if (src.equals("supportor")) {
			service ="SupportorQueryService";
			url = "/pages/navy/supportormanage/supportorQuery.jsp";
		}
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta content="MSHTML 6.00.3790.2666" name="GENERATOR">
		
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		</style>
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= dto.getString("SUPID") %>">
			<input id="str_importid" name="str_importid" type="hidden" value="<%= dto.getString("IMPORTID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<center>
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top" height="1">
							<div id="site">
								当前位置：供应商信息管理&gt;&gt;	<span>供应商信息明细</span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="1">
							<div class="searchTbl">
								<table border="0" cellpadding="0" cellspacing="0" width="100%" class="searchTbl">
									<tr>
										<td align="right" width="20%">
											供应商名称:&nbsp;
										</td>
										<td align="left" width="30%">
											<a class="link_blue_table" href="javascript:submit_form('Navy','NavyManage','SupportorQueryByIDService','/pages/navy/supportormanage/supportorInfoIndex.jsp?src=<%= src %>');"><%= dto.getString("SUPNAME") == null ? "" : dto.getString("SUPNAME") %></a>
										</td>
										<td align="right" width="20%">
											英文名称:&nbsp;
										</td>
										<td align="left" width="30%">
											<%= dto.getString("SUPENNAME") == null ? "" : dto.getString("SUPENNAME") %>
										</td>
									</tr>
									<tr>
										<td align="right">
											公司简称:&nbsp;
										</td>
										<td align="left">
											<%= dto.getString("ABBREVIATION") == null ? "" : dto.getString("ABBREVIATION") %>
										</td>
										<td align="right">
											成立时间:&nbsp;
										</td>
										<td align="left">
											<%= dto.getDate("CREATEDATE") == null ? "" : fmtDate.format(dto.getDate("CREATEDATE")) %>
										</td>
									</tr>
									<tr>	
										<td align="right">
											注册地址:&nbsp;
										</td>
										<td align="left">
											<%= dto.getString("ADDRESS") == null ? "" : dto.getString("ADDRESS") %>
										</td>
										<td align="right">
											邮编:&nbsp;
										</td>
										<td align="left">
											<%= dto.getString("POSTCODE") == null ? "" : dto.getString("POSTCODE") %>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25" align="right">
							<input type="button" name="back" id="button" value="返 回" class="btu_input"
								onclick="submit_form('Navy', 'NavyManage', '<%= service %>', '<%= url %>');" />&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td valign="top">
							<iframe id="result" src="pages/navy/importmanage/importResultBySupportor.jsp?supid=<%= dto.getString("SUPID") %>" 
								width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>
						</td>
					</tr>
					<tr>
						<td height="30">
							<div class="linepage1">
								第<%= pages.getPageIndex() %>页/共<%= pages.getPageCount() %>页 共<%= pages.getRowsCount() %>条记录
								<a href="javascript:result.firstpage('Navy','NavyManage','SupportorDetailService','/pages/navy/importmanage/importResultBySupportor.jsp?supid=<%= dto.getString("SUPID") %>')">首页</a>
								<a href="javascript:result.prevpage('Navy','NavyManage','SupportorDetailService','/pages/navy/importmanage/importResultBySupportor.jsp?supid=<%= dto.getString("SUPID") %>')">上一页</a>
								<a href="javascript:result.nextpage('Navy','NavyManage','SupportorDetailService','/pages/navy/importmanage/importResultBySupportor.jsp?supid=<%= dto.getString("SUPID") %>')">下一页</a>
								<a href="javascript:result.lastpage('Navy','NavyManage','SupportorDetailService','/pages/navy/importmanage/importResultBySupportor.jsp?supid=<%= dto.getString("SUPID") %>')">末页</a>
								转到 
								<select id="page" name="page" 
									onchange="result.gopage(this.value, 'Navy','NavyManage','SupportorDetailService','/pages/navy/importmanage/importResultBySupportor.jsp?supid=<%= dto.getString("SUPID") %>')">
									<% 
										for (int i = 0; i < ((pages.getPageCount() == null) ? 0 : pages.getPageCount()); i ++) { 
									%>
									<option value="<%= i + 1 %>"><%= i + 1 %></</option>
									<% 
										} 
									%>
								</select>
								&nbsp;&nbsp;&nbsp;
							</div>
						</td>
					</tr>
				</table>
			</center>
		</form>
	</body>
</html>