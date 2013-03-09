<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ include file="../../common/init.jsp" %>
<%
	List resList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (resList != null && resList.size() > 0) {
		dto = (DTO) resList.get(0);
	}
	
	String supid = request.getParameter("supid");
	String orgid = request.getParameter("orgid");
	String loc = "修改";
	if (orgid == null) {
		orgid = "";
		loc = "新增";
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script language="javascript" src="<%= base %>/resources/javascript/calendar/WdatePicker.js"></script>
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
		<script language="javascript" src="resources/javascript/hdcube.js"></script>

		<script type="text/javascript">
			function checkinput() {
				var obj = document.getElementById("STR_ORGNAME");
				if (!check_input(obj, false, 0, null, null, "机构名称")) {
					return false;
				}
				
				obj = document.getElementById("STR_ORGTYPE");
				if (!check_input(obj, false, 0, null, null, "类别")) {
					return false;
				}
				
				obj = document.getElementById("STR_LOCATION");
				if (!check_input(obj, false, 0, null, null, "所在市县")) {
					return false;
				}
				
				obj = document.getElementById("STR_DIRECTOR");
				if (!check_input(obj, false, 0, null, null, "负责人")) {
					return false;
				}
				
				obj = document.getElementById("STR_PHONE");
				if (!check_input(obj, false, 0, null, null, "联系电话")) {
					return false;
				}
				
				return true;
			}
		</script>
	</head>
	
	<body scroll="no"
		style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<jsp:include page="supportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supid %>">
			<input id="str_orgid" name="str_orgid" type="hidden" value="<%= orgid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">&nbsp;当前位置：供应商信息管理&gt;&gt;<span>售后服务机构信息<%= loc %></span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title" style="width:160px">售后服务机构信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free" style="width:95%">
							<tr>
								<th width="40%">
									机构名称
								</th>
								<td>
									<input type="text" name="STR_ORGNAME" id="STR_ORGNAME"
										class="searchTbl_input" value="<%= dto.showString("ORGNAME") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									类别
								</th>
								<td>
									<input type="text" name="STR_ORGTYPE" id="STR_ORGTYPE"
										class="searchTbl_input" value="<%= dto.showString("ORGTYPE") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									所在市县
								</th>
								<td>
									<input type="text" name="STR_LOCATION" id="STR_LOCATION"
										class="searchTbl_input" value="<%= dto.showString("LOCATION") %>" />
		        					<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									负责人
								</th>
								<td>
									<input type="text" name="STR_DIRECTOR" id="STR_DIRECTOR"
										class="searchTbl_input" value="<%= dto.showString("DIRECTOR") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									联系电话
								</th>
								<td>
									<input type="text" name="STR_PHONE" id="STR_PHONE"
										class="searchTbl_input" value="<%= dto.showString("PHONE") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="save" value="保 存" class="btu_input"
					onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'SupportorSaleOrgSaveOrUpdateService', '/pages/navy/supportormanage/supportorSaleOrgSaveOrUpdate.jsp?supid=<%= supid %>&orgid=<%= orgid %>');" />
				<input type="button" name="back" id="button" value="关 闭" class="btu_input"
					onclick="window.close();" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				window.dialogArguments.submit_form('Navy', 'NavyManage', 'SupportorSaleOrgQueryService', '/pages/navy/supportormanage/supportorSaleOrgQuery.jsp?supid=<%= supid %>');
				window.close();
			<% 
				}
			%>
			
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_orgid").value = "<%= orgid %>";
				submit_form('Navy', 'NavyManage', 'SupportorSaleOrgQueryByIdService', '/pages/navy/supportormanage/supportorSaleOrgSaveOrUpdate.jsp?supid=<%= supid %>&orgid=<%= orgid %>');
			}
		</script>
	</body>
</html>