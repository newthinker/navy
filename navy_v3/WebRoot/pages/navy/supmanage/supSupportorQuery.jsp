<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	String downloadurl = "";
	if (resp.getDto().get("DOWNLOAD") != null) {
		String download = (String)resp.getDto().get("DOWNLOAD");
		String downloadFilename = (String)resp.getDto().get("DOWNLOAD_FILENAME");
		downloadurl = "download?download=" + download + "&filename=" + downloadFilename;
	}
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
				} else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") == 1){ %>
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
					cellspacing="0" style="table-layout:fixed;">
					<tr>
						<td valign="top" height="31px">
							<div id="site">&nbsp;当前位置：供应商信息查询</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="140px">
							<jsp:include page="supSupportorQueryParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="35px">
							<div id="btu_new">
								<img src="resources/images/common/btn_search.gif" alt="查询" width="62" height="22"
									onclick="submit_form('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp');" />
								<img src="resources/images/common/btn_new.gif" alt="新增" width="62" height="22"
									onclick="window.document.getElementById('str_supid').value='-1';submit_form('Navy', 'NavyManage', 'SupSupportorQueryByIDService', '/pages/navy/supmanage/supSupportorAdd.jsp');" />
								<img src="resources/images/common/btn_export.gif" alt="导出" width="62" height="22"
									onclick="submit_form('Navy', 'NavyManage', 'SupExportService', '/pages/navy/supmanage/supSupportorQuery.jsp');" />
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<div style="overflow-x:scroll; width:100%; height:100%">
							<table border="0" cellpadding="0" cellspacing="0"
								height="100%" width="100%">
								<tr>
									<td valign="top" height="35" width="100%">
										<table border="0" cellpadding="0" cellspacing="0"
											height="100%" width="100%">
											<tr>
												<td>
													<div class="title" style="width:50px">序号</div>
												</td>
												<td>
													<div class="title" style="width:150px">供应商名称</div>
												</td>
												<td>
													<div class="title" style="width:150px">供应商类型</div>
												</td>
												<td>
													<div class="title" style="width:250px">注册地址</div>
												</td>
												<td>
													<div class="title" style="width:200px">经济性质</div>
												</td>
												<td>
													<div class="title" style="width:100px">法定代表人</div>
												</td>
												<td>
													<div class="title" style="width:100px">注册基本金</div>
												</td>
												<td>
													<div class="title" style="width:100px">采购方式</div>
												</td>
												<td>
													<div class="title" style="width:100px">操作</div>
												</td>
												<td>
													<div class="title" style="width:16px">&nbsp;</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td valign="top" height="100%">
										<div style="overflow:auto; width:100%; height:100%">
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
													<td width="50px">
														<%= i + 1 + pages.getRowNumber() * (pages.getPageIndex() - 1) %>
													</td>
													<td width="150px">
														<a href="javascript:window.document.getElementById('str_supid').value='<%= data.getString("SUPID")  %>';submit_form('Navy', 'NavyManage', 'SupSupportorQueryByIDService', '/pages/navy/supmanage/supSupportorInfo.jsp');" class="link_blue_table">
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
													<td width="150px">
														<%= data.getString("TYPE") == null ? "&nbsp;" : data.getString("TYPE") %>
													</td>
													<td width="250px">
														<%= data.getString("ADDRESS") == null ? "&nbsp;" : data.getString("ADDRESS") %>&nbsp;&nbsp;
													</td>
													<td width="200px">
														<%= data.getString("ECONOMY") == null ? "&nbsp;" : data.getString("ECONOMY") %>&nbsp;&nbsp;
													</td>
													<td width="100px">
														<%= data.getString("CORPORATION") == null ? "&nbsp;" : data.getString("CORPORATION") %>&nbsp;&nbsp;
													</td>
													<td width="100px">
														<%= data.getNumber("LICCAPITAL") == null ? "&nbsp;" : data.getNumber("LICCAPITAL") %>&nbsp;&nbsp;
													</td>
													<td width="100px">
														<%= data.getString("PURCHASETYPE") == null ? "&nbsp;" : data.getString("PURCHASETYPE") %>&nbsp;&nbsp;
													</td>
													<td width="100px">
														&nbsp;&nbsp;&nbsp;
														<a class="link_blue" href="javascript:window.document.getElementById('str_supid').value='<%= data.getString("SUPID")  %>';submit_form('Navy', 'NavyManage', 'SupSupportorQueryByIDService', '/pages/navy/supmanage/supSupportorUpdate.jsp');">修改</a>
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
							</div>
						</td>
					</tr>
					<tr>
						<td height="30px">
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
		<iframe id="download" src="<%= downloadurl %>" width="0" height="0" frameborder="0"></iframe>
	</body>
</html>