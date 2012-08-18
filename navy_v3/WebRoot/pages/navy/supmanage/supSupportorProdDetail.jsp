<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	List resList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (resList != null && resList.size() > 0) {
		dto = (DTO) resList.get(0);
	}
	
	String supid = request.getParameter("supid");
	String prodid = request.getParameter("prodid");
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
			<input id="str_prodid" name="str_prodid" type="hidden" value="<%= prodid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">&nbsp;当前位置：供应商信息管理&gt;&gt;&gt;&gt;<span>产品详细信息</span>
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
								<th width="40%">
									物资品名
								</th>
								<td>
									<%= dto.showString("GOODNAME", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									产品名称
								</th>
								<td>
									<%= dto.showString("PRODNAME", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									计量单位
								</th>
								<td>
									<%= dto.showString("MEASURUNIT", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									产品系列或型号
								</th>
								<td>
									<%= dto.showString("PRODNO", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									2008-2010年平均年产量
								</th>
								<td>
									<%= dto.showNumber("AVGOUTPUT", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									2008-2010年最大年产量
								</th>
								<td>
									<%= dto.showNumber("MAXOUTPUT", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									单批最大产量
								</th>
								<td>
									<%= dto.showNumber("SINGLEMAXOUTPUT", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									完成单批最大产量所用时间(天)
								</th>
								<td>
									<%= dto.showString("SINGLEMAXDATE", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									备注
								</th>
								<td>
									<textarea name="STR_REMARK" id="STR_REMARK" rows="5" cols="6" readonly><%= dto.showString("REMARK") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
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
				document.getElementById("str_prodid").value = "<%= prodid %>";
				submit_form('Navy', 'NavyManage', 'SupSupportorProdQueryByIdService', '/pages/navy/supmanage/supSupportorProdDetail.jsp?supid=<%= supid %>&prodid=<%= prodid %>');
			}
		</script>
	</body>
</html>