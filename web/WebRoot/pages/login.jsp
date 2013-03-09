<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self" />
		<title>海军战略储备物资信息管理系统</title>
		<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			#content {
				width:1000px;
				height:600px;
				position:absolute;
				top:50%;
				margin-top:-300px;
				left:50%;
				margin-left:-500px;
			}
		</style>
		<script language='javascript'>
			function checkinput() {
				var obj = document.getElementById("STR_LOGINNAME");
				if (obj.value == "") {
					alert("请填写登录名");
					obj.focus();
					return false;
				}
				
				return true;
			}
			
			function login() {
				if (event.keyCode == 13) {
					if (checkinput()) {
						submit_form('HDPriv', 'PrivManage', 'LoginService', '/pages/login.jsp');
					}
				}
			}
		</script>
	</head>
	
	<body background="#f2f3f3">
		<div id="content" align="center">
			<form action="login" method="post">
				<input type="hidden" name="opt" id="opt" />
				<input id="XML_DATA" name="XML_DATA" type="hidden" value="" />
				<div id="login_div">
				<div id="login_top"></div>
				<div id="login_middle">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td width="261" id="login_middle_user">用户名：
				      <input type="text" name="STR_LOGINNAME" id="STR_LOGINNAME" class="login_input" onkeydown="login();" /></td>
				    <td width="109" rowspan="2" align="center"><img src="resources/images/common/login_btn.gif" style="cursor:hand;" width="81" height="78" 
				    	onclick="if (checkinput()) submit_form('HDPriv', 'PrivManage', 'LoginService', '/pages/login.jsp');"/></td>
				  </tr>
				  <tr>
				    <td id="login_middle_password">密&nbsp;&nbsp;码：
				      <input type="password" name="STR_LOGINPASS" id="STR_LOGINPASS" class="login_input" onkeydown="login();" /></td>
				    </tr>
				</table>
				
				</div>
				<div id="login_bottom" style="height:68px"></div>
				<div id="login_copyright">版权信息：海后军需物资油料部 <br/>联系人：熊键 电话：0201-960810</div>
				
				</div>
			</form>
		</div>
		<script language='javascript'>
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				window.location = "pages/blan.html";
			<% 
				}
			%>
		</script>
	</body>
</html>
