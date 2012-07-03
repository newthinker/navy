<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/init.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self">
		<title></title>
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		
		<script language='javascript' src='resources/javascript/xtree.js'></script>
	</head>
	
	<body style="background-color: transparent;">
		<table width="120" border="0" cellspacing="0" align="left" cellpadding="0" style="margin-top:10px; font-size:12px; color:#000;">
		  <tr>
		    <td align="left" class="tree_tes"><div id="functionmap"></div></td>
		  </tr>
		</table>
		<script language='javascript'>
			var root = new treeItem("字典管理","index_main.htm","ifrm","",icon.root.src);
	
			var item0 = new treeItem("字典分类管理","pages/typemanage/dictTypeQuery.jsp","ifrm");
			var item1 = new treeItem("字典项管理","pages/dictmanage/dictQuery.jsp","ifrm");
	
			root.add(item0);
			root.add(item1);
	
			root.setup(document.getElementById("functionmap"));
		</script>
	</body>
</html>
