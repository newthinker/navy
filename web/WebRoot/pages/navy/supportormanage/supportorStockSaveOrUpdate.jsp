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
	String stockid = request.getParameter("stockid");
	String loc = "修改";
	if (stockid == null) {
		stockid = "";
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
				var obj = document.getElementById("STR_STOCKHOLDERNAME");
				if (!check_input(obj, false, 0, null, null, "出资人名称(或股东姓名)")) {
					return false;
				}
				
				obj = document.getElementById("STR_CAPITAL");
				if (!check_input(obj, false, 1, 0, 99999.99, "出资金额")) {
					return false;
				}
				
				obj = document.getElementById("STR_RATIO");
				if (!check_input(obj, false, 0, null, null, "出资比例")) {
					return false;
				}
				
				obj = document.getElementById("DAT_STOCKDATE");
				if (!check_input(obj, false, 0, null, null, "出资时间")) {
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
			<input id="str_stockholderid" name="str_stockholderid" type="hidden" value="<%= stockid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">&nbsp;当前位置：供应商信息管理&gt;&gt;<span>出资(或股东)信息<%= loc %></span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title" style="width:160px">出资(或股东)信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free" style="width:95%">
							<tr>
								<th>
									出资人名称(或股东姓名)
								</th>
								<td>
									<input type="text" name="STR_STOCKHOLDERNAME" id="STR_STOCKHOLDERNAME"
										class="searchTbl_input" value="<%= dto.showString("STOCKHOLDERNAME") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									出资金额(万元)
								</th>
								<td>
									<input type="text" name="STR_CAPITAL" id="STR_CAPITAL"
										class="searchTbl_input" value="<%= dto.showNumber("CAPITAL") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									出资比例
								</th>
								<td>
									<input type="text" name="STR_RATIO" id="STR_RATIO"
										class="searchTbl_input" value="<%= dto.showString("RATIO") %>" />
		        					<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									出资时间
								</th>
								<td>
									<input name="DAT_STOCKDATE" id="DAT_STOCKDATE" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" readonly="readonly" class="Wdate"
										value="<%= dto.showDate("STOCKDATE") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="save" value="保 存" class="btu_input"
					onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'SupportorStockSaveOrUpdateService', '/pages/navy/supportormanage/supportorStockSaveOrUpdate.jsp?supid=<%= supid %>&stockid=<%= stockid %>');" />
				<input type="button" name="back" id="button" value="关 闭" class="btu_input"
					onclick="window.close();" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				window.dialogArguments.submit_form('Navy', 'NavyManage', 'SupportorStockQueryService', '/pages/navy/supportormanage/supportorStockQuery.jsp?supid=<%= supid %>');
				window.close();
			<% 
				}
			%>
			
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_stockholderid").value = "<%= stockid %>";
				submit_form('Navy', 'NavyManage', 'SupportorStockQueryByIdService', '/pages/navy/supportormanage/supportorStockSaveOrUpdate.jsp?supid=<%= supid %>&stockid=<%= stockid %>');
			}
		</script>
	</body>
</html>