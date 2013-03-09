<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="../pages/common/init.jsp" %>

<%!
	private void createTree(DTO dto, StringBuffer sStrBuff, String var) {
		List list = dto.getList("TREE");
		if (list == null) {
			return;
		}
		
		for (int i = 0; i < list.size(); i ++) {
			DTO subdto = (DTO)list.get(i);
			String subvar = var + "item" + i;
			String title = subdto.getString("FUNCTIONNAME");
			String url = subdto.getString("FUNCTIONURL");
			if (url == null) {
				url = "";
			}
			
			sStrBuff.append("var " + subvar + " = new treeItem('" + title + "', '" + url + "', 'ifrm');\n");
			sStrBuff.append(var + ".add(" + subvar + ");\n");
			createTree(subdto, sStrBuff, subvar);
		}
	}
%>

<%
	StringBuffer sStrBuff = new StringBuffer();
	createTree(resp.getDto(), sStrBuff, "root");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self">
		<title></title>
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		
		<script language='javascript' src='resources/javascript/xtree.js'></script>
	</head>
	
	<body style="background-color: transparent;"
		onload="init('HDPriv','PrivManage','FuncTreeService','/pages/functionTree.jsp');" >
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		</form>
		<table width="120" border="0" cellspacing="0" align="left" cellpadding="0" style="margin-top:10px; font-size:12px; color:#000;">
		  <tr>
		    <td align="left" class="tree_tes"><div id="functionmap"></div></td>
		  </tr>
		</table>
		<script language='javascript'>
			var root = new treeItem("海军战备储备物资信息管理","","main","",icon.root.src);
			<%= sStrBuff.toString() %>
			for (var i = 0; i < root.childNodes.length; i ++) {
				root.childNodes[i].setup(document.getElementById("functionmap"));
			}
		</script>
	</body>
</html>
