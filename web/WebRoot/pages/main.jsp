<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/init.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<head>
		<base href="<%= base %>" target="_self">
		<link href="resources/css/index.css" rel="stylesheet" type="text/css">
	
		<script language="javascript" src="resources/javascript/leftmenu.js"></script>
	</head>
	<body style="height:100%; background:url(resources/images/common/index_bg.gif) bottom left repeat-x; background-color:#1f9bcc">
		<div id="index_frame">
			<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
			    <tr>
			      <td width="213" align="left" valign="top" style="background:#9BABE9; border-left:1px solid #173a7a;" id="menu"><table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
			        <tr>
			        <td align="left" valign="top"><iframe frameborder="0" width="100%" marginheight="0" height="100%" marginwidth="0" allowTransparency="true" scrolling="yes" src="pages/functionTree.jsp" name="win"  style="background:url(resources/images/common/index_menu_tree_bg.jpg) no-repeat left  bottom; background-color:#FFFFFF"></iframe></td>
			          </tr>
			        </table></td>
			      <td width="8" valign="middle"  background="resources/images/common/arrow-bg.gif"><table background="resources/images/common/arrow-bg.gif" style="cursor:pointer" border="0" cellspacing="0" cellpadding="0" >
			        <tr>
			          <td width="58"><img src="resources/images/common/bar-top.gif" width="10" height="37" style="cursor:pointer" /></td>
			          </tr>
			        <tr>
			          <td background="resources/images/common/arrow-bg.gif" valign="middle" style="cursor:pointer"><img src="resources/images/common/nav_5.gif" width="10" height="80" onClick="showHideMenu(this)"/></td>
			          </tr>
			        <tr>
			          <td valign="bottom" background="resources/images/common/arrow-bg.gif"><img src="resources/images/common/bar-foot.gif" width="10" height="31" /></td>
			          </tr>
			        </table></td>
			      <td align="left" valign="top"><iframe frameborder="0" width="100%" marginheight="0" marginwidth="0" height="100%" scrolling="no" src="pages/welcome.htm"  name="ifrm"  id="ifrm"></iframe></td>
			    </tr>
			</table>
		</div>
	</body>
</html>