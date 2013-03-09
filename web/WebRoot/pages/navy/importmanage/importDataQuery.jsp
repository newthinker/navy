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
				} else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") == 1) { 
			%>
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
	
	<body  style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="str_importid" name="str_importid" type="hidden" value="">
			<input id="str_imagetypeid" name="str_imagetypeid" type="hidden" value="">
			<input id="str_imagetype" name="str_imagetype" type="hidden" value="">
			<input id="str_supid" name="str_supid" type="hidden" value="">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		
			<center>
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top" height="1">
							<div id="site">&nbsp;当前位置：采购项目信息管理</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="1">
							<jsp:include page="importDataQueryParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25">
							<div id="btu_new">
								<img src="resources/images/common/btn_search.gif" alt=" " width="62" height="22"
									onclick="submit_form('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp');" /> 
								<img src="resources/images/common/btn_new.gif" width="62" height="22"
									onclick="window.document.getElementById('str_importid').value='-1';submit_form('Navy', 'NavyManage', 'ImportQueryByIDService', '/pages/navy/importmanage/importDataAddIndex.jsp');" />
								<img src="resources/images/common/btn_export.gif" width="62" height="22"
									onclick="submit_form('Navy', 'NavyManage', 'ExportService', '/pages/navy/importmanage/importDataQuery.jsp');" />
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
												<td width="20%">
													<div class="title" style="width:100%">采购项目名称</div>
												</td>
												<td width="9%">
													<div class="title" style="width:100%">计划类别</div>
												</td>
												<td width="10%">
													<div class="title" style="width:100%">计划年度
												</td>
												<td width="15%">
													<div class="title" style="width:100%">事业部门
												</td>
												<td width="15%">
													<div class="title" style="width:100%">专业类别
												</td>
												<td width="20%">
													<div class="title" style="width:100%">供应商
												</td>
												<td>
													<div class="title" style="width:100%">操作
												</td>
												<td width="15">
													<div class="title" style="width:100%">&nbsp;
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td valign="top" height="100%">
										<div style="overflow:scroll;overflow-x:hidden;width:100%;height:100%">
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
													<td height="30" width="20%">
														<a href="javascript:window.document.getElementById('str_importid').value='<%= data.getString("IMPORTID")  %>';submit_form('Navy', 'NavyManage', 'ImportQueryByIDService', '/pages/navy/importmanage/importDataDetailsIndex.jsp?src=manage');" class="link_blue_table"><%= data.showString("PROJECT") %></a>
													</td>
													<td height="30" width="10%">
														<%= data.showString("TYPENAME", "&nbsp;") %>
													</td>
													<td height="30" width="10%">
														<%= data.showString("IMPORTYEAR", "&nbsp;") %>
													</td>
													<td height="30" width="15%">
														<%= data.showString("DEPT", "&nbsp;") %>
													</td>
													<td height="30" width="15%">
														<%= data.showString("CLASSNAME", "&nbsp;") %>
													</td>
													<td height="30" width="20%">
														<%= data.showString("SUPPORTOR", "&nbsp;") %>
													</td>
													<td height="30" width="10%">
														<a class="link_blue" href="javascript:window.document.getElementById('str_importid').value='<%= data.getString("IMPORTID")  %>';submit_form('Navy', 'NavyManage', 'ImportQueryByIDService', '/pages/navy/importmanage/importDataUpdateIndex.jsp');">修改</a>
														<a class="link_blue" href="javascript:if (confirm('确定要删除记录吗？')) {window.document.getElementById('str_importid').value='<%= data.getString("IMPORTID")  %>';submit_form('Navy', 'NavyManage', 'ImportDeleteService', '/pages/navy/importmanage/importDataQuery.jsp?opt=refresh');}">删除</a>
														
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
								<a href="javascript:firstpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp')">首页</a>
								<a href="javascript:prevpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp')">上一页</a>
								<a href="javascript:nextpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp')">下一页</a>
								<a href="javascript:lastpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp')">末页</a>
								转到 
								<select id="page" name="page" 
									onchange="gopage(this.value, 'Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp')">
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
			
			init('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp');
		</script>
	</body>
</html>
<iframe id="download" src="<%= downloadurl %>" width="0" height="0" frameborder="0"></iframe>