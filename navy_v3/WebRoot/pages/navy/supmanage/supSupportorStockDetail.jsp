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
		
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		</style>
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>
		<script language="javascript" src="resources/javascript/hdcube.js"></script>

		<script type="text/javascript">
		</script>
	</head>
	
	<body scroll="no"
		style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<jsp:include page="supSupportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supid %>">
			<input id="str_stockholderid" name="str_stockholderid" type="hidden" value="<%= stockid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">&nbsp;当前位置：供应商信息管理&gt;&gt;<span>出资(或股东)详细信息<</span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">出资(或股东)信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free" style="width:95%">
							<tr>
								<th width="40%">
									出资人名称(或股东姓名)
								</th>
								<td>
									<%= dto.showString("STOCKHOLDERNAME", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									出资金额(万元)
								</th>
								<td>
									<%= dto.showNumber("CAPITAL", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									出资比例
								</th>
								<td>
									<%= dto.showString("RATIO", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									出资时间
								</th>
								<td>
									<%= dto.showDate("STOCKDATE", "&nbsp;") %>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="back" id="button" value="关 闭" class="btu_input"
					onclick="window.close();" />
			</div>
		</form>
		<script type="text/javascript">
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_stockholderid").value = "<%= stockid %>";
				submit_form('Navy', 'NavyManage', 'SupSupportorStockQueryByIdService', '/pages/navy/supmanage/supSupportorStockDetail.jsp?supid=<%= supid %>&stockid=<%= stockid %>');
			}
		</script>
	</body>
</html>