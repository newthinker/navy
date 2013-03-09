<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	List resList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (resList != null && resList.size() > 0) {
		dto = (DTO) resList.get(0);
	}
	
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	
	String supid = request.getParameter("supid");
	String prodid = request.getParameter("prodid");
	String loc = "修改";
	if (prodid == null) {
		prodid = "";
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
				var obj = document.getElementById("STR_GOODNAME");
				if (!check_input(obj, false, 0, null, null, "物资品名")) {
					return false;
				}
				
				obj = document.getElementById("STR_PRODNAME");
				if (!check_input(obj, false, 0, null, null, "产品名称")) {
					return false;
				}
				
				obj = document.getElementById("STR_PRODNO");
				if (!check_input(obj, false, 0, null, null, "产品系列或型号")) {
					return false;
				}
				
				obj = document.getElementById("STR_MEASURUNIT");
				if (!check_input(obj, false, 0, null, null, "计量单位")) {
					return false;
				}
				
				obj = document.getElementById("STR_SINGLEMAXDATE");
				if (!check_input(obj, true, 1, null, null, "所用天数")) {
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
			<input id="str_prodid" name="str_prodid" type="hidden" value="<%= prodid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">&nbsp;当前位置：供应商信息管理&gt;&gt;<span>供应商信息新增</span>&gt;&gt;<span>产品信息<%= loc %></span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">产品信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free" style="width:95%">
							<tr>
								<th>
									物资品名
								</th>
								<td>
									<input type="text" name="STR_GOODNAME" id="STR_GOODNAME"
										class="searchTbl_input" value="<%= dto.showString("GOODNAME") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									产品名称
								</th>
								<td>
									<input type="text" name="STR_PRODNAME" id="STR_PRODNAME"
										class="searchTbl_input" value="<%= dto.showString("PRODNAME") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									产品系列或型号
								</th>
								<td>
									<input type="text" name="STR_PRODNO" id="STR_PRODNO"
										class="searchTbl_input" value="<%= dto.showString("PRODNO") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									计量单位
								</th>
								<td>
									<input type="text" name="STR_MEASURUNIT" id="STR_MEASURUNIT"
										class="searchTbl_input" value="<%= dto.showString("MEASURUNIT") %>" />
		        					<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									2008-2010年平均年产量
								</th>
								<td>
									<input type="text" name="STR_AVGOUTPUT" id="STR_AVGOUTPUT"
										class="searchTbl_input" value="<%= dto.showString("AVGOUTPUT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									2008-2010年最大年产量
								</th>
								<td>
									<input type="text" name="STR_MAXOUTPUT" id="STR_MAXOUTPUT"
										class="searchTbl_input" value="<%= dto.showString("MAXOUTPUT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									单批最大产量
								</th>
								<td>
									<input type="text" name="STR_SINGLEMAXOUTPUT" id="STR_SINGLEMAXOUTPUT"
										class="searchTbl_input" value="<%= dto.showString("SINGLEMAXOUTPUT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									完成单批最大产量所用时间(天)
								</th>
								<td>
									<input type="text" name="STR_SINGLEMAXDATE" id="STR_SINGLEMAXDATE"
										class="searchTbl_input" value="<%= dto.showString("SINGLEMAXDATE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									备注
								</th>
								<td>
									<textarea name="STR_REMARK" id="STR_REMARK" rows="5" cols="6"><%= dto.showString("REMARK") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="save" value="保 存" class="btu_input"
					onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'SupportorProdSaveOrUpdateService', '/pages/navy/supportormanage/supportorProdSaveOrUpdate.jsp?supid=<%= supid %>&prodid=<%= prodid %>');" />
				<input type="button" name="back" id="button" value="关 闭" class="btu_input"
					onclick="window.close();" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				window.dialogArguments.submit_form('Navy', 'NavyManage', 'SupportorProdQueryService', '/pages/navy/supportormanage/supportorProdQuery.jsp?supid=<%= supid %>');
				window.close();
			<% 
				}
			%>
			
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_prodid").value = "<%= prodid %>";
				submit_form('Navy', 'NavyManage', 'SupportorProdQueryByIdService', '/pages/navy/supportormanage/supportorProdSaveOrUpdate.jsp?supid=<%= supid %>&prodid=<%= prodid %>');
			}
		</script>
	</body>
</html>