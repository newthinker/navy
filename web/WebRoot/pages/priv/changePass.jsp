<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../common/init.jsp" %>
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
				var pass = document.getElementById("STR_QUERY_LOGINPASS").value;
				if (pass == "") {
					alert("请输入密码！");
					
					document.getElementById("STR_QUERY_LOGINPASS").value = "";
					document.getElementById("STR_LOGINPASS").value = "";
					document.getElementById("confirm").value = "";
					
					return false;
				}
				
				var newpass = document.getElementById("STR_LOGINPASS").value;
				if (newpass == "") {
					alert("请输入新密码！");
					
					document.getElementById("STR_QUERY_LOGINPASS").value = "";
					document.getElementById("STR_LOGINPASS").value = "";
					document.getElementById("confirm").value = "";
					
					return false;
				}
				
				var conf = document.getElementById("confirm").value;
				if (newpass != conf) {
					alert("2次输入的密码不一致，请重新输入！");
					
					document.getElementById("STR_QUERY_LOGINPASS").value = "";
					document.getElementById("STR_LOGINPASS").value = "";
					document.getElementById("confirm").value = "";
					
					return false;
				}
				
				return confirm("确定要修改密码吗？");
			}
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">
				当前位置：
				<a href="#">修改密码</a>
			</div>
			<div class="fen_div">
				<div class="fen_div_title"
					style="position: absolute; z-index: 2; left: 26px; top: 37px;">
					修改密码
				</div>
				<table width="0%" border="0" cellpadding="0" cellspacing="0"
					class="tbl_search2_free">
					<tr>
						<th width="30%" align="right">
							密码
						</th>
						<td>
							<input id="STR_QUERY_LOGINPASS" name="STR_QUERY_LOGINPASS" type="password" />
						</td>
					</tr>
					<tr>
						<th width="30%" align="right">
							新密码
						</th>
						<td>
							<input id="STR_LOGINPASS" name="STR_LOGINPASS" type="password" />
						</td>
					</tr>
					<tr>
						<th width="30%" align="right">
							密码确认
						</th>
						<td>
							<input id="confirm" name="confirm" type="password" />
						</td>
					</tr>
				</table>
			</div>
			<div class="btu">
				<input type="button" name="save" value="修 改" class="btu_input"
					onclick="if (checkInput()) submit_form('HDPriv', 'PrivManage', 'ChangePasswordService', '/pages/priv/changePass.jsp');" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("密码修改成功，系统正在注销，请重新登录！");
				window.top.location = "pages/logout.jsp";
			<% 
				}
			%>
		</script>
	</body>
</html>