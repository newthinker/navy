<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
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
		
		<title></title>
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		</style>
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>

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
		
		<script type="text/javascript">
			function SYNC_Roll(){
				DataGroup2.style.posTop=-DataFrame3.scrollTop
			}
		</script>
	</head>
	
	<body  style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;"
		onload="init('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp');">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		
			<center>
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top" height="1">
							<div id="site">&nbsp;当前位置：供应商信息查询</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="1">
							<jsp:include page="supSupportorQueryParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25">
							<div id="btu_new">
								<img src="resources/images/common/btn_search.gif" alt=" " width="62" height="22"
									onclick="submit_form('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp');" /> 
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<table border="0" cellpadding="0" cellspacing="0"
								height="100%" width="100%">
								<tr>
									<td valign="top" height="35" width="100%">
										<table border="0" cellpadding="0" cellspacing="0"
											height="100%" width="100%">
											<tr>
												<td width="5%">
													<div class="title" style="width:100%">序号</div>
												</td>
												<td width="20%">
													<div class="title" style="width:100%">供应商名称</div>
												</td>
												<td width="15%">
													<div class="title" style="width:100%">供应商类型</div>
												</td>
												<td width="25%">
													<div class="title" style="width:100%">注册地址</div>
												</td>
												<td width="15%">
													<div class="title" style="width:100%">网址</div>
												</td>
												<td width="10%">
													<div class="title" style="width:100%">是否协议供应商</div>
												</td>
												<td>
													<div class="title" style="width:100%">操作</div>
												</td>
												<td width="16">
													<div class="title" style="width:100%">&nbsp;</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td valign="top" height="100%">
										<div
											style="overflow: scroll; overflow-x: hidden; width: 100%; height: 100%">
											<table border="0" cellpadding="0" cellspacing="0"
												width="100%" class="tbl">
												<%
													List typeList = resp.getDto().getList("RESULT");
													if (typeList == null) {
														typeList = new ArrayList();
													}
																						
													for (int i = 0; i < typeList.size(); i ++) {
														DTO data = (DTO)typeList.get(i);
												%>
												<tr>
													<td width="5%">
														<%= i + 1 + pages.getRowNumber() * (pages.getPageIndex() - 1) %>
													</td>
													<td width="20%">
														<a href="javascript:window.document.getElementById('str_supid').value='<%= data.getString("SUPID")  %>';submit_form('Navy', 'NavyManage', 'SupSupportorQueryService', '/pages/navy/supmanage/supSupportorInfo.jsp');" class="link_blue_table">
															<%
																if (data.showString("TYPECODE").equals("A90000000") || 
																	data.showString("TYPECODE").equals("AA0000000") || 
																	data.showString("TYPECODE").equals("AB0000000")) {
																	out.println(data.showString("SUPENNAME"));
																} else {
																	out.println(data.showString("SUPNAME"));
																}
															%>
														</a>
													</td>
													<td width="15%">
														<%= data.getString("TYPE") == null ? "&nbsp;" : data.getString("TYPE") %>
													</td>
													<td width="25%">
														&nbsp;&nbsp;<%= data.getString("ADDRESS") == null ? "&nbsp;" : data.getString("ADDRESS") %>
													</td>
													<td width="15%">
														&nbsp;&nbsp;&nbsp;<a target="_blank" class="link_blue" href="<%= (data.showString("NETADDR").toLowerCase().indexOf("http://") > 0) ? data.showString("NETADDR") : "http://" + data.showString("NETADDR") %>"><%= data.getString("NETADDR") == null ? "" : data.getString("NETADDR") %></a>&nbsp;
													</td>
													<td width="10%">
														&nbsp;&nbsp;&nbsp;<%= data.getString("SUPTYPE") == null ? "&nbsp;" : data.getString("SUPTYPE") %>
													</td>
													<td>
														&nbsp;&nbsp;&nbsp;
														<a class="link_blue" href="javascript:window.document.getElementById('str_supid').value='<%= data.getString("SUPID")  %>';submit_form('Navy', 'NavyManage', 'SupportorQueryByIDService', '/pages/navy/supmanage/supSupportorUpdate.jsp');">修改</a>
														<a class="link_blue" href="javascript:if (confirm('确定要删除记录吗？')) {window.document.getElementById('str_supid').value='<%= data.getString("SUPID")  %>';submit_form('Navy', 'NavyManage', 'SupportorDeleteService', '/pages/navy/supmanage/supSupportorQuery.jsp?opt=refresh');}">删除</a>
													</td>
												</tr>
												<%
													}
												%>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30">
							<div class="linepage1">
								第<%= pages.getPageIndex() %>页/共<%= pages.getPageCount() == null ? 0 : pages.getPageCount() %>页 共<%= pages.getRowsCount() == null ? 0 : pages.getRowsCount() %>条记录
								<a href="javascript:firstpage('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp')">首页</a>
								<a href="javascript:prevpage('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp')">上一页</a>
								<a href="javascript:nextpage('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp')">下一页</a>
								<a href="javascript:lastpage('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp')">末页</a>
								转到 
								<select id="page" name="page" 
									onchange="gopage(this.value, 'Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp')">
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
		<script type="text/javascript">
			setSelect("page", "<%= pages.getPageIndex() %>");

		</script>
		<iframe id="download" src="" width="0" height="0" frameborder="0"></iframe>
	</body>
</html>