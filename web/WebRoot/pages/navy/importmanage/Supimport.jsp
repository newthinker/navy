<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
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
			function checkInput() {
				var value = document.getElementById("upload").value;
				if (value == "") {
					alert("请选择导入文件！");
					return false;
				}
				
				if (value.substring(value.indexOf(".") + 1, value.length).toLowerCase() != "dat") {
					alert("导入文件格式不对，应为“dat”文件！");
					return false;
				}
				
				return true;
			}
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="upload?size=50&url=/pages/navy/importmanage/Supimport.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="opt" id="opt">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">
				当前位置：供应商导入
			</div>
			<div class="fen_div">
				<div class="fen_div_title"
					style="position: absolute; z-index: 2; left: 26px; top: 37px;">
					供应商导入
				</div>
				<table width="0%" border="0" cellpadding="0" cellspacing="0"
					class="tbl_search2_free">
					<tr>
						<th width="30%" align="right">
							选择文件
						</th>
						<td>
							<input id="upload" name="upload" type="file"/>
						</td>
					</tr>
				</table>
			</div>
			<div class="btu">
				<input type="button" name="save" value="导 入" class="btu_input"
					onclick="if (checkInput()) submit_form('Navy', 'NavyManage', 'SupImportService', '/pages/navy/importmanage/Supimport.jsp');" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("导入成功！");
			<% 
				}
			%>
		</script>
	</body>
</html>